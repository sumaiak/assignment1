package Exercise2;

import java.util.Arrays;

public class Exercise2 {
    public interface MyTransformingType {
        public int transform(int a);


    }

    public interface MyValidatingType {
        public boolean validate(int a);
    }

    static int[] map(int[] a, MyTransformingType op) {
        int[] array = new int[a.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = op.transform(a[i])
            ;
        }
        return array;


    }
    public static int[] filter(int[] fruitbasket,MyValidatingType op) {
        int ripedBananas = 0;
        // we loop throught the fruit basket and find the riped bananas
        for (int i = 0; i < fruitbasket.length; i++) {
            //we call this op valdiate method so it returnt true if bana is riped
            if (op.validate(fruitbasket[i])) {
                ripedBananas++;

            }
        }
        //new basket for holding riped
        int[] ripeBananaBasket = new int[ripedBananas];
        int keepTrackOfbananasPosition = 0;
        for (int i = 0; i < fruitbasket.length; i++) {
            // Check if the fruit at position i is a ripe banana
            if (op.validate(fruitbasket[i])) {
                ripeBananaBasket[keepTrackOfbananasPosition] = fruitbasket[i]; // Put the ripe banana into the new basket
                keepTrackOfbananasPosition++; // Move to the next position in the new basket

            }
        }
        return ripeBananaBasket;


    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5};
        MyTransformingType transform = (int a) -> a * 2;

        MyValidatingType valdiate = (int a) -> a % 2 == 0;

        int[] transformingNumbers = map(array, transform);
        System.out.println(Arrays.toString(transformingNumbers));

        int[] valdiating = filter(array,valdiate );
        System.out.println(Arrays.toString(valdiating));

    }
}