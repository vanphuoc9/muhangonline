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
public class khachhang {
    private int idkh;
    private String tenkh;
    private String matkhau;
    private String sodienthoai;

    public khachhang() {
    }

    public khachhang(int idkh, String tenkh, String matkhau, String sodienthoai) {
        this.idkh = idkh;
        this.tenkh = tenkh;
        this.matkhau = matkhau;
        this.sodienthoai = sodienthoai;
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    

   
}
