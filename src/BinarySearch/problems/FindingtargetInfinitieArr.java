package BinarySearch.problems;
// Note this Code will only work for a infinite array where there is no array end index otherwise it will fail
// If this code reached array end it will throw array out of bound as we have not considered the lenth of array here

// we have to find a target element within the infinite size of sorted array
public class FindingtargetInfinitieArr {
    public static void main(String[] args) {
        int[] arr= {2,3,4,5,6,7,8,9,11,12,13};
        int target = 8;
        System.out.println(findingRange(arr,target));

    }

    static int findingRange(int[] arr, int target) {
        // lets take small chunk of array as a start below we are taking array=2 to search with then we will dynamically change it
        int start = 0;
        int end = 1;

        // Now we will check if the target lies in the range which we assumed that is 0-1
        // here we are not checking each element because we have a sorted array so we will check only with the last value of array
        // we dont need to check with 1st value of array as for eg we took Start = 0 and End = 4 and if we check as
        // if target element is less than end then this range 0-4 will be checked and we again move forward doubling the range
        // Then we will change the range as end will become end+1 and start will be the double size of chunk we took
        // We are checking as greater than that means it lies about and don't need to check less than as it will be OBIVIOUS Else Condition

        while (target > arr[end]) {
            int tempStart = end + 1;
            // Lets say now the size of box = 2 and we need to double it So that size of box we need = 4
            // So lets take it on left hand side and create a formula arr= {2,3,4,5,6,7,8,9,11,12,13} Start = index 2 End = index 5
            // If we want to find the size of chunk how we will do we will the full length - lenth to exclue we will get current length
            // end - (s-1) that will be end - start + 1 below we are just finding that and doubling it by 2 with the current end
            end = end + (end - start + 1) * 2;
            start = tempStart;
        }

        return binarySearch(arr, target, start, end);

    }

    // we will pass start end and find the target element one we know the range where it lies in
    static int binarySearch(int[] array, int target, int start, int end) {

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
}
