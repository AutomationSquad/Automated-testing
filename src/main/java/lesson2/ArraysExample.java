package lesson2;

import entities.User;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.stream.IntStream;

public class ArraysExample {

    String[] catNames = new String[10];

    public static void main(String[] args) {
        Random random = new Random();
        IntStream ints = random.ints(-1, 1).limit(10);
        int[] ints1 = ints.toArray();
        int length = ints1.length;

        int[][] twoD = new int[3][4]; // объявили двухмерный массив
        int i, j, k = 0;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 4; j++) {
                twoD[i][j] = k;
                k++;
            }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println();
        }
        User[] users = new User[5];
        users[0] = new User("user1", "Pass1231");
        users[1] = new User("user2", "Pass1231");
        User[] usersNew = users;
        users[1] = new User("usersNew", "Pass1231");
        int length1 = users.length;
        Hashtable<String, Integer> numbers
                = new Hashtable<String, Integer>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);

        int[] test1 = {1,2,3,4};
        int[] ints2 = Arrays.copyOf(test1, 4);
        int[] test2 = test1;
        test2[0] = 10;
        int length2 = test2.length;

    }
}
