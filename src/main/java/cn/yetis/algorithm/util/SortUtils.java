package cn.yetis.algorithm.util;

/**
 * 排序工具类
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class SortUtils {

    private SortUtils() {
    }

    /**
     * 交换数组中的两个数
     *
     * @param arr 数组
     * @param i   索引 i
     * @param j   索引 j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
