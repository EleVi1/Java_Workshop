package fr.epita.assistants.ministreamsmusic.dataaccess;

import fr.epita.assistants.ministreamsmusic.data.Song;

import java.util.List;

public class StreamsSongs {

    public static List<String> getOlderArtists(List<Song> songs)
    {
        return songs.stream().filter(e -> e.getArtist().getAge() >= 30)
                .map(e -> e.getArtist().getSurname())
                .distinct()
                .limit(10)
                .toList();
    }
    public static Integer getSumAges(List<Song> songs)
    {
        return songs.stream().filter(e -> e.getArtist().getAge() >= 20).mapToInt(e -> e.getArtist().getAge()).sum();
    }

    public static List<String> getMusics(List<Song> songs)
    {
        return songs.stream().filter(e -> e.getArtist().getName().matches("^.*(An|an|aN|AN).*$")).map(e -> e.getName()).limit(10).toList();
    }
}
