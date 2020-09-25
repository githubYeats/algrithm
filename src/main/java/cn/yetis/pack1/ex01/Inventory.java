package cn.yetis.pack1.ex01;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fyyang
 * @since 2020-9-23
 */
@Data
public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, String builder, String model, String type, String backWood, String topWood, double price) {
        Guitar guitar = new Guitar(serialNumber, builder, model, type, backWood, topWood, price);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public Guitar search(Guitar searchGuitar) {
        for (Guitar guitar : guitars) {
            // serialNumber、price两者不判断了，因为它们都是唯一的。  price假设也是唯一的。

            String builder = searchGuitar.getBuilder();
            if ((!"".equals(builder)) && (!builder.equals(guitar.getBuilder()))) {
                continue;
            }

            String model = searchGuitar.getModel();
            if ((!"".equals(model)) && (!model.equals(guitar.getModel()))) {
                continue;
            }

            String type = searchGuitar.getType();
            if ((!"".equals(type)) && (!type.equals(guitar.getType()))) {
                continue;
            }

            String backWood = searchGuitar.getBackWood();
            if ((!"".equals(backWood)) && (!backWood.equals(guitar.getBackWood()))) {
                continue;
            }

            String topWood = searchGuitar.getTopWood();
            if ((!"".equals(topWood)) && (!topWood.equals(guitar.getTopWood()))) {
                continue;
            }
        }
        return null;
    }

}
