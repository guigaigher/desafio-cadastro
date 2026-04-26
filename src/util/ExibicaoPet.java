package util;

import model.Pet;

public class ExibicaoPet {
    public void exibirPet(Pet pet, int numeroListagem) {
        String tipo = pet.getTipoPet().toString().toLowerCase();
        String sexo = pet.getSexoPet().toString().toLowerCase();
        System.out.println(numeroListagem + ". " + pet.getNomeCompleto() + " - " + Character.toUpperCase(tipo.charAt(0)) + tipo.substring(1) + " - " +
                Character.toUpperCase(sexo.charAt(0)) + sexo.substring(1) + " - " + pet.getEndereco().getRua() + ", " +
                pet.getEndereco().getNumeroCasa() + " - " + pet.getEndereco().getCidade() + " - " + pet.getIdadeAproximada() + " - " +
                pet.getPesoAproximado() + " - " + pet.getRaca());
    }
}
