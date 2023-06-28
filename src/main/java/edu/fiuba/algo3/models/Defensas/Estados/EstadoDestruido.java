package edu.fiuba.algo3.models.Defensas.Estados;

public class EstadoDestruido implements Estado {

    public boolean puedoAtacar() {
        return false;
    }
    public boolean destruido()
    {
        return true;
    }
    public boolean enContruccion(){
        return false;
    }
}
