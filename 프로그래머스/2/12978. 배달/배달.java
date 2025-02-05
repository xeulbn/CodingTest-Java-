class Solution {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;

    
    public int solution(int N, int[][] road, int K) {
        
        cnt=0;
        
        arr=new int[N+1][N+1];
        
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                arr[i][j]=500001;
            }
        }
        
        for(int i=0;i<road.length;i++){
            if(arr[road[i][0]][road[i][1]]>road[i][2]){
                arr[road[i][0]][road[i][1]]=road[i][2];
                arr[road[i][1]][road[i][0]]=road[i][2];
            }
        }
        
        dist= new int[N+1];
        for(int i=2;i<N+1;i++){
            dist[i]=500001;
        }
        
        visited= new boolean[N+1];
        visited[1]=true;
        
        dijkstra(N,K);
        
        return cnt;
    }
    
    static void dijkstra(int n,int k){
        for(int i=1;i<n;i++){
            int min = 500001;
            int index=1;
            
            for(int j=2;j<=n;j++){
                if(!visited[j]&&min>dist[j]){
                    index=j;
                    min=dist[j];
                }
            }
            visited[index]=true;
        
            for(int j=2;j<=n;j++){
                if(dist[j]>dist[index]+arr[index][j]){
                    dist[j]=dist[index]+arr[index][j];
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            if(dist[i]<=k){
                cnt++;
            }
        }
    }
}