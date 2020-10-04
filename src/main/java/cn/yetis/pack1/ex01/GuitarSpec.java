package cn.yetis.pack1.ex01;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 吉他规格类
 * <p>
 * 两处共用：1.吉他类；2.客户搜索规格定义。
 * 当吉他需要多出一种特性中，客户要搜索的规格特性也随之增加一个。  这正是共用Spec的妙处。
 * </p>
 *
 * @author fyyang
 * @since 2020-9-25
 */
@Data
public class GuitarSpec {

    /**
     * 型号
     */
    private String model;

    /**
     * 制作者
     */
    BuilderEnum builder;

    /**
     * 类型
     */
    TypeEnum type;

    /**
     * 背面材质
     */
    WoodEnum backWood;

    /**
     * 正面材质
     */
    WoodEnum topWood;

    /**
     * 吉他弦数
     */
    private Long numStrings;

    public GuitarSpec(String model, BuilderEnum builder, TypeEnum type,
                      WoodEnum backWood, WoodEnum topWood, Long numStrings) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {
        if (model.equals(otherSpec.getModel())) {
            return true;
        }
        if (builder == otherSpec.getBuilder()) {
            return true;
        }
        if (type == otherSpec.getType()) {
            return true;
        }
        if (backWood == otherSpec.getBackWood()) {
            return true;
        }
        if (topWood == otherSpec.getTopWood()) {
            return true;
        }
        return numStrings.equals(otherSpec.getNumStrings());
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "model='" + model + '\'' +
                ", builder=" + builder +
                ", type=" + type +
                ", backWood=" + backWood +
                ", topWood=" + topWood +
                '}';
    }
}
