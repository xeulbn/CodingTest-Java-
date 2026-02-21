import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String id = st.nextToken();
        String[][] emoji = makeEmoji(id);

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                sb.append(emoji[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static String[][] makeEmoji(String id){
        String[][] emo = new String[3][3];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1&&j==1){
                    emo[i][j]=":"+id+":";
                }else{
                    emo[i][j]=":fan:";
                }
            }
        }

        return emo;
    }
}