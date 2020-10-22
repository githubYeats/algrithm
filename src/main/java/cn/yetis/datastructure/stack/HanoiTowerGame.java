package cn.yetis.datastructure.stack;

/**
 * 用Stack及递归解决“汉诺塔问题”
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class HanoiTowerGame {
    public static void main(String[] args) {
        // 盘子个数
        int n = 5;
        int p1 = 1;
        int p2 = 2;
        int p3 = 3;
        hanoi(n, p1, p2, p3);
    }

    /**
     * 递归解决搬盘子的最少次数
     *
     * @param n  盘子总个数
     * @param p1 第1根柱子
     * @param p2 第2根柱子
     * @param p3 第3根柱子
     */
    public static void hanoi(int n, int p1, int p2, int p3) {
        if (1 == n) {
            System.out.println("盘子从" + p1 + "搬到" + p3);
        } else {
            hanoi(n - 1, p1, p3, p2);
            System.out.println("盘子从" + p1 + "搬到" + p3);
            hanoi(n - 1, p2, p1, p3);
        }
    }
}

