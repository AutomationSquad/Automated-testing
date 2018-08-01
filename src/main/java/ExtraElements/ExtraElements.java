package ExtraElements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExtraElements {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        boolean isMoreThanThree = false;
        while (!isMoreThanThree) {
            System.out.println("Enter numbers separated by a space");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            String[] strArr = string.split("\\s+");
            for (int i = 0; i < strArr.length; i++) {
                list.add(Integer.parseInt(strArr[i]));
            }
            if (list.size() > 3) {
                isMoreThanThree = true;
            }
        }
       Set s = new HashSet(list);
        System.out.println("Numbers :" + s);
    }
}