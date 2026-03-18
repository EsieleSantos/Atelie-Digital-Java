import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("--- SISTEMA DE APOIO À DECISÃO: ATELIÊ ---");

        System.out.println("O que você pretende tecer agora?");
        System.out.println("1. Amigurumi Pequeno (50m)");
        System.out.println("2. Amigurumi Grande (150m)");
        System.out.println("3. Faixa de Cabelo (30m)");

        System.out.print("Escolha a opção (1, 2 ou 3): ");
        int escolha = leitor.nextInt();

        System.out.print("Quantos metros de linha você tem na mão? ");
        int estoque = leitor.nextInt();

        // Parte Específica
        switch (escolha) {
            case 1:
                verificarEstoque(estoque, 50, "Amigurumi Pequeno");
                break;
            case 2:
                verificarEstoque(estoque, 150, "Amigurumi Grande");
                break;
            case 3:
                verificarEstoque(estoque, 30, "Faixa de Cabelo");
                break;
            default:
                System.out.println("Opção inválida. Selecione 1, 2 ou 3.");
        }

        leitor.close();
    }

    //  "ferramenta" (método) para não repetir código
    public static void verificarEstoque(int atual, int necessario, String projeto) {
        if (atual >= necessario) {
            System.out.println("Sucesso! Você pode começar seu " + projeto + ".");
        } else {
            int falta = necessario - atual;
            System.out.println("Puxa, faltam " + falta + " metros para o " + projeto + ".");
        }
    }
}