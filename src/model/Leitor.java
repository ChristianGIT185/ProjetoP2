package model;

public class Leitor extends Pessoa {
    private String matricula;

    public Leitor(){
    }
    public Leitor(int id, String nome, String email, String matricula){
        super(id, nome, email);
        this.matricula = matricula;
    }
    public String GetMatricula(){
        return matricula;
    }
    public void SetMatricula(String matricula){
        this.matricula = matricula;
    }

}
