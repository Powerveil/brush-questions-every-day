package com.power.september_21;

/**
 * @author 崔帅
 * @version 1.0
 */
public class No_14 {

    private String name;
    private Integer age;


    public No_14() {
    }


    public No_14(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public No_14(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "No_14{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
