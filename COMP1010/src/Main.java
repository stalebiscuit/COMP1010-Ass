import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create a playlist manager
        PlaylistManager playlistManager = new PlaylistManager();

        boolean exit = false; //control variable for exiting the loop
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
            scanner.nextLine();  // Consume the newline character

            // process menu choice
            switch (choice) {
                case 1: //shows all playlists available in the PlaylistManager
                    System.out.println("\n--- All Playlists ---");
                    playlistManager.showAllPlaylists();
                    break;

                case 2: //create a new playlist and set it as the current one 
                    System.out.print("Enter playlist name: ");
                    String playlistName = scanner.nextLine();
                    playlistManager.createNewPlaylist(playlistName);
                    System.out.println("New playlist '" + playlistName + "' created and set as current.");
                    break;

                case 3: //allows the user to select a playlist by its index
                    System.out.println("Select a playlist by index:");
                    playlistManager.showAllPlaylists();
                    int playlistIndex = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    playlistManager.switchToPlaylist(playlistIndex);
                    break;

                case 4: //add a new song to the selected playlist
                    if (playlistManager.hasPlaylists()) {
                        Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                        if (currentPlaylist != null) {
                            System.out.print("Enter song title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter artist name: ");
                            String artist = scanner.nextLine();
                            System.out.print("Is this a single? (true/false): ");
                            boolean isSingle = scanner.nextBoolean();
                            scanner.nextLine();  // Consume newline
                            Song newSong = new Song(title, artist, isSingle);
                            currentPlaylist.addSong(newSong);
                            System.out.println("Song added to playlist '" + currentPlaylist.getName() + "'.");
                        } else {
                            System.out.println("No current playlist selected.");
                        }
                    } else {
                        System.out.println("No playlists available. Please create one first.");
                    }
                    break;

                case 5: //show all songs in the current playlist
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
                    break;

                case 6: //play the current selected song in the playlist
                    Playlist currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        System.out.println("\nNow Playing: " + currentPlaylist.getCurrentSong());
                    } else {
                        System.out.println("No playlist selected.");
                    }
                    break;

                case 7: //move to the next song in the current playlist
                    currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        currentPlaylist.nextSong();
                        System.out.println("Next Song: " + currentPlaylist.getCurrentSong());
                    } else {
                        System.out.println("No playlist selected.");
                    }
                    break;

                case 8: //move to the previous song in the current playlist
                    currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        currentPlaylist.previousSong();
                        System.out.println("Previous Song: " + currentPlaylist.getCurrentSong());
                    } else {
                        System.out.println("No playlist selected.");
                    }
                    break;

                case 9: //shuffle play a random song from current playlist
                    currentPlaylist = playlistManager.getCurrentPlaylist();
                    if (currentPlaylist != null) {
                        currentPlaylist.shufflePlay();
                    } else {
                        System.out.println("No playlist selected.");
                    }
                    break;

                case 0: //exit the program
                    exit = true;
                    System.out.println("Exiting Music Player...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}