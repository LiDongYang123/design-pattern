package singleton;

import vo.Person;

/**
 * @ClassName InnerStatic
 * @Description 静态内部类
 * @Author lidongyang
 * @Date 2022/9/19 14:57
 * @Version 1.0
 **/
public class InnerStatic {

    public static class SingleTon {
        public static final Person person = new Person();
    }

    public static Person getInstance() {
        return SingleTon.person;
    }


    public static void main(String[] args) {
        Person instance1 = InnerStatic.getInstance();
        Person instance2 = InnerStatic.getInstance();
        System.out.println(instance1 == instance2);
    }
}
