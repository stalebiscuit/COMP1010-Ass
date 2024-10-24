import java.util.ArrayList;

public class Album {
    private String name;
    private Song mainTrack;  // Contains a Song object (not an ArrayList)
    private ArrayList<Song> songs;  // Contains an ArrayList of Song objects

    public Album(String name, Song mainTrack) {
        this.name = name;
        this.mainTrack = mainTrack;
        this.songs = new ArrayList<>();
        this.songs.add(mainTrack);  // Main track is always part of the album
    }

    public void addSongToAlbum(Song song) {
        songs.add(song);
    }

    public Song getMainTrack() {
        return mainTrack;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void showAlbum() {
        System.out.println("Album: " + name);
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}