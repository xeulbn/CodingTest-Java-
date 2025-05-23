
import java.util.*;
import java.io.*;


class Solution{
    public static int t;
    public static int sum;
    
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
        
        for(int i=0;i<t;i++){
            sum=0;
            for(int j=0;j<10;j++){
            	int x=sc.nextInt();
                if(x%2!=0){
                    sum+=x;
                }
        	}
            System.out.println("#"+(i+1)+" "+sum);
        }
	}
}