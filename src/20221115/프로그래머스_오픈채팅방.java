import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> nicknameMap = new HashMap<>();
        
        String[][] log = new String[record.length][2];
        String[] defualtMessages = {
            "님이 들어왔습니다.",
            "님이 나갔습니다."
        };
        int cnt = 0;
        for (String str : record) {
            String[] input = str.split(" ");
            if ("Change".equals(input[0])) {
                nicknameMap.put(input[1], input[2]);
                
                continue;
            }
            
            log[cnt] = new String[2];
            log[cnt][0] = input[1];   // uid 입력
            if ("Enter".equals(input[0])) {
                log[cnt][1] = defualtMessages[0];
                nicknameMap.put(input[1], input[2]);
            }
            else if ("Leave".equals(input[0])) {
                log[cnt][1] = defualtMessages[1];
            }
            cnt++;
        }
        
        answer = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            answer[i] = nicknameMap.get(log[i][0]).concat(log[i][1]);
        }
        return answer;
    }
}