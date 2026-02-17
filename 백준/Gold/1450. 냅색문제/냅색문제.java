import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static Long c;
    public static int[] left;
    public static int[] right;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        c=Long.parseLong(st.nextToken());

        int mid = n / 2;
        left = new int[mid];
        right = new int[n - mid];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int w = Integer.parseInt(st.nextToken());
            if(i<mid){
                left[i]=w;
            }else{
                right[i-mid]=w;
            }
        }

        ArrayList<Long> leftSums = new ArrayList<>();
        ArrayList<Long> rightSums = new ArrayList<>();

        makeSums(left, 0, 0L, leftSums);
        makeSums(right, 0, 0L, rightSums);

        Collections.sort(rightSums);

        long answer=0;
        for(long ls :leftSums){
            if(ls>c){
                continue;
            }else{
                long remain = c-ls;
                int cnt = upperBound(rightSums,remain);

                answer+=cnt;
            }
        }

        System.out.println(answer);
    }

    public static void makeSums(int[] arr, int index, Long sum, ArrayList<Long> sums){
        if(sum>c){
            return;
        }
        if(index==arr.length){
            sums.add(sum);
            return;
        }

        makeSums(arr, index + 1, sum, sums);
        makeSums(arr, index+ 1, sum + arr[index], sums);
    }

    public static int upperBound(ArrayList<Long> list, long target){
        int low = 0;
        int high = list.size();
        
        while (low < high) {
            int mid = (low + high)/2;
            if (list.get(mid) <= target) 
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    
}