package com.power.september_21;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Apple {
    private String color;
    private Integer age;

    public Apple() {
    }

    public Apple(String color, Integer age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
