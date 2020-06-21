package cn.yetis.pro;

/**
 * @author fyyang
 * @since 2020-4-27
 */
public class AppleColorPredicate implements ApplePredicate {

    /**
     * 筛选红苹果
     *
     * @param apple 苹果对象
     * @return 是否是红苹果
     */
    @Override
    public boolean chooseApple(Apple apple) {
        return "red".equals(apple.getColour());
    }
}
