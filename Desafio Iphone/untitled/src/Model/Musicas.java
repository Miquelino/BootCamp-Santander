package Model;

public class Musicas {

    private int id;
    private String nome;
    private Double time;

    public Musicas(int id, String nome, Double time) {
        this.id = id;
        this.nome = nome;
        this.time = time;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
