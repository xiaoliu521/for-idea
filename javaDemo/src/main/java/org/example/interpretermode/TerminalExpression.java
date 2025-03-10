package org.example.interpretermode;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description 终结符表达式
 */
public class TerminalExpression implements Expression {


    private String[] data;

    public TerminalExpression(String[] data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        for (String str : data) {
            if (context.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
