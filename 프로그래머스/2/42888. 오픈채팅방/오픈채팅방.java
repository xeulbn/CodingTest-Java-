import java.util.*;

class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};
            List<String> answerList = new ArrayList<>();

            Map<String, String> idNameMap = new HashMap<>();
            for(int i=0;i<record.length;i++){
                String[] str = record[i].split(" ");

                if(str[0].equals("Enter")){
                    idNameMap.put(str[1], str[2]);
                }else if(str[0].equals("Change")){
                    idNameMap.put(str[1],str[2]);
                }
            }
            for(int i=0;i<record.length;i++){
                String[] str=record[i].split(" ");
                if(str[0].equals("Enter")){
                    answerList.add(idNameMap.get(str[1])+"님이 들어왔습니다.");
                }else if(str[0].equals("Leave")){
                    answerList.add(idNameMap.get(str[1])+"님이 나갔습니다.");
                }
            }

                        answer=answerList.stream().toArray(String[]::new);


            return answer;
        }
    }