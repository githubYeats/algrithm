package cn.yetis.designpattern.dp23.strategy;

/**
 * @author fyyang
 * @since 2020-9-22
 */
public class CatStrategy implements IAnimalStrategy {






    @Override
    public int getType() {
        // 设置1代表猫类
        return 1;
    }

    @Override
    public String dealBusiness(String name) {
        return "猫类的实现类" + name;
    }
}
