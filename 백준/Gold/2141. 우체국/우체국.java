import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int n; //일직선 상 마을 개수

    public static List<Village> villageList = new ArrayList<>();

    public static class Village{
        int locate;
        long person;

        public Village(int locate, long person){
            this.locate=locate;
            this.person=person;
        }
    }
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int answer =0;
        n=Integer.parseInt(st.nextToken());
        long totalPeople =0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int locate =Integer.parseInt(st.nextToken());
            long person =Long.parseLong(st.nextToken());
            totalPeople+=person;

            villageList.add(new Village(locate,person));
        }

        Collections.sort(villageList,(v1,v2)->v1.locate-v2.locate);
            
        long avgPerson = (totalPeople+1)/2;

        long cumPerson=0;
        for(int i=0;i<n;i++){
            cumPerson+=villageList.get(i).person;
            if(cumPerson>=avgPerson){
                answer=villageList.get(i).locate;
                break;
            }
        }

        System.out.println(answer);
        
    }
}