import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 0; tc < T; tc++) {
            // 테스트케이스 수행
            int[][] game = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    game[i][j] = Integer.parseInt(input[j]);
                }
            }
             
//          // game 출력
//          for (int i = 0; i < 9; i++) {
//              for (int j = 0; j < 9; j++) {
//                  System.out.print(game[i][j] + " ");
//              }
//              System.out.println();
//          }
             
            int[] rowSum = new int[9];
            int[] colSum = new int[9];
            int[][] cellSum = new int[3][3];
             
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    rowSum[i] += game[i][j];    // i행의 합
                    colSum[j] += game[i][j];    // j행의 합
                    cellSum[i/3][j/3] += game[i][j];    // 9등분한 셀의 합
                }
            }
             
            boolean bOutput = true;
            for (int i = 0; i < 9; i++) {
                if (!bOutput) break;
                if (rowSum[i] != 45 || colSum[i] != 45) {
                    bOutput = false;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!bOutput) break;
                    if (cellSum[i][j] != 45) {
                        bOutput = false;
                        break;
                    }
                }
            }
 
            // 출력
            bw.write("#");
            bw.write(Integer.toString(tc+1));
            if (bOutput) {
                bw.write(" 1\n");
            }
            else {
                bw.write(" 0\n");
            }
        }
         
        bw.flush();
    }
}