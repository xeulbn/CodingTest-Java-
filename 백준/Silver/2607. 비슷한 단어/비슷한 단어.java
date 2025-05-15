import java.io.*;
import java.util.*;


public class Main {
    public static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer=0;
        n=Integer.parseInt(br.readLine());
        String targetStr= br.readLine();

        for(int i=1;i<n;i++){
            String word= br.readLine();
            if(isSimilar(targetStr,word)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static boolean isSimilar(String tget, String a) {
        int[] index=new int[26];

        for(char ch :tget.toCharArray()){
            index[ch-'A']++;
        }
        for(char ch:a.toCharArray()){
            index[ch-'A']--;
        }

        int plus=0;
        int minus=0;

        for(int i:index){
            if(i>0){
                plus+=i;
            }else if(i<0){
                minus-=i;
            }
        }
        return(plus<=1&&minus<=1);
    }

}
