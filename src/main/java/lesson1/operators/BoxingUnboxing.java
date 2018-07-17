package lesson1.operators;

public class BoxingUnboxing {
    public static void main(String[] args) {
        ///boxing
        Integer iOb = 7;
        Double dOb = 7.0;
        Character cOb = 'a';
        Boolean bOb = true;

        method(7);
        method(iOb);

        ///unboxing
        int i = iOb;
        double d = dOb;
        char c = cOb;
        boolean b = bOb;
    }

    public static void method(Integer i) {
        System.out.println("Integer");
    }

    public static void method(int i) {
        System.out.println("int");
    }
}
