package cn.yetis.util;

import java.math.BigDecimal;

/**
 * BigDecimal 工具类
 *
 * @author fyyang
 * @date 2020-4-6
 * @since 1.0.0
 */
public class BigDecimalUtils {

    /**
     * 除法运算默认精度
     */
    private static final int DEFAULT_DIV_SCALE = 3;

    /**
     * 构造器私有化
     */
    private BigDecimalUtils() {
    }

    /**
     * 两个double类型数值比大小。
     *
     * @param v1 值1
     * @param v2 值2
     * @return 等于-1：v1 < v2；等于1：v1 > v2；等于0：v1 = v2
     * @see BigDecimal#compareTo(BigDecimal)
     */
    public static int compare(double v1, double v2) {
        return BigDecimal.valueOf(v1).compareTo(BigDecimal.valueOf(v2));
    }

    /**
     * 判断：num1 == num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1等于num2返回true
     */
    public static boolean equal(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == 0;
    }

    /**
     * 判断：num1 == num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1等于num2返回true
     */
    public static boolean equal(double num1, double num2) {
        return equal(BigDecimal.valueOf(num1), BigDecimal.valueOf(num2));
    }

    /**
     * 判断：num1 < num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1小于num2返回true
     */
    public static boolean lessThan(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == -1;
    }

    /**
     * 判断：num1 < num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1小于num2返回true
     */
    public static boolean lessThan(double num1, double num2) {
        return lessThan(BigDecimal.valueOf(num1), BigDecimal.valueOf(num2));
    }

    /**
     * 判断：num1 > num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1大于num2返回true
     */
    public static boolean greaterThan(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) == 1;
    }

    /**
     * 判断：num1 > num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1大于num2返回true
     */
    public static boolean greaterThan(double num1, double num2) {
        return greaterThan(BigDecimal.valueOf(num1), BigDecimal.valueOf(num2));
    }

    /**
     * 判断：num1 <= num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1小于或者等于num2返回true
     */
    public static boolean lessEqual(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) < 1;
    }

    /**
     * 判断：num1 <= num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1小于或者等于num2返回true
     */
    public static boolean lessEqual(double num1, double num2) {
        return lessEqual(BigDecimal.valueOf(num1), BigDecimal.valueOf(num2));
    }

    /**
     * 判断：num1 >= num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1大于或者等于num2返回true
     */
    public static boolean greaterEqual(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) > -1;
    }

    /**
     * 判断：num1 >= num2
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return num1大于或者等于num2返回true
     */
    public static boolean greaterEqual(double num1, double num2) {
        return greaterEqual(BigDecimal.valueOf(num1), BigDecimal.valueOf(num2));
    }

    /**
     * 判断decimal是否数值区间内：[left, right)
     *
     * @param decimal BigDecimal类型数值
     * @param left    区间左边界值
     * @param right   区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterEqualAndLess(BigDecimal decimal, BigDecimal left, BigDecimal right) {
        return -1 < decimal.compareTo(left) && decimal.compareTo(right) < 0;
    }

    /**
     * 判断d是否数值区间内：[left, right)
     *
     * @param d     数值
     * @param left  区间左边界值
     * @param right 区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterEqualAndLess(double d, double left, double right) {
        return greaterEqualAndLess(BigDecimal.valueOf(d), BigDecimal.valueOf(left), BigDecimal.valueOf(right));
    }

    /**
     * 判断是否数值区间内：[left, right]
     *
     * @param decimal BigDecimal类型数值
     * @param left    区间左边界值
     * @param right   区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterEqualAndLessEqual(BigDecimal decimal, BigDecimal left, BigDecimal right) {
        return -1 < decimal.compareTo(left) && decimal.compareTo(right) < 1;
    }

    /**
     * 判断是否数值区间内：[left, right]
     *
     * @param d     数值
     * @param left  区间左边界值
     * @param right 区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterEqualAndLessEqual(double d, double left, double right) {
        return greaterEqualAndLessEqual(BigDecimal.valueOf(d), BigDecimal.valueOf(left), BigDecimal.valueOf(right));
    }

    /**
     * 判断decimal是否数值区间内：(left, right)
     *
     * @param decimal BigDecimal类型数值
     * @param left    区间左边界值
     * @param right   区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterAndLess(BigDecimal decimal, BigDecimal left, BigDecimal right) {
        return 0 < decimal.compareTo(left) && decimal.compareTo(right) < 0;
    }

    /**
     * 判断double类型数值是否数值区间内：(left, right)
     *
     * @param d     double类型数值
     * @param left  区间左边界值
     * @param right 区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterAndLess(double d, double left, double right) {
        return greaterAndLess(BigDecimal.valueOf(d), BigDecimal.valueOf(left), BigDecimal.valueOf(right));
    }

    /**
     * 判断decimal是否数值区间内：(left, right]
     *
     * @param decimal BigDecimal类型数值
     * @param left    区间左边界值
     * @param right   区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterAndLessEqual(BigDecimal decimal, BigDecimal left, BigDecimal right) {
        return 0 < decimal.compareTo(left) && decimal.compareTo(right) < 1;
    }

    /**
     * 判断double类型数值是否数值区间内：(left, right]
     *
     * @param d     double类型数值
     * @param left  区间左边界值
     * @param right 区间右边界值
     * @return 是否在该区间内
     */
    public static boolean greaterAndLessEqual(double d, double left, double right) {
        return greaterAndLessEqual(BigDecimal.valueOf(d), BigDecimal.valueOf(left), BigDecimal.valueOf(right));
    }

    /**
     * double类型数值格式化：四舍五入，保留几位小数
     *
     * @param d     double类型数值
     * @param point 保留的小数位数
     * @return double 响应值
     */
    public static Double formatDouble(double d, int point) {
        return BigDecimal.valueOf(d).setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * double类型数值格式化：四舍五入，保留几位小数
     *
     * @param d     double类型数值
     * @param point 保留的小数位数
     * @return BigDecimal 响应值
     */
    public static BigDecimal formatDoubleToBigDecimal(double d, int point) {
        return BigDecimal.valueOf(d).setScale(point, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * double类型数值处理：带小数的显示小数；不带小数的显示整数。
     *
     * @param d double类型数值
     * @return 响应值
     */
    public static String doubleTrans(Double d) {
        if (Math.round(d) - d == 0) {
            return String.valueOf((long) d.doubleValue());
        }
        return String.valueOf(d);
    }

    /**
     * double类型精确相加
     *
     * @param v1 值1
     * @param v2 值 2
     * @return 结果
     */
    public static Double add(double v1, double v2) {
        return BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * double类型精确相减
     *
     * @param v1 值1
     * @param v2 值 2
     * @return 结果
     */
    public static Double subtract(double v1, double v2) {
        return BigDecimal.valueOf(v1).subtract(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * double类型精确相乘
     *
     * @param v1 值1
     * @param v2 值 2
     * @return 结果
     */
    public static Double multiply(double v1, double v2) {
        return BigDecimal.valueOf(v1).multiply(BigDecimal.valueOf(v2)).doubleValue();
    }

    /**
     * 精确除法，指定精度
     *
     * @param v1    值1
     * @param v2    值 2
     * @param scale 精度
     * @return 结果
     */
    public static Double divide(double v1, double v2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        return BigDecimal.valueOf(v1)
                .divide(BigDecimal.valueOf(v2), scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 精确除法，指定精度
     *
     * @param v1    值1
     * @param v2    值 2
     * @param scale 精度
     * @return 结果
     */
    public static Double divide(String v1, String v2, int scale) throws IllegalAccessException {
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        return new BigDecimal(v1).divide(new BigDecimal(v2), scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 精确除法：使用默认精度
     */
    public static double divide(double value1, double value2) throws IllegalAccessException {
        return divide(value1, value2, DEFAULT_DIV_SCALE);
    }

    /**
     * 精确除法：使用默认精度
     */
    public static double divide(String value1, String value2) throws IllegalAccessException {
        return divide(value1, value2, DEFAULT_DIV_SCALE);
    }

    /**
     * 精确除法：四舍五入
     *
     * @param scale 小数点后保留几位
     */
    public static double round(double v, int scale) throws IllegalAccessException {
        return divide(v, 1, scale);
    }

    /**
     * 精确除法：四舍五入
     *
     * @param scale 小数点后保留几位
     */
    public static double round(String v, int scale) throws IllegalAccessException {
        return divide(v, "1", scale);
    }
}
