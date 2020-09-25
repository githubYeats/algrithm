package cn.yetis.pack1.ex01;

/**
 * 吉他类型枚举
 *
 * @author fyyang
 * @since 2020-9-25
 */
public enum TypeEnum {

    /**
     * 原声吉他
     */
    ACOUSTIC,

    /**
     * 电吉他
     */
    ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "acoustic";
            case ELECTRIC:
                return "electric";
            default:
                return "";
        }
    }
}
