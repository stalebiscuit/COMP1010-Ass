import java.util.Random;

public class Playlist {
    private String name;          
    private SongNode head;        
    private SongNode tail;        
    private SongNode currentSongNode; 

    /*
       Constructor to initialize the playlist with a name.
       The linked list of songs head, tail is initially empty,
       and there is no current song selected.
    */
    public Playlist(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.currentSongNode = null;
    }
    
    /*
       Method to retrieve the name of the playlist.
       Returns the name stored in the 'name' variable.
    */
    public String getName() {
        return name;
    }

    /*
       Method to add a song to the playlist.
       We create a new SongNode for the given song.
       If the playlist is empty, this song becomes head, tail, and current song.
       Otherwise, it gets added to the end, updating the tail node.
    */
    public void addSong(Song song) {
        SongNode newNode = new SongNode(song);
        if (head == null) { 
            head = newNode;
            tail = newNode;
            currentSongNode = head;
        } else { 
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    /*
       Method to retrieve the current song.
       If currentSongNode is not null, we return the song at that node;
       otherwise, return null to indicate no song is selected.
    */
    public Song getCurrentSong() {
        return currentSongNode != null ? currentSongNode.getSong() : null;
    }

    /*
       Method to advance to the next song in the playlist.
       Moves currentSongNode to the next node, or loops back to head if at the end.
    */
    public void nextSong() {
        if (currentSongNode != null) {
            currentSongNode = currentSongNode.getNext() != null ? currentSongNode.getNext() : head;
        }
    }

     /*
       Method to go to the previous song in the playlist.
       Moves currentSongNode to the previous node, or loops back to tail if at the start.
    */
    public void previousSong() {
        if (currentSongNode != null) {
            currentSongNode = currentSongNode.getPrev() != null ? currentSongNode.getPrev() : tail;
        }
    }

    /*
       Method to play a random song in the playlist (shuffle play).
       If the playlist is empty, print a message and return.
       Otherwise, select a random position in the linked list, starting from head,
       and advance 'steps' times to reach a random song node.
    */
    public void shufflePlay() {
        if (head == null) {
            System.out.println("No songs in the playlist to shuffle.");
            return;
        }

        Random random = new Random();
        int steps = random.nextInt(getSize());
        SongNode temp = head;
        for (int i = 0; i < steps; i++) {
            if (temp.getNext() != null) {
                temp = temp.getNext();
            }
            
            else {
                temp = head;
            }
        }
        currentSongNode = temp;
        System.out.println("Shuffle Playing: " + currentSongNode.getSong());
    }

    /*
        Traversing the linked list to find a random node.
     */
    public void showPlaylist() {
        if (head == null) {
            System.out.println("No songs in the playlist.");
        } else {
            SongNode temp = head;
            while (temp != null) {
                System.out.println(temp.getSong());
                temp = temp.getNext();
            }
        }
    }

     /*
       Helper method to get the number of songs in the playlist.
       Starts at head and traverses each node until tail, counting each node.
       Returns the count of nodes, representing the playlist size.
    */
    private int getSize() {
        int size = 0;
        SongNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }
}
