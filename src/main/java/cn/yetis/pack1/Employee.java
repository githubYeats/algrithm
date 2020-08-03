package cn.yetis.pack1;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
@Data
@NoArgsConstructor
public class Employee {

    private String name;

    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
