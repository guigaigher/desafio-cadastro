package model;

public class Pet{
    private String nome;
    private String sobrenome;
    private String raca;
    private double idadeAproximada;
    private double pesoAproximado;
    private final TipoPet tipoPet;
    private Endereco endereco;
    private final SexoPet sexoPet;

    public Pet(String nome, String sobrenome, String raca, double idadeAproximada, double pesoAproximado, TipoPet tipoPet, Endereco endereco, SexoPet sexoPet) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.raca = raca;
        this.idadeAproximada = idadeAproximada;
        this.pesoAproximado = pesoAproximado;
        this.tipoPet = tipoPet;
        this.endereco = endereco;
        this.sexoPet = sexoPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
