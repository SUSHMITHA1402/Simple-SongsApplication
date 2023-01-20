import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album ab1 = new Album("Robo","Rehman");
        ab1.addSongsToAlbum("hey robo",5.2);
        ab1.addSongsToAlbum("Andam ana",5);
        ab1.addSongsToAlbum("Neloo valapu",4.2);

        Album ab2 = new Album("Arjiths Hits","Arjith Sing");
        ab2.addSongsToAlbum("Kesariya",4);
        ab2.addSongsToAlbum("Jeena Jeena",3.05);
        ab2.addSongsToAlbum("Gerua",6);

        albums.add(ab1);
        albums.add(ab2);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        ab1.addToPlaylistFromAlbum("Neloo valapu",myPlaylist);
        ab2.addToPlaylistFromAlbum(2,myPlaylist);


        System.out.println(ab1.findSong("hey robo"));
        Song sample = new Song("Sushmi",5);
        System.out.println(sample);
        play(myPlaylist);

    }
    public static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playList.listIterator();
        if(playList.size()>0){
            System.out.println("Currently Playing - ");
            System.out.println(itr.next());
        }
        else{
            System.out.println("PlayList is Empty");
            return;
        }

        System.out.println("Enter Your Choice : ");
        printMenu();

        boolean isForward = true;
        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                            itr.next();
                            isForward = true;
                    }
                    if(itr.hasNext()) System.out.println(itr.next());
                    else System.out.println("Reached End of PlayList");
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()) System.out.println(itr.previous());
                    else System.out.println("You are at the start of PlayList");
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                        else {
                            System.out.println("Song not present");
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward = true;
                        }
                        else{
                            System.out.println("Song not present");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    itr.remove();
                    break;
                case 6:
                    printAllSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }
    public static void printAllSongs(LinkedList<Song> playList){
        for(Song song:playList){
            System.out.println(song);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1 - Play Next Song");
        System.out.println("2 - Play Previous Song");
        System.out.println("3 - Repeat the Current Song");
        System.out.println("4 - Show Menu Again");
        System.out.println("5 - Delete the Current Song");
        System.out.println("6 - Print All the Songs in Current Playlist");
        System.out.println("7 - Exit");
        return ;
    }
}