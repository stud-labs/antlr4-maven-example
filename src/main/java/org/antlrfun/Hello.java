package org.antlrfun;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.charset.StandardCharsets;

public class Hello {
    public static void main(String [] args) throws Exception
    {
        String input = "hello world";
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        HelloLexer lexer = new HelloLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        HelloParser parser = new HelloParser( tokens );
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new HelloWalker(), tree );
    }
}