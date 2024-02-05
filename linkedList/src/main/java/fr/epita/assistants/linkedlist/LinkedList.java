package fr.epita.assistants.linkedlist;

import javax.enterprise.inject.Default;
import java.util.Comparator;
import java.util.zip.Deflater;

public class LinkedList<T extends Comparable<T>> {

    Node head;
    public class Node {
        T data;
        Node next;
        Node(T d)
        {
            data = d;
            next = null;
        }
    }

    /**
     * Initializes the list
     **/

    public LinkedList() {
        head = null;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T elt) {
        Node node = new Node(elt);
        Node curr = head;
        if (curr == null)
        {
            head = node;
        }
        else {
            Node after = null;
            if (elt.compareTo(curr.data) <= 0)
            {
                after = curr;
                head = node;
                node.next = after;
                return;
            }
            while (curr.next != null)
            {
                if (elt.compareTo(curr.next.data) <= 0)
                {
                    after = curr.next;
                    curr.next = node;
                    node.next = after;
                    return;
                }
                else {
                    curr = curr.next;
                }
            }
            curr.next = node;
        }
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        if (i < 0 || i >= size() || head == null)
        {
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        while (curr != null && i != 0)
        {
            curr = curr.next;
            i--;
        }
        if (curr == null)
        {
            throw new IndexOutOfBoundsException();
        }
        return curr.data;
    }

    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        Node curr = head;
        if (curr.data == e) {
            curr = curr.next;
            return e;
        }
        Node prev = null;
        while (curr != null && curr.data != e)
        {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            return e;
        }
        return null;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        int i = 0;
        Node curr = head;
        while (curr != null)
        {
            i++;
            curr = curr.next;
        }
        return i;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        head = null;
    }
}
