package main;

// Para importar las clases

import controlador.Controlador_prin;
import modelo.modelo_principal;
import modelo.personas;
import vista.Ventana_Inicial;

public class Interfaz_Covid {
    public static void main(String[] args){
        Ventana_Inicial inicio = new Ventana_Inicial();
        modelo_principal model = new modelo_principal();
        personas per = new personas();
        new Controlador_prin(model,inicio,per); //Para darle accion a los botones

    }
}
