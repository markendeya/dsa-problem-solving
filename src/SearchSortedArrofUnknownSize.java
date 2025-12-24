

 class ArrayReader {
   int[] arr;

   ArrayReader(int[] arr) {
     this.arr = arr;
   }

   public int get(int index) {
     if (index >= arr.length)
       return Integer.MAX_VALUE;
     return arr[index];
   }
 }
public class SearchSortedArrofUnknownSize {
    public int search(ArrayReader reader, int target) {
        int start=0,end=1;
        while(reader.get(end)<target){
            int newStart = end+1;
            end+=(end-start+1)*2;
            start = newStart;
        }
        return binarySearch(reader, target, start, end);
    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid)) {
                end = mid - 1;
            } else if (key > reader.get(mid)) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }

        return -1;
    }
    }