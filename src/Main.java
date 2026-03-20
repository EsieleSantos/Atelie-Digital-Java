import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("--- 💰 CALCULADORA DE ATELIÊ 💰 ---");

        // 1. Entrada de dados
        System.out.print("Digite o preço de VENDA do amigurumi: ");
        double precoVenda = leitor.nextDouble();

        System.out.print("Digite o custo do MATERIAL: ");
        double precoMaterial = leitor.nextDouble();

        // 2. O Cálculo (A "mágica" acontece aqui)
        double lucro = precoVenda - precoMaterial;

        // 3. Exibição do Resultado
        System.out.println("---------------------------------");
        System.out.printf("Seu lucro neste projeto é: R$ %.2f %n", lucro);

        // 4. Tomada de Decisão (Lógica)
        if (lucro >= 100) {
            System.out.println("✅ Meta atingida! Esse projeto paga bem.");
        } else if (lucro > 0) {
            System.out.println("⚠️ O lucro é baixo, mas ainda é positivo.");
        } else {
            System.out.println("❌ Alerta! Você está tendo PREJUÍZO.");
        }

        System.out.println("---------------------------------");
    }
}