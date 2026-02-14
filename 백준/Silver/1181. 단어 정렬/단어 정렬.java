import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static Set<String> set;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        set= new HashSet<>();
        for (int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        List<String> sorted = set.stream().sorted((a,b)->{
            if(a.length() != b.length()){
                return a.length()-b.length();
            }else{
                return a.compareTo(b);
            }
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(String str : sorted){
            sb.append(str).append("\n");
        }
        
        System.out.print(sb);
        
    }
    
}