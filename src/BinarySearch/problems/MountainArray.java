package BinarySearch.problems;

// 852. Peak Index in a Mountain Array https://leetcode.com/problems/peak-index-in-a-mountain-array/
//  This solution wont work for duplicate element array
public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0,10,11,5,2,1};

        int ans = peakIndexInMountainArray(arr);

        System.out.println(ans);
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // modifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid+1]){
                // so in this case mid can be the possible ans but it could be that a more bigger number lies on left
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }

        // gc will invoke the garbage collector and frees the memory
        System.gc();
        // At this point Start == end and it will be pointing to the largest number in the array
        // start and end will be coming closer to the largest number at this condition these will become equal and hence the max number is found
        // At every point of start and end they have the best possible ans till that time and if we are saying that only one item is remaining then tha tis the best possible ans found through
        return start;


    }

    // the other way we can do like simple binary search
    static int peakIndexInMountainArray2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;

        while (start <= end) {
            // modifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid+1]){
                // so in this case mid can be the possible ans but it could be that a more bigger number lies on left
                end = mid -1;
                // as this is the possible ans we are storing it
                // It will again go through loop and update the possible ans until we find it as perfect
                // As we shrink down the start and end it will get more closer to the perfect ans
                ans = mid;
            }else {
                start = mid + 1;
            }
        }

        // gc will invoke the garbage collector and frees the memory
        System.gc();
        //At this point it will break through loop after recording the closes possible or the perfect ans as the end > start
        return ans;


    }

}
