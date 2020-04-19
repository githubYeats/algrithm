package cn.yetis.pack1;


import java.util.*;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        List<Object> list1 = Arrays.asList(1, new Employee(), "user");
        for (Object o : list1) {
            System.out.println(o);
        }

        List<List<Object>> list2 = Collections.nCopies(1, list1);
        System.out.println(list2);
        List<String> list3 = Collections.nCopies(10, "msg");
        System.out.println(list3);


        Set<Integer> singleton = Collections.singleton(2);
        System.out.println(singleton);

        Properties properties = new Properties();

        System.out.println("-----------------------------");
        BitSet bitSet = new BitSet(1);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.length());
        System.out.println(bitSet.size());




    }
}
