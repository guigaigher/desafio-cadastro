package service;

import model.Pet;
import model.SexoPet;
import model.TipoPet;
import util.ConversorPet;
import util.ExibicaoPet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaService {
    public void buscarPet(Scanner scanner, byte tipoPet, byte criterio) {
        PetService petService = new PetService();
        List<Pet> pets = petService.buscarPet();
        List<Pet> petsFiltrados = new ArrayList<>();
        ConversorPet conversorPet = new ConversorPet();
        TipoPet tipoPet1 = conversorPet.conversorTipoPetByte(tipoPet);
        for (Pet pet : pets) {
            if (pet.getTipoPet() == tipoPet1) {
                petsFiltrados.add(pet);
            }
        }

        ExibicaoPet exibicaoPet = new ExibicaoPet();

        int contador = 1;
        switch (criterio) {
            case 1:
                System.out.println("Qual o nome do Pet cadastrado?");
                String nome = scanner.nextLine();
                for (Pet pet : petsFiltrados) {
                    if (pet.getNomeCompleto().toLowerCase().contains(nome.toLowerCase())) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 2:
                System.out.println("Digite macho ou fêmea para buscar o sexo do Pet cadastrado");
                String sexoPet = scanner.nextLine();
                SexoPet sexoPet1 = conversorPet.conversorSexoPet(sexoPet);
                for (Pet pet : petsFiltrados) {
                    if (sexoPet1 == pet.getSexoPet()) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 3:
                System.out.println("Qual o endereço do Pet cadastrado?");
                System.out.println("Rua: ");
                String rua = scanner.nextLine();
                System.out.println("Número da Casa: ");
                String numeroCasa = scanner.nextLine();
                System.out.println("Cidade: ");
                String cidade = scanner.nextLine();
                for (Pet pet : petsFiltrados) {
                    if (rua.equalsIgnoreCase(pet.getEndereco().getRua()) && numeroCasa.equals(pet.getEndereco().getNumeroCasa()) && cidade.equalsIgnoreCase(pet.getEndereco().getCidade())) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 4:
                System.out.println("Qual a idade do Pet cadastrado?");
                String idade = scanner.nextLine();
                double conversorIdade = conversorPet.conversorIdade(idade);
                for (Pet pet : petsFiltrados) {
                    if (conversorIdade == pet.getIdadeAproximada()) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 5:
                System.out.println("Qual o nome e idade do Pet cadastrado?");
                System.out.print("Nome: ");
                String nome1 = scanner.nextLine();
                System.out.print("Idade: ");
                idade = scanner.nextLine();
                conversorIdade = conversorPet.conversorIdade(idade);
                for (Pet pet : petsFiltrados) {
                    if (pet.getNomeCompleto().toLowerCase().contains(nome1.toLowerCase()) && conversorIdade == pet.getIdadeAproximada()) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 6:
                System.out.println("Qual o peso do Pet cadastrado?");
                String peso = scanner.nextLine();
                double conversorPeso = conversorPet.conversorPeso(peso);
                for (Pet pet : petsFiltrados) {
                    if (conversorPeso == pet.getPesoAproximado()) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 7:
                System.out.println("Qual o peso e idade do Pet cadastrado?");
                System.out.print("Peso: ");
                peso = scanner.nextLine();
                conversorPeso = conversorPet.conversorPeso(peso);
                System.out.print("Idade: ");
                idade = scanner.nextLine();
                conversorIdade = conversorPet.conversorIdade(idade);
                for (Pet pet : petsFiltrados) {
                    if (conversorPeso == pet.getPesoAproximado() && conversorIdade == pet.getIdadeAproximada()) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
            case 8:
                System.out.println("Qual a raça do Pet cadastrado?");
                String raca = scanner.nextLine();
                for (Pet pet : petsFiltrados) {
                    if (pet.getRaca().toLowerCase().contains(raca.toLowerCase())) {
                        exibicaoPet.exibirPet(pet, contador);
                        contador++;
                    }
                }
                break;
        }
    }
}
