package edu.fiuba.algo3.models.Parcelas;

import java.util.Objects;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;

public abstract class Parcela
{
   protected String TipoDeParcela;
   protected Cordenada cordenadas ;

    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        return false;
    }

    public String getTipo(){
        return TipoDeParcela;
    }

    public Cordenada getCordenada() {
        return cordenadas;
    }
  
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Parcela otra = (Parcela) obj;
        return Objects.equals(cordenadas, otra.cordenadas) &&
                Objects.equals(TipoDeParcela, otra.TipoDeParcela);
    }
    public void liberar(){
    }

}
