package HomeWork4;

import java.util.ArrayList;

public class NumberArray {
    public boolean checkArray(int[] array) {
        int numberA = 1;
        int numberB = 4;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != numberA) {
                if(array[i] != numberB) {
                    return false;
                }
            }
        }
            if (contains(array, numberA) && contains(array,numberB)) {
                return true;
            }
        return false;
    }

    public ArrayList<Integer> arrayAfterNumber(int[] array) {
        int number = 4;
        if(!contains(array, number)) {
            throw new RuntimeException("No number 4 in array");
        }
        ArrayList<Integer> arrayAfterNumber = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                int length = array.length - 1 - i;
                if(length != 0) {
                    for (int j = length; j < array.length; j++) {
                        arrayAfterNumber.add(array[j]);
                        if(array[j] == number) {
                            arrayAfterNumber.clear();
                        }
                    }
                }
            }
        }
        return arrayAfterNumber;
    }

    public static boolean contains(int[] array, int number) {
        boolean result = false;

        for(int i : array){
            if(i == number){
                result = true;
                break;
            }
        }
        return result;
    }
}
