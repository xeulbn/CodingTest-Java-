import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    //영어 단어를 유사 라틴어 단어로 번역하는 프로그램을 작성하세요.
    //표에 나와 있는 대로 어미가 끝나지 않으면 단어 끝에 '-us'
    //첫 번째 줄에는 영어 단어의 개수인 정수 n 
    //n 개의 줄에는 각각 영어 단어가 하나씩,단어는 모두 소문자
    //한 줄에 정확히 하나의 의사 라틴어 단어를 출력

    public static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            String word = br.readLine();
            sb.append(changeWord(word)).append("\n");
        }

        System.out.println(sb.toString());
        
    }

    public static String changeWord(String word){
        if(word.endsWith("ne"))
            return word.substring(0, word.length() - 2) + "anes";
        if(word.endsWith("a"))
            return word.substring(0, word.length() - 1) + "as";
        if(word.endsWith("i") || word.endsWith("y"))
            return word.substring(0, word.length() - 1) + "ios";
        if(word.endsWith("l"))
            return word.substring(0, word.length() - 1) + "les";
        if(word.endsWith("n"))
            return word.substring(0, word.length() - 1) + "anes";
        if(word.endsWith("o"))
            return word.substring(0, word.length() - 1) + "os";
        if(word.endsWith("r"))
            return word.substring(0, word.length() - 1) + "res";
        if(word.endsWith("t"))
            return word.substring(0, word.length() - 1) + "tas";
        if(word.endsWith("u"))
            return word.substring(0, word.length() - 1) + "us";
        if(word.endsWith("v"))
            return word.substring(0, word.length() - 1) + "ves";
        if(word.endsWith("w"))
            return word.substring(0, word.length() - 1) + "was";
    
        return word + "us";
    }
        
}