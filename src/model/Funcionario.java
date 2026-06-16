package model;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(){
    }

    public Funcionario(int id, String nome, String email, String cargo){
        super(id, nome, email);
        this.cargo = cargo;
    }

    public String GetCargo(){
        return cargo;
    }

    public void SetCargo(String cargo){
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return "Funcionário { cargo =" + cargo + "}";
    }


}
