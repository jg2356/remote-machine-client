
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.*;


public class EvalVisitor extends ExprBaseVisitor<Node> {

    public Node visitProgl(ExprParser.ProglContext ctx) {
        ProgNode node = new ProgNode();
        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            node.add(visit(ctx.expr(i)));
        }
        return node;
    }

	public Node visitAddsubl(ExprParser.AddsublContext ctx) {
        char c = ctx.op.getText().charAt(0);
        return extractBinopNode(c, ctx.expr(0), ctx.expr(1));
    }

    public Node visitMuldivl(ExprParser.MuldivlContext ctx) {
        char c = ctx.op.getText().charAt(0);
        return extractBinopNode(c, ctx.expr(0), ctx.expr(1));
    }

    public Node visitAssl(ExprParser.AsslContext ctx) {
        String id = ctx.ID().getText();
        Node node = visit(ctx.expr());
        return new AssignNode(id, node);
    }

    public Node visitParenl(ExprParser.ParenlContext ctx) {
        return visit(ctx.expr());
    }

	public Node visitDoublel(ExprParser.DoublelContext ctx) {
		Double val = Double.valueOf(ctx.DOUBLE().getText());
        return new DoubleNode(val);
	}

    public Node visitIdl(ExprParser.IdlContext ctx) {
        return new VarNode(ctx.ID().getText());
    }

    private Node extractBinopNode(char op, ExprParser.ExprContext expr0, ExprParser.ExprContext expr1) {
        Node left = visit(expr0);
        Node right = visit(expr1);
        return new BinopNode(op, left, right);
    }
}


