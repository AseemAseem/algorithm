package thread_test;

/**
 * 三个线程，A输出A，B输出B，C输出C，要求同时启动三个线程，按顺序输出ABC，循环10次
 */
public class SynchronizedDemo implements Runnable {
    private String name;
    private String prev;
    private String self;

    public SynchronizedDemo(String name, String prev, String self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    // 先取得两个锁，打印name，打印完 唤醒下一个需要自己的线程，并释放锁。本次打印完毕，释放prev锁，并进入等待状态。
    // 每个线程最开始的 notify是无用的，后面每次对应一个wait  相当于第一组的notify没用，第二组的notify激活第一组的wait，第三组的notify激活第二组的wait、最后已一组没有wait。
    @Override
    public void run() {
        int count = 3;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    System.out.println("   " + self + " notify");               //用完了 释放self锁
                    self.notify();
                }
                try {
                    if (count != 0) {                                           // 最后一次 不需要wait了 如果wait会导致卡在这
                        System.out.println("   " + prev + " wait");
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        String a = new String("a");
        String b = new String("b");
        String c = new String("c");

        SynchronizedDemo t1 = new SynchronizedDemo("A", c, a);
        SynchronizedDemo t2 = new SynchronizedDemo("B", a, b);
        SynchronizedDemo t3 = new SynchronizedDemo("C", b, c);

        // 依赖线程启动的顺序
        new Thread(t1).start();
        Thread.sleep(50);
        new Thread(t2).start();
        Thread.sleep(50);
        new Thread(t3).start();
        Thread.sleep(50);
    }
}