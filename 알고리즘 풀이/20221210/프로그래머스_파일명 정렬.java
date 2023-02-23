import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        answer = Arrays.stream(files).sorted((s1, s2) -> {
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			
			int length1 = s1.length();
			int length2 = s2.length();
			int idx1 = 0;
			int idx2 = 0;
			char[] arr1 = s1.toCharArray();
			char[] arr2 = s2.toCharArray();
			while (true) {
				boolean bDigit1 =Character.isDigit(arr1[idx1]);
				boolean bDigit2 = Character.isDigit(arr2[idx2]);
				if ( bDigit1 && bDigit2 ) {
					int idxBegin1 = idx1;
					int idxBegin2 = idx2;
					while ( idx1 < length1 ) {
						if ( !Character.isDigit(arr1[idx1]) ) break;
						else idx1++;
					}
					while ( idx2 < length2 ) {
						if ( !Character.isDigit(arr2[idx2]) ) break;
						else idx2++;
					}
					int v1 = Integer.parseInt(s1.substring(idxBegin1, idx1++));
					int v2 = Integer.parseInt(s2.substring(idxBegin2, idx2++));
					if (v1 == v2) break;
					else
						return v1-v2;
				}
				else if ( bDigit1 ) {
					return -1;
				}
				else if ( bDigit2 ) {
					return 1;
				}
				
				// 문자열 끝
				if (idx1 >= length1 && idx2 >= length2) {
					return 0;
				}
				else if (idx1 >= length1) {
					return -1;
				}
				else if (idx2 >= length2) {
					return 1;
				}
				
				// 문자열 비교
				if (arr1[idx1] != arr2[idx2]) return arr1[idx1] - arr2[idx2];
				else {
					idx1++;
					idx2++;
				}
			}
			return 0;
		}).toArray(String[]::new);
        
        
        return answer;
    }
}