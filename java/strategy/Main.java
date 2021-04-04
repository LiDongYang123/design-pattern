package strategy;

import org.junit.Test;

import java.util.Arrays;

public class Main {

    @Test
    public void testCat() {
        Sorter<Cat> catSorter = new Sorter<Cat>();
        Cat[] cats = {new Cat(3),new Cat(1),new Cat(5),new Cat(4)};
        catSorter.sort(cats,new CatWeightComparator());
        System.out.println(Arrays.toString(cats));
    }

    @Test
    public void testDog() {
        Sorter<Dog> dogSorter = new Sorter<Dog>();
        Dog[] dogs = {new Dog(7),new Dog(1),new Dog(3),new Dog(4)};
        dogSorter.sort(dogs,new DogHeightComparator());
        System.out.println(Arrays.toString(dogs));
    }
}
