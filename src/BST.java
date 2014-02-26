/**
 *
 * @author CreativeD
 */
public class BST {
    
    static Node n, root;
    static Node find;
    static StringBuilder stringBuilder = new StringBuilder();
    static String output = "";
    static BookForm parentFrame;
    
    static void insert(String t,String af,String al,long b, Node n) {
        if (root == null)
        {
            root = new Node();
            root.isbn = b;
            root.title = t;
            root.AuthorFName = af;
            root.AuthorLName = al;
            display(root);
        }
        else
        {
            if (t.compareTo(n.title) < 0)
            {
                if (n.left != null) 
                {
                    insert(t,af,al,b, n.left);
                } else 
                {
                    Node temp = new Node();
                    temp.isbn = b;
                    temp.title = t;
                    temp.AuthorFName = af;
                    temp.AuthorLName = al;
                    n.left = temp;
                    display(root);
                }
            } 
            else if (t.compareTo(n.title) > 0) 
            {
                if (n.right != null) 
                {
                    insert(t,af,al,b, n.right);
                } else
                {
                    Node temp = new Node();
                    temp.isbn = b;
                    temp.title = t;
                    temp.AuthorFName = af;
                    temp.AuthorLName = al;
                    n.right = temp;
                    display(root);
                }
            } 
            else if (t.equals(n.title)) 
            {
                n.count++;
                display(root);
            }
        }
    }
	
	
	static void display(Node n) {
        if (n == null) {
            return ;
        }
        display(n.left);
        display(n.right);

    }
        
        static void LoadBooks(String t,String af,String al,long b, Node n) {
        if (root == null)
        {
            root = new Node();
            root.isbn = b;
            root.title = t;
            root.AuthorFName = af;
            root.AuthorLName = al;
        }
        else
        {
            if (t.compareTo(n.title) < 0)
            {
                if (n.left != null) 
                {
                    LoadBooks(t,af,al,b, n.left);
                } else 
                {
                    Node temp = new Node();
                    temp.isbn = b;
                    temp.title = t;
                    temp.AuthorFName = af;
                    temp.AuthorLName = al;
                    n.left = temp;
                }
            } 
            else if (t.compareTo(n.title) > 0) 
            {
                if (n.right != null) 
                {
                    LoadBooks(t,af,al,b, n.right);
                } else
                {
                    Node temp = new Node();
                    temp.isbn = b;
                    temp.title = t;
                    temp.AuthorFName = af;
                    temp.AuthorLName = al;
                    n.right = temp;
                }
            } 
            else if (t.equals(n.title)) 
            {
                n.count++;
            }
        }
    }
 
    static Node SearchByName(String s,Node n)
    {
        if(s.equals(n.title))
        {
            find = n;
        }
        else if(s.compareTo(n.title) < 0)
        {
            if(n.left != null)
            {
                SearchByName(s,n.left);
            }
            else
                find = null;
        }
        else
        {
            if(n.right != null)
            {
                SearchByName(s,n.right);
            }
            else
                find = null;
        }
        return find;
    }
    
}
