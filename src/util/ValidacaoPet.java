package util;

import exception.IdadeInvalidaException;
import exception.NomeInvalidoException;
import exception.PesoInvalidoException;
import exception.RacaInvalidaException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidacaoPet {
    private static final String NAO_INFORMADO = "NÃO INFORMADO(A)";

    public void validacaoNome(String nome, String sobrenome) {
        String regex = "\\W";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNome = pattern.matcher(nome);
        Matcher matcherSobrenome = pattern.matcher(sobrenome);

        if (nome.isBlank() || sobrenome.isBlank()) {
            throw new NomeInvalidoException("NOME OU SOBRENOME " + NAO_INFORMADO);
        } else if (matcherNome.find() || matcherSobrenome.find()) {
            throw new NomeInvalidoException("Nome ou sobrenome inválidos!!");
        }
    }

    public String validacaoNumeroCasa(String numeroCasa) {
        if (numeroCasa.isBlank()) {
            System.out.println("NÚMERO DA CASA " + NAO_INFORMADO);
            return NAO_INFORMADO;
        }
        return numeroCasa;
    }

    public double validacaoIdade(String idade) {
        if (idade.isBlank()) {
            throw new IdadeInvalidaException("IDADE " + NAO_INFORMADO);
        }
        double idadeDouble = Double.parseDouble(idade.replace(",", "."));
        if (idadeDouble > 20) {
            throw new IdadeInvalidaException("Idade inválida!!");
        }
        return idadeDouble;
    }

    public double validacaoPeso(String peso) {
        if (peso.isBlank()) {
            throw new PesoInvalidoException("PESO " + NAO_INFORMADO);
        }
        double pesoDouble = Double.parseDouble(peso.replace(",", "."));
        if (pesoDouble < 0.5 || pesoDouble > 60) {
            throw new PesoInvalidoException("Peso inválido!!");
        }
        return pesoDouble;
    }

    public String validacaoRaca(String raca) {
        String regex = "\\W";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherRaca = pattern.matcher(raca);

        if (raca.isBlank()) {
            System.out.println("RAÇA " + NAO_INFORMADO);
            return NAO_INFORMADO;
        } else if (matcherRaca.find()) {
            throw new RacaInvalidaException("Raça inválida!!");
        }
        return raca;
    }
}
