package vistas;

import Entidades.*;
import java.sql.Connection;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;

/**
 *
 * @author Juan
 */
public class Vista_Ins extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private AlumnoData alumnoData;
    
    private Alumno a1;

    public Vista_Ins(Connection conexion) {
        initComponents();
        this.setTitle("Inscripciones");

        alumnoData = new AlumnoData();
        a1 = new Alumno();
        
        cargarCombo();
        // Llamar al método cargarTabla para inicializar la tabla
        agregarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BotonInscribir = new javax.swing.JButton();
        Anular = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un Alumno");

        ComboBox1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                ComboBox1ComponentAdded(evt);
            }
        });
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado de Materias");

        jLabel4.setText("Materias Inscriptas");

        jLabel5.setText("Materias no Inscriptas");

        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        BotonInscribir.setText("Inscribir");
        BotonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInscribirActionPerformed(evt);
            }
        });

        Anular.setText("Anular Inscripcion");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 357, Short.MAX_VALUE)
                                .addComponent(Salir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(BotonInscribir)
                        .addGap(68, 68, 68)
                        .addComponent(Anular))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonInscribir)
                    .addComponent(Anular)
                    .addComponent(Salir))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SalirActionPerformed

    private void ComboBox1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_ComboBox1ComponentAdded

    }//GEN-LAST:event_ComboBox1ComponentAdded

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        InscripcionData ins_data = new InscripcionData();
        // Llamar al método obtenerMateriasNoCursadas para obtener la lista de materias no cursadas
        List<Materia> materiasNoCursadas = ins_data.obtenerMateriasNoCursadas(0);
        if (materiasNoCursadas != null) {
            // Limpiar la tabla antes de agregar nuevos datos
            DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
            modeloTabla.setRowCount(0);
            // Agregar las materias no cursadas a la tabla
            for (Materia materia : materiasNoCursadas) {
                // Agrega una fila con los datos de la materia
                modeloTabla.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
            }
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void BotonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInscribirActionPerformed
        
        int filaSeleccionada = Tabla.getSelectedRow();

        if (filaSeleccionada >= 0) {
            Object idMateria = Tabla.getValueAt(filaSeleccionada, 0);
            Object nombreMateria = Tabla.getValueAt(filaSeleccionada, 1);
            Object añoMateria = Tabla.getValueAt(filaSeleccionada, 2);

            // Configurar la instancia de Materia (reemplaza con la instancia correcta)
            Materia materiaSeleccionada = new Materia();
            materiaSeleccionada.setIdMateria(Integer.parseInt(idMateria.toString())); // Asignar el id de la materia como int
            materiaSeleccionada.setNombre(nombreMateria.toString()); // Asignar el nombre de la materia
            materiaSeleccionada.setAnioMateria(Integer.parseInt((String) añoMateria)); // Asignar el año de la materia como int

            // Crear una instancia de Inscripcion y configurarla con los valores
            Inscripcion insc = new Inscripcion();
            insc.setAlumno(a1);
            insc.setMateria(materiaSeleccionada);

            // Asignar la nota (si tienes un mecanismo para obtenerla)
            double nota = insc.getNota(); // Reemplaza obtenerNota() con tu lógica real
            insc.setNota(nota);

            // Llamar al método para guardar la inscripción
            InscripcionData ins = new InscripcionData();
            ins.guardarInscripcion(insc);
        }

    }//GEN-LAST:event_BotonInscribirActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked

    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anular;
    private javax.swing.JButton BotonInscribir;
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JButton Salir;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        List<Alumno> listaAlumnos = alumnoData.listarAlumnos();

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Alumno alumno : listaAlumnos) {
            modelo.addElement(alumno.toString());
        }
        ComboBox1.setModel(modelo);
    }

    private void agregarTabla() {
        Tabla.setModel(modeloTabla);
        modeloTabla.addColumn("id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Año");
    }
}
