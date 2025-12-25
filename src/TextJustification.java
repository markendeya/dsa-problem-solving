import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i =0;
        while(i<words.length){
            int len = words[i].length();
            int j = i+1;
            while(j<words.length && len+words[j].length()+ (j-i)<= maxWidth){
                len+=words[j].length();
                j++;
            }
            int gaps = j-i-1;
            int spaces = maxWidth-len;
            StringBuilder line = new StringBuilder();
            if(j== words.length || gaps == 0){
                for(int k=i;k<j;k++){
                    line.append(words[k]);
                    if(k!=j-1){
                        line.append(" ");
                    }
                }
                while(line.length()<maxWidth){
                    line.append(" ");
                }
            }else{
                int spacesEach = spaces/gaps;
                int extra = spaces%gaps;
                for(int k=i;k<j;k++){
                    line.append(words[k]);
                    if(k!=j-1){
                        int toAdd =spacesEach + (extra-->0? 1:0);
                        line.append(" ".repeat(toAdd));
                    }
                }
            }
            result.add(line.toString());
            i=j;
        }
        return result;
    }
}
