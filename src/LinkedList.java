import java.util.Scanner;
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(int size) {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null; // true is list is empty
    }

    /**
     * Adds a new node to the lined list
     * @param data - the String we are adding
     */
    public void add(String data){
        Node node = new Node(data);// make a new node object
        if (isEmpty()){ //if the list is empty this is the first item
            head = node;
            tail = node;
        } else { // otherwise add it to the tail
            tail.setNext(node); // what was the tail is now pointing to the new item
            tail = node; // the new item is now the tail
        }size++;
    }

    public void print(){
        Node next = head;
        while (next != null){
            System.out.println(next.getData());
            next = next.getNext();
        }
    }

    public String search(String item) {
        Node next = head;
        while (next != null) {
            if (next.getData().equals(item)){
               return item;
            }
            next = next.getNext();
        }
        return "";
    }

    public void remove(String item) {
        if (isEmpty()) {
            return;
        }


        if (head.getData().equals(item)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }
        Node current = head;

        while (current.getNext() != null) {
            if (current.getNext().getData().equals(item)) {
                if (current.getNext() == tail) {
                    tail = current;
                }
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }
    public boolean replace(String oldItem, String newItem){
        Node current = head;
        while (current != null) {
            if (current.getData().equals(oldItem)){
                current.setData(newItem);
                return true;
            } current = current.getNext();
        }
        return false;
    }

    public void delete(int index){
        if (index < 0 || index >= size){
            return;
        }

        if (index == 0){
            head = head.getNext();
            if (head == null){
                tail = null;
            }
            size--;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++){
            current = current.getNext();
        }

        if (current.getNext() == tail){
            tail = current;
        }

        current.setNext(current.getNext().getNext());
        size--;
    }
    public void addAtHead(String data){
        Node node = new Node(data);
        if (isEmpty()){
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    } public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 7){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add item");
            System.out.println("2. Add at head");
            System.out.println("3. Remove item");
            System.out.println("4. Replace item");
            System.out.println("5. Delete by index");
            System.out.println("6. Print list");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1){
                System.out.print("Enter item: ");
                add(sc.nextLine());
            }
            else if (choice == 2){
                System.out.print("Enter item: ");
                addAtHead(sc.nextLine());
            }
            else if (choice == 3){
                System.out.print("Enter item to remove: ");
                remove(sc.nextLine());
            }
            else if (choice == 4){
                System.out.print("Old item: ");
                String oldItem = sc.nextLine();
                System.out.print("New item: ");
                String newItem = sc.nextLine();
                boolean result = replace(oldItem, newItem);
                if (!result){
                    System.out.println("Item not found.");
                }
            }
            else if (choice == 5){
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                delete(index);
            } else if (choice == 6){
                print();
            }
        }
    }
}

