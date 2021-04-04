package singleton;

/**
 * 静态内部类，相对完美，但是不能防止反序列化获取类对象
 */
public class StaticInner {

    private StaticInner(){}

    private static class StaticInstance {
        private static StaticInner instance = new StaticInner();
    }

    public static StaticInner getInstance() {
        return StaticInstance.instance;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            new Thread(() -> {
                System.out.println(StaticInner.getInstance().hashCode());
            }).start();
        }
    }
}
