import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int[] arr;
    public static Set<Integer> set;
    public static List<Integer> sorted;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        arr=new int[n];
        set=new HashSet<>();

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        sorted=new ArrayList<>();
        sorted= set.stream().sorted((a,b)->a-b).collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<sorted.size();i++){
            map.put(sorted.get(i),i);
        }
        
        StringBuilder sb =new StringBuilder();
        for(int var : arr){
            sb.append(map.get(var)).append(" ");
        }
        System.out.println(sb);
        
    }
    
}