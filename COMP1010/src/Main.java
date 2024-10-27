import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Create scanner for user input to choose what part of the program they want to use.
        */
        Scanner scanner = new Scanner(System.in);

        /*
        Create an initial playlist manager
        */
        PlaylistManager playlistManager = new PlaylistManager();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Music Player Menu ---");
            System.out.println("1. Show All Playlists");
            System.out.println("2. Create New Playlist");
            System.out.println("3. Switch to Playlist");
            System.out.println("4. Add Song to Current Playlist");
            System.out.println("5. Show Current Playlist");
            System.out.println("6. Play Current Song");
            System.out.println("7. Next Song");
            System.out.println("8. Previous Song");
            System.out.println("9. Shuffle Play (Random Song)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            /*
            All choices the user can make for this program
            */
            if (choice == 1) { // show all playlists made
                System.out.println("\n--- All Playlists ---");
                playlistManager.showAllPlaylists();
                continue;
            }
            
            if (choice == 2) { //allow the user to create a new playlist
                System.out.print("Enter playlist name: ");
                String playlistName = scanner.nextLine();
                playlistManager.createNewPlaylist(playlistName);
                System.out.println("New playlist '" + playlistName + "' created and set as current.");
                continue;   
            }
            
            if (choice == 3) { //allow the user to switch playlists
                System.out.println("Select a playlist by index:");
                playlistManager.showAllPlaylists();
                int playlistIndex = scanner.nextInt();
                scanner.nextLine();
                playlistManager.switchToPlaylist(playlistIndex);
                continue;
            }
            
            if (choice == 4) { //give the user the ability to add a song to a playlist
                if (playlistManager.hasPlaylists()) {
                    Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        System.out.print("Enter song title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter artist name: ");
                        String artist = scanner.nextLine();
                        System.out.print("Is this a single? (true/false): ");
                        boolean isSingle = scanner.nextBoolean();
                        scanner.nextLine(); 
                        Song newSong = new Song(title, artist, isSingle);
                        currentPlaylist.addSong(newSong);
                        System.out.println("Song added to playlist '" + currentPlaylist.getName() + "'.");
                    } else {
                        System.out.println("No current playlist selected.");
                    }
                } else {
                    System.out.println("No playlists available. Please create one first.");
                }
                continue;
            }

            if (choice == 5) { //show all songs in the current playlist
                if (playlistManager.hasPlaylists()) {
                    Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        System.out.println("\n--- Current Playlist: " + currentPlaylist.getName() + " ---");
                        currentPlaylist.showPlaylist();
                    } else {
                        System.out.println("No current playlist selected.");
                    }
                } else {
                    System.out.println("No playlists available.");
                }
                continue;
            }
            
            if (choice == 6) { //play the current song in the playlist
                Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                if (currentPlaylist != null) {
                    System.out.println("\nNow Playing: " + currentPlaylist.getCurrentSong());
                } else {
                    System.out.println("No playlist selected.");
                }
                continue;
            }
            
            if (choice == 7) { //Play the next song
                Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                if (currentPlaylist != null) {
                    currentPlaylist.nextSong();
                    System.out.println("Next Song: " + currentPlaylist.getCurrentSong());
                } else {
                    System.out.println("No playlist selected.");
                }
                continue;
            }
            
            if (choice == 8) { //Play the previous song
                Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                if (currentPlaylist != null) {
                    currentPlaylist.previousSong();
                    System.out.println("Previous Song: " + currentPlaylist.getCurrentSong());
                } else {
                    System.out.println("No playlist selected.");
                }
                continue;
            }
            
            if (choice == 9) { //Shuffle the songs in the playlist
                Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                if (currentPlaylist != null) {
                    currentPlaylist.shufflePlay();
                } else {
                    System.out.println("No playlist selected.");
                }
                continue;
            }
            
            if (choice == 0) { //If the user wants to quit the program
                exit = true;
                System.out.println("Exiting Music Player...");
                break;
            }
            
            else { //if the user inputs a non-index input
                System.out.println("Wrong put in a number instead");
                    continue;
            }
        }
        scanner.close();
    }
}