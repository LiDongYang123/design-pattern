package strategy;

import java.util.Comparator;

public class Dog{

    //身高
    int height;
    //重量
    int weight;

    public Dog(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
