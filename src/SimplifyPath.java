import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if(path== null || path.isEmpty()){
            return "";
        }
        Stack<String> stack = new Stack<>();
        for(String str: path.split("/")){
            if(str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else if(!str.isEmpty() && !str.equals(".")){
                    stack.push(str);
                }
        }
        return "/" + String.join("/",stack);
    }

    public static void main(String[] args) {
        SimplifyPath sol = new SimplifyPath();
        // Test cases
        System.out.println(sol.simplifyPath("/a//b////c/d//././/..")); // Expected output: "/a/b/c"
        System.out.println(sol.simplifyPath("/../")); // Expected output: "/"
        System.out.println(sol.simplifyPath("/home//foo/")); // Expected output: "/home/foo"
    }
}
