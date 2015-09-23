package practice;

/**
 * Created by winster on 5/2/14.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);
        if(isEmpty())
            root = node;
        else {
          Node<T> prev = null;
          for(Node<T> curr = root;;
            curr = curr.getValue().compareTo(value) > 0 ? curr.getLeft() : curr.getRight()){
              if(curr == null) {
                  if(prev.getValue().compareTo(value) > 0)
                    prev.setLeft(node);
                  else
                    prev.setRight(node);
                  break;
              }
              prev = curr;
          }
        }
    }

    public void delete(T value) {
        SearchNodeWithParent searchResult = searchWithParent(value);
        if(searchResult != null) {
            if(searchResult.getParent() == null && searchResult.getSearchNode().isLeaf()) {
                root = null;
            } else {
               if(searchResult.getSearchNode().isLeaf())
                    deleteLeaf(searchResult.getSearchNode(), searchResult.getParent());
                else if(searchResult.getSearchNode().hasOneChild())
                    deleteNodeWithOneChild(searchResult.getSearchNode(), searchResult.getParent());
                else if(searchResult.getSearchNode().hasBothChildren())
                    deleteNodeWithBothChildren(searchResult.getSearchNode(), searchResult.getParent());
            }
        }
    }

    private void deleteLeaf(Node<T> nodeToDel, Node<T> parent){
        if(nodeToDel.getValue().compareTo(parent.getValue()) > 0)
            parent.setRight(null);
        else
            parent.setLeft(null);
    }

    private void deleteNodeWithOneChild(Node<T> nodeToDel, Node<T> parent){
        Node<T> nodeToDelChild = nodeToDel.getLeft() == null ? nodeToDel.getRight() : nodeToDel.getLeft();
        if(nodeToDel.getValue().compareTo(parent.getValue()) > 0)
            parent.setRight(nodeToDelChild);
        else
            parent.setLeft(nodeToDelChild);
    }

    private void deleteNodeWithBothChildren(Node<T> nodeToDel, Node<T> parent){

    }

    public Node<T> search(T value) {
        SearchNodeWithParent result = searchWithParent(value);
        return result == null ? null : result.getSearchNode();
    }


    private SearchNodeWithParent<T> searchWithParent(T value) {
        Node<T> prev = null;
        if(!isEmpty()) {
            for(Node<T> curr = root; curr != null;
                curr = (curr.getValue().compareTo(value) > 0 ? curr.getLeft() : curr.getRight())) {
                if(curr.getValue().equals(value))
                    return new SearchNodeWithParent<T>(curr, prev);
            }
        }
        return null;
    }

    static class Node<T extends Comparable<T>> {
        T value;
        Node<T> left, right;

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasOneChild() {
            return (left == null && right != null) || (left != null && right == null);
        }

        public boolean hasBothChildren() {
            return !(left == null || right == null);
        }

        public Node(T value) {
            setValue(value);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    static class SearchNodeWithParent<T extends Comparable<T>> {
        Node<T> parent, searchNode;

        public SearchNodeWithParent(Node<T> searchNode, Node<T> parent) {
            this.parent = parent;
            this.searchNode = searchNode;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getSearchNode() {
            return searchNode;
        }

        public void setSearchNode(Node<T> searchNode) {
            this.searchNode = searchNode;
        }
    }
}
