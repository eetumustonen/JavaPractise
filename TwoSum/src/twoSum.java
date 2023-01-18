import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 2, 4, 3 };
        int[] ans = twoSum(nums, 11);
        for( int i = 0; i < ans.length; i++ ) {
            System.out.println(ans[i]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(checked.containsKey(nums[i])){
                int[] ret = {checked.get(nums[i]), i};
                return ret;
            } else {
                checked.put( target- nums[i], i);
            }
        }
        return nums;
    }
}
