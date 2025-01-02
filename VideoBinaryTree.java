public class VideoBinaryTree {
    public Video root;

    public VideoBinaryTree() {
        this.root = null;
    }

    public void insert(String barcode, String title) {
        root = insertRecursive(root, barcode, title);
    }

    private Video insertRecursive(Video current, String barcode, String title) {
        if (current == null) {
            return new Video(barcode, title); // if the root is null then we are going to make a new Video
        }
        if (barcode.compareTo(current.barcode) < 0) { // check and see if it belongs on left or right of the tree/ left
                                                      // = < and right = >
            current.left = insertRecursive(current.left, barcode, title);
        } else if (barcode.compareTo(current.barcode) > 0) {
            current.right = insertRecursive(current.right, barcode, title);
        }
        return current;
    }

    public Video findVideoByBarcode(String barcode) {
        return findVideoByBarcode(root, barcode);
    }

    public Video findVideoByBarcode(Video current, String barcode) {
        if (current == null) {
            return null;
        }

        if (barcode.equals(current.barcode)) { // traverse the tree looking for the video by comparing barcodes
            return current;
        } else if (barcode.compareTo(current.barcode) < 0) {
            return findVideoByBarcode(current.left, barcode); // Search in the left subtree
        } else {
            return findVideoByBarcode(current.right, barcode); // Search in the right subtree
        }
    }

    public void rent(CustomerList cl, String customerPhoneNumber, String videoBarcode) {
        Customer customer = cl.findCustomerByPhoneNumber(customerPhoneNumber);
        if (customer == null) { // check and see if we even have a customer
            System.out.println("Cannot rent video: Customer not found");
            return;
        }

        if (!customer.canRentMoreVideos()) { // using 2 methods in our customer class we are able to see if we are able
                                             // to rent a movie depending on if the user has less than 4 movies out
            System.out.println("Cannot rent video: Exceeded rent limit");
            return;
        }

        Video video = this.findVideoByBarcode(videoBarcode); // we are setting the Video = to the current video with the
                                                             // same barcode
        if (video == null) {
            System.out.println("Cannot rent video: Video not found");
            return;
        }

        if (!video.isAvailable()) { // check and see if the movie is available for renting
            System.out.println("Cannot rent video: Video is already rented");
            return;
        }
        // if we pass all cases when now add our customers number to the Video
        // and add the barcode into video1-3 depening on how many they have out
        video.rentVideo(customerPhoneNumber);
        customer.addRentedVideo(videoBarcode);
        System.out.println("Video rented successfully");
    }

    public void returnVideo(CustomerList cl, String customerPhoneNumber, String videoBarcode) {
        Customer customer = cl.findCustomerByPhoneNumber(customerPhoneNumber);
        if (customer == null) {
            System.out.println("Return failed: Customer not found");
            return;
        }

        Video video = this.findVideoByBarcode(videoBarcode);
        if (video == null) {
            System.out.println("Return failed: Video not found");
            return;
        }

        if (!video.isRented || !video.num.equals(customerPhoneNumber)) {
            System.out.println("Return failed: Video not rented by this customer");
            return;
        }

        video.isRented = false;
        video.num = null; // Clearing the phone number from the video
        customer.removeRentedVideo(videoBarcode);
        System.out.println("Video returned successfully");
    }

    public Video findVideoByTitle(String title) {
        return findVideoByTitle(root, title); // Call the private helper method
    }

    private Video findVideoByTitle(Video current, String title) {
        // Recursive private helper method
        if (current == null) {
            return null;
        }
        if (title.equalsIgnoreCase(current.title)) {
            return current;
        }
        Video found = findVideoByTitle(current.left, title); // Search in the left subtree
        if (found == null) {
            found = findVideoByTitle(current.right, title); // Search in the right subtree
        }
        return found;
    }

    public void findWhoHasVideoRented(CustomerList cl, String title) {
        Video video = findVideoByTitle(title);
        if (video == null || !video.isRented) {
            System.out.println("No one has rented '" + title + "' or the video does not exist.");
            return;
        }

        Customer customer = cl.findCustomerByPhoneNumber(video.num); // we are using a seperate fuction and setting the result of it to our customer
        if (customer != null) {
            System.out.println("Customer who rented '" + title + "': " + customer);
        } else {
            System.out.println("Customer data not found for the rented video.");
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Video v) {
        if (v == null) {
            return;
        }
        printInOrder(v.left);
        System.out.println(v);
        printInOrder(v.right);
    }
}
