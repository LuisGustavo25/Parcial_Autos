package Implementacion;
import Autos.datos_autos;
import Librerias.piezasSiniestro;
import Taller.ClientesConSiniestro;
public class principal {
    public static void main(String[] args) {
        // Access data from datos_autos
        String[] clientesData = {
                "Luis Peñaloza 13283191 SegurosCaracas 2",
                "Marion Lucena 11934274 LosAndes 1"
                //añada los otros
        };

        String[] autosData = {
                "TAI64A Fiat Siena 13283191 PARACHOQUE DEL-CAPOT",
                "RAD34B Toyota Corolla 11934274 TECHO-PUERTA TRA IZQ",
                "SAP37L Chevrolet Aveo 13283191 PUERTA DEL IZQ-CAPOT-GUARDAFANGO DEL IZQ"
                //añada los otros x2
        };

        datos_autos datosAutos = new datos_autos(clientesData, autosData);

        ClientesConSiniestro[] clientes = new ClientesConSiniestro[2];

        for (int i = 0; i < clientes.length; i++) {

            String[] clientData = datosAutos.devolver_cliente(i).split(" ");
            String nombre = clientData[0];
            String apellido = clientData[1];
            String cedula = clientData[2];
            String aseguradora = clientData[3];
            int numAutos = Integer.parseInt(clientData[4]);


            String[] autoData = datosAutos.devolver_autos(i).split(" ");
            String[] placas = new String[numAutos];
            String[][] piezasDanhadas = new String[piezasSiniestro.MAX_PIEZAS][numAutos];

            int autoDataIndex = 0;
            for (int j = 0; j < numAutos; j++) {
                placas[j] = autoData[autoDataIndex++];
                StringBuilder piezasBuilder = new StringBuilder();
                while (autoDataIndex < autoData.length && !autoData[autoDataIndex].matches("\\d+")) {
                    piezasBuilder.append(autoData[autoDataIndex++]).append("-");
                }
                String piezasString = piezasBuilder.toString();
                piezasDanhadas[j] = piezasString.isEmpty() ? new String[0] : piezasString.split("-");
            }

            clientes[i] = new ClientesConSiniestro(nombre, apellido, cedula, aseguradora, placas, piezasDanhadas) {
                @Override
                public double obtenerCostoPieza(int ind) {
                    return 0;
                }
            };
        }

        // Print payment details for each client
        for (ClientesConSiniestro cliente : clientes) {
            System.out.println("Cliente: " + cliente.get_nom() + " " + cliente.get_ape());
            System.out.println("Aseguradora: " + cliente.separa_aseguradora());
            System.out.println("Monto a Pagar: " + cliente.pago_cliente());
            System.out.println("Autos:");
            String[] placas = cliente.get_placas();
            for (String placa : placas) {
                System.out.println(placa);
            }
            System.out.println();
        }

        // Count clients with 15% discount
        int clientsWithDiscount = 0;
        for (ClientesConSiniestro cliente : clientes) {
            if (cliente.get_piezasDanhadas().length > 7) {
                clientsWithDiscount++;
            }
        }
        System.out.println("Clientes con 15% de descuento: " + clientsWithDiscount);

        // Find the most reported piece for the aseguradora
        String aseguradora = clientes[0].get_ase();
        int[] pieceCount = new int[piezasSiniestro.piezas.length];
        for (ClientesConSiniestro cliente : clientes) {
            if (cliente.get_ase().equals(aseguradora)) {
                String[][] piezasDanhadas = cliente.get_piezasDanhadas();
                for (int i = 0; i < piezasDanhadas.length; i++) {
                    for (int j = 0; j < piezasDanhadas[i].length; j++) {
                        if (!piezasDanhadas[i][j].isEmpty()) {
                            int index = piezasSiniestro.obtenerIndicePieza(piezasDanhadas[i][j]);
                            if (index != -1) {
                                pieceCount[index]++;
                            }
                        }
                    }
                }
            }
        }

        int maxCount = 0;
        for (int count : pieceCount) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println("Piezas más reportadas para la aseguradora " + aseguradora + ":");
        for (int i = 0; i < pieceCount.length; i++) {
            if (pieceCount[i] == maxCount) {
                System.out.println(piezasSiniestro.piezas[i]);
            }
        }
    }
}