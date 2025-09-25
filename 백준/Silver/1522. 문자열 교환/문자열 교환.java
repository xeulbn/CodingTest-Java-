import java.io.*;
import java.util.*;

public class Main {

    public static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        arr = new String[str.length()];
        arr=str.split("");


        int aMax =0 ;
        int aTotal =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("a")){
                aTotal++;
            }
        }


        for(int i=0;i<arr.length;i++){
            int aCnt =0 ;

            for(int j=0;j<aTotal;j++){
                int index = i+j;
                if(i+j>=arr.length){
                    index= i+j-arr.length;
                }
                if(arr[index].equals("a")){
                    aCnt++;
                }
                if(aCnt>aMax){
                    aMax=aCnt;
                }
            }
        }

        System.out.println(aTotal-aMax);
    }
}
