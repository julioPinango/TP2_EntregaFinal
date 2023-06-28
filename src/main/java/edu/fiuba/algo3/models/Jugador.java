package edu.fiuba.algo3.models;

public class Jugador{

   private int Vida;
   private int Creditos;
   private String Nombre;
   private int hormigasDestruidas;

   public Jugador(String nombreJugador){ 
      this.Vida=20;
      this.Creditos=100;
      this.Nombre=nombreJugador;
      this.hormigasDestruidas=0;
   }
   public int getVida() {
      return this.Vida;
   }
   public int getCreditos() {
      return this.Creditos;
   }
   public String getNombre() {
      return this.Nombre;
   }
   public boolean creditosSuficientes(int costo) {   
      return getCreditos()>=costo;
   }
   public void descontarCredito(int costo) {
      this.Creditos=Creditos-costo;
   }

   public void recibirAtaque(int danio) {
      this.Vida=Vida-danio;
   }

   public Boolean jugadorDerrotado() {
      return (getVida()<=0);
   }

   public int getHormigasDestruidas() {
      return hormigasDestruidas;
   }

   public void sumarHormigaMuerta() {
      this.hormigasDestruidas++;
   }

   public void agregarCreditos(int creditosEntrantes){
      Creditos=Creditos+creditosEntrantes;
   }
}