import java.util.*;

public class collectionsBasic {
    public static void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i] = 0;
                System.out.println(i);
                System.out.println(snowBallSize);
                nums[i - snowBallSize] = t;
            }
        }

        boolean el = true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }


    }
