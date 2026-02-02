import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int digits = String.valueOf(n).length();
        int start = Math.max(0, n - 9 * digits);

        int answer = 0;
        for (int i = start; i < n; i++) {
            if (isGenerator(i, n)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGenerator(int x, int target) {
        int sum = x;
        int tmp = x;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum == target;
    }
}
