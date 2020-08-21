package cn.yetis.pack1;


/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + "==>" + getChineseOrder(i));
        }
        System.out.println(getChineseOrder(99999));

    }

    /**
     * 根据所给数字，获取对应的中文序号
     *
     * @param i 数字，要求的范围：[0, 100000]
     * @return 中文序号
     */
    private static String getChineseOrder(int i) {
        if (i < 0 || i > 99999) {
            throw new IllegalArgumentException("数字超出范围，需在[0, 99999]之内！");
        }
        String str = String.valueOf(i);
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] s2 = {"十", "百", "千", "万"};
        //String[] s2 = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        StringBuilder result = new StringBuilder();
        int n = str.length();
        for (int j = 0; j < n; j++) {
            int num = str.charAt(j) - '0';
            if (j != n - 1 && num != 0) {
                result.append(s1[num]).append(s2[n - 2 - j]);
            } else {
                result.append(s1[num]);
            }
        }
        return wipeOutBeginOne(i, wipeOutEndZero(result.toString()));
    }

    /**
     * 10~19，去除前端的"一"：10==>一十， 13==>一十三，19==>一十九
     *
     * @param i   所给数字
     * @param str 中文序号
     * @return 结果
     */
    private static String wipeOutBeginOne(int i, String str) {
        int length = str.length();
        if (i >= 10 && i <= 19 & str.startsWith("一")) {
            str = str.substring(1, length);
        }
        return str;
    }

    /**
     * 去除末尾"零"（数字0本身转化出的"零"除外）：100==>一百零零，9900==>九千九百零零
     *
     * @param str 中文序号
     * @return 结果
     */
    private static String wipeOutEndZero(String str) {
        int length = str.length();
        if (length > 2 && str.endsWith("零")) {
            str = str.substring(0, length - 1);
            // 针对"900 : 九百零零"这类情况，递归去除末尾"零"。
            str = wipeOutEndZero(str);
        }
        return str;
    }

}
