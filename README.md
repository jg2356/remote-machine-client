# remote-machine-client

Remotely executes code expressions represented as an JSON AST

## Usage

### Generate ANTLR4 visitors

`antlr4 Expr.g4 -visitor`

### Compile the application

`javac *.java`

### Run the application locally

`java Eval http://url-to-remote-machine/visit`

## License

Copyright ©  Jose Gomez 2015
