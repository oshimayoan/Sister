/*
 * Copyright (C) 2014 Yoan Pratama Putra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fridge;

/**
 *
 * @author Yoan Pratama Putra
 */
public class Main extends javax.swing.JFrame{

    /**
     * Creates new form Main
     */
    private Fridge server;
    public static int temperature;
    public static int freezerTemp;
    public static Thread tempThread;
    
    // ubah suhu
    public static void changeTemperature() {
        lblTemperature.setText(Integer.toString(temperature));
        lblFreezer.setText(Integer.toString(freezerTemp));
    }
    
    // ambil suhu untuk client
    public static int getTemperature() {
        return Integer.parseInt(lblTemperature.getText());
    }
    
    public Main() {
        initComponents();
        this.setTitle("Fridge");
        try {
            server = new Fridge();
        } catch(Exception ex) {
            System.out.println("Server: " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCelcius = new javax.swing.JLabel();
        btnSwitch = new javax.swing.JToggleButton();
        btnTempMin = new javax.swing.JButton();
        lblTemperature = new javax.swing.JLabel();
        btnTempMax = new javax.swing.JButton();
        lblFridgeTemperature = new javax.swing.JLabel();
        btnFreezerMax = new javax.swing.JButton();
        btnFreezerMin = new javax.swing.JButton();
        lblCelcius2 = new javax.swing.JLabel();
        lblFreezer = new javax.swing.JLabel();
        lblFreezerTemperature = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        lblCelcius.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCelcius.setText("°C");

        btnSwitch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSwitch.setText("Turn on");
        btnSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchActionPerformed(evt);
            }
        });

        btnTempMin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTempMin.setText("-");
        btnTempMin.setEnabled(false);
        btnTempMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTempMinActionPerformed(evt);
            }
        });

        lblTemperature.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTemperature.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTemperature.setText("0");

        btnTempMax.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTempMax.setText("+");
        btnTempMax.setEnabled(false);
        btnTempMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTempMaxActionPerformed(evt);
            }
        });

        lblFridgeTemperature.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFridgeTemperature.setText("Fridge :");

        btnFreezerMax.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFreezerMax.setText("+");
        btnFreezerMax.setEnabled(false);

        btnFreezerMin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFreezerMin.setText("-");
        btnFreezerMin.setEnabled(false);

        lblCelcius2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCelcius2.setText("°C");

        lblFreezer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFreezer.setText("0");

        lblFreezerTemperature.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFreezerTemperature.setText("Freezer :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSwitch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFridgeTemperature))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(lblFreezerTemperature)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelcius))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblFreezer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCelcius2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTempMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFreezerMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFreezerMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTempMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelcius)
                    .addComponent(btnTempMin)
                    .addComponent(lblTemperature)
                    .addComponent(btnTempMax)
                    .addComponent(btnSwitch)
                    .addComponent(lblFridgeTemperature))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFreezerMax)
                    .addComponent(btnFreezerMin)
                    .addComponent(lblCelcius2)
                    .addComponent(lblFreezer)
                    .addComponent(lblFreezerTemperature))
                .addContainerGap(537, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchActionPerformed
        try {
            if(this.btnSwitch.getText().equals("Turn on")) {
                // menghidupkan kulkas dan menjalankan RMI
                server.start();
                
                // ambil nilai suhu dari database
                Temperature temp = new Temperature();
                temperature = temp.getTemp();
                
                this.setTitle("Fridge [" + server.getStatus() + "]");
                this.btnSwitch.setText("Turn off");
                this.btnTempMin.setEnabled(true);
                this.btnTempMax.setEnabled(true);
                this.btnFreezerMin.setEnabled(true);
                this.btnFreezerMax.setEnabled(true);
            } else {
                // mematikan kulkas dan menghentikan RMI
                server.stop();
                this.setTitle("Fridge");
                this.btnSwitch.setText("Turn on");
                this.btnTempMin.setEnabled(false);
                this.btnTempMax.setEnabled(false);
                this.btnFreezerMin.setEnabled(false);
                this.btnFreezerMax.setEnabled(false);
            }
        } catch(Exception ex) {
            System.out.println("Failed: " + ex);
            this.btnSwitch.setSelected(false);
        }
    }//GEN-LAST:event_btnSwitchActionPerformed

    private void btnTempMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTempMinActionPerformed
        // cek apakah suhu > -20
        if(temperature > 1) {
            // kurangi suhu
            temperature--;
            lblTemperature.setText(Integer.toString(temperature));
        }
    }//GEN-LAST:event_btnTempMinActionPerformed

    private void btnTempMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTempMaxActionPerformed
        // cek apakah suhu < 4
        if(temperature < 6) {
            // tambah suhu
            temperature++;
            lblTemperature.setText(Integer.toString(temperature));
        }
    }//GEN-LAST:event_btnTempMaxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
                // buat dan jalankan thread suhu
                temperatureThread tempThread = new temperatureThread();
                tempThread.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFreezerMax;
    private javax.swing.JButton btnFreezerMin;
    private javax.swing.JToggleButton btnSwitch;
    private javax.swing.JButton btnTempMax;
    private javax.swing.JButton btnTempMin;
    private javax.swing.JLabel lblCelcius;
    private javax.swing.JLabel lblCelcius2;
    private static javax.swing.JLabel lblFreezer;
    private javax.swing.JLabel lblFreezerTemperature;
    private javax.swing.JLabel lblFridgeTemperature;
    private static javax.swing.JLabel lblTemperature;
    // End of variables declaration//GEN-END:variables

}
