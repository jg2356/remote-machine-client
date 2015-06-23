public class VarNode implements Node {

    String id;

    public VarNode(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}