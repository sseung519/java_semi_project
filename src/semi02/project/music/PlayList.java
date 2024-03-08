package semi02.project.music;

import java.util.ArrayList;

public class PlayList {
    private ArrayList<Music> musicList;


    public PlayList() {
        this.musicList = new ArrayList<>();
    }

    public void addMusic(Music music) {
        musicList.add(music);
    }

}
