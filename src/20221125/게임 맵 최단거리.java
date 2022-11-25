import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        
        Bfs bfs = new Bfs(maps);
        
        bfs.execute();
        
        return bfs.answer;
    }

}

class Bfs {
    
    static int[] dx = { -1,  0,  1,  0};
    static int[] dy = {  0,  1,  0, -1};
    
    int[][] maps;
    boolean[][] visited;
    
    int n;
    int m;
    
    int answer;
    
    public Bfs(int[][] maps) {
        this.maps = maps;
        
        this.n = maps.length;
        this.m = maps[0].length;
        
        this.visited = new boolean[n][m];
        
        this.answer = 1;    
    }
    
    void execute () {
        int[] start = {0, 0};
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        
        while ( !que.isEmpty() ) {
            
            int len = que.size();
            for (int i = 0; i < len; i++) {
                int[] p = que.poll();
                
                if (visited[p[0]][p[1]]) continue;
                
                if (p[0] == n-1 && p[1] == m-1) {
                    return;
                }
                
                visited[p[0]][p[1]] = true;
                
                for (int j = 0; j < 4; j++) {
                    int[] np = {p[0], p[1]};
                    np[0] = p[0] + dx[j];
                    np[1] = p[1] + dy[j];
                    
                    if (np[0] >= 0 && np[0] < n
                         && np[1] >= 0 && np[1] < m
                         && maps[np[0]][np[1]] == 1
                         && !visited[np[0]][np[1]]) {
                        que.offer(np);
                    }
                }
            }
                
            answer++;
        }
        
        answer = -1;
    }
}

/*
https://school.programmers.co.kr/learn/courses/30/lessons/1844
*/