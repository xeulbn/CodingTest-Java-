import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String width  = "@".repeat(5 * n); 
        String length = "@".repeat(n);   

        StringBuilder sb = new StringBuilder();

        append(sb, width, n);
        append(sb, length, n);
        append(sb, width, n);
        append(sb, length, n);
        append(sb, length, n);

        System.out.print(sb);
    }

    private static void append(StringBuilder sb, String line, int times) {
        for (int i = 0; i < times; i++) {
            sb.append(line).append('\n');
        }
    }
}