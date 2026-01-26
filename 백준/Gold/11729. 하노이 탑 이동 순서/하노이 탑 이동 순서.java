import java.util.*;
import java.io.*;

class Main {
    static long answer;
    static Deque<Integer> a;
    static Deque<Integer> b;
    static Deque<Integer> c;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
        c = new ArrayDeque<>();

        for (int i = n; i >= 1; i--) 
            a.push(i);

        answer = 0;
        hanoi(n, a, b, c, 1, 2, 3);

        System.out.println(answer);
        System.out.print(sb.toString());
    }

    static void hanoi(int n, Deque<Integer> from, Deque<Integer> via, Deque<Integer> to,
                      int fromIdx, int viaIdx, int toIdx) {
        if (n == 0) 
            return;

        hanoi(n - 1, from, to, via, fromIdx, toIdx, viaIdx);
        move(from, to, fromIdx, toIdx);
        hanoi(n - 1, via, from, to, viaIdx, fromIdx, toIdx);
    }

    static void move(Deque<Integer> from, Deque<Integer> to, int fromIdx, int toIdx) {
        int disk = from.pop();
        to.push(disk);
        answer++;

        sb.append(fromIdx).append(' ').append(toIdx).append('\n');
    }
}
