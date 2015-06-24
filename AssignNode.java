public class AssignNode implements Node {
    private String id;
    private Node value;

    public AssignNode(String id, Node node) {
        this.id = id;
        this.value = node;
    }

    public String id() {
        return id;
    }
    
    public Node value() {
        return value;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}