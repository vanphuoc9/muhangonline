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
public class loaisanpham {
    private int idloaisp;
    private String tenloaisp;

    public loaisanpham(int idloaisp, String tenloaisp) {
        this.idloaisp = idloaisp;
        this.tenloaisp = tenloaisp;
    }

    public loaisanpham() {
    }

    public int getIdloaisp() {
        return idloaisp;
    }

    public void setIdloaisp(int idloaisp) {
        this.idloaisp = idloaisp;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }
    
   
    
}
