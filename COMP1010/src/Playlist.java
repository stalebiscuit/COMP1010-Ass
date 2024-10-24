import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {
    private List<Song> songs;
    private int currentIndex;

    public Playlist() {
        songs = new ArrayList<>();
        currentIndex = 0;
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
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
