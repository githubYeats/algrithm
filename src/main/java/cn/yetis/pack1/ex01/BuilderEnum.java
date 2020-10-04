package cn.yetis.pack1.ex01;

/**
 * 吉他制作者枚举
 *
 * @author fyyang
 * @since 2020-9-25
 */
public enum BuilderEnum {

    /**
     * 制作人
     */
    FENDER,
    MARTIN,
    GIBSON;

    @Override
    public String toString() {
        switch (this) {
            case FENDER:
                return "Fender";
            case MARTIN:
                return "Martin";
            case GIBSON:
                return "Gibson";
            default:
                return "unknown";
        }
    }
}
