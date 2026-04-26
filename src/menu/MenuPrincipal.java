package menu;

import exception.IdadeInvalidaException;
import exception.NomeInvalidoException;
import exception.PesoInvalidoException;
import exception.RacaInvalidaException;
import model.Pet;
import service.PetService;

import java.util.Scanner;

public class MenuPrincipal {
    public void exibir() {
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
            String entrada = scanner.nextLine();
            System.out.println();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            if (opcao <= 0 || opcao > 6) {
                System.out.println("Número inválido!!! Tente novamente");
            }

            if (opcao == 1) {
                PetService petService = new PetService();
                try {
                    Pet pet = petService.cadastrarPet(scanner);
                } catch (NomeInvalidoException e) {
                    System.out.println(e.getMessage());
                } catch (PesoInvalidoException e) {
                    System.out.println(e.getMessage());
                } catch (IdadeInvalidaException e) {
                    System.out.println(e.getMessage());
                } catch (RacaInvalidaException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 5) {
                MenuBusca menuBusca = new MenuBusca();
                menuBusca.exibirBusca(scanner);
            }
        }

        scanner.close();
    }
}
