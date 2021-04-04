package strategy;

import java.util.Comparator;

public class DogHeightComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2) {
        if (dog1.height < dog2.height) return -1;
        else if (dog1.height > dog2.height) return 1;
        else return 0;
    }
}
