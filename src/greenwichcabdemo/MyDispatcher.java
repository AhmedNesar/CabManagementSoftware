/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;
import org.junit.Test;

/**
 *
 * @author ahmed
 */

public class MyDispatcher extends javax.swing.JFrame {

    /**
     * Creates new form CabBook
     */
    public MyDispatcher() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        showDate();
        showTime();
        Border jLabel_Title_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        Border jLabel_bar = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
    }

    public void showTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss a");
                jLabel_timenow.setText(s.format(date));
            }
        }
        ).start();
    }

    public void showDate() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String tt = formatter.format(date);
        String dd = format.format(date);
        jLabel_datetoday.setText(dd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_Title = new javax.swing.JLabel();
        jLabel_ALLR = new javax.swing.JLabel();
        jPanel_bar = new javax.swing.JPanel();
        jButton_SetNewTrip = new javax.swing.JButton();
        jButton_ShowStatistics = new javax.swing.JButton();
        jButton_AddDriver = new javax.swing.JButton();
        jButton_TrackTrip = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Date1 = new javax.swing.JLabel();
        jLabel_datetoday = new javax.swing.JLabel();
        jLabel_Date2 = new javax.swing.JLabel();
        jLabel_timenow = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_ALLR1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Title.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Title.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 40)); // NOI18N
        jLabel_Title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon-60@2x.png"))); // NOI18N
        jLabel_Title.setText("   Greenwich Cab Service");
        jPanel3.add(jLabel_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 940, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        jLabel_ALLR.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR.setText("All rights reserved by ⒸGreenwich Cab Service");
        jPanel2.add(jLabel_ALLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, 286, 23));

        jPanel_bar.setBackground(new java.awt.Color(0, 0, 102));
        jPanel_bar.setPreferredSize(new java.awt.Dimension(353, 75));

        jButton_SetNewTrip.setBackground(new java.awt.Color(0, 84, 144));
        jButton_SetNewTrip.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_SetNewTrip.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SetNewTrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-cab-stand-50.png"))); // NOI18N
        jButton_SetNewTrip.setText("    Set New Trip");
        jButton_SetNewTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_SetNewTripMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_SetNewTripMouseExited(evt);
            }
        });
        jButton_SetNewTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SetNewTripActionPerformed(evt);
            }
        });

        jButton_ShowStatistics.setBackground(new java.awt.Color(0, 84, 144));
        jButton_ShowStatistics.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_ShowStatistics.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ShowStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon-Small50.png"))); // NOI18N
        jButton_ShowStatistics.setText("  Show Statistics");
        jButton_ShowStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ShowStatisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ShowStatisticsMouseExited(evt);
            }
        });
        jButton_ShowStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatisticsActionPerformed(evt);
            }
        });

        jButton_AddDriver.setBackground(new java.awt.Color(0, 84, 144));
        jButton_AddDriver.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_AddDriver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddDriver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-taxi-driver-60.png"))); // NOI18N
        jButton_AddDriver.setText(" Add New Driver");
        jButton_AddDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_AddDriverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_AddDriverMouseExited(evt);
            }
        });
        jButton_AddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddDriverActionPerformed(evt);
            }
        });

        jButton_TrackTrip.setBackground(new java.awt.Color(0, 84, 144));
        jButton_TrackTrip.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_TrackTrip.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TrackTrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon-Small@2x.png"))); // NOI18N
        jButton_TrackTrip.setText(" Track a Trip");
        jButton_TrackTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_TrackTripMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_TrackTripMouseExited(evt);
            }
        });
        jButton_TrackTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TrackTripActionPerformed(evt);
            }
        });

        jButton_LogOut.setBackground(new java.awt.Color(0, 84, 144));
        jButton_LogOut.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_LogOut.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon-SmallLogout.png"))); // NOI18N
        jButton_LogOut.setText("Log Out");
        jButton_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_LogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_LogOutMouseExited(evt);
            }
        });
        jButton_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_barLayout = new javax.swing.GroupLayout(jPanel_bar);
        jPanel_bar.setLayout(jPanel_barLayout);
        jPanel_barLayout.setHorizontalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_LogOut)
                    .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(129, 129, 129))
        );
        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_AddDriver, jButton_SetNewTrip, jButton_ShowStatistics, jButton_TrackTrip});

        jPanel2.add(jPanel_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 236, 540));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Dispatcher Pannel");
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 239, 38));

        jLabel_Date1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Date1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel_Date1.setText("Date Today:");
        jPanel4.add(jLabel_Date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 21));

        jLabel_datetoday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_datetoday.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_datetoday.setText("date");
        jPanel4.add(jLabel_datetoday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 120, 20));

        jLabel_Date2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Date2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel_Date2.setText("Time: ");
        jPanel4.add(jLabel_Date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 21));

        jLabel_timenow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_timenow.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_timenow.setText("time");
        jPanel4.add(jLabel_timenow, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 100, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 900, 50));

        jPanel5.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ezgif.com-gif-maker (1).gif"))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(124, 124, 250));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro Black", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("Welcome to Greenwich Cab Service Dispatcher Panel");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 900, 450));

        jLabel_ALLR1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setText("Developed  by Ahmed");
        jPanel2.add(jLabel_ALLR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 650, 120, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_SetNewTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SetNewTripActionPerformed

        SetTrip form = new SetTrip();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_SetNewTripActionPerformed

    private void jButton_SetNewTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SetNewTripMouseEntered
        jButton_SetNewTrip.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_SetNewTripMouseEntered

    private void jButton_SetNewTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SetNewTripMouseExited
        jButton_SetNewTrip.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_SetNewTripMouseExited

    private void jButton_AddDriverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AddDriverMouseEntered
        jButton_AddDriver.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_AddDriverMouseEntered

    private void jButton_AddDriverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AddDriverMouseExited
        jButton_AddDriver.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_AddDriverMouseExited

    private void jButton_ShowStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatisticsMouseEntered
        jButton_ShowStatistics.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_ShowStatisticsMouseEntered

    private void jButton_AddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddDriverActionPerformed
        AddDriver form = new AddDriver();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_AddDriverActionPerformed

    private void jButton_ShowStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatisticsActionPerformed
        AllStat form = new AllStat();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_ShowStatisticsActionPerformed

    private void jButton_ShowStatisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatisticsMouseExited
        jButton_ShowStatistics.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_ShowStatisticsMouseExited

    private void jButton_TrackTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TrackTripActionPerformed
        TrackTrip form = new TrackTrip();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_TrackTripActionPerformed

    private void jButton_TrackTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TrackTripMouseEntered
        jButton_TrackTrip.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_TrackTripMouseEntered

    private void jButton_TrackTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TrackTripMouseExited
        jButton_TrackTrip.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_TrackTripMouseExited

    private void jButton_LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogOutMouseEntered
        jButton_LogOut.setBackground(new Color(156, 0, 11));
    }//GEN-LAST:event_jButton_LogOutMouseEntered

    private void jButton_LogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogOutMouseExited
        jButton_LogOut.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_LogOutMouseExited

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login form = new Login();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_LogOutActionPerformed

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
            java.util.logging.Logger.getLogger(MyDispatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyDispatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyDispatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyDispatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyDispatcher().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddDriver;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_SetNewTrip;
    private javax.swing.JButton jButton_ShowStatistics;
    private javax.swing.JButton jButton_TrackTrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_ALLR;
    private javax.swing.JLabel jLabel_ALLR1;
    private javax.swing.JLabel jLabel_Date1;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_datetoday;
    private javax.swing.JLabel jLabel_timenow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_bar;
    // End of variables declaration//GEN-END:variables
}
