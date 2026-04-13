package service;

import model.Endereco;
import model.Pet;
import model.SexoPet;
import model.TipoPet;
import util.LeituraFormulario;


import java.util.List;
import java.util.Scanner;

public class PetService {

    private static final String NAO_INFORMADO = "NÃO INFORMADO";

    public Pet cadastrarPet(Scanner scanner) {
        LeituraFormulario leituraFormulario = new LeituraFormulario();
        leituraFormulario.exibirFormulario();
        List<String> perguntas = leituraFormulario.perguntaPorPergunta();

        System.out.println("\n---Iniciando Coleta de Dados do Pet---");

        System.out.println(perguntas.get(1));
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();


        System.out.println(perguntas.get(2));
        String tipoPet = scanner.nextLine();
        byte tipoPetByte = Byte.parseByte(tipoPet);
        TipoPet tipo;
        if (tipoPetByte == 1) {
            tipo = TipoPet.CACHORRO;
        } else {
            tipo = TipoPet.GATO;
        }


        System.out.println(perguntas.get(3));
        String sexoPet = scanner.nextLine();
        byte sexoPetByte = Byte.parseByte(sexoPet);
        SexoPet sexo;
        if (sexoPetByte == 1) {
            sexo = SexoPet.MACHO;
        } else {
            sexo = SexoPet.FEMEA;
        }

        System.out.println(perguntas.get(4));
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número da Casa: ");
        String numeroCasa = scanner.nextLine();
        int numeroCasaInt = Integer.parseInt(numeroCasa);


        System.out.println(perguntas.get(5));
        String idadeAproximada = scanner.nextLine();
        double idadeAproximadaDouble = Double.parseDouble(idadeAproximada);


        System.out.println(perguntas.get(6));
        String pesoAproximado = scanner.nextLine();
        double pesoAproximadoDouble = Double.parseDouble(pesoAproximado);


        System.out.println(perguntas.get(7));
        String raca = scanner.nextLine();

        Endereco endereco = new Endereco(cidade, rua, numeroCasaInt);

        return new Pet(nome, sobrenome, raca, idadeAproximadaDouble, pesoAproximadoDouble, tipo, endereco, sexo);
    }
}
