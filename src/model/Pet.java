package model;

public class Pet{
    private String nomeCompleto;
    private final TipoPet tipoPet;
    private final SexoPet sexoPet;
    private Endereco endereco;
    private double idadeAproximada;
    private double pesoAproximado;
    private String raca;

    public Pet(String nomeCompleto, TipoPet tipoPet, SexoPet sexoPet, Endereco endereco, double idadeAproximada, double pesoAproximado, String raca) {
        this.nomeCompleto = nomeCompleto;
        this.tipoPet = tipoPet;
        this.sexoPet = sexoPet;
        this.endereco = endereco;
        this.idadeAproximada = idadeAproximada;
        this.pesoAproximado = pesoAproximado;
        this.raca = raca;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getIdadeAproximada() {
        return idadeAproximada;
    }

    public void setIdadeAproximada(double idadeAproximada) {
        this.idadeAproximada = idadeAproximada;
    }

    public double getPesoAproximado() {
        return pesoAproximado;
    }

    public void setPesoAproximado(double pesoAproximado) {
        this.pesoAproximado = pesoAproximado;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public SexoPet getSexoPet() {
        return sexoPet;
    }
}
