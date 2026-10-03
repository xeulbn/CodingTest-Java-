class Solution {
    
    private static int mapH;
    private static int mapW;
    
    public int[] solution(String[] park, String[] routes) {
        String[][] parkScript = new String[park.length][park[0].length()];
        mapH = parkScript.length;
        mapW = parkScript[0].length;
        
        for(int i=0;i<park.length;i++){
            parkScript[i]=park[i].split("");
        }
        
        int[] dog = findStart(parkScript);
        
        int[] answer = move(dog,routes,parkScript);
        
        return answer;
    }
    
    private int[] move(int[] location,String[] routes,String[][] mapScript){

        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = route.charAt(2) - '0';

            int dh = 0;
            int dw = 0;
            
            if (direction == 'E') {
                dw = 1;
            } else if (direction == 'W') {
                dw = -1;
            } else if (direction == 'S') {
                dh = 1;
            } else if (direction == 'N') {
                dh = -1;
            }

            int nextH = location[0];
            int nextW = location[1];
            boolean canMove = true;
            
            for(int i=0;i<distance;i++){
                nextH+=dh;
                nextW+=dw;
                if(nextH<0||nextH>=mapH||nextW<0||nextW>=mapW){
                    canMove= false;
                    break;
                }
                if(mapScript[nextH][nextW].equals("X")){
                    canMove= false;
                    break;
                }
            }
            if(canMove){
                location[0]=nextH;
                location[1]=nextW;
            }
        }
        
        return location;
    }
    
    private int[] findStart(String[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j].equals("S")){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}