import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		String[] numbers = input.split("[+-]");
		String[] operations;
		Pattern pattern = Pattern.compile("([+-])");
		Matcher matcher = pattern.matcher(input);
		
		int total = Integer.parseInt(numbers[0]);
		boolean plus = true;
		for (int i = 1; i < numbers.length; i++) {
			
			if (!plus) {
				total -= Integer.parseInt(numbers[i]); 
			}
			else {
				matcher.find();
				String op = matcher.group();
				
				if ("-".equals(op)) {
					plus = false;
				};
				
				if (plus) {
					total += Integer.parseInt(numbers[i]); 
				}
				else {
					total -= Integer.parseInt(numbers[i]); 
				}
			}
		}
		System.out.println(total);
	}
}

/**
  * 1541. 잃어버린 괄호
  * 
**/