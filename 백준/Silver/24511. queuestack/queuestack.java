import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n;
    public static int m;
    public static int[] a;
    public static int[] b;
    public static int[] c;

    //1이면 스택 (후입 선출) 0이면 큐 (선입 선출)

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        b=new int[n];
        for(int i=0;i<n;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());

        c=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                queue.addFirst(b[i]); // 새로 만든 큐에 현재 요소를 담는다.
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            queue.add(c[i]);
            answer.append((queue.pollFirst() + " "));
        }
 
        System.out.println(answer);
        
    }
}