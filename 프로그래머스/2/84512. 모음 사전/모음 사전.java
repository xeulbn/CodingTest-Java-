import java.util.*;

class Solution {
    List<String> listDictionary = new ArrayList<>();
    String[] arr = {"A","E","I","O","U"};

    public int solution(String  word) {
        int answer = 0;
        for(int i=0;i<5;i++){
            makeDictionary(arr[i],1);
        }

        answer= listDictionary.indexOf(word)+1;

        return answer;
    }

    public void makeDictionary(String vowel, int depth){
        listDictionary.add(vowel);
        if(depth==5){
            return;
        }
        for(int i=0;i<5;i++){
            makeDictionary(vowel+arr[i],depth+1);
        }
    }
}