import java.util.*;
import java.util.stream.*;

class Solution {
    static int[] LEFT   = { 0, -1};
    static int[] UP     = {-1,  0};
    static int[] RIGHT  = { 0, +1};
    static int[] DOWN   = {+1,  0};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][] rowVisited = new boolean[11][10];
        boolean[][] colVisited = new boolean[10][11];
        
        int[] point = {5, 5};
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            switch(dir) {
                case 'U':
                    if (point[0] == 0) break;
                    
                    point[0] += UP[0];
                    point[1] += UP[1];
                    
                    colVisited[point[0]][point[1]] = true;
                    break;
                case 'R':
                    if (point[1] == 10) break;
                    
                    rowVisited[point[0]][point[1]] = true;
                    
                    point[0] += RIGHT[0];
                    point[1] += RIGHT[1];
                    break;
                case 'D':
                    if (point[0] == 10) break;
                    
                    colVisited[point[0]][point[1]] = true;
                    
                    point[0] += DOWN[0];
                    point[1] += DOWN[1];
                    break;
                case 'L':
                    if (point[1] == 0) break;
                    
                    point[0] += LEFT[0];
                    point[1] += LEFT[1];
                    
                    rowVisited[point[0]][point[1]] = true;
                    break;
            }
        }
        
        
            
            
        for (int i = 0; i < rowVisited.length; i++) {
            for (int j = 0; j < rowVisited[0].length; j++) {
                if (rowVisited[i][j]) answer++;
            }
        }

        for (int i = 0; i < colVisited.length; i++) {
            for (int j = 0; j < colVisited[0].length; j++) {
                if (colVisited[i][j]) answer++;
            }
        }
        
        return answer;
    }
}