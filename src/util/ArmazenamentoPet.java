package util;

import model.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArmazenamentoPet {
    private final File pasta = new File("../petsCadastrados");

    public void criarPasta() {
        pasta.mkdir();
    }

    private String formatarNumero(double valor, String unidade) {
        if (valor % 1 == 0) {
            return (int) valor + " " + unidade;
        } else {
            return valor + " " + unidade;
        }
    }

    public void salvarPet(Pet pet) {
        criarPasta();
        String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        String nomeArquivo = dataFormatada + "-" + pet.getNome().toUpperCase() + pet.getSobrenome().toUpperCase() + ".TXT";
        File arquivo = new File(pasta, nomeArquivo);
        String tipo = pet.getTipoPet().toString().toLowerCase();
        String sexo = pet.getSexoPet().toString().toLowerCase();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write("1 - " + pet.getNome() + " " + pet.getSobrenome());
            bw.newLine();
            bw.write("2 - " + Character.toUpperCase(tipo.charAt(0)) + tipo.substring(1));
            bw.newLine();
            bw.write("3 - " + Character.toUpperCase(sexo.charAt(0)) + sexo.substring(1));
            bw.newLine();
            bw.write("4 - " + pet.getEndereco().getCidade() + ", " + pet.getEndereco().getRua() + ", " + pet.getEndereco().getNumeroCasa());
            bw.newLine();
            bw.write("5 - " + formatarNumero(pet.getIdadeAproximada(), "anos"));
            bw.newLine();
            bw.write("6 - " + formatarNumero(pet.getPesoAproximado(), "kg"));
            bw.newLine();
            bw.write("7 - " + pet.getRaca());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
