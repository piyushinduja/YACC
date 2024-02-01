import java.io.*;
import java.util.*;

public class LeftRecursion {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Enter the number of productions: ");
        int n = Integer.parseInt(br.readLine());

        List<String> prods = new ArrayList<>();
        System.out.println("Enter the productions: ");
        for (int i = 0; i < n; i++) {
            String production = br.readLine();
            prods.add(production);
        }

        System.out.println("Grammar after Left Recursion is(# indicates epsillon): ");
        for (int i = 0; i < n; i++) {
            
            String production = prods.get(i);
            char ntr = production.charAt(0);

            if(production.charAt(3)==ntr){
                String alpha = "";
                String beta = "";
                
                int j=4;
                while(production.charAt(j)!='|' && i<production.length()){
                    alpha = alpha + production.charAt(j);
                    j++;
                }
                
                if(j==production.length()){
                    System.out.println("Cannot be reduced due to absence of beta.");
                }else{
                    j++;
                    while(j<production.length()){
                        beta = beta + production.charAt(j);
                        j++;
                    }
                }

                System.out.println(ntr + "->" + beta + ntr+"'");
                System.out.println(ntr + "'->"+alpha+ntr+"'|#");

            }else{
                System.out.println(production);
            }

        }

    }
}
