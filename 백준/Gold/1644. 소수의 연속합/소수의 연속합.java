import java.util.*;

public class Main {

    public static int N;
    public static boolean[] prime;
    public static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N= sc.nextInt();

        prime= new boolean[N+1];
        Arrays.fill(prime,true);
        list= new ArrayList<>();

        prime[0]=prime[1]=false;
        for(int i=2;i*i<=N;i++){
            if(prime[i]){
                for(int j=i*i;j<=N;j+=i){
                    prime[j]=false;
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(prime[i]){
                list.add(i);
            }
        }
        list.add(0);

        int start=0;
        int end=0;
        int sum=0;
        int cnt=0;

        while(start<=end&&end<list.size()){
            if(sum<N)
                sum+=list.get(end++);
            else{
                if(sum==N){
                    cnt++;
                }
                sum-=list.get(start++);
            }
        }
        System.out.println(cnt);

    }
}
