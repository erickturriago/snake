/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

public class Sistema implements Runnable{
    
    private int[][] tablero = new int[35][35];
    private ArrayList<String> serpiente = new ArrayList<String>();
    private ArrayList<String> copiaSerpiente = new ArrayList<String>();
    private Boolean activo = false;
    private int comida[]=new int [2];
    private String sentido = "f";
    private int signo;
    private String mensaje;
    private int[] cab=new int [2];
    private int contacomida=0;

    public Sistema() {
        serpiente.add("18,18");
        serpiente.add("18,17");
        comida();
    }

    public void moverSerpienteMatriz(String sentido, int valor) {
        resetMatriz();
        copiaSerpiente.clear();
        
        for (int i = 0; i < serpiente.size(); i++) {
            String a[] = serpiente.get(i).split(",");
            String b = String.join(",", a);
            copiaSerpiente.add(b);
        }

        String cabeza[] = serpiente.get(0).split(",");
        String cuello[] = serpiente.get(1).split(",");
        if (sentido == "x") {
            cabeza[1] = (Integer.parseInt(cabeza[1]) + valor) + "";
            cab[1]=(Integer.parseInt(cabeza[1]));  
        } else {
            cabeza[0] = (Integer.parseInt(cabeza[0]) + valor) + "";
            cab[0]=(Integer.parseInt(cabeza[0])); 
        }

        //verificar si muere
        if(verificarSuicidio()){
            //acabar todo;
            setMensaje("Suicidio");
            setActivo(false);
        }
        
        //limpiar todo
        serpiente.clear();
        //agregarle la cabeza a la serpiente
        serpiente.add(String.join(",", cabeza));
        
        if(serpComio()){ //agregar una posicion mas
            for (int i = 0; i < copiaSerpiente.size(); i++) {
                serpiente.add(copiaSerpiente.get(i));
                //generar de nuevo la comida
              
            }
            comida();
            contacomida++;
        }
        
        else{ //mantener tal y como esta
            for (int i = 0; i < copiaSerpiente.size() - 1; i++) {
                serpiente.add(copiaSerpiente.get(i));
            }
        }
        
        for (int i = 0; i < serpiente.size(); i++) {
            String a[] = serpiente.get(i).split(",");
            int cuerpo[] = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
            tablero[cuerpo[0]][cuerpo[1]] = 1;
        }
        
        if(verificarLimite()){
            //acabar todo;
            setMensaje("Perdiste");
            setActivo(false);
        }
    }

    public boolean verificarLimite(){
        
       for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                if (j == 0 || i == 0 || i == 34 || j == 34) {
                    if(tablero[i][j]==1){
                        return true;
                    }
                } 
                
            }
        }
        return false;
        
    }
    
    public boolean verificarSuicidio(){
        
        for (int i = 0; i < serpiente.size(); i++) {
            String a[] = serpiente.get(i).split(",");
            int cuerpo[] = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
            if(cuerpo[0]==cab[0]&&cuerpo[1]==cab[1]){
                setMensaje("Has perdido");
                return true;
            }
        }
        return false;
    }

  
    public void setMensaje(String r){
        this.mensaje=r;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void resetMatriz() {
        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                tablero[i][j] = 0;
            }
        }
    }
    
    public void comida(){
        int cx;
        int cy;
        do{
            cx=(int)(1+Math.random()*32);
            cy=(int)(1+Math.random()*32);
        } while(comprobarComida(cx,cy));
        
        comida[0]=cx;
        comida[1]=cy;
        
        
        
    }
    
    public boolean comprobarComida(int cx, int cy){
        //hacer que la comida no se genere en el cuerpo de la serpiente   
        for (int i = 0; i < serpiente.size(); i++) {
            String a[] = serpiente.get(i).split(",");
            int cuerpo[] = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
            if((cuerpo[0]==cx)&&(cuerpo[1]==cy)){
                return true;         
            }
        }
        return false;
    }
    
    public int[] getComida(){
        return comida;
    }
    
    public boolean serpComio(){
        if(cab[0]==comida[0]&&cab[1]==comida[1]){
            return true;
        }
        return false;
    }
   
    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public ArrayList<String> getSerpiente() {
        return serpiente;
    }

    public void setSerpiente(ArrayList<String> serpiente) {
        this.serpiente = serpiente;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public int getContaComida(){
        return contacomida;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public int getSigno() {
        return signo;
    }

    public void setSigno(int signo) {
        this.signo = signo;
    }
    

    @Override
    public void run() {
        while(getActivo()){
            try {
                Thread.sleep(80);
            } catch (Exception error) {
            }

            moverSerpienteMatriz(getSentido(), getSigno());
        }
        
    }
    
    
}
