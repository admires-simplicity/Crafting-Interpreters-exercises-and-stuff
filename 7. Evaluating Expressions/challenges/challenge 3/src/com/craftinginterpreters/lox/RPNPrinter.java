package com.craftinginterpreters.lox;

class RPNPrinter implements Expr.Visitor<String> {
  String print(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    return print(expr.left) + " " + print(expr.right) + " " + expr.operator.lexeme;
  }

  @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    return print(expr.expression);
  }

  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    if (expr.value == null)
      return "nil";
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return print(expr.right) + " " + expr.operator.lexeme;
  }

  public static void main(String[] args) {
    Expr expression1 = new Expr.Binary(
        new Expr.Unary(
            new Token(TokenType.MINUS, "-", null, 1),
            new Expr.Literal(123)),
        new Token(TokenType.STAR, "*", null, 1),
        new Expr.Grouping(
            new Expr.Literal(45.67)));

    Expr expression2 = new Expr.Binary(
        new Expr.Binary(
            new Expr.Binary(
                new Expr.Literal(1),
                new Token(TokenType.PLUS, "+", null, 1),
                new Expr.Literal(2)),
            new Token(TokenType.STAR, "*", null, 1),
            new Expr.Binary(
                new Expr.Literal(3),
                new Token(TokenType.PLUS, "+", null, 1),
                new Expr.Literal(4))),
        new Token(TokenType.MINUS, "-", null, 1),
        new Expr.Binary(
            new Expr.Binary(
                new Expr.Literal(5),
                new Token(TokenType.PLUS, "+", null, 1),
                new Expr.Literal(6)),
            new Token(TokenType.STAR, "*", null, 1),
            new Expr.Binary(
                new Expr.Literal(7),
                new Token(TokenType.PLUS, "+", null, 1),
                new Expr.Literal(8))));


    System.out.println(new RPNPrinter().print(expression1));
    System.out.println(new RPNPrinter().print(expression2));
  }

}
