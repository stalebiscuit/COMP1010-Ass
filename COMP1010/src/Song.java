public class Song {
    private String title;         
    private String artist;          
    private boolean isSingle;      

    /*
       Constructor to create a new Song instance.
       Initializes the song with a title, artist, and indicates whether
       it is a single or part of an album.
    */
    public Song(String title, String artist, boolean isSingle) {
        this.title = title;
        this.artist = artist;
        this.isSingle = isSingle;
    }

    /*
       Method to retrieve the title of the song.
       Returns the title stored in the 'title' variable.
    */
    public String getTitle() {
        return title;
    }

    /*
       Method to retrieve the artist of the song.
       Returns the artist stored in the 'artist' variable.
    */
    public String getArtist() {
        return artist;
    }

    /*
       Method to check if the song is a single.
       Returns true if the song is a single, false otherwise.
    */
    public boolean isSingle() {
        return isSingle;
    }

    /*
       Provides a string representation of the song.
       Returns a formatted string that includes the title, artist,
       and indicates whether it is a single or part of an album.
    */
    @Override
    public String toString() {
        return title + " by " + artist + (isSingle ? " (Single)" : " (Album)");
    }
}
