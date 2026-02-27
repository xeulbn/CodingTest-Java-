import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n,q;
    public static List<List<int[]>> usado;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());

        usado=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            usado.add(new ArrayList<>());
        }
        
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            usado.get(start).add(new int[]{end,value});
            usado.get(end).add(new int[]{start,value});
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            sb.append(bfs(key,value)).append("\n");
        }
        System.out.println(sb);
        
    }

    public static int bfs(int k, int start){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[start]=true;
        q.offer(start);

        int answer=0;
        while(!q.isEmpty()){
            int cur= q.poll();
            
            for(int[] next : usado.get(cur)){
                int nextNode = next[0];
                int nextValue = next[1];

                if(!visited[nextNode]&&nextValue>=k){
                    visited[nextNode]=true;
                    answer++;
                    q.offer(nextNode);
                }
            }
        }
        return answer;
    }

}