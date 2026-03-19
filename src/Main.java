import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("--- CALCULADORA DE ATELIÊ ---");
        System.out.print("Nome do boneco: ");
        String nome = leitor.nextLine();

        System.out.print("Custo do material (ex: 20,50): ");
        double custoMaterial = leitor.nextDouble();
        double precoVenda = custoMaterial * 3;

        System.out.println("\n--- RELATÓRIO FINAL ---");
        System.out.println("Para o " + nome + ", sugerimos o preço de: R$ " + precoVenda);

        }
    }

