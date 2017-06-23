import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Devang on 6/21/2017.
 */
public class BinaryTree<E> {
    BNode<E> root;
    Queue<BNode> myQ;
    
    public BinaryTree() {
        this.myQ = new LinkedList<>();
    }
    
    protected class BNode<E>{
        protected E data;
        protected BNode<E> left;
        protected BNode<E> right;
        
        protected BNode(E data) {
            this.data = data;
        }
    }
    
    public void insert(E data){
        BNode newNode = new BNode(data);
        if(this.root == null){
            this.root = newNode;
        } else {
            BNode current = myQ.peek();
            if(current.left == null){
                current.left = new BNode(data);
            } else if(current.right == null){
                current.right = new BNode(data);
                myQ.remove();
            }
        }
        myQ.add(newNode);
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        insertAll(a);
        
        
    }
    
    public static void insertAll(int[] list){
        
    }
    
}
