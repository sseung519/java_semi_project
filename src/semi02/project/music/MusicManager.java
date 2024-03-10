package semi02.project.music;

import java.util.ArrayList;

public class MusicManager {
    private static MusicManager instance;
    private ArrayList<Music> musicList;
    private ArrayList<Music> playlist;

    private MusicManager() {
        musicList = new ArrayList<>();
        playlist = new ArrayList<>();
    }

    public static MusicManager getInstance() {
        if (instance == null) {
            instance = new MusicManager();
        }
        return instance;
    }

    public void addMusic(Music music) {
        musicList.add(music);
    }

    public ArrayList<Music> searchMusic(String keyword) {
        ArrayList<Music> foundMusicList = new ArrayList<>();
        for (Music music : musicList) {
            if (music.getTitle().contains(keyword) || music.getArtist().contains(keyword) || music.getAlbum().contains(keyword)) {
                foundMusicList.add(music);
            }
        }
        return foundMusicList;
    }

    //스캐너로 입력받은 keyword와 비교! equals보단 contains를 사용하여 실제 음악 앱들의 검색 형태와 같게함.
    public ArrayList<Music> searchByAlbum(String keyword) {
        ArrayList<Music> foundMusicList = new ArrayList<>();
        for (Music music : musicList) {
            if (music.getAlbum().contains(keyword) || music.getArtist().contains(keyword)) {
                foundMusicList.add(music);
            }
        }
        return foundMusicList;
    }

    public void addToPlaylist(Music music) {
        playlist.add(music);
    }

    public void showPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("플레이리스트가 비어 있습니다.");
        } else {
            System.out.println("---------- 플레이리스트 ----------");
            for (int i = 0; i < playlist.size(); i++) {
                Music music = playlist.get(i);
                System.out.println((i + 1) + ". " + music.getTitle() + " - " + music.getArtist() + " (" + music.getAlbum() + ")");
            }
            System.out.println("---------------------------------");
        }
    }
}
