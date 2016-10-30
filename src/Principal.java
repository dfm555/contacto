
import arboles.ABB;
import comun.CuentaDeAhorros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Oscar Arenas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ABB<CuentaDeAhorros> banco = new ABB<>();
        /*CuentaDeAhorros cuenta1 = new CuentaDeAhorros(100, "C1", "C1", 0);
        CuentaDeAhorros cuenta2 = new CuentaDeAhorros(80, "C2", "C2", 0);
        CuentaDeAhorros cuenta3 = new CuentaDeAhorros(120, "C3", "C3", 0);
        CuentaDeAhorros cuenta4 = new CuentaDeAhorros(60, "C4", "C4", 0);
        CuentaDeAhorros cuenta5 = new CuentaDeAhorros(90, "C5", "C5", 0);
        CuentaDeAhorros cuenta6 = new CuentaDeAhorros(110, "C6", "C6", 0);
        CuentaDeAhorros cuenta7 = new CuentaDeAhorros(130, "C7", "C7", 0);
        CuentaDeAhorros cuenta8 = new CuentaDeAhorros(40, "C8", "C8", 0);
        CuentaDeAhorros cuenta9 = new CuentaDeAhorros(70, "C9", "C9", 0);
        CuentaDeAhorros cuenta10 = new CuentaDeAhorros(10, "C10", "C10", 0);
        CuentaDeAhorros cuenta11 = new CuentaDeAhorros(6, "C11", "C11", 0);
        CuentaDeAhorros cuenta12 = new CuentaDeAhorros(20, "C12", "C12", 0);*/

        CuentaDeAhorros cuenta1 = new CuentaDeAhorros(40, "C1", "C1", 0);
        CuentaDeAhorros cuenta2 = new CuentaDeAhorros(30, "C2", "C2", 0);
        CuentaDeAhorros cuenta3 = new CuentaDeAhorros(70, "C3", "C3", 0);
        CuentaDeAhorros cuenta4 = new CuentaDeAhorros(10, "C4", "C4", 0);
        CuentaDeAhorros cuenta5 = new CuentaDeAhorros(35, "C5", "C5", 0);
        CuentaDeAhorros cuenta6 = new CuentaDeAhorros(20, "C6", "C6", 0);
        CuentaDeAhorros cuenta7 = new CuentaDeAhorros(25, "C7", "C7", 0);
        CuentaDeAhorros cuenta8 = new CuentaDeAhorros(80, "C8", "C7", 0);
        CuentaDeAhorros cuenta9 = new CuentaDeAhorros(69, "C9", "C7", 0);
        CuentaDeAhorros cuenta10 = new CuentaDeAhorros(81, "C10", "C7", 0);

        banco.add(cuenta1);
        banco.add(cuenta2);
        banco.add(cuenta3);
        banco.add(cuenta4);
        banco.add(cuenta5);
        banco.add(cuenta6);
        banco.add(cuenta7);
        banco.add(cuenta8);
        banco.add(cuenta9);
        banco.add(cuenta10);
        /*banco.add(cuenta11);
        banco.add(cuenta12);*/

        System.out.println("size:" + banco.size() );
        System.out.println("number of leaves: " + banco.numberLeaves() );
        System.out.println("numero de Hojas: " + banco.numHojas() );
        System.out.println("My Parent:" + banco.myParent(cuenta4));
        System.out.println("Mi altura:" + banco.altura());
        System.out.println("Mi nivel es:" + banco.calcularNivel(cuenta6));
        System.out.println("Mi nodo en el nive: " + banco.numNodosDelNivel(2));
        banco.nodosDelNivel(2);
        //System.out.println( "Lo encontrò" + banco.findNode(cuenta4));

    }

}
