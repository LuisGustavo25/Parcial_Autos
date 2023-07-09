
package Librerias;


public interface piezasSiniestro {
    //constante
    final int MAX_PIEZAS =13;
                                    //1             2               3       4          5           6                7               8               9                   10                       11               12                   13                            
    public String[] piezas = {"PARACHOQUE DEL","PARACHOQUE TRA","CAPOT","MALETERA","TECHO","PUERTA TRA IZQ","PUERTA TRA DER","PUERTA DEL IZQ","PUERTA DEL DER","GUARDAFANGO TRA IZQ","GUARDAFANGO TRA DER","GUARDAFANGO DEL IZQ","GUARDAFANGO DEL DER"};
    //AMBOS SERAN PARALELOS; ES DECIR COMAPAR>TEN MISMO ORDEN
    public double[] Costos = new double[MAX_PIEZAS];

    static int obtenerIndicePieza(String pieza) {
        return 0;
    }

    double obtenerCostoPieza(int ind);
    
}//end interface
