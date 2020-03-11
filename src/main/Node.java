package main;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void addTail(Node head, T value){
        if(head.next == null) head.next = new Node(value, null);
        else addTail(head.next, value);
    }

    public void removeFirst(Node head){
        head.setValue(head.getNext().value);
        head.setNext(head.next.next);
    }

    public void removeLast(Node head){
        if(head.next != null){
            if(head.next.next == null){
                head.next = null;
            } else {
                removeLast(head.next);
            }
        }
    }

    public void remove(Node head, T value){
        if(head == null) return;
        if (head.value == value) {
            removeFirst(head);
        } else if (head.next.next == null && head.next.value == value) {
            removeLast(head);
        } else {
            remove(head.next, value);
        }
    }


    public void print(Node<String> head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public void printRecursively(Node head) {
        if (head == null) return;
        System.out.println(head.getValue());
        printRecursively(head.getNext());
    }
}
