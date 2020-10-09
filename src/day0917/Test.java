package day0917;

class yearToDay {

    public yearToDay() {
    }

    public int calculateDay(int year, int month, int day) {

        // 合计天数
        int sumDay = 0;

        // 闰年
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 平年
        int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 输入错误
        if(month <=0 || month >12 || day <=0 || day >31){
            return -1;
        }

        // 如果是一月直接返回天数
        if (month == 1) {
            return day;
        }

        // 判断年份是闰年还是平年
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {

            // 闰年
            // 累加输入月份之前的完整天数
            for (int i = month - 2; i >= 0; i--) {
                sumDay += leapYear[i];
            }
        } else {

            // 平年
            // 累加输入月份之前的完整天数
            for (int i = month - 2; i >= 0; i--) {
                sumDay += commonYear[i];
            }
        }

        // 返回天数
        return sumDay + day;
    }

    public static void main(String[]args){
        yearToDay dd = new yearToDay();
        int sum = dd.calculateDay(2020,1,1);
        if(sum == -1){
            System.out.println("输入有误！！！");
        } else {
            System.out.println(sum);
        }
    }
}






