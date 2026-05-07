package service;

import model.Endereco;
import model.Pet;
import model.SexoPet;
import model.TipoPet;
import util.*;


import java.io.File;
import java.util.ArrayList;
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
        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();
        validacaoPet.validacaoNome(nomeCompleto);


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

        Pet pet = new Pet(nomeCompleto, tipo, sexo, endereco, validacaoIdade, validacaoPeso, validacaoRaca);

        ArmazenamentoPet armazenamentoPet = new ArmazenamentoPet();
        armazenamentoPet.salvarPet(pet);

        return pet;
    }

    public List<Pet> buscarPet() {
        LeituraPet leituraPet = new LeituraPet();
        List<Pet> lista = new ArrayList<>();
        File[] arquivos = Constantes.pasta.listFiles();
        if (arquivos == null) {
            return lista;
        }
        for (File arquivo : arquivos) {
            lista.add(leituraPet.leituraPet(arquivo));
        }
        return lista;
    }

    public Pet alterarPet(Scanner scanner, Pet pet) {
        ValidacaoPet validacaoPet = new ValidacaoPet();
        System.out.println("\n---Iniciando Alteração de Dados do Pet---");

        System.out.println("Deseja alterar o nome? (S/N)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o novo nome: ");
            String nomeCompleto = scanner.nextLine();
            validacaoPet.validacaoNome(nomeCompleto);
            pet.setNomeCompleto(nomeCompleto);
        }


        System.out.println("Deseja alterar o endereço? (S/N)");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Informe o novo endereço");
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Número da Casa: ");
            String numeroCasa = scanner.nextLine();
            String validacaoNumeroCasa = validacaoPet.validacaoNumeroCasa(numeroCasa);
            Endereco endereco = new Endereco(cidade, rua, validacaoNumeroCasa);
            pet.setEndereco(endereco);
        }


        System.out.println("Deseja alterar a idade? (S/N)");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a nova idade: ");
            String idadeAproximada = scanner.nextLine();
            double validacaoIdade = validacaoPet.validacaoIdade(idadeAproximada);
            pet.setIdadeAproximada(validacaoIdade);
        }

        System.out.println("Deseja alterar o peso? (S/N)");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o novo peso: ");
            String pesoAproximado = scanner.nextLine();
            double validacaoPeso = validacaoPet.validacaoPeso(pesoAproximado);
            pet.setPesoAproximado(validacaoPeso);
        }

        System.out.println("Deseja alterar a raça? (S/N)");
        resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a nova raça: ");
            String raca = scanner.nextLine();
            String validacaoRaca = validacaoPet.validacaoRaca(raca);
            pet.setRaca(validacaoRaca);
        }

        ArmazenamentoPet armazenamentoPet = new ArmazenamentoPet();

        armazenamentoPet.deletarPet(pet);

        armazenamentoPet.salvarPet(pet);
        return pet;
    }
}
