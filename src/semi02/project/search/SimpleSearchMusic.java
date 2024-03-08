package semi02.project.search;

import semi02.project.music.Music;

import java.util.ArrayList;

public class SimpleSearchMusic implements SearchMusic {
    private ArrayList<Music> musicList;

    public SimpleSearchMusic(ArrayList<Music> musicList) {
        this.musicList = musicList;
    }

    @Override
    public Music search(String keyword) {
        for (Music music : musicList) {
            if (music.getTitle().contains(keyword) || music.getArtist().contains(keyword) || music.getAlbum().contains(keyword)) {
                return music;
            }
        }
        return null;
    }
}
