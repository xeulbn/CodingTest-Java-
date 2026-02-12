import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static ArrayList<Node> list;

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
        StringTokenizer st=new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        list= new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            list.add(new Node(x,y));
        }

        List<Node> sorted =list.stream().sorted((a,b)->{
            if(a.x!=b.x){
                return a.x-b.x;
            }
            return a.y-b.y;
        }).collect(Collectors.toList());

        StringBuilder sb=new StringBuilder();
        for(Node node : sorted){
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }
        System.out.println(sb);
    }
    
}