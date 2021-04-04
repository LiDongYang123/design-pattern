package singleton;

/**
 * 懒汉
 */
public class Hungry {

    public static Hungry instance = new Hungry();

    private Hungry(){};

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Hungry.instance.hashCode());
            }).start();
        }
    }

}
