package thread_test;

/**
 * 三个线程，A输出A，B输出B，C输出C，要求同时启动三个线程，按顺序输出ABC，循环10次
 */
public class NotifyDemo implements Runnable {

    public static void main(String args[]) throws InterruptedException {
        String signalA = new String("a");
        String signalB = new String("b");
        String signalC = new String("c");

        new Thread(new NotifyDemo(signalC, signalA, "a")).start();
        Thread.sleep(500);
        new Thread(new NotifyDemo(signalA, signalB, "b")).start();
        Thread.sleep(500);
        new Thread(new NotifyDemo(signalB, signalC, "c")).start();
    }

    private String pre, my;
    private String str;

    public NotifyDemo(String pre, String my, String str) {
        this.pre = pre;
        this.my = my;
        this.str = str;
    }

    @Override
    public void run() {
        int count = 3;
        while (count > 0) {
            synchronized (pre) {
                synchronized (my) {
                    System.out.println(str);
                    count--;
                    my.notify();
                }
                try {
                    if (count != 0) { // 输出完成后无须再等待了
                        pre.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
