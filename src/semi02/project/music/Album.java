package semi02.project.music;

import java.util.ArrayList;

public class Album {

    private Music music;

    public Album(Music music) {
        this.music = music;
    }

    private String title;
    private String artist;
    private ArrayList<Music> musics;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.musics = new ArrayList<>();
    }

    public void addMusic(Music music) {
        musics.add(music);
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

