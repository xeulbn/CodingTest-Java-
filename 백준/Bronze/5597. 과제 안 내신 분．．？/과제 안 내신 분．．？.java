import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> alreadyStudents=new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<28;i++){
            int x=sc.nextInt();
            alreadyStudents.add(x);
        }
        for(int i=1;i<=30;i++){
            if(alreadyStudents.contains(i)){
                continue;
            }else{
                System.out.println(i);
            }
        }
    }
}