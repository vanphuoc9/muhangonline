insert into loaisanpham(tenloaisanpham) values('Computer');
insert into loaisanpham(tenloaisanpham) values('Smartphone');
insert into loaisanpham(tenloaisanpham) values('USB');

insert into sanpham(tensp, giasp,idloai) values('Apple Macbook Air MQD32SA',23990000, 1);
insert into sanpham(tensp, giasp,idloai) values('Dell Inspiron 7567A i7 7700HQ',27590000, 1);

insert into sanpham(tensp, giasp,idloai) values('iPhone 7',23490000,2);
insert into sanpham(tensp, giasp,idloai) values('Galaxy S8 Plus',20490000,2);

insert into sanpham(tensp, giasp,idloai) values('USB Apacer 16 GB',176000, 3);
insert into sanpham(tensp, giasp,idloai) values('Sandisk SDCZ43',220000, 3);

insert into nguoidung(tenkh,matkhau,sodienthoai) values('vanphuoc','123456','01264969696');


insert into khachhang(tenkhang,diachi,sodienthoai) values('Van phuoc Thai','Can Tho', '012345678');

insert into chitietdonhang(idkhang, idsp, ngaymua, soluongsp) values('2', 31, '2017-09-28', 10);


create database muahang;
use muahang;

create table loaisanpham(
  idloai int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tenloaisanpham varchar(200) NOT NULL
);



create table sanpham(
  idsp int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tensp varchar(200) NOT NULL,
  giasp int(15) NOT NULL,
  idloai int(11) NOT NULL,
  foreign key(idloai) references loaisanpham(idloai)
);

create table nguoidung(
  idkh int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tenkh varchar(200) NOT NULL,
  matkhau varchar(45) NOT NULL,
  sodienthoai char(11) NOT NULL
);

create table khachhang(
  idkhang int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tenkhang varchar(200) NOT NULL,
  diachi varchar(200) NOT NULL,
  sodienthoai char(11) NOT NULL

);

create table chitietdonhang(
   iddonhang int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
   idkhang int(11) NOT NULL,
   foreign key(idkhang) references khachhang(idkhang),
   idsp int(11) NOT NULL,
   foreign key(idsp) references sanpham(idsp),
   ngaymua date,
   soluongsp  int(11) NOT NULL
);


/*================================Cac ham xu ly cua bang san pham=========================================*/

/*xuat ra bang san pham */
delimiter $$
create procedure b_sanpham()
begin
    select idsp, tensp, giasp, tenloaisanpham 
    from sanpham join loaisanpham on sanpham.idloai = loaisanpham.idloai;
end;$$

/* them san pham
delimiter $$
create procedure themSP(
  in tensp varchar(200),
  in giasp int,
  in tenloaisp varchar(200)
)
begin
   declare idloaisp int(11);
   select idloai into idloaisp from loaisanpham where loaisanpham.tenloaisanpham = tenloaisp;
   insert into sanpham(tensp, giasp,idloai) values (tensp, giasp,idloaisp); 
end;$$  */



/* them san pham*/
delimiter $$
create procedure themSP(
  in tensp varchar(200),
  in giasp int,
  in tenloaisp varchar(200)
)
begin
   declare idloaisp int(11);
   if exists (select * from loaisanpham where loaisanpham.tenloaisanpham = tenloaisp)
     then
       select idloai into idloaisp from loaisanpham where loaisanpham.tenloaisanpham = tenloaisp;
       insert into sanpham(tensp, giasp,idloai) values (tensp, giasp,idloaisp); 
   else 
           call themLoai(tenloaisp);
           select idloai into idloaisp from loaisanpham where loaisanpham.tenloaisanpham = tenloaisp;
           insert into sanpham(tensp, giasp,idloai) values (tensp, giasp,idloaisp); 
   end if;

end;$$



/* cap nhat san pham*/
delimiter $$
create procedure capnhatSP(
  in idsanpham int(11),
  in tsp varchar(200),
  in gsp int,
  in tenloaisp varchar(200)
)
begin
   declare idloaisp int(11);
   select idloai into idloaisp from loaisanpham where loaisanpham.tenloaisanpham = tenloaisp;
   update sanpham set tensp = tsp, giasp = gsp, idloai = idloaisp where idsp = idsanpham;
end;$$

/* Tim kiem san pham theo ma san pham*/
delimiter $$
create procedure timMaSP(in idsanpham int(11))
begin
  select idsp, tensp, giasp, tenloaisanpham 
  from sanpham join loaisanpham on sanpham.idloai = loaisanpham.idloai
  where idsp = idsanpham;
end;$$
/* Tim kiem san phamtheo ten san pham*/

delimiter $$
create procedure timTenSP(in tsp varchar(200))
begin
  select idsp, tensp, giasp, tenloaisanpham 
  from sanpham join loaisanpham on sanpham.idloai = loaisanpham.idloai
  where tensp = tsp;
end;$$

/* Tim theo loai san pham*/
delimiter $$
create procedure timTenLoaiSP(in tloaisp varchar(200))
begin
  select idsp, tensp, giasp, tenloaisanpham 
  from sanpham join loaisanpham on sanpham.idloai = loaisanpham.idloai
  where tenloaisanpham = tloaisp;
end;$$
 /*================================Cac ham xu ly cua bang loai san pham=========================================*/
/* xuat ra bang loai san pham*/
delimiter $$
create procedure b_loaiSP()
begin
select * from loaisanpham;
end;$$

/*Them loai san pham*/
delimiter $$
create procedure themLoai(in tenloai varchar(200))
begin
insert into loaisanpham(tenloaisanpham) values(tenloai);
end;$$

/*cap nhat loai san pham*/
delimiter $$
create procedure capnhatLoai(in idlsp int(11),in tenloai varchar(200))
begin 
update loaisanpham set tenloaisanpham = tenloai where idloai = idlsp;
end;$$

/*Xoa loai san pham: xóa san pham cua loai đó lun*/
delimiter $$
create procedure xoaloaisp(in idlsp int(11))
begin
  if exists (select * from loaisanpham where idloai = idlsp)
    then
      delete from sanpham where sanpham.idloai = idlsp;
      delete from loaisanpham where loaisanpham.idloai = idlsp;
   end if;
end;$$

/* Tim kiem theo idloai san pham*/
delimiter $$
create procedure timIdLoai(in id int(11))
begin
select * from loaisanpham where idloai=id;
end;$$

/*Tim kiem theo ten loai san pham*/
delimiter $$
create procedure timTenLoai(in tenloai varchar(200))
begin
select * from loaisanpham where tenloaisanpham=tenloai;
end;$$
/* Cac ham quan ly don hang */

/* Tong so tien trong tung khach hang */
delimiter $$
Create function tongtiensp(idkhachhang int(11))
RETURNS FLOAT
begin
  declare kq float default -1;
     select soluongsp*giasp into kq 
               from chitietdonhang inner join sanpham 
               on chitietdonhang.idsp = sanpham.idsp
               where chitietdonhang.idkhang = idkhachhang;
   return kq;
end;$$

/* Xem don hang*/ 
delimiter $$
create procedure b_donhang()
begin 
   select chitietdonhang.iddonhang, khachhang.tenkhang, sanpham.tensp, chitietdonhang.ngaymua, chitietdonhang.soluongsp, tongtiensp(khachhang.idkhang) as tongtien
   from chitietdonhang inner join sanpham on chitietdonhang.idsp = sanpham.idsp
                             join khachhang on chitietdonhang.idkhang = khachhang.idkhang;
end;$$

/* Tim don hang theo ma don hang*/

delimiter $$
create procedure timDonhang(in iddonhang int(11))
begin
   select chitietdonhang.iddonhang, khachhang.tenkhang, sanpham.tensp, chitietdonhang.ngaymua, chitietdonhang.soluongsp, tongtiensp(khachhang.idkhang) as tongtien
   from chitietdonhang inner join sanpham on chitietdonhang.idsp = sanpham.idsp
                             join khachhang on chitietdonhang.idkhang = khachhang.idkhang
   where chitietdonhang.iddonhang = iddonhang;
end;$$

/* Tim don hang theo ma khach hang*/

delimiter $$
create procedure timDonhangMKH(in idkh int(11))
begin
   select chitietdonhang.iddonhang, khachhang.tenkhang, sanpham.tensp, chitietdonhang.ngaymua, chitietdonhang.soluongsp, tongtiensp(khachhang.idkhang) as tongtien
   from chitietdonhang inner join sanpham on chitietdonhang.idsp = sanpham.idsp
                             join khachhang on chitietdonhang.idkhang = khachhang.idkhang
   where chitietdonhang.idkhang = idkh;
end;$$


/*  Tim don hang theo ten khach hang*/
delimiter $$
create procedure timDonhangTenKH(in tenkh varchar(200))
begin
   select chitietdonhang.iddonhang, khachhang.tenkhang, sanpham.tensp, chitietdonhang.ngaymua, chitietdonhang.soluongsp, tongtiensp(khachhang.idkhang) as tongtien
   from chitietdonhang inner join sanpham on chitietdonhang.idsp = sanpham.idsp
                             join khachhang on chitietdonhang.idkhang = khachhang.idkhang
   where khachhang.tenkhang = tenkh;
end;$$


 /*================================Cac ham xu ly cua bang khach hang=========================================*/

/*Bang khach hang*/
delimiter $$
create procedure b_khachhang()
begin
    select *
    from khachhang;
end;$$
/*Tim theo ma khach hang*/
delimiter $$
create procedure timIDKH(in id int(11))
begin
select * from khachhang where idkhang=id;
end;$$

/*Tim kiem theo ten khach hang*/
delimiter $$
create procedure timTenKH(in tenKH varchar(200))
begin
select * from khachhang where tenkhang=tenKH;
end;$$

/*Tim kiem theo sdt khach hang*/
delimiter $$
create procedure timSDTKH(in sdt char(11))
begin
select * from khachhang where sodienthoai=sdt;
end;$$

/*cap nhat thong tin khach hang*/
delimiter $$
create procedure capnhatKH(in id int(11),in tenKH varchar(200), in email varchar(200), in sdt char(11))
begin 
update khachhang set tenkhang = tenKH, diachi = email, sodienthoai = sdt  where idkhang = id;
end;$$

/*Xoa khach hang: xóa don hang cua khach hang đó lun*/
delimiter $$
create procedure xoaloaiKH(in id int(11))
begin
  if exists (select * from khachhang where idkhang = id)
    then
      delete from chitietdonhang where chitietdonhang.idkhang = id;
      delete from khachhang where khachhang.idkhang = id;
   end if;
end;$$



/*================================Cac ham xu ly quan ly nguoi dung phan mem=========================================*/
/* xac nhan*/
delimiter $$
Create function xacnhan(idnguoidung int(11))
RETURNS varchar(20)
begin
  declare kq VARCHAR(20) default "NO";
  declare xn int default -1;
     select xacnhan into xn  from nguoidung where idkh=idnguoidung;
  if (xn = 1)
    then
     set kq = 'yes';
  else  
	  set kq = 'no';
  end if;
   return kq;
end;$$
/* bang nguoi dung*/
delimiter $$
create procedure b_nguoidung()
begin
select idkh, tenkh, matkhau, sodienthoai, xacnhan(idkh), phanquyen from nguoidung;
end;$$

/*Xoa nguoi dung*/
delimiter $$
create procedure xoa_nguoidung(in id int(11))
begin
  if exists (select * from nguoidung where idkh = id)
    then
      delete from nguoidung where nguoidung.idkh = id;
   end if;
end;$$
/*Them nguoi dung*/
delimiter $$
create procedure them_nguoidung(in ten varchar(200), in mk varchar(45), in sdt char(11), in xnhan int(1), in pquyen char(55))
begin
insert into nguoidung(tenkh,matkhau,sodienthoai,xacnhan,phanquyen) values(ten,mk,sdt,xnhan,pquyen);
end;$$

/* cap nhat nguoi*/
delimiter $$
create procedure capnhat_nguoidung(in id int(11),in ten varchar(200), in mk varchar(45), in sdt char(11), in xnhan int(1), in pquyen char(55))
begin
 update nguoidung set tenkh = ten, matkhau = mk, sodienthoai = sdt, xacnhan = xnhan, phanquyen =  pquyen where idkh = id;
end;$$

/*Tim kiem theo tình trang xac nhan*/
delimiter $$
create procedure timXacNhan(in xn int(1))
begin
select idkh, tenkh, matkhau, sodienthoai, xacnhan(idkh), phanquyen from nguoidung where xacnhan=xn;
end;$$

/*Tim kiem ds theo phan quyen*/
delimiter $$
create procedure timPhanQuyen(in pq varchar(200))
begin
select idkh, tenkh, matkhau, sodienthoai, xacnhan(idkh), phanquyen from nguoidung where phanquyen=pq;
end;$$

/*Tim theo tinh trang xac nhan va quyen han*/
delimiter $$
create procedure timND(in xn int(1),in pq varchar(200))
begin
select idkh, tenkh, matkhau, sodienthoai, xacnhan(idkh), phanquyen from nguoidung where xacnhan=xn and phanquyen=pq;
end;$$

create table nguoidung(
  idkh int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tenkh varchar(200) NOT NULL,
  matkhau varchar(45) NOT NULL,
  sodienthoai char(11) NOT NULL,
  xacnhan int(1) NOT NULL,
  phanquyen char(55) NOT NULL
);
delimiter ;
drop procedure them_nguoidung;
call b_nguoidung();
select xacnhan(2);
drop function xacnhan;
drop procedure b_nguoidung;

select * from nguoidung;








select * from loaisanpham;
call timDonhang(1);
call timDonhangTenKH('Van phuoc');
call timTenLoai('USB');

select tongtiensp(1);