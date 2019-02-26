/**
 * 创建日期 2017-11-3
 */
package com.xx.task.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 功能说明：定时器task例子
 * 
 * @author 邓锦烨 2017-11-3
 */
@Component
public class TestTasks
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @Scheduled的用法：
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron="x/5 x x x x x") ：通过cron表达式定义规则
     * 
     * @author 邓锦烨 2017-11-3
     */
    @Scheduled(fixedRate = 5000000)
    public void reportCurrentTime()
    {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
