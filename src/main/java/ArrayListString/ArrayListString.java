package ArrayListString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayListString {
    public static void main(String[] args) throws IOException {
        ArrayList <String> list = new ArrayList <String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lengthMin = 0;
        for (int i =0; i < 5; i++) {
           list.add (reader.readLine());
           if (i == 0) {
               lengthMin = list.get(i).length();
           }
            list.get(i).length();
           if (list.get(i).length() < lengthMin) {
               lengthMin = list.get(i).length();
           }
        }
        for (int i = 0; i < 5; i++) {
            if (list.get(i).length() == lengthMin) {
                System.out.println(list.get(i));
            }
        }
    }
}
