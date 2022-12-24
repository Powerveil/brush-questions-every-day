package com.power.study_2022_12.test;

public class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }

    public void addOne(final Other o) {
        o.i++;
    }
}

class Other {
    public int i;
}