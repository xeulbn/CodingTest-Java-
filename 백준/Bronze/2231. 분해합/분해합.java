import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=0;i<n;i++){
            if(checkIsProducer(i,n)){
                answer=i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkIsProducer (int x,int target){
        int sum=0;
        int total=x;
        while(x>0){
            sum=sum+x%10;
            x=x/10;
        }
        if(total+sum==target){
            return true;
        }
        return false;
    }
}