import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    public static int k;
    public static List<List<Integer>> power;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        power= new ArrayList<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            List<Integer> row = new ArrayList<>();
            row.add(Integer.parseInt(st.nextToken()));
            row.add(Integer.parseInt(st.nextToken()));
            row.add(Integer.parseInt(st.nextToken()));

            power.add(row);
        }

        int maxSum=0;

        int[][] pairs ={{0,1},{0,2},{1,2}};

        for(int[] pair : pairs){
            int idx1=pair[0];
            int idx2=pair[1];

            List<Integer> sumList=new ArrayList<>();
            for(List<Integer> row : power){
                sumList.add(row.get(idx1)+row.get(idx2));
            }

            Collections.sort(sumList, Collections.reverseOrder());

            int sum=0;
            for(int i=0;i<k;i++){
                sum+=sumList.get(i);
            }
            maxSum=Math.max(maxSum,sum);
        }
        System.out.println(maxSum);
    }

}
