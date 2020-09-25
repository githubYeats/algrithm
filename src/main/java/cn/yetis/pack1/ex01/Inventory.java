package cn.yetis.pack1.ex01;

import lombok.Data;

import java.util.ArrayList;
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

    public void addGuitar(String serialNumber, BuilderEnum builder, String model,
                          TypeEnum type, WoodEnum backWood, WoodEnum topWood, double price) {
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

    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> matchedGuitars = new ArrayList<>();
        for (Guitar guitar : guitars) {
            // serialNumber、price两者不判断了，因为它们都是唯一的。  price假设也是唯一的。

            String model = searchGuitar.getModel();
            if ((!"".equals(model)) && (!model.equals(guitar.getModel()))) {
                continue;
            }

            if (!searchGuitar.getBuilder().equals(guitar.getBuilder())) {
                continue;
            }
            if (!searchGuitar.getType().equals(guitar.getType())) {
                continue;
            }
            if (!searchGuitar.getBackWood().equals(guitar.getBackWood())) {
                continue;
            }
            if (!searchGuitar.getTopWood().equals(guitar.getTopWood())) {
                continue;
            }

            // 满足其中一项搜索条件，即添加到搜索结果中。
            matchedGuitars.add(guitar);
        }
        return matchedGuitars;
    }

}
