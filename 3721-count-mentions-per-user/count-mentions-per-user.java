import java.util.*;

class Solution {

    static class Event {
        String type;
        int time;
        String data;

        Event(String type, int time, String data) {
            this.type = type;
            this.time = time;
            this.data = data;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers]; // 0 means online initially

        // Convert to Event objects
        List<Event> list = new ArrayList<>();
        for (List<String> e : events) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));
            String data = e.get(2);
            list.add(new Event(type, time, data));
        }

        // Sort by time asc; for same time: OFFLINE first, then MESSAGE
        Collections.sort(list, (a, b) -> {
            if (a.time != b.time) return a.time - b.time;
            if (a.type.equals(b.type)) return 0;
            return a.type.equals("OFFLINE") ? -1 : 1; // OFFLINE before MESSAGE
        });

        // Process in correct chronological order
        for (Event ev : list) {
            int time = ev.time;

            if (ev.type.equals("OFFLINE")) {
                int userId = Integer.parseInt(ev.data);
                offlineUntil[userId] = time + 60;
            } else { // MESSAGE
                String msg = ev.data;

                if (msg.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) mentions[i]++;
                } else if (msg.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (time >= offlineUntil[i]) mentions[i]++;
                    }
                } else {
                    String[] tokens = msg.split(" ");
                    for (String token : tokens) {
                        // token looks like "id<number>"
                        int userId = Integer.parseInt(token.substring(2));
                        mentions[userId]++;
                    }
                }
            }
        }

        return mentions;
    }
}
