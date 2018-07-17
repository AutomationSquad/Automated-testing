package lesson1.operators;

class WordCount {

    static String text = "Now is the tifne\n" +
            "for all good men\n" +
            "to come to the aid\n" +
            "of their country\n" +
            "and pay their due taxes\n";

    static int len = text.length();

    public static void main(String args[]) {
        boolean inWord = false;
        int numChars = 0;
        int numWords = 0;
        int numLines = 0;

        for (int i = 0; i < len; i++) {
            char с = text.charAt(i);
            numChars++;
            switch (с) {
                case '\n':
                    numLines++;
                case '\t':
                case ' ':
                    if (inWord) {
                        numWords++;
                        inWord = false;
                    }
                    break;
                default:
                    inWord = true;
            }
        }

        System.out.println("\t" + numLines + "\t" + numWords + "\t" + numChars);

    }
}

