package cn.yetis.enums;

/**
 * 性别枚举
 *
 * @author fyyang
 * @since 2020-4-30
 */
public enum GenderEnum {

    /**
     * 男
     */
    GENDER_MALE("1", "男"),

    /**
     * 女
     */
    GENDER_FEMALE("2", "女"),

    /**
     * 未知
     */
    GENDER_UNKNOWN("3", "未知");


    /**
     * 性别编码："1" 男；"2" 女；"3" 未知（是数据未知，而非别人真实性别不知道）。
     */
    private String genderCode;

    /**
     * 性别描述：男、女、未知
     */
    private String genderDesc;

    GenderEnum(String genderCode, String genderDesc) {
        this.genderCode = genderCode;
        this.genderDesc = genderDesc;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public String getGenderDesc() {
        return genderDesc;
    }
}
