package cn.yetis.algorithm.sort;

import cn.yetis.algorithm.util.SortUtils;

/**
 * 冒泡排序
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class BubbleSort {
    /**
     * 冒泡排序：升序
     *
     * @param arr 需要排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // 扫描次数：n-1
        for (int i = arr.length - 1; i > 0; i--) {
            // 每轮扫描，交换的次数
            for (int j = 0; j < i; j++) {
                // 升序
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 改进版冒泡排序：升序
     *
     * @param arr 需要排序的数组
     */
    public static void bubbleSort1(int[] arr) {
        // 扫描次数：n-1
        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;
            // 每轮扫描，交换的次数
            for (int j = 0; j < i; j++) {
                // 升序
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                    //执行过交换，则flag不为0
                    swapped = true;
                }
            }
            // 循环没有执行过交换，说明已经排序好，可以结束当前循环。
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
//        bubbleSort(arr);
        bubbleSort1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
