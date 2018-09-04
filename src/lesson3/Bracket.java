package lesson3;

import lesson3.StackSimple;

class Bracket {
    public static void check(String input) {
        int size = input.length();
        StackSimple st = new StackSimple(size);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    st.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!st.isEmpty()) {
                        char chr = st.pop();
                        if ((ch == '}' && chr != '{') || (ch == ']' && chr != '[') || (ch == ')' && chr != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!st.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
