import java.util.*;

public class findOriginalArray {
    //Input: changed = [2,4,1,8]
   // Expected Output: [1,4]  //1,2,4,8
    public List<Integer> findOriginalArray(int[] changed) {
        if(changed.length%2!=0) return new ArrayList<>();
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : changed){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : changed){
            if(map.get(num)==0)continue;
            if(map.getOrDefault(2 * num, 0) > 0){
                map.put(num,map.getOrDefault(num,0)-1);
                map.put(2*num,map.getOrDefault(2*num,0)-1);
                res.add(num);
            }else{
                return  new ArrayList<>();
            }
        }
     return res;
    }
    public static void main(String[] args) {
        findOriginalArray solution = new findOriginalArray();
        // Test with the provided examples
        System.out.println(solution.findOriginalArray(new int[]{2, 4, 1, 8}));
        System.out.println(solution.findOriginalArray(new int[]{6, 3, 0, 0}));
        System.out.println(solution.findOriginalArray(new int[]{1, 2, 2, 4, 4, 8, 16, 32}));
    }
}
