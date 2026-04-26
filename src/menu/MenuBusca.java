package menu;

import service.BuscaService;

import java.util.Scanner;

public class MenuBusca {
    public void exibirBusca(Scanner scanner) {
        System.out.println("Antes de dizer por quais critérios você quer buscar, digite qual o tipo de Pet:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        byte tipoPet = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Agora digite como você quer buscar pelo Pet?");
        System.out.println("1 - Nome/Sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Endereço");
        System.out.println("4 - Idade");
        System.out.println("5 - Nome e/ou sobrenome e Idade");
        System.out.println("6 - Peso");
        System.out.println("7 - Peso e Idade");
        System.out.println("8 - Raça");
        byte criterio = scanner.nextByte();
        scanner.nextLine();
        BuscaService buscaService = new BuscaService();
        buscaService.buscarPet(scanner, tipoPet, criterio);
    }
}