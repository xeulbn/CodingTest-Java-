import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int i = 0; i < truck_weights.length; i++) { 
            int truck = truck_weights[i];

            while(true) {
               
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++; 
                    break;
                } else if(queue.size() == bridge_length) { 
                    sum -= queue.poll();
                } else  { 
                    
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

    
        return time + bridge_length;
    }
}