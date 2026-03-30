import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static final int OPEN_YEAR = 1946;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int answer = Math.abs(year-OPEN_YEAR);
        System.out.println(answer);
    }
}