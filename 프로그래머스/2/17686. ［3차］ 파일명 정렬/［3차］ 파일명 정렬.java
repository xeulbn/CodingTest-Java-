import java.util.Arrays;

class Solution {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            answer = Arrays.stream(files).sorted((v1,v2)->{
                String head1 = v1.split("[0-9]")[0];
                String head2 = v2.split("[0-9]")[0];
                int tmp = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(tmp==0){
                    int n1 = extractNumber(v1, head1.length());
                    int n2 = extractNumber(v2, head2.length());
                    return Integer.compare(n1, n2);
                }
                return tmp;
            }).toArray(String[]::new);;

            return answer;
    }
    
    public int extractNumber(String str1, int headLength) {
        int n= str1.length();
        int i= headLength;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i<n&&Character.isDigit(str1.charAt(i)) && cnt < 5){
            sb.append(str1.charAt(i));
            i++;
            cnt++;
        }
        
        return sb.length()==0?0:Integer.parseInt(sb.toString());

    }
}