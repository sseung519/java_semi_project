package semi02.project.music;

public class Music {
    private String title;
    private String artist;
    private String album;

    public Music(String title, String artist, String album){
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
