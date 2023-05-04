package BinarySearch.problems;

public class FindLargestSum {

    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // this will return the max value at the end of loop
            end += nums[i];
        }

        // Now we have range so applly the binary search
        while (start < end) {
            // try for the mid as potential and
            int mid = start + (end - start) / 2;

            // Now lets calculate how many pieces we can divide this array in sub array to get the largest sum
            int sum = 0;
            int pieces = 1; // this is k which we are calculating, we will check this with given k later to reach desired ans

            for (int num : nums) {
                if (sum + num > mid) {
                    // If the sum reaches this condition means we cannot add more values in this sub array
                    // so then lets create a new array where the new sum will start from current num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            // Here if the pieces we got is greater than k required then this means the sum we are getting has
            // in first part of array has larger indivisual values then we need to make the subarray such that it has k peices
            // we just need to reduce the range so if pieces are more then just changing the start range
            // if pieces are less then we wi just alter the end as mid
            // increasing or decreasing the range will alter the partition we are creating
            if (pieces > k){
                start = mid +1;
            } else {
                end = mid;
            }


        }

        return end; // this will be our ans as here start = end

    }
}


