import java.io.*;

public class Main {
    public static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S=br.readLine();

        int zeroCnt=0;
        int oneCnt=0;

        if(S.charAt(0)=='0'){
            zeroCnt++;
        }else{
            oneCnt++;
        }

        for(int i=1;i<S.length();i++){
            if(S.charAt(i)!=S.charAt(i-1)){
                if(S.charAt(i)=='0'){
                    zeroCnt++;
                }else{
                    oneCnt++;
                }
            }
        }
        System.out.println(Math.min(zeroCnt,oneCnt));

    }
}
