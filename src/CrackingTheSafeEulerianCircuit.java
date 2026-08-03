import java.util.HashSet;
import java.util.Set;

class CrackingTheSafeEulerianCircuit {

       public static  void main(String [] args){
           CrackingTheSafeEulerianCircuit sol = new CrackingTheSafeEulerianCircuit();
          String res =  sol.crackSafe(2,2);
          System.out.println(res);
       }
        public String crackSafe(int n, int k) {
            Set<String> visited = new HashSet<>();
            StringBuilder result = new StringBuilder();

            String start = "0".repeat(n - 1);

            dfs(start, k, visited, result);

            // DFS builds the answer during backtracking.
            result.append(start);

            return result.toString();
        }

        private void dfs(String node, int k, Set<String> visited, StringBuilder result) {
            for (int digit = 0; digit < k; digit++) {

                String password = node + digit;

                if (!visited.contains(password)) {
                    visited.add(password);

                    // Keep the last n - 1 characters.
                    String nextNode = password.substring(1);

                    // Go deeper first.
                    dfs(nextNode, k, visited, result);

                    // This executes while backtracking.
                    result.append(digit);
                }
            }
        }
    }
