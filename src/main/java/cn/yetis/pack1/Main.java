package cn.yetis.pack1;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZoneId;
import java.util.*;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        // 注意：一定要使用创建对象的格式创建数组
        Integer[] a = new Integer[]{6, 3, 9, 3, 2, 4, 5, 7};
        Integer[] b = new Integer[]{5, 8, 6, 2, 1, 9};
        List _a = Arrays.asList(a);
        List _b = Arrays.asList(b);
// 创建集合
        Collection realA = new ArrayList<Integer>(_a);
        Collection realB = new ArrayList<Integer>(_b);
// 求交集
        realA.retainAll(realB);
        System.out.println("交集结果：" + realA);
        Set result = new HashSet();
// 求全集
        result.addAll(_a);
        result.addAll(_b);
        System.out.println("全集结果：" + result);
// 求差集：结果
        Collection aa = new ArrayList(realA);
        Collection bb = new ArrayList(result);
        bb.removeAll(aa);
        System.out.println("最终结果：" + bb);


    }

    public static List<String> getFiledName(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }


    /**
     * org.apache.commons.collections4.CollectionUtils
     */
    public static void testCollectionUtils() {
        String[] arrayA = new String[]{"1", "2", "3", "3", "4", "5"};
        String[] arrayB = new String[]{"3", "4", "4", "5", "6", "7"};
        List<String> a = Arrays.asList(arrayA);
        List<String> b = Arrays.asList(arrayB);
        //并集
        Collection<String> union = CollectionUtils.union(a, b);
        //交集
        Collection<String> intersection = CollectionUtils.intersection(a, b);
        //交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(a, b);
        //集合相减
        Collection<String> subtract = CollectionUtils.subtract(a, b);
        Collections.sort((List<String>) union);
        Collections.sort((List<String>) intersection);
        Collections.sort((List<String>) disjunction);
        Collections.sort((List<String>) subtract);
        System.out.println("A: " + ArrayUtils.toString(a.toArray()));
        System.out.println("B: " + ArrayUtils.toString(b.toArray()));
        System.out.println("--------------------------------------------");
        System.out.println("Union(A, B): " + ArrayUtils.toString(union.toArray()));
        System.out.println("Intersection(A, B): " + ArrayUtils.toString(intersection.toArray()));
        System.out.println("Disjunction(A, B): " + ArrayUtils.toString(disjunction.toArray()));
        System.out.println("Subtract(A, B): " + ArrayUtils.toString(subtract.toArray()));

        System.out.println("--------------------------------------------");
        String[] arrayC = new String[]{"1", "2", "3", "3", "3", "3", "4", "4", "4", "5"};
        List<String> c = Arrays.asList(arrayC);
        Collection<String> disjunctionC = CollectionUtils.disjunction(c, new HashSet<String>(c));
        System.out.println("*******): " + ArrayUtils.toString(disjunctionC.toArray()));
    }
}
