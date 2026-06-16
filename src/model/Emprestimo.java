package model;

public class Emprestimo {
    private int id;
    private Leitor leitor;
    private Copia copia;

    public Emprestimo(){
    }

    public Emprestimo(int id, Leitor leitor, Copia copia){
        this.id = id;
        this.leitor = leitor;
        this.copia = copia;
    }

    public int GetId(){
        return id;
    }

    public void SetId(int id){
        this.id = id;
    }

    public Leitor GetLeitor(){
        return leitor;
    }

    public void SetLeitor(Leitor leitor){
        this.leitor = leitor;
    }

    public Copia GetCopia(){
        return copia;
    }

    public void SetCopia(Copia copia){
        this.copia = copia;
    }
}
