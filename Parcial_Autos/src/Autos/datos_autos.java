
package Autos;


public class datos_autos {
    private String[] clientes;
    private String[] autos;

    public datos_autos(String[] clientes, String[] autos) {
        this.clientes = clientes;
        this.autos = autos;
    }

    public String devolver_autos(int posicion) {
        return autos[posicion];
    }

    public String devolver_cliente(int posicion) {
        return clientes[posicion];
    }

}// end class
