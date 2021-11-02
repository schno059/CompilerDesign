import java.util.List;
import java.util.LinkedList;

public class Node {
    private List<Node> children = null;
    private String value;

    public Node(String value)
    {
        this.children = new LinkedList<>();
        this.value = value;
    }

    public void addChild(Node child)
    {
        children.add(child);
    }

    public Node getChild(String childName)
    {
        Node returnNode = null;
        for(int i = 0; i<this.children.size(); i++)
            if(this.children.get(i).getValue().equals(childName))
                returnNode = this.children.get(i);
        return returnNode;
    }

    public String getValue()
    {
        return this.value;
    }

    public String toString()
    {
        String returnString = value;
        if(children!=null)
            returnString += this.children.toString();
        return returnString;
    }

}