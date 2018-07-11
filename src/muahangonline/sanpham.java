/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muahangonline;

/**
 *
 * @author User
 */
public class sanpham {

    private int idsp;
    private String tensp;
    private float giasp;
    private String idloaisp;

    public sanpham() {
    }

    public sanpham(int idsp, String tensp, float giasp, String idloaisp) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.idloaisp = idloaisp;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGiasp() {
        return giasp;
    }

    public void setGiasp(float giasp) {
        this.giasp = giasp;
    }

    public String getIdloaisp() {
        return idloaisp;
    }

    public void setIdloaisp(String idloaisp) {
        this.idloaisp = idloaisp;
    }
    

  

}
