package org.example.interpretermode;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description TODO
 */
public class AndExpression implements Expression {

    private Expression e1;

    private Expression e2;

    public AndExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return this.e1.interpret(context) && this.e2.interpret(context);
    }
}
