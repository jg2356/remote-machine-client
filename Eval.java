import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

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
        
        JSONSerializerVisitor jsonVisitor = new JSONSerializerVisitor();
        String jsonRootAST = rootAST.accept(jsonVisitor);
        
        String url = args.length == 0
        		? "http://localhost:3000/visit"
        	    : args[0];
        System.out.println(executePost(url, jsonRootAST));
    }

    public static String executePost(String targetURL, String jsonBody)
    {
        HttpURLConnection connection = null;  
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            connection.setUseCaches (false);
            connection.setDoOutput(true);
            connection.connect();

            //Send request
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            out.write(jsonBody);
            out.flush();
            out.close();

            //Get Response  
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer(); 
            while((line = in.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if(connection != null) {
                connection.disconnect(); 
            }
        }
    }
}
