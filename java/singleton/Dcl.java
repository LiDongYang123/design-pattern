package singleton;

import vo.Person;

/**
 * @ClassName DCL
 * @Description 双重检测式单例
 * @Author lidongyang
 * @Date 2022/9/19 14:52
 * @Version 1.0
 **/
public class Dcl {
    /**
     * tips:低版本的jdk需要加volatile 防止指令重排导致拿到的对象是未初始化对象
     */
    public static Person person;

    public static Person getInstance() {
        if (null == person) {
            synchronized (Dcl.class) {
                if (null == person) {
                    person = new Person();
                }
            }
        }
        return person;
    }
    public static void main(String[] args) {
        Person instance1 = Dcl.getInstance();
        Person instance2 = Dcl.getInstance();
        System.out.println(instance1 == instance2);
    }

}
