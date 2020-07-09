package cn.yetis.designpattern.interceptor;

import lombok.Data;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fyyang
 * @since 2020-7-9
 */
@Data
public class TargetInvocation {
    private List<Interceptor> interceptorList = new ArrayList<>();
    private Iterator<Interceptor> interceptors;
    private Target target;
    private MyRequest request;

    public MyResponse invoke() {
        if (interceptors.hasNext()) {
            Interceptor interceptor = interceptors.next();

            //整个算法的关键，这里会递归调用 invoke()
            interceptor.intercept(this);
        }
        return target.execute(request);
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
        interceptors = interceptorList.iterator();
    }

}
