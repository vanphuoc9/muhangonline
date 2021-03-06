/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muahangonline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class GUI_quanlyND extends javax.swing.JFrame {

    /**
     * Creates new form GUI_quanlyND
     */
    Vector col;
    private boolean isInsert = false;
    private boolean isUpdate = false;

    public GUI_quanlyND() {
        initComponents();
        initComboBoxPQ();
        initComboBoxXN();
        initComboBoxtimXN();
        initComboBoxtimQuyen();
    }

    public void initComboBoxPQ() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("admin");
        model.addElement("manager");
        cbpq.setModel(model);
    }

    public void initComboBoxXN() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("yes");
        model.addElement("no");
        cbxn.setModel(model);
    }

    public void initComboBoxtimXN() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("none");
        model.addElement("yes");
        model.addElement("no");
        cbtimxn.setModel(model);
    }

    public void initComboBoxtimQuyen() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("none");
        model.addElement("admin");
        model.addElement("manager");
        cbtimquyen.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableqt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ten_nd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_matkhau_nd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt_nd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxn = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbpq = new javax.swing.JComboBox<>();
        btn_them_nd = new javax.swing.JButton();
        btn_sua_nd = new javax.swing.JButton();
        btn_xoa_nd = new javax.swing.JButton();
        btn_luu_nd = new javax.swing.JButton();
        btn_xem_ds = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbtimxn = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbtimquyen = new javax.swing.JComboBox<>();
        btntim = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Quản Trị người dùng");

        tableqt.setModel(new javax.swing.table.DefaultTableModel(
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
        tableqt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableqtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableqt);

        jLabel1.setText("Danh sách");

        jLabel2.setText("Nhập thông tin người dùng");

        jLabel3.setText("Tên người dùng");

        jLabel4.setText("Mật khẩu");

        jLabel5.setText("SĐT");

        jLabel6.setText("Xác nhận TK");

        jLabel7.setText("Phân quyền");

        btn_them_nd.setText("Thêm");
        btn_them_nd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them_ndActionPerformed(evt);
            }
        });

        btn_sua_nd.setText("Sửa");
        btn_sua_nd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua_ndActionPerformed(evt);
            }
        });

        btn_xoa_nd.setText("Xóa");
        btn_xoa_nd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa_ndActionPerformed(evt);
            }
        });

        btn_luu_nd.setText("Lưu");
        btn_luu_nd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luu_ndActionPerformed(evt);
            }
        });

        btn_xem_ds.setText("Xem DS");
        btn_xem_ds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xem_dsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbpq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_ten_nd)
                                .addComponent(txt_matkhau_nd)
                                .addComponent(txt_sdt_nd, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_sua_nd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_xoa_nd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_them_nd)
                                .addGap(18, 18, 18)
                                .addComponent(btn_luu_nd, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_xem_ds)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ten_nd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_matkhau_nd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_sdt_nd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbpq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sua_nd)
                    .addComponent(btn_xoa_nd))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_luu_nd)
                    .addComponent(btn_xem_ds)
                    .addComponent(btn_them_nd))
                .addGap(21, 21, 21))
        );

        jLabel8.setText("Tìm kiếm");

        jLabel9.setText("Tình trạng XN");

        jLabel10.setText("Quyền hạng");

        btntim.setText("Tìm");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbtimquyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtimxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btntim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbtimxn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btntim)
                    .addComponent(cbtimquyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableqtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableqtMouseClicked
        // TODO add your handling code here:
        int row = tableqt.getSelectedRow();
        txt_ten_nd.setText(tableqt.getValueAt(row, 1).toString());
        txt_matkhau_nd.setText(tableqt.getValueAt(row, 2).toString());
        txt_sdt_nd.setText(tableqt.getValueAt(row, 3).toString());
        String xacnhan = tableqt.getValueAt(row, 4).toString();
        String quyenhang = tableqt.getValueAt(row, 5).toString();
        if (xacnhan.equals("yes")) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("yes");
            model.addElement("no");
            cbxn.setModel(model);
        } else {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("no");
            model.addElement("yes");
            cbxn.setModel(model);
        }
        if (quyenhang.equals("admin")) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("admin");
            model.addElement("manager");
            cbpq.setModel(model);
        } else {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("manager");
            model.addElement("admin");
            cbpq.setModel(model);
        }
    }//GEN-LAST:event_tableqtMouseClicked

    private void btn_xem_dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xem_dsActionPerformed
        // TODO add your handling code here:
        layND();
    }//GEN-LAST:event_btn_xem_dsActionPerformed

    private void btn_xoa_ndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa_ndActionPerformed
        // TODO add your handling code here:
        btn_them_nd.setEnabled(true);
        btn_sua_nd.setEnabled(true);

        try {
            int row = tableqt.getSelectedRow();
            int id = Integer.parseInt(tableqt.getValueAt(row, 0).toString());
            int y = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Xóa sản phẩm", JOptionPane.YES_NO_OPTION);
            if (y == JOptionPane.YES_OPTION) {

                try {
                    MyConnect pt = new MyConnect();
                    pt.connect();
                    pt.xoaND(id);
                    pt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Lỗi", "Lỗi xóa", 1);
                }

                txt_ten_nd.setText("");
                txt_matkhau_nd.setText("");
                txt_sdt_nd.setText("");
                initComboBoxPQ();
                initComboBoxXN();
                layND();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn để xóa", "Lỗi xóa", 1);
        }


    }//GEN-LAST:event_btn_xoa_ndActionPerformed

    private void btn_them_ndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them_ndActionPerformed
        // TODO add your handling code here:
        isInsert = true;
        isUpdate = false;
        btn_them_nd.setEnabled(false);
        btn_sua_nd.setEnabled(true);
    }//GEN-LAST:event_btn_them_ndActionPerformed

    private void btn_sua_ndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua_ndActionPerformed
        // TODO add your handling code here:
        isUpdate = true;
        isInsert = false;
        btn_them_nd.setEnabled(true);
        btn_sua_nd.setEnabled(false);
    }//GEN-LAST:event_btn_sua_ndActionPerformed

    private void btn_luu_ndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luu_ndActionPerformed
        // TODO add your handling code here:
        btn_them_nd.setEnabled(true);
        btn_sua_nd.setEnabled(true);
        String kiemtraSDT = "0[0-9]{9,10}"; // đây là biểu thức chính quy 
        String ten = txt_ten_nd.getText().toString();
        String mk = txt_matkhau_nd.getText().toString();
        String sdt = txt_sdt_nd.getText().toString();
        String xn = cbxn.getSelectedItem().toString();
        String phanquyen = cbpq.getSelectedItem().toString();

        if (isInsert == true) {
            if (ten.equals("") || mk.equals("") || sdt.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Error", 2);
            } else {
                if(sdt.matches(kiemtraSDT)){
                    try {
                        boolean tontai = false;
                        MyConnect pt = new MyConnect();
                        pt.connect();
                        //ResultSet r = pt.themND(ten, mk, sdt, xacnhan(xn), phanquyen);
                        ResultSet rs = pt.getDataND();
                        while (rs.next()) {
                            // nếu có đã có tên khách hàng thì tontai = true thoát ra vòng lập
                            if (ten.equals(rs.getString("tenkh"))) {
                                tontai = true;
                                break;
                            }
                        }
                        if (tontai) {
                            JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại", "Lỗi đăng ký", 2);

                        } else {
                            // thêm khách hàng vào csdl
                            pt.themND(ten, mk, sdt, xacnhan(xn), phanquyen);
                            // cho dialog xuất hiện thông báo
                            JOptionPane.showMessageDialog(this, "Thêm thành công", "Thêm", 1);
                        }
                        pt.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    layND();
                }else{
                 JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra số điện thoại", "Lỗi ", 1);
                }
           }
        }
        if (isUpdate == true) {
            int row = tableqt.getSelectedRow();
            int idsp = Integer.parseInt(tableqt.getValueAt(row, 0).toString());
            //JOptionPane.showMessageDialog(this, "Sửa thành công", "Error", 1);
            try {
                MyConnect pt = new MyConnect();
                pt.connect();
                pt.capND(idsp, ten, mk, sdt, xacnhan(xn), phanquyen);
                pt.close();
            } catch (SQLException ex) {
                Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
            }
            layND();
        }

        isInsert = false;
        isUpdate = false;
    }//GEN-LAST:event_btn_luu_ndActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        // TODO add your handling code here:

        String xn = cbtimxn.getSelectedItem().toString();
        String phanquyen = cbtimquyen.getSelectedItem().toString();
        col = new Vector();
        col.addElement("Mã ND");
        col.addElement("Tên ND");
        col.addElement("Mật khẩu");
        col.addElement("Số ĐT");
        col.addElement("Tình trạng XN");
        col.addElement("Quyền hạn");

        if (!xn.equals("none")) {
            MyConnect pt = new MyConnect();
            pt.connect();
            ResultSet rs = pt.timXacNhan(xacnhan(xn));
            Vector data = new Vector();

            try {
                while (rs.next()) {
                    Vector nguoidung = new Vector();
                    nguoidung.addElement(rs.getInt("idkh"));
                    nguoidung.addElement(rs.getString("tenkh"));
                    nguoidung.addElement(rs.getString("matkhau"));
                    nguoidung.addElement(rs.getString("sodienthoai"));
                    nguoidung.addElement(rs.getString("xacnhan(idkh)"));
                    nguoidung.addElement(rs.getString("phanquyen"));
                    data.addElement(nguoidung);
                }
                tableqt.setModel(new DefaultTableModel(data, col));

            } catch (SQLException ex) {
                Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!phanquyen.equals("none")) {
            MyConnect pt = new MyConnect();
            pt.connect();
            ResultSet rs = pt.timPhanQuyen(phanquyen);
            Vector data = new Vector();

            try {
                while (rs.next()) {
                    Vector nguoidung = new Vector();
                    nguoidung.addElement(rs.getInt("idkh"));
                    nguoidung.addElement(rs.getString("tenkh"));
                    nguoidung.addElement(rs.getString("matkhau"));
                    nguoidung.addElement(rs.getString("sodienthoai"));
                    nguoidung.addElement(rs.getString("xacnhan(idkh)"));
                    nguoidung.addElement(rs.getString("phanquyen"));
                    data.addElement(nguoidung);
                }
                tableqt.setModel(new DefaultTableModel(data, col));

            } catch (SQLException ex) {
                Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!xn.equals("none") && !phanquyen.equals("none")) {
            MyConnect pt = new MyConnect();
            pt.connect();
            ResultSet rs = pt.timND(xacnhan(xn), phanquyen);
            Vector data = new Vector();

            try {
                while (rs.next()) {
                    Vector nguoidung = new Vector();
                    nguoidung.addElement(rs.getInt("idkh"));
                    nguoidung.addElement(rs.getString("tenkh"));
                    nguoidung.addElement(rs.getString("matkhau"));
                    nguoidung.addElement(rs.getString("sodienthoai"));
                    nguoidung.addElement(rs.getString("xacnhan(idkh)"));
                    nguoidung.addElement(rs.getString("phanquyen"));
                    data.addElement(nguoidung);
                }
                tableqt.setModel(new DefaultTableModel(data, col));

            } catch (SQLException ex) {
                Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btntimActionPerformed
    public int xacnhan(String xacnhan) {
        if (xacnhan.equals("yes")) {
            return 1;
        }
        return 0;
    }

    public void layND() {
        col = new Vector();
        col.addElement("Mã ND");
        col.addElement("Tên ND");
        col.addElement("Mật khẩu");
        col.addElement("Số ĐT");
        col.addElement("Tình trạng XN");
        col.addElement("Quyền hạn");
        MyConnect pt = new MyConnect();
        pt.connect();
        ResultSet rs = pt.getND();
        Vector data = new Vector();
        try {
            while (rs.next()) {
                Vector nguoidung = new Vector();
                nguoidung.addElement(rs.getInt("idkh"));
                nguoidung.addElement(rs.getString("tenkh"));
                nguoidung.addElement(rs.getString("matkhau"));
                nguoidung.addElement(rs.getString("sodienthoai"));
                nguoidung.addElement(rs.getString("xacnhan(idkh)"));
                nguoidung.addElement(rs.getString("phanquyen"));
                data.addElement(nguoidung);
            }
            tableqt.setModel(new DefaultTableModel(data, col));

        } catch (SQLException ex) {
            Logger.getLogger(GUI_muahang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(GUI_quanlyND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_quanlyND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_quanlyND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_quanlyND.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                GUI_quanlyND nd = new GUI_quanlyND();
                nd.setVisible(true);
                nd.setLocationRelativeTo(null);
                nd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nd.layND();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu_nd;
    private javax.swing.JButton btn_sua_nd;
    private javax.swing.JButton btn_them_nd;
    private javax.swing.JButton btn_xem_ds;
    private javax.swing.JButton btn_xoa_nd;
    private javax.swing.JButton btntim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbpq;
    private javax.swing.JComboBox<String> cbtimquyen;
    private javax.swing.JComboBox<String> cbtimxn;
    private javax.swing.JComboBox<String> cbxn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableqt;
    private javax.swing.JTextField txt_matkhau_nd;
    private javax.swing.JTextField txt_sdt_nd;
    private javax.swing.JTextField txt_ten_nd;
    // End of variables declaration//GEN-END:variables
}
