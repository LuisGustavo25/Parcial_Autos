
package Taller;

import Librerias.piezasSiniestro;


public class ClientesSiniestro extends ClientesGenerales implements piezasSiniestro {
    //Nota: Guarda los autos de c/u de los clientes uno por uno
    public String[] placas = new String[13];
    public String[][] piezasDanhadas = new String[MAX_PIEZAS][1]; //FILAS ITINERNADO EN MAX_PIEZAS
    @Override
    public String separaAseguradora() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int obtenerPieza() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double obtenerCosto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //Constructores

    public ClientesSiniestro() {
    }

    public ClientesSiniestro(String nombre, String apellido, String cedula, String aseguradora) {
        super(nombre, apellido, cedula, aseguradora);
    }
    
    //setter 

    public void setPlacas(String[] placas) {
        this.placas = placas;
    }

    public void setPiezasDanhadas(String[][] piezasDanhadas) {
        this.piezasDanhadas = piezasDanhadas;
    }
    
    //getter

    public String[] getPlacas() {
        return placas;
    }

    public String[][] getPiezasDanhadas() {
        return piezasDanhadas;
    }

    public static int getMAX_PIEZAS() {
        return MAX_PIEZAS;
    }

    public static String[] getPiezas() {
        return piezas;
    }

    public static double[] getCostos() {
        return Costos;
    }
    
    public int n_autos(){return 0;};
    
    public double calcularPago(){return 0;}
    
}// end class
