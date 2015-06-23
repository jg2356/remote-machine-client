public class BinopNode implements Node {

    Node left, right;
    char op;

    public BinopNode(char op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public char op() {
        return op;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}