package cn.yetis.algorithm.sort;

import cn.yetis.algorithm.util.SortUtils;

/**
 * 选择排序法
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class SelectSort {

    /**
     * 选择排序法：升序
     *
     * @param arr 需要排序的数组
     */
    public static void selectSort(int[] arr) {
        int n = arr.length;
        // 扫描次数，即选择次数
        for (int i = 0; i < n - 1; i++) {
            // 比较：从第i+1个数比到最后一个数
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    SortUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
