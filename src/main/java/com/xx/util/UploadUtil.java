package com.xx.util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	@Value("${upload.oneMaxSize}")
    public static int uploadOneMaxSize = 500; //单位KB
    
    @Value("${upload.maxNum}")
    public static int uploadMaxNum = 9;

    @Value("${upload.fileType}")
    public static String fileType = "jpg,jpeg,bmp,png";
    
    public boolean upload(MultipartFile[] fileList) throws IllegalStateException, IOException, Exception {
    	if(fileList==null || fileList.length==0)
    		throw new Exception("Parameter 'file' can't be empty!");
    	
    	if(fileList.length>uploadMaxNum)
    		throw new Exception("上传文件数超过最大值：" +uploadMaxNum+"!");
    	
    	for(MultipartFile file : fileList) {
    		String originalFilaNme = file.getOriginalFilename();
    		long fileSize = file.getSize();
    		if(fileSize>uploadOneMaxSize*1024)
    			throw new Exception("上传文件:"+originalFilaNme+"大小为："+(fileSize/1024)+"KB,超出最大限制：" +uploadOneMaxSize+"KB!");
    		if(!fileType.contains(originalFilaNme.substring(originalFilaNme.lastIndexOf(".")+1).toLowerCase()))
    			throw new Exception("上传文件:"+originalFilaNme+" 为非法文件。允许上传的文件类型：" +fileType+"!");
    	}
    	
    	for(MultipartFile file : fileList) {
        	//1. 接受上传的文件  @RequestParam("file") MultipartFile file
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
    		String originalFilaNme = file.getOriginalFilename();
            String fileName = String.valueOf(System.currentTimeMillis())+originalFilaNme.substring(originalFilaNme.lastIndexOf("."));
            
            //3.图片存放在D盘下
            String destFileName = "D:/"+ "uploaded" + File.separator + fileName;
            
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            
          //5.把浏览器上传的文件复制到希望的位置
        	file.transferTo(destFile);
        }
    	return true;
    }
}
