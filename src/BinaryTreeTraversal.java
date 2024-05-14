import Structs.BinaryNode;
import java.util.ArrayList;

public class BinaryTreeTraversal {
    public ArrayList<Integer> BinaryTreeTraversal(BinaryNode head, ArrayList<Integer> path) {
        if (head == null) {
            return path;
        }
        BinaryTreeTraversal(head.left, path);
        path.add(head.value);
        BinaryTreeTraversal(head.rigth, path);

        return path;
    }
}   
