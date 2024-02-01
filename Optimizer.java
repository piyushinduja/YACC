import java.util.*;
import java.io.*;

public  class Optimizer {

    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Enter number of instructions: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Enter Instructions: ");
        List<String> list1 = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            String instruction = br.readLine();
            String[] result = instruction.split("=");

            if(!list1.contains(result[1])){
                list1.add(result[1]);
            }
        }

        System.out.println("\nOptimimized Code: ");
        int i = 1;
        for(String str : list1){
            System.out.println("t" + i + " = " + str);
            i = i + 1;
        }
    }
}