package Exercise1;

import java.util.Arrays;

public class ExersiceOne {
    public interface ArithmeticOperation {

        int perform(int a, int b);

    }
    static int operates(int a, int b, ArithmeticOperation op) {
        return op.perform(a, b);


    }

    static int[] array(int[] a, int[] b, ArithmeticOperation op) {
        int[] array = new int[a.length + b.length];
        for (int i = 0; i < array.length; i++) {
            if (a.length > i) {
                array[i] = a[i];
            } else {

                array[i] = b[i - a.length];
            }

        }
        return array;
    }

    public static void main(String[] args) {


      //  List<Employee> lists = new ArrayList<>();

        ArithmeticOperation addition = (int a, int b) -> a + b;
        ArithmeticOperation subtraction = (int a, int b) -> a - b;
        ArithmeticOperation multiplcation = (int a, int b) -> a * b;
        ArithmeticOperation divsion = (int a, int b) -> a / b;
        ArithmeticOperation power = (int a, int b) -> a ^ b;
        ArithmeticOperation modlus = (int a, int b) -> a % b;


        int result = operates(4, 8, addition);
        System.out.println(result);
        int[] array = {1, 3, 4, 5};
        int[] array1 = {1, 3, 4, 5};


        int[] results = array(array, array1, addition);
        System.out.println(Arrays.toString(results));


    }
}