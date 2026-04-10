package menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal {
    public void exibir() {
        try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"));) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n" +
                    "Selecione uma das opções para continuar\n" +
                    "1.Cadastrar um pet\n" +
                    "2.Alterar os dados do pet cadastrado\n" +
                    "3.Deletar um pet cadastrado\n" +
                    "4.Listar todos os pets cadastrados\n" +
                    "5.Listar pets por algum critério(idade,nome,raça)\n" +
                    "6.Sair\n");
            System.out.print("Digite o número da opção: ");
            String entrada=scanner.nextLine();

            try{
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            if (opcao <= 0 || opcao > 6) {
                System.out.println("Número inválido!!! Tente novamente");
            }
        }
        scanner.close();
    }
}
