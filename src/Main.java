import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String opcao = "s";
        int totalMetros = 0; // Nossa "sacola" que começa vazia

        System.out.println("--- CALCULADORA DE ESTOQUE TOTAL ---");

        while (opcao.equalsIgnoreCase("s")) {
            System.out.print("Qual a cor da lã? ");
            String cor = leitor.next();

            System.out.print("Quantos metros você tem de " + cor + "? ");
            int metros = leitor.nextInt();

            // Aqui está a mágica: somamos o que já tínhamos com o novo valor
            totalMetros = totalMetros + metros;

            System.out.println("-> " + cor + " adicionada. Total parcial: " + totalMetros + "m");

            System.out.print("\nCadastrar outra cor? (s/n): ");
            opcao = leitor.next();
        }

        System.out.println("\n--- RELATÓRIO DE PRODUÇÃO ---");
        System.out.println("Você tem um total de " + totalMetros + " metros de linha no ateliê.");

        // Uma pitada de lógica: Se tiver mais de 200m, você pode fazer um projeto grande!
        if (totalMetros >= 200) {
            System.out.println("Sugestão: Você tem material para uma manta ou um amigurumi GG!");
        }

        leitor.close();
    }
}