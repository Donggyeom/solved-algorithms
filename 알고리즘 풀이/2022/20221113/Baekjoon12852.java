import java.io.*;
import java.util.*;
class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(Integer.toString(N));
		sb.append(" ");
		
		Queue<History> bfs = new LinkedList<>();
		History h = new History();
		h.N = N;
		h.list = new ArrayList<>();
		h.list.add(N);
		bfs.offer(h);
		History answer = null;
		boolean[] visited = new boolean[N+1];
		BFS_LOOP:
		while ( !bfs.isEmpty() ) {
			Queue<History> nextQue = new LinkedList<>();
			while ( !bfs.isEmpty() ) {
				h = bfs.poll();
				//System.out.print(h.N + " ");
				
				if (visited[h.N]) continue;
				
				visited[h.N] = true;
				if (h.N == 1) {
					answer = h;
					break BFS_LOOP;
				}
				else { 			
					if (h.N % 3 == 0 && !visited[h.N/3]) {
						History newHist = (History) h.clone();
						newHist.N = h.N/3;
						newHist.list.add(newHist.N);
						nextQue.offer(newHist);
					}
					if (h.N % 2 == 0 && !visited[h.N/2]) {
						History newHist = (History) h.clone();
						newHist.N = h.N/2;
						newHist.list.add(newHist.N);
						nextQue.offer(newHist);
					}
					if (!visited[h.N-1]) {
						History newHist = (History) h.clone();
						newHist.N = h.N-1;
						newHist.list.add(newHist.N);
						nextQue.offer(newHist);
					}
				}
			}
			bfs = nextQue;
			//System.out.println();
		}
		System.out.println(answer.list.size()-1);

		for (int i : answer.list) {
			System.out.print(i);
			System.out.print(" ");
		}
	}	
}

class History implements Cloneable{
	int N;
	ArrayList<Integer> list;
	
	@Override
	public String toString() {
		return N+list.toString();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		History newHistory = new History();
		newHistory.N = N;
		newHistory.list = (ArrayList<Integer>) list.clone();
		
		return newHistory;
	}
}



/**
  * 12852. 1로 만들기 2
  * 
**/