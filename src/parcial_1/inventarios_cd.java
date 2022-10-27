/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_1;

/**
 *
 * @author Hewlett Packard
 */
public class inventarios_cd implements Comparable <inventarios_cd> {
    
    private String Nombre_cd = "";
    private int Cantidad_pistas = 0;
    private float Valor_cd = 0;
    private char clasificacion;

    public inventarios_cd(String nombre, int cantidad_pistas, float valor, char clasificacion){
        
        this.Nombre_cd = nombre;
        this.Cantidad_pistas = cantidad_pistas;
        this.Valor_cd = valor;
        this.clasificacion = clasificacion;
    }
    
    
    /**
     * @return the Nombre_cd
     */
    public String getNombre_cd() {
        return Nombre_cd;
    }

    /**
     * @param Nombre_cd the Nombre_cd to set
     */
    public void setNombre_cd(String Nombre_cd) {
        this.Nombre_cd = Nombre_cd;
    }

    /**
     * @return the Cantidad_pistas
     */
    public int getCantidad_pistas() {
        return Cantidad_pistas;
    }

    /**
     * @param Cantidad_pistas the Cantidad_pistas to set
     */
    public void setCantidad_pistas(int Cantidad_pistas) {
        this.Cantidad_pistas = Cantidad_pistas;
    }

    /**
     * @return the Valor_cd
     */
    public float getValor_cd() {
        return Valor_cd;
    }

    /**
     * @param Valor_cd the Valor_cd to set
     */
    public void setValor_cd(float Valor_cd) {
        this.Valor_cd = Valor_cd;
    }

    /**
     * @return the clasificacion
     */
    public char getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(char clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public int compareTo(inventarios_cd t) {
        return this.Nombre_cd.compareTo(t.getNombre_cd());
    }
    
    
    
    
    
    
}
