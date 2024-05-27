package org.example;


    public class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        private static class Node<T> {
            T data;
            Node<T> next;
            Node<T> prev;

            Node(T data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        // Add to the front of the list
        public void addFirst(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        // Add to the end of the list
        public void addLast(T data) {
            Node<T> newNode = new Node<>(data);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Remove the first node
        public T removeFirst() {
            if (head == null) {
                return null;
            }
            T data = head.data;
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return data;
        }

        // Remove the last node
        public T removeLast() {
            if (tail == null) {
                return null;
            }
            T data = tail.data;
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return data;
        }

        // Remove a specific item
        public boolean remove(T data) {
            if (head == null) {
                return false;
            }

            Node<T> current = head;

            // Search for the node to be removed
            while (current != null && !current.data.equals(data)) {
                current = current.next;
            }

            // Node not found
            if (current == null) {
                return false;
            }

            // Node is the head
            if (current == head) {
                return removeFirst() != null;
            }

            // Node is the tail
            if (current == tail) {
                return removeLast() != null;
            }

            // Node is in between
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return true;
        }

        // Get the size of the list
        public int size() {
            return size;
        }

        // Check if the list is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Print the list from the front
        public void printListForward() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Print the list from the end
        public void printListBackward() {
            Node<T> current = tail;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.addFirst(1);
            list.addLast(2);
            list.addFirst(0);
            list.printListForward(); // Output: 0 1 2
            list.printListBackward(); // Output: 2 1 0
            System.out.println("Size: " + list.size()); // Output: Size: 3

            list.removeFirst();
            list.printListForward(); // Output: 1 2
            list.removeLast();
            list.printListForward(); // Output: 1
            System.out.println("Size: " + list.size()); // Output: Size: 1

            list.addLast(3);
            list.addLast(4);
            list.printListForward(); // Output: 1 3 4
            list.remove(3);
            list.printListForward(); // Output: 1 4
            System.out.println("Size: " + list.size()); // Output: Size: 2
        }
    }



