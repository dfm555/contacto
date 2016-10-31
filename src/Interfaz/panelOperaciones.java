package Interfaz;

import comun.DirectorioContactos;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class panelOperaciones extends JPanel implements ActionListener {

    private JButton btnagregarcontacto, btneliminarcontacto, btnmostrarcontactos, btnjerarquia,btnmostrarresultadosa,btnmostrarresultadosd,btnmostrarresultadose,btnmostrarresultadosf,btnmostrarresultadosg,btnmostrarresultadosh;
    private InterfazDirectorioContactos ventanaPrincipal;
    
    public panelOperaciones(InterfazDirectorioContactos interfaz) {

        ventanaPrincipal= interfaz;
        
        btnagregarcontacto = new JButton();
        inicializarOperaciones(btnagregarcontacto, "Agr.Contacto", "AGREGAR");
        
        btneliminarcontacto = new JButton("Eli.Contacto");
      
        
        btnmostrarcontactos = new JButton();
        inicializarOperaciones(btnmostrarcontactos, "Mos.contactos", "ALFABETICO");
        
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
     private void inicializarOperaciones(JButton boton, String etiqueta, String comando) {
        boton.setText(etiqueta);
        boton.setFocusable(false);
        boton.setActionCommand(comando);
        boton.addActionListener(this);
        boton.setDefaultCapable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        String actionCommand = evento.getActionCommand();

        // Boton añadir contacto
        if (actionCommand.equals("AGREGAR")) {
            ventanaPrincipal.adicionarContactoDirectorio();
        }
        // Boton orden alfabetico
        if (actionCommand.equals("ALFABETICO")) {
            ventanaPrincipal.mostrarContactosAlfabeticamente();
        }
    }

}
