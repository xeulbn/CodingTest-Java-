import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static final int REGULAR_SIZE = 8;
    private static final int SMALL_SIZE = 3;
    private static final int STUDENT_NUMBER = 28;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int regular = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int small = Integer.parseInt(st.nextToken());

        int totalCupcake = regular * REGULAR_SIZE + small * SMALL_SIZE;

        System.out.println(totalCupcake-STUDENT_NUMBER);
    }
}