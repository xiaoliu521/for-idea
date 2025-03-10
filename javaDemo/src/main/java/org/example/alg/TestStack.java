package org.example.alg;

import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        int abfcacdb = testStack.minLength("ACBBD");
        System.out.println(abfcacdb);
    }

    public int minLength(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A'){
                stack.push('A');
            }else if(s.charAt(i) == 'B'){
                if(!stack.isEmpty()){
                    Character ch = stack.peek();
                    if(ch == 'A'){
                        length -= 2;
                        stack.pop();
                    } else{
                        stack.clear();
                    }
                }
            }else if(s.charAt(i) == 'C'){
                stack.push('C');
            }else if(s.charAt(i) == 'D'){
                if(!stack.isEmpty()){
                    Character ch = stack.peek();
                    if(ch == 'C'){
                        length -= 2;
                        stack.pop();
                    } else{
                        stack.clear();
                    }
                }
            }else{
                stack.clear();
            }
        }
        return length;
    }
}
