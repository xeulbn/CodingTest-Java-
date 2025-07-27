import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static String[] option;
    public static List<Character> shortKey;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        option=new String[n];
        for(int i=0;i<n;i++){
            option[i]=br.readLine();

        }

        shortKey=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] charArr=option[i].toCharArray();
            char first = Character.toLowerCase(charArr[0]);
            if(!shortKey.contains(first)){
                shortKey.add(first);
                option[i] = "[" + option[i].charAt(0) + "]" + option[i].substring(1);
                continue;
            }else{
                boolean found=false;
                String[] words = option[i].split(" ");
                int idx=0;
                for(String word:words){
                    char c = Character.toLowerCase(word.charAt(0));
                    if(!shortKey.contains(c)){
                        shortKey.add(c);
                        words[idx]="["+word.charAt(0)+"]"+word.substring(1);
                        found=true;
                        break;
                    }
                    idx++;
                }


                if(!found){
                    char[]chars=option[i].toCharArray();
                    for(int j=0;j<chars.length;j++){
                        char c = Character.toLowerCase(chars[j]);
                        if(c!=' '&&!shortKey.contains(c)){
                            shortKey.add(c);
                            StringBuilder sb= new StringBuilder();
                            for(int k=0;k<chars.length;k++){
                                if(k==j){
                                    sb.append("[").append(chars[k]).append("]");
                                }else{
                                    sb.append(chars[k]);
                                }
                            }
                            option[i]=sb.toString();
                            break;
                        }
                    }
                }else{
                    option[i]=String.join(" ",words);
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(option[i]);
        }


    }
}
