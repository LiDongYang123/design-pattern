package singleton;

/**
 * 懒汉，按需加载，有线程安全问题
 */
public class Lazy {

    private Lazy(){}

    private static Lazy instance;

    public static Lazy getInstance() {
        if (null == instance) {
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Lazy();
            return instance;
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Lazy.getInstance().hashCode());
            }).start();
        }
    }

}
