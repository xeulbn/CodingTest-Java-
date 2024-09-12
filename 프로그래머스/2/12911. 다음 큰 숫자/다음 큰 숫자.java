class Solution{
    public int solution(int n) {
        int answer=0,oneNumber;
        String binaryString = Integer.toBinaryString(n);

        oneNumber=howManyOne(binaryString);

        int howManyOneNumber;
        for (int i=n+1;i<1000000;i++){
            String temp = Integer.toBinaryString(i);
            howManyOneNumber=howManyOne(temp);
            if(howManyOneNumber==oneNumber){
                answer=i;
                break;
            }
        }

        return answer;
    }

    public int howManyOne(String binary) {
        int oneNumber=0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                oneNumber++;
            }
        }
        return oneNumber;
    }
}