import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlaylistManagerTest {
    @Test
    void testCreateNewPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createNewPlaylist("Test Playlist");
        assertEquals(1, manager.playlists.size());
        assertEquals("Test Playlist", manager.getCurrentPlaylist().getName());
    }
    @Test
    void testGetCurrentPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createNewPlaylist("Playlist 1");
        manager.createNewPlaylist("Playlist 2");
        assertEquals("Playlist 2", manager.getCurrentPlaylist().getName());
    }
    @Test
    void testGetCurrentPlaylistAfterSwitch() {
        PlaylistManager manager = new PlaylistManager();
        manager.createNewPlaylist("Playlist 1");
        manager.createNewPlaylist("Playlist 2");
        manager.switchToPlaylist(0); // Switch to "Playlist 1"
        assertEquals("Playlist 1", manager.getCurrentPlaylist().getName());
    }
    @Test
    void testSwitchToPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createNewPlaylist("Playlist A");
        manager.createNewPlaylist("Playlist B");
        manager.switchToPlaylist(0); // Switch to Playlist A
        assertEquals("Playlist A", manager.getCurrentPlaylist().getName());
        manager.switchToPlaylist(1); // Switch to Playlist B
        assertEquals("Playlist B", manager.getCurrentPlaylist().getName());
    }
}