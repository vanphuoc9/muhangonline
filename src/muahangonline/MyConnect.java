/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muahangonline;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeFunction.call;

public class MyConnect {

    private Connection conn = null;
    private String user = "root";
    private String pass = "";
    private String tableSP = "sanpham";
    private String tableND = "nguoidung";

    // ============ HÀM XỬ LÝ KẾT NỐI VỚI MYSQL 
    public void connect() {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/muahang", user, pass);

            System.out.println("Noi ket thanh cong");
        } catch (Exception ex) {
            System.out.println("Noi ket khong thanh cong");
            ex.printStackTrace();
        }
    }
    // CÁC HÀM XỬ LÝ CHO BẢNG SẢM PHẨM  

    public ResultSet getDataSP() {
        ResultSet rs = null;
        String myCommand = "select * from " + tableSP;
        Statement st;
        try {
            st = conn.createStatement();
            // lấy dữ liệu
            rs = st.executeQuery(myCommand);
        } catch (SQLException ex) {
            System.out.println("select error\n" + ex.toString());
        }

        return rs;
    }

    // lấy dữ liệu theo idsp
    public ResultSet getDataIdSP(String idsp) {
        ResultSet rs = null;
        String myCommand = "select * from " + tableSP + " where idsp = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            // set cho dấu hỏi thứ 1
            pst.setString(1, idsp);
            rs = pst.executeQuery();
        } catch (SQLException ex) {

        }
        return rs;

    }
    // show dữ liệu

    public void showDataSP(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("idsp") + " "
                        + rs.getString("tensp") + " "
                        + rs.getFloat("giasp") + " "
                        + rs.getString("tenloaisanpham"));
            }
        } catch (SQLException ex) {

        }
    }

    //  Thêm dữ liệu vào bảng sản phẩm
//    private void insertData(String idsp, String tensp, float giasp, String idloaisp ){
//        String myCommand ="insert into "+ table +" values(?,?,?,?)";
//        PreparedStatement pst = null;
//        try {
//            pst = conn.prepareStatement(myCommand);
//            pst.setString(1, idsp);
//            pst.setString(2,tensp);
//            pst.setFloat(3,giasp);
//            pst.setString(4, idloaisp);
//            pst.executeUpdate(); // thực thi trả kết quả về rs
//        } catch (SQLException ex) {
//     
//        }
//        
//    }
    //Thêm dữ liệu vào bảng sản phẩm
    public void insertDataSP(sanpham sp) {
        String myCommand = "insert into " + tableSP + " values(?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            pst.setInt(1, sp.getIdsp());
            pst.setString(2, sp.getTensp());
            pst.setFloat(3, sp.getGiasp());
            pst.setString(4, sp.getIdloaisp());
            if (pst.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            } else {
                System.out.println("Thêm không thành công");
            }
        } catch (SQLException ex) {
            System.out.println("Thêm không thành công");

        }

    }

    // xóa dữ liệu theo id sản phẩm
    public void deleteIdSP(int idsp) {
        String myCommand = "delete from " + tableSP + " where idsp = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            pst.setInt(1, idsp);
            // nếu id có trong CSDL thì xóa nó
            // ngược lại báo lỗi
            if (pst.executeUpdate() > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa không thành công");
            }
        } catch (SQLException ex) {
            System.out.println("Xóa không thành công");
        }
    }

    //Cập dữ liệu vào bảng sản phẩm
    public void updateIdSP(sanpham sp) {
        String myCommand = "update " + tableSP
                + " set tensp = ?, giasp = ?, idloaisp = ? where idsp = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            pst.setString(1, sp.getTensp());
            pst.setFloat(2, sp.getGiasp());
            pst.setString(3, sp.getIdloaisp());
            pst.setInt(4, sp.getIdsp());
            if (pst.executeUpdate() > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Cập nhật không thành công");
            }
        } catch (SQLException ex) {
            System.out.println("Cập nhật không thành công");

        }

    }

    public void close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }

    //======================== CAC HAM THU TUC CUA SAM PHAM ============================
    // get dl san pham theo ham thu tuc 
    public ResultSet getSP() {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call b_sanpham()}");
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    // Them san pham theo ham thu tuc
    public ResultSet themSP(String tensp, int giasp, String loaisp) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call themSP(?,?,?)}");
            cs.setString(1, tensp);
            cs.setInt(2, giasp);
            cs.setString(3, loaisp);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    // Tim kiem san pham theo ma san pham
    public ResultSet timMaSP(int masp) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timMaSP(?)}");
            cs.setInt(1, masp);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // tìm các sản phẩm theo tên
    public ResultSet timTenSP(String tensp) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timTenSP(?)}");
            cs.setString(1, tensp);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    // Tìm các sản phẩm theo loại sản phẩm

    public ResultSet timTenLoaiSP(String tenloaisp) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timTenLoaiSP(?)}");
            cs.setString(1, tenloaisp);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    // Cập nhật sản phẩm theo idsp

    public void capnhapSP(int idsp, String tensp, int giasp, String tenloaisp) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call capnhatSP(?,?,?,?)}");
            cs.setInt(1, idsp);
            cs.setString(2, tensp);
            cs.setInt(3, giasp);
            cs.setString(4, tenloaisp);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ==============================================================================
    // ==================== CÁC Hàm Xử Lý Cho Bảng Loại ================
    // Get loại sản phẩm
    public ResultSet getLoaiSP() {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call b_loaiSP()}");
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet timMaLoaiSP(int maloai) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timIdLoai(?)}");
            cs.setInt(1, maloai);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // tìm các sản phẩm theo tên
    public ResultSet timTheoTenLoaiSP(String tenloai) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timTenLoai(?)}");
            cs.setString(1, tenloai);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // Thêm loại sản phẩm
    public ResultSet themLoaiSP(String tenloai) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call themLoai(?)}");
            cs.setString(1, tenloai);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // Cập nhật loại sp
    public void capnhapLoaiSP(int idloai, String tenloai) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call capnhatLoai(?,?)}");
            cs.setInt(1, idloai);
            cs.setString(2, tenloai);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Xóa loại sản phẩm
    public void xoaLoaiSP(int idloai) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call xoaloaisp(?)}");
            cs.setInt(1, idloai);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // -==================== CÁC HÀM XỬ LÝ CHO NGƯỜI DÙNG TÀI KHOẢN =============
    // get dl 
    public ResultSet getDataND() {
        ResultSet rs = null;
        String myCommand = "select * from " + tableND;
        Statement st;
        try {
            st = conn.createStatement();
            // lấy dữ liệu
            rs = st.executeQuery(myCommand);
        } catch (SQLException ex) {
            System.out.println("select error\n" + ex.toString());
        }

        return rs;
    }
    
    // GET DL từ username, pass
    public ResultSet getDataND(String tenkh, String matkhau, int xacnhan, String phanquyen) {
        ResultSet rs = null;
        String myCommand = "select * from " + tableND + " where tenkh = ? and matkhau = ? and xacnhan = ? and phanquyen = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            // set cho dấu hỏi thứ 1
            pst.setString(1, tenkh);
            pst.setString(2, matkhau);
            pst.setInt(3, xacnhan);
            pst.setString(4, phanquyen);
            rs = pst.executeQuery();
        } catch (SQLException ex) {

        }
        return rs;

    }
    //Thêm dữ liệu vào bảng nguoi dung

    public void insertDataND(String tenkh, String matkhau, String sodienthoai, int xacnhan, String phanquyen) {
        String myCommand = "insert into " + tableND + " (tenkh,matkhau,sodienthoai,xacnhan,phanquyen)" + " values(?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(myCommand);
            pst.setString(1, tenkh);
            pst.setString(2, matkhau);
            pst.setString(3, sodienthoai);
            pst.setInt(4, xacnhan);
            pst.setString(5, phanquyen);
            if (pst.executeUpdate() > 0) {
                System.out.println("Thêm thành công");
            } else {
                System.out.println("Thêm không thành công");
            }
        } catch (SQLException ex) {
            System.out.println("Thêm không thành công");

        }

    }
// //////////////////////// CÁC HÀM XỬ LÝ CHO PHẦN QUẢN LÝ CỦA ADMIN ////////////////////////////////

       public ResultSet getND() {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call b_nguoidung()}");
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }    
    // Xóa người dùng
    public void xoaND(int id) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call xoa_nguoidung(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       // Thêm người dùng
    public ResultSet themND(String ten, String mk, String sdt, int xacnhan, String phanquyen) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call them_nguoidung(?,?,?,?,?)}");
            cs.setString(1, ten);
            cs.setString(2, mk);
            cs.setString(3, sdt);
            cs.setInt(4, xacnhan);
            cs.setString(5, phanquyen);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // Cập nhật loại sp
    public void capND(int id, String ten, String mk, String sdt, int xacnhan, String phanquyen) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call capnhat_nguoidung(?,?,?,?,?,?)}");
            cs.setInt(1, id);
            cs.setString(2, ten);
            cs.setString(3, mk);
            cs.setString(4, sdt);
            cs.setInt(5, xacnhan);
            cs.setString(6, phanquyen);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Tìm theo tình trạng xác nhận
      public ResultSet timXacNhan(int xacnhan) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timXacNhan(?)}");
            cs.setInt(1, xacnhan);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    // Tìm theo phân quyền
      public ResultSet timPhanQuyen(String phanquyen) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timPhanQuyen(?)}");
            cs.setString(1, phanquyen);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    // Tìm theo trình trạng xác nhận và phân quyền
    
      public ResultSet timND(int xacnhan, String phanquyen) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timND(?,?)}");
            cs.setInt(1, xacnhan);
            cs.setString(2, phanquyen);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ================= ==================================================================
    // ================================ CÁC HÀM XỬ LÝ CHO CHI ĐƠN HÀNG ======================================

    public ResultSet getDHSP() {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call b_donhang()}");
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    // TÌM THEO MÃ ĐƠN HÀNG
    public ResultSet timDonhang(int maDH) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timDonhang(?)}");
            cs.setInt(1, maDH);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // TÌM THEO MÃ KHÁCH HÀNG
    public ResultSet timDonhangMKH(int maKH) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timDonhangMKH(?)}");
            cs.setInt(1, maKH);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    // TÌM THEO Tên KHÁCH HÀNG trong chi tiet don hang
    public ResultSet timDonhangTenKH(String ten) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timDonhangTenKH(?)}");
            cs.setString(1, ten);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    
     // -==================== CÁC HÀM XỬ LÝ CHO NGƯỜI DÙNG TÀI KHOẢN =============
    
       public ResultSet getKH() {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call b_khachhang()}");
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
        // TÌM THEO MÃ KHÁCH HÀNG
    public ResultSet timMaKH(int maKH) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timIDKH(?)}");
            cs.setInt(1, maKH);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
        // TÌM THEO Tên KHÁCH HÀNG trong chi tiet don hang
    public ResultSet timTenKH(String ten) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timTenKH(?)}");
            cs.setString(1, ten);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
       // TÌM THEO Tên KHÁCH HÀNG trong chi tiet don hang
    public ResultSet timSDTKH(String ten) {
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call timSDTKH(?)}");
            cs.setString(1, ten);
            rs = cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
        // Cập nhật khach hang
    public void capnhapKH(int id, String tenkh, String email, String sdt) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call capnhatKH(?,?,?,?)}");
            cs.setInt(1, id);
            cs.setString(2, tenkh);
            cs.setString(3, email);
            cs.setString(4, sdt);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Xóa khach hang
    public void xoaKH(int id) {
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call xoaloaiKH(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


//
// public static void main(String[] args) {
//     MyConnect myCon = new MyConnect();
//       myCon.connect();
//////////////        //myCon.showData(myCon.getDataId("sp002"));
//////////////        //myCon.insertData("sp007"," Iphone X", 300000, "loai002");
//////    myCon.insertDataKH(new khachhang(3,"yen","123456","012345678"));
//////////////        //myCon.deleteId("sp008");
//////////////       // myCon.updateId(new sanpham("sp007"," Iphone X", 320000, "loai002"));
////         myCon.showDataSP(myCon.timMaSP(1));
////
//    myCon.capnhapSP(22, "iphone 6", 10000, "Smartphone");
//   }
}
