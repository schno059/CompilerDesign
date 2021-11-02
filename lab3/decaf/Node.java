import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class Node {
    private List<Node> children = null;
    private HashMap<String, String> localTable;

    public Node()
    {
        this.children = new LinkedList<>();
        this.localTable = new HashMap<String, String>();
    }

    public void declare(String name, String type)
    {
        this.localTable.put(name,type);
    }

    public String use(Node root, String name)
    {
        return getType(root, name);
    }

    public Node enterScope()
    {
        Node newNode = new Node();
        children.add(newNode);
        return newNode;
    }

    public Node exitScope(Node root)
    {
        Node exitAttempt = getParent(root, this);
        if(exitAttempt==null)
            return this;
        else
            return exitAttempt;
    }

    private Node getParent(Node top, Node query)
    {
        Node returnNode = null;
        // System.out.println(top);
        for(int i = 0; i<top.getChildren().size(); i++)
        {
            Node currentChild = top.getChildren().get(i);
            ;
            if(currentChild.equals(query))
            {
                returnNode = top;
            }
            else if(getParent(currentChild, query)!=null)
            {
                returnNode = getParent(currentChild, query);
            }

        }
        // System.out.println(returnNode);
        return returnNode;
    }

    // private Node getParent(Node top, Node query)
    // {
    //     Node returnNode = null;
    //     for(int i = 0; i<top.children.size(); i++)
    //     {
    //         if(top.children.get(i).equals(query))
    //             returnNode = top;
    //     }
    //     for(int i = 0; i<top.children.size(); i++)
    //     {
    //         if(getParent(top.children.get(i), query).equals(query))
    //             returnNode = top;
    //     }
    //     return returnNode;
    // }

    private List<Node> getChildren()
    {
        return this.children;
    }

    public String getType(Node root, String name)
    {
        String returnString = getLocalType(name);
        Node parent = getParent(root, this);
        if(returnString==null && parent!=null)
        {
            String parentGetType = parent.getType(root, name);
            if(parentGetType!=null)
                returnString = parentGetType;
        }
        return returnString;
    }

    public String getLocalType(String name)
    {
        return this.localTable.get(name);
    }

    public String toString()
    {
        return toString(0);
    }

    private String toString(int indents)
    {
        String returnString = "";
        for(HashMap.Entry mapelement : localTable.entrySet())
        {
            returnString+="\n";
            for(int i=0; i<indents; i++){returnString+="\t";}
            returnString+=mapelement.toString();
        }
        for(Node child : this.children)
        {
            returnString+="\n"+child.toString(indents+1);
        }
        return returnString;
    }

}