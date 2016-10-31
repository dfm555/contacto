package Interfaz;

import comun.DirectorioContactos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class panelOperaciones extends JPanel  {

    private JButton btnagregarcontacto, btneliminarcontacto, btnmostrarcontactos, btnjerarquia,btnmostrarresultadosa,btnmostrarresultadosd,btnmostrarresultadose,btnmostrarresultadosf,btnmostrarresultadosg,btnmostrarresultadosh;
    private InterfazDirectorioContactos ventanaPrincipal;
    
    public panelOperaciones(InterfazDirectorioContactos interfaz) {

        ventanaPrincipal= interfaz;
        btnagregarcontacto = new JButton("Agr.Contacto");
        btneliminarcontacto = new JButton("Eli.Contacto");
        btnmostrarcontactos = new JButton("Mos.contactos");
        btnjerarquia = new JButton("Arb.Jerárquico");
        btnmostrarresultadosa = new JButton("Punto 2(a)");
        btnmostrarresultadosd = new JButton("Punto 2(d)");
        btnmostrarresultadose = new JButton("Punto 2(e)");
        btnmostrarresultadosf = new JButton("Punto 2(f)");
        btnmostrarresultadosg = new JButton("Punto 2(g)");
        btnmostrarresultadosh = new JButton("Punto 2(h)");


        setLayout(new GridLayout(2, 4));
        setBorder(BorderFactory.createTitledBorder("Operaciones"));

        add(btnagregarcontacto);
        add(btneliminarcontacto);
        add(btnmostrarcontactos);
        add(btnjerarquia);
        add(btnmostrarresultadosa);
        add(btnmostrarresultadosd);
        add(btnmostrarresultadose);
        add(btnmostrarresultadosf);
        add(btnmostrarresultadosg);
        add(btnmostrarresultadosh);

    }
 

}
