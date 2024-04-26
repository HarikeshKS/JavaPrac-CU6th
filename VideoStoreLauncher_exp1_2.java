class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int totalRatings;
    
    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.totalRatings = 0;
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean isCheckedOut() {
        return checkedOut;
    }
    
    public void checkOut() {
        checkedOut = true;
    }
    
    public void returnVideo() {
        checkedOut = false;
    }
    
    public void receiveRating(int rating) {
        averageRating = (averageRating * totalRatings + rating) / (totalRatings + 1);
        totalRatings++;
    }
    
    public double getAverageRating() {
        return averageRating;
    }
}

class VideoStore {
    private Video[] inventory;
    private int count;
    
    public VideoStore() {
        this.inventory = new Video[10];
        this.count = 0;
    }
    
    public void addVideo(String title) {
        if (count < inventory.length) {
            inventory[count++] = new Video(title);
            System.out.println("Video \"" + title + "\" added to inventory.");
        } else {
            System.out.println("Inventory is full. Cannot add more videos.");
        }
    }
    
    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && !video.isCheckedOut()) {
                video.checkOut();
                System.out.println("Video \"" + title + "\" checked out.");
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found or already checked out.");
    }
    
    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && video.isCheckedOut()) {
                video.returnVideo();
                System.out.println("Video \"" + title + "\" returned.");
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found or not checked out.");
    }
    
    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                System.out.println("Rating received for video \"" + title + "\".");
                return;
            }
        }
        System.out.println("Video \"" + title + "\" not found.");
    }
    
    public void listInventory() {
        System.out.println("Inventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println(video.getTitle() + " (Checked Out: " + video.isCheckedOut() +
                                   ", Average Rating: " + video.getAverageRating() + ")");
            }
        }
    }
}

public class VideoStoreLauncher_exp1_2 {
    public static void main(String[] args) {
        VideoStore videoStoreObj = new VideoStore();

        videoStoreObj.addVideo("The Matrix");
        videoStoreObj.addVideo("Godfather II");
        videoStoreObj.addVideo("Star Wars Episode IV: A New Hope");

        videoStoreObj.receiveRating("The Matrix", 4);
        videoStoreObj.receiveRating("The Matrix", 5);
        videoStoreObj.receiveRating("Godfather II", 5);
        videoStoreObj.receiveRating("Godfather II", 4);
        videoStoreObj.receiveRating("Star Wars Episode IV: A New Hope", 3);
        videoStoreObj.receiveRating("Star Wars Episode IV: A New Hope", 4);

        videoStoreObj.checkOut("The Matrix");
        videoStoreObj.returnVideo("The Matrix");

        videoStoreObj.checkOut("Godfather II");

        videoStoreObj.listInventory();
    }
}
