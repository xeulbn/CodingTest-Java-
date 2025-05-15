import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int newScore= sc.nextInt();
        int p = sc.nextInt();

        Integer[] arr= new Integer[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());

        if(n==p&&newScore<=arr[arr.length-1]){
            System.out.println(-1);
        }else{
            int answer=1;
            for(int i=0;i<arr.length;i++){
                if(newScore<arr[i]){
                    answer++;
                }else{
                    break;
                }
            }

            System.out.println(answer);
        }

    }

}
