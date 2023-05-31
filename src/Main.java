import Presentacion.Modelo;

public class Main {
    
    private Modelo aplicacion; 
    
    public Main() {
        aplicacion = new Modelo();
        aplicacion.iniciar();
    }
    
    public static void main(String[] args){
        new Main();
    }
   
}
