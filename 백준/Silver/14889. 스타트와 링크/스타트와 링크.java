import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int[][] ability;
    public static boolean[] picked;
    public static int abilityDiff=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        ability = new int[n][n];
        picked = new boolean[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        picked[0]=true; 
        dfs(1,1); //스타트팀을 기준으로 돌리자

        System.out.println(abilityDiff);
    }

    public static void dfs(int start,int cnt){
        if(cnt==n/2){
            abilityDiff=Math.min(abilityDiff,calcDiff());
            return;
        }
        for(int i=start;i<n;i++){
            picked[i]=true;
            dfs(i+1,cnt+1);
            picked[i]=false;
        }
        
    }

    public static int calcDiff(){
        int startScore=0;
        int linkScore=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(picked[i]&&picked[j]){
                    startScore=startScore+ability[i][j]+ability[j][i];
                }else if(!picked[i]&&!picked[j]){
                    linkScore = linkScore+ability[i][j]+ability[j][i];
                }
            }
        }

        return Math.abs(startScore-linkScore);
    }


    
}