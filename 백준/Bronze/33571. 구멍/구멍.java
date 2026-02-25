import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static Set<Character> oneSpace =
        Set.of('A','a','b','D','d','e','g','O','o','P','p','Q','q','R','@');

    private static Set<Character> twoSpace = Set.of('B');
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer=0;
        for(int i=0;i<str.length();i++){
            answer=answer+findSpace(str.charAt(i));
        }
        System.out.println(answer);
    }

    public static int findSpace(char chr){
        if(oneSpace.contains(chr)){
            return 1;
        }else if(twoSpace.contains(chr)){
            return 2;
        }else{
            return 0;
        }
    }
}