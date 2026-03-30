class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        
        if(n<=2){
            return n;
        }
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        leftMin[0]=a[0];
        for(int i=1;i<a.length;i++){
            leftMin[i]=Math.min(leftMin[i-1],a[i]);
        }
        
        rightMin[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],a[i]);
        }

        for(int i=0;i<n;i++){
            if(leftMin[i]>=a[i]||rightMin[i]>=a[i]){
                answer++;
            }
        }
        
        return answer;
    }
}