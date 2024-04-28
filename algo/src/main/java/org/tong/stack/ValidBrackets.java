package org.tong.stack;

import java.util.Stack;

/**
 * @description: 判断字符串内的括号是否有效
 * @author: yanghantong
 * @time: 2024/4/28 9:55
 */
public class ValidBrackets {
    public static void main(String[] args) {
//        String s = "(]";
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null && s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            }
            if (charArray[i] == ')' || charArray[i] == ']' || charArray[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (charArray[i] == ')' && pop != '(') {
                    return false;
                } else if (charArray[i] == ']' && pop != '[') {
                    return false;
                } else if (charArray[i] == '}' && pop != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
