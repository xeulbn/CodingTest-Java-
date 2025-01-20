import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String[] videoLen = video_len.split(":");
            String[] posArr = pos. split(":");
            String[] opStart= op_start.split(":");
            String[] opEnd = op_end.split(":");

            LocalTime video = getTime(videoLen);
            LocalTime posTime = getTime(posArr);
            LocalTime startTime = getTime(opStart);
            LocalTime endTime = getTime(opEnd);

            if(!posTime.isBefore(startTime)&& !posTime.isAfter(endTime)){
                posTime=endTime;
            }
            for(int i=0;i<commands.length;i++){
                if(commands[i].equals("next")){
                    posTime= toNext(posTime,video);
                }else if (commands[i].equals("prev")){
                    posTime= toBefore(posTime,video);
                }
                if(!posTime.isBefore(startTime)&& !posTime.isAfter(endTime)){
                    posTime=endTime;
                }
            }

            String now =posTime.format(DateTimeFormatter.ofPattern("mm:ss"));

            return now;
        }

        public LocalTime toNext(LocalTime now,LocalTime video){
            now = now.plusSeconds(10);
            if(now.isAfter(video)){
                now=video;
            }
            return now;
        }

        public LocalTime toBefore(LocalTime now, LocalTime video){
            if(now.getMinute() ==0 && now.getSecond()<10){
                now= LocalTime.of(0,0,0);
                return now;
            }
            now = now.minusSeconds(10);
            return now;
        }

        public LocalTime getTime(String[] time){
            int min = Integer.parseInt(time[0]);
            int sec = Integer.parseInt(time[1]);

            LocalTime toTime = LocalTime.of(0,min,sec);

            return toTime;
        }
}