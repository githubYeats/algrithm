package cn.yetis.algorithm.sort;

import cn.yetis.algorithm.util.SortUtils;

/**
 * 插入排序
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class InsertSort {

    public static void insertSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    // 大量的交换会消耗时间
                    SortUtils.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 改进版插入排序（减少了数组元素的操作次数）
     */
    public static void insertSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }

    /**
     * 插入排序法：升序
     *
     * @param arr 需要排序的数组
     */
    public static void insertSort3(int[] arr) {
        int temp;
        // 扫描次数，即插入次数：n-1，需要从第2个数开始操作
        for (int i = 1; i < arr.length; i++) {
            // 记住取出的数
            temp = arr[i];
            // 插入的时候，需要比较已排好序的数组中，左右两个数，才能确定插入的位置
            int j = i - 1;
            // 第二个元素小于第一个元素
            while (j >= 0 && temp < arr[j]) {
                // 把之前所有的已存在元素往后推一个位置
                arr[j + 1] = arr[j];
                j--;
            }
            // 最小的元素放到第一个位置
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
//        insertSort1(arr);
//        insertSort2(arr);
        insertSort3(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
