package Interface;

import Proccess.Check;
import Proccess.MonHoc.MonHoc;
import Proccess.MonHoc.IMonHocDAO;
import Proccess.SinhVien.SinhVien;
import Proccess.SinhVien.ISinhVienDAO;
import Proccess.BangDiem.BangDiem;
import Proccess.BangDiem.IBangDiemDAO;
import Proccess.BangDiem.BangDiemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmBangDiem extends javax.swing.JPanel
{
    private DefaultTableModel dtm;
    private DefaultButtonModel dbm;    
    private DefaultComboBoxModel dcbmMaSV;
    private DefaultComboBoxModel dcbmMaMH;
    private DefaultComboBoxModel dcbmLanThi;
    private DefaultComboBoxModel dcbmHeSo;
    ArrayList<SinhVien> allSinhVien = null;
    ArrayList<MonHoc> allMonHoc = null;
    ArrayList<BangDiem> allDiem = null;

    public frmBangDiem()
    {
        try
        {
            initComponents();
            dtm = new DefaultTableModel();
            dbm = new DefaultButtonModel();
            dcbmMaSV = new DefaultComboBoxModel();
            dcbmMaMH = new DefaultComboBoxModel();
            dcbmLanThi = new DefaultComboBoxModel();
            dcbmHeSo = new DefaultComboBoxModel();
            
            // Load môn học
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = monHocDAO.getAll();
            for (MonHoc mh : allMonHoc)
            {
                dcbmMaMH.addElement(mh.getMamh());
            }
            cboMaMH.setModel(dcbmMaMH);
            
            //Load mã sinh viên
            try
            {
                ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
                allSinhVien = sinhVienDAO.getAll();
                dcbmMaSV.removeAllElements();
                for (SinhVien sv : allSinhVien)
                {
                    dcbmMaSV.addElement(sv.getMasv());
                }
                cboMaSV.setModel(dcbmMaSV);
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
            {
                Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Load lần thi
            dcbmLanThi.addElement("0");
            dcbmLanThi.addElement("1");
            dcbmLanThi.addElement("2");
            dcbmLanThi.addElement("3");
            dcbmLanThi.addElement("4");
            dcbmLanThi.addElement("5");
            cboLanThi.setModel(dcbmLanThi);

            //Load hệ số
            dcbmHeSo.addElement("0");
            dcbmHeSo.addElement("1");
            dcbmHeSo.addElement("2");
            dcbmHeSo.addElement("3");
            cboHeSo.setModel(dcbmHeSo);

            dtm.addColumn("Mã sinh viên");
            dtm.addColumn("Mã môn học");
            dtm.addColumn("Lần thi");
            dtm.addColumn("Hệ số");
            dtm.addColumn("Điểm");
            dtm.addColumn("Trạng thái");
            loaddata();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loaddata()
    {
        try
        {
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("Proccess.BangDiem.BangDiemDAO").newInstance();
            allDiem = bangDiemDAO.getAll();
            for (BangDiem bd : allDiem)
            {
                dtm.addRow(toObjectsData(bd));
            }
            tblDiem.setModel(dtm);
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ResetForm()
    {
        btnThem.setEnabled(true);
        cboMaSV.setEnabled(true);
        cboMaSV.setSelectedIndex(0);
        cboMaMH.setEnabled(true);
        cboMaMH.setSelectedIndex(0);
        cboLanThi.setEnabled(true);   
        cboLanThi.setSelectedIndex(0);
        cboHeSo.setSelectedIndex(0);
        txtDiem.setText("");
        radTrangThai.setSelected(false);   
    }
    
    public void showAll()
    {
        while (dtm.getRowCount() > 0)
        {
            dtm.removeRow(0);
        }
        ArrayList<BangDiem> Diems = new BangDiemDAO().getAll();
        for (BangDiem bd : Diems)
        {
            Vector v = new Vector();
            v.add(bd.getMasv());
            v.add(bd.getMamh());
            v.add(bd.getLanthi());
            v.add(bd.getHeso());
            v.add(bd.getDiem());
            if (bd.isTrangthai() == true)
                v.add("Bật");
            else
                v.add("Tắt");
            dtm.addRow(v);
        }
        ResetForm();
    }

    private static Object[] toObjectsData(BangDiem bd)
    {
        boolean flag = bd.isTrangthai();
        String trangthai;
        if (flag == true)
            trangthai = "Bật";
        else
            trangthai = "Tắt";
               
        Object[] objectsData = {bd.getMasv(), bd.getMamh(), bd.getLanthi(), bd.getHeso(), bd.getDiem(), trangthai};
        return objectsData;
    }
    
    public boolean checkinfo()
    {
        Check c = new Check();
        if (!c.checkSpace(txtDiem.getText()) || !c.checkMark(txtDiem.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lỗi nhập điểm", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtDiem.selectAll();
            txtDiem.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtDiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboLanThi = new javax.swing.JComboBox();
        cboHeSo = new javax.swing.JComboBox();
        radTrangThai = new javax.swing.JRadioButton();
        cboMaSV = new javax.swing.JComboBox();
        cboMaMH = new javax.swing.JComboBox();
        txtTenMH = new javax.swing.JTextField();
        txtHoTenSV = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnCapnhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("Mã sinh viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("Mã môn học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 153));
        jLabel4.setText("Lần thi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 153));
        jLabel5.setText("Hệ số");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 153));
        jLabel6.setText("Điểm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Trạng thái");

        cboLanThi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboLanThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        cboHeSo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboHeSo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

        radTrangThai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radTrangThai.setText("Bật/Tắt");

        cboMaSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboMaSV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaSVItemStateChanged(evt);
            }
        });

        cboMaMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboMaMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaMHItemStateChanged(evt);
            }
        });

        txtTenMH.setEnabled(false);

        txtHoTenSV.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radTrangThai)
                                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txtHoTenSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(radTrangThai))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblDiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDiem.setRowHeight(25);
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDiem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hoa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 0, 153));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("THÔNG TIN ĐIỂM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        cboMaSV.setSelectedItem(tblDiem.getValueAt(tblDiem.getSelectedRow(), 0).toString());
        cboMaMH.setSelectedItem(tblDiem.getValueAt(tblDiem.getSelectedRow(), 1).toString());
        cboLanThi.setSelectedItem(tblDiem.getValueAt(tblDiem.getSelectedRow(), 2).toString());
        cboHeSo.setSelectedItem(tblDiem.getValueAt(tblDiem.getSelectedRow(), 3).toString());
        txtDiem.setText(tblDiem.getValueAt(tblDiem.getSelectedRow(), 4).toString());
        String trangthai = tblDiem.getValueAt(tblDiem.getSelectedRow(), 5).toString();
        if (trangthai.equals("Bật"))
            radTrangThai.setSelected(true);
        else
            radTrangThai.setSelected(false);
        
        btnThem.setEnabled(false);
        btnCapnhat.setEnabled(true);
        btnXoa.setEnabled(true);
        cboMaSV.setEnabled(false);
        cboMaMH.setEnabled(false);
        cboLanThi.setEnabled(false);
    }//GEN-LAST:event_tblDiemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String masv = allSinhVien.get(cboMaSV.getSelectedIndex()).getMasv();
        String mamh = allMonHoc.get(cboMaSV.getSelectedIndex()).getMamh();
        int lanthi = cboLanThi.getSelectedIndex();
        int heso = cboHeSo.getSelectedIndex();
        String diem = txtDiem.getText();
        boolean trangthai = radTrangThai.isSelected();        
        
        if (lanthi == 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn lần thi", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (heso == 0)
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hệ số", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (!checkinfo()) 
            return;
        
        float diemsv = Float.parseFloat(diem);
        if (diemsv > 10 || diemsv < 0)
        {
            JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 10", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtDiem.selectAll();
            txtDiem.requestFocus();
            return;
        }
        BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv, trangthai);
        boolean result = new BangDiemDAO().CheckID(masv, mamh, lanthi);
        if (result)
            JOptionPane.showMessageDialog(this, "Dữ liệu bị trùng!", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
        else
        {
            BangDiem insert = new BangDiemDAO().addNew(bd);
            if (insert != null) 
                showAll();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhatActionPerformed
        String masv = allSinhVien.get(cboMaSV.getSelectedIndex()).getMasv();
        String mamh = allMonHoc.get(cboMaSV.getSelectedIndex()).getMamh();
        int lanthi = cboLanThi.getSelectedIndex();
        int heso = cboHeSo.getSelectedIndex();
        String diem = txtDiem.getText();
        boolean trangthai = radTrangThai.isSelected();        
        
        if(diem.length()==0)     
            JOptionPane.showMessageDialog(null, "Vui lòng chọn điểm cần cập nhật", "Thông báo", 1);
        else
        {
            if (heso == 0)
            {
                JOptionPane.showMessageDialog(this, "Hệ số phải khác 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!checkinfo())
                return;
            float diemsv = Float.parseFloat(diem);
            if (diemsv > 10 || diemsv < 0)
            {
                JOptionPane.showMessageDialog(this, "Điểm phải nhập là số từ 0 - 10", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
                txtDiem.selectAll();
                txtDiem.requestFocus();
                return;
            }
            BangDiem bd = new BangDiem(masv, mamh, lanthi, heso, diemsv, trangthai);
            BangDiem update = new BangDiemDAO().updateByID(bd);
            if (update != null)
                showAll();
            btnThem.setEnabled(true);
            cboMaSV.setEnabled(true);
            cboMaMH.setEnabled(true);
            cboLanThi.setEnabled(true);
        }
    }//GEN-LAST:event_btnCapnhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String masv = allSinhVien.get(cboMaSV.getSelectedIndex()).getMasv();
        String mamh = allMonHoc.get(cboMaSV.getSelectedIndex()).getMamh();
        int lanthi = cboLanThi.getSelectedIndex();
        String diem = txtDiem.getText();
        if(diem.length()==0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn điểm cần xóa", "Thông báo", 1);
        else
        {       
            int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (b == JOptionPane.YES_OPTION)
            {                
                try
                {
                    new BangDiemDAO().deleteBangDiem(masv, mamh, lanthi);
                }
                catch (SQLException | ClassNotFoundException ex)
                {
                    Logger.getLogger(frmBangDiem.class.getName()).log(Level.SEVERE, null, ex);
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

    private void cboMaSVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaSVItemStateChanged
        String masv = cboMaSV.getSelectedItem().toString();
        try
        {
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            allSinhVien = sinhVienDAO.getAll();
            for (SinhVien sv : allSinhVien)
            {
                if (masv.equals(sv.getMasv()))
                    txtHoTenSV.setText(sv.getHotensv());
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboMaSVItemStateChanged

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
    private javax.swing.JComboBox cboHeSo;
    private javax.swing.JComboBox cboLanThi;
    private javax.swing.JComboBox cboMaMH;
    private javax.swing.JComboBox cboMaSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton radTrangThai;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTenSV;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
