import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<Double> listaDeLucros = new ArrayList<>();
        int totalPecas = 0;
        double somaAtual = 0;

        System.out.println("--- 🧶 GESTÃO DE ATELIÊ DIGITAL v1.5 🧶 ---");

        while (continuar) {
            try {
                System.out.print("\nPreço de VENDA (ou 0 para SAIR): ");
                double precoVenda = leitor.nextDouble();

                if (precoVenda == 0) {
                    continuar = false;
                    break;
                }

                leitor.nextLine();
                System.out.print("Nome do Projeto: ");
                String nomeProjeto = leitor.nextLine();

                System.out.print("Custo do MATERIAL: ");
                double precoMaterial = leitor.nextDouble();

                double lucro = precoVenda - precoMaterial;

                System.out.println("Tipo: 1-Amigurumi G | 2-Chaveiro | 3-Acessório");
                int tipo = leitor.nextInt();

                listaDeLucros.add(lucro);
                totalPecas++;
                somaAtual += lucro;

                System.out.println("---------------------------------");
                System.out.printf("📌 PROJETO: %s | LUCRO: R$ %.2f %n", nomeProjeto, lucro);
                if (somaAtual >= 500.0) System.out.println("🎉 META DIÁRIA BATIDA!");
                System.out.println("---------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("🚫 Erro de entrada.");
                leitor.nextLine();
            }
        }

        // --- 📊 GRAVANDO O ARQUIVO COM CARIMBO DE TEMPO ---
        try {
            // Usamos "true" para o modo APPEND (anexar no final)
            FileWriter escritor = new FileWriter("relatorio_atelie.txt", true);

            // 1. Preparamos a Data e Hora
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
            String dataFormatada = agora.format(formatador);

            // 2. Escrevemos os dados no arquivo
            escritor.write("\n\n=================================");
            escritor.write("\n📅 REGISTRO EM: " + dataFormatada);
            escritor.write("\n📊 PROJETOS NA SESSÃO: " + totalPecas);
            escritor.write("\n💰 LUCRO DA SESSÃO: R$ " + String.format("%.2f", somaAtual));

            if (somaAtual >= 500.0) {
                escritor.write("\nStatus: META DIÁRIA ATINGIDA! ✅");
            } else {
                escritor.write("\nStatus: Meta não atingida. ⏳");
            }

            escritor.write("\n=================================");

            escritor.close();
            System.out.println("\n✅ Sucesso! O relatório foi atualizado em 'relatorio_atelie.txt'.");

        } catch (IOException e) {
            System.out.println("🚫 Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}