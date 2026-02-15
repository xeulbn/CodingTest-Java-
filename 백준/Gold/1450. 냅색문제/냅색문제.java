import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static int c;
    public static int[] leftArr;
    public static int[] rightArr;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int mid = n / 2;
        leftArr = new int[mid];
        rightArr = new int[n - mid];
        
        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(st.nextToken());
            if (i < mid) {
                leftArr[i] = w;
            }else {
                rightArr[i - mid] = w;
            }
        }

        ArrayList<Long> leftSums = new ArrayList<>();
        ArrayList<Long> rightSums = new ArrayList<>();
        
        makeSums(leftArr, 0, 0L, leftSums);
        makeSums(rightArr, 0, 0L, rightSums);

        Collections.sort(rightSums);
        
        long answer = 0;
        
        for (long ls : leftSums) {
            if (ls > c) continue;
            long remain = c - ls;

            int cnt = upperBound(rightSums, remain);
            answer += cnt;
        }

        System.out.println(answer);
        
    }

    static void makeSums(int[] arr, int idx, long sum, ArrayList<Long> sums) {
        if (sum > c) 
            return;
        if (idx == arr.length) {
            sums.add(sum);
            return;
        }
        makeSums(arr, idx + 1, sum, sums);
        
        makeSums(arr, idx + 1, sum + arr[idx], sums);
    }

    static int upperBound(ArrayList<Long> list, long target) {
        int low = 0;
        int high = list.size(); 
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (list.get(mid) <= target) 
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
}