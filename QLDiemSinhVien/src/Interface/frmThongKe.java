package Interface;

import Proccess.Check;
import Proccess.BangDiem.BangDiem;
import Proccess.BangDiem.IBangDiemDAO;
import Proccess.GiangVien.GiangVien;
import Proccess.GiangVien.IGiangVienDAO;
import Proccess.Khoa.IKhoaDAO;
import Proccess.Khoa.Khoa;
import Proccess.Lop.ILopDAO;
import Proccess.Lop.Lop;
import Proccess.MonHoc.IMonHocDAO;
import Proccess.MonHoc.MonHoc;
import Proccess.SinhVien.SinhVien;
import Proccess.SinhVien.ISinhVienDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmThongKe extends javax.swing.JPanel
{
    private DefaultTableModel dtmLop;
    private DefaultTableModel dtmSinhVien;
    private DefaultTableModel dtmGiangVien;
    private DefaultTableModel dtmDiem;
    
    private DefaultComboBoxModel dcbmKhoa;
    private DefaultComboBoxModel dcbmLop;
    private DefaultComboBoxModel dcbmMonHoc;
    private DefaultComboBoxModel dcbmSinhVien;
    
    ArrayList<Khoa> allKhoa = null;
    ArrayList<Lop> allLop = null;
    ArrayList<MonHoc> allMonHoc = null;
    ArrayList<SinhVien> allSinhVien = null;

    public frmThongKe()
    {
        try
        {
            initComponents();
            dtmLop = new DefaultTableModel();
            dtmSinhVien = new DefaultTableModel();
            dtmGiangVien = new DefaultTableModel();
            dtmDiem = new DefaultTableModel();
            
            dcbmKhoa = new DefaultComboBoxModel();
            dcbmLop = new DefaultComboBoxModel();
            dcbmMonHoc = new DefaultComboBoxModel();
            dcbmSinhVien = new DefaultComboBoxModel();
            
            IKhoaDAO khoaDAO = (IKhoaDAO) Class.forName("Proccess.Khoa.KhoaDAO").newInstance();
            allKhoa = khoaDAO.getAll();
            for (Khoa khoa : allKhoa)
            {
                dcbmKhoa.addElement(khoa.getMakhoa());
            }
            cboMaKhoa.setModel(dcbmKhoa);
            
            ILopDAO lopDAO = (ILopDAO) Class.forName("Proccess.Lop.LopDAO").newInstance();
            allLop = lopDAO.getAll();
            for (Lop lop : allLop)
            {
                dcbmLop.addElement(lop.getMalop());
            }
            cboMaLop.setModel(dcbmLop);
            
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = monHocDAO.getAll();
            for (MonHoc mh : allMonHoc)
            {
                dcbmMonHoc.addElement(mh.getMamh());
            }
            cboMaMH.setModel(dcbmMonHoc);
            
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            allSinhVien = sinhVienDAO.getAll();
            for (SinhVien sv : allSinhVien)
            {
                dcbmSinhVien.addElement(sv.getMasv());
            }
            cboMaSV.setModel(dcbmSinhVien);

            // Danh sách lớp theo khoa
            dtmLop.addColumn("Mã lớp");
            dtmLop.addColumn("Tên lớp");           
            dtmLop.addColumn("Khóa học");
            dtmLop.addColumn("Mã khoa");
            tblLop_Khoa.setModel(dtmLop);

            // Danh sách sinh viên theo lớp
            dtmSinhVien.addColumn("Mã sinh viên");
            dtmSinhVien.addColumn("Họ tên");
            dtmSinhVien.addColumn("Hệ đào tạo");
            dtmSinhVien.addColumn("Giới tính");
            dtmSinhVien.addColumn("Ngày sinh");
            dtmSinhVien.addColumn("Địa chỉ");
            dtmSinhVien.addColumn("Số điện thoại");
            dtmSinhVien.addColumn("Mã lớp");
            tblSinhVien_Lop.setModel(dtmSinhVien);

            // Danh sách giảng viên theo môn học
            dtmGiangVien.addColumn("Mã giảng viên");
            dtmGiangVien.addColumn("Họ tên");
            dtmGiangVien.addColumn("Giới tính");
            dtmGiangVien.addColumn("Ngày sinh");
            dtmGiangVien.addColumn("Địa chỉ");          
            dtmGiangVien.addColumn("Email");           
            dtmGiangVien.addColumn("Số điện thoại");
            dtmGiangVien.addColumn("Mã môn học");
            tblGiangVien_MonHoc.setModel(dtmGiangVien);

            // Danh sách điểm theo sinh viên
            dtmDiem.addColumn("Mã sinh viên");
            dtmDiem.addColumn("Mã môn học");
            dtmDiem.addColumn("Lần thi");
            dtmDiem.addColumn("Hệ số");
            dtmDiem.addColumn("Điểm");
            dtmDiem.addColumn("Trạng thái");
            tblSinhVien_Lop.setModel(dtmDiem);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Object[] toObjectLop(Lop lop)
    {
        Object[] objectsData = {lop.getMalop(), lop.getTenlop(), lop.getKhoahoc(), lop.getMakhoa()};
        return objectsData;
    }
    
    private static Object[] toObjectSV(SinhVien sv)
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
    
    private static Object[] toObjectGV(GiangVien gv)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(gv.getNgaysinh());
        boolean flag = gv.isGioitinh();
        String gioitinh;
        if (flag == true)
            gioitinh = "Nam";
        else
            gioitinh = "Nữ";
        Object[] objectData = {gv.getMagv(), gv.getHotengv(), gioitinh, date, gv.getDiachi(), gv.getEmail(), gv.getSdt(), gv.getMamh()};
        return objectData;
    }
    
    public static Object[] toOjectDiem(BangDiem bd)
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLop_Khoa = new javax.swing.JTable();
        txtTenKhoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboMaKhoa = new javax.swing.JComboBox<>();
        txtSLLop = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSinhVien_Lop = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTenLop = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboMaLop = new javax.swing.JComboBox<>();
        txtSLSinhVien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGiangVien_MonHoc = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboMaMH = new javax.swing.JComboBox<>();
        txtSLGiangVien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDiem_SinhVien = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboMaSV = new javax.swing.JComboBox<>();

        jButton1.setText("jButton1");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblLop_Khoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblLop_Khoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lớp", "Tên lớp", "Khóa học", "Mã khoa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLop_Khoa.setRowHeight(25);
        jScrollPane2.setViewportView(tblLop_Khoa);

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

        txtTenKhoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenKhoa.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("Khoa");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        cboMaKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaKhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaKhoaItemStateChanged(evt);
            }
        });

        txtSLLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSLLop.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSLLop.setDisabledTextColor(new java.awt.Color(0, 51, 255));
        txtSLLop.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Số lượng lớp thuộc khoa");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSLLop, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cboMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSLLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addGap(11, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách Lớp theo Khoa", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblSinhVien_Lop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSinhVien_Lop.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSinhVien_Lop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSinhVien_Lop.setRowHeight(25);
        jScrollPane3.setViewportView(tblSinhVien_Lop);

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
        jLabel2.setText("Lớp");

        txtTenLop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenLop.setEnabled(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        cboMaLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaLopItemStateChanged(evt);
            }
        });

        txtSLSinhVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSLSinhVien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSLSinhVien.setDisabledTextColor(new java.awt.Color(0, 51, 255));
        txtSLSinhVien.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Số lượng sinh viên thuộc lớp");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenLop)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cboMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSLSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách Sinh viên theo Lớp", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblGiangVien_MonHoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblGiangVien_MonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGiangVien_MonHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblGiangVien_MonHoc.setRowHeight(25);
        jScrollPane4.setViewportView(tblGiangVien_MonHoc);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Môn học");

        txtTenMH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenMH.setEnabled(false);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        cboMaMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaMHItemStateChanged(evt);
            }
        });

        txtSLGiangVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSLGiangVien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSLGiangVien.setDisabledTextColor(new java.awt.Color(0, 51, 255));
        txtSLGiangVien.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Số lượng giảng viên dạy môn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtSLGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cboMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSLGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách Giảng viên theo Môn học", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 153)));

        tblDiem_SinhVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDiem_SinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDiem_SinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDiem_SinhVien.setRowHeight(25);
        jScrollPane5.setViewportView(tblDiem_SinhVien);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 153));
        jLabel10.setText("Sinh viên");

        txtTenSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenSV.setEnabled(false);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flower_2.png"))); // NOI18N

        cboMaSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMaSV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMaSVItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cboMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách Điểm theo Sinh viên", jPanel7);

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

    private void cboMaKhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaKhoaItemStateChanged
        String makhoa = cboMaKhoa.getSelectedItem().toString();
        while (dtmLop.getRowCount() > 0)
        {
            dtmLop.removeRow(0);
        }
        try
        {
            IKhoaDAO khoaDAO = (IKhoaDAO) Class.forName("Proccess.Khoa.KhoaDAO").newInstance();
            allKhoa = khoaDAO.getAll();
            for (Khoa khoa : allKhoa)
            {
                if (makhoa.equals(khoa.getMakhoa()))
                    txtTenKhoa.setText(khoa.getTenkhoa());
            }
            
            ILopDAO lopDAO = (ILopDAO) Class.forName("Proccess.Lop.LopDAO").newInstance();
            ArrayList<Lop> list = lopDAO.findByIDKhoa(makhoa);
            for (Lop lop : list)
            {
                dtmLop.addRow(toObjectLop(lop));
            }
            tblLop_Khoa.setModel(dtmLop);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sl = dtmLop.getRowCount();
        txtSLLop.setText(Integer.toString(sl));
    }//GEN-LAST:event_cboMaKhoaItemStateChanged

    private void cboMaLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaLopItemStateChanged
        String malop = cboMaLop.getSelectedItem().toString();
        while (dtmSinhVien.getRowCount() > 0)
        {
            dtmSinhVien.removeRow(0);
        }
        try
        {
            ILopDAO lopDAO = (ILopDAO) Class.forName("Proccess.Lop.LopDAO").newInstance();
            allLop = lopDAO.getAll();
            for (Lop lop : allLop)
            {
                if (malop.equals(lop.getMalop()))
                    txtTenLop.setText(lop.getTenlop());
            }
            
            ISinhVienDAO sinhVienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            ArrayList<SinhVien> list = sinhVienDAO.findByIDLop(malop);
            for (SinhVien sv : list)
            {
                dtmSinhVien.addRow(toObjectSV(sv));
            }
            tblSinhVien_Lop.setModel(dtmSinhVien);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sl = dtmSinhVien.getRowCount();
        txtSLSinhVien.setText(Integer.toString(sl));
    }//GEN-LAST:event_cboMaLopItemStateChanged

    private void cboMaMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaMHItemStateChanged
        String mamh = cboMaMH.getSelectedItem().toString();
        while (dtmGiangVien.getRowCount() > 0)
        {
            dtmGiangVien.removeRow(0);
        }
        try
        {
            IMonHocDAO monHocDAO = (IMonHocDAO) Class.forName("Proccess.MonHoc.MonHocDAO").newInstance();
            allMonHoc = monHocDAO.getAll();
            for (MonHoc mh : allMonHoc)
            {
                if (mamh.equals(mh.getMamh()))
                    txtTenMH.setText(mh.getTenmh());
            }
            
            IGiangVienDAO giangVienDAO = (IGiangVienDAO) Class.forName("Proccess.GiangVien.GiangVienDAO").newInstance();
            ArrayList<GiangVien> list = giangVienDAO.findByIDMonHoc(mamh);
            for (GiangVien gv : list)
            {
                dtmGiangVien.addRow(toObjectGV(gv));
            }
            tblGiangVien_MonHoc.setModel(dtmGiangVien);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sl = dtmGiangVien.getRowCount();
        txtSLGiangVien.setText(Integer.toString(sl));
    }//GEN-LAST:event_cboMaMHItemStateChanged

    private void cboMaSVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMaSVItemStateChanged
        String masv = cboMaSV.getSelectedItem().toString();
        while (dtmDiem.getRowCount() > 0)
        {
            dtmDiem.removeRow(0);
        }
        try
        {
            ISinhVienDAO sinhvienDAO = (ISinhVienDAO) Class.forName("Proccess.SinhVien.SinhVienDAO").newInstance();
            allSinhVien = sinhvienDAO.getAll();
            for (SinhVien sv : allSinhVien)
            {
                if (masv.equals(sv.getMasv()))
                    txtTenSV.setText(sv.getHotensv());
            }
            
            IBangDiemDAO bangDiemDAO = (IBangDiemDAO) Class.forName("Proccess.BangDiem.BangDiemDAO").newInstance();
            ArrayList<BangDiem> list = bangDiemDAO.findByIDSinhVien(masv);
            for (BangDiem bd : list)
            {
                dtmDiem.addRow(toOjectDiem(bd));
            }
            tblDiem_SinhVien.setModel(dtmDiem);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(frmLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboMaSVItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboMaKhoa;
    private javax.swing.JComboBox<String> cboMaLop;
    private javax.swing.JComboBox<String> cboMaMH;
    private javax.swing.JComboBox<String> cboMaSV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDiem_SinhVien;
    private javax.swing.JTable tblGiangVien_MonHoc;
    private javax.swing.JTable tblLop_Khoa;
    private javax.swing.JTable tblSinhVien_Lop;
    private javax.swing.JTextField txtSLGiangVien;
    private javax.swing.JTextField txtSLLop;
    private javax.swing.JTextField txtSLSinhVien;
    private javax.swing.JTextField txtTenKhoa;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTenMH;
    private javax.swing.JTextField txtTenSV;
    // End of variables declaration//GEN-END:variables
}
