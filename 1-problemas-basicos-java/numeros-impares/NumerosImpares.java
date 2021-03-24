import java.util.Scanner;

public class NumerosImpares {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();
        for (int i = 0; i <= num; i++) { //complete seu codigo aqui
        if (i % 2 == 1){
            System.out.println(i);
        }
    }
  }
}