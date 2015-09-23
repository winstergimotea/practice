package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winster on 5/2/14.
 */
public class LinkedList<T> {
    Node<T> firstLink;
    Node<T> lastLink;

    public LinkedList() {
        firstLink = null;
        lastLink = null;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);
        if(isEmpty())
            firstLink = node;
        else {
            node.setNext(firstLink);
            firstLink = node;
        }
    }

    public void delete(T value) {
        if(isEmpty())
            return;

        Node<T> prev = null;
        for(Node<T> curr = firstLink; curr != null; curr = curr.getNext()) {
            if(curr.getValue().equals(value)) {
                if(curr == firstLink)
                    firstLink = firstLink.getNext();
                else
                    prev.setNext(curr.getNext());
            } else {
                prev = curr;
            }
        }
    }

    public void deleteAt(int position) {
        if(isEmpty())
            return;

        int i=0;
        Node<T> prev = null;

        if(position==0) {
            firstLink = firstLink.getNext();
        } else {
            for(Node<T> curr = firstLink; curr != null; curr = curr.getNext()) {
                if(i==position) {
                    prev.setNext(curr.getNext());
                    break;
                }
                prev = curr;
                i++;
            }
        }
    }

    public void reverse(){
        if(isEmpty())
            return;

        if(firstLink.getNext() == null) {
            return;
        } else {
            Node<T> curr = firstLink;
            Node<T> next = firstLink.getNext();
            firstLink = firstLink.getNext();
            curr.setNext(null);
            reverse();
            next.setNext(curr);
        }
    }

    public List<T> asList() {
        List<T> ret = new ArrayList<T>();

        if(isEmpty())
            return ret;

        for(Node<T> curr = firstLink; curr != null; curr = curr.getNext())
            ret.add(curr.getValue());

        return ret;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            setValue(value);
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
    }
}
