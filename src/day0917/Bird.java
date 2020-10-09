package day0917;

/**
 * @author 王旻爽
 * 2020/9/17
 * @ClassName Bird.java
 */
public interface Bird {
    public void fly();
}

class RedBird implements Bird{

    @Override
    public void fly() {
        System.out.println("红色小鸟正常飞行");
    }
}

class BlueBird implements Bird{

    @Override
    public void fly() {
        System.out.println("蓝色小鸟分裂成三个");
    }
}

class YellowBird implements Bird{

    @Override
    public void fly() {
        System.out.println("黄色小鸟飞行加速");
    }
}

class BlackBird implements Bird{

    @Override
    public void fly() {
        System.out.println("黑色小鸟会爆炸");
    }
}