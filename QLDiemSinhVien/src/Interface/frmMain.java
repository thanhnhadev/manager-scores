package Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JFrame;

public class frmMain extends javax.swing.JFrame
{
    public static String nameLogin;
    private final Date today = new Date();
    Locale local = new Locale("vi", "VI");
    DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, local);
    String date = d.format(today);

    public frmMain()
    {
        initComponents();
        setUser();

        Timer dongho = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                Calendar lich = Calendar.getInstance();
                int gio = lich.get(Calendar.HOUR);
                int phut = lich.get(Calendar.MINUTE);
                int giay = lich.get(Calendar.SECOND);
                txtCurrent.setText(" " + gio + " : " + phut + " : " + giay);
            }
        });
        dongho.start();
    }

    private void setUser()
    {
        nameLogin = frmLogin.nameLogin;
        lblUser.setText(nameLogin);
        lblToday.setText(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSinhVien = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnGiangVien = new javax.swing.JButton();
        btnBangDiem = new javax.swing.JButton();
        btnLop = new javax.swing.JButton();
        btnMonHoc = new javax.swing.JButton();
        btnTinhDiemTB = new javax.swing.JButton();
        btnKhoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel()

        ;
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblToday = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCurrent = new javax.swing.JTextField();
        jtpContent = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src/Images/background.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuHeThong = new javax.swing.JMenu();
        itemTrangchu = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemDangxuat = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        itemThoat = new javax.swing.JMenuItem();
        menuQuanLy = new javax.swing.JMenu();
        itemKhoa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemLop = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemSinhVien = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemMonHoc = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemGiangVien = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemDiem = new javax.swing.JMenuItem();
        menuTimKiem = new javax.swing.JMenu();
        menuThongKe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ ĐIỂM SINH VIÊN - MAI PHƯƠNG 1515060039 - KIM NGÂN 1515060085");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        btnSinhVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSinhVien.setForeground(new java.awt.Color(255, 0, 153));
        btnSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnSinhVien.setText("Sinh viên");
        btnSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSinhVien.setDefaultCapable(false);
        btnSinhVien.setHideActionText(true);
        btnSinhVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSinhVien.setIconTextGap(10);
        btnSinhVien.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnSinhVien.setPreferredSize(new java.awt.Dimension(151, 33));
        btnSinhVien.setSelected(true);
        btnSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinhVienActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hippo.png"))); // NOI18N
        jLabel6.setText("QUẢN LÝ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGiangVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGiangVien.setForeground(new java.awt.Color(255, 0, 153));
        btnGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnGiangVien.setText("Giảng viên");
        btnGiangVien.setDefaultCapable(false);
        btnGiangVien.setHideActionText(true);
        btnGiangVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGiangVien.setIconTextGap(10);
        btnGiangVien.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnGiangVien.setPreferredSize(new java.awt.Dimension(151, 33));
        btnGiangVien.setSelected(true);
        btnGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiangVienActionPerformed(evt);
            }
        });

        btnBangDiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBangDiem.setForeground(new java.awt.Color(255, 0, 153));
        btnBangDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnBangDiem.setText("Bảng điểm");
        btnBangDiem.setDefaultCapable(false);
        btnBangDiem.setHideActionText(true);
        btnBangDiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBangDiem.setIconTextGap(10);
        btnBangDiem.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnBangDiem.setPreferredSize(new java.awt.Dimension(151, 33));
        btnBangDiem.setSelected(true);
        btnBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangDiemActionPerformed(evt);
            }
        });

        btnLop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLop.setForeground(new java.awt.Color(255, 0, 153));
        btnLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnLop.setText("Lớp");
        btnLop.setDefaultCapable(false);
        btnLop.setHideActionText(true);
        btnLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLop.setIconTextGap(10);
        btnLop.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnLop.setPreferredSize(new java.awt.Dimension(151, 33));
        btnLop.setSelected(true);
        btnLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopActionPerformed(evt);
            }
        });

        btnMonHoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMonHoc.setForeground(new java.awt.Color(255, 0, 153));
        btnMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnMonHoc.setText("Môn học");
        btnMonHoc.setDefaultCapable(false);
        btnMonHoc.setHideActionText(true);
        btnMonHoc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMonHoc.setIconTextGap(10);
        btnMonHoc.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnMonHoc.setPreferredSize(new java.awt.Dimension(151, 33));
        btnMonHoc.setSelected(true);
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        btnTinhDiemTB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTinhDiemTB.setForeground(new java.awt.Color(255, 0, 153));
        btnTinhDiemTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/calculator.png"))); // NOI18N
        btnTinhDiemTB.setText("Tính điểm trung bình");
        btnTinhDiemTB.setDefaultCapable(false);
        btnTinhDiemTB.setHideActionText(true);
        btnTinhDiemTB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTinhDiemTB.setIconTextGap(10);
        btnTinhDiemTB.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnTinhDiemTB.setPreferredSize(new java.awt.Dimension(151, 33));
        btnTinhDiemTB.setSelected(true);
        btnTinhDiemTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhDiemTBActionPerformed(evt);
            }
        });

        btnKhoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKhoa.setForeground(new java.awt.Color(255, 0, 153));
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/muiten.png"))); // NOI18N
        btnKhoa.setText("Khoa");
        btnKhoa.setDefaultCapable(false);
        btnKhoa.setHideActionText(true);
        btnKhoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKhoa.setIconTextGap(10);
        btnKhoa.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnKhoa.setPreferredSize(new java.awt.Dimension(151, 33));
        btnKhoa.setSelected(true);
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 0, 153));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setDefaultCapable(false);
        btnTimKiem.setHideActionText(true);
        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTimKiem.setIconTextGap(10);
        btnTimKiem.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(151, 33));
        btnTimKiem.setSelected(true);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/butterfly.png"))); // NOI18N
        jLabel10.setText(" THAO TÁC");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 0, 153));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setDefaultCapable(false);
        btnThongKe.setHideActionText(true);
        btnThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThongKe.setIconTextGap(10);
        btnThongKe.setMargin(new java.awt.Insets(1, 14, 2, 14));
        btnThongKe.setPreferredSize(new java.awt.Dimension(151, 33));
        btnThongKe.setSelected(true);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSinhVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBangDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTinhDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGiangVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBangDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTinhDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ĐỒ ÁN MÔN HỌC");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CHUYÊN ĐỀ 1 CÔNG NGHỆ PHẦN MỀM - LẬP TRÌNH JAVA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 153));
        jLabel2.setText("Người dùng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 153));
        jLabel3.setText("Ngày:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clockGraphic.png"))); // NOI18N

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 0, 0));

        lblToday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblToday.setText("Hour");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 153));
        jLabel5.setText("Giờ:");

        txtCurrent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCurrent.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblToday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpContent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtpContent.setMinimumSize(new java.awt.Dimension(33, 28));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHẦN MỀM QUẢN LÝ ĐIỂM SINH VIÊN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("SINH VIÊN THỰC HIỆN:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("1.  Nguyễn Ngọc Mai Phương        MSSV: 1515060039");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("2.  Trần Thị Kim Ngân                     MSSV: 1515060085");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)))
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addGap(39, 39, 39))
        );

        jtpContent.addTab("Hệ thống", jPanel6);

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)));
        jMenuBar2.setPreferredSize(new java.awt.Dimension(391, 40));

        menuHeThong.setBackground(new java.awt.Color(204, 204, 255));
        menuHeThong.setForeground(new java.awt.Color(255, 0, 153));
        menuHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-login.png"))); // NOI18N
        menuHeThong.setText("  HỆ THỐNG");
        menuHeThong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuHeThong.setPreferredSize(new java.awt.Dimension(160, 20));

        itemTrangchu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_HOME, 0));
        itemTrangchu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemTrangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house.png"))); // NOI18N
        itemTrangchu.setText("Trang chủ");
        itemTrangchu.setPreferredSize(new java.awt.Dimension(160, 30));
        itemTrangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTrangchuActionPerformed(evt);
            }
        });
        menuHeThong.add(itemTrangchu);
        menuHeThong.add(jSeparator7);

        itemDangxuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        itemDangxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemDangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit3.png"))); // NOI18N
        itemDangxuat.setText("Đăng xuất");
        itemDangxuat.setPreferredSize(new java.awt.Dimension(160, 30));
        itemDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDangxuatActionPerformed(evt);
            }
        });
        menuHeThong.add(itemDangxuat);
        menuHeThong.add(jSeparator6);

        itemThoat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        itemThoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit2.png"))); // NOI18N
        itemThoat.setText("Thoát                     ");
        itemThoat.setPreferredSize(new java.awt.Dimension(160, 30));
        itemThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemThoatActionPerformed(evt);
            }
        });
        menuHeThong.add(itemThoat);

        jMenuBar2.add(menuHeThong);

        menuQuanLy.setForeground(new java.awt.Color(255, 0, 153));
        menuQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        menuQuanLy.setText("  QUẢN LÝ");
        menuQuanLy.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuQuanLy.setPreferredSize(new java.awt.Dimension(160, 20));

        itemKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemKhoa.setText("Khoa");
        itemKhoa.setPreferredSize(new java.awt.Dimension(160, 30));
        itemKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKhoaActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemKhoa);
        menuQuanLy.add(jSeparator1);

        itemLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemLop.setText("Lớp");
        itemLop.setPreferredSize(new java.awt.Dimension(160, 30));
        itemLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLopActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemLop);
        menuQuanLy.add(jSeparator2);

        itemSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemSinhVien.setText("Sinh viên");
        itemSinhVien.setPreferredSize(new java.awt.Dimension(160, 30));
        itemSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSinhVienActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemSinhVien);
        menuQuanLy.add(jSeparator3);

        itemMonHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemMonHoc.setText("Môn học");
        itemMonHoc.setPreferredSize(new java.awt.Dimension(160, 30));
        itemMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMonHocActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemMonHoc);
        menuQuanLy.add(jSeparator4);

        itemGiangVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemGiangVien.setText("Giảng viên");
        itemGiangVien.setPreferredSize(new java.awt.Dimension(160, 30));
        itemGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGiangVienActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemGiangVien);
        menuQuanLy.add(jSeparator5);

        itemDiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thaotac.png"))); // NOI18N
        itemDiem.setText("Bảng điểm");
        itemDiem.setPreferredSize(new java.awt.Dimension(160, 30));
        itemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDiemActionPerformed(evt);
            }
        });
        menuQuanLy.add(itemDiem);

        jMenuBar2.add(menuQuanLy);

        menuTimKiem.setForeground(new java.awt.Color(255, 0, 153));
        menuTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-2.png"))); // NOI18N
        menuTimKiem.setText("  TÌM KIẾM");
        menuTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuTimKiem.setPreferredSize(new java.awt.Dimension(160, 20));
        menuTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTimKiemMouseClicked(evt);
            }
        });
        jMenuBar2.add(menuTimKiem);

        menuThongKe.setForeground(new java.awt.Color(255, 0, 153));
        menuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N
        menuThongKe.setText("  THỐNG KÊ");
        menuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuThongKe.setPreferredSize(new java.awt.Dimension(160, 20));
        menuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThongKeMouseClicked(evt);
            }
        });
        jMenuBar2.add(menuThongKe);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtpContent.getAccessibleContext().setAccessibleName("Main");

        setSize(new java.awt.Dimension(1200, 708));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDangxuatActionPerformed
        dispose();
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_itemDangxuatActionPerformed

    private void itemThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemThoatActionPerformed

    private void itemKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKhoaActionPerformed
        frmKhoa khoa = new frmKhoa();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Khoa", khoa);
    }//GEN-LAST:event_itemKhoaActionPerformed

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        frmKhoa khoa = new frmKhoa();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Khoa", khoa);
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void itemLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLopActionPerformed
        frmLop lop = new frmLop();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Lớp", lop);
    }//GEN-LAST:event_itemLopActionPerformed

    private void btnLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopActionPerformed
        frmLop lop = new frmLop();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Lớp", lop);
    }//GEN-LAST:event_btnLopActionPerformed

    private void itemSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSinhVienActionPerformed
        frmSinhVien sinhvien = new frmSinhVien();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Sinh Viên", sinhvien);
    }//GEN-LAST:event_itemSinhVienActionPerformed

    private void btnSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinhVienActionPerformed
        frmSinhVien sinhvien = new frmSinhVien();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Sinh Viên", sinhvien);
    }//GEN-LAST:event_btnSinhVienActionPerformed

    private void itemMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMonHocActionPerformed
        frmMonHoc monhoc = new frmMonHoc();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Môn Học", monhoc);
    }//GEN-LAST:event_itemMonHocActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed
        frmMonHoc monhoc = new frmMonHoc();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Môn Học", monhoc);
    }//GEN-LAST:event_btnMonHocActionPerformed

    private void itemGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGiangVienActionPerformed
        frmGiangVien giangvien = new frmGiangVien();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Giảng Viên", giangvien);
    }//GEN-LAST:event_itemGiangVienActionPerformed

    private void btnGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiangVienActionPerformed
        frmGiangVien giangvien = new frmGiangVien();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Giảng Viên", giangvien);
    }//GEN-LAST:event_btnGiangVienActionPerformed

    private void itemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDiemActionPerformed
        frmBangDiem bangdiem = new frmBangDiem();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Điểm", bangdiem);
    }//GEN-LAST:event_itemDiemActionPerformed

    private void btnBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangDiemActionPerformed
        frmBangDiem bangdiem = new frmBangDiem();
        jtpContent.removeAll();
        jtpContent.add("Thông Tin Điểm", bangdiem);
    }//GEN-LAST:event_btnBangDiemActionPerformed

    private void btnTinhDiemTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhDiemTBActionPerformed
        frmTinhDiem tinhdiem = new frmTinhDiem();
        jtpContent.removeAll();
        jtpContent.add("Tính Điểm Trung Bình", tinhdiem);
    }//GEN-LAST:event_btnTinhDiemTBActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        frmTimKiem timkiem = new frmTimKiem();
        jtpContent.removeAll();
        jtpContent.add("Tìm Kiếm", timkiem);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void menuTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTimKiemMouseClicked
        frmTimKiem timkiem = new frmTimKiem();
        jtpContent.removeAll();
        jtpContent.add("Tìm Kiếm", timkiem);
    }//GEN-LAST:event_menuTimKiemMouseClicked

    private void itemTrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTrangchuActionPerformed
        new frmMain().setVisible(true);
    }//GEN-LAST:event_itemTrangchuActionPerformed

    private void menuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseClicked
        frmThongKe thongke = new frmThongKe();
        jtpContent.removeAll();
        jtpContent.add("Thống Kê", thongke);
    }//GEN-LAST:event_menuThongKeMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        frmThongKe thongke = new frmThongKe();
        jtpContent.removeAll();
        jtpContent.add("Thống Kê", thongke);
    }//GEN-LAST:event_btnThongKeActionPerformed

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBangDiem;
    private javax.swing.JButton btnGiangVien;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnLop;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSinhVien;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTinhDiemTB;
    private javax.swing.JMenuItem itemDangxuat;
    private javax.swing.JMenuItem itemDiem;
    private javax.swing.JMenuItem itemGiangVien;
    private javax.swing.JMenuItem itemKhoa;
    private javax.swing.JMenuItem itemLop;
    private javax.swing.JMenuItem itemMonHoc;
    private javax.swing.JMenuItem itemSinhVien;
    private javax.swing.JMenuItem itemThoat;
    private javax.swing.JMenuItem itemTrangchu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JTabbedPane jtpContent;
    private javax.swing.JLabel lblToday;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenu menuHeThong;
    private javax.swing.JMenu menuQuanLy;
    private javax.swing.JMenu menuThongKe;
    private javax.swing.JMenu menuTimKiem;
    private javax.swing.JTextField txtCurrent;
    // End of variables declaration//GEN-END:variables
}
