import java.io.*;

class Solution {
    public String solution(String s) {
        
        return s.substring(s.length()/2 - (s.length()%2==1? 0 : 1), s.length()/2 + 1);
    }
}