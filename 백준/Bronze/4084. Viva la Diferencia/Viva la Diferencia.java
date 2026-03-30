import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        StringBuilder sb= new StringBuilder();
        while(true){
            int[] numbers = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                numbers[i]=Integer.parseInt(st.nextToken());
            }
            
            if(numbers[0]==0&&numbers[1]==0&&numbers[2]==0&&numbers[3]==0){
                break;
            }

            int answer= check(numbers);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int check(int[] nums){
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[3];

        int value=0;
        
        while(true){
            if(a==b && b==c && c==d){
                break;
            }

            int tmp = a;
            a=Math.abs(a-b);
            b=Math.abs(b-c);
            c=Math.abs(c-d);
            d=Math.abs(d-tmp);
            value+=1;
        }
        return value;
        
    }
}