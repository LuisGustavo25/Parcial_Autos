package Taller;
import Librerias.piezasSiniestro;

public abstract class ClientesConSiniestro extends ClientesGenerales implements piezasSiniestro {
    private String[] placas;
    private String[][] piezasDanhadas;

    public ClientesConSiniestro() {
        super();
        this.placas = new String[0];
        this.piezasDanhadas = new String[MAX_PIEZAS][0];
    }

    public ClientesConSiniestro(String nombre, String apellido, String cedula, String aseguradora, String[] placas, String[][] piezasDanhadas) {
        super(nombre, apellido, cedula, aseguradora);
        this.placas = placas;
        this.piezasDanhadas = piezasDanhadas;
    }

    public String[] get_placas() {
        return placas;
    }

    public String[][] get_piezasDanhadas() {
        return piezasDanhadas;
    }

    public int cantidad_clientes() {
        return placas.length;
    }

    public void set_placas(String[] placas) {
        this.placas = placas;
    }

    public void set_piezasDanhadas(String[][] piezasDanhadas) {
        this.piezasDanhadas = piezasDanhadas;
    }

    public int cantidad_autos() {
        return placas.length;
    }

    public double pago_cliente() {
        double totalPago = 0.0;
        int numAutos = placas.length;
        for (int i = 0; i < piezasSiniestro.MAX_PIEZAS; i++) {
            for (int j = 0; j < numAutos; j++) {
                if (i < piezasDanhadas.length && j < piezasDanhadas[i].length && piezasDanhadas[i][j] != null && !piezasDanhadas[i][j].isEmpty()) {
                    int indPieza = obtenerIndicePieza(piezasDanhadas[i][j]);
                    if (indPieza != -1) {
                        double costoPieza = obtenerCostoPieza(indPieza);
                        totalPago += costoPieza;
                    }
                }
            }
        }

        if (numAutos >= 4 && numAutos <= 7) {
            totalPago -= totalPago * 0.1; // Descuento del 10%
        } else if (numAutos > 7) {
            totalPago -= totalPago * 0.15; // Descuento del 15%
        }

        return totalPago;
    }


    @Override
    public String separa_aseguradora() {
        String[] palabras = get_ase().split(" ");
        StringBuilder aseguradoraSeparada = new StringBuilder();
        for (String palabra : palabras) {
            aseguradoraSeparada.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
        }
        return aseguradoraSeparada.toString().trim();
    }

    public String separa_aseguradora(boolean mayuscula) {
        String aseguradoraSeparada = separa_aseguradora();
        if (!mayuscula) {
            StringBuilder aseguradoraAlternada = new StringBuilder();
            for (int i = 0; i < aseguradoraSeparada.length(); i++) {
                if (i % 2 == 0) {
                    aseguradoraAlternada.append(Character.toUpperCase(aseguradoraSeparada.charAt(i)));
                } else {
                    aseguradoraAlternada.append(Character.toLowerCase(aseguradoraSeparada.charAt(i)));
                }
            }
            return aseguradoraAlternada.toString();
        } else {
            return aseguradoraSeparada.toUpperCase();
        }
    }

    @Override
    public int obtenerIndicePieza(String pieza) {
        return 0;
    }

    public abstract double obtenerCostoPieza(int ind);
}
