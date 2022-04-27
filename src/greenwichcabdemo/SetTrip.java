package greenwichcabdemo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ahmed
 */
public class SetTrip extends javax.swing.JFrame {
    ArrayList<String> loc = new ArrayList<String>();
    int tripID;
    Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
    Border warning = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED);
    public SetTrip() {
        initComponents();
        this.setLocationRelativeTo(null);
        ShowTrip();
        searchList();
        DriverDropDown();
        showDate();
        showTime();
        tblColor();
        this.setResizable(false);
        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tblModel);
        
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        trs.setSortKeys(sortKeys);
        trs.sort();
        jTable_ShowTrip.setRowSorter(trs);
         jTable_ShowTrip.setAutoCreateRowSorter(true);
        Border field_border = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.darkGray);
        jTextField_Hour.setBorder(field_border);
        jTextField_Minute.setBorder(field_border);
        jTextField_Pickup.setBorder(field_border);
        jTextField_Destination.setBorder(field_border);
        jTextField_PassengerName.setBorder(field_border);
        jTextField_PassengerCell.setBorder(field_border);
        jTextField_Tips.setBorder(field_border);
        jTextField_TotalFare.setBorder(field_border);
        jTextField_DriverPay.setBorder(field_border);
    }

    public void search(String str) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tblModel);
        jTable_ShowTrip.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));

    }

    public void tblColor() {
        jTable_ShowTrip.getTableHeader().setFont(new Font("tahoma", Font.BOLD, 13));
        jTable_ShowTrip.getTableHeader().setOpaque(true);
        jTable_ShowTrip.getTableHeader().setBackground(new Color(0, 0, 0));
        jTable_ShowTrip.getTableHeader().setForeground(new Color(80, 0, 171));
        jTable_ShowTrip.setRowHeight(20);
    }

    public void searchList() {
        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from trips";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                loc.add(rs.getString("ppoint"));
                loc.add(rs.getString("dpoint"));
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        
        }

    }
public void autoComplete1(String txt){
    String complete = "";
    int start = txt.length();
    int last = txt.length();
    int a;
    for(a=0;a<loc.size();a++){
        if(loc.get(a).toString().startsWith(txt)){
            complete = loc.get(a).toString();
            last = complete.length();
            break;
        }
    }
    if(last>start){
        jTextField_Pickup.setText(complete);
        jTextField_Pickup.setCaretPosition(last);
        jTextField_Pickup.moveCaretPosition(start);
    }
}
public void autoComplete2(String txt){
    String complete = "";
    int start = txt.length();
    int last = txt.length();
    int a;
    for(a=0;a<loc.size();a++){
        if(loc.get(a).toString().startsWith(txt)){
            complete = loc.get(a).toString();
            last = complete.length();
            break;
        }
    }
    if(last>start){
        jTextField_Destination.setText(complete);
        jTextField_Destination.setCaretPosition(last);
        jTextField_Destination.moveCaretPosition(start);
    }
}
    public void showTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.Date date = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
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
        SimpleDateFormat ss = new SimpleDateFormat("HH");
        SimpleDateFormat sss = new SimpleDateFormat("mm");
        String hh = ss.format(date);
        String mm = sss.format(date);
        jTextField_Hour.setText(ss.format(date));
        jTextField_Minute.setText(sss.format(date));
        jLabel_datetoday.setText(dd);
        ((JTextField) jDatePicker.getDateEditor().getUiComponent()).setText(dd);
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

    public void ShowTrip() {

        PreparedStatement ps;
        ResultSet rs;
        String query = "select * from trips";
        try {
            ps = DBConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tid = rs.getString("tripid");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String did = rs.getString("did");
                String pick = rs.getString("ppoint");
                String dpoint = rs.getString("dpoint");
                String pesname = rs.getString("pname");
                String pcell = rs.getString("pcell");
                String pmethod = rs.getString("pmethod");
                String tips = rs.getString("tips");
                String fare = rs.getString("fare");
                String driverpay = rs.getString("driverpay");
                String status = rs.getString("status");
                //String img = rs.getString("image");

                String tbData[] = {tid, date, time, did, pick, dpoint, pesname, pcell, pmethod, tips, fare, driverpay, status};

                DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();

                tblModel.addRow(tbData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TripID(String TripQuery) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = DBConnection.getConnection().prepareStatement(TripQuery);
            rs = ps.executeQuery();
            if (rs.next()) {
                tripID = Integer.parseInt(rs.getString(1));
                //System.out.println(tripID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ClearField() {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat ss = new SimpleDateFormat("HH");
        SimpleDateFormat sss = new SimpleDateFormat("mm");
        jTextField_Hour.setText(ss.format(date));
        jTextField_Minute.setText(sss.format(date));
//        jTextField_Hour.setText("hour..");
//        jTextField_Minute.setText("min..");
        jTextField_Pickup.setText("pickuppoint..");
        jTextField_Destination.setText("destination..");
        jTextField_PassengerName.setText("passengername..");
        jTextField_PassengerCell.setText("pessengercell..");
        jTextField_Tips.setText("0.00");
        jTextField_TotalFare.setText("0.00");
        jTextField_DriverPay.setText("£0.00");
        jComboBox_DriverID.setSelectedIndex(0);
        jComboBox_Payment.setSelectedIndex(0);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String dd = format.format(date);
        ((JTextField) jDatePicker.getDateEditor().getUiComponent()).setText(dd);
        jTextField_Search.setText("searchtrip...");

    }

    public boolean verifyFields() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String pl = jTextField_Pickup.getText();
        String des = jTextField_Destination.getText();
        String pn = jTextField_PassengerName.getText();
        String pc = jTextField_PassengerCell.getText();
        String tips = jTextField_Tips.getText();
        String fare = jTextField_TotalFare.getText();
        String dp = jTextField_DriverPay.getText();
        String did = jComboBox_DriverID.getSelectedItem().toString();
        String pm = jComboBox_Payment.getSelectedItem().toString();

//        if (jTextField_Hour.getText().trim().equals("hour..") || jTextField_Hour.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Hour field is empty!");
//            jTextField_Hour.setBorder(warning);
//            return false;
//        }
//        if (jTextField_Minute.getText().trim().equals("min..") || jTextField_Minute.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Minute field is empty!");
//            jTextField_Minute.setBorder(warning);
//            return false;
//        }
        if (Integer.valueOf(jTextField_Hour.getText()) > 23) {
            JOptionPane.showMessageDialog(null, "Hour should be between 00 to 23!");
            jTextField_Hour.setBorder(warning);
            return false;
        }
        if (Integer.valueOf(jTextField_Minute.getText()) > 59) {
            JOptionPane.showMessageDialog(null, "Minute should be between 00 to 59!");
            jTextField_Minute.setBorder(warning);
            return false;
        }
        if (pl.trim().equals("pickuppoint..") || pl.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a pickup point!");
            jTextField_Pickup.setBorder(warning);
            return false;
        }
        if (des.trim().equals("destination..") || des.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a destination point!!");
            jTextField_Destination.setBorder(warning);
            return false;
        }
        if (did.trim().equals("Select Driver")) {
            JOptionPane.showMessageDialog(null, "Please select a driver!");
            jLabel_DriverID.setBorder(warning);
            jComboBox_DriverID.setBorder(warning);
            return false;
        }
        if (pn.trim().equals("passengername..") || pn.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Passenger name field is empty!");
            jTextField_PassengerName.setBorder(warning);
            return false;
        }
        if (fare.trim().equals("0.00") || fare.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter total fare amount!");
            jTextField_TotalFare.setBorder(warning);
            return false;
        }
        if (dp.trim().equals("0.00") || dp.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please click on the driver pay field!");
            jTextField_DriverPay.setBorder(warning);
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_Title = new javax.swing.JLabel();
        jPanel_bar = new javax.swing.JPanel();
        jButton_Home = new javax.swing.JButton();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel_Date = new javax.swing.JLabel();
        jDatePicker = new com.toedter.calendar.JDateChooser();
        jLabel_hr = new javax.swing.JLabel();
        jTextField_Hour = new javax.swing.JTextField();
        jTextField_Minute = new javax.swing.JTextField();
        jLabel_pick = new javax.swing.JLabel();
        jTextField_Pickup = new javax.swing.JTextField();
        jLabel_destination = new javax.swing.JLabel();
        jTextField_Destination = new javax.swing.JTextField();
        jLabel_DriverID = new javax.swing.JLabel();
        jComboBox_DriverID = new javax.swing.JComboBox<>();
        jLabel_Payment = new javax.swing.JLabel();
        jComboBox_Payment = new javax.swing.JComboBox<>();
        jLabel_Pname = new javax.swing.JLabel();
        jTextField_PassengerName = new javax.swing.JTextField();
        jLabel_Pcell = new javax.swing.JLabel();
        jTextField_PassengerCell = new javax.swing.JTextField();
        jLabel_Fare = new javax.swing.JLabel();
        jTextField_TotalFare = new javax.swing.JTextField();
        jLabel_tips = new javax.swing.JLabel();
        jTextField_Tips = new javax.swing.JTextField();
        jLabel_Dpay = new javax.swing.JLabel();
        jTextField_DriverPay = new javax.swing.JTextField();
        jButton_SaveTrip = new javax.swing.JButton();
        jButton_UpdateTrip = new javax.swing.JButton();
        jButton_DeleteTrip = new javax.swing.JButton();
        jButton_TripClear = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ShowTrip = new javax.swing.JTable();
        jButton_Save = new javax.swing.JButton();
        jButton_Print = new javax.swing.JButton();
        jTextField_Search = new javax.swing.JTextField();
        jLabel_ALLR1 = new javax.swing.JLabel();
        jLabel_ALLR = new javax.swing.JLabel();

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
        jPanel3.add(jLabel_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 940, 110));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        jPanel_bar.setBackground(new java.awt.Color(0, 0, 102));

        jButton_Home.setBackground(new java.awt.Color(0, 84, 144));
        jButton_Home.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_Home.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/favicon-48x48.png"))); // NOI18N
        jButton_Home.setText("    Home");
        jButton_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_HomeMouseExited(evt);
            }
        });
        jButton_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HomeActionPerformed(evt);
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
                    .addComponent(jButton_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_AddDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_TrackTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(129, 129, 129))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_ShowStatistics, jButton_TrackTrip});

        jPanel_barLayout.setVerticalGroup(
            jPanel_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton_ShowStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton_AddDriver)
                .addGap(33, 33, 33)
                .addComponent(jButton_TrackTrip)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel_barLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_AddDriver, jButton_Home, jButton_ShowStatistics, jButton_TrackTrip});

        jPanel2.add(jPanel_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 236, 550));

        jPanel4.setBackground(new java.awt.Color(51, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Trip Pannel");
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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 900, 50));

        jPanel5.setBackground(new java.awt.Color(102, 102, 0));

        jPanel6.setBackground(new java.awt.Color(63, 46, 104));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(908, 450));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Date.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_Date.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Date.setText("Date");
        jPanel6.add(jLabel_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 21));

        jDatePicker.setBackground(new java.awt.Color(255, 255, 255));
        jDatePicker.setDateFormatString("dd.MM.yy");
        jDatePicker.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel6.add(jDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 282, 30));

        jLabel_hr.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_hr.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hr.setText("Time");
        jPanel6.add(jLabel_hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jTextField_Hour.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Hour.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Hour.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Hour.setText("hour..");
        jTextField_Hour.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_HourFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_HourFocusLost(evt);
            }
        });
        jTextField_Hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HourActionPerformed(evt);
            }
        });
        jTextField_Hour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_HourKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_Hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 137, 29));

        jTextField_Minute.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Minute.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Minute.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Minute.setText("min..");
        jTextField_Minute.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_MinuteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_MinuteFocusLost(evt);
            }
        });
        jTextField_Minute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MinuteActionPerformed(evt);
            }
        });
        jTextField_Minute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_MinuteKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_Minute, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 127, 29));

        jLabel_pick.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_pick.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pick.setText("Pickup Point");
        jPanel6.add(jLabel_pick, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTextField_Pickup.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Pickup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Pickup.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Pickup.setText("pickuppoint..");
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
        jTextField_Pickup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_PickupKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_PickupKeyReleased(evt);
            }
        });
        jPanel6.add(jTextField_Pickup, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 281, 30));

        jLabel_destination.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_destination.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_destination.setText("Destination");
        jPanel6.add(jLabel_destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTextField_Destination.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Destination.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Destination.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Destination.setText("destination..");
        jTextField_Destination.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DestinationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DestinationFocusLost(evt);
            }
        });
        jTextField_Destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DestinationActionPerformed(evt);
            }
        });
        jTextField_Destination.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_DestinationKeyPressed(evt);
            }
        });
        jPanel6.add(jTextField_Destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 281, -1));

        jLabel_DriverID.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_DriverID.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_DriverID.setText("Driver ID");
        jPanel6.add(jLabel_DriverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 40));

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
        jPanel6.add(jComboBox_DriverID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 281, -1));

        jLabel_Payment.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_Payment.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Payment.setText("Payment");
        jPanel6.add(jLabel_Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, 40));

        jComboBox_Payment.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox_Payment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox_Payment.setMaximumRowCount(10);
        jComboBox_Payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Barclays", "Monzo", "HSBC" }));
        jComboBox_Payment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox_PaymentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_PaymentFocusLost(evt);
            }
        });
        jPanel6.add(jComboBox_Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 281, -1));

        jLabel_Pname.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_Pname.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Pname.setText("Passenger Name");
        jPanel6.add(jLabel_Pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 36));

        jTextField_PassengerName.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_PassengerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_PassengerName.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_PassengerName.setText("passengername..");
        jTextField_PassengerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_PassengerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_PassengerNameFocusLost(evt);
            }
        });
        jTextField_PassengerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PassengerNameActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField_PassengerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 214, 38));

        jLabel_Pcell.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_Pcell.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Pcell.setText("Passenger's Cell");
        jPanel6.add(jLabel_Pcell, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jTextField_PassengerCell.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_PassengerCell.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_PassengerCell.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_PassengerCell.setText("pessengercell..");
        jTextField_PassengerCell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_PassengerCellFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_PassengerCellFocusLost(evt);
            }
        });
        jTextField_PassengerCell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PassengerCellActionPerformed(evt);
            }
        });
        jTextField_PassengerCell.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PassengerCellKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_PassengerCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 214, 39));

        jLabel_Fare.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_Fare.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Fare.setText("Total Fare(£)");
        jPanel6.add(jLabel_Fare, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, 32));

        jTextField_TotalFare.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_TotalFare.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_TotalFare.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_TotalFare.setText("0.00");
        jTextField_TotalFare.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_TotalFareFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_TotalFareFocusLost(evt);
            }
        });
        jTextField_TotalFare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TotalFareActionPerformed(evt);
            }
        });
        jTextField_TotalFare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TotalFareKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_TotalFare, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 214, 34));

        jLabel_tips.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel_tips.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tips.setText("Tips(If Any)(£)");
        jPanel6.add(jLabel_tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 32));

        jTextField_Tips.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Tips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Tips.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Tips.setText("0.00");
        jTextField_Tips.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_TipsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_TipsFocusLost(evt);
            }
        });
        jTextField_Tips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TipsActionPerformed(evt);
            }
        });
        jTextField_Tips.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TipsKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 214, 33));

        jLabel_Dpay.setFont(new java.awt.Font("Century", 1, 22)); // NOI18N
        jLabel_Dpay.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Dpay.setText("Driver's Income(£)");
        jPanel6.add(jLabel_Dpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 210, -1));

        jTextField_DriverPay.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_DriverPay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_DriverPay.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_DriverPay.setText("0.00");
        jTextField_DriverPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_DriverPayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DriverPayFocusLost(evt);
            }
        });
        jTextField_DriverPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DriverPayActionPerformed(evt);
            }
        });
        jTextField_DriverPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_DriverPayKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DriverPayKeyTyped(evt);
            }
        });
        jPanel6.add(jTextField_DriverPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 214, 29));

        jButton_SaveTrip.setBackground(new java.awt.Color(0, 84, 144));
        jButton_SaveTrip.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_SaveTrip.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SaveTrip.setText("Set Trip");
        jButton_SaveTrip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_SaveTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_SaveTripMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_SaveTripMouseExited(evt);
            }
        });
        jButton_SaveTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveTripActionPerformed(evt);
            }
        });
        jButton_SaveTrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton_SaveTripKeyReleased(evt);
            }
        });
        jPanel6.add(jButton_SaveTrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 148, -1));

        jButton_UpdateTrip.setBackground(new java.awt.Color(0, 84, 144));
        jButton_UpdateTrip.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_UpdateTrip.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UpdateTrip.setText("Update");
        jButton_UpdateTrip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_UpdateTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_UpdateTripMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_UpdateTripMouseExited(evt);
            }
        });
        jButton_UpdateTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateTripActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_UpdateTrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 100, -1));

        jButton_DeleteTrip.setBackground(new java.awt.Color(0, 84, 144));
        jButton_DeleteTrip.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_DeleteTrip.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DeleteTrip.setText("Delete");
        jButton_DeleteTrip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_DeleteTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_DeleteTripMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_DeleteTripMouseExited(evt);
            }
        });
        jButton_DeleteTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteTripActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_DeleteTrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 100, -1));

        jButton_TripClear.setBackground(new java.awt.Color(0, 84, 144));
        jButton_TripClear.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton_TripClear.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TripClear.setText("Clear");
        jButton_TripClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_TripClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_TripClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_TripClearMouseExited(evt);
            }
        });
        jButton_TripClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TripClearActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_TripClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 85, -1));

        jPanel7.setBackground(new java.awt.Color(63, 46, 104));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_ShowTrip.setBackground(new java.awt.Color(123, 29, 47));
        jTable_ShowTrip.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        jTable_ShowTrip.setForeground(new java.awt.Color(255, 255, 255));
        jTable_ShowTrip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trip ID", "Date", "Time", "Driver ID", "Pickup Point", "Destination", "Passenger Name", "Passenger Cell", "Payment Method", "Tips", "Total Fare", "Driver Pay", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ShowTrip.setGridColor(java.awt.SystemColor.textHighlight);
        jTable_ShowTrip.setInheritsPopupMenu(true);
        jTable_ShowTrip.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_ShowTrip.setRowHeight(20);
        jTable_ShowTrip.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable_ShowTrip.setShowVerticalLines(false);
        jTable_ShowTrip.getTableHeader().setReorderingAllowed(false);
        jTable_ShowTrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ShowTripMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_ShowTrip);
        if (jTable_ShowTrip.getColumnModel().getColumnCount() > 0) {
            jTable_ShowTrip.getColumnModel().getColumn(0).setMinWidth(100);
            jTable_ShowTrip.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 140));

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
        jPanel7.add(jButton_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 140, 30));

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
        jPanel7.add(jButton_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 85, 30));

        jTextField_Search.setBackground(new java.awt.Color(204, 255, 255));
        jTextField_Search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField_Search.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_Search.setText("searchtrip...");
        jTextField_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_SearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_SearchFocusLost(evt);
            }
        });
        jTextField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SearchActionPerformed(evt);
            }
        });
        jTextField_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 900, 500));

        jLabel_ALLR1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR1.setText("All rights reserved by ⒸGreenwich Cab Service");
        jPanel2.add(jLabel_ALLR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, 286, 23));

        jLabel_ALLR.setBackground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR.setForeground(new java.awt.Color(204, 255, 204));
        jLabel_ALLR.setText("Developed  by Ahmed");
        jPanel2.add(jLabel_ALLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 670, 120, 23));

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jTextField_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchKeyReleased
        String search = jTextField_Search.getText();
        search(search);
    }//GEN-LAST:event_jTextField_SearchKeyReleased

    private void jTextField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchActionPerformed

    private void jTextField_SearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusLost
        if (jTextField_Search.getText().trim().equals("")
                || jTextField_Search.getText().trim().toLowerCase().equals("searchtrip...")) {
            jTextField_Search.setText("searchtrip...");
            jTextField_Search.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextField_SearchFocusLost

    private void jTextField_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SearchFocusGained
        if (jTextField_Search.getText().trim().toLowerCase().equals("searchtrip...")) {
            jTextField_Search.setText("");
            jTextField_Search.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextField_SearchFocusGained

    private void jButton_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PrintActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        MessageFormat header = new MessageFormat("All Trip Report Till " + d + "");
        try {
            jTable_ShowTrip.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not print!");
        }
    }//GEN-LAST:event_jButton_PrintActionPerformed

    private void jButton_PrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PrintMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_PrintMouseExited

    private void jButton_PrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PrintMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_PrintMouseEntered

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
        try {
            File file = new File(".\\Saved Data\\AllTrip.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw)) {
                for (int i = 0; i < jTable_ShowTrip.getRowCount(); i++) {
                    for (int j = 0; j < jTable_ShowTrip.getColumnCount(); j++) {
                        bw.write(jTable_ShowTrip.getModel().getValueAt(i, j) + " ");
                    }
                    bw.write("\n_______________________________________________________________________________________________\n");
                }
            }
            JOptionPane.showMessageDialog(null, "Data Exported");
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Data Export Failed. Please check the file save path.");
        }
    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jButton_SaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveMouseExited

    private void jButton_SaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveMouseEntered

    private void jTable_ShowTripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ShowTripMouseClicked
        int i = jTable_ShowTrip.getSelectedRow();
        TableModel model = jTable_ShowTrip.getModel();
        jTextField_Search.setText(model.getValueAt(i, 0).toString());
        String date = model.getValueAt(i, 1).toString();
        ((JTextField) jDatePicker.getDateEditor().getUiComponent()).setText(date);
        String hr = model.getValueAt(i, 2).toString();
        jTextField_Hour.setText(hr.substring(0, 2));
        String min = model.getValueAt(i, 2).toString();
        jTextField_Minute.setText(hr.substring(3, 5));
        jComboBox_DriverID.setSelectedItem(model.getValueAt(i, 3).toString());
        jTextField_Pickup.setText(model.getValueAt(i, 4).toString());
        jTextField_Destination.setText(model.getValueAt(i, 5).toString());
        jTextField_PassengerName.setText(model.getValueAt(i, 6).toString());
        jTextField_PassengerCell.setText(model.getValueAt(i, 7).toString());
        jComboBox_Payment.setSelectedItem(model.getValueAt(i, 8).toString());
        jTextField_TotalFare.setText(model.getValueAt(i, 10).toString());
        jTextField_Tips.setText(model.getValueAt(i, 9).toString());
        jTextField_DriverPay.setText(model.getValueAt(i, 11).toString());
    }//GEN-LAST:event_jTable_ShowTripMouseClicked

    private void jButton_UpdateTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateTripActionPerformed
        PreparedStatement ps;
        ResultSet rs;
        String tid = jTextField_Search.getText();
        String thr = jTextField_Hour.getText();
        String tmin = jTextField_Minute.getText();
        String time = thr + ":" + tmin;
        String pl = jTextField_Pickup.getText();
        String des = jTextField_Destination.getText();
        String pn = jTextField_PassengerName.getText();
        String pc = jTextField_PassengerCell.getText();
        String tips = jTextField_Tips.getText();
        String fare = jTextField_TotalFare.getText();
        String dp = jTextField_DriverPay.getText();
        String did = jComboBox_DriverID.getSelectedItem().toString();
        String pm = jComboBox_Payment.getSelectedItem().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());
        String status = "Completed";

        int row = jTable_ShowTrip.getSelectedRow();
        String value = (jTable_ShowTrip.getModel().getValueAt(row, 0).toString());
        //String id = jTextField_Search.getText();
        String updateTripQuery = "UPDATE trips SET tripid = ?,date=?,time=?,did=?,"
                + "ppoint=?,dpoint=?,pname=?,pcell=?,pmethod=?,tips=?, fare=?, "
                + "driverpay=?,status=? WHERE tripid='" + tid + "'";

        try {
            ps = DBConnection.getConnection().prepareStatement(updateTripQuery);
            ps.setString(1, tid);
            ps.setString(2, d);
            ps.setString(3, time);
            ps.setString(4, did);
            ps.setString(5, pl);
            ps.setString(6, des);
            ps.setString(7, pn);
            ps.setString(8, pc);
            ps.setString(9, pm);
            ps.setString(10, tips);
            ps.setString(11, fare);
            ps.setString(12, dp);
            ps.setString(13, status);

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Trip has been updated successfully!");
                DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
                tblModel.setRowCount(0);
                ShowTrip();
                ClearField();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_UpdateTripActionPerformed

    private void jButton_UpdateTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_UpdateTripMouseExited

    }//GEN-LAST:event_jButton_UpdateTripMouseExited

    private void jButton_UpdateTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_UpdateTripMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_UpdateTripMouseEntered

    private void jComboBox_PaymentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_PaymentFocusLost
        jComboBox_Payment.setForeground(new Color(153, 153, 153));
        jLabel_Payment.setBorder(null);
    }//GEN-LAST:event_jComboBox_PaymentFocusLost

    private void jComboBox_PaymentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_PaymentFocusGained
        jComboBox_Payment.setForeground(Color.black);
        jLabel_Payment.setBorder(jLabel_icon);
    }//GEN-LAST:event_jComboBox_PaymentFocusGained

    private void jTextField_TotalFareKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TotalFareKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter only digits!");
        }
    }//GEN-LAST:event_jTextField_TotalFareKeyTyped

    private void jTextField_TotalFareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TotalFareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TotalFareActionPerformed

    private void jTextField_TotalFareFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_TotalFareFocusLost
        if (jTextField_TotalFare.getText().trim().equals("")
                || jTextField_TotalFare.getText().trim().toLowerCase().equals("£0.00")
                || jTextField_TotalFare.getText().trim().toLowerCase().equals("0.00")) {
            jTextField_TotalFare.setText("0.00");
            jTextField_TotalFare.setForeground(new Color(153, 153, 153));
        }
        jLabel_Fare.setBorder(null);
    }//GEN-LAST:event_jTextField_TotalFareFocusLost

    private void jTextField_TotalFareFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_TotalFareFocusGained
        if (jTextField_TotalFare.getText().trim().toLowerCase().equals("£0.00")
                || jTextField_TotalFare.getText().trim().toLowerCase().equals("0.00")) {
            jTextField_TotalFare.setText("");
            jTextField_TotalFare.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_Fare.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_TotalFareFocusGained

    private void jTextField_TipsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TipsKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_TipsKeyTyped

    private void jTextField_TipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TipsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TipsActionPerformed

    private void jTextField_TipsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_TipsFocusLost
        if (jTextField_Tips.getText().trim().equals("")
                || jTextField_Tips.getText().trim().toLowerCase().equals("£0.00")
                || jTextField_Tips.getText().trim().toLowerCase().equals("0.00")) {
            jTextField_Tips.setText("0.00");
            jTextField_Tips.setForeground(new Color(153, 153, 153));
        }
        jLabel_tips.setBorder(null);
    }//GEN-LAST:event_jTextField_TipsFocusLost

    private void jTextField_TipsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_TipsFocusGained
        if (jTextField_Tips.getText().trim().toLowerCase().equals("£0.00")
                || jTextField_Tips.getText().trim().toLowerCase().equals("0.00")) {
            jTextField_Tips.setText("");
            jTextField_Tips.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_tips.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_TipsFocusGained

    private void jButton_TripClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TripClearActionPerformed
        ClearField();
    }//GEN-LAST:event_jButton_TripClearActionPerformed

    private void jButton_TripClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TripClearMouseExited
        jButton_TripClear.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_TripClearMouseExited

    private void jButton_TripClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TripClearMouseEntered
        jButton_TripClear.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_TripClearMouseEntered

    private void jButton_DeleteTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteTripActionPerformed
        PreparedStatement ps;
        ResultSet rs;
        String tid = jTextField_Search.getText();

        int row = jTable_ShowTrip.getSelectedRow();
        String value = (jTable_ShowTrip.getModel().getValueAt(row, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record", "Warning", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {

            String updateTripQuery = "DELETE FROM trips WHERE tripid='" + tid + "'";

            try {
                ps = DBConnection.getConnection().prepareStatement(updateTripQuery);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Trip has been removed successfully!");
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
                    tblModel.setRowCount(0);
                    ShowTrip();
                    ClearField();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_DeleteTripActionPerformed

    private void jButton_DeleteTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_DeleteTripMouseExited
        jButton_DeleteTrip.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_DeleteTripMouseExited

    private void jButton_DeleteTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_DeleteTripMouseEntered
        jButton_DeleteTrip.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_DeleteTripMouseEntered

    private void jButton_SaveTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveTripActionPerformed
        String thr = jTextField_Hour.getText();
        String tmin = jTextField_Minute.getText();
        String time = thr + ":" + tmin;
        String pl = jTextField_Pickup.getText();
        String des = jTextField_Destination.getText();
        String pn = jTextField_PassengerName.getText();
        String pc = jTextField_PassengerCell.getText();
        String tips = jTextField_Tips.getText();
        String fare = jTextField_TotalFare.getText();
        String dp = jTextField_DriverPay.getText();
        String did = jComboBox_DriverID.getSelectedItem().toString();
        String pm = jComboBox_Payment.getSelectedItem().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String d = sdf.format(jDatePicker.getDate());

        SimpleDateFormat sdff = new SimpleDateFormat("ddMMyy", Locale.getDefault());
        String dd = sdff.format(jDatePicker.getDate());

        String status = "Completed";

        if (verifyFields()) {
            PreparedStatement ps;
            ResultSet rs;
            TripID("select count(tripid) from trips where date = '" + d + "' ");
            String tid = "GCS" + dd + (tripID+1);
            tripID++;
            String TripQuery = "INSERT INTO trips(tripid, date, time, did, ppoint,"
                    + " dpoint, pname, pcell, pmethod, tips, fare, driverpay, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                ps = DBConnection.getConnection().prepareStatement(TripQuery);
                ps.setString(1, tid);
                ps.setString(2, d);
                ps.setString(3, time);
                ps.setString(4, did);
                ps.setString(5, pl);
                ps.setString(6, des);
                ps.setString(7, pn);
                ps.setString(8, pc);
                ps.setString(9, pm);
                ps.setDouble(10, Double.parseDouble(tips));
                ps.setDouble(11, Double.parseDouble(fare));
                ps.setDouble(12, Double.parseDouble(dp));
                ps.setString(13, status);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "Trip has been added successfully!");
                    DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
                    tblModel.setRowCount(0);
                    ShowTrip();
                    ClearField();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                }

            } catch (SQLException ex) {
                Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_SaveTripActionPerformed

    private void jButton_SaveTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveTripMouseExited
        jButton_SaveTrip.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_SaveTripMouseExited

    private void jButton_SaveTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveTripMouseEntered
        jButton_SaveTrip.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_SaveTripMouseEntered

    private void jTextField_HourKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_HourKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_HourKeyTyped

    private void jTextField_HourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HourActionPerformed

    private void jTextField_HourFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_HourFocusLost
        java.util.Date date = new java.util.Date();
        SimpleDateFormat ss = new SimpleDateFormat("HH");
        String hh = ss.format(date);
        if (jTextField_Hour.getText().trim().equals("")
                || jTextField_Hour.getText().trim().toLowerCase().equals(hh)) {
            jTextField_Hour.setText(hh);
            jTextField_Hour.setForeground(new Color(153, 153, 153));

        }
        jLabel_hr.setBorder(null);
    }//GEN-LAST:event_jTextField_HourFocusLost

    private void jTextField_HourFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_HourFocusGained
        java.util.Date date = new java.util.Date();
        SimpleDateFormat ss = new SimpleDateFormat("HH");
        String hh = ss.format(date);
        if (jTextField_Hour.getText().trim().toLowerCase().equals(hh)) {
            jTextField_Hour.setText("");
            jTextField_Hour.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_hr.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_HourFocusGained

    private void jTextField_MinuteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MinuteKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_MinuteKeyTyped

    private void jTextField_MinuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MinuteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_MinuteActionPerformed

    private void jTextField_MinuteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MinuteFocusLost
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sss = new SimpleDateFormat("mm");
        String mm = sss.format(date);
        if (jTextField_Minute.getText().trim().equals("")
                || jTextField_Minute.getText().trim().toLowerCase().equals(mm)) {
            jTextField_Minute.setText(mm);
            jTextField_Minute.setForeground(new Color(153, 153, 153));
        }

        jLabel_hr.setBorder(null);
    }//GEN-LAST:event_jTextField_MinuteFocusLost

    private void jTextField_MinuteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_MinuteFocusGained
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sss = new SimpleDateFormat("mm");
        String mm = sss.format(date);
        if (jTextField_Minute.getText().trim().toLowerCase().equals(mm)) {
            jTextField_Minute.setText("");
            jTextField_Minute.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_hr.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_MinuteFocusGained

    private void jComboBox_DriverIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_DriverIDFocusLost
        jComboBox_DriverID.setForeground(new Color(153, 153, 153));
        jLabel_DriverID.setBorder(null);
    }//GEN-LAST:event_jComboBox_DriverIDFocusLost

    private void jComboBox_DriverIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_DriverIDFocusGained
        jComboBox_DriverID.setForeground(Color.black);
        Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
        jLabel_DriverID.setBorder(jLabel_icon);
    }//GEN-LAST:event_jComboBox_DriverIDFocusGained

    private void jTextField_DriverPayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DriverPayKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_DriverPayKeyTyped

    private void jTextField_DriverPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DriverPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DriverPayActionPerformed

    private void jTextField_DriverPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverPayFocusLost
        jTextField_DriverPay.setForeground(new Color(153, 153, 153));
        jLabel_Dpay.setBorder(null);
    }//GEN-LAST:event_jTextField_DriverPayFocusLost

    private void jTextField_DriverPayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DriverPayFocusGained
        jTextField_DriverPay.setForeground(Color.black);
        Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
        jLabel_Dpay.setBorder(jLabel_icon);
        Double tips = Double.parseDouble(jTextField_Tips.getText());
        Double fare = Double.parseDouble(jTextField_TotalFare.getText());
        DecimalFormat df = new DecimalFormat("0.00");
        Double dpay = tips + (fare * 0.2);
        String dp = df.format(dpay);
        jTextField_DriverPay.setText(dp);
    }//GEN-LAST:event_jTextField_DriverPayFocusGained

    private void jTextField_PassengerCellKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PassengerCellKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_PassengerCellKeyTyped

    private void jTextField_PassengerCellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PassengerCellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PassengerCellActionPerformed

    private void jTextField_PassengerCellFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PassengerCellFocusLost
        if (jTextField_PassengerCell.getText().trim().equals("")
                || jTextField_PassengerCell.getText().trim().toLowerCase().equals("pessengercell..")) {
            jTextField_PassengerCell.setText("pessengercell..");
            jTextField_PassengerCell.setForeground(new Color(153, 153, 153));
        }

        jLabel_Pcell.setBorder(null);
    }//GEN-LAST:event_jTextField_PassengerCellFocusLost

    private void jTextField_PassengerCellFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PassengerCellFocusGained
        if (jTextField_PassengerCell.getText().trim().toLowerCase().equals("pessengercell..")) {
            jTextField_PassengerCell.setText("");
            jTextField_PassengerCell.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_Pcell.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_PassengerCellFocusGained

    private void jTextField_PassengerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PassengerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PassengerNameActionPerformed

    private void jTextField_PassengerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PassengerNameFocusLost
        if (jTextField_PassengerName.getText().trim().equals("")
                || jTextField_PassengerName.getText().trim().toLowerCase().equals("passengername..")) {
            jTextField_PassengerName.setText("passengername..");
            jTextField_PassengerName.setForeground(new Color(153, 153, 153));
        }

        jLabel_Pname.setBorder(null);
    }//GEN-LAST:event_jTextField_PassengerNameFocusLost

    private void jTextField_PassengerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PassengerNameFocusGained
        if (jTextField_PassengerName.getText().trim().toLowerCase().equals("passengername..")) {
            jTextField_PassengerName.setText("");
            jTextField_PassengerName.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_Pname.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_PassengerNameFocusGained

    private void jTextField_PickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PickupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PickupActionPerformed

    private void jTextField_PickupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PickupFocusLost
        String pick;
        pick = jTextField_Pickup.getText();
        if (pick.trim().equals("")
                || pick.trim().toLowerCase().equals("pickuppoint..")) {
            jTextField_Pickup.setText("pickuppoint..");
            jTextField_Pickup.setForeground(new Color(153, 153, 153));
        }

        jLabel_pick.setBorder(null);
    }//GEN-LAST:event_jTextField_PickupFocusLost

    private void jTextField_PickupFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_PickupFocusGained
        if (jTextField_Pickup.getText().trim().toLowerCase().equals("pickuppoint..")) {
            jTextField_Pickup.setText("");
            jTextField_Pickup.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_pick.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_PickupFocusGained

    private void jTextField_DestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DestinationActionPerformed

    private void jTextField_DestinationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DestinationFocusLost
        if (jTextField_Destination.getText().trim().equals("")
                || jTextField_Destination.getText().trim().toLowerCase().equals("destination..")) {
            jTextField_Destination.setText("destination..");
            jTextField_Destination.setForeground(new Color(153, 153, 153));
        }

        jLabel_destination.setBorder(null);
    }//GEN-LAST:event_jTextField_DestinationFocusLost

    private void jTextField_DestinationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DestinationFocusGained
        if (jTextField_Destination.getText().trim().toLowerCase().equals("destination..")) {
            jTextField_Destination.setText("");
            jTextField_Destination.setForeground(Color.black);
            Border jLabel_icon = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray);
            jLabel_destination.setBorder(jLabel_icon);
        }
    }//GEN-LAST:event_jTextField_DestinationFocusGained

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed
        Login form = new Login();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    private void jButton_LogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogOutMouseExited
        jButton_LogOut.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_LogOutMouseExited

    private void jButton_LogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_LogOutMouseEntered
        jButton_LogOut.setBackground(new Color(156, 0, 11));
    }//GEN-LAST:event_jButton_LogOutMouseEntered

    private void jButton_TrackTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TrackTripActionPerformed
        TrackTrip form = new TrackTrip();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_TrackTripActionPerformed

    private void jButton_TrackTripMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TrackTripMouseExited
        jButton_TrackTrip.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_TrackTripMouseExited

    private void jButton_TrackTripMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_TrackTripMouseEntered
        jButton_TrackTrip.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_TrackTripMouseEntered

    private void jButton_AddDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddDriverActionPerformed
        AddDriver form = new AddDriver();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_AddDriverActionPerformed

    private void jButton_AddDriverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AddDriverMouseExited
        jButton_AddDriver.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_AddDriverMouseExited

    private void jButton_AddDriverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AddDriverMouseEntered
        jButton_AddDriver.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_AddDriverMouseEntered

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

    private void jButton_ShowStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ShowStatisticsMouseEntered
        jButton_ShowStatistics.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_ShowStatisticsMouseEntered

    private void jButton_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HomeActionPerformed
        MyDispatcher form = new MyDispatcher();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton_HomeActionPerformed

    private void jButton_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_HomeMouseExited
        jButton_Home.setBackground(new Color(0, 84, 104));
    }//GEN-LAST:event_jButton_HomeMouseExited

    private void jButton_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_HomeMouseEntered
        jButton_Home.setBackground(new Color(0, 101, 183));
    }//GEN-LAST:event_jButton_HomeMouseEntered

    private void jButton_SaveTripKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_SaveTripKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveTripKeyReleased

    private void jTextField_DriverPayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DriverPayKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String thr = jTextField_Hour.getText();
            String tmin = jTextField_Minute.getText();
            String time = thr + ":" + tmin;
            String pl = jTextField_Pickup.getText();
            String des = jTextField_Destination.getText();
            String pn = jTextField_PassengerName.getText();
            String pc = jTextField_PassengerCell.getText();
            String tips = jTextField_Tips.getText();
            String fare = jTextField_TotalFare.getText();
            String dp = jTextField_DriverPay.getText();
            String did = jComboBox_DriverID.getSelectedItem().toString();
            String pm = jComboBox_Payment.getSelectedItem().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
            String d = sdf.format(jDatePicker.getDate());

            SimpleDateFormat sdff = new SimpleDateFormat("ddMMyy", Locale.getDefault());
            String dd = sdff.format(jDatePicker.getDate());

            String status = "Completed";

            if (verifyFields()) {
                PreparedStatement ps;
                ResultSet rs;
                TripID("select count(tripid) from trips where date = '" + d + "' ");
                String tid = "GCS" + dd + tripID;
                tripID++;
                String TripQuery = "INSERT INTO trips(tripid, date, time, did, ppoint,"
                        + " dpoint, pname, pcell, pmethod, tips, fare, driverpay, status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

                try {
                    ps = DBConnection.getConnection().prepareStatement(TripQuery);
                    ps.setString(1, tid);
                    ps.setString(2, d);
                    ps.setString(3, time);
                    ps.setString(4, did);
                    ps.setString(5, pl);
                    ps.setString(6, des);
                    ps.setString(7, pn);
                    ps.setString(8, pc);
                    ps.setString(9, pm);
                    ps.setDouble(10, Double.parseDouble(tips));
                    ps.setDouble(11, Double.parseDouble(fare));
                    ps.setDouble(12, Double.parseDouble(dp));
                    ps.setString(13, status);

                    if (ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Trip has been added successfully!");
                        DefaultTableModel tblModel = (DefaultTableModel) jTable_ShowTrip.getModel();
                        tblModel.setRowCount(0);
                        ShowTrip();
                        ClearField();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(SetTrip.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTextField_DriverPayKeyPressed

    private void jTextField_PickupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PickupKeyReleased

    }//GEN-LAST:event_jTextField_PickupKeyReleased

    private void jTextField_PickupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PickupKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_BACK_SPACE:
            break;
            case KeyEvent.VK_ENTER:
            jTextField_Pickup.setText(jTextField_Pickup.getText());
            break;
            default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override
                    public void run(){
                        String txt = jTextField_Pickup.getText();
                        autoComplete1(txt);
                    }
                    });
        
        }
    }//GEN-LAST:event_jTextField_PickupKeyPressed

    private void jTextField_DestinationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DestinationKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_BACK_SPACE:
            break;
            case KeyEvent.VK_ENTER:
            jTextField_Destination.setText(jTextField_Destination.getText());
            break;
            default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override
                    public void run(){
                        String txt =jTextField_Destination.getText();
                        autoComplete2(txt);
                    }
                    });
        
        }
    }//GEN-LAST:event_jTextField_DestinationKeyPressed

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
            java.util.logging.Logger.getLogger(SetTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new SetTrip().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddDriver;
    private javax.swing.JButton jButton_DeleteTrip;
    private javax.swing.JButton jButton_Home;
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_Print;
    private javax.swing.JButton jButton_Save;
    private javax.swing.JButton jButton_SaveTrip;
    private javax.swing.JButton jButton_ShowStatistics;
    private javax.swing.JButton jButton_TrackTrip;
    private javax.swing.JButton jButton_TripClear;
    private javax.swing.JButton jButton_UpdateTrip;
    private javax.swing.JComboBox<String> jComboBox_DriverID;
    private javax.swing.JComboBox<String> jComboBox_Payment;
    private com.toedter.calendar.JDateChooser jDatePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_ALLR;
    private javax.swing.JLabel jLabel_ALLR1;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_Date1;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_Dpay;
    private javax.swing.JLabel jLabel_DriverID;
    private javax.swing.JLabel jLabel_Fare;
    private javax.swing.JLabel jLabel_Payment;
    private javax.swing.JLabel jLabel_Pcell;
    private javax.swing.JLabel jLabel_Pname;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_datetoday;
    private javax.swing.JLabel jLabel_destination;
    private javax.swing.JLabel jLabel_hr;
    private javax.swing.JLabel jLabel_pick;
    private javax.swing.JLabel jLabel_timenow;
    private javax.swing.JLabel jLabel_tips;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_bar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ShowTrip;
    private javax.swing.JTextField jTextField_Destination;
    private javax.swing.JTextField jTextField_DriverPay;
    private javax.swing.JTextField jTextField_Hour;
    private javax.swing.JTextField jTextField_Minute;
    private javax.swing.JTextField jTextField_PassengerCell;
    private javax.swing.JTextField jTextField_PassengerName;
    private javax.swing.JTextField jTextField_Pickup;
    private javax.swing.JTextField jTextField_Search;
    private javax.swing.JTextField jTextField_Tips;
    private javax.swing.JTextField jTextField_TotalFare;
    // End of variables declaration//GEN-END:variables
}
