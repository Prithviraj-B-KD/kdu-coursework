package backend.handson.q3;

import backend.handson.LogBack;

import java.lang.reflect.Array;
import java.util.Arrays;

import static backend.handson.q3.GenericArray.swap;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 4, 2, 5};
        LogBack.outputLogger(Arrays.toString(numbers),"INFO");
        swap(numbers, 0, 2);
        LogBack.outputLogger(Arrays.toString(numbers),"INFO");

        String[] names = {"Alice", "Bob", "Charlie"};
        LogBack.outputLogger(Arrays.toString(names),"INFO");
        swap(names, 1, 2);
        LogBack.outputLogger(Arrays.toString(names),"INFO");

    }
}
