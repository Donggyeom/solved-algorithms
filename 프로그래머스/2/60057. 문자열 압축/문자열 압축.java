import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        char[] chars = s.toCharArray();
        
        StringBuilder sb = new StringBuilder(s.length());
        Deque<StringCounter> deque = new ArrayDeque<>();
        for (int i = 1, end = s.length()/2; i <= end; i++) {
            sb.setLength(0);
            deque.clear();
            int curIdx = 0;
            while (curIdx+i <= s.length()) {
                StringCounter top = deque.peekLast();
                String cur = s.substring(curIdx, curIdx+i);
                if (top == null) {
                    deque.offer(new StringCounter(cur));
                }
                else if (cur.equals(top.str)) {
                    top.plusCount();
                }
                else {
                    deque.offer(new StringCounter(cur));
                }
                curIdx += i;
            }
            
            while (!deque.isEmpty()) {
                sb.append(deque.poll());
            }
            sb.append(s.substring(curIdx));
            
            answer = Math.min(answer, sb.length());
            // System.out.println(sb.toString());
        }
        
        
        return answer;
    }
}

class StringCounter {
    String str;
    int count;
    
    public StringCounter(String str) {
        this.str = new String(str);
        this.count = 1;
    }
    public void plusCount() {
        // System.out.println(toString() + "++");
        this.count++;
    }
    public String toString(){
        if (count != 1) return Integer.toString(count) + str;
        else return str;
    }
}