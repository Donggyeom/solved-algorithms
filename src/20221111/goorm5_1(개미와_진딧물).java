import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		ArrayList<Point> antList = new ArrayList<>();
		ArrayList<Point> aphidList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(input[j]);
				Point p = new Point(i, j);
				if (n == 1) {
					antList.add(p);
				}
				else if(n == 2) {
					aphidList.add(p);
				}
			}
		}
		
		int result = antList.size();
		for (Point ant : antList) {
			boolean b = true;
			for (Point aphid : aphidList) {
				if (Point.getDistance(ant, aphid) <= M) {
					b = false;
					break;
				}
			}
			if (b) result--;
		}
		
		System.out.println(result);
	}
		
}

class Point {
	int x;
	int y;
	
	public Point(int xi, int yi) {
		x = xi;
		y = yi;
	}
	
	public static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y); 
	}
}