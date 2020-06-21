package cn.yetis.pro;

import cn.yetis.util.BigDecimalUtils;

import java.math.BigDecimal;

/**
 * @author fyyang
 * @since 2020-4-27
 */
public class AppleWeightPredicate implements ApplePredicate {

    @Override
    public boolean chooseApple(Apple apple) {
        return BigDecimalUtils.greaterThan(apple.getWeight(), BigDecimal.valueOf(150));
    }
}
