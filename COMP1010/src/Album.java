import java.util.ArrayList;

public class Album {
    private String name; // Name of the album
    private Song mainTrack;  // Contains a Song object (not an ArrayList)
    private ArrayList<Song> songs;  // Contains an ArrayList of Song objects

    /** 
     * constructor to initialize an album with a name and a main track
     * main track is added as the first song in the album
     */

    public Album(String name, Song mainTrack) {
        this.name = name;
        this.mainTrack = mainTrack;
        this.songs = new ArrayList<>();
        this.songs.add(mainTrack);  // Main track is always part of the album
    }
     
    public void addSongToAlbum(Song song) { //adds a song to the album's song list
        songs.add(song);
    }

    public Song getMainTrack() { //retrieves album's main track
        return mainTrack;
    }

    public ArrayList<Song> getSongs() { //retrieves all songs in the album
        return songs;
    }

    public void showAlbum() { //displays the album name and list of songs
        System.out.println("Album: " + name);
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}