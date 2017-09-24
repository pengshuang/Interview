/**
 * Created by pengshuang on 17/9/23.
 */
public class Thread1 {

    static synchronized void print1() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("a");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static synchronized void print2() {
        for (int i = 0; i < 3; i++) {
            System.out.println("b");
        }
    }

    public static void main(String [] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread1.print1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread1().print2();
            }
        }).start();
    }
}
