package cn.yetis.pack1;


/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Integer i = null;
        if (i.compareTo(1) >= 0) { // java.lang.NullPointerException
            System.out.println("success");
        } else {
            System.out.println("false");
        }

        Integer i1 = 1;
        if (i1.compareTo(null) >= 0) { // java.lang.NullPointerException
            System.out.println("success");
        } else {
            System.out.println("false");
        }
    }

}
