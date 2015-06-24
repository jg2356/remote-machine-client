public class DoubleNode implements Node {
    private Double value;

    public DoubleNode(Double val) {
        this.value = val;
    }

    public Double value() {
        return value;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}