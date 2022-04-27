/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ahmed
 */

public class AllStat extends javax.swing.JFrame {

    /**
     * Creates new form CabBook
     */
    ArrayList<String> driver = new ArrayList<String>(10);

    public AllStat() {
        initComponents();
        this.setLocationRelativeTo(null);
        showDate();
        showTime();
        Border jLabel_Title_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        Border jLabel_bar = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
        tblColor();
        this.setResizable(false);
        DriverList(); 
    }
    public void DriverList() {

        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from drivers";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                driver.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void tblColor() {
        jTable_ShowStat.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 13));
        jTable_ShowStat.getTableHeader().setOpaque(true);
        jTable_ShowStat.getTableHeader().setBackground(new Color(250, 198, 195));
        jTable_ShowStat.getTableHeader().setForeground(new Color(132, 94, 255));
        jTable_ShowStat.setRowHeight(20);
        jTable_ShowStatDriver.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 13));
        jTable_ShowStatDriver.getTableHeader().setOpaque(true);
        jTable_ShowStatDriver.getTableHeader().setBackground(new Color(250, 198, 195));
        jTable_ShowStatDriver.getTableHeader().setForeground(new Color(132, 94, 255));
        jTable_ShowStatDriver.setRowHeight(20);
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

    public void driverStat10() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(9);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void driverStat9() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(8);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void driverStat8() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(7);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void driverStat7() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(6);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void driverStat6() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(5);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void driverStat5() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(4);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void driverStat4() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(3);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void driverStat3() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(2);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void driverStat2() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(1);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void driverStat1() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String did = driver.get(0);

        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select SUM(DISTINCT fare) as fare,COUNT(did) as did from trips where "
                + "date = '" + d + "' AND did = '" + did + "' ";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fare = rs.getString("fare");
                String count = rs.getString("did");
                int c = Integer.parseInt(count);
                String id = rs.getString("did");
                if (c != 0) {

                    DecimalFormat df = new DecimalFormat("0.00");
                    Double taking = ((Double.parseDouble(fare)) * 0.20);
                    String taking1 = df.format(taking);
                    String tblData[] = {did, fare, taking1, count};

                    tblModel.addRow(tblData);

                } else {
                    String t = "0.00";
                    String tt = "0.00";
                    String jd = "0";
                    String tbData[] = {did, t, tt, jd};
                    tblModel.addRow(tbData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getSum() {

        double sum = 0;
        for (int i = 0; i < jTable_ShowStat.getRowCount(); i++) {

            sum = sum + Double.parseDouble(jTable_ShowStat.getValueAt(i, 2).toString());
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String sum1 = df.format(sum);
        jTextField_TotalFare.setText("£" + sum1);
        double dpay = (double) (sum * 0.20);
        String dpayy = df.format(dpay);
        jTextField_TotalDriverPay.setText("£" + dpayy);
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
        jButton_AddDriver = new javax.swing.JButton();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ShowStat = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jDatePicker = new com.toedter.calendar.JDateChooser();
        jLabel_Date = new javax.swing.JLabel();
        jButton_ShowStat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel_Date3 = new javax.swing.JLabel();
        jTextField_TotalFare = new javax.swing.JTextField();
        jTextField_TotalTrip = new javax.swing.JTextField();
        jLabel_Date4 = new javax.swing.JLabel();
        jLabel_Date5 = new javax.swing.JLabel();
        jTextField_TotalDriverPay = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_ShowStatDriver = new javax.swing.JTable();
        jButton_Save = new javax.swing.JButton();
        jButton_Print = new javax.swing.JButton();
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
                            .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_barLayout.createSequentialGroup()
                        .addComponent(jButton_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_SetNewTrip, jButton_TrackTrip});

        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton_SetNewTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_AddDriver)
                .addGap(35, 35, 35)
                .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_SetNewTrip, jButton_TrackTrip});

        jPanel2.add(jPanel_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 142, 236, 520));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Statistics Pannel");
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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 900, 40));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jTable_ShowStat.setAutoCreateRowSorter(true);
        jTable_ShowStat.setBackground(new java.awt.Color(123, 29, 47));
        jTable_ShowStat.setFont(new java.awt.Font("Century", 0, 20)); // NOI18N
        jTable_ShowStat.setForeground(new java.awt.Color(255, 255, 255));
        jTable_ShowStat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trip ID", "Driver ID", "Fare (£)"
            }
        ));
        jTable_ShowStat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ShowStatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ShowStat);

        jPanel6.setBackground(new java.awt.Color(63, 46, 104));

        jDatePicker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_Date.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Date.setText("Select Date");

        jButton_ShowStat.setBackground(new java.awt.Color(0, 84, 144));
        jButton_ShowStat.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_ShowStat.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ShowStat.setText("Show Stat");
        jButton_ShowStat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_ShowStat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ShowStatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ShowStatMouseExited(evt);
            }
        });
        jButton_ShowStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowStatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ShowStat, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Date)
                    .addComponent(jButton_ShowStat))
                .addGap(6, 6, 6))
        );

        jPanel7.setBackground(new java.awt.Color(63, 46, 104));

        jLabel_Date3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Date3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel_Date3.setText("Total for the Day");

        jTextField_TotalFare.setBackground(new java.awt.Color(123, 29, 47));
        jTextField_TotalFare.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField_TotalFare.setForeground(new java.awt.Color(255, 255, 255));

        jTextField_TotalTrip.setBackground(new java.awt.Color(123, 29, 47));
        jTextField_TotalTrip.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField_TotalTrip.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_Date4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Date4.setForeground(new java.awt.Color(153, 153, 0));
        jLabel_Date4.setText("Total Jobs of the Day");

        jLabel_Date5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Date5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel_Date5.setText("Expected % for the Day");

        jTextField_TotalDriverPay.setBackground(new java.awt.Color(123, 29, 47));
        jTextField_TotalDriverPay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField_TotalDriverPay.setForeground(new java.awt.Color(255, 255, 255));

        jTable_ShowStatDriver.setAutoCreateRowSorter(true);
        jTable_ShowStatDriver.setBackground(new java.awt.Color(123, 29, 47));
        jTable_ShowStatDriver.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jTable_ShowStatDriver.setForeground(new java.awt.Color(255, 255, 255));
        jTable_ShowStatDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver ID", "Total Takings", "Drivers Percentage", "Job Done Today"
            }
        ));
        jTable_ShowStatDriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ShowStatDriverMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_ShowStatDriver);

        jButton_Save.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Save.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Save.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Save.setText("Export Data");
        jButton_Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_SaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_SaveMouseExited(evt);
            }
        });
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });

        jButton_Print.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Print.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Print.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Print.setText("Print");
        jButton_Print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_PrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_PrintMouseExited(evt);
            }
        });
        jButton_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Date3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_TotalFare, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Date4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_TotalTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_TotalDriverPay, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jLabel_Date5))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Save)
                .addGap(20, 20, 20)
                .addComponent(jButton_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Date4)
                        .addComponent(jLabel_Date5))
                    .addComponent(jLabel_Date3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_TotalFare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TotalTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TotalDriverPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Save)
                    .addComponent(jButton_Print))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 900, 480));

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

    private void jButton_AddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddDriverActionPerformed
        AddDriver form = new AddDriver();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_AddDriverActionPerformed

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

    private void jTable_ShowStatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ShowStatMouseClicked

    }//GEN-LAST:event_jTable_ShowStatMouseClicked

    private void jButton_ShowStatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatMouseEntered
        jButton_ShowStat.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_ShowStatMouseEntered

    private void jButton_ShowStatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatMouseExited
        jButton_ShowStat.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_ShowStatMouseExited

    private void jButton_ShowStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowStatActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStat.getModel();
        DefaultTableModel tbModel = (DefaultTableModel) jTable_ShowStatDriver.getModel();
        tblModel.setRowCount(0);
        tbModel.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        String TripQuery = "select * from trips where date = '" + d + "'";

        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            while (rs.next()) {

                String tid = rs.getString("tripid");
                String date = rs.getString("did");
                String fare = rs.getString("fare");

                String tbData[] = {tid, date, fare};

                //DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowStat.getModel();
                tblModel.addRow(tbData);
            }
            getSum();
            driverStat1();
            driverStat2();
            driverStat3();
            driverStat4();
            driverStat5();
            driverStat6();
            driverStat7();
            driverStat8();
            driverStat9();
            driverStat10();
            jTextField_TotalTrip.setText(Integer.toString(jTable_ShowStat.getRowCount()));
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_ShowStatActionPerformed

    private void jTable_ShowStatDriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ShowStatDriverMouseClicked
    }//GEN-LAST:event_jTable_ShowStatDriverMouseClicked

    private void jButton_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HomeActionPerformed
        MyDispatcher form = new MyDispatcher();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_HomeActionPerformed

    private void jButton_SaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveMouseEntered

    private void jButton_SaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveMouseExited

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        try {
            File file = new File(".\\Saved Data\\AllDriversStat.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw)) {
                for (int i = 0; i < jTable_ShowStatDriver.getRowCount(); i++) {
                    for (int j = 0; j < jTable_ShowStatDriver.getColumnCount(); j++) {
                        bw.write(jTable_ShowStatDriver.getModel().getValueAt(i, j) + " ");
                    }
                    bw.write("\n_______________________________________\n");
                }
            }
            JOptionPane.showMessageDialog(null, "Data Exported");
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Data Export Failed. Please check the file save path.");
        }
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jButton_PrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PrintMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_PrintMouseEntered

    private void jButton_PrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PrintMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_PrintMouseExited

    private void jButton_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PrintActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        MessageFormat header = new MessageFormat("Driver Trip Report of " + d + "");
        try {
            jTable_ShowStatDriver.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not print!");
        }
    }//GEN-LAST:event_jButton_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(AllStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AllStat().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddDriver;
    private javax.swing.JButton jButton_Home;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_Print;
    private javax.swing.JButton jButton_Save;
    private javax.swing.JButton jButton_SetNewTrip;
    private javax.swing.JButton jButton_ShowStat;
    private javax.swing.JButton jButton_TrackTrip;
    private com.toedter.calendar.JDateChooser jDatePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_ALLR;
    private javax.swing.JLabel jLabel_ALLR1;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_Date1;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_Date3;
    private javax.swing.JLabel jLabel_Date4;
    private javax.swing.JLabel jLabel_Date5;
    private javax.swing.JLabel jLabel_Title;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_ShowStat;
    private javax.swing.JTable jTable_ShowStatDriver;
    private javax.swing.JTextField jTextField_TotalDriverPay;
    private javax.swing.JTextField jTextField_TotalFare;
    private javax.swing.JTextField jTextField_TotalTrip;
    // End of variables declaration//GEN-END:variables
}
