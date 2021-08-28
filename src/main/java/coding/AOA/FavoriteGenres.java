package main.java.coding.AOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {
    public static void main(String[] args) {

        Map<String, List<String>>  res = favoriteGenres(
                Map.of( "David", List.of("song1", "song2", "song3", "song4", "song8") ,
                        "Emma", List.of("song5", "song6", "song7")
                ),
                Map.of(
                        "Rock", List.of("song1", "song3"),
                        "Dubstep", List.of("song7"),
                        "Techno", List.of("song2", "song4"),
                        "Pop", List.of("song5", "song6"),
                        "Jazz", List.of("song8", "song9")
                )


        );

        System.out.println(res);
    }

    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,Map<String, List<String>> songGenres){
        Map<String, List<String>> res = new HashMap<>();

        Map<String,String> song2genres = new HashMap<>();
        for (Map.Entry<String, List<String>> entry: songGenres.entrySet()) {
            for ( String song: entry.getValue()) {
                song2genres.put(song, entry.getKey());
            }
        }

        for (Map.Entry<String, List<String>> entry: userSongs.entrySet()) {
            Map<String, Integer> count = new HashMap<>();
            int max = 0;
            for (String song: entry.getValue()) {
                count.put( song2genres.get(song), count.getOrDefault( song2genres.get(song), 0) +1 );
                max = Math.max(max, count.get(song2genres.get(song)));
            }

            res.put(entry.getKey(), new ArrayList<>());
            for (String key : count.keySet()) {
                if (count.get(key) == max) {
                    res.get(entry.getKey()).add(key);
                }
            }
        }

        return res;
    }
}
