
package Taller;


public abstract class ClientesGenerales {
    //atributos
    private String nombre,apellido,cedula,aseguradora;
    
    //COnstrcutores

    public ClientesGenerales() {
        this.nombre = " ";
        this.apellido = " ";
        this.cedula = " ";
        this.aseguradora = " ";
    }

    public ClientesGenerales(String nombre, String apellido, String cedula, String aseguradora) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.aseguradora = aseguradora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }
    
    //metodo abstracto stiring
    public abstract String separaAseguradora();
    
    
}//end asbtract
