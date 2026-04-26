package util;


import model.Endereco;
import model.SexoPet;
import model.TipoPet;


public class ConversorPet {
    public TipoPet conversorTipoPet(String tipoPet) {
        TipoPet tipo;
        if (tipoPet.equalsIgnoreCase("cachorro")) {
            tipo = TipoPet.CACHORRO;
        } else {
            tipo = TipoPet.GATO;
        }
        return tipo;
    }

    public TipoPet conversorTipoPetByte(byte tipoPet){
        TipoPet tipo;
        if (tipoPet == 1){
            tipo = TipoPet.CACHORRO;
        }else {
            tipo = TipoPet.GATO;
        }
        return tipo;
    }

    public SexoPet conversorSexoPet(String sexoPet) {
        SexoPet sexo;
        if (sexoPet.equalsIgnoreCase("macho")) {
            sexo = SexoPet.MACHO;
        } else {
            sexo = SexoPet.FEMEA;
        }
        return sexo;
    }

    public Endereco conversorEndereco(String endereco) {
        String partes[] = endereco.split(", ");
        return new Endereco(partes[0], partes[1], partes[2]);
    }

    public double conversorIdade(String idade) {
        double idadeDouble = Double.parseDouble(idade.replace(",", "."));
        return idadeDouble;
    }

    public double conversorPeso(String peso) {
        double pesoDouble = Double.parseDouble(peso.replace(",", "."));
        return pesoDouble;
    }
}
