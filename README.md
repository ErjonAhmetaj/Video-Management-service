# Video Rental Management System

A Java-based project simulating a video rental system. It uses binary search trees for efficient video management and linked lists for customer data.

## Features
- Add and manage customers
- Rent and return videos
- Search for movies
- Track rented videos

## How It Works
1. **Customer Management**: Customers are stored in a linked list (`CustomerList`), allowing easy addition and retrieval by phone number.
2. **Video Management**: Videos are stored in a binary search tree (`VideoBinaryTree`) for efficient searching and sorting by barcode.
3. **Renting Videos**: When a customer rents a video, the system checks if the video is available and if the customer hasn’t exceeded the rental limit (3 videos).
4. **Returning Videos**: When a video is returned, it’s marked as available, and the customer’s rented video list is updated.
5. **Searching**: You can search for videos by title or barcode and find out which customer has rented a specific video.

## Technologies
- Java
- Binary Search Tree (BST)
- Linked List

## Usage
1. Clone the repository.
2. Compile and run `Main.java`.
3. Follow the menu prompts to manage rentals.

## Example Commands
- Add a customer: `Contact Information`
- Rent a video: `Rent`
- Return a video: `Return`
- Search for a movie: `Search`
