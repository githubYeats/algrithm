package cn.yetis.algorithm.sort;

/**
 * 希尔排序
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class ShellSort {

    /**
     * 希尔排序法：升序
     *
     * @param arr 需要排序的数组
     */
    public static void shellSort1(int[] arr) {
        int i, j;
        int temp;

        int n = arr.length;

        // 设定分隔区的间隔大小
        int jump = n / 2;
        while (jump != 0) {
            // 执行带分隔区的插入排序法
            for (i = jump; i < n; i++) {
                temp = arr[i];
                j = i - jump;
                // 插入排序法
                while (j >= 0 && temp < arr[j]) {
                    arr[j + jump] = arr[j];
                    j = j - jump;
                }
                arr[j + jump] = temp;
            }
            // 逐渐减小分隔区大小，以控制循环次数
            jump = jump / 2;
        }
    }

    public static void shellSort2(int[] arr) {
        int n = arr.length;
        for (int h = n / 2; h > 0; h = h / 2) {
            // 内部是一个插入排序
            for (int i = 0; i < n; i = i + h) {

                int e = arr[i];
                int j = i;
                for (; j > 0; j = j - h) {
                    if (e < arr[j - h]) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = e;
            }
        }
    }

    public static void shellSort3(int[] arr) {
        int n = arr.length;
        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                int e = arr[i];
                int j = i;
                for (; j >= h && e < arr[j - h]; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }

            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5, 0};
//        shellSort1(arr);
//        shellSort2(arr);
        shellSort3(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
