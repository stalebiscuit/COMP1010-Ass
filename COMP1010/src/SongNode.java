public class SongNode {
    private Song song;     
    private SongNode next;  
    private SongNode prev;  

    /*
       Constructor to create a new SongNode with a given Song.
       Initializes the node with the specified song and sets 
       next and prev pointers to null.
    */
    public SongNode(Song song) {
        this.song = song;  
        this.next = null;   
        this.prev = null;    
    }

    /*
       Method to retrieve the song contained in this node.
       Returns the song stored in the 'song' variable.
    */
    public Song getSong() {
        return song;       
    }

    /*
       Method to retrieve the next SongNode.
       Returns the next node in the playlist.
    */
    public SongNode getNext() {
        return next;        
    }

    /*
       Method to set the next SongNode.
       Updates the pointer to the next node in the playlist.
    */
    public void setNext(SongNode next) {
        this.next = next;   
    }

    /*
       Method to retrieve the previous SongNode.
       Returns the previous node in the playlist.
    */
    public SongNode getPrev() {
        return prev;        
    }

    /*
       Method to set the previous SongNode.
       Updates the pointer to the previous node in the playlist.
    */
    public void setPrev(SongNode prev) {
        this.prev = prev;   
    }
}
