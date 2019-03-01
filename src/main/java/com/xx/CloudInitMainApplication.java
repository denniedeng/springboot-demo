/**
 * 创建日期 2017-11-1
 */
package com.xx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 功能说明：spring boot入口类
 * 
 * @author 邓锦烨 2017-11-1
 */

@SpringBootApplication  /** 设置此类为spring boot的启动入口 */
@EnableTransactionManagement    /** 开启事务功能 */
@EnableScheduling   /** 开启定时器功能 */
@EnableCaching /** 开启缓存 */
//@EnableEurekaServer /** 开启eureka服务注册中心 */
//@EnableAsync  /** 开启异步调用功能（异步时候的事务一致性待确认） */
public class CloudInitMainApplication
{
    public static void main(String[] args)
    {
    	System.out.println("test commit");
    	System.out.println("test jenkins work?");
//        SpringApplication.run(CloudInitMainApplication.class, args);
    }

}
