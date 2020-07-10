package Interface;

import Proccess.Check;
import Proccess.MonHoc.MonHoc;
import Proccess.MonHoc.IMonHocDAO;
import Proccess.GiangVien.GiangVien;
import Proccess.GiangVien.IGiangVienDAO;
import Proccess.GiangVien.GiangVienDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmGiangVien extends javax.swing.JPanel
{
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    ArrayList<MonHoc> allMonHoc = null;
    ArrayList<GiangVien> allGiangVien = null;
    
    public static String regexDDMMYYYY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";

    public frmGiangVien()
    {
        try
        {
            initComponents();
            dtm = new DefaultTableModel();
            dcbm = new DefaultComboBoxModel();
            
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = monHocDAO.getAll();
            for (MonHoc mh : allMonHoc)
            {
                dcbm.addElement(mh.getMamh());
            }
            cboMaMH.setModel(dcbm);

            dtm.addColumn("Mã giảng viên");
            dtm.addColumn("Họ tên");
            dtm.addColumn("Giới tính");
            dtm.addColumn("Ngày sinh");
            dtm.addColumn("Địa chỉ");          
            dtm.addColumn("Email");           
            dtm.addColumn("Số điện thoại");
            dtm.addColumn("Mã môn học");
            loaddata();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loaddata()
    {
        try
        {
            IGiangVienDAO giangVienDAO = (IGiangVienDAO) Class.forName("Proccess.GiangVien.GiangVienDAO").newInstance();
            allGiangVien = new GiangVienDAO().getAll();
            for (GiangVien gv : allGiangVien)
            {
                dtm.addRow(toObjectsData(gv));
            }
            tblGiangVien.setModel(dtm);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ResetForm()
    {
        btnThem.setEnabled(true);
        txtMaGV.setEnabled(true);
        txtMaGV.setText("");
        txtHoTenGV.setText("");
        radGioiTinh.setSelected(false);
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");        
        txtSDT.setText("");
        cboMaMH.setSelectedIndex(0);
        txtMaGV.requestFocus();
    }
    
    private void showAll()
    {
        while (dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        
        int selectedIndex = cboMaMH.getSelectedIndex();
        MonHoc getmh = allMonHoc.get(selectedIndex);
        ArrayList<GiangVien> gvs = new GiangVienDAO().findByIDMonHoc(getmh.getMamh());
        for (GiangVien gv : gvs)
        {
            Vector vector = new Vector();
            vector.add(gv.getMagv());
            vector.add(gv.getHotengv());
            if (gv.isGioitinh() == true)
                vector.add("Nam");
            else
                vector.add("Nữ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            vector.add(dateFormat.format(gv.getNgaysinh()));
            vector.add(gv.getDiachi());
            vector.add(gv.getEmail());            
            vector.add(gv.getSdt());
            vector.add(gv.getMamh());            
            dtm.addRow(vector);
        }
        ResetForm();
    }

    private static Object[] toObjectsData(GiangVien gv)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(gv.getNgaysinh());
        boolean flag = gv.isGioitinh();
        String gioitinh;
        if (flag == true)
            gioitinh = "Nam";
        else
            gioitinh = "Nữ";

        Object[] objectsData = {gv.getMagv(), gv.getHotengv(), gioitinh, date, gv.getDiachi(), gv.getEmail(), gv.getSdt(), gv.getMamh()};
        return objectsData;
    }
    
    public boolean checkinfo()
    {
        Check c = new Check();
        if (!c.checkSpace(txtHoTenGV.getText()) || !c.check(txtHoTenGV.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập họ tên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtHoTenGV.selectAll();
            txtHoTenGV.requestFocus();
            return false;
        }        
        else if (!c.checkSpace(txtDiaChi.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập địa chỉ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtDiaChi.selectAll();
            txtDiaChi.requestFocus();
            return false;
        }
        else if (!c.checkSpace(txtEmail.getText()) || !c.checkEmail(txtEmail.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập email", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtEmail.selectAll();
            txtEmail.requestFocus();
            return false;
        }
        else if (!c.checkSpace(txtSDT.getText()) || !c.checkPhone(txtSDT.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập số điện thoại", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtSDT.selectAll();
            txtSDT.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtHoTenGV = new javax.swing.JTextField();
        txtMaGV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        radGioiTinh = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        cboMaMH = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCapnhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGiangVien = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 0, 153));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THÔNG TIN GIẢNG VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 153));
        jLabel8.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 153));
        jLabel6.setText("Giới tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Điện thoại");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 153));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 153));
        jLabel5.setText("Địa chỉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("Mã giảng viên");

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("Họ tên");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtHoTenGV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMaGV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        radGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radGioiTinh.setText("Nam/Nữ");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cboMaMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboMaMH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaMHItemStateChanged(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(51, 51, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 153));
        jLabel9.setText("Mã môn học");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("(dd/MM/yyyy)");

        txtTenMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenMH.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("(8-12 số)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenMH, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12))
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radGioiTinh))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(radGioiTinh))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCapnhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapnhat.setForeground(new java.awt.Color(255, 0, 153));
        btnCapnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_1.png"))); // NOI18N
        btnCapnhat.setText(" Cập nhật");
        btnCapnhat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 0, 153));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset_1.png"))); // NOI18N
        btnReset.setText(" Reset");
        btnReset.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReset.setMaximumSize(new java.awt.Dimension(75, 27));
        btnReset.setMinimumSize(new java.awt.Dimension(75, 27));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCapnhat)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapnhat, btnReset, btnThem, btnXoa});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblGiangVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảng viên", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Email", "Số điện thoại", "Mã môn học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblGiangVien.setRowHeight(25);
        tblGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGiangVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGiangVien);

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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hoa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void tblGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiangVienMouseClicked
        txtMaGV.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 0).toString());
        txtHoTenGV.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 1).toString());
        String sex = tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 2).toString();
        if (sex.equals("Nam"))
            radGioiTinh.setSelected(true);
        else
            radGioiTinh.setSelected(false);        
        txtNgaySinh.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 3).toString());
        txtDiaChi.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 4).toString());
        txtEmail.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 5).toString());       
        txtSDT.setText(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 6).toString());
        cboMaMH.setSelectedItem(tblGiangVien.getValueAt(tblGiangVien.getSelectedRow(), 7).toString());
        
        btnThem.setEnabled(false);
        btnCapnhat.setEnabled(true);
        btnXoa.setEnabled(true);
        txtMaGV.setEnabled(false);
    }//GEN-LAST:event_tblGiangVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String magv = txtMaGV.getText();
        String hoten = txtHoTenGV.getText();
        boolean gioitinh = radGioiTinh.isSelected();
        String ngaysinh = txtNgaySinh.getText();
        String diachi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();  
        String mamh = allMonHoc.get(cboMaMH.getSelectedIndex()).getMamh();
        
        Date d = null;
        Check c = new Check();        
        if (!c.checkID(txtMaGV.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập mã giảng viên", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMaGV.selectAll();
            txtMaGV.requestFocus();
        }
        else if (!checkinfo())
            return;
        else if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtNgaySinh.selectAll();
            txtNgaySinh.requestFocus();
            return;
        }
        else
        {
            try
            {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
            }
            catch (ParseException ex)
            {
                JOptionPane.showMessageDialog(this, "Lỗi nhập ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        GiangVien giangVien = new GiangVien(magv, hoten, gioitinh, d, diachi, email, sdt, mamh);
        ArrayList<GiangVien> listCheck = new GiangVienDAO().CheckID(magv);
        if (listCheck.size() > 0)
        {
            JOptionPane.showMessageDialog(this, "Mã giảng viên bị trùng!", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
            txtMaGV.selectAll();
            txtMaGV.requestFocus();
        }
        else
        {
            GiangVien insert = new GiangVienDAO().addNew(giangVien);
            if (insert != null)
                showAll();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        String magv = txtMaGV.getText();
        String hotengv = txtHoTenGV.getText();
        boolean gioitinh = radGioiTinh.isSelected();
        String ngaysinh = txtNgaySinh.getText();
        String diachi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();        
        String mamh = allMonHoc.get(cboMaMH.getSelectedIndex()).getMamh();

        Date d;        
        if(magv.length()==0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giảng viên cần cập nhật", "Thông báo", 1);
        else
        {
            if (!checkinfo())
                return;
            else if (ngaysinh == null || ngaysinh.equals("") || !ngaysinh.matches(regexDDMMYYYY))
            {
                JOptionPane.showMessageDialog(this, "Lỗi nhập ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                txtNgaySinh.selectAll();
                txtNgaySinh.requestFocus();
                return;
            }
            else
            {
                try
                {
                    d = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
                }
                catch (ParseException ex)
                {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập ngày sinh", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }             
            GiangVien giangVien = new GiangVien(magv, hotengv, gioitinh, d, diachi, email, sdt, mamh);
            GiangVien update = new GiangVienDAO().updateByID(giangVien);           
            if (update != null)
                showAll();
            btnThem.setEnabled(true);
            txtMaGV.setEnabled(true);
        }
    }//GEN-LAST:event_btnCapnhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String magv = txtMaGV.getText();
        if(magv.length()==0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giảng viên cần xóa", "Thông báo", 1);
        else
        {        
            int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (b == JOptionPane.YES_OPTION)
            {
                try
                {
                    new GiangVienDAO().deleteGiangVien(magv);
                }
                catch (SQLException | ClassNotFoundException ex)
                {
                    Logger.getLogger(frmGiangVien.class.getName()).log(Level.SEVERE, null, ex);
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

    private void cboMaMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaMHItemStateChanged
        String mamh = cboMaMH.getSelectedItem().toString();
        try
        {
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = monHocDAO.getAll();
            for (MonHoc mh : allMonHoc)
            {
                if (mamh.equals(mh.getMamh()))
                    txtTenMH.setText(mh.getTenmh());
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboMaMHItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cboMaMH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radGioiTinh;
    private javax.swing.JTable tblGiangVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenGV;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
