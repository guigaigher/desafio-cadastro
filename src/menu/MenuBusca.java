package menu;

import service.BuscaService;

import java.util.Scanner;

public class MenuBusca {
    public void exibirBusca(Scanner scanner) {
        System.out.println("Antes de dizer por quais critérios você quer buscar, digite qual o tipo de Pet:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        String tP = scanner.nextLine();
        byte tipoPet = Byte.parseByte(tP);
        System.out.println("Agora digite como você quer buscar pelo Pet?");
        System.out.println("1 - Nome/Sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Endereço");
        System.out.println("4 - Idade");
        System.out.println("5 - Nome e/ou sobrenome e Idade");
        System.out.println("6 - Peso");
        System.out.println("7 - Peso e Idade");
        System.out.println("8 - Raça");
        String crit = scanner.nextLine();
        byte criterio = Byte.parseByte(crit);
        BuscaService buscaService = new BuscaService();
        buscaService.buscarPet(scanner, tipoPet, criterio);
    }
}