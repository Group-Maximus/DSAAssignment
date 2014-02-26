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
        
    static boolean DeleteByName(String s,Node n) 
    {
        if(root == null){
            //JOptionPane.showMessageDialog(parentFrame,"No items to delete");
            return false;
        }
        Node d = n;
        Node parent = n;
        boolean isLeft = true;
        while(!s.equals(d.title))
        {
            parent = d;
            if(s.compareTo(d.title) < 0)
            {
                d = d.left;
                isLeft = true;
            }
            else
            {
                d = d.right;
                isLeft = false;
            }
            if(d == null)
            {
                return false;
            } 
        }
        if(d.count > 1)
        {
            d.count--;
        }
        else
        {
            if(d.left == null && d.right == null)
            {
                if(d == root)
                    root = null;
                else if (isLeft)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else if (d.left == null)
            {
                if(d == root)
                    root = d.right;
                else if(isLeft)
                    parent.left = d.right;
                else
                    parent.right = d.right;
               
            }
            else if (d.right == null)
            {
                if(d == root)
                    root = d.left;
                else if(isLeft)
                    parent.left = d.left;
                else
                    parent.right = d.left;
            }
            else
            {
                Node replacer = FindReplacer(d);
                if(d == root)
                    root = replacer;
                else if(isLeft)
                    parent.left = replacer;
                else
                    parent.right = replacer;
                replacer.left = d.left;           
            }
        }
        return true;
    }

    static Node FindReplacer(Node del) 
    {
        Node repParent = del;
        Node current = del;
        Node replacer = del;
        while(current != null)
        {
            repParent = replacer;
            replacer = current;
            current = replacer.right;
        }
        if(replacer.left != null)
        {
            repParent.right = replacer.left;
            replacer.right = del.right;
        }
        return replacer;
    }    
    
}
