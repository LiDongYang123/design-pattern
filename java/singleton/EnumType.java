package singleton;

import vo.Person;

/**
 * @ClassName EnumType
 * @Description 枚举方式
 * @Author lidongyang
 * @Date 2022/9/19 15:04
 * @Version 1.0
 **/
public enum EnumType {
    INSTANCE;

    public void dodo() {
        System.out.println(111);
    }

    public static void main(String[] args) {
        EnumType.INSTANCE.dodo();
    }

}
