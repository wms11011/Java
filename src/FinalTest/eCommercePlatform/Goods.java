package FinalTest.eCommercePlatform;

import java.util.Objects;

/**
 * @author 王旻爽
 * 2020/10/2
 * @ClassName goods.java
 */
public class Goods {

    // 商品编号
    private String goodsNum;

    // 商品名称
    private String goodsName;

    // 商品价格
    private int goodsPrice;

    // 商品销量
    private int goodsSellVolume;

    public Goods() {
    }

    public Goods(String goodsNum, String goodsName, int goodsPrice, int goodsSellVolume) {
        this.goodsNum = goodsNum;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsSellVolume = goodsSellVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return goodsPrice == goods.goodsPrice &&
                goodsSellVolume == goods.goodsSellVolume &&
                Objects.equals(goodsName, goods.goodsName);
    }

    @Override
    public String toString() {
        return goodsNum+"           "+goodsName+ "          " + goodsPrice +"         "+ goodsSellVolume;
    }



    @Override
    public int hashCode() {
        return Objects.hash(goodsName, goodsPrice, goodsSellVolume);
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsSellVolume() {
        return goodsSellVolume;
    }

    public void setGoodsSellVolume(int goodsSellVolume) {
        this.goodsSellVolume = goodsSellVolume;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }
}
