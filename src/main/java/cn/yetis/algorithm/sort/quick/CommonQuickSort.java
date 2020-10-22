package cn.yetis.algorithm.sort.quick;

import cn.yetis.algorithm.util.SortUtils;

/**
 * 普通快速排序
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class CommonQuickSort {

    /**
     * 递归使用快速排序,对 arr[l...r] 的范围进行排序
     *
     * @param arr 数组
     * @param l   左侧开始索引
     * @param r   右侧结束索引
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }


    /**
     * 将数组通过p分割成两部分
     * 对arr[l...r]部分进行partition操作
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     */
    private static int partition(int[] arr, int l, int r) {
        // 加入这一行变成随机快速排序
        SortUtils.swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                SortUtils.swap(arr, i, j);
            }
        }
        SortUtils.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
