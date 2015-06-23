Implements visitor design pattern manually.
A visitor for evaluation.
A visitor for translating AST to string format.

Can you write the print visitor ASTPrintVisitor. 
See Eval.java for its use. Sample transcript:



> java Eval -t
a = 2
b = a + a
a * b
^Z
prog
  =
    a
    2.0
  =
    b
    +
      a
      a
  *
    a
    b
=> 8.0

> java Eval -t
(2 + 3) * 6
^Z
prog
  *
    +
      2.0
      3.0
    6.0
=> 30.0
