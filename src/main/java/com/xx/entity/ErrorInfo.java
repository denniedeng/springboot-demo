/**
 * 创建日期 2017-11-3
 */
package com.xx.entity;

/**
 * 功能说明：错误返回码统一处理实体
 * 
 * @author 邓锦烨 2017-11-3
 */
public class ErrorInfo<T>
{
    public static final Integer OK = 200;

    public static final Integer ERROR = 300;

    private Integer code;

    private String message;

    private String url;

    private T data;

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
