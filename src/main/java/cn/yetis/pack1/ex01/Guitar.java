package cn.yetis.pack1.ex01;

import lombok.Data;

/**
 * @author fyyang
 * @since 2020-9-23
 */
@Data
public class Guitar {
    private String serialNumber, builder, model, type, backWood, topWood;
    private double price;

    public Guitar(String serialNumber, String builder, String model, String type, String backWood, String topWood, double price) {
        this.serialNumber = serialNumber;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", backWood='" + backWood + '\'' +
                ", topWood='" + topWood + '\'' +
                ", price=" + price +
                '}';
    }
}
