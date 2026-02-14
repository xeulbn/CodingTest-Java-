import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static List<Node> arr;

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Node(x,y));
        }

        List<Node> answer = new ArrayList<>();
        
        answer=arr.stream().sorted((a,b)->{
            if(a.y != b.y){
                return a.y-b.y;
            }else{
                return a.x-b.x;
            }
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(Node node : answer){
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }

        System.out.println(sb);
    }
    
}