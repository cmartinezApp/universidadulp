package vistas;

import Entidades.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import AccesoADatos.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Vista_Ins extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private AlumnoData alumnoData;

    private Alumno a1;

    public Vista_Ins() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null); //Elimina encabezado de ventana
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

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Inscripto = new javax.swing.JRadioButton();
        noInscripto = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        botonInscribir = new javax.swing.JButton();
        Anular = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setBackground(java.awt.SystemColor.activeCaption);
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seleccione un Alumno");

        ComboBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Listado de Materias");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Materias Inscriptas");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Materias no Inscriptas");

        Inscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InscriptoActionPerformed(evt);
            }
        });

        noInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noInscriptoActionPerformed(evt);
            }
        });

        Tabla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        botonInscribir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonInscribir.setText("Inscribir");
        botonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInscribirActionPerformed(evt);
            }
        });

        Anular.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Anular.setText("Anular Inscripcion");
        Anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnularActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
                .addGap(98, 98, 98)
                .addComponent(botonInscribir)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Anular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(77, 77, 77)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Inscripto)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(68, 68, 68)
                                .addComponent(noInscripto)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(noInscripto)
                    .addComponent(Inscripto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInscribir)
                    .addComponent(Anular)
                    .addComponent(Salir))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();

    }//GEN-LAST:event_SalirActionPerformed

    private void noInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noInscriptoActionPerformed
        Tabla.removeAll();
        Inscripto.setSelected(false);
        InscripcionData ins_data = new InscripcionData();
        // Llamar al método obtenerMateriasNoCursadas para obtener la lista de materias no cursadas
        List<Materia> materiasNoCursadas = ins_data.obtenerMateriasNoCursadas(ComboBox1.getItemAt(ComboBox1.getSelectedIndex()).getIdAlumno());
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
    }//GEN-LAST:event_noInscriptoActionPerformed

    private void botonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInscribirActionPerformed
        //Instanciamos los Objetos a Utilizar
        MateriaData matData = new MateriaData();
        //Obtenemos el Alumno del ComboBox
        Alumno alu = (Alumno) ComboBox1.getSelectedItem();

        //Obtenemos la Fila Seleccionada
        int fs = (int) modeloTabla.getValueAt(Tabla.getSelectedRow(), 0);

        //Instanciamos la Inscripcion y el Alumno
        Inscripcion in = new Inscripcion();
        a1 = alumnoData.buscarAlumnoPorDni(alu.getDni());

        //Seteamos los Datos de Materia e Inscripcion
        in.setAlumno(alu);
        Materia materia = matData.buscarMateria(fs);
        in.setMateria(materia);

        //Guardamos la Inscripcion
        InscripcionData ins_data = new InscripcionData();
        ins_data.guardarInscripcion(in);
        noInscriptoActionPerformed(evt);
    }//GEN-LAST:event_botonInscribirActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked

    }//GEN-LAST:event_TablaMouseClicked

    private void InscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InscriptoActionPerformed
        Tabla.removeAll();
        noInscripto.setSelected(false);
        InscripcionData ins_data = new InscripcionData();
        // Llamar al método obtenerMateriasNoCursadas para obtener la lista de materias no cursadas
        List<Materia> materiasCursadas = ins_data.obtenerMateriaCursada(ComboBox1.getItemAt(ComboBox1.getSelectedIndex()).getIdAlumno());
        if (materiasCursadas != null) {
            // Limpiar la tabla antes de agregar nuevos datos
            DefaultTableModel modeloTabla = (DefaultTableModel) Tabla.getModel();
            modeloTabla.setRowCount(0);
            // Agregar las materias no cursadas a la tabla
            for (Materia materia : materiasCursadas) {
                // Agrega una fila con los datos de la materia
                modeloTabla.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAnioMateria()});
            }
        }
    }//GEN-LAST:event_InscriptoActionPerformed

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        Tabla.removeAll();
        Inscripto.setSelected(false);
        noInscripto.setSelected(false);
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void AnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnularActionPerformed
        // Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = Tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener el ID de la materia seleccionada en la tabla
            int idMateria = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

            //Instanciamos la InscripcionData
            InscripcionData ins_data = new InscripcionData();

            // Llamamos al método borrarInscripcion para anular la inscripción
            ins_data.borrarInscripcion(a1.getIdAlumno(), idMateria);

            // Volver a cargar las materias inscriptas después de la anulación
            InscriptoActionPerformed(evt);
        } else {
            // Mostrar un mensaje de error si no se selecciona ninguna materia en la tabla
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una materia para anular la inscripción.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anular;
    private javax.swing.JComboBox<Alumno> ComboBox1;
    private javax.swing.JRadioButton Inscripto;
    private javax.swing.JButton Salir;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton botonInscribir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton noInscripto;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        List<Alumno> listaAlumnos = alumnoData.listarAlumnos();
        for (Alumno alumno : listaAlumnos) {
            ComboBox1.addItem(new Alumno(alumno.getIdAlumno(), alumno.getDni(), alumno.getApellido(), alumno.getNombre()));
        }
    }

    private void agregarTabla() {
        Tabla.setModel(modeloTabla);
        modeloTabla.addColumn("id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Año");
    }
}
