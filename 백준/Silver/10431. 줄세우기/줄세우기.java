import java.util.*;
import java.io.*;

public class Main {

    private static int p;
    private static List<List<Integer>> testCase;
    private static Map<Integer,Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = Integer.parseInt(br.readLine());
        testCase = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            st.nextToken();
            for (int j = 0; j < 20; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            testCase.add(list);
        }

        answer= new HashMap<>();
        for(int i=0;i<p;i++){
            List<Integer> cur = testCase.get(i);
            for (int x = 0; x < 20; x++) {
                for (int y = 0; y < x; y++) {
                    if (cur.get(y) > cur.get(x)) {
                        answer.put(i, answer.getOrDefault(i, 0) + 1);
                    }
                }
            }
        }

        for(int i=0;i<p;i++){
            System.out.println((i+1)+" "+ answer.getOrDefault(i,0));
        }


    }

}
