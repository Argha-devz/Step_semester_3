import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        songs = new String[capacity];
        songCount = 0;
    }

    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
        }
    }

    public String[] getSongs() {
        // Return a safe copy of only the added songs so external modifications don't affect the original array
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}