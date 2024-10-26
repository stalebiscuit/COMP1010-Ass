public class Song {
    private String title;
    private String artist;
    private boolean isSingle; //true if song is a single, false if part of an album

    // constructs a new song with a title, artist, and single/album
    public Song(String title, String artist, boolean isSingle) {
        this.title = title;
        this.artist = artist;
        this.isSingle = isSingle;
    }

    //retrieves title of the song
    public String getTitle() {
        return title;
    }

    //retrieves artist of the song
    public String getArtist() {
        return artist;
    }

    //checks if the song is a single
    public boolean isSingle() {
        return isSingle;
    }

    //provides string representation of the song, includes title, artist and whether it's a single or part of an album
    @Override
    public String toString() {
        return title + " by " + artist + (isSingle ? " (Single)" : " (Album)");
    }
}
