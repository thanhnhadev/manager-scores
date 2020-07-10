package Interface;

import Proccess.Check;
import Proccess.BangDiem.BangDiem;
import Proccess.BangDiem.IBangDiemDAO;
import Proccess.Lop.Lop;
import Proccess.Lop.ILopDAO;
import Proccess.SinhVien.SinhVien;
import Proccess.SinhVien.ISinhVienDAO;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmTimKiem extends javax.swing.JPanel
{
    private DefaultTableModel dtm;
    private DefaultTableModel dtmMark;
    ArrayList<BangDiem> listbdiem = null;

    public frmTimKiem()
    {
        initComponents();
        dtm = new DefaultTableModel();
        dtmMark = new DefaultTableModel();

        // Tìm sinh viên theo mã lớp
        dtm.addColumn("Mã sinh viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Hệ đào tạo");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Số điện thoại");
        dtm.addColumn("Mã lớp");
        tblSinhVien_MaLop.setModel(dtm);

        // Tìm điểm theo mã sinh viên
        dtmMark.addColumn("Mã sinh viên");
        dtmMark.addColumn("Mã môn học");
        dtmMark.addColumn("Lần thi");
        dtmMark.addColumn("Hệ số");
        dtmMark.addColumn("Điểm");
        dtmMark.addColumn("Trạng thái");
        tblDiem_MaSV.setModel(dtmMark);
    }
    
    private static Object[] toObjectData(SinhVien sv)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(sv.getNgaysinh());
        boolean flag = sv.isGioitinh();
        String gioitinh;
        if (flag == true)
            gioitinh = "Nam";
        else
            gioitinh = "Nữ";
        Object[] objectData = {sv.getMasv(), sv.getHotensv(), sv.getHedaotao(), gioitinh, date, sv.getDiachi(), sv.getSdt(), sv.getMalop()};
        return objectData;
    }
    
    public static Object[] toOjectBd(BangDiem bd)
    {
        boolean flag = bd.isTrangthai();
        String trangthai;
        if (flag == true)
            trangthai = "Bật";
        else
            trangthai = "Tắt";
        Object[] objects = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem(), trangthai};
        return objects;
    }

    public void timkiem()
    {
        String malop = txtMaLop.getText();
        while (dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        try
        {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            ArrayList<SinhVien> list = sinhVienDAO.findByIDLop(malop);
            for (SinhVien sv : list)
            {
                dtm.addRow(toObjectData(sv));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Check c = new Check();
        if (!c.checkSpace(malop) || !c.check(malop))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã lớp", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaLop.selectAll();
            txtMaLop.requestFocus();
        }
        else if (dtm.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy lớp này hoặc lớp này không có sinh viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaLop.selectAll();
            txtMaLop.requestFocus();
        }
    }

    public void timKiemDiem()
    {
        String masv = txtMaSV.getText();
        while (dtmMark.getRowCount() > 0)
        {
            dtmMark.removeRow(0);
        }
        try
        {        
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("Proccess.BangDiem.BangDiemDAO").newInstance();
            ArrayList<BangDiem> listbd = bangDiemDAO.findByIDSinhVien(masv);
            for (BangDiem bd : listbd)
            {
                dtmMark.addRow(toOjectBd(bd));
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Check c = new Check();
        if (!c.checkSpace(masv) || !c.check(masv))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã sinh viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaSV.selectAll();
            txtMaSV.requestFocus();
        }        
        else if (dtmMark.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên này hoặc sinh viên này không có điểm", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaSV.selectAll();
            txtMaSV.requestFocus();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien_MaLop = new javax.swing.JTable();
        txtMaLop = new javax.swing.JTextField();
        btnTimkiemSV = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem_MaSV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        btnTimkiemDiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblSinhVien_MaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSinhVien_MaLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Hệ đào tạo", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Mã lớp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSinhVien_MaLop.setRowHeight(25);
        jScrollPane2.setViewportView(tblSinhVien_MaLop);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaLop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaLopKeyReleased(evt);
            }
        });

        btnTimkiemSV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiemSV.setForeground(new java.awt.Color(255, 0, 153));
        btnTimkiemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimkiemSV.setText(" Tìm kiếm");
        btnTimkiemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemSVActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("Mã lớp");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnTimkiemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Sinh viên theo Mã lớp", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblDiem_MaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDiem_MaSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Mã môn học", "Lần thi", "Hệ số", "Điểm", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiem_MaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDiem_MaSV.setRowHeight(25);
        jScrollPane3.setViewportView(tblDiem_MaSV);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("Mã sinh viên");

        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSVKeyReleased(evt);
            }
        });

        btnTimkiemDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiemDiem.setForeground(new java.awt.Color(255, 0, 153));
        btnTimkiemDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimkiemDiem.setText(" Tìm kiếm");
        btnTimkiemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemDiemActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimkiemDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimkiemDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tìm Điểm theo Mã sinh viên", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnTimkiemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemSVActionPerformed
        timkiem();
    }//GEN-LAST:event_btnTimkiemSVActionPerformed

    private void btnTimkiemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemDiemActionPerformed
        timKiemDiem();
    }//GEN-LAST:event_btnTimkiemDiemActionPerformed

    private void txtMaLopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLopKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timkiem();
        }
    }//GEN-LAST:event_txtMaLopKeyReleased

    private void txtMaSVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSVKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            timKiemDiem();
        }
    }//GEN-LAST:event_txtMaSVKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimkiemDiem;
    private javax.swing.JButton btnTimkiemSV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDiem_MaSV;
    private javax.swing.JTable tblSinhVien_MaLop;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
