
import java.io.*;
import java.util.*;
import java.util.stream.LongStream;

public class Main {

    private static int n;
    private static int m;
    private static Map<String, Integer> wordMap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        wordMap= new HashMap<>();


        for(int i=0;i<n;i++){
            String word = br.readLine();

            if(word.length()<m){
                continue;
            }
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }

        List<String> wordList= new ArrayList<>(wordMap.keySet());

        Collections.sort(wordList,(a,b)->{
            if(!wordMap.get(b).equals(wordMap.get(a))){
                return wordMap.get(b)-wordMap.get(a);
            }
            if(a.length()!=b.length()){
                return b.length()-a.length();
            }
            return a.compareTo(b);
        });

        StringBuilder sb= new StringBuilder();
        for(String word:wordList){
            sb.append(word).append("\n");
        }
        System.out.println(sb);


    }
}
