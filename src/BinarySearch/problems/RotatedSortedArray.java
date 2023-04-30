package BinarySearch.problems;

//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotatedSortedArray {
    public static void main(String[] args) {

    }

    static int findPiviot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // 4 cases to find this
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // lets take {1,2,3,4,5,6,3,2,1} if mid = 6 is greater than mid +1 then this is possible ans
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                // lets take {1,2,3,4,5,6,3,2,1} if mid = 3 then mid is smaller than mid-1 then mid-1 is the possile ans
                return mid - 1;
            } else if (arr[mid] < arr[start]) {
                // lets take {3,4,5,6,2} if mid = 2,start=6,end = 2
                // In this case mid 2 is less than 6 then this means that greater number lies on the left of 2
                end = mid - 1;
            } else {
                start = mid +1;
                
            }
        }

            return start;
    }
}
