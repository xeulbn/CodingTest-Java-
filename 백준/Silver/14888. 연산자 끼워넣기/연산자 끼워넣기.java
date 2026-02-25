import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n;
    public static int[] number;
    public static int[] operator; //순서대로 +,-,*,/
    public static int count=0;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        number=new int[n];
        for(int i=0;i<n;i++){
            number[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());

        operator = new int[4];
        for(int i=0;i<4;i++){
            operator[i]=Integer.parseInt(st.nextToken());
        }
        dfs(1,number[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int value){
        
        if(depth == n){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        if(operator[0] > 0){
            operator[0]--;
            dfs(depth+1, value + number[depth]);
            operator[0]++;
        }

        if(operator[1] > 0){
            operator[1]--;
            dfs(depth+1, value - number[depth]);
            operator[1]++;
        }

        if(operator[2] > 0){
            operator[2]--;
            dfs(depth+1, value * number[depth]);
            operator[2]++;
        }

        if(operator[3] > 0){
            operator[3]--;
            dfs(depth+1, value / number[depth]);
            operator[3]++;
        }
        
    }
}