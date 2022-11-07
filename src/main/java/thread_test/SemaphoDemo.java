package thread_test;

import java.util.concurrent.Semaphore;

/**
 * 三个线程，A输出A，B输出B，C输出C，要求同时启动三个线程，按顺序输出ABC，循环10次
 */
public class SemaphoDemo implements Runnable {
    Semaphore pre, my; // pre是前置信号量，my表示本字母信号量
    String str;

    // 构造函数传参
    public SemaphoDemo(Semaphore pre, Semaphore my, String str) {
        this.pre = pre;
        this.my = my;
        this.str = str;
    }

    @Override
    public void run() {
        // 执行次数控制
        for (int i = 0; i < 3; i++) {
            try {
                pre.acquire(); // 获取前置信号量
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(str);
            my.release(); // 释放信号量
        }
    }

    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(1);//放一个信号量c，让a可以先输出

        SemaphoDemo a = new SemaphoDemo(semaphoreC, semaphoreA, "a");
        SemaphoDemo b = new SemaphoDemo(semaphoreA, semaphoreB, "b");
        SemaphoDemo c = new SemaphoDemo(semaphoreB, semaphoreC, "c");

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
}
