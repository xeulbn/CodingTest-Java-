import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        String[] track =new String[n];
        for(int i=0;i<n;i++){
            track[i] = st.nextToken();
        }
        String hellobit = br.readLine();

        int answer=0;
        for(int i=0;i<n;i++){
            if(track[i].equals(hellobit)){
                answer+=1;
            }
        }
        System.out.println(answer);
        
    }
}