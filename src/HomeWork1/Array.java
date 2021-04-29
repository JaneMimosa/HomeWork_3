package HomeWork1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Array<T> {
    public T[] array;
    public T temp;

    public Array(T[] array) {
        this.array = array;
    }

    public <T> void changeArrayList(int left, int right) {
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        System.out.println(Arrays.toString(array));
    }

    public <T> ArrayList<T> toArrayList() {
        ArrayList<T> ar = new ArrayList<T>((Collection<? extends T>) Arrays.asList(array));
        return ar;
    }
}

