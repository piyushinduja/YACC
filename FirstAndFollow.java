import java.io.*;
import java.util.*;
import java.lang.*;

public class FirstAndFollow {
    static char trArr[], ntrArr[];
    static String grammar[][], frstArr[], fllwArr[];

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int i, j, n;

        System.out.println("Enter the non-termials: ");
        String ntr = br.readLine();
        ntrArr = new char[ntr.length()];
        ntrArr = ntr.toCharArray();

        System.out.println("Enter the teriminals: ");
        String tr = br.readLine();
        trArr = new char[tr.length()];
        trArr = tr.toCharArray();

        grammar = new String[ntrArr.length][];

        for (i = 0; i < ntrArr.length; i++) {
            System.out.println("Enter the number of productions for " + ntrArr[i] + ": ");
            int prodCount = Integer.parseInt(br.readLine());
            grammar[i] = new String[prodCount];
            System.out.println("Enter the production(s): ");
            for (j = 0; j < prodCount; j++) {
                grammar[i][j] = br.readLine();
            }
        }

        // Printing Grammar
        // int x=0;
        // for (String[] arr : grammar) {
        // for (i = 0; i < arr.length; i++) {
        // System.out.print(grammar[x][i]);
        // }
        // x++;
        // System.out.println();
        // }

        System.out.print("Non-Terminals:\t");
        for (i = 0; i < ntrArr.length; i++) {
            System.out.print(ntrArr[i] + "\t");
        }
        System.out.println();

        frstArr = new String[ntrArr.length];
        for (i = 0; i < ntrArr.length; i++) {
            frstArr[i] = first(i);
        }
        System.out.print("First: \t");
        for (i = 0; i < frstArr.length; i++) {
            System.out.print(removeDuplicates(frstArr[i]) + "\t");
        }

    }

    static String first(int i) {
        int j, k, l, found = 0;
        String temp = "", str = "";

        for (j = 0; j < grammar[i].length; j++) {
            for (k = 0; k < grammar[i][j].length(); k++, found = 0) {
                for (l = 0; l < ntrArr.length; l++) {
                    if (grammar[i][j].charAt(k) == ntrArr[l]) {
                        temp = first(1);
                        if (!(temp.length() == 1 && temp.charAt(0) == '9')) {
                            str = str + temp;
                            found = 1;
                            break;
                        }
                    }
                }
                if (found == 1) {
                    if (temp.contains("9")) {
                        continue;
                    }
                } else {
                    str = str + grammar[i][j].charAt(k);
                }
                break;
            }
        }

        return str;
    }

    static String removeDuplicates(String str)
    {
        char ch;
        boolean seen[] = new boolean[256];
        StringBuilder sb = new StringBuilder(seen.length);
        for(int i=0;i<str.length();i++)
        {
            ch=str.charAt(i);
            if (!seen[ch])
            {
                seen[ch] = true;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
