import java.util.Scanner;

public class App {
      public static void main(String[] args) throws Exception {
          Scanner scanner = new Scanner(System.in);

        // Create some initial songs
        Song song1 = new Song("Song A", "Artist 1", true);
        Song song2 = new Song("Song B", "Artist 2", false);
        Song song3 = new Song("Song C", "Band 1", true);
        Song song4 = new Song("Song D", "Band 2", false);

        // Create a playlist
        Playlist playlist = new Playlist();

        // Create an album with a main track
        Album album1 = new Album("Album 1", song2);
        album1.addSongToAlbum(song3);  // Add more songs to the album

        // Add initial songs to the playlist
        playlist.addSong(song1);
        playlist.addSong(song4);
        playlist.addSong(album1.getMainTrack());
        for (Song song : album1.getSongs()) {
            playlist.addSong(song);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Music Player Menu ---");
            System.out.println("1. Show Playlist");
            System.out.println("2. Play Current Song");
            System.out.println("3. Next Song");
            System.out.println("4. Previous Song");
            System.out.println("5. Shuffle Playlist");
            System.out.println("6. Add New Song");
            System.out.println("7. Add New Album");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("\n--- Playlist ---");
                    playlist.showPlaylist();
                    break;

                case 2:
                    System.out.println("\nNow Playing: " + playlist.getCurrentSong());
                    break;

                case 3:
                    playlist.nextSong();
                    System.out.println("Next Song: " + playlist.getCurrentSong());
                    break;

                case 4:
                    playlist.previousSong();
                    System.out.println("Previous Song: " + playlist.getCurrentSong());
                    break;

                case 5:
                    playlist.shufflePlay();
                    System.out.println("Shuffled Playlist:");
                    playlist.showPlaylist();
                    break;

                case 6:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Is this a single? (true/false): ");
                    boolean isSingle = scanner.nextBoolean();
                    scanner.nextLine();  // Consume newline
                    Song newSong = new Song(title, artist, isSingle);
                    playlist.addSong(newSong);
                    System.out.println("Song added to playlist.");
                    break;

                case 7:
                    System.out.print("Enter album name: ");
                    String albumName = scanner.nextLine();
                    System.out.print("Enter main track title: ");
                    String mainTrackTitle = scanner.nextLine();
                    System.out.print("Enter main track artist: ");
                    String mainTrackArtist = scanner.nextLine();
                    Song mainTrack = new Song(mainTrackTitle, mainTrackArtist, false);
                    Album newAlbum = new Album(albumName, mainTrack);
                    playlist.addSong(mainTrack);
                    System.out.print("How many songs in the album? ");
                    int songCount = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    for (int i = 0; i < songCount; i++) {
                        System.out.print("Enter song " + (i + 1) + " title: ");
                        String albumSongTitle = scanner.nextLine();
                        System.out.print("Enter song " + (i + 1) + " artist: ");
                        String albumSongArtist = scanner.nextLine();
                        Song albumSong = new Song(albumSongTitle, albumSongArtist, false);
                        newAlbum.addSongToAlbum(albumSong);
                        playlist.addSong(albumSong);
                    }
                    System.out.println("Album added to playlist.");
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting Music Player...");
                    break;

                default:
                    System.out.println("Inva1lid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
