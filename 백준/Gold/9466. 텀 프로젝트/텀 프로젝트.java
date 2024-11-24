import java.io.*;
import java.util.*;

public class Main{
    static int T;
    static int N;
    static int[] result;
    static int[] select;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            select = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= N; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                result[select[i]]++;
            }

            System.out.println(bfs());
        }
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(result[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int selected = select[current];
            result[selected]--;
            if(result[selected] == 0) {
                queue.add(selected);
            }
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(result[i] >= 1) {
                count++;
            }
        }

        return N - count;
    }
}
