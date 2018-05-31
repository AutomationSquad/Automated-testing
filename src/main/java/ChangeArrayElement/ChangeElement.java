package ChangeArrayElement;

public class ChangeElement {

    public static void main(String[] args) {
        int[] nums = {3, -7, 0, 6, 9};
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        int change;
        change = nums[max];
        nums[max] = nums[min];
        nums[min] = change;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(",");
            }
        }
    }
}

