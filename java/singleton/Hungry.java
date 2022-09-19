package singleton;

import vo.Person;

/**
 * @ClassName Hungry
 * @Description 饿汉式单例
 * @Author lidongyang
 * @Date 2022/9/19 14:43
 * @Version 1.0
 **/
public class Hungry {
    public static Person person = new Person();
    private Hungry() {}
    public static Person getInstance() {
        return person;
    }


    public static void main(String[] args) {
        Person instance1 = Hungry.getInstance();
        Person instance2 = Hungry.getInstance();
        System.out.println(instance1 == instance2);
    }
}
