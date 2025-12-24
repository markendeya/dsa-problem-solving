public class MinDiffElement {
//    Input: [4, 6, 10], key = 7
//    Output: 6
//    Explanation: The difference between the key '7' and '6' is minimum than any other number in the array


    public int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0])
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }
}
