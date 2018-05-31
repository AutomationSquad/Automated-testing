package RandomArray;

import java.util.Random;
import java.util.stream.IntStream;

public class FrequentElement {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream ints = random.ints(-1, 2).limit(13);
        int[] arr1 = ints.toArray();
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            System.out.print(arr1[i] + ",");
        }
        System.out.println();
        int counter;
        int maxCounter = 0;
        int element = 0;
        for (int i = 0; i < length; i++) {
            counter = 0;
            for (int j = 0; j < length; j++) {
                if (arr1[j] == arr1[i]) {
                    counter++;
                }
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                element = arr1[i];
            }
        }
        System.out.println(element + " " + maxCounter);
    }
}
