import java.util.ArrayList;

public class PlaylistManager {
    private ArrayList<Playlist> playlists;
    private int currentPlaylistIndex;

    public PlaylistManager() {
        playlists = new ArrayList<>();
        currentPlaylistIndex = -1;  // No playlist selected initially
    }

    // Create a new playlist and add it to the list
    public void createNewPlaylist(String playlistName) {
        Playlist newPlaylist = new Playlist(playlistName);
        playlists.add(newPlaylist);
        currentPlaylistIndex = playlists.size() - 1;  // Set the new playlist as the current one
    }

    // Get the current playlist
    public Playlist getCurrentPlaylist() {
        if (currentPlaylistIndex >= 0 && currentPlaylistIndex < playlists.size()) {
            return playlists.get(currentPlaylistIndex);
        }
        return null;  // No playlist available
    }

    // Switch to another playlist by index
    public void switchToPlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            currentPlaylistIndex = index;
            System.out.println("Switched to playlist: " + playlists.get(currentPlaylistIndex).getName());
        } else {
            System.out.println("Invalid playlist index.");
        }
    }

    // Show all playlists
    public void showAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists available.");
        } else {
            for (int i = 0; i < playlists.size(); i++) {
                System.out.println(i + ": " + playlists.get(i).getName());
            }
        }
    }

    public boolean hasPlaylists() {
        return !playlists.isEmpty();
    }
}