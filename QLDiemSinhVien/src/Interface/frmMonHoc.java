package Interface;

import Proccess.Check;
import Proccess.MonHoc.IMonHocDAO;
import Proccess.MonHoc.MonHoc;
import Proccess.MonHoc.MonHocDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmMonHoc extends javax.swing.JPanel
{
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private ArrayList<MonHoc> allMonHoc = null;

    public frmMonHoc()
    {
        initComponents();
        dtm = new DefaultTableModel();
        dcbm = new DefaultComboBoxModel();
        
        dcbm.addElement("Trắc nghiệm");
        dcbm.addElement("Tự luận");
        dcbm.addElement("Đồ án");
        cboHinhThucThi.setModel(dcbm);

        dtm.addColumn("Mã môn học");
        dtm.addColumn("Tên môn học");
        dtm.addColumn("Số tín chỉ");
        dtm.addColumn("Hình thức thi");
        dtm.addColumn("Học kỳ");
        dtm.addColumn("Phòng học");
        loaddata();
    }

    private void loaddata()
    {
        try
        {
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = new MonHocDAO().getAll();
            for (MonHoc mh : allMonHoc)
            {
                dtm.addRow(toObjectsData(mh));
            }
            tblMonHoc.setModel(dtm);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmMonHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ResetForm()
    {
        btnThem.setEnabled(true);
        txtMaMH.setEnabled(true);
        txtMaMH.setText("");
        txtTenMH.setText("");        
        txtSoTinChi.setText("");
        cboHinhThucThi.setSelectedIndex(0);
        txtHocKy.setText("");       
        txtPhongHoc.setText("");
        txtMaMH.requestFocus();
    }
    
    private void showAll()
    {
        while (dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        
        ArrayList<MonHoc> mhs = new MonHocDAO().getAll();
        for (MonHoc mh : mhs)
        {
            Vector v = new Vector();
            v.add(mh.getMamh());
            v.add(mh.getTenmh());
            v.add(mh.getSotinchi());
            v.add(mh.getHinhthucthi());
            v.add(mh.getHocky());
            v.add(mh.getPhonghoc());
            dtm.addRow(v);
        }
        ResetForm();
    }

    private static Object[] toObjectsData(MonHoc mh)
    {
        Object[] objectsData = {mh.getMamh(), mh.getTenmh(), mh.getSotinchi(), mh.getHinhthucthi(), mh.getHocky(), mh.getPhonghoc()};
        return objectsData;
    }
    
    public boolean checkinfo()
    {
        Check c = new Check();        
        if (!c.checkSpace(txtTenMH.getText()) || !c.check(txtTenMH.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập tên môn học", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtTenMH.selectAll();
            txtTenMH.requestFocus();
            return false;
        }
        else if (!c.checkSpace(txtSoTinChi.getText()) || !c.checkNumber(txtSoTinChi.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập số tín chỉ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtSoTinChi.selectAll();
            txtSoTinChi.requestFocus();
            return false;
        }
        else if (!c.checkSpace(txtHocKy.getText()) || !c.checkNumber(txtHocKy.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập số học kỳ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtHocKy.selectAll();
            txtHocKy.requestFocus();
            return false;
        }
        else if (!c.checkSpace(txtPhongHoc.getText()) || !c.check(txtPhongHoc.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập phòng học", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtPhongHoc.selectAll();
            txtPhongHoc.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        txtPhongHoc = new javax.swing.JTextField();
        txtSoTinChi = new javax.swing.JTextField();
        txtTenMH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        cboHinhThucThi = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapnhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblMonHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã môn học", "Tên môn học", "Số tín chỉ", "Hình thức thi", "Học kỳ", "Phòng học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        tblMonHoc.setRowHeight(25);
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonHocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMonHoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("Tên môn học");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("Mã môn học");

        txtMaMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPhongHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtSoTinChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTenMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 153));
        jLabel4.setText("Số tín chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 153));
        jLabel5.setText("Học kỳ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 153));
        jLabel6.setText("Phòng học");

        txtHocKy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cboHinhThucThi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Hình thức thi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHinhThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 181, 181))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(cboHinhThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboHinhThucThi, txtHocKy, txtMaMH, txtPhongHoc, txtSoTinChi, txtTenMH});

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 0, 153));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnThem.setText(" Thêm");
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapnhat.setForeground(new java.awt.Color(255, 0, 153));
        btnCapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_1.png"))); // NOI18N
        btnCapnhat.setText(" Cập nhật");
        btnCapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 0, 153));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/xoa.png"))); // NOI18N
        btnXoa.setText(" Xóa");
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoa.setIconTextGap(2);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 0, 153));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset_1.png"))); // NOI18N
        btnReset.setText(" Reset");
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapnhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCapnhat, btnReset, btnThem, btnXoa});

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hoa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN MÔN HỌC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMouseClicked
        txtMaMH.setText(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 0).toString());
        txtTenMH.setText(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 1).toString());
        txtSoTinChi.setText(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 2).toString());
        cboHinhThucThi.setSelectedItem(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 3).toString());
        txtHocKy.setText(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 4).toString());
        txtPhongHoc.setText(tblMonHoc.getValueAt(tblMonHoc.getSelectedRow(), 5).toString());

        btnThem.setEnabled(false);
        btnCapnhat.setEnabled(true);
        btnXoa.setEnabled(true);
        txtMaMH.setEnabled(false);
    }//GEN-LAST:event_tblMonHocMouseClicked
       
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maMH = txtMaMH.getText();
        String tenMH = txtTenMH.getText();
        String soTinchi = txtSoTinChi.getText();
        String htThi = (String) cboHinhThucThi.getSelectedItem();
        String hocKy = txtHocKy.getText();
        String phongHoc = txtPhongHoc.getText();
        
        Check c = new Check();
        if (!c.checkID(txtMaMH.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã môn học", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaMH.selectAll();
            txtMaMH.requestFocus();
        }
        else if (!checkinfo())
            return;
        
        int stchi = Integer.parseInt(soTinchi);
        int hky = Integer.parseInt(hocKy);
        MonHoc monHoc = new MonHoc(maMH, tenMH, stchi,  htThi, hky, phongHoc);
        ArrayList<MonHoc> listCheck = new MonHocDAO().CheckID(maMH);
        if (listCheck.size() > 0)
        {
            JOptionPane.showMessageDialog(this, "Mã môn học bị trùng!", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            txtMaMH.selectAll();
            txtMaMH.requestFocus();
        }
        else
        {
            MonHoc insert = new MonHocDAO().addNew(monHoc);
            if (insert != null)
                showAll();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        String maMH = txtMaMH.getText();
        String tenMH = txtTenMH.getText();
        String soTinchi = txtSoTinChi.getText();
        String htThi = (String) cboHinhThucThi.getSelectedItem();
        String hocKy = txtHocKy.getText();
        String phongHoc = txtPhongHoc.getText();
        
        if(maMH.length()==0)       
            JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học cần cập nhật", "Thông báo", 1);
        else
        {
            if (!checkinfo())
                return;
            int stchi = Integer.parseInt(soTinchi);
            int hky = Integer.parseInt(hocKy);
            MonHoc monHoc = new MonHoc(maMH, tenMH, stchi, htThi, hky, phongHoc);
            MonHoc update = new MonHocDAO().updateByID(monHoc);
            if (update != null)
                showAll();
            btnThem.setEnabled(true);
            txtMaMH.setEnabled(true);
        }
    }//GEN-LAST:event_btnCapnhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maMH = txtMaMH.getText();
        if(maMH.length()==0)       
            JOptionPane.showMessageDialog(null, "Vui lòng chọn môn học cần xóa", "Thông báo", 1);
        else
        {
            int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (b == JOptionPane.YES_OPTION)
            {
                try
                {
                    new MonHocDAO().deleteMonHoc(maMH);
                }
                catch (SQLException | ClassNotFoundException ex)
                {
                    JOptionPane.showMessageDialog(this, "Dữ liệu chưa thể xóa, có tồn tại điểm hoặc giảng viên của môn học này.\nHãy xóa dữ liệu điểm hoặc giảng viên của môn học này trước.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                while (dtm.getRowCount() > 0)
                {
                    dtm.removeRow(0);
                }
                ResetForm();
                loaddata();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.ResetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cboHinhThucThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtPhongHoc;
    private javax.swing.JTextField txtSoTinChi;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
