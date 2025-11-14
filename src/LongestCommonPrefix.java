public class LongestCommonPrefix {

    public static void main(String[] args){
      String str[] =  new String[]{"digital","dig","dinner"};
     System.out.println("answer " + LCA(str));
    }
    public static String LCA(String[] strArr){
        String lca = strArr[0];

        for(int i=0;i<strArr.length;i++){
            while(strArr[i].indexOf(lca) != 0){
                lca = lca.substring(0,lca.length() -1);
                if(lca.isEmpty()){
                    return "";
                }
            }
        }
        return lca;
    }
}
