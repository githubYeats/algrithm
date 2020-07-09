package cn.yetis.designpattern.interceptor;


/**
 * @author fyyang
 * @since 2020-7-9
 */
public class LogInterceptor implements Interceptor {

    @Override
    public MyResponse intercept(TargetInvocation targetInvocation) {
        System.out.println("Logging Begin");
        MyResponse response = targetInvocation.invoke();
        System.out.println("Logging End");
        return response;
    }
}
