public class Song {
    private String title;
    private String artist;
    private boolean isSingle;

    public Song(String title, String artist, boolean isSingle) {
        this.title = title;
        this.artist = artist;
        this.isSingle = isSingle;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isSingle() {
        return isSingle;
    }

    @Override
    public String toString() {
        return title + " by " + artist + (isSingle ? " (Single)" : " (Album)");
    }
}
