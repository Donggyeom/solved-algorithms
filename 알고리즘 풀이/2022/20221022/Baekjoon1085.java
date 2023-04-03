import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		int w = Integer.parseInt(input[2]);
		int h = Integer.parseInt(input[3]);
		
		int dx = Math.min(x, w-x);
		int dy = Math.min(y, h-y);
		
		System.out.println(Math.min(dx, dy));
		
		// System.out.println();
	}
}


/**
  * 1085. 직사각형에서 탈출
  * 
  *   직사각형의 경계선까지 가는 거리의 최솟값
  *   왼쪽 아래 꼭짓점 (0, 0)
  *   오른쪽 위 꼭짓점 (w, h)
  *   
  *   현재 위치 좌표 (x, y)
  *  
  * 입력
  *   x, y, w, h
  *   
  * 출력
  *   직사각형의 경계선까지 가는 거리의 최솟값
  * 
**/