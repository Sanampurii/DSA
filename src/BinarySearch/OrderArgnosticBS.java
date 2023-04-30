package BinarySearch;
// Assumption : Array is sorted
// Order of sorting is UNKNOWN
public class OrderArgnosticBS {
    public static void main(String[] args) {

        int[] array = {-10, -4, 0, 1, 2, 5, 6, 45, 76, 89, 99};
        int target = 99;

        int ans = orderArgnosticBS(array, target);
        System.out.println("Target Value is present in Array at index = " + ans);

    }

    // This is when its when we know its a sorted array just that we dont know its order.
    // Bcoz if we use this and array is {1,4,3,4,10} this will not work as its designed to work with a sorted algo
    static int orderArgnosticBS(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        boolean isAscending = array[start] < array[end];

        while (start <= end) {
            // midifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (target < array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (target > array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }


            }
        }
        return -1;
    }
}
