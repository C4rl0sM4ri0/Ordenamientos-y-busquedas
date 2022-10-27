/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_1;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett Packard
 */
public class vectores_cd {
    
    
    
    private inventarios_cd[] arreglo_invent;
    private int numero_cd = 0;
    String [] nombre = {"Musica", "La sirenita", "Miguelito", "Audio J-0009", "Me aburri de Escribir Nombres", "Audio K-0007", "Audio H-0006", "Audio Z-0005",
        "Audio R-0004", "Audio F-0003", "Audio B-0002", "Audio D-0001", "Pedro"};
        int [] Cantidad_pistas = {10, 1, 4, 7, 8, 9, 4, 0, 2, 3, 6, 1, 6};
        char [] Clasificacion = {65, 66, 67, 68, 69,65,66,67,68,69,65,67};
    
    public vectores_cd(){
        super();
        this.numero_cd = 12;
        arreglo_invent = new inventarios_cd[numero_cd];
    }
    
    public int getNumero_cd() {
        return numero_cd;
    }
    
    public void setNumero_cd(int numero_cd) {
        this.numero_cd = numero_cd;
    }
    
    public void setarreglo_invent(inventarios_cd inventarios_cd, int pos) {
        arreglo_invent[pos] = inventarios_cd;
    }
    
    public inventarios_cd getarreglo_invent(int pos) {
        return arreglo_invent[pos];
    }
    
    public String getnombre(int pos){
        return nombre[pos];
    }
    
    public int getCantidad_pistas(int pos)
    {
        return Cantidad_pistas[pos];
    }
    
    public char getclasificacion(int pos)
    {
        return Clasificacion[pos];
    }
    
    public void aumentar_cd_invent(){
        inventarios_cd[] arregloAuxiliar = arreglo_invent;
        arreglo_invent = new inventarios_cd[arreglo_invent.length+1];
        System.arraycopy(arregloAuxiliar, 0, arreglo_invent, 0, arregloAuxiliar.length);   
        numero_cd++;
    }
    
    public void cambiar(int p1, int p2){
        
        inventarios_cd auxiliar_arreglo_invent; 
        auxiliar_arreglo_invent = getarreglo_invent(p1);
        setarreglo_invent(getarreglo_invent(p2), p1);
        setarreglo_invent(auxiliar_arreglo_invent, p2);
    }
    
    public void ordenarBurbuja() {
        int i, j;
        for (i = 0; i <= getNumero_cd() - 1; i++) {
            for (j = 0; j <= (getNumero_cd() - i) - 2; j++) {
                if (getarreglo_invent(j).getCantidad_pistas() > getarreglo_invent(j + 1).getCantidad_pistas()) {
                    cambiar(j, j + 1);
                }
            }
        }
    }
    
    public void ordenarintercambio()
     {
        int i, j; 
        for (i=0; i<=getNumero_cd()-1; i++){ 
            for (j = i+1; j <= getNumero_cd()-1; j++){ 
                if (getarreglo_invent(i).getCantidad_pistas() > getarreglo_invent(j).getCantidad_pistas()){ 
                    cambiar(i, j); 
                } 
            } 
        } 
    }
    
    public int posicionMenor(int inicio){ 
        int i;
        int posMenor;
        int menorElemento;
        posMenor = inicio; 
        menorElemento = getarreglo_invent(inicio).getCantidad_pistas(); 
        for (i = inicio; i <= getNumero_cd()-1; i++){ 
            if (getarreglo_invent(i).getCantidad_pistas() < menorElemento){ 
                menorElemento = getarreglo_invent(i).getCantidad_pistas(); 
                posMenor = i; 
            } 
        }
        return posMenor; 
    }
    
    public void ordenarSeleccion(){ 
        for (int i = 0; i <= getNumero_cd()-1; i++){ 
            cambiar(i, posicionMenor(i)); 
        } 
    }
    
    public void ordenarShell(){ 
        int i, n, cont; 
        n = (getNumero_cd()-1)/2; 
        while(n != 0){             
            cont = 1;             
            while(cont != 0){                 
                cont = 0; 
                for(i = n; i <= getNumero_cd()-1; i++){                     
                    if(getarreglo_invent(i).getCantidad_pistas() > getarreglo_invent(i-n).getCantidad_pistas()){                         
                        cambiar(i, i-n);
                        cont = cont + 1;
                    }
                }
            }
            n = n/2; 
        } 
    } 

    
    public void ordenarQuickSort(int primero, int ultimo){
        int i, j, centro; 
        int pivote; 
        centro = (primero+ultimo)/2; 
        pivote = getarreglo_invent(centro).getCantidad_pistas(); 
        i = primero; 
        j = ultimo; 
        do{ 
            while((i <= j) && (getarreglo_invent(i).getCantidad_pistas() < pivote)){ 
                i = i + 1; 
            } 
            while((i <= j) && (getarreglo_invent(j).getCantidad_pistas() > pivote)){ 
                j = j - 1; 
            } 
            if(i <= j){ 
                cambiar(i, j); 
                i = i + 1; 
                j = j - 1; 
            } 
        }while(i <= j); 
        if(primero < j){ 
            ordenarQuickSort(primero, j); 
        } 
        if(i < ultimo){ 
            ordenarQuickSort(i, ultimo); 
        } 
    } 
    
    public int busquedaLineal(int dato){ 
    int i;      
    int posicion;
    posicion = -1;         
    i = 0;      
    while ((i <= getNumero_cd()-1) && (posicion == -1)){
            if (getarreglo_invent(i).getCantidad_pistas() == dato){ 
                posicion=i; 
            }
            else{                 
                i = i + 1; 
            } 
        } 
        return posicion; 
    }
    
    public int bsuquedaBinaria(int dato){
    int posicion, izq, der, centro;       
    ordenarintercambio();       
    izq = 0;      
    der = getNumero_cd()-1;       
    posicion = -1;
        while ((izq <= der) && (posicion == -1)){
            centro = (izq + der) / 2; 
            if (dato == (getarreglo_invent(centro).getCantidad_pistas()) ){ 
                posicion = centro; 
                }else{ 
                    if (dato < (getarreglo_invent(centro).getCantidad_pistas())){                         
                        der = centro-1; 
                    }
                    else{ 
                        izq = centro+1; 
                    } 
                } 
        } 
        return posicion;
    }
    
    public String mostrarOrdenados() {
        String datos = ""; 
        for (int i = 0; i <= getNumero_cd() -1; i++) {
            datos = datos + String.valueOf("Posicion " + i + ":" + "\n"
                    + "Nombre del CD: " + getarreglo_invent(i).getNombre_cd() + "\n"
                    + "Clasificacion: " + getarreglo_invent(i).getClasificacion() + "\n"
                    + "Cantidad de Pistas: " + getarreglo_invent(i).getCantidad_pistas() + "\n"
                    + "Valor del CD: $" + getarreglo_invent(i).getValor_cd() + "\n"+ "\n");
        }
        return datos;
    }


    public void ordenamiento_alf(){
        Arrays.sort(arreglo_invent);
    }
    
    public void ramdom_cd(){
        
        for (int i = 0; i < 12; i++){
            
            int pistas = getCantidad_pistas((int) (Math.random()*12+1));
            String nombre = getnombre((int) (Math.random()*12+1));
            char clasificacion = getclasificacion((int) (Math.random()*6+1));
            float valor = (int) (Math.random()*10000+1);
            arreglo_invent[i] = new inventarios_cd(nombre, pistas, valor, clasificacion);
        }
        
        
    }
    
}