package BinarySearch;
//Assumption : Array is sorted in ascending order

public class BinarySearch {

    public static void main(String[] args) {
        //we must take a sorted array here AS IN ascending order. For Descending order the logic will change a bit
        int[] array = {-10, -4, 0, 1, 2, 5, 6, 45, 76, 89, 99};
        int target = 99;

        int ans = binarySearch(array,target);
        System.out.println("Target Value is present in Array at index = " + ans);

    }

    // For Ascending Order Sorted Array
    static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // midifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    // For Descending Order Sorted Array
/*    static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // mxidifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (target > array[mid]) {
                end = mid - 1;
            } else if (target < array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }*/

}
