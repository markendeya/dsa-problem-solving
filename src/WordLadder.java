import java.util.*;

public class WordLadder {
     static class Pair<K,V>{
         private K key;
         private V value;
         public Pair(K key, V value){
             this.key=key;
             this.value=value;
         }

         public K getKey() {
             return key;
         }
         public V getValue() {
             return value;
         }
     }
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength("bit", "pog", Arrays.asList("but", "put", "pig", "pog", "big"))); // Example 1
        System.out.println(solution.ladderLength("cat", "dog", Arrays.asList("cot", "dot", "dog"))); // Example 2
        System.out.println(solution.ladderLength("sing", "ring", Arrays.asList("ring"))); // Example 3
    }
    //Let's consider the input: startWord = "bit", endWord = "pog", wordList = ["but", "put", "pig", "pog", "big"]
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> wordSet = new HashSet<>(wordList);
         if(!wordSet.contains(endWord)) return -1;
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
         queue.add(new Pair<>(beginWord,1));
         while(!queue.isEmpty()){
             Pair<String,Integer> currentData = queue.poll();
             String currentWord = currentData.getKey();
             Integer level = currentData.getValue();
             if(currentWord.equals(endWord)) return level;
             for(int i=0;i<currentWord.length();i++){
                 char[] chArr = currentWord.toCharArray();
                 for(char ch = 'a'; ch<='z';ch++){
                     chArr[i] = ch;
                     String str = new String(chArr);
                     if(wordSet.contains(str)){
                         queue.add(new Pair<>(str,level+1));
                         wordSet.remove(str);
                     }
                 }
             }
         }
         return -1;
    }
}
