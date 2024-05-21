import java.util.Scanner;

class Node {
    String musicFileName;
    Node next;

    public Node(String musicFileName) {
        this.musicFileName = musicFileName;
        this.next = null;
    }
}

public class LinkedList {

    public static Scanner sc = new Scanner(System.in);
    private int totalSongs = 0;

    public Node insertAtIndex(Node head, int index, String musicFileName) {
        Node newNode = new Node(musicFileName);
        
        if(index == 0) {
            newNode.next = head;
            setTotalSongs(getTotalSongs() + 1);
            return newNode;
        }

        Node prev = null;
        Node current = head;
        int count = 0;
        while(current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }

        if(count == index) {
            prev.next = newNode;
            newNode.next = current;
        }

        setTotalSongs(getTotalSongs() + 1);
        return head;
    }

    public Node deleteAtIndex(Node head, int index) {
        if(head == null || index < 0) {
            return head;
        }

        if(index == 0) {
            setTotalSongs(getTotalSongs() - 1);
            return head.next;
        }

        Node prev = null;
        Node current = head;
        int count = 0;

        while(current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }

        if(count == index && current != null) {
            prev.next = current.next;
        }

        setTotalSongs(getTotalSongs() - 1);
        return head;
    }

    public void printList(Node head) {
        Node current = head;

        if(head == null) {
            System.out.println("No music :(");
        }

        while(current != null) {
            System.out.println(current.musicFileName);
            current = current.next;
        }
        System.out.println();
    }

    public int getTotalSongs() {
        return totalSongs;
    }

    public void setTotalSongs(int totalSongs) {
        this.totalSongs = totalSongs;
    }

    public static void main(String[] args) {
        LinkedList songList = new LinkedList();
        Node head = null;

        System.out.println("--- Welcome to Music Player Playlist ---");

        while(true) {
            System.out.println();
            System.out.println("You can do the following operations.");
            System.out.println("1. To see all the music in your list.");
            System.out.println("2. To add a song at a specific place.");
            System.out.println("3. To delete a song at a specific place.");
            System.out.println("4. To quit application.");
            System.out.println();
            
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    songList.printList(head);
                    break;
                case 2:
                    head = add(head, songList);
                    break;
                case 3:
                    head = delete(head, songList);
                    break;
                case 4:
                    System.out.println("----Thank you----");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }       
        }
    }

    public static int getIndex(String info) {
        System.out.print("Enter the index where you want to " + info + ": ");
        return sc.nextInt();
    }

    public static String getMusicName() {
        System.out.print("Enter the name of the music file you want to add: ");
        sc.nextLine();
        return sc.nextLine();
    }

    public static Node add(Node head, LinkedList songList) {
        int index = getIndex("insert");
        if(index < 0 || index > songList.getTotalSongs()) {
            System.out.println("Index is out of bounds. Can not add.");
            return head;
        } else {
            head = songList.insertAtIndex(head, index, getMusicName());
            System.out.println("\nSong added successfully.");
            System.out.println("There are now " + songList.getTotalSongs() + " songs in the playlist.\n");
            return head;
        }
    }

    public static Node delete(Node head, LinkedList songList) {
        int index = getIndex("delete");
        if(index < 0 || index >= songList.getTotalSongs()) {
            System.out.println("Index is out of bounds. Can not delete.");
            return head;
        } else {
            head = songList.deleteAtIndex(head, index);
            System.out.println("\nSong deleted successfully.");
            System.out.println("There are now " + songList.getTotalSongs() + " songs in the playlist\n");
            return head;
        }
    }
}
