package cn.yetis.pack1;


import java.util.Arrays;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        char arr[] = new char[52];
        int i;
        for (i = 0; i < 52; i++) {
            if (i < 26) {
                arr[i] = (char) ('A' + i);
            } else {
                arr[i] = (char) ('a' + (i - 26));
            }
        }

        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

//        for (char c : arr) {
//            for (int j : number) {
//                System.out.println(c + String.valueOf(j));
//            }
//        }

        for (int j : number) {
            for (char c : arr) {
                System.out.println(String.valueOf(j) + c);
            }
        }


    }

}
