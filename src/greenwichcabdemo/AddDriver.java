/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ahmed
 */

public class AddDriver extends javax.swing.JFrame {

    /**
     * Creates new form CabBook
     */
    String image_path = null;

    public AddDriver() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        showDate();
        showTime();
        ShowDriver();
        Border jLabel_Title_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        Border jLabel_bar = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
    }

    public void ShowDriver() {

        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from drivers";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String cell = rs.getString("cell");
                String address = rs.getString("address");
                String carno = rs.getString("carno");
                String gender = rs.getString("gender");
                //String img = rs.getString("image");

                String tbData[] = {id, name, cell, address, carno, gender};

                DefaultTableModel tblModel = (DefaultTableModel) jTable_Drivers.getModel();

                tblModel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verifyFields() {
        String id = jTextField_DriverID.getText();
        String name = jTextField_DriverName.getText();
        String cell = jTextField_DriverCell.getText();
        String address = jTextField_DriverAddress.getText();

        if (id.trim().equals("") || name.trim().equals("") || cell.trim().equals("") || address.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
            return false;
        } else {
            return true;

        }
    }
    public void Clear(){
        jTextField_DriverID.setText("");
        jTextField_DriverName.setText("");
        jTextField_DriverCell.setText("");
        jTextField_DriverAddress.setText("");
        jTextField_DriverCarNo.setText("");
        jRadioButton_Female.setText("");
        jRadioButton_Male.setText("");
    
    }
    public boolean checkDriverID(String id) {

        PreparedStatement st;
        ResultSet rs;
        boolean driverid_exist = false;

        String query = "SELECT * FROM driverss WHERE id = ?";

        try {

            st = DBConnection.getConnection().prepareStatement(query);
            st.setString(1, id);
            rs = st.executeQuery();
            Clear();
            if (rs.next()) {
                driverid_exist = true;
                JOptionPane.showMessageDialog(null, "This Driver ID is already exist, Choose another one", "id Failed", 2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return driverid_exist;
    }

    private Icon ResizeImage(String path) {
        ImageIcon MyImage = new ImageIcon(path);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel_ImgPath.getWidth(), jLabel_ImgPath.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jButton_TrackTrip = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jButton_Home = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Date1 = new javax.swing.JLabel();
        jLabel_datetoday = new javax.swing.JLabel();
        jLabel_Date2 = new javax.swing.JLabel();
        jLabel_timenow = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_DriverID = new javax.swing.JTextField();
        jLabel_UserName = new javax.swing.JLabel();
        jLabel_UserName1 = new javax.swing.JLabel();
        jTextField_DriverName = new javax.swing.JTextField();
        jLabel_UserName2 = new javax.swing.JLabel();
        jTextField_DriverCell = new javax.swing.JTextField();
        jLabel_UserName3 = new javax.swing.JLabel();
        jTextField_DriverAddress = new javax.swing.JTextField();
        jLabel_UserName4 = new javax.swing.JLabel();
        jTextField_DriverCarNo = new javax.swing.JTextField();
        jLabel_UserName5 = new javax.swing.JLabel();
        jRadioButton_Male = new javax.swing.JRadioButton();
        jRadioButton_Female = new javax.swing.JRadioButton();
        jLabel_UserName6 = new javax.swing.JLabel();
        jButton_Img = new javax.swing.JButton();
        jLabel_ImgPath = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Drivers = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton_AddDriver = new javax.swing.JButton();
        jButton_UpdateDriver = new javax.swing.JButton();
        jButton_RemoveDriver = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jLabel_UserName7 = new javax.swing.JLabel();
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
        jPanel2.add(jLabel_ALLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 660, 286, 23));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_barLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_barLayout.createSequentialGroup()
                        .addComponent(jButton_LogOut)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(129, 129, 129))
        );
        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton_TrackTrip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 142, 236, 570));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Driver ADD/Update Pannel");
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 0, 270, 38));

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

        jPanel7.setBackground(new java.awt.Color(63, 46, 104));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("All rights reserved by ⒸGreenwich Cab Service");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 785, 286, 23));

        jTextField_DriverID.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverID.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverIDFocusLost(evt);
            }
        });
        jTextField_DriverID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverIDActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField_DriverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 282, 29));

        jLabel_UserName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName.setText("ID:");
        jPanel7.add(jLabel_UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel_UserName1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName1.setText("Full Name:");
        jPanel7.add(jLabel_UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTextField_DriverName.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverName.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverNameFocusLost(evt);
            }
        });
        jTextField_DriverName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverNameActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField_DriverName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 280, 29));

        jLabel_UserName2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName2.setText("Cell Number:");
        jPanel7.add(jLabel_UserName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTextField_DriverCell.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverCell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverCell.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverCell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverCellFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverCellFocusLost(evt);
            }
        });
        jTextField_DriverCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverCellActionPerformed(evt);
            }
        });
        jTextField_DriverCell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DriverCellKeyTyped(evt);
            }
        });
        jPanel7.add(jTextField_DriverCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 280, 29));

        jLabel_UserName3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName3.setText("Address:");
        jPanel7.add(jLabel_UserName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jTextField_DriverAddress.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverAddress.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverAddressFocusLost(evt);
            }
        });
        jTextField_DriverAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverAddressActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField_DriverAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 280, 29));

        jLabel_UserName4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName4.setText("Gender:");
        jPanel7.add(jLabel_UserName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jTextField_DriverCarNo.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverCarNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverCarNo.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverCarNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverCarNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverCarNoFocusLost(evt);
            }
        });
        jTextField_DriverCarNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverCarNoActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField_DriverCarNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 280, 29));

        jLabel_UserName5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName5.setText("Driver List");
        jPanel7.add(jLabel_UserName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jRadioButton_Male.setBackground(new java.awt.Color(0, 102, 102));
        jRadioButton_Male.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jRadioButton_Male.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_Male.setText(" Male");
        jPanel7.add(jRadioButton_Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 110, -1));

        jRadioButton_Female.setBackground(new java.awt.Color(0, 102, 102));
        jRadioButton_Female.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jRadioButton_Female.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton_Female.setText(" Female");
        jRadioButton_Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_FemaleActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton_Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 140, -1));

        jLabel_UserName6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName6.setText("Image:");
        jPanel7.add(jLabel_UserName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jButton_Img.setBackground(new java.awt.Color(204, 204, 255));
        jButton_Img.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        jButton_Img.setForeground(new java.awt.Color(204, 204, 204));
        jButton_Img.setText("Browse");
        jButton_Img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImgActionPerformed(evt);
            }
        });
        jPanel7.add(jButton_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 280, -1));

        jLabel_ImgPath.setForeground(new java.awt.Color(153, 153, 153));
        jLabel_ImgPath.setText("             Preview");
        jPanel7.add(jLabel_ImgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 140, 130));

        jTable_Drivers.setAutoCreateRowSorter(true);
        jTable_Drivers.setBackground(new java.awt.Color(51, 51, 51));
        jTable_Drivers.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jTable_Drivers.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Drivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Cell", "Address", "Car", "Gender"
            }
        ));
        jTable_Drivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DriversMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Drivers);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 404, 200));

        jPanel6.setBackground(new java.awt.Color(102, 102, 0));

        jButton_AddDriver.setBackground(new java.awt.Color(0, 84, 144));
        jButton_AddDriver.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_AddDriver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_AddDriver.setText("Add Driver");
        jButton_AddDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddDriverActionPerformed(evt);
            }
        });

        jButton_UpdateDriver.setBackground(new java.awt.Color(0, 84, 144));
        jButton_UpdateDriver.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_UpdateDriver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UpdateDriver.setText("Update Driver");
        jButton_UpdateDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateDriverActionPerformed(evt);
            }
        });

        jButton_RemoveDriver.setBackground(new java.awt.Color(0, 84, 144));
        jButton_RemoveDriver.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_RemoveDriver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RemoveDriver.setText("Remove Driver");
        jButton_RemoveDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveDriverActionPerformed(evt);
            }
        });

        jButton_Clear.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Clear.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Clear.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Clear.setText("Clear");
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jButton_UpdateDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_RemoveDriver)
                .addGap(46, 46, 46)
                .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_UpdateDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_RemoveDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 900, 70));

        jLabel_UserName7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_UserName7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UserName7.setText("Car No:");
        jPanel7.add(jLabel_UserName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 900, 460));

        jLabel_ALLR1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setText("Developed  by Ahmed");
        jPanel2.add(jLabel_ALLR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 660, 120, 23));

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton_ShowStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatisticsMouseEntered
        jButton_ShowStatistics.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_ShowStatisticsMouseEntered

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

    private void jTable_DriversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DriversMouseClicked
        int i = jTable_Drivers.getSelectedRow();
        TableModel model = jTable_Drivers.getModel();
        jTextField_DriverID.setText(model.getValueAt(i, 0).toString());
        jTextField_DriverName.setText(model.getValueAt(i, 1).toString());
        jTextField_DriverCell.setText(model.getValueAt(i, 2).toString());
        jTextField_DriverAddress.setText(model.getValueAt(i, 3).toString());
        jTextField_DriverCarNo.setText(model.getValueAt(i, 4).toString());
        String gender = model.getValueAt(i, 5).toString();
        if (gender.equals("Male")) {
            jRadioButton_Male.setSelected(true);
        } else {
            jRadioButton_Female.setSelected(true);
        }
    }//GEN-LAST:event_jTable_DriversMouseClicked

    private void jButton_ImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImgActionPerformed

        String path = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter extension = new FileNameExtensionFilter("*.Images", "jpg", "png", "jpeg");
        chooser.addChoosableFileFilter(extension);
        chooser.addChoosableFileFilter(extension);
        int filestate = chooser.showSaveDialog(null);

        if (filestate == JFileChooser.APPROVE_OPTION) {

            File selectedImage = chooser.getSelectedFile();
            path = selectedImage.getAbsolutePath();
            jLabel_ImgPath.setIcon(ResizeImage(path));
            //jLabel_ImgPath.setText(path);

            image_path = path;
        } else if (filestate == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_jButton_ImgActionPerformed

    private void jRadioButton_FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_FemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_FemaleActionPerformed

    private void jTextField_DriverCarNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverCarNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCarNoActionPerformed

    private void jTextField_DriverCarNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverCarNoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCarNoFocusLost

    private void jTextField_DriverCarNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverCarNoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCarNoFocusGained

    private void jTextField_DriverAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverAddressActionPerformed

    private void jTextField_DriverAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverAddressFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverAddressFocusLost

    private void jTextField_DriverAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverAddressFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverAddressFocusGained

    private void jTextField_DriverCellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DriverCellKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_DriverCellKeyTyped

    private void jTextField_DriverCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCellActionPerformed

    private void jTextField_DriverCellFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverCellFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCellFocusLost

    private void jTextField_DriverCellFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverCellFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverCellFocusGained

    private void jTextField_DriverNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverNameActionPerformed

    private void jTextField_DriverNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverNameFocusLost

    private void jTextField_DriverNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverNameFocusGained

    private void jTextField_DriverIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverIDActionPerformed

    private void jTextField_DriverIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverIDFocusLost

        if (jTextField_DriverID.getText().trim().equals("")
                || jTextField_DriverID.getText().trim().toLowerCase().equals("driverid....")) {
            jTextField_DriverID.setText("driverid....");
            jTextField_DriverID.setForeground(new Color(153, 153, 153));
        }

        jLabel_UserName.setBorder(null);
    }//GEN-LAST:event_jTextField_DriverIDFocusLost

    private void jTextField_DriverIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverIDFocusGained

        if (jTextField_DriverID.getText().trim().toLowerCase().equals("driverid....")) {
            jTextField_DriverID.setText("");
            jTextField_DriverID.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green);
            jLabel_UserName.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_DriverIDFocusGained

    private void jButton_AddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddDriverActionPerformed
        String id = jTextField_DriverID.getText();
        String name = jTextField_DriverName.getText();
        String cell = jTextField_DriverCell.getText();
        String address = jTextField_DriverAddress.getText();
        String carno = jTextField_DriverAddress.getText();
        String gender = "Male";

        if (jRadioButton_Female.isSelected()) {
            gender = "Female";
        }

        if (verifyFields()) {

            //if (!checkDriverID(id)) {
            PreparedStatement ps;
            ResultSet rs;
            String registerDriverQuery = "INSERT INTO drivers(id, name, cell, address, carno, gender, image) VALUES (?,?,?,?,?,?,?)";

            try {

                ps = DBConnection.getConnection().prepareStatement(registerDriverQuery);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, cell);
                ps.setString(4, address);
                ps.setString(5, carno);
                ps.setString(6, gender);

                try {

                    // save the image as blob in the database
                    if (image_path != null) {

                        InputStream image = new FileInputStream(new File(image_path));
                        ps.setBlob(7, image);

                    } else {
                        ps.setNull(7, java.sql.Types.BLOB);
                    }

                    if (ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "New Driver Account Has Been Created");
                        DefaultTableModel tblModel = (DefaultTableModel) jTable_Drivers.getModel();
                        tblModel.setRowCount(0);
                        ShowDriver();
                        Clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton_AddDriverActionPerformed

    private void jButton_UpdateDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateDriverActionPerformed

        String gender = "Male";

        if (jRadioButton_Female.isSelected()) {
            gender = "Female";
        }
        PreparedStatement ps;
        ResultSet rs;
        int row = jTable_Drivers.getSelectedRow();
        String value = (jTable_Drivers.getModel().getValueAt(row, 0).toString());
        String updateDriverQuery = "UPDATE drivers SET id= ?,name=?,cell=?,address=?,carno=?,gender=?,image=? WHERE id='"+jTextField_DriverID.getText()+"' " ;

        try {
            ps = DBConnection.getConnection().prepareStatement(updateDriverQuery);
            ps.setString(1, jTextField_DriverID.getText());
            ps.setString(2, jTextField_DriverName.getText());
            ps.setString(3, jTextField_DriverCell.getText());
            ps.setString(4, jTextField_DriverAddress.getText());
            ps.setString(5, jTextField_DriverCarNo.getText());
            ps.setString(6, gender);

            try {

                if (image_path != null) {

                    InputStream image = new FileInputStream(new File(image_path));
                    ps.setBlob(7, image);

                } else {
                    ps.setNull(7, java.sql.Types.BLOB);
                }
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Driver Updated");
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_Drivers.getModel();
                    tblModel.setRowCount(0);
                    ShowDriver();
                    jTextField_DriverID.setText("");
                    jTextField_DriverName.setText("");
                    jTextField_DriverCell.setText("");
                    jTextField_DriverAddress.setText("");
                    jTextField_DriverCarNo.setText("");
                    jRadioButton_Female.setText("");
                    jRadioButton_Male.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_UpdateDriverActionPerformed

    private void jButton_RemoveDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveDriverActionPerformed
            PreparedStatement ps;
            ResultSet rs;
            int row = jTable_Drivers.getSelectedRow();
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record", "Warning", JOptionPane.YES_NO_OPTION);
            String tid = jTextField_DriverID.getText();
        if (dialogResult == JOptionPane.YES_OPTION) {

            String updateTripQuery = "DELETE FROM drivers WHERE id='" + tid + "'";

            try {
                ps = DBConnection.getConnection().prepareStatement(updateTripQuery);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Driver has been removed successfully!");
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_Drivers.getModel();
                    tblModel.setRowCount(0);
                    ShowDriver();
                    Clear();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
            }}
    }//GEN-LAST:event_jButton_RemoveDriverActionPerformed

    private void jButton_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HomeActionPerformed
        MyDispatcher form = new MyDispatcher();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_HomeActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        Clear();
    }//GEN-LAST:event_jButton_ClearActionPerformed

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
            java.util.logging.Logger.getLogger(AddDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AddDriver().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddDriver;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Home;
    private javax.swing.JButton jButton_Img;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_RemoveDriver;
    private javax.swing.JButton jButton_SetNewTrip;
    private javax.swing.JButton jButton_ShowStatistics;
    private javax.swing.JButton jButton_TrackTrip;
    private javax.swing.JButton jButton_UpdateDriver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_ALLR;
    private javax.swing.JLabel jLabel_ALLR1;
    private javax.swing.JLabel jLabel_Date1;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_ImgPath;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_UserName;
    private javax.swing.JLabel jLabel_UserName1;
    private javax.swing.JLabel jLabel_UserName2;
    private javax.swing.JLabel jLabel_UserName3;
    private javax.swing.JLabel jLabel_UserName4;
    private javax.swing.JLabel jLabel_UserName5;
    private javax.swing.JLabel jLabel_UserName6;
    private javax.swing.JLabel jLabel_UserName7;
    private javax.swing.JLabel jLabel_datetoday;
    private javax.swing.JLabel jLabel_timenow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_bar;
    private javax.swing.JRadioButton jRadioButton_Female;
    private javax.swing.JRadioButton jRadioButton_Male;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Drivers;
    private javax.swing.JTextField jTextField_DriverAddress;
    private javax.swing.JTextField jTextField_DriverCarNo;
    private javax.swing.JTextField jTextField_DriverCell;
    private javax.swing.JTextField jTextField_DriverID;
    private javax.swing.JTextField jTextField_DriverName;
    // End of variables declaration//GEN-END:variables
}
