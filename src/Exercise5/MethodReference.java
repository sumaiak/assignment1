package Exercise5;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
        list.stream().map(number -> number * 2).forEach(System.out::println);
    }
}