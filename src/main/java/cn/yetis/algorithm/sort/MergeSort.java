package cn.yetis.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class MergeSort {
    private static void sort(int[] arr) {
        __MergeSort(arr, 0, arr.length - 1);
    }

    private static void __MergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        __MergeSort(arr, l, mid);
        __MergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // 将arr[l...mid]和arr[mid+1...r]两部分进行归并

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    // 自底向上归并排序
    private static void sort2(int[] arr) {
        int n = arr.length;
        int[] aux = new int[n];
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }
}
