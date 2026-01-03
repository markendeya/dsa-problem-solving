import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!set.contains(endWord)) {
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        HashMap<String, List<String>> parentMap = new HashMap<>();
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> visitedThisLevel = new HashSet<>();
            for (int s = 0; s < size; s++) {
                String currentWord = queue.poll();
                char[] chArr = currentWord.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char original = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original)
                            continue;
                        chArr[i] = ch;
                        String nextWord = new String(chArr);
                        if (!set.contains(nextWord)) {
                            continue;
                        }
                        parentMap.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(currentWord);

                        if (!visitedThisLevel.contains(nextWord)) {
                            visitedThisLevel.add(nextWord);
                            if (nextWord.equals(endWord)) {
                                found = true;
                            } else {
                                queue.add(nextWord);
                            }
                        }
                    }
                    chArr[i] = original;
                }
            }
            set.removeAll(visitedThisLevel);
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parentMap, path, ans);
        }

        return ans;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parentMap,
                     List<String> path, List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            ans.add(validPath);
            return;
        }

        if (!parentMap.containsKey(word))
            return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parentMap, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
