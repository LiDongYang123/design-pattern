package strategy;

import java.util.Comparator;

public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator) {
        //选择排序
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

    void swap(T[] arr,int i,int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
