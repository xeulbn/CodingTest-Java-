import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder answer = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                answer.append(Character.toUpperCase(str.charAt(i)));
            }else{
                answer.append(Character.toLowerCase(str.charAt(i)));
            }
        }

        System.out.println(answer.toString());
    }
}