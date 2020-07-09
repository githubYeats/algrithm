package cn.yetis.designpattern.interceptor;


/**
 * @author fyyang
 * @since 2020-7-9
 */
public interface Interceptor {
    MyResponse intercept(TargetInvocation targetInvocation);
}
