package week08_interface;

public interface Searchable {
    void search(String url);
    
    default void setMute(boolean mute) { 
        if (mute) {
            System.out.println("Searchable - 무음 처리");
        }
        else {
            System.out.println("Searchable - 무음 해제");
        }
    }
}
