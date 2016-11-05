package Interfaz;

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
        
        btneliminarcontacto = new JButton();
        inicializarOperaciones(btneliminarcontacto,"Eli.Contacto","ELIMINAR");
        
        btnmostrarcontactos = new JButton();
        inicializarOperaciones(btnmostrarcontactos, "Mos.contactos", "ALFABETICO");
        
        btnjerarquia = new JButton();
        inicializarOperaciones(btnjerarquia,"Arb.Jerárquico","JERARQUICA");
        
        btnmostrarresultadosa = new JButton();
        inicializarOperaciones(btnmostrarresultadosa,"Punto 2(a)","2(A)");
        
        btnmostrarresultadosd = new JButton();
        inicializarOperaciones(btnmostrarresultadosd,"Punto 2(d)","2(D)");
        
        btnmostrarresultadose = new JButton();
        inicializarOperaciones(btnmostrarresultadose,"Punto 2(e)","2(E)");
        
        btnmostrarresultadosf = new JButton();
        inicializarOperaciones(btnmostrarresultadosf,"Punto 2(f)","2(F)");
        
        btnmostrarresultadosg = new JButton();
        inicializarOperaciones(btnmostrarresultadosg,"Punto 2(g)","2(G)");
        
        btnmostrarresultadosh = new JButton();
        inicializarOperaciones(btnmostrarresultadosh,"Punto 2(h)","2(H)");


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
         // Boton mostrar estructura jerarquica del arbol
        if (actionCommand.equals("JERARQUICA")) {
            ventanaPrincipal.mostrarContactosAlfabeticamente();
        }
         // Boton punto 2-a
        if (actionCommand.equals("2(A)")) {
            ventanaPrincipal.abrirDialogoBuscarContacto();
        }
         // Boton punto 2-d
        if (actionCommand.equals("2(D)")) {
            ventanaPrincipal.obtenerElNumeroDeNodosPorNivel();
        }
         // Boton punto 2-e
        if (actionCommand.equals("2(E)")) {
            ventanaPrincipal.mostrarContactosAlfabeticamente();
        }
         // Boton punto 2f
        if (actionCommand.equals("2(F)")) {
            ventanaPrincipal.mostrarContactosAlfabeticamente();
        }
         // Boton punto 2-g
        if (actionCommand.equals("2(G)")) {
            ventanaPrincipal.mostrarContactosAlfabeticamente();
        }
         // Boton punto 2-h
        if (actionCommand.equals("2(H)")) {
            ventanaPrincipal.elArbolEsCompleto();
        }
         // Boton eliminar contacto
        if (actionCommand.equals("ELIMINAR")) {
            ventanaPrincipal.abrirDialogoEliminarContacto();
        }
    }

}
