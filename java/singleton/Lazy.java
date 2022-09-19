package singleton;

import vo.Person;

/**
 * @ClassName Lazy
 * @Description 懒汉式单例
 * @Author lidongyang
 * @Date 2022/9/19 14:48
 * @Version 1.0
 **/
public class Lazy {
    public static Person person;
    public static synchronized Person getInstance() {
        if (null == person) {
            person = new Person();
        }
        return person;
    }

    public static void main(String[] args) {
        Person instance1 = Lazy.getInstance();
        Person instance2 = Lazy.getInstance();
        System.out.println(instance1 == instance2);
    }
}
