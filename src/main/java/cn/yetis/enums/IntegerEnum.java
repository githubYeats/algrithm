package cn.yetis.enums;

/**
 * 数字枚举
 *
 * @author fyyang
 * @since 2020-4-29
 */
public enum IntegerEnum {

    /**
     * 数字枚举、对应数字字符
     */
    NUM_1(1, "1"),
    NUM_2(2, "2"),
    NUM_3(3, "3"),
    NUM_4(4, "4"),
    NUM_5(5, "5"),
    NUM_6(6, "6"),
    NUM_156(156, "156"),
    ;

    private Integer num;
    private String numString;

    IntegerEnum(Integer num, String numString) {
        this.num = num;
        this.numString = numString;
    }

    public Integer getNum() {
        return num;
    }

    public String getNumString() {
        return numString;
    }
}
