import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        m = convert(m);

        String bestTitle = "(None)";
        int bestTime = -1;

        for (String info : musicinfos) {
            String[] arr = info.split(",");
            String start = arr[0];
            String end = arr[1];
            String title = arr[2];
            String melody = convert(arr[3]);

            int playTime = getPlayTime(start, end);
            String played = buildPlayedMelody(melody, playTime);

            if (played.contains(m)) {
                if (playTime > bestTime) {
                    bestTime = playTime;
                    bestTitle = title;
                }
            }
        }

        return bestTitle;
    }
    
    public int getPlayTime(String startTime, String endTime) {
        String[] s = startTime.split(":");
        String[] e = endTime.split(":");

        int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);

        return end - start;
    }

    public String buildPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }

        return sb.toString();
    }

    public String convert(String s) {
        return s.replace("B#", "b")
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}