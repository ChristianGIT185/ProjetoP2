package model;

public class Copia {
    private int id;
    private Obra obra;
    private boolean disponivel;

    public Copia(){
    }

    public Copia(int id, Obra obra, boolean disponivel){
        this.id = id;
        this.obra = obra;
        this.disponivel = disponivel;

    }

    public int GetId(){
        return id;
    }

    public void SetId(int id){
        this.id = id;
    }

    public Obra getObra(){
        return obra;
    }

    public void SetObra(Obra obra){
        this.obra = obra;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void SetDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

}
