package model;

public class reserva {
    private int id;
    private Leitor leitor;
    private Obra obra;

    public reserva(){
    }

    public reserva(int id, Leitor leitor, Obra obra){
        this.id = id;
        this.leitor = leitor;
        this.obra = obra;
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

    public Obra GetObra(){
        return obra;
    }
    public void SetObra(Obra obra){
        this.obra = obra;
    }
}
