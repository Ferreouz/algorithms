import Structs.BinaryNode;
import java.util.Queue;

public class TreeBreadthSearch {
    private Queue queue;
    
    public boolean TreeBreadthSearch(BinaryNode head, Integer value) {
        queue.add(head);
        
        while (!queue.isEmpty()) {
            BinaryNode current = (BinaryNode) queue.remove();
            if(current == null) {
                continue;
            }

            if (current.value == value) {
                return true;
            }
            
            queue.add(current.left);
            queue.add(current.rigth);
        }
        
        return false;
    }
}