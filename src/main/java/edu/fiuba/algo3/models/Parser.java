package edu.fiuba.algo3.models;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

public class Parser {

    public List<List<String>> desglosarEnemigos(String rutaArchivo) {
        List<List<String>> enemigosList = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONObject enemigosObj = jsonObject.getJSONObject("enemigos");
                List<String> enemigos = new ArrayList<>();

                for (String enemigoKey : enemigosObj.keySet()) {
                    int cantidad = enemigosObj.getInt(enemigoKey);
                    for (int j = 0; j < cantidad; j++) {
                        enemigos.add(enemigoKey);
                    }
                }
                enemigosList.add(enemigos);
            }

            return enemigosList;
        } catch (IOException e) {
            
            e.printStackTrace();
            return null; 
        }
    }


    public List<List<String>> leerMapa(String rutaArchivo) {

        try {
            String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            List<List<String>> mapa = new ArrayList<>(); 

            JSONObject jsonObject = new JSONObject(json); 
            JSONObject mapaObj = jsonObject.getJSONObject("Mapa"); 

            for (int i = 0; i < mapaObj.length(); i++) { 
                JSONArray filaArray = mapaObj.getJSONArray(String.valueOf(i + 1));
                List<String> fila = new ArrayList<>();

                for (int j = 0; j < filaArray.length(); j++) {
                    String elemento = filaArray.getString(j);
                    fila.add(elemento);
                }

                mapa.add(fila);
            }

            return mapa; 
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }
    }

    public List<List<String>> formarCamino(String rutaArchivo){
        List<List<String>> camino = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            JSONObject jsonObject = new JSONObject(json); 

            JSONObject mapaObj = jsonObject.getJSONObject("Mapa");

            for (int i = 0; i < mapaObj.length(); i++) { 

                JSONArray filaArray = mapaObj.getJSONArray(String.valueOf(i + 1)); 
               
                for (int j = 0; j < filaArray.length(); j++) {
                    List<String> pasarela = new ArrayList<>();
                    String elemento = filaArray.getString(j); 
                   
                    if(elemento.equals("Pasarela")){ 
                                        
                        pasarela.add(elemento);
                        pasarela.add(String.valueOf(j));
                        pasarela.add(String.valueOf(i));
                        camino.add(pasarela);                        
                    }
                }
            }
            return camino; 
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }
    }

}




