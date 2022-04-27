/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.border.Border;
import org.junit.Test;

/**
 *
 * @author ahmed
 */

public class TrackTrip extends javax.swing.JFrame {

    /**
     * Creates new form CabBook
     */
    public TrackTrip() {
        initComponents();
        DriverDropDown();
        this.setLocationRelativeTo(null);
        showDate();
        showTime();
        Border jLabel_Title_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        Border jLabel_bar = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        this.setResizable(false);
    }

    public void DriverDropDown() {

        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from drivers";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                jComboBox_DriverID.addItem(rs.getString("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void myMap() {

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
        jButton_LogOut = new javax.swing.JButton();
        jButton_Home = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Date1 = new javax.swing.JLabel();
        jLabel_datetoday = new javax.swing.JLabel();
        jLabel_Date2 = new javax.swing.JLabel();
        jLabel_timenow = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField_Pickup = new javax.swing.JTextField();
        jLabel_UserName = new javax.swing.JLabel();
        jLabel_UserName1 = new javax.swing.JLabel();
        jTextField_Pickup1 = new javax.swing.JTextField();
        jButton_Track1 = new javax.swing.JButton();
        jButton_Track2 = new javax.swing.JButton();
        jComboBox_DriverID = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel_ALLR1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        jPanel2.add(jLabel_ALLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 640, 286, 23));

        jPanel_bar.setBackground(new java.awt.Color(0, 0, 102));

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

        jButton_Home.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Home.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Home.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/favicon-48x48.png"))); // NOI18N
        jButton_Home.setText("    Home");
        jButton_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_barLayout = new javax.swing.GroupLayout(jPanel_bar);
        jPanel_bar.setLayout(jPanel_barLayout);
        jPanel_barLayout.setHorizontalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                        .addComponent(jButton_LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129))
                    .addGroup(jPanel_barLayout.createSequentialGroup()
                        .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_SetNewTrip, jButton_ShowStatistics});

        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_AddDriver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_SetNewTrip, jButton_ShowStatistics});

        jPanel2.add(jPanel_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 236, 510));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tracking Pannel");
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

        jPanel6.setBackground(new java.awt.Color(63, 46, 104));

        jTextField_Pickup.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Pickup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Pickup.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Pickup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_PickupFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_PickupFocusLost(evt);
            }
        });
        jTextField_Pickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PickupActionPerformed(evt);
            }
        });

        jLabel_UserName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName.setText("Start");

        jLabel_UserName1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName1.setText("Destination");

        jTextField_Pickup1.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Pickup1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Pickup1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Pickup1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Pickup1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Pickup1FocusLost(evt);
            }
        });
        jTextField_Pickup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Pickup1ActionPerformed(evt);
            }
        });

        jButton_Track1.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Track1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Track1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Track1.setText("Track");
        jButton_Track1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton_Track2.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Track2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Track2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Track2.setText("Track Using DriverID");
        jButton_Track2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBox_DriverID.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox_DriverID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_DriverID.setMaximumRowCount(10);
        jComboBox_DriverID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Driver" }));
        jComboBox_DriverID.setSelectedItem(0);
        jComboBox_DriverID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox_DriverIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_DriverIDFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField_Pickup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel_UserName)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_UserName1)
                    .addComponent(jTextField_Pickup1))
                .addGap(18, 18, 18)
                .addComponent(jButton_Track1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jComboBox_DriverID, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButton_Track2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_UserName1)
                    .addComponent(jLabel_UserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Pickup1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Pickup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Track1)
                    .addComponent(jComboBox_DriverID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Track2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/mm.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 900, 450));

        jLabel_ALLR1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setText("Developed  by Ahmed");
        jPanel2.add(jLabel_ALLR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 640, 120, 23));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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

    private void jComboBox_DriverIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_DriverIDFocusLost
        jComboBox_DriverID.setForeground(new Color(153, 153, 153));
        //jLabel_DriverID.setBorder(null);
    }//GEN-LAST:event_jComboBox_DriverIDFocusLost

    private void jComboBox_DriverIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_DriverIDFocusGained
        jComboBox_DriverID.setForeground(Color.black);
        Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
        //jLabel_DriverID.setBorder(jLabel_icon);
    }//GEN-LAST:event_jComboBox_DriverIDFocusGained

    private void jTextField_Pickup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Pickup1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Pickup1ActionPerformed

    private void jTextField_Pickup1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Pickup1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Pickup1FocusLost

    private void jTextField_Pickup1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Pickup1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Pickup1FocusGained

    private void jTextField_PickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PickupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PickupActionPerformed

    private void jTextField_PickupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PickupFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PickupFocusLost

    private void jTextField_PickupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PickupFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PickupFocusGained

    private void jButton_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HomeActionPerformed
        MyDispatcher form = new MyDispatcher();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_HomeActionPerformed

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
            java.util.logging.Logger.getLogger(TrackTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackTrip().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddDriver;
    private javax.swing.JButton jButton_Home;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_SetNewTrip;
    private javax.swing.JButton jButton_ShowStatistics;
    private javax.swing.JButton jButton_Track1;
    private javax.swing.JButton jButton_Track2;
    private javax.swing.JComboBox<String> jComboBox_DriverID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_ALLR;
    private javax.swing.JLabel jLabel_ALLR1;
    private javax.swing.JLabel jLabel_Date1;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_UserName;
    private javax.swing.JLabel jLabel_UserName1;
    private javax.swing.JLabel jLabel_datetoday;
    private javax.swing.JLabel jLabel_timenow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_bar;
    private javax.swing.JTextField jTextField_Pickup;
    private javax.swing.JTextField jTextField_Pickup1;
    // End of variables declaration//GEN-END:variables
}
