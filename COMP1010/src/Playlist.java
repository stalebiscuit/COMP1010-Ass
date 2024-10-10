import java.util.*;

public class Playlist {
 ArrayList<Song> contents;

public Playlist(){
    contents = new ArrayList<Song>();
}

public void addSong(Song a){
    contents.add(a);
}

}
