package cn.yetis.pack1;


import java.util.HashMap;
import java.util.Map;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        // 空 map
        Map<String, String> emptyMap = new HashMap<>(0);
        String s = emptyMap.get("1");
        System.out.println(s);

        // 空对象
        Employee employee = new Employee();
        String name = employee.getName();
        System.out.println(name);
    }

}
