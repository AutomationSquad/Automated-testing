package ArrayOdd;

public class Array {
    public static void main(String[] args) {
        int [] nums = {1,3,5,7,9,11,13,15,17,19};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
    }


}
