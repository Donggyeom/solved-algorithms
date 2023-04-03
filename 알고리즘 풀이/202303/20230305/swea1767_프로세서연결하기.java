import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
class Solution {
     
    static BufferedReader br;
    static StringBuilder sb;
     
    static int T, N, coreCnt, connected, maxConnected, minLine;
    static int[][] map;
    static List<int[]> cores;
     
    static int[] dx = { -1,  0,  1,  0 };
    static int[] dy = {  0,  1,  0, -1 };
     
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder(10);                  
         
        T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            // 테스트케이스 시작
            init();
 
            // 코어 순서에 따른 시뮬
            simulate(0, 0, 0);
             
            sb.append("#").append(tc).append(" ").append(minLine).append("\n");
        }
        // 결과 출력
        System.out.println(sb);
    }
     
    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        cores = new ArrayList<>();
        coreCnt = 0;
        maxConnected = 0;
        minLine = Integer.MAX_VALUE;
        connected = 0;
        // 맵 초기화
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
                 
                // 코어 개수 카운트
                if (map[i][j] == 1) {
                    if (isSide(i,j)) {
                        connected++;
                    }
                    else {
                        coreCnt++;
                        cores.add(new int[] {i, j});
                        // 끝 단에 있는 코어만큼 연결된 코어 개수 증가
                    }
                }
            }
        }
    }
     
    private static void simulate(int cnt, int connectedCore, int lineSum) {
        if (cnt == coreCnt) {
            // 개수 저장
            if (connectedCore > maxConnected) {
                minLine = lineSum;
	            maxConnected = Math.max(maxConnected, connectedCore);
            }
            else if (connectedCore == maxConnected)
                minLine = Math.min(minLine, lineSum);
             
            return;
        }
         
        if (coreCnt-cnt + connectedCore == maxConnected && lineSum > minLine) return;
        if (coreCnt-cnt + connectedCore < maxConnected) return;  // 남은 코어를 모두 연결해도 이전보다 결과가 안좋을 때, 백트래킹
         
        
        // 연결 안하는 경우
        simulate(cnt+1, connectedCore, lineSum);
         
        // 연결을 시도하는 경우 (사방향)
        for (int j = 0; j < 4; j++) {
            int lc = 0;
            // 전선 연결
            int x = cores.get(cnt)[0];
            int y = cores.get(cnt)[1];
            boolean bConnected = false;
            int destX = -1;
            int destY = -1;
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[j];
                ny += dy[j];
                lc++;
                 
                if (isValidCoord(nx, ny) && map[nx][ny] == 0) {
                    if (isSide(nx, ny)) {
                        bConnected = true;
                        connectedCore++;
                        destX = nx;
                        destY = ny;
                        break;
                    }
                }
                else break; // 더이상 진행 불가
            }
             
            // 전선 맵에 세팅
            if (bConnected) {
                int rd = (j+2)%4;   // 방향 거꾸로 설정
                nx = destX;
                ny = destY;
                while (nx != x || ny != y) {
                    map[nx][ny] = 2;    // 0이 아니게 설정
                     
                    nx += dx[rd];
                    ny += dy[rd];
                }
            }
             
            simulate(cnt+1, connectedCore, lineSum + lc);
             
            // 세팅된 전선 롤백
            if (bConnected) {
                connectedCore--;
                int rd = (j+2)%4;   // 방향 거꾸로 설정
                nx = destX;
                ny = destY;
                while (nx != x || ny != y) {
                    map[nx][ny] = 0;    // 0이 아니게 설정
                     
                    nx += dx[rd];
                    ny += dy[rd];
                }
            }
        }
    }
 
    private static boolean isSide(int x, int y) {
        return x == 1 || x == N || y == 1 || y == N;
    }
 
    private static boolean isValidCoord(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N; 
    }
     
}
 
/**
  * 1767. 프로세서 연결하기
  * 
    [입력]
    테스트케이스의 수
    코어의 수   // 7 <= N <= 12
    전체 맵[0,1]
**/