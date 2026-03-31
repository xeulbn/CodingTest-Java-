import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int munzaCnt = Integer.parseInt(st.nextToken());
        String numberStr = br.readLine();

        StringBuilder answer = new StringBuilder();
        String[] num = new String[] {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
        
        for(int i=0;i<munzaCnt;i++){
            int check =0;

            for(int j=0;j<8;j++){
                int notEqual=0;
                
                for (int k = 0; k < 6; k++) {
                    if (numberStr.charAt(k) != num[j].charAt(k)) {
                        notEqual++;
                        if (notEqual > 1) {
                            break;
                        }
                    }
                }

                if(notEqual==0||notEqual==1){
                    answer.append((char)(j+'A'));
                    check=1;
                    break;
                }
            }
            if (check == 0) {
                System.out.println(i+1);
                return;
            }else{
                numberStr=numberStr.substring(6);
            }
        }

        System.out.println(answer);        
    }
}