/**
 * 创建日期 2017-11-1
 */
package com.xx.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 功能说明：
 * @author 邓锦烨 2017-11-1
 *
 */
@Component
public class PropertiesUtil
{
    @Value("${name}")
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
