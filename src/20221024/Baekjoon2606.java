import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Node[] nodeArr = new Node[N];
		for (int i = 0; i < N; i++) {
			nodeArr[i] = new Node();
			nodeArr[i].num = i;
		}
		
		for (int i = 0; i < E; i++) {
			String[] input = br.readLine().split(" ");
			
			nodeArr[Integer.parseInt(input[0]) - 1].adj.add(Integer.parseInt(input[1]) - 1);
			nodeArr[Integer.parseInt(input[1]) - 1].adj.add(Integer.parseInt(input[0]) - 1);
		}
		
		int answer = -1;
		
		boolean[] bVisited = new boolean[N];
		Stack<Node> dfs = new Stack<>();
		dfs.push(nodeArr[0]);
		while ( !dfs.isEmpty() ) {
			
			Node idx = dfs.pop();
			
			if ( !bVisited[idx.num] ) {
				bVisited[idx.num] = true;
				answer++;
				
				for (int adjNum : idx.adj) {
					if (bVisited[adjNum] == false) {
						dfs.push(nodeArr[adjNum]);
					}
				}
				idx.adj.clear();
			}
		}
		
		System.out.println(answer);
	}
}

class Node {
	int num;
	ArrayList<Integer> adj;
	
	public Node() {
		adj = new ArrayList<Integer>();
	}
}

/**
  * 2606. 바이러스
  * 
**/