package model;

public class Pessoa {

    private int id;
    private String nome;
    private String email;
    
    public Pessoa(){
    }

//Construtores
    public Pessoa(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;

    }
    
  //getters e setters

  public int GetId(){
    return id;
  }

  public void SetId(int id){
    this.id = id;
  }

  public String GetNome(){
    return nome;
  }

  public void SetNome(String nome){
    this.nome = nome;
  }

  public String GetEmail(){
    return email;
  }

  public void SetEmail(String email){
    this.email = email;
  }

@Override
public String toString(){
    return "Pessoa {id" + id + ", nome" + nome + "Email =" + email +"}";

}

  
    

}
