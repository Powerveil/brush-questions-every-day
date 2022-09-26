package com.power.september_21;


interface Geometry {
    int lon = 4;//矩形的长
    int wid = 5;//矩形的宽
    int r = 3;//圆形的半径
    String RecName = "矩形";
    String RouName = "圆形";

    static String getRecName() {
        return Geometry.RecName;
    }

    static String getRouName() {
        return Geometry.RouName;
    }

    static int getLon() {
        return Geometry.lon;
    }

    static int getWid() {
        return Geometry.wid;
    }

    static int getR() {
        return Geometry.r;
    }

    public void RectangleCir();

    public void RectangleArea();

    public void RoundCir();

    public void RoundArea();
}

public class shape {

    static class Compute implements Geometry {
        Compute() {
            System.out.println("im working");
        }

        public void RectangleCir() {
            System.out.println((lon + wid) * 2);
        }

        public void RectangleArea() {
            System.out.println(lon * wid);
        }

        public void RoundCir() {
            System.out.println(2 * r * 3.14);
        }

        public void RoundArea() {
            System.out.println(r * r * 3.14);
        }
    }

    public static void main(String[] args) {
        Compute compute = new Compute();
        System.out.println(Geometry.RecName + "的周长是:");
        compute.RectangleCir();
        System.out.println(Geometry.RecName + "的面积是:");
        compute.RectangleArea();
        System.out.println(Geometry.RouName + "的周长是:");
        compute.RoundCir();
        System.out.println(Geometry.RouName + "的面积是:");
        compute.RoundArea();
    }
}

