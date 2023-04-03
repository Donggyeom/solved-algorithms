import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			char[] actions = br.readLine().toCharArray();
			int[] numbers = null;
			//new int[Integer.parseInt(br.readLine())];
			br.readLine();
			Deque<Integer> deque = new LinkedList<Integer>(Arrays.stream(br.readLine().replaceAll("[\\[\\]]", "").split(","))
					.filter(s -> s.length() != 0)
					.map(Integer::parseInt)
					.collect(Collectors.toList()));
			boolean bFront = true;
			boolean bError = false;
			for (char action : actions) {
				if (bError) break;
				
				switch (action) {
				case 'R':
					bFront = !bFront;
					break;
				case 'D':
					if (deque.isEmpty()) {
						bError = true;
					}
					else {
						 if (bFront) {
							 deque.pollFirst();
						 }
						 else {
							 deque.pollLast();
						 }
					}
				}
			}
			
			if (bError) {
				bw.append("error");
			}
			else {
				if (bFront) {
					bw.append(deque.toString().replaceAll(" ", ""));
				}
				else {
					List<Integer> list = new ArrayList<>();
					int size = deque.size();
					for (int i = 0; i < size; i++) {
						list.add(deque.pollLast());
					}
					bw.append(list.toString().replaceAll(" ", ""));
				}
			}
			bw.append("\n");
			
		} // tc-loop end
		bw.flush();
	}
}



/**
  * 5430. AC
  * 
**/