import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(i%10==9&&i>0){
                sb.append(str.charAt(i)).append("\n");
            }else{
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb);
    }
}