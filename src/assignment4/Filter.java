package assignment4;

import java.util.*;

public class Filter {

    /* Again, the assignment is engineered to work on python, since it requires to return a dictionary */
    /* In Java, the closest thing to it, is the map, so I'll implement a function that returns a map with the key (Video, Audio, Other) and value a list of entries */

    public static void main(String[] args) {
        List<String> listOfEntries = new ArrayList<>(Arrays.asList(
                "Entry One.mp4",
                "Entry Two.wav",
                "Entry Three.jpg",
                "Entry Four.mng",
                "Entry Five.png",
                "Entry Six.csv"
        ));
        Map<String, List<String>> filteredEntries = new HashMap<>();

        // Filter by extension
        for(String it: listOfEntries)
        {
            if(it.contains(".wav"))
            {
                if(!filteredEntries.containsKey("Audio"))
                {
                    filteredEntries.put("Audio", new ArrayList<>());
                }
                filteredEntries.get("Audio").add(it);
            }
            else if(it.contains(".mp4"))
            {
                if(!filteredEntries.containsKey("Video"))
                {
                    filteredEntries.put("Video", new ArrayList<>());
                }
                filteredEntries.get("Video").add(it);
            }
            else
            {
                if(!filteredEntries.containsKey("Other"))
                {
                    filteredEntries.put("Other", new ArrayList<>());
                }
                filteredEntries.get("Other").add(it);
            }
        }

        // Print map
        filteredEntries.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
