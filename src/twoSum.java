import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        int[] twoSum = new int[2];

        for (int i =0;i < nums.length ; i++){
            for (int j = i+1; j< nums.length ; j++){
                if (nums[j] == target - nums[i]){
                    twoSum[0] = i;
                    twoSum [1] = j;

                }
            }
        }

        System.out.println(Arrays.toString(twoSum));

    }
}
