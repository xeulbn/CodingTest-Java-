import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bigNumber = br.readLine();

        long remain = 0;
        for(int i=0;i<bigNumber.length();i++){
            remain = (remain*10+(bigNumber.charAt(i)-'0'))%20000303;
        }
        System.out.println(remain);
    }
    
}