package util;

import model.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraPet {
    public Pet leituraPet(File arquivo) {
        List<String> lista = new ArrayList<>();
        int contadorLinha = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String valor = linha.split(" - ")[1];
                if (contadorLinha == 5 || contadorLinha == 6) {
                    valor = valor.split(" ")[0];
                }
                lista.add(valor);
                contadorLinha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConversorPet cp = new ConversorPet();

        return new Pet(lista.get(0), cp.conversorTipoPet(lista.get(1)), cp.conversorSexoPet(lista.get(2)), cp.conversorEndereco(lista.get(3)), cp.conversorIdade(lista.get(4)), cp.conversorPeso(lista.get(5)), lista.get(6));
    }
}