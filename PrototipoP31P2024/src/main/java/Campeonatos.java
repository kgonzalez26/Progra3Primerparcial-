/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.util.Random;
/**
 *
 * @author Maynor
 */
public class Campeonatos extends javax.swing.JPanel {

    private String[] equipos;
    private int[][] resultados;
    
    public Campeonatos() {
        initComponents();
        equipos = new String[6];
        resultados = new int[6][6];
    }
    
    private int generarNumeroAleatorio(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private void simularPartidos() {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                int golesEquipoLocal = generarNumeroAleatorio(0, 10);
                int golesEquipoVisitante = generarNumeroAleatorio(0, 10);
                resultados[i][j] = golesEquipoLocal;
                resultados[j][i] = golesEquipoVisitante;
            }
        }
    }

    private int[] calcularPuntos() {
        int[] puntos = new int[equipos.length];
        for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++) {
                if (i != j) {
                    if (resultados[i][j] != -1 || resultados[j][i] != -1) {
                        if (resultados[i][j] > resultados[j][i]) {
                            puntos[i] += 3; // Equipo i gana
                        } else if (resultados[i][j] < resultados[j][i]) {
                            puntos[j] += 3; // Equipo j gana
                        } else {
                            puntos[i] += 1; // Empate
                            puntos[j] += 1;
                        }
                    }
                }
            }
        }
        return puntos;
    }

    private void mostrarTabla() {
        int[] puntos = calcularPuntos();
        String tabla = "Tabla de Posiciones:\n";
        tabla += "Equipo\tPartidos\tGanados\tEmpatados\tPerdidos\tPuntos\n";
        for (int i = 0; i < equipos.length; i++) {
            int partidosJugados = 0;
            int partidosGanados = 0;
            int partidosEmpatados = 0;
            int partidosPerdidos = 0;
            for (int j = 0; j < equipos.length; j++) {
                if (i != j) {
                    if (resultados[i][j] != -1 || resultados[j][i] != -1) {
                        partidosJugados++;
                        if (resultados[i][j] > resultados[j][i]) {
                            partidosGanados++;
                        } else if (resultados[i][j] < resultados[j][i]) {
                            partidosPerdidos++;
                        } else {
                            partidosEmpatados++;
                        }
                    }
                }
            }
            tabla += equipos[i] + "\t" + partidosJugados + "\t\t" + partidosGanados + "\t"
                    + partidosEmpatados + "\t\t" + partidosPerdidos + "\t\t" + puntos[i] + "\n";
        }
        System.out.println(tabla);
    }
    
    

    private String equipoGanador() {
        int[] puntos = calcularPuntos();
        int maxPuntos = 0;
        int indiceEquipo = 0;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] > maxPuntos) {
                maxPuntos = puntos[i];
                indiceEquipo = i;
            }
        }
        return equipos[indiceEquipo];
    }

    private String equipoBaja() {
        int[] puntos = calcularPuntos();
        int minPuntos = puntos[0];
        int indiceEquipo = 0;
        for (int i = 1; i < puntos.length; i++) {
            if (puntos[i] < minPuntos) {
                minPuntos = puntos[i];
                indiceEquipo = i;
            }
        }
        return equipos[indiceEquipo];
    }
    
    private void borrarEquipos() {
        for (int i = 0; i < equipos.length; i++) {
            equipos[i] = null;
        }
        for (int i = 0; i < resultados.length; i++) {
            for (int j = 0; j < resultados[i].length; j++) {
                resultados[i][j] = 0;
            }
        }
        System.out.println("Se han borrado todos los equipos.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IngresoEquipo = new javax.swing.JTextField();
        IngresarEquipos = new javax.swing.JButton();
        Table = new javax.swing.JButton();
        SimularPartidos = new javax.swing.JButton();
        Resul = new javax.swing.JButton();
        borrarEquipos = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Equipos de un campeonato");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Equipos de un campeonato");

        IngresoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoEquipoActionPerformed(evt);
            }
        });

        IngresarEquipos.setText("Ingresar Equipos");
        IngresarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarEquiposActionPerformed(evt);
            }
        });

        Table.setText("Mostrar Tabla");
        Table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableActionPerformed(evt);
            }
        });

        SimularPartidos.setText("Simular Partidos");
        SimularPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimularPartidosActionPerformed(evt);
            }
        });

        Resul.setText("Calcular Resultado");
        Resul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResulActionPerformed(evt);
            }
        });

        borrarEquipos.setText("Borrar y restablecer");
        borrarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarEquiposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IngresoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IngresarEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Table, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(borrarEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(SimularPartidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(Resul, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IngresarEquipos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Table)
                    .addComponent(SimularPartidos)
                    .addComponent(Resul))
                .addGap(18, 18, 18)
                .addComponent(borrarEquipos)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IngresoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoEquipoActionPerformed
        // ignorar este boton
    }//GEN-LAST:event_IngresoEquipoActionPerformed

    private void IngresarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarEquiposActionPerformed

        String nombreEquipo = IngresoEquipo.getText();

        int equiposIngresados = 0;
        for (String equipo : equipos) {
            if (equipo != null) {
                equiposIngresados++;
            }
        }

        if (equiposIngresados < 6) {
            equipos[equiposIngresados] = nombreEquipo;
            equiposIngresados++;

            IngresoEquipo.setText("");

            if (equiposIngresados == 6) {
                System.out.println("Se han ingresado los 6 equipos.");
            }
        } else {
            System.out.println("Ya se han ingresado los 6 equipos.");
        }
    }//GEN-LAST:event_IngresarEquiposActionPerformed

    private void TableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableActionPerformed
        mostrarTabla();
    }//GEN-LAST:event_TableActionPerformed

    private void SimularPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimularPartidosActionPerformed
        simularPartidos();
    }//GEN-LAST:event_SimularPartidosActionPerformed

    private void ResulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResulActionPerformed
        String ganador = equipoGanador();
        String equipoBaja = equipoBaja();
        System.out.println("El equipo ganador es: " + ganador);
        System.out.println("El equipo que baja de categoría es: " + equipoBaja);
    }//GEN-LAST:event_ResulActionPerformed

    private void borrarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarEquiposActionPerformed
        borrarEquipos();
    }//GEN-LAST:event_borrarEquiposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresarEquipos;
    private javax.swing.JTextField IngresoEquipo;
    private javax.swing.JButton Resul;
    private javax.swing.JButton SimularPartidos;
    private javax.swing.JButton Table;
    private javax.swing.JButton borrarEquipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
