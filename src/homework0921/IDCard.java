package homework0921;

/**
 * @author 王旻爽
 * 2020/9/21
 * @ClassName IDCard.java
 */
public class IDCard {
    public static void main(String[] args) {

        String idCard1 = "622226199510133034";
        String idCard2 = "622206194908213045";

        showInformation(idCard1);
        showInformation(idCard2);
    }

    private static void showInformation(String idCard) {

        String birthdayYYYY = idCard.substring(6,10);
        String birthdayMM = idCard.substring(10,12);
        String birthdayDD = idCard.substring(12,14);
        System.out.println("这位同学生日为"+birthdayYYYY+"年"+birthdayMM+"月"+birthdayDD+"日");

        int sexCode = idCard.charAt(16)-'0';
        if(sexCode % 2 == 0){
            System.out.println("是女性");
        } else {
            System.out.println("是男性");
        }
    }
}
