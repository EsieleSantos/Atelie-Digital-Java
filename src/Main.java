import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<Double> listaDeLucros = new ArrayList<>();
        int totalPecas = 0;

        System.out.println("--- 🧶 GESTÃO DE ATELIÊ DIGITAL v1.2 🧶 ---");

        while (continuar) {
            try {

                System.out.print("\nPreço de VENDA (ou 0 para SAIR): ");
                double precoVenda = leitor.nextDouble();

                if (precoVenda == 0) {
                    continuar = false;
                    break; // Sai do laço imediatamente
                }


                leitor.nextLine();
                System.out.print("Nome do Projeto: ");
                String nomeProjeto = leitor.nextLine();

                System.out.print("Custo do MATERIAL: ");
                double precoMaterial = leitor.nextDouble();

                double lucro = precoVenda - precoMaterial;

                System.out.println("Escolha o TIPO: 1-Amigurumi G | 2-Chaveiro | 3-Acessório");
                int tipo = leitor.nextInt();
                double margem = (tipo == 1) ? 150.0 : (tipo == 2) ? 20.0 : 50.0;


                listaDeLucros.add(lucro);
                totalPecas++;

                System.out.println("---------------------------------");
                System.out.println("📌 Projeto: " + nomeProjeto);
                System.out.println("📊 Projeto nº: " + totalPecas);
                System.out.printf("💰 Lucro: R$ %.2f %n", lucro);
                System.out.println(lucro >= margem ? "✅ Meta atingida!" : "⚠️ Abaixo da meta.");
                System.out.println("---------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("🚫 Erro: Use apenas números com vírgula (ex: 50,00).");
                leitor.nextLine();
            }
        }


        System.out.println("\n=================================");
        System.out.println("📊 RESUMO FINAL DA SESSÃO");
        double somaTotal = 0;
        for (Double v : listaDeLucros) somaTotal += v;

        System.out.println("Total de projetos: " + totalPecas);
        System.out.printf("Lucro Total Acumulado: R$ %.2f %n", somaTotal);
        System.out.println("=================================");
    }
}