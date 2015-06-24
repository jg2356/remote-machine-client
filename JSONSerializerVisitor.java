import java.util.Iterator;

public class JSONSerializerVisitor implements Visitor<String> {

	@Override
	public String visit(ProgNode node) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":\"prog\", \"children\":[");
		Iterator<Node> iterator = node.children().iterator();
		Node c = iterator.hasNext() ? iterator.next() : null;
		while(c != null) {
			sb.append(c.accept(this));
			if (!iterator.hasNext())
				break;
			sb.append(",");
			c = iterator.next();
		}
		sb.append("]}");
		return sb.toString();
	}

	@Override
	public String visit(BinopNode node) {
		return "{\"type\":\"binop\", \"op\":\"" + node.op() 
		       + "\", \"left\":" + node.left().accept(this)
		       + ", \"right\": " + node.right().accept(this)
		       +  "}";
	}

	@Override
	public String visit(AssignNode node) {
		return "{\"type\":\"assign\", \"id\":\"" + node.id() 
		       + "\", \"value\":" + node.value().accept(this)
		       +  "}";
	}

	@Override
	public String visit(VarNode node) {
		return "{\"type\":\"var\", \"id\":\"" + node.id() + "\"}";
	}

	@Override
	public String visit(DoubleNode node) {
		return "{\"type\":\"double\", \"value\":" + node.value() + "}";
	}
}
