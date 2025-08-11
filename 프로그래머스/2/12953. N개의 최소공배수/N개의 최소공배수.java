class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1;i<arr.length;i++){
            answer=(answer*arr[i])/gcd(answer,arr[i]);
        }
        
        return answer;
    }
    
    private static int gcd(int num1, int num2){
        if(num1<num2){
            int tmp = num1;
            num1=num2;
            num2=tmp;
        }
        
        while(num2!=0){
            int r= num1%num2;
            num1=num2;
            num2=r;
        }
        
        return num1;
    }
}