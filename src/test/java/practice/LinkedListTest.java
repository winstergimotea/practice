package practice;

import org.junit.Test;
import java.util.List;

public class LinkedListTest {
    @Test
    public void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(9);
        assert "[9, 8, 2, 1]".equals(list.asList().toString()) : list.asList() + " not equal to [9, 8, 2, 1]";
    }

    @Test
    public void testLinkedListRemove(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(9);
        list.delete(9);
        list.delete(1);
        list.delete(8);
        assert "[2]".equals(list.asList().toString()) : list.asList() + " not equal to [2]";
    }

    @Test
    public void testLinkedRemoveAt(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(9);
        list.deleteAt(1);
        assert "[9, 2, 1]".equals(list.asList().toString()) : list.asList() + " not equal to [9, 2, 1]";
    }

    @Test
    public void testLinkedReverse(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(9);
        list.reverse();
        List<Integer> list1 = list.asList();
        list.reverse();
        List<Integer> list2 = list.asList();
        assert "[1, 2, 8, 9]".equals(list1.toString()) : list1 + " not equal to [1, 2, 8, 9]";
        assert "[9, 8, 2, 1]".equals(list2.toString()) : list2 + " not equal to [9, 8, 2, 1]";
    }

    @Test
    public void test(){
        System.out.println("asdasdad".hashCode() & 15);

        assert true;
    }
}