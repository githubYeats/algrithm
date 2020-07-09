package cn.yetis.designpattern.interceptor;

/**
 * @author fyyang
 * @since 2020-7-9
 */
public class AuditInterceptor implements Interceptor{


    @Override
    public MyResponse intercept(TargetInvocation targetInvocation) {
        if (targetInvocation.getTarget() == null) {
            throw new IllegalArgumentException("Target is null");
        }
        System.out.println("Audit Succeeded ");
        return targetInvocation.invoke();
    }
}
