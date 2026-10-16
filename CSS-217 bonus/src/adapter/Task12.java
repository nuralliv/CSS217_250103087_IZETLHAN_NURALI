package adapter;

public class Task12 {
    interface MediaPlayer { void playAudio(String filename); }
    static class VlcEngine {
        void startPlayback(String filepath, int volume) {
            System.out.println("VLC playing " + filepath + " at volume " + volume);
        }
    }
    static class VlcAdapter implements MediaPlayer {
        private final VlcEngine engine;
        VlcAdapter(VlcEngine e) { this.engine = e; }
        public void playAudio(String filename) { engine.startPlayback(filename, 80); }
    }
    public static void main(String[] args) {
        new VlcAdapter(new VlcEngine()).playAudio("song.mp3");
    }
}
