# Danh sách Test Case — Bài thực hành 04

Chú thích cột **Loại**: `Hợp lệ` → dùng cho Issue 1, `Biên/Lỗi` → dùng cho Issue 2.

## Bài 1 — Chu vi hình chữ nhật (`tinhChuVi`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 1.1 | chuVi_hopLe | dai=3, rong=4 | 14.0 | Hợp lệ | điều kiện false → return |
| 1.2 | chuVi_hopLe_thapPhan | dai=2.5, rong=2.0 | 9.0 | Hợp lệ | điều kiện false → return |
| 1.3 | chuVi_daiKhongDuong | dai=0 / dai=-2, rong=5 | ném `IllegalArgumentException` | Biên/Lỗi | dai<=0 → true |
| 1.4 | chuVi_rongKhongDuong | dai=5, rong=0 / rong=-3 | ném `IllegalArgumentException` | Biên/Lỗi | rong<=0 → true |

## Bài 2 — Diện tích hình chữ nhật (`tinhDienTich`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 2.1 | dienTich_hopLe | dai=3, rong=4 | 12.0 | Hợp lệ | điều kiện false |
| 2.2 | dienTich_daiKhongDuong | dai=0, rong=5 | ném ngoại lệ | Biên/Lỗi | dai<=0 → true |
| 2.3 | dienTich_rongKhongDuong | dai=5, rong=-1 | ném ngoại lệ | Biên/Lỗi | rong<=0 → true |

## Bài 3 — Giải phương trình bậc 2 (`giaiPhuongTrinhBac2`)

| # | Test | Input (a,b,c) | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|----------------|-------------------|------|-----------|
| 3.1 | hoNghiemDelta_duong | 1,-3,2 | HAI_NGHIEM: x1=2, x2=1 | Hợp lệ | a≠0, delta>0 |
| 3.2 | nghiemKep_delta0 | 1,-2,1 | MOT_NGHIEM: x=1 | Hợp lệ | a≠0, delta=0 |
| 3.3 | voNghiem_deltaAm | 1,1,1 | VO_NGHIEM | Biên/Lỗi | a≠0, delta<0 |
| 3.4 | bacMot_aBangKhong | 0,2,-4 | MOT_NGHIEM: x=2 | Biên/Lỗi | a=0, b≠0 |
| 3.5 | voNghiem_aBangKhongBBangKhong | 0,0,5 | VO_NGHIEM | Biên/Lỗi | a=0, b=0, c≠0 |
| 3.6 | voSoNghiem_tatCaBangKhong | 0,0,0 | VO_SO_NGHIEM | Biên/Lỗi | a=0, b=0, c=0 |

## Bài 4 — Số ngày của một tháng (`soNgayCuaThang`, `isNamNhuan`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 4.1 | thang31Ngay | (1,2026), (12,2026) | 31 | Hợp lệ | case 31 ngày |
| 4.2 | thang30Ngay | (4,2026), (11,2026) | 30 | Hợp lệ | case 30 ngày |
| 4.3 | thang2NamNhuan | (2,2024), (2,2000) | 29 | Hợp lệ | case 2, năm nhuận |
| 4.4 | thang2KhongNhuan | (2,2023), (2,1900) | 28 | Hợp lệ | case 2, không nhuận |
| 4.5 | thangKhongHopLe | thang=0 / 13 | ném ngoại lệ | Biên/Lỗi | thang<1 hoặc >12 |
| 4.6 | kiemTraNamNhuan | 2024,2000,1900,2023 | true,true,false,false | Biên/Lỗi | cả 2 nhánh của biểu thức nhuận |

## Bài 5 — Kiểm tra số nguyên tố (`isNguyenTo`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 5.1 | soNguyenTo_hopLe | 2,3,17,97 | true | Hợp lệ | n=2 và vòng lặp không tìm ước |
| 5.2 | hopSo_hopLe | 9,15,100 | false | Hợp lệ | vòng lặp tìm thấy ước |
| 5.3 | bien_nNhoHon2 | 1,0,-5 | false | Biên/Lỗi | n<2 → true |
| 5.4 | bien_soChan | 4,100 | false | Biên/Lỗi | n%2==0 → true |

## Bài 6 — Tổng đan dấu (`tinhTongDanXen`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 6.1 | nChan | n=4 | -2 | Hợp lệ | vòng lặp nhiều lần, kết thúc ở số chẵn |
| 6.2 | nLe | n=3 | 2 | Hợp lệ | vòng lặp nhiều lần, kết thúc ở số lẻ |
| 6.3 | bien_n1 | n=1 | 1 | Biên/Lỗi | vòng lặp chạy đúng 1 lần |
| 6.4 | loi_nNhoHon1 | n=0, n=-3 | ném ngoại lệ | Biên/Lỗi | n<1 → true |

## Bài 7 — UCLN (`ucln`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 7.1 | ucln_hopLe | (48,18), (17,5) | 6, 1 | Hợp lệ | vòng lặp while nhiều lần |
| 7.2 | bien_motSoBang0 | (0,5), (7,0) | 5, 7 | Biên/Lỗi | vòng lặp while chạy 0 lần |
| 7.3 | bien_soAm | (-48,18), (48,-18) | 6, 6 | Biên/Lỗi | Math.abs xử lý số âm |
| 7.4 | loi_caHaiBang0 | (0,0) | ném ngoại lệ | Biên/Lỗi | a=0 && b=0 → true |

## Bài 8 — Tổng giai thừa (`tinhTongGiaiThua`, `giaiThua`)

| # | Test | Input | Kết quả mong đợi | Loại | Nhánh phủ |
|---|------|-------|-------------------|------|-----------|
| 8.1 | giaiThua_hopLe | 0,1,5 | 1,1,120 | Hợp lệ | vòng lặp chạy 0, 0, và nhiều lần |
| 8.2 | giaiThua_soAm | -1 | ném ngoại lệ | Biên/Lỗi | n<0 → true |
| 8.3 | tongGiaiThua_hopLe | n=3 | 9 | Hợp lệ | vòng lặp gọi giaiThua() nhiều lần |
| 8.4 | tongGiaiThua_bien_n1 | n=1 | 1 | Biên/Lỗi | vòng lặp chạy đúng 1 lần |
| 8.5 | tongGiaiThua_loi_nNhoHon1 | n=0, n=-2 | ném ngoại lệ | Biên/Lỗi | n<1 → true |

---

**Tổng cộng: 36 test case** — tất cả PASS (xem `junit-run-log.txt`).
Bộ test này phủ 100% câu lệnh và 100% nhánh điều kiện của `Functions.java`
(mỗi nhánh `if/else`, mỗi case của `switch`, mỗi điều kiện dừng vòng lặp
đều có ít nhất một test case đi qua).
