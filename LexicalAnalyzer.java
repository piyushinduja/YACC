import java.io.*;
import java.util.*;

public class LexicalAnalyzer {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        List<String> operators = new ArrayList<>();
        List<String> delimeters = new ArrayList<>();
        List<String> constants = new ArrayList<>();
        List<String> identifiers = new ArrayList<>();
        List<String> keywords = new ArrayList<>();

        System.out.println("Enter the number of lines of code: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Enter the code: ");
        for (int i = 0; i < n; i++) {
            String code = br.readLine();
            String[] codeArr = code.split(" ");
            for (int j = 0; j < codeArr.length; j++) {
                String word = codeArr[j];
                if (isDelimeter(word)) {
                    delimeters.add(word);
                } else if (isKeyword(word)) {
                    keywords.add(word);
                } else if (isOperator(word)) {
                    operators.add(word);
                } else if (isConstant(word)) {
                    constants.add(word);
                } else if (isIdentifier(word)) {
                    identifiers.add(word);
                }
            }
        }
        System.out.println(keywords);
        System.out.println(operators);
        System.out.println(constants);
        System.out.println(delimeters);
        System.out.println(identifiers);
    }

    static boolean isDelimeter(String str) {
        if (str.equals(" ") || str.equals(";") || str.equals(","))
            return (true);
        return (false);
    }

    static boolean isOperator(String str) {
        if (str.equals("=") || str.equals("+"))
            return (true);
        return (false);
    }

    static boolean isIdentifier(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isConstant(String str) {
        try {
            int intValue = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isKeyword(String str) {
        String[] keywords = { "char", "int", "float", "class" };
        for (int i = 0; i < keywords.length; i++) {
            if (str.equals(keywords[i])) {
                return true;
            }
        }
        return false;
    }

}
