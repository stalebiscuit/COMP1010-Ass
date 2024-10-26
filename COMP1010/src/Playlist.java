import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Playlist {
    private List<Song> songs; //list to store songs in the playlist
    private String name; // name of playlist
    private int currentIndex; //index of the currently playing song

    //name of the playlist
    public Playlist(String name) { 
        this.songs = new ArrayList<>();
        this.name = name;
        this.currentIndex = 0;
    }

    public String getName() { //retrieves the playlist's name
        return name;
    }

    public void addSong(Song song) { //adds a song to the playlist
        songs.add(song);
    }

    public Song getCurrentSong() { //retrieves the currently playing song in the playlist
        if (songs.isEmpty()) {
            return null;
        }
        return songs.get(currentIndex);
    }

    public void nextSong() { //moves to the next song in the playlist, looping to the beginning
        currentIndex = (currentIndex + 1) % songs.size();
    }

    public void previousSong() { //moves to the previous song in the playlist, looping to the end if at the beginning
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
    }

    // Method to play a random song (shuffle play without altering order)
    public void shufflePlay() {
        Random random = new Random();
        int randomIndex = random.nextInt(songs.size());
        System.out.println("Shuffle Playing: " + songs.get(randomIndex));
    }

    public void showPlaylist() { //display all songs in the playlist
        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }
}