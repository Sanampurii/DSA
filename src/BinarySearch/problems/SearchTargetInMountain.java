package BinarySearch.problems;
// https://leetcode.com/problems/find-in-mountain-array/
// interactive so not submitted

public class SearchTargetInMountain {
    public static void main(String[] args) {
        int[] mountainArr = {0,1,2,4,2,1};
        int target = 3;
        int peakElement = peakIndexInMountainArray(mountainArr);
        int ans = binarySearch(mountainArr,target,0,peakElement);
        if (ans== -1){
            ans = binarySearch(mountainArr,target,peakElement+1,mountainArr.length-1);
        }
        System.out.println(ans);
    }

    static int peakIndexInMountainArray(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;

        while (start < end) {
            // modifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (mountainArr[mid] > mountainArr[mid+1]){
                // so in this case mid can be the possible ans but it could be that a more bigger number lies on left
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        System.gc();
        return start;
    }

    static int binarySearch(int[] mountainArr, int target,int start,int end) {

        while (start <= end) {
            // midifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;

            if (target < mountainArr[mid]) {
                end = mid - 1;
            } else if (target > mountainArr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
