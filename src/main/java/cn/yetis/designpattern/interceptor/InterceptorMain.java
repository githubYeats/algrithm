package cn.yetis.designpattern.interceptor;


/**
 * @author fyyang
 * @since 2020-7-9
 */
public class InterceptorMain {
    public static void main(String[] args) {
        TargetInvocation targetInvocation = new TargetInvocation();
        targetInvocation.addInterceptor(new LogInterceptor());
        targetInvocation.addInterceptor(new AuditInterceptor());
        targetInvocation.setRequest(new MyRequest());
        targetInvocation.setTarget(request -> new MyResponse());

        targetInvocation.invoke();
    }
}
