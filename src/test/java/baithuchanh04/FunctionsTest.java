package baithuchanh04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Nested
    @DisplayName("Bài 1 - Chu vi hình chữ nhật")
    class ChuViTest {

        @Test
        @Tag("valid")
        @DisplayName("Chu vi với kích thước hợp lệ (số nguyên)")
        void chuVi_hopLe() {
            assertEquals(14.0, Functions.tinhChuVi(3, 4), 1e-9);
        }

        @Test
        @Tag("valid")
        @DisplayName("Chu vi với kích thước hợp lệ (số thập phân)")
        void chuVi_hopLe_thapPhan() {
            assertEquals(9.0, Functions.tinhChuVi(2.5, 2.0), 1e-9);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Dài <= 0 phải ném ngoại lệ")
        void chuVi_daiKhongDuong() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhChuVi(0, 5));
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhChuVi(-2, 5));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Rộng <= 0 phải ném ngoại lệ")
        void chuVi_rongKhongDuong() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhChuVi(5, 0));
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhChuVi(5, -3));
        }
    }

    @Nested
    @DisplayName("Bài 2 - Diện tích hình chữ nhật")
    class DienTichTest {

        @Test
        @Tag("valid")
        @DisplayName("Diện tích với kích thước hợp lệ")
        void dienTich_hopLe() {
            assertEquals(12.0, Functions.tinhDienTich(3, 4), 1e-9);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Dài <= 0 phải ném ngoại lệ")
        void dienTich_daiKhongDuong() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhDienTich(0, 5));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Rộng <= 0 phải ném ngoại lệ")
        void dienTich_rongKhongDuong() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhDienTich(5, -1));
        }
    }

    @Nested
    @DisplayName("Bài 3 - Giải phương trình bậc 2")
    class PhuongTrinhBac2Test {

        @Test
        @Tag("valid")
        @DisplayName("Delta > 0: hai nghiệm phân biệt")
        void hoNghiemDelta_duong() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(1, -3, 2);
            assertEquals(QuadraticResult.Type.HAI_NGHIEM, r.type);
            assertEquals(2.0, r.x1, 1e-9);
            assertEquals(1.0, r.x2, 1e-9);
        }

        @Test
        @Tag("valid")
        @DisplayName("Delta = 0: nghiệm kép")
        void nghiemKep_delta0() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(1, -2, 1);
            assertEquals(QuadraticResult.Type.MOT_NGHIEM, r.type);
            assertEquals(1.0, r.x1, 1e-9);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Delta < 0: vô nghiệm")
        void voNghiem_deltaAm() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(1, 1, 1);
            assertEquals(QuadraticResult.Type.VO_NGHIEM, r.type);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("a = 0, b != 0: phương trình bậc 1")
        void bacMot_aBangKhong() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(0, 2, -4);
            assertEquals(QuadraticResult.Type.MOT_NGHIEM, r.type);
            assertEquals(2.0, r.x1, 1e-9);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("a = 0, b = 0, c != 0: vô nghiệm")
        void voNghiem_aBangKhongBBangKhong() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(0, 0, 5);
            assertEquals(QuadraticResult.Type.VO_NGHIEM, r.type);
        }

        @Test
        @Tag("edge-error")
        @DisplayName("a = 0, b = 0, c = 0: vô số nghiệm")
        void voSoNghiem_tatCaBangKhong() {
            QuadraticResult r = Functions.giaiPhuongTrinhBac2(0, 0, 0);
            assertEquals(QuadraticResult.Type.VO_SO_NGHIEM, r.type);
        }
    }

    @Nested
    @DisplayName("Bài 4 - Số ngày của một tháng")
    class SoNgayThangTest {

        @Test
        @Tag("valid")
        @DisplayName("Tháng có 31 ngày")
        void thang31Ngay() {
            assertEquals(31, Functions.soNgayCuaThang(1, 2026));
            assertEquals(31, Functions.soNgayCuaThang(12, 2026));
        }

        @Test
        @Tag("valid")
        @DisplayName("Tháng có 30 ngày")
        void thang30Ngay() {
            assertEquals(30, Functions.soNgayCuaThang(4, 2026));
            assertEquals(30, Functions.soNgayCuaThang(11, 2026));
        }

        @Test
        @Tag("valid")
        @DisplayName("Tháng 2 năm nhuận: 29 ngày")
        void thang2NamNhuan() {
            assertEquals(29, Functions.soNgayCuaThang(2, 2024));
            assertEquals(29, Functions.soNgayCuaThang(2, 2000)); 
        }

        @Test
        @Tag("valid")
        @DisplayName("Tháng 2 năm không nhuận: 28 ngày")
        void thang2KhongNhuan() {
            assertEquals(28, Functions.soNgayCuaThang(2, 2023)); 
            assertEquals(28, Functions.soNgayCuaThang(2, 1900)); 
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Tháng ngoài khoảng [1,12] phải ném ngoại lệ")
        void thangKhongHopLe() {
            assertThrows(IllegalArgumentException.class, () -> Functions.soNgayCuaThang(0, 2026));
            assertThrows(IllegalArgumentException.class, () -> Functions.soNgayCuaThang(13, 2026));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Kiểm tra hàm năm nhuận độc lập")
        void kiemTraNamNhuan() {
            assertTrue(Functions.isNamNhuan(2024));
            assertTrue(Functions.isNamNhuan(2000));
            assertFalse(Functions.isNamNhuan(1900));
            assertFalse(Functions.isNamNhuan(2023));
        }
    }

    @Nested
    @DisplayName("Bài 5 - Kiểm tra số nguyên tố")
    class NguyenToTest {

        @Test
        @Tag("valid")
        @DisplayName("Số nguyên tố hợp lệ")
        void soNguyenTo_hopLe() {
            assertTrue(Functions.isNguyenTo(2));
            assertTrue(Functions.isNguyenTo(3));
            assertTrue(Functions.isNguyenTo(17));
            assertTrue(Functions.isNguyenTo(97));
        }

        @Test
        @Tag("valid")
        @DisplayName("Hợp số hợp lệ")
        void hopSo_hopLe() {
            assertFalse(Functions.isNguyenTo(9));
            assertFalse(Functions.isNguyenTo(15));
            assertFalse(Functions.isNguyenTo(100));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: n < 2 không phải số nguyên tố")
        void bien_nNhoHon2() {
            assertFalse(Functions.isNguyenTo(1));
            assertFalse(Functions.isNguyenTo(0));
            assertFalse(Functions.isNguyenTo(-5));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: số chẵn > 2 không phải số nguyên tố")
        void bien_soChan() {
            assertFalse(Functions.isNguyenTo(4));
            assertFalse(Functions.isNguyenTo(100));
        }
    }

    @Nested
    @DisplayName("Bài 6 - Tổng đan dấu")
    class TongDanXenTest {

        @Test
        @Tag("valid")
        @DisplayName("n chẵn")
        void nChan() {
            assertEquals(-2, Functions.tinhTongDanXen(4));
        }

        @Test
        @Tag("valid")
        @DisplayName("n lẻ")
        void nLe() {
            assertEquals(2, Functions.tinhTongDanXen(3));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: n = 1 (vòng lặp chạy đúng 1 lần)")
        void bien_n1() {
            assertEquals(1, Functions.tinhTongDanXen(1));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Lỗi: n < 1 phải ném ngoại lệ")
        void loi_nNhoHon1() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhTongDanXen(0));
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhTongDanXen(-3));
        }
    }

    @Nested
    @DisplayName("Bài 7 - Ước chung lớn nhất")
    class UclnTest {

        @Test
        @Tag("valid")
        @DisplayName("UCLN của hai số hợp lệ")
        void ucln_hopLe() {
            assertEquals(6, Functions.ucln(48, 18));
            assertEquals(1, Functions.ucln(17, 5));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: một số bằng 0")
        void bien_motSoBang0() {
            assertEquals(5, Functions.ucln(0, 5));
            assertEquals(7, Functions.ucln(7, 0));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: số âm (lấy trị tuyệt đối)")
        void bien_soAm() {
            assertEquals(6, Functions.ucln(-48, 18));
            assertEquals(6, Functions.ucln(48, -18));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Lỗi: cả hai số đều bằng 0 phải ném ngoại lệ")
        void loi_caHaiBang0() {
            assertThrows(IllegalArgumentException.class, () -> Functions.ucln(0, 0));
        }
    }

    @Nested
    @DisplayName("Bài 8 - Tổng giai thừa")
    class TongGiaiThuaTest {

        @Test
        @Tag("valid")
        @DisplayName("Giai thừa hợp lệ")
        void giaiThua_hopLe() {
            assertEquals(1, Functions.giaiThua(0));
            assertEquals(1, Functions.giaiThua(1));
            assertEquals(120, Functions.giaiThua(5));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Lỗi: giai thừa của số âm phải ném ngoại lệ")
        void giaiThua_soAm() {
            assertThrows(IllegalArgumentException.class, () -> Functions.giaiThua(-1));
        }

        @Test
        @Tag("valid")
        @DisplayName("Tổng giai thừa hợp lệ")
        void tongGiaiThua_hopLe() {
            assertEquals(9, Functions.tinhTongGiaiThua(3));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Biên: n = 1 (vòng lặp chạy đúng 1 lần)")
        void tongGiaiThua_bien_n1() {
            assertEquals(1, Functions.tinhTongGiaiThua(1));
        }

        @Test
        @Tag("edge-error")
        @DisplayName("Lỗi: n < 1 phải ném ngoại lệ")
        void tongGiaiThua_loi_nNhoHon1() {
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhTongGiaiThua(0));
            assertThrows(IllegalArgumentException.class, () -> Functions.tinhTongGiaiThua(-2));
        }
    }
}
