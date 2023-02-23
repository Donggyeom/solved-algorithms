import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }
        
        if (!set.contains(target)) return 0;
        
        // bfs
        Queue<String> que = new LinkedList<>();
        Set<String> hist = new HashSet<>();
        que.offer(begin);
        BFS:
        while ( !que.isEmpty() ) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                String str = que.poll();

                if (str.equals(target)) {
                    break BFS;
                }

                hist.add(str);

                for (String item : set) {
                    int matched = 0;
                    for (int j = 0; j < item.length(); j++) {
                        if (item.charAt(j) == str.charAt(j)) {
                            matched++;
                        }
                    }
                    if (item.length() - matched == 1 &&
                        !hist.contains(item)) {
                        que.offer(item);
                    }
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}