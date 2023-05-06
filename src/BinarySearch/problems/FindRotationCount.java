package BinarySearch.problems;

// Find how many times the array has been rotated
// Assume the give as array as a mountain array
//
public class FindRotationCount {
    public static void main(String[] args) {
        // Best Approach Find the pivot and ans will be pivot +1
        int[] array = {4,5,6,7,0,1,2};

        int pivot = findPiviotDuplicate(array);
        System.out.println(pivot + 1);
    }

    static int findPiviotDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // 4 cases to find this
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                // lets take {1,2,3,4,5,6,3,2,1} if mid = 6 is greater than mid +1 then this is possible ans
                return mid;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                // lets take {1,2,3,4,5,6,3,2,1} if mid = 3 then mid is smaller than mid-1 then mid-1 is the possile ans
                return mid - 1;
            }
            //if elements at middle,start and end are same then we have to just skip the duplicate the elements by incrementing
            //but in this case if our start or end is the pivot then we will make a check here
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // if all this fails means left side is sorted, so pivot will ie on right hand side
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                start = mid - 1;
            }

        }

        return -1;
    }
}
