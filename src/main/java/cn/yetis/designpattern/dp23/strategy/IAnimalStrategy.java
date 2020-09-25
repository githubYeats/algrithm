package cn.yetis.designpattern.dp23.strategy;

/**
 * @author fyyang
 * @since 2020-9-22
 */
public interface IAnimalStrategy {

    /**
     * 用于识别实体类的类型
     */
    int getType();

    /**
     * 业务方法
     */
    String dealBusiness(String name);
}
