package semi02.project.application;

import semi02.project.music.Music;
import semi02.project.music.MusicManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MusicApplication {
    private static MusicManager musicManager = MusicManager.getInstance(); //뮤직매니저 생성 싱글톤이끼 때문에 getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createMusic();
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------------");
            System.out.println("----------------- 플레이리스트에 노래 추가하기! -------------------");
            System.out.println("---- 1. 노래 추가 | 2. 앨범 추가 | 3. 플레이리스트 보기 | 4. 종료 ----");
            System.out.println("------------------------------------------------------------");
            System.out.print("선택: ");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addMusicFromSearch();
                    break;
                case 2:
                    addAlbum();
                    break;
                case 3:
                    musicManager.showPlaylist();
                    break;
                case 4:
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    //노래 생성
    private static void createMusic() {
        /* 노래 생성때매 배열에 넣는 작업이 귀찮으니 생성때부터 배열로 만들기.
         Music music1 = new Music("Attention", "뉴진스", "New Jeans");
        Music music2 = new Music("Hype Boy", "뉴진스", "New Jeans");
        Music music3 = new Music("Cookie", "뉴진스", "New Jeans");
        Music music4 = new Music("Hurt", "뉴진스", "New Jeans");
        Music music5 = new Music("OMG", "뉴진스", "OMG");
        Music music6 = new Music("Ditto", "뉴진스", "OMG");
          Music[] musics = {music1, music2, music3, music4, music5, music6, music7, music8, music9, music10, music11};
         */

        Music[] musics = {
                new Music("Attention", "뉴진스", "New Jeans"),
                new Music("Hype Boy", "뉴진스", "New Jeans"),
                new Music("Cookie", "뉴진스", "New Jeans"),
                new Music("Hurt", "뉴진스", "New Jeans"),
                new Music("OMG", "뉴진스", "OMG"),
                new Music("Ditto", "뉴진스", "OMG"),
                new Music("New Jeans", "뉴진스", "Get Up"),
                new Music("Super Shy", "뉴진스", "Get Up"),
                new Music("ETA", "뉴진스", "Get Up"),
                new Music("Get Up", "뉴진스", "Get Up"),
                new Music("ASAP", "뉴진스", "Get Up"),
                new Music("FEARLESS", "르세라핌", "FEARLESS"),
                new Music("ANTIFRAGILE", "르세라핌", "ANTIFRAGILE"),
                new Music("UNFORGIVEN", "르세라핌", "UNFORGIVEN"),
                new Music("이브, 프시케 그리고 푸른 수염의 아내", "르세라핌", "UNFORGIVEN"),
                new Music("EASY", "르세라핌", "EASY"),
                new Music("ELEVEN", "아이브", "ELEVEN"),
                new Music("LOVE DIVE", "아이브", "LOVE DIVE"),
                new Music("After LIKE", "아이브", "After LIKE"),
                new Music("Kitsch", "아이브", "I've IVE"),
                new Music("I AM", "아이브", "I've IVE"),
                new Music("Glory", "글로리", "Glory Manchester United"),
        };

        for (Music music : musics) {
            musicManager.addMusic(music);
        }
    }

    private static void addMusicFromSearch() {
        System.out.print("검색할 노래 제목 또는 가수를 입력하세요: ");
        scanner.nextLine();
        String keyword = scanner.nextLine();

        if (!keyword.isEmpty()) { //키워드가 비어있지 않으면
            ArrayList<Music> foundMusicList = musicManager.searchMusic(keyword);
            if (!foundMusicList.isEmpty()) {
                System.out.println("검색 결과:");
                for (int i = 0; i < foundMusicList.size(); i++) {
                    Music music = foundMusicList.get(i);
                    System.out.println((i + 1) + ". " + music.getTitle() + " - " + music.getArtist() + " (" + music.getAlbum() + ")");
                }

                System.out.print("추가할 노래 번호를 입력하세요: ");
                int index = scanner.nextInt();
                if (1 <= index && index <= foundMusicList.size()) {
                    Music selectedMusic = foundMusicList.get(index - 1);
                    musicManager.addToPlaylist(selectedMusic);
                    System.out.println(selectedMusic.getTitle() + "이(가) 플레이리스트에 추가되었습니다.");
                } else {
                    System.out.println("유효하지 않은 노래 번호입니다.");
                }
            } else {
                System.out.println("검색한 노래를 찾을 수 없습니다.");
            }
        } else {
            System.out.println("검색어를 입력하지 않았습니다.");
        }
    }
    private static void addAlbum() {
        System.out.print("공백을 입력하면 모든 앨범이 나옵니다.\n앨범명 또는 가수를 입력하세요: ");
        scanner.nextLine();
        String keyword = scanner.nextLine();

        //중복된 것 저장 하징 ㅏㄴㅎ기 위해서 hashSet 사용
        HashSet<String> noJoongBokAlbums = new HashSet<>();
        ArrayList<Music> albums = musicManager.searchByAlbum(keyword);
        if (!albums.isEmpty()) {
            System.out.println("검색된 앨범 목록:");
            for (Music music : albums) {
                noJoongBokAlbums.add(music.getAlbum()); // 중복 앨범 제거 HashSet은 중복저장x
            }

            int index = 1;
            for (String album : noJoongBokAlbums) {
                System.out.println((index++) + ". " + album);
            }

            System.out.print("추가할 앨범 번호를 입력하세요: ");
            int albumIndex = scanner.nextInt();
            if (1 <= albumIndex && albumIndex <= noJoongBokAlbums.size()) {
                String selectedAlbumName = (String) noJoongBokAlbums.toArray()[albumIndex - 1];
                ArrayList<Music> albumMusicList = musicManager.searchByAlbum(selectedAlbumName);
                for (Music music : albumMusicList) {
                    musicManager.addToPlaylist(music);
                }
                System.out.println(selectedAlbumName + " 앨범의 모든 노래가 플레이리스트에 추가되었습니다.");
            } else {
                System.out.println("유효하지 않은 앨범 번호입니다.");
            }
        } else {
            System.out.println("검색어와 일치하는 앨범이 없습니다.");
        }
    }
}


