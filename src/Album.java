import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private List<Song> songsList;
    private String artist;

    public Album(String name, String artist) {
        this.name = name;
        this.songsList = new ArrayList<>();
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public boolean findSong(String title){
        for(Song s:songsList){
            if(s.getTitle().equals(title)) return true;
        }
        return false;
    }

    void addSongsToAlbum(String title, double time){
        Song s = new Song(title,time);
        if(findSong(s.getTitle())==true){
            System.out.println("Song already Added in Album");
        }
        else{
            songsList.add(s);
            System.out.println("New Song Added to Album");
        }
        return;

    }

    // polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playList){
        if(findSong(title)==true){
            for(Song song:songsList){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been Added to Playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song not present in the Album");
        }
        return;
    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playList){
        int index = trackNo-1;
        if(index>=0 && index< songsList.size()){
            playList.add(songsList.get(index));
            System.out.println("Song is added to PlayList");
        }
        else{
            System.out.println("Invalid TrackNo of song");
        }
        return;
    }
}
