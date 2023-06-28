package edu.fiuba.algo3.models.Defensas.Estados;

public class EstadoOperativo implements Estado {

    public boolean puedoAtacar() {
        return true;
    }
     public boolean destruido()
    {
        return false;
    }

    public boolean enContruccion(){
        return false;
    }
}
