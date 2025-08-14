import java.io.*;
import java.util.regex.Pattern;

public class Main {

    public static int t;
    public static final Pattern p = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        t=Integer.parseInt(br.readLine());

        while(t-->0){
            if(p.matcher(br.readLine()).matches()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);




    }
}
