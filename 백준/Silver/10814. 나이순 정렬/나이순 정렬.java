import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

class Main {

    public static int n;
    public static List<People> peopleList;

    public static class People{
        int age;
        String name;
        public People(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
        
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        peopleList=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            peopleList.add(new People(age,name));
        }

        List<People> answer = new ArrayList<>();
        answer=peopleList.stream().sorted((a,b)->{
            if(a.age != b.age){
                return a.age-b.age;
            }else{
                return 0;
            }
        }).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(People p : answer){
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }
    
}