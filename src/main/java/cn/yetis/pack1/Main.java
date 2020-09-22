package cn.yetis.pack1;


import java.util.ArrayList;
import java.util.List;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Object o = list.stream().findFirst().get();
        System.out.println(o);

    }

}
