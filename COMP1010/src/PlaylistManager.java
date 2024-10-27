import java.util.ArrayList;

public class PlaylistManager {
    public ArrayList<Playlist> playlists; 
    public int curPlylstIdx;

    /*
       Constructor to initialize an empty PlaylistManager.
       It creates an empty list of playlists and sets the current playlist index to -1,
       indicating no playlist is selected initially.
    */
    public PlaylistManager() {
        playlists = new ArrayList<>();
        curPlylstIdx = -1; // No playlist selected initially
    }

    /*
       Method to create a new playlist with a given name.
       A new Playlist object is created and added to the playlists list.
       The new playlist is set as the current playlist.
    */
    public void createNewPlaylist(String playlistName) {
        Playlist newPlaylist = new Playlist(playlistName);
        playlists.add(newPlaylist);
        curPlylstIdx = playlists.size() - 1;
    }

    /*
       Method to retrieve the current playlist.
       If there is a valid current playlist (index >= 0 and < size),
       the method returns the current Playlist object; otherwise, it returns null.
    */
    public Playlist getCurrentPlaylist() {
        if (curPlylstIdx >= 0 && curPlylstIdx < playlists.size()) {
            return playlists.get(curPlylstIdx);
        }
        return null; 
    }

    /*
       Method to switch to another playlist by its index.
       If the provided index is valid, it updates the current playlist index 
       and prints a confirmation message. Otherwise, it prints an error message.
    */
    public void switchToPlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            curPlylstIdx = index;
            System.out.println("Switched to playlist: " + playlists.get(curPlylstIdx).getName());
        } else {
            System.out.println("Invalid playlist index.");
        }
    }

    /*
       Method to display all playlists in the manager.
       If there are no playlists, a message is printed indicating this.
       Otherwise, it prints the index and name of each playlist.
    */
    public void showAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists available.");
        } else {
            for (int i = 0; i < playlists.size(); i++) {
                System.out.println(i + ": " + playlists.get(i).getName());
            }
        }
    }

    /*
       Method to check if there are any playlists in the manager.
       Returns true if the playlists list is not empty; otherwise, returns false.
    */
    public boolean hasPlaylists() {
        return !playlists.isEmpty();
    }
}
