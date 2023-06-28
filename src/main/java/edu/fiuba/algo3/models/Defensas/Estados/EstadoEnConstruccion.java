package edu.fiuba.algo3.models.Defensas.Estados;

public class EstadoEnConstruccion implements Estado{


    protected int tiempoDeConstruccion=0;

    public EstadoEnConstruccion(int turnos)
    {
        this.tiempoDeConstruccion=turnos;
    }
    public boolean puedoAtacar() {
        if(this.tiempoDeConstruccion>0)
        {
            this.tiempoDeConstruccion=tiempoDeConstruccion-1;
            return false;
        }

        return true;
    }

    public boolean destruido()
    {
        return false;
    }
    public boolean enContruccion(){
        return true;
    }
}
