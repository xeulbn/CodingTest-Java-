import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n;
    public static int l;
    public static int k;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int hardCount = 0; 
        int easyCount = 0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());

            if (hard<=l) {
                hardCount++;
            } else if (easy<=l) {
                easyCount++;
            }
        }

        int solveHard = Math.min(hardCount, k);
        int remain = k-solveHard;
        int solveEasy = Math.min(easyCount, remain);
        int answer = solveHard * 140 + solveEasy * 100;
        System.out.println(answer);
    }
}