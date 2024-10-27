import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SongTest {
    @Test
    void testSongConstructor() {
        Song song = new Song("Song Title", "Artist Name", true);
        assertEquals("Song Title", song.getTitle());
        assertEquals("Artist Name", song.getArtist());
        assertTrue(song.isSingle());
    }
    @Test
    void testToString() {
        Song song1 = new Song("Song Title", "Artist Name", true);
        Song song2 = new Song("Another Song", "Different Artist", false);
        assertEquals("Song Title by Artist Name (Single)", song1.toString());
        assertEquals("Another Song by Different Artist (Album)", song2.toString());
    }
}