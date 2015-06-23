public class DoubleNode implements Node {

    Double val;

    public DoubleNode(Double val) {
        this.val = val;
    }

    public Double val() {
        return val;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}