package cn.yetis.pack1.ex01;

import lombok.Data;

/**
 * @author fyyang
 * @since 2020-9-23
 */
@Data
public class Guitar {
    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 价格
     */
    private double price;

    /**
     * 吉他规格
     */
    private GuitarSpec guitarSpec;

    public Guitar(String serialNumber, GuitarSpec guitarSpec, double price) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.guitarSpec = guitarSpec;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", guitarSpec=" + guitarSpec +
                '}';
    }
}
