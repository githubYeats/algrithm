package cn.yetis.pack1.ex01;

/**
 * 吉他材质枚举
 *
 * @author fyyang
 * @since 2020-9-25
 */
public enum WoodEnum {

    /**
     * 材质
     */
    INDIAN_ROSEWOOD,
    BRAZILIAN_ROSEWOOD,
    MAPLE;

    @Override
    public String toString() {
        switch (this) {
            case INDIAN_ROSEWOOD:
                return "Indian Rosewood";
            case BRAZILIAN_ROSEWOOD:
                return "Brazilian Rosewood";
            case MAPLE:
                return "Maple";
            default:
                return "Other";
        }
    }
}
