import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlaylistTest {

    @Test
    void testGetCurrentSong() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1", true);
        Song song2 = new Song("Song 2", "Artist 2", false);
        playlist.addSong(song1);
        playlist.addSong(song2);
        assertEquals(song1, playlist.getCurrentSong()); // Initially, the first song is current
    }
    @Test
    void testGetCurrentSongAfterNext() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1", true);
        Song song2 = new Song("Song 2", "Artist 2", false);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.nextSong(); // Move to the next song
        assertEquals(song2, playlist.getCurrentSong()); 
    }
    @Test
    void testNextSong() {
        Playlist playlist = new Playlist("Test Playlist");
        Song song1 = new Song("Song 1", "Artist 1", true);
        Song song2 = new Song("Song 2", "Artist 2", false);
        Song song3 = new Song("Song 3", "Artist 3", true);
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.nextSong(); 
        assertEquals(song2, playlist.getCurrentSong());
        playlist.nextSong();
        assertEquals(song3, playlist.getCurrentSong());
        playlist.nextSong(); // Wrap around to the beginning
        assertEquals(song1, playlist.getCurrentSong());
    }
    @Test
    void testNextSongEmptyPlaylist() {
        Playlist playlist = new Playlist("Test Playlist");
        playlist.nextSong(); // Calling nextSong on an empty playlist should not crash
        assertNull(playlist.getCurrentSong()); 
    }
}