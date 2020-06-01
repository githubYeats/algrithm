package cn.yetis.pro;

import java.math.BigDecimal;

/**
 * @author fyyang
 * @since 2020-4-27
 */
public class Apple {

    private String name;

    private String colour;

    private BigDecimal weight;

    public Apple(String name, String colour, BigDecimal weight) {
        this.name = name;
        this.colour = colour;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
