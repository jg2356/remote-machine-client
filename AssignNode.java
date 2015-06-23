public class AssignNode implements Node {

    String id;
    Node node;

    public AssignNode(String id, Node node) {
        this.id = id;
        this.node = node;
    }

    public String id() {
        return id;
    }
    
    public Node node() {
        return node;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}