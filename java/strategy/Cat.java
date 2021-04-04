package strategy;

import java.util.Comparator;

public class Cat{
    //身高
    int height;
    //重量
    int weight;

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Cat(int weight) {
        this.weight = weight;
    }
}
