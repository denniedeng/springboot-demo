package com.xx.controller.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xx.util.UploadUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/upload")
public class UploadController {
	 	@ApiOperation(value = "上传图片例子")
	    @RequestMapping(value = "/photo", method = RequestMethod.POST)
	    public String uploadPhoto(@RequestParam("file") MultipartFile[] fileList) throws Exception
	    {
	        try {
	            UploadUtil uploadUtil = new UploadUtil();
	            uploadUtil.upload(fileList);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            return "上传失败," + e.getMessage();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "上传失败," + e.getMessage();
	        }

	        return "showImg";
	    }
}
