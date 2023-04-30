package BinarySearch.problems;

//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
    }

    static int search(int[] nums, int target) {
        int pivot = findPiviot(nums);

        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivot] == target) {
            return pivot;
        } else if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }

    }

    // This will not work for duplicate elements
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

    // For duplocate elements we will use this
    static int findPiviot(int[] nums) {
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
            } else if (nums[mid] < nums[start]) {
                // lets take {3,4,5,6,2} if mid = 2,start=6,end = 2
                // In this case mid 2 is less than 6 then this means that greater number lies on the left of 2
                end = mid - 1;
            } else {
                start = mid + 1;

            }
        }

        return -1;
    }


    // Normal binary search
    static int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {
            // midifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
