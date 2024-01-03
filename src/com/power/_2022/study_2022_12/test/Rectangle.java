package com.power._2022.study_2022_12.test;

/**
 * @author 崔帅
 * @version 1.0
 */
public class Rectangle implements Graph{

    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public int getCircum() {
        return (length + width) * 2;
    }

    @Override
    public void showAll() {
        System.out.println("长：" + length);
        System.out.println("宽：" + width);
        System.out.println("面积：" + getArea());
        System.out.println("周长：" + getCircum());
    }
}
