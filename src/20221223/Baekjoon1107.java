import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String nString = br.readLine();
		int nStringLength = nString.length();
		int N = Integer.parseInt(nString);
		int M = Integer.parseInt(br.readLine());
		
		if (M == 10) {
			System.out.println(Math.abs(N-100));
		}
		else {
			ArrayList<Integer> buttons = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
			if (M != 0) {
				List<Integer> brokenButtons = Arrays.stream(br.readLine().split(" "))
						.map(Integer::parseInt)
						.collect(Collectors.toList());
				buttons.removeAll(brokenButtons);
			}
			
			List<Counter> numbers = new ArrayList<>();
			// 초기값 100
			numbers.add(new Counter(100, 0));
			// 한자리 작은 수 중 가장 큰 수
			if (nStringLength > 1) {
				StringBuilder sb = new StringBuilder();
				String biggestNumber = ""; 
				Optional<Integer> optionalNumber = buttons.stream()
						.max(Comparator.naturalOrder());
				if (optionalNumber.isPresent()) {
					biggestNumber = optionalNumber.get().toString();
					for (int i = 0; i < nStringLength-1; i++) {
						sb.append(biggestNumber);
					}
					numbers.add(new Counter(Integer.parseInt(sb.toString()), nStringLength-1));
				}
			}
			// 한 자리 큰 수 중 가장 작은 수
			if (nStringLength < 6) {
				StringBuilder sb = new StringBuilder();
				String smallestNumber = "";
				Optional<Integer> optionalNumber = buttons.stream()
						.filter(i -> i != 0)
						.min(Comparator.naturalOrder());
				if (optionalNumber.isPresent()) {
					smallestNumber = optionalNumber.get().toString();
					sb.append(smallestNumber);
					if (buttons.contains(0)) {
						smallestNumber = "0";
					}
					for (int i = 1; i < nStringLength+1; i++) {
						sb.append(smallestNumber);
					}
					numbers.add(new Counter(Integer.parseInt(sb.toString()), nStringLength+1));
				}
			}
			// 같은 자리 수 모든 조합
			Queue<Integer> que = new LinkedList<>();
			que.offer(0);
			for (int i = 0; i < nStringLength; i++) {
				int length = que.size();
				for (int j = 0; j < length; j++) {
					int number = que.poll();
					for (Integer button : buttons) {
						int newNumber = number*10;
						que.offer(newNumber+button);
					}
				}
			}
			while (!que.isEmpty()) {
				int number = que.poll();
				numbers.add(new Counter(number, nStringLength));
			}
			
			int answer = numbers.stream()
					.mapToInt(counter -> counter.count + (int) Math.abs(N - counter.number))
					.min()
					.getAsInt();
			
			System.out.println(answer);
		}
	}
}

class Counter {
	int number;
	int count;
	
	public Counter(int number, int count) {
		this.number = number;
		this.count = count;
	}
}

/**
  * 1107. 리모컨
  * 
**/