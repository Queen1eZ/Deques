package deques;

/**
 * @see Deque
 */
public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        size = 0;
        sentinel();
    }

    private void sentinel() {
        // Create the front sentinel node
        front = new Node<>(null);
        // Create the back sentinel node
        back = new Node<>(null);
        // Pointing to each other simplifies the operation of linked lists
        front.next = back;
        back.prev = front;
    }

    // Add an item to the beginning of the deque
    public void addFirst(T item) {
        size += 1;
        // Create a new node
        Node<T> node1 = new Node<>(item);

        // Insert the new node at the beginning
        node1.next = front.next;
        node1.prev = front;

        // Update the connections
        front.next.prev = node1;
        front.next = node1;
    }

    // Add an item to the end of the deque
    public void addLast(T item) {
        size += 1;
        Node<T> node2 = new Node<>(item);

        // Insert the new node at the end
        node2.prev = back.prev;
        node2.next = back;

        // Update the connections
        back.prev.next = node2;
        back.prev = node2;
    }

    // Removes and returns the item at the front of the deque
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;

        // Get the first node
        Node<T> node1 = front.next;

        // Update the connections to bypass the removed node
        front.next = node1.next;
        front.next.prev = front;

        // Return the value of the removed node
        return node1.value;
    }

    // Removes and returns the item at the back of the deque
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;

        // Get the last node
        Node<T> node2 = back.prev;

        // Update the connections to bypass the removed node
        back.prev = node2.prev;
        back.prev.next = back;

        // Return the value of the removed node
        return node2.value;
    }

    // Gets the item at the given index
    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }

        Node<T> curr;

        if (index < size / 2)
        {
            // Index is closer to the front
            // Start from the first node
            curr = front.next;

            // Traverse the deque to find the node at the given index
            for (int i = 0; i < index; i++)
            {
                curr = curr.next;
            }
        }
        else
        {
            // Index is closer to the back
            // Start from the back node
            curr = back.prev;

            // Traverse the deque to find the node at the given index
            for (int i = size -1; i > index; i--)
            {
                curr = curr.prev;
            }
        }

        // Return the value of the node at the given index
        return curr.value;
    }

    public int size() {
        return size;
    }
}
