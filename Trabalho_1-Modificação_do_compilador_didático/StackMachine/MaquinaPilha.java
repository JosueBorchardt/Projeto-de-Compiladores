import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MaquinaPilha {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Uso: java MaquinaPilha <arquivo>");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        File arq = new File(args[0]);

        try {
            Scanner scanner = new Scanner(arq);
        
            while(scanner.hasNextLine()){
                String linha = scanner.nextLine();

                String comando = linha.trim().split(" ")[0];
                int arg1, arg2;

                switch (comando) {
                    case "PUSH":
                        int argumento = Integer.parseInt(linha.trim().split(" ")[1]);
                        stack.push(argumento);
                        break;

                    case "SUM":
                        arg2 = stack.pop();
                        arg1 = stack.pop();
                        stack.push(arg1 + arg2);
                        break;

                    case "SUB":
                        arg2 = stack.pop();
                        arg1 = stack.pop();
                        stack.push(arg1 - arg2);
                        break;

                    case "MULT":
                        arg2 = stack.pop();
                        arg1 = stack.pop();
                        stack.push(arg1 * arg2);
                        break;
                    case "DIV":
                        try {
                            arg2 = stack.pop();
                            arg1 = stack.pop();
                            stack.push(arg1 / arg2);
                        } catch (ArithmeticException e) {
                            System.out.println("Não é permitido divisão por zero.");
                        }
                        break;
                    case "PRINT":
                        System.out.println(stack.peek());
                }
            }
        
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
