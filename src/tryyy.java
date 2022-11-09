public class tryyy {

    public static void main(String[] args) {
        /******************************************************************************

         Online Java Debugger.
         Code, Run and Debug Java program online.
         Write your code in this editor and press "Debug" button to debug program.

         *******************************************************************************/

        int[] nums = {4,8,8,8,10};
        int target = 8;
        int low =0 , high = nums.length-1, start=-1, end=-1;

        while(low<high){

            int mid = (low+high)/2;

            if (nums[mid]==target) {
                if (mid>0 && mid < nums.length-1) {
                    if(nums[mid-1]==target) low = mid-1;
                    else start = low = mid;

                    if(nums[mid+1]==target) high = mid+1;
                    else end = high = mid;
                }
            }
            else if (target>nums[mid]) low = mid+1;
            else high = mid-1;
        }

        System.out.println(start);
        System.out.println(end);
    }
}
