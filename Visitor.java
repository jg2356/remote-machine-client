public interface Visitor<T> {
    public T visit(ProgNode node);
    public T visit(BinopNode node);
    public T visit(AssignNode node);
    public T visit(VarNode node);
    public T visit(DoubleNode node);
}