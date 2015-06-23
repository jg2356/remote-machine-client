grammar Expr;
 
prog: expr+                       # progl
    ;
 
expr: '(' expr ')'                # parenl
    | expr op=('*'|'/') expr      # muldivl
    | expr op=('+'|'-') expr      # addsubl
    | <assoc=right> ID '=' expr # assl
    | DOUBLE                      # doublel
    | ID                          # idl
    ;
 
fragment
DIGIT:   [0-9];
DOUBLE:  ('-')? DIGIT+ ('.' DIGIT*)?;
fragment
LETTER:  [a-zA-Z];
ID:      LETTER (LETTER | DIGIT)*;
WS:      [ \t\r\n]+ -> skip;
NEWLINE: '\r'?'\n';
