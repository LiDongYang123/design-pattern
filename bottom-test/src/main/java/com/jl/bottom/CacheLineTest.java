package com.jl.bottom;


import org.junit.Test;

/**
 * 测试缓存行的数据同步问题
 * intel cpu 默认缓存行的大小为64byte
 * 一个long类型数据占内存大小为；8byte，故当数组大小超过8时，就属于另一缓存行了
 * @author JackLi
 * @date 2021/3/12 15:25
 */
public class CacheLineTest {

    private static volatile long[] arrOne = new long[2];

    private static volatile long[] arrTwo = new long[16];

    @Test
    public void sameCacheLine() throws InterruptedException {
        Thread threadOne = new Thread(
                () -> {
                    for (int i = 0; i < 10_0000_0000l; i++) {
                        arrOne[0] = i;
                    }
                }
        );

        Thread threadTwo = new Thread(
                () -> {
                    for (int i = 0; i < 10_0000_0000l; i++) {
                        arrOne[1] = i;
                    }
                }
        );
        long startTime = System.nanoTime();
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println( (System.nanoTime() - startTime) / 100_0000l );
    }


    @Test
    public void differentCacheLine() throws InterruptedException {
        Thread threadOne = new Thread(
                () -> {
                    for (int i = 0; i < 10_0000_0000l; i++) {
                        arrTwo[0] = i;
                    }
                }
        );

        Thread threadTwo = new Thread(
                () -> {
                    for (int i = 0; i < 10_0000_0000l; i++) {
                        arrTwo[8] = i;
                    }
                }
        );
        long startTime = System.nanoTime();
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println( (System.nanoTime() - startTime) / 100_0000l );
    }

    static int a=0;
    static int b=0;
    static int x=0;
    static int y=0;

    @Test
    public void test3() throws InterruptedException {
        Thread threadOne;
        Thread threadTwo;
        for (int i = 0; i < 10_0000; i++) {
            a=b=x=y=0;
            threadOne =  new Thread(
                    () -> {
                        a = 1;
                        x = b;
                    }
            );
            threadTwo =  new Thread(
                    () -> {
                        b = 1;
                        y = a;
                    }
            );
            threadOne.start();
            threadTwo.start();
            threadOne.join();
            threadTwo.join();
            if (x==0 && y==0){
                System.out.println("第" + i + "次时发生了重排序");
            }
        }
    }

    @Test
    public void test4() throws InterruptedException {

        Thread threadOne =  new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {

                    System.out.println("1111");
                    }
                }
        );
        Thread threadTwo =  new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {

                    System.out.println("2222");
                    }
                }
        );
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
    }

    @Test
    public void test5() throws InterruptedException {
        long[] arr = new long[2];
        Thread threadOne = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        arr[0] = i;
                    }
                }
        );

        Thread threadTwo = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        arr[1] = i;
                    }
                }
        );
        long startTime = System.nanoTime();
        threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadTwo.join();
        System.out.println( (System.nanoTime() - startTime) / 100_0000l );
    }






}
