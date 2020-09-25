package cn.yetis.pack1.ex01;

/**
 * 吉他类型枚举
 *
 * @author fyyang
 * @since 2020-9-25
 */
public enum TypeEnum {

    /**
     * 类型
     */
    ACOUSTIC,
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
