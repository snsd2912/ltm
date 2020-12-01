/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import laptrinhmang.Cookie;
import laptrinhmang.Kiphoc;
import laptrinhmang.Request;
import laptrinhmang.TKB;

/**
 *
 * @author DELL
 */
public class home extends javax.swing.JFrame {
    private String cookie;
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel tkb = new DefaultTableModel();
    Object[] obj = {"Mã MH", "Tên MH", "Số TC", "%CC", "%KT", "%TH", "%BT", "%Thi", 
                    "Điểm CC", "Điểm KT", "Điểm TH", "Điểm BT", "Điểm thi L1", "Điểm thi L2", "Điểm TB","Xếp loại"};
    Object[] obj2 = {"Thứ", "Ngày", "Giờ bắt đầu", "Giờ kết thúc", "Môn học", "Nhóm MH", "Số phòng"};
    ArrayList<Kiphoc> listkh;
    /**
     * Creates new form home
     */
    public home(String cookie) throws IOException {
        this.cookie = cookie;
        initComponents();
        dtm.setColumnIdentifiers(obj);
        tbldiem.setModel(dtm);
        tkb.setColumnIdentifiers(obj2);
        tbl.setModel(tkb);
        
        String request = Request.createWelcomePageRequest(this.cookie);
        Request.sendRequest(request, "viewstate.txt");
        String user = Cookie.getUsername("viewstate.txt");
        username.setText(user); 
        
        listkh = new ArrayList<Kiphoc>();
    }
    
    
    public void getFullTKB() throws IOException{
        System.out.println("-------------------");
        String request5 = Request.createTKBPageRequest(this.cookie);
        Request.sendRequest(request5, "viewstate.txt");
        String viewstate5 = Cookie.getViewState("viewstate.txt");
        System.out.println("-------------------");
            // to get tkb
        String request6 = Request.createTKBRequest(this.cookie);
        Request.sendRequest(request6, "viewstate.txt");
        System.out.println("-------------------");
            //String viewstate6 = Cookie.getViewState("viewstate.txt");
        Cookie.getTimeTable("viewstate.txt");
        System.out.println("-------------------");
        listkh = TKB.getTKB();
        System.out.println("-------------------");
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
        username = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cover = new javax.swing.JTabbedPane();
        xemtkb = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        option = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        xemd = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldiem = new javax.swing.JTable();
        dtb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Home");

        username.setText("Xin chào, ");

        jButton1.setText("Đăng xuất");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày", "Môn học", "Nhóm MH", "Thứ", "Giờ bắt đầu", "Giờ kết thúc", "Số phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xem cả học kì", "Tuần 01 [Từ 07/09/2020 -- Đến 13/09/2020]", "Tuần 02 [Từ 14/09/2020 -- Đến 20/09/2020]", "Tuần 03 [Từ 21/09/2020 -- Đến 27/09/2020]", "Tuần 04 [Từ 28/09/2020 -- Đến 04/10/2020]", "Tuần 05 [Từ 05/10/2020 -- Đến 11/10/2020]", "Tuần 06 [Từ 12/10/2020 -- Đến 18/10/2020]", "Tuần 07 [Từ 19/10/2020 -- Đến 25/10/2020]", "Tuần 08 [Từ 26/10/2020 -- Đến 01/11/2020]", "Tuần 09 [Từ 02/11/2020 -- Đến 08/11/2020]", "Tuần 10 [Từ 09/11/2020 -- Đến 15/11/2020]", "Tuần 11 [Từ 16/11/2020 -- Đến 22/11/2020]", "Tuần 12 [Từ 23/11/2020 -- Đến 29/11/2020]", "Tuần 13 [Từ 30/11/2020 -- Đến 06/12/2020]", "Tuần 14 [Từ 07/12/2020 -- Đến 13/12/2020]", "Tuần 15 [Từ 14/12/2020 -- Đến 20/12/2020]", "Tuần 16 [Từ 21/12/2020 -- Đến 27/12/2020]", "Tuần 17 [Từ 28/12/2020 -- Đến 03/01/2021]", "Tuần 18 [Từ 04/01/2021 -- Đến 10/01/2021]", "Tuần 19 [Từ 11/01/2021 -- Đến 17/01/2021]", "Tuần 20 [Từ 18/01/2021 -- Đến 24/01/2021]", "Tuần 21 [Từ 25/01/2021 -- Đến 31/01/2021]", "Tuần 22 [Từ 01/02/2021 -- Đến 07/02/2021]", "Tuần 23 [Từ 08/02/2021 -- Đến 14/02/2021]" }));

        jButton4.setText("Xem");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout xemtkbLayout = new javax.swing.GroupLayout(xemtkb);
        xemtkb.setLayout(xemtkbLayout);
        xemtkbLayout.setHorizontalGroup(
            xemtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xemtkbLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(xemtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(xemtkbLayout.createSequentialGroup()
                        .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        xemtkbLayout.setVerticalGroup(
            xemtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xemtkbLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(xemtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        cover.addTab("Xem thời khóa biểu", xemtkb);

        jButton2.setText("Xem");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        tbldiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên môn", "Điểm chuyên cần", "Điểm kiểm tra", "Điểm thực hành", "Điểm thi", "Điểm tổng", "Đánh giá", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbldiem);

        javax.swing.GroupLayout xemdLayout = new javax.swing.GroupLayout(xemd);
        xemd.setLayout(xemdLayout);
        xemdLayout.setHorizontalGroup(
            xemdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xemdLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(xemdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(xemdLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtb, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        xemdLayout.setVerticalGroup(
            xemdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xemdLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(xemdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(dtb))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        cover.addTab("Xem điểm", xemd);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cover)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(jButton1))
                .addGap(57, 57, 57)
                .addComponent(cover)
                .addContainerGap())
        );

        cover.getAccessibleContext().setAccessibleName("Xem thời khóa biểu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            // TODO add your handling code here:
            (new login()).setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            // TODO add your handling code here:
            // to get score page
            String request = Request.createScorePageRequest(this.cookie);
            Request.sendRequest(request, "viewstate.txt");
            String viewstate = Cookie.getViewState("viewstate.txt");
            
            // to get score list
            String request1 = Request.createScoreRequest(cookie, viewstate);
            Request.sendRequest(request1, "viewstate.txt");
            Cookie.getScoreList("viewstate.txt");
            
            File file = new File("score.txt");
            Scanner myReader = new Scanner(file);
            dtm.setRowCount(0);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String col[] = line.split("#");
                dtm.addRow(new Object[]{col[2],col[3],col[4],col[5],col[6],col[7],col[8],
                                        col[9],col[10],col[11],col[12],col[13],col[14],col[15],col[16],col[17]});
            }
            myReader.close();
            
            float diemtb = Cookie.getAverageScore("viewstate.txt");
            dtb.setText("Điểm trung bình tích lũy (hệ 4): "+diemtb);
            
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    
    
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        
            try {
                if(option.getSelectedIndex()==0){
                    if(listkh.isEmpty()) getFullTKB();
                    tkb.setRowCount(0);
                    for(Kiphoc kh : listkh){
                        System.out.println(kh.toString());
                        tkb.addRow(new Object[]{kh.getThu(),kh.getNgay(),kh.getGiobatdau()+":00",kh.getGioketthuc()+":00",
                            kh.getTenMH(),kh.getNhomMH(),kh.getPhong()});
                    }
                }else {
                    String tuan = option.getItemAt(option.getSelectedIndex());
                    System.out.println(tuan);
                    String ngaybd = tuan.substring(12, 22);
                    String ngaykt = tuan.substring(30, 40);
                    System.out.println(ngaybd + " " + ngaykt);
                    tkb.setRowCount(0);
                    if(listkh.isEmpty()) getFullTKB();
                    try {
                        ArrayList<Kiphoc> listsubkh = TKB.getSubTKB(listkh, ngaybd, ngaykt);
                        for(Kiphoc kh : listsubkh){
                            //System.out.println(kh.toString());
                            tkb.addRow(new Object[]{kh.getThu(),kh.getNgay(),kh.getGiobatdau()+":00",kh.getGioketthuc()+":00",
                                kh.getTenMH(),kh.getNhomMH(),kh.getPhong()});
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                }
            } catch (IOException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private String cookie;
            public void run() {
                try {
                    new home(this.cookie).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane cover;
    private javax.swing.JLabel dtb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> option;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tbldiem;
    private javax.swing.JLabel username;
    private javax.swing.JPanel xemd;
    private javax.swing.JPanel xemtkb;
    // End of variables declaration//GEN-END:variables
}
