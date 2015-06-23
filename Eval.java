import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.InputStream;

public class Eval {

    static InputStream is = System.in;

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(is); 
        ExprLexer lexer = new ExprLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 
        ExprParser parser = new ExprParser(tokens); 
        ParseTree tree = parser.prog();
	    EvalVisitor evalVisitor = new EvalVisitor();
	    Node rootAST = evalVisitor.visit(tree);
    }
}
