import java.util.*;
import java.math.*;
import java.io.*;

class Main {

    public static int n;
    public static int k;
    public static String[] numberStr;

    public static int[] numbers;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        numberStr= new String[n];
        BigInteger[] gain = new BigInteger[36];
        BigInteger totalSum = BigInteger.ZERO;
        Arrays.fill(gain,BigInteger.ZERO);
        
        for(int i=0;i<n;i++){
            numberStr[i]=br.readLine();

            totalSum= totalSum.add(new BigInteger(numberStr[i],36));

            int len = numberStr[i].length();
            BigInteger place = BigInteger.ONE;
            for(int j=len-1;j>=0;j--){
                char ch = numberStr[i].charAt(j);
                int value = charToValue(ch);

                int diff = 35-value;
                if(diff>0){
                    gain[value]=gain[value].add(place.multiply(BigInteger.valueOf(diff)));
                }
                place = place.multiply(BigInteger.valueOf(36));
            }
        }
        k=Integer.parseInt(br.readLine());

        //정렬 후 큰거 Pick하기
        Arrays.sort(gain,Collections.reverseOrder());
        
        BigInteger extra = BigInteger.ZERO;
        numbers= new int[n];

        for(int i=0;i<k;i++){
            extra = extra.add(gain[i]);
        }
        
        BigInteger answer = totalSum.add(extra);
        System.out.println(answer.toString(36).toUpperCase());
    }

    public static int charToValue(char ch){
        if('0'<=ch&&'9'>=ch){
            return ch-'0';
        }
        return ch-'A'+10;
    }
}