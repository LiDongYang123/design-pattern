package singleton;

public enum ByEnum {
    INSTANCE;


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1);
            new Thread(() -> {
                System.out.println(ByEnum.INSTANCE.hashCode());
            }).start();
        }
    }
}
