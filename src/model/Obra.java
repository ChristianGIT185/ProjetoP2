package model;

public class Obra {
    private int id;
    private String titulo;
    private String autor;

    public Obra(){
    }

    public Obra(int id, String titulo, String autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;

    }
    public int GetId(){
        return id;
    }

    public void SetId(int id){
        this.id = id;
    }
    public String GetTitulo(){
        return titulo;
    }
    public void SetTitulo(String titulo){
        this.titulo = titulo;
    
    }
    public String GetAutor(){
        return autor;
    }

    public void SetAutor(String autor){
        this.autor = autor;
    }
    

}
