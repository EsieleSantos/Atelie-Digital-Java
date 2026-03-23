import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<Double> listaDeLucros = new ArrayList<>();
        int totalPecas = 0;
        double somaAtual = 0; // O acumulador para o nosso "fiscal"
        double metaDiaria = 500.0;

        System.out.println("--- 🧶 GESTÃO DE ATELIÊ DIGITAL v1.3 🧶 ---");

        while (continuar) {
            try {
                System.out.print("\nPreço de VENDA (ou 0 para SAIR): ");
                double precoVenda = leitor.nextDouble();

                if (precoVenda == 0) {
                    continuar = false;
                    break;
                }

                leitor.nextLine(); // Limpa o trilho
                System.out.print("Nome do Projeto: ");
                String nomeProjeto = leitor.nextLine();

                System.out.print("Custo do MATERIAL: ");
                double precoMaterial = leitor.nextDouble();

                double lucro = precoVenda - precoMaterial;

                System.out.println("Tipo: 1-Amigurumi G | 2-Chaveiro | 3-Acessório");
                int tipo = leitor.nextInt();
                double margemReq = (tipo == 1) ? 150.0 : (tipo == 2) ? 20.0 : 50.0;

                // --- 📈 ATUALIZANDO O SISTEMA ---
                listaDeLucros.add(lucro);
                totalPecas++;
                somaAtual += lucro; // O fiscal soma aqui!

                // --- 🖥️ EXIBIÇÃO REFINADA ---
                System.out.println("\n---------------------------------");
                System.out.printf("📌 PROJETO: %-15s | Nº: %d %n", nomeProjeto, totalPecas);
                System.out.printf("💰 LUCRO: R$ %-10.2f | %s %n", lucro, (lucro >= margemReq ? "✅ OK" : "⚠️ BAIXO"));

                // --- 🚨 O FISCAL EM AÇÃO ---
                if (somaAtual >= metaDiaria) {
                    System.out.println("*********************************");
                    System.out.println("🎉 META DIÁRIA BATIDA! R$ " + String.format("%.2f", somaAtual));
                    System.out.println("*********************************");
                } else {
                    System.out.printf("⏳ Faltam R$ %.2f para a meta.%n", (metaDiaria - somaAtual));
                }
                System.out.println("---------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("🚫 Erro de entrada. Use números com vírgula.");
                leitor.nextLine();
            }
        }

        // --- 📊 RELATÓRIO FINAL ---
        System.out.println("\n=================================");
        System.out.println("       RESUMO DO EXPEDIENTE      ");
        System.out.println("=================================");
        System.out.println("Total de Projetos: " + totalPecas);
        System.out.printf("Lucro Acumulado:   R$ %.2f %n", somaAtual);
        System.out.println("=================================");
    }
}