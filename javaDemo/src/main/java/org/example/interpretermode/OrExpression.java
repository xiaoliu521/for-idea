package org.example.interpretermode;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description TODO
 */
public class OrExpression implements Expression {

    private Expression e1;

    private Expression e2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.e1 = expression1;
        this.e2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return e1.interpret(context) || e2.interpret(context);
    }
}
