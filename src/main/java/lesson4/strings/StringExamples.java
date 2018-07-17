package lesson4.strings;

public class StringExamples {

    public void length() {
        String s1 = "hello";
        String s2 = "whatsup";
        System.out.println("string length is: " + s1.length());
        System.out.println("string length is: " + s2.length());
    }

    //https://www.asciitable.com/
    public void compareTo() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hemlo";
        String s4 = "flag";
        System.out.println(s1.compareTo(s2)); // 0 because both are equal
        System.out.println(s1.compareTo(s3)); //-1 because "l" is only one time lower than "m"
        System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"
    }

    public void concat() {
        String s1 = "hello";
        s1 = s1.concat("how are you");
        System.out.println(s1);
    }

    public void isEmpty() {
        String s1 = "";
        String s2 = "hello";
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
    }

    public void trim() {
        String s1 = "  hello   ";
        System.out.println(s1 + "how are you");
        System.out.println(s1.trim() + "how are you");
    }

    public void toLowerCase() {
        String s1 = "HELLO HOW Are You?";
        String s1lower = s1.toLowerCase();
        System.out.println(s1lower);
    }

    public void toUpperCase() {
        String s1 = "hello how are you";
        String s1upper = s1.toUpperCase();
        System.out.println(s1upper);
    }

    public void valueOf() {
        int value = 20;
        String s1 = String.valueOf(value);
        System.out.println(s1 + 17);
    }

    public void replaceChars() {
        String s1 = "hello how are you";
        String replaceString = s1.replace('h', 't');
        System.out.println(replaceString);
    }

    public void replaceCharSequences() {
        String s1 = "Hey, welcome to Edureka";
        String replaceString = s1.replace("Edureka", "Brainforce");
        System.out.println(replaceString);
    }

    public void contains() {
        String name = " hello how are you doing?";
        System.out.println(name.contains("how are you"));
        System.out.println(name.contains("hello"));
        System.out.println(name.contains("fine"));
    }

    public void equals() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hi";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }

    public void equalsIgnoreCase() {
        String s1 = "hello";
        String s2 = "HELLO";
        String s3 = "hi";
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.equalsIgnoreCase(s3));
    }

    public void toCharArray() {
        String s1 = "Welcome to Edureka";
        char[] ch = s1.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
    }

    public void endsWith() {
        String s1="hello how are you";
        System.out.println(s1.endsWith("u"));
        System.out.println(s1.endsWith("you"));
        System.out.println(s1.endsWith("how"));
    }
}
