package cn.yetis.pro;

/**
 * @author fyyang
 * @since 2020-4-27
 */
public interface ApplePredicate {

    /**
     * 选择苹果的策略
     *
     * @param apple 苹果对象
     * @return 是否满足选择条件
     */
    boolean chooseApple(Apple apple);
}
