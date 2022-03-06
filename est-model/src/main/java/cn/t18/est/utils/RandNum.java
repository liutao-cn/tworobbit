package cn.t18.est.utils;

import java.util.Random;

/**
 * 生成随机数
 */
public class RandNum {

    //设置成私有构造
    private RandNum(){
    }


    /**
     * 生成随机数的第一种方式
     * @param num 值为多大，则生成几位的随机数  Math.pow(10,1)定义为10的1次方
     * @return
     */
    public static int creatRandom(int num){
        double random = Math.random() * (9 * Math.pow(10, num - 1) - 1) + Math.pow(10, num - 1);
        int random1 = (int) random;
        //return (int)(Math.random() * 9000 + 1000);
        return random1;
    }

    /**
     * 生成随机数的第二种方式
     * 根据指定参数数量，来生成随机长度
     * @param num 10000,100000   在需要多少位的长度上在多加一位数
     * @return
     */
    public static int getRandNum(int num){
        Random random = new Random();
        int i;
        do {
            i = random.nextInt(num);
        } while (i< num/10);   //比如 100000/10=10000  当i小于10000时从新生成
        return i;
    }

    //测试方法
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(creatRandom(4));
        }
    }
}
