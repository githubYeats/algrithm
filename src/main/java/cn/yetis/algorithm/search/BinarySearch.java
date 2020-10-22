package cn.yetis.algorithm.search;

/**
 * 二分查找
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class BinarySearch {

    /**
     * 二分查找法：它需要给定的数组已经排序好才行
     *
     * @param arr 已排好序的数组
     * @param val 要查找的数据,如果输入-1，表示不查找
     * @return 查找结果
     */
    public static int binarySearch(int[] arr, int val) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            // 二分之名的由来
            mid = (low + high) / 2;
            // 要找的数据在数组左半边,假设排序是升序
            if (val < arr[mid]) {
                high = mid - 1;
                // 要找的数在数组的右半边
            } else if (val > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
