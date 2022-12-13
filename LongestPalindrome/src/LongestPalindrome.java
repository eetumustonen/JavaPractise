import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

  public static void main(String[] args){
    String s = "abcracecarxxxx";
    System.out.println(s);
    System.out.println(longestPalindrome(s));
  }

  private static String longestPalindrome(String s) {
     HashMap<String, Integer> palindromes = new HashMap<>();
     palindromes.put(s.charAt(0) + "", 1);

     for(int i = 1; i < s.length() - 1; i++){
        if(s.charAt(i) == s.charAt(i + 1) && s.length() % 2 == 0){
            int p1 = i - 1;
            int p2 = i + 2;
            String pal = s.charAt(i) + Character.toString(s.charAt(i + 1));
            while(true){
                if(p1 == -1 || p2 == s.length()){
                    palindromes.put(pal, pal.length());
                    break;
                } else if(s.charAt(p1) != s.charAt(p2)){
                    palindromes.put(pal, pal.length());
                    break;
                } else {
                    pal = s.charAt(p1) + pal + s.charAt(p2);
                    p1--;
                    p2++;
                }
            }
        }
        else if(s.charAt(i - 1) == s.charAt(i + 1)){
            int p1 = i - 1;
            int p2 = i + 1;
            String pal = s.charAt(i) + "";
            while(true){
                if(p1 == -1 || p2 == s.length()){
                    palindromes.put(pal, pal.length());
                    break;
                } else if(s.charAt(p1) != s.charAt(p2)){
                    palindromes.put(pal, pal.length());
                    break;
                } else {
                    pal = s.charAt(p1) + pal + s.charAt(p2);
                    p1--;
                    p2++;
                }
            }
        } else {
            //not a palindrome
        }
     }
     String key = Collections.max(palindromes.entrySet(), Map.Entry.comparingByValue()).getKey();
     return key;
  }
}