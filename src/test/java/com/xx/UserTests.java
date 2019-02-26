/**
 * 创建日期 2017-11-3
 */
package com.xx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xx.entity.test.User;
import com.xx.entity.test.UserMapper;

/**
 * 功能说明：还不能跑起来
 * 
 * @author 邓锦烨 2017-11-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CloudInitMainApplication.class)
public class UserTests
{
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception
    {
        //userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }
}
