import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {
    private List<Song> songs;
    private String name;
    private int currentIndex;

    public Playlist(String name) {
        this.songs = new ArrayList<>();
        this.name = name;
        this.currentIndex = 0;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public Song getCurrentSong() {
        if (songs.isEmpty()) {
            return null;
        }
        return songs.get(currentIndex);
    }

    public void nextSong() {
        currentIndex = (currentIndex + 1) % songs.size();
    }

    public void previousSong() {
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
    }

    // Method to play a random song (shuffle play without altering order)
    public void shufflePlay() {
        Random random = new Random();
        int randomIndex = random.nextInt(songs.size());
        System.out.println("Shuffle Playing: " + songs.get(randomIndex));
    }

    public void showPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}