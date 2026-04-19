package service;

import model.Endereco;
import model.Pet;
import model.SexoPet;
import model.TipoPet;
import util.ArmazenamentoPet;
import util.LeituraFormulario;
import util.ValidacaoPet;


import java.util.List;
import java.util.Scanner;

public class PetService {

    public Pet cadastrarPet(Scanner scanner) {
        LeituraFormulario leituraFormulario = new LeituraFormulario();
        leituraFormulario.exibirFormulario();
        List<String> perguntas = leituraFormulario.perguntaPorPergunta();
        ValidacaoPet validacaoPet = new ValidacaoPet();

        System.out.println("\n---Iniciando Coleta de Dados do Pet---");

        System.out.println(perguntas.get(1));
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        validacaoPet.validacaoNome(nome, sobrenome);


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
        String validacaoNumeroCasa = validacaoPet.validacaoNumeroCasa(numeroCasa);


        System.out.println(perguntas.get(5));
        String idadeAproximada = scanner.nextLine();
        double validacaoIdade = validacaoPet.validacaoIdade(idadeAproximada);


        System.out.println(perguntas.get(6));
        String pesoAproximado = scanner.nextLine();
        double validacaoPeso = validacaoPet.validacaoPeso(pesoAproximado);

        System.out.println(perguntas.get(7));
        String raca = scanner.nextLine();
        String validacaoRaca = validacaoPet.validacaoRaca(raca);

        Endereco endereco = new Endereco(cidade, rua, validacaoNumeroCasa);

        Pet pet = new Pet(nome, sobrenome, validacaoRaca, validacaoIdade, validacaoPeso, tipo, endereco, sexo);

        ArmazenamentoPet armazenamentoPet = new ArmazenamentoPet();
        armazenamentoPet.salvarPet(pet);

        return pet;
    }
}
