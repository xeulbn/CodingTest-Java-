import java.util.*;
import java.io.*;

class Solution{
    
    static int x,y,n;
    static int cnt;
    
	public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int i = 0 ; i < T; i++) {
            st= new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
			cnt=0;
             
            if(x>y) {
                dfs(x,y);   
            }else {
                dfs(y,x);
            }
             
            sb.append(cnt).append("\n");
		}
        System.out.println(sb);
        
	}
    
    public static void dfs (int x , int y) {
        int sum = x+y;
        cnt++;
        if(sum>n) {
            return;
        }
        dfs(sum,x);
    }
}