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

    public void addGuitar(String serialNumber, GuitarSpec guitarSpec, double price) {
        Guitar guitar = new Guitar(serialNumber, guitarSpec, price);
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

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchedGuitars = new ArrayList<>();
        for (Guitar guitar : guitars) {
            // serialNumber、price两者不判断了，因为它们都是唯一的。  price假设也是唯一的。
            if (guitar.getGuitarSpec().matches(searchSpec)) {
                // 满足其中一项搜索条件，即添加到搜索结果中。
                matchedGuitars.add(guitar);
            }
        }
        return matchedGuitars;
    }
}
