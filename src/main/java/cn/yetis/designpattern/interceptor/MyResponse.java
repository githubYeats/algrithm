package cn.yetis.designpattern.interceptor;

import lombok.Data;

/**
 * @author fyyang
 * @since 2020-7-9
 */
@Data
public class MyResponse {

    private String code;

    private Object data;

}
