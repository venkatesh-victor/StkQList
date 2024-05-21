import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PriorityQueue {
    private List<Integer> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(int item) {
        int i = 0;
        while (i < queue.size() && queue.get(i) <= item) {
            i++;
        }
        queue.add(i, item);
    }

    public Integer delete() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null;
        }
    }

    public void display() {
        System.out.println(queue);
    }
}

class Schedule {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        System.out.println("---- Scheduling using priority queue ----");

        while (true) {
            System.out.println("\nYou can do the following operations.");
            System.out.println("1. Add a job");
            System.out.println("2. Complete the high priority job that's in the queue.");
            System.out.println("3. View the schedule.");
            System.out.println("4. Exit the application.\n");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: insert(pq); break;
                case 2: delete(pq); break;
                case 3: display(pq); break;
                case 4: exit(); break;
                default: alert();
            }
        }
    }

    public static void insert(PriorityQueue pq) {
        System.out.print("Enter the priority of the job: ");
        int priority = sc.nextInt();

        pq.insert(priority);
        
        System.out.println("The job with the priority of " + priority + " is added to the queue.");
    }

    public static void delete(PriorityQueue pq) {
        if(!pq.isEmpty()) {
            System.out.println("The job with the priority of " + pq.delete() + " is completed");
        } else {
            System.out.println("The queue is empty. Nothing to remove.");
        }
    }

    public static void display(PriorityQueue pq) {
        System.out.println("Here are the current job that are enqueued.");
        pq.display();
    }

    public static void exit () {
        System.out.println("Thank you for using the scheduler.");
        System.exit(0);
    }

    public static void alert() {
        System.out.println("Invalid input. Try again.");
    }
}

