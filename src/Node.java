/**
 *
 * @author CreativeD
 */
public class Node {
    
    long isbn;
    int count;
    Node left;
    Node right;
    String title;
    String AuthorFName;
    String AuthorLName;

    public Node() 
    {
        this.left = null;
        this.right = null;
        this.isbn = 0;
        this.count = 1;
    }
}
