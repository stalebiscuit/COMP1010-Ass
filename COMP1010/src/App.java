public class App {
    public static void main(String[] args) throws Exception {
        Song test = new Song(2012, "jamesBong", "balls", 2);
        Playlist testplay = new Playlist();
        testplay.addSong(test);
        System.out.println(testplay.contents.get(0));
        System.out.printf("Listening to: " + //testplay.contents.get(0)); im gonna neck myself its too confusing
    }
}
