/**
 * 创建日期 2017-11-1
 */
package com.xx.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xx.entity.test.User;
import com.xx.service.SuperException;
import com.xx.service.test.UserService;
import com.xx.util.PropertiesUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 功能说明：
 * 
 * @author 邓锦烨 2017-11-1
 */
@RestController
@RequestMapping("/message")
public class MessageController
{
    // @Value("${name}")
    // private String name;

    @Autowired
    private PropertiesUtil properties;
    
    @Autowired
    private UserService userService;
    
    @ApiOperation(value = "test", notes = "第一个swagger例子")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws Exception
    {
        return "helloworld";
    }
    
    @ApiOperation(value = "helloworld", notes = "第一个swagger例子")
    @RequestMapping(value = "/hello/world", method = RequestMethod.GET)
    public String hello() throws Exception
    {
        return "helloworld";
    }
    
    @ApiOperation(value = "从yml配置文件中获取配置信息", notes = "从yml配置文件中获取配置信息")
    @RequestMapping(value = "/yml", method = RequestMethod.GET)
    public String getYmlInfo() throws Exception
    {
        return properties.getName();
    }
    
    @ApiOperation(value = "获取用户列表", notes = "第一个swagger例子")
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable Long id) throws Exception
    {
    	User u = userService.findByName("AAA");
        return String.valueOf(u.getId());
    }

    @ApiOperation(value = "错误统一处理例子", notes = "错误统一处理")
    @RequestMapping(value = "/hello/error", method = RequestMethod.GET)
    public String dealError() throws Exception
    {
        // throw new SuperException("发生错误2");
        try
        {
            int i = 0;
            i = i / 0;
            return "ok";
        }
        catch (Exception e)
        {
            throw new SuperException(e.getMessage());
        }
    }
    
    @ApiOperation(value = "插入数据库例子<br>开启事务，需要在启动类加注解@EnableTransactionManagement，然后在对应的service类的方法上加注解@Transactional；", notes = "后续提供redis连接例子<br>多数据源例子<br>连接池DRUID例子")
    @RequestMapping(value = "/hello/insert", method = RequestMethod.GET)
    public String insertByMybatis() throws Exception
    {
        try
        {
            int count = userService.insertUser("AAA", 20);
            return String.valueOf(count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new SuperException(e.getMessage());
        }
    }
    
    @ApiOperation(value = "删除指定id的用户例子", notes = "删除指定id的用户例子")
    @RequestMapping(value = "/hello/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable int id) throws Exception
    {
        try
        {
            userService.deleteById(id);
            return "OK";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new SuperException(e.getMessage());
        }
    }
}
