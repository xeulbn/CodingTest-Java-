import java.util.*;

class Culture{
    
    String x,y,z;
    
    boolean isAdd;
    
    Culture(String expression){
        
        StringTokenizer st= new StringTokenizer(expression);
        x=st.nextToken();
        isAdd=st.nextToken().equals("+");
        y=st.nextToken();
        st.nextToken();
        z=st.nextToken();
    }
    
    String calculate(int radix,boolean check){
        int xx= Integer.parseInt(x,radix);
        int yy = Integer.parseInt(y,radix);
        
        if(!isAdd){
            yy*=-1;
        }
        
        if(!check||Integer.parseInt(z,radix)==xx+yy){
            return Integer.toString(xx+yy,radix);
        }
        
        return "Wrong";
    }
}

class Solution {
    public String[] solution(String[] expressions) {
        
        List<Culture> cultureList = new ArrayList<>();
        for(String expression : expressions){
            cultureList.add(new Culture(expression));
        }
        
        int limit = 2;
        
        for(String expression : expressions){
            for(int i=0;i<expression.length();i++){
                char c= expression.charAt(i);
                if('0'<=c && c<='9'){
                    limit=Math.max(limit, c-'0'+1);
                }
            }
        }
        
        boolean[] failed = new boolean [10];
        
        for(Culture culture : cultureList){
            if(culture.z.equals("X")){
                continue;
            }
            
            for(int i=limit;i<=9;i++){
                if(failed[i]){
                    continue;
                }
                
                if(culture.calculate(i,true).equals("Wrong")){
                    failed[i]=true;
                }
            }
        }
        
        List<String> answerList= new ArrayList<>();
        StringBuilder sb;
        
        for(Culture culture : cultureList){
            if(!culture.z.equals("X")){
                continue;
            }
            
            String tmp ="";
            boolean flag = false;
            
            sb=new StringBuilder();
            sb.append(culture.x).append(culture.isAdd ? " + ":" - ").append(culture.y).append( " = ");
        
            for(int i=limit;i<=9;i++){
                if(failed[i]){
                    continue;
                }
                
                if(tmp.length()==0){
                    tmp=culture.calculate(i,false);
                }else if(!tmp.equals(culture.calculate(i,false))){
                    flag= true;
                    break;
                }
            }
            
            
            if(flag||tmp.length()==0){
                sb.append("?");
            }else{
                sb.append(tmp);
            }
            
            answerList.add(sb.toString());
        }
        
        String[] answer = new String[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=answerList.get(i);
        }
        
        return answer;
    }
}