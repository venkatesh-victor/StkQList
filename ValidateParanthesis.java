import java.util.Stack;

public class ValidateParanthesis {
    public static void main(String[] args) {
        System.out.println(validateParanthesis("{}[]()"));
        System.out.println(validateParanthesis("{{}}[()]{{}}}"));
        System.out.println(validateParanthesis("((()))(){}{{}}([])"));
        System.out.println(validateParanthesis("[{}()]"));
    }

    public static boolean validateParanthesis(String paranthesisString) {
        Stack<Character> stack = new Stack<>();

        for(char c : paranthesisString.toCharArray()) {
            switch(c) {
                case '{':
                    stack.push('}');
                    break;

                case '(':
                    stack.push(')');
                    break;

                case '[':
                    stack.push(']');
                    break;

                default:
                    if(stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
