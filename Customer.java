public class Customer {
    public String number;
    public String first;
    public String last;
    public String video1;
    public String video2;
    public String video3;
    public Customer next;

    public Customer(String number, String first, String last) {
        this.number = number;
        this.first = first;
        this.last = last;
        this.video1 = null;
        this.video2 = null;
        this.video3 = null;
        this.next = null;
    }

    public boolean canRentMoreVideos() {
        return getNumberOfRentedVideos() < 3;
    }

    public void addRentedVideo(String barcode) {
        if (video1 == null) {
            video1 = barcode;
        } else if (video2 == null) {
            video2 = barcode;
        } else if (video3 == null) {
            video3 = barcode;
        }
    }

    public void removeRentedVideo(String barcode) {
        if (video1 != null && video1.equals(barcode)) {
            video1 = null;
        } else if (video2 != null && video2.equals(barcode)) {
            video2 = null;
        } else if (video3 != null && video3.equals(barcode)) {
            video3 = null;
        }
    }

    public int getNumberOfRentedVideos() {
        int count = 0;
        if (video1 != null)
            count++;
        if (video2 != null)
            count++;
        if (video3 != null)
            count++;
        return count;
    }

    public String toString() {
        return number + " " + first + " " + last;
    }
}
