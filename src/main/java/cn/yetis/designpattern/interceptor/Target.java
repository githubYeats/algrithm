package cn.yetis.designpattern.interceptor;

/**
 * @author fyyang
 * @since 2020-7-9
 */
public interface Target {
    MyResponse execute(MyRequest request);
}
