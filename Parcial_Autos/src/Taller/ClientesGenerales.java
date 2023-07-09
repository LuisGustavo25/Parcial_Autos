
package Taller;


public abstract class ClientesGenerales {
    private String nombre;
    private String apellido;
    private String cedula;
    private String aseguradora;

    public ClientesGenerales() {
        this.nombre = "";
        this.apellido = "";
        this.cedula = "";
        this.aseguradora = "";
    }

    public ClientesGenerales(String nombre, String apellido, String cedula, String aseguradora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.aseguradora = aseguradora;
    }


    public String get_nom() {
        return nombre;
    }

    public String get_ape() {
        return apellido;
    }

    public String get_ced() {
        return cedula;
    }

    public String get_ase() {
        return aseguradora;
    }

    public void set_nom(String nombre) {
        this.nombre = nombre;
    }

    public void set_ape(String apellido) {
        this.apellido = apellido;
    }

    public void set_ced(String cedula) {
        this.cedula = cedula;
    }

    public void set_ase(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public abstract String separa_aseguradora();
}//end asbtract
