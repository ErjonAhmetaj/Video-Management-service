public class Video {
    public String barcode;
    public String title;
    public boolean isRented; // set to false changed to true whenever video is rented
    public Video left;
    public Video right;
    public String num; // Storing the phone number of the customer who rented this video

    public Video(String barcode, String title) {
        this.barcode = barcode;
        this.title = title;
        this.isRented = false;
        this.left = null;
        this.right = null;
        this.num = null;
    }

    public boolean isAvailable() {
        return !this.isRented;
    }

    public void rentVideo(String customerPhoneNumber) {
        this.isRented = true;
        this.num = customerPhoneNumber;
    }

    public String toString() {
        String videoStatus;
        if (isRented) { // if true , set to rented otherwise it's availabe.
            videoStatus = " (Rented)";
        } else {
            videoStatus = " (Available)";
        }

        return barcode + " " + title + videoStatus;
    }
}
