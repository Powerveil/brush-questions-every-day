package com.power.test01;

public class Test {
	public static void main(String[] args) {
		/********** Begin **********/
		//创建Dog对象
        Dog wuhuarou = new Dog();
		//设置Dog对象的属性
        wuhuarou.setName("五花肉");
        wuhuarou.setColor("棕色");
        wuhuarou.setVariety("阿拉斯加");

		//输出小狗的属性
        System.out.println("名字：" + wuhuarou.getName() + "，毛色：" + wuhuarou.getColor() + "，品种：" + wuhuarou.getVariety());
		
		//调用方法
        wuhuarou.eat();
        wuhuarou.run();
//        String

		/********** End **********/
		
	}
}

//在这里定义Dog类
/********** Begin **********/
class Dog {
    String name;
    String color;
    String variety;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getVariety() {
        return variety;
    }

    public Dog() {}
    public Dog(String name, String color, String variety) {
        this.name = name;
        this.color = color;
        this.variety = variety;
        
    }
    

    public void eat() {
        System.out.println("啃骨头");
    }
    public void run() {
        System.out.println("叼着骨头跑");
    }
}


/********** End **********/