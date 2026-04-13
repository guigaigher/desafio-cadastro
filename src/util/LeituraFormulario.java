package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraFormulario {
    public void exibirFormulario() {
        try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"));) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> perguntaPorPergunta() {
        List<String> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("formulario.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

