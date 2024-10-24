import java.util.ArrayList;
import java.util.Collections;
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
        currentIndex = moveNext(currentIndex);  // Use recursion to move to the next song
    }

    public void previousSong() {
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
    }

    // Recursive method for moving to the next song
    private int moveNext(int index) {
        if (index + 1 < songs.size()) {
            return index + 1;
        } else {
            return moveNext(-1);  // Recursion that wraps around to the start
        }
    }

    public void shufflePlay() {
        Collections.shuffle(songs, new Random());
        currentIndex = 0;
    }

    public void showPlaylist() {
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}