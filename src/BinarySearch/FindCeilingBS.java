package BinarySearch;

public class FindCeilingBS {
    public static void main(String[] args) {
        int[] array = {2,3,5,9,14,16,18};
        int target = 100;

        int ans = searchCeilingBS(array,target);
        System.out.println("Ceiling is = " + ans);
    }
    //return the index of greater no >= Target
    static int searchCeilingBS(int[] array,int target) {
        int start = 0;
        int end = array.length - 1;

        if (target > array[array.length-1]){
            return -1;
        }

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
        return start;
    }
}
