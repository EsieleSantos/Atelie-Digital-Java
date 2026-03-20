import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("--- 🧶 GESTÃO DE ATELIÊ DIGITAL v1.1 🧶 ---");

        System.out.print("Nome do projeto: ");
        leitor.nextLine();
        String nomeProjeto = leitor.nextLine();

        while (continuar) {
            try {
                System.out.print("\nPreço de VENDA (ou 0 para sair): ");
                double precoVenda = leitor.nextDouble();

                if (precoVenda == 0) {
                    continuar = false;
                    System.out.println("Fechando o Ateliê... Até logo!");
                    break;
                }

                System.out.print("Custo do MATERIAL: ");
                double precoMaterial = leitor.nextDouble();

                double lucro = precoVenda - precoMaterial;
                System.out.println("Escolha o TIPO de projeto:");
                System.out.println("1 - Amigurumi Grande");
                System.out.println("2 - Chaveiro/Lembrancinha");
                System.out.println("3 - Acessório");
                System.out.print("Opção: ");
                int tipo = leitor.nextInt();

                double margemEsperada = 0;

                switch (tipo) {
                    case 1:
                        margemEsperada = 150.0; // Amigurumis grandes precisam lucrar mais
                        System.out.println("Categoria Selecionada: Amigurumi Grande");
                        break;
                    case 2:
                        margemEsperada = 20.0;  // Chaveiros têm lucro menor, mas saem mais
                        System.out.println("Categoria Selecionada: Chaveiro");
                        break;
                    case 3:
                        margemEsperada = 50.0;
                        System.out.println("Categoria Selecionada: Acessório");
                        break;
                    default:
                        System.out.println("Tipo desconhecido. Usando margem padrão de R$ 50,00");
                        margemEsperada = 50.0;
                        break;
                }

                System.out.println("---------------------------------");
                System.out.printf("💰 Lucro calculado: R$ %.2f %n", lucro);

                if (lucro >= margemEsperada) {
                    System.out.println("✅ Meta atingida para esta categoria!");
                } else if (lucro > 0) {
                    System.out.println("⚠️ Margem apertada.");
                } else {
                    System.out.println("❌ Alerta de Prejuízo!");
                }
                System.out.println("---------------------------------");

            } catch (InputMismatchException e) {
                System.out.println("🚫 Erro: Digite apenas NÚMEROS com vírgula (ex: 15,50).");
                leitor.nextLine(); // Limpa o erro do leitor para tentar de novo
            }
        }
    }
}