package baithuchanh04;

public class Functions {

    // ============================================================
    // Bài 1: Tính chu vi hình chữ nhật
    // ============================================================
    /**
     * Tính chu vi hình chữ nhật.
     * @param dai chiều dài (> 0)
     * @param rong chiều rộng (> 0)
     * @return chu vi = 2 * (dai + rong)
     * @throws IllegalArgumentException nếu dai <= 0 hoặc rong <= 0
     */
    public static double tinhChuVi(double dai, double rong) {
        if (dai <= 0 || rong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0");
        }
        return 2 * (dai + rong);
    }

    // ============================================================
    // Bài 2: Tính diện tích hình chữ nhật
    // ============================================================
    /**
     * Tính diện tích hình chữ nhật.
     * @param dai chiều dài (> 0)
     * @param rong chiều rộng (> 0)
     * @return diện tích = dai * rong
     * @throws IllegalArgumentException nếu dai <= 0 hoặc rong <= 0
     */
    public static double tinhDienTich(double dai, double rong) {
        if (dai <= 0 || rong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0");
        }
        return dai * rong;
    }

    // ============================================================
    // Bài 3: Giải phương trình bậc 2: a*x^2 + b*x + c = 0
    // ============================================================
    /**
     * Giải phương trình bậc 2 (tổng quát, bao gồm cả trường hợp suy biến a = 0).
     */
    public static QuadraticResult giaiPhuongTrinhBac2(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return QuadraticResult.voSoNghiem();
                } else {
                    return QuadraticResult.voNghiem();
                }
            } else {
                // Phương trình bậc 1: b*x + c = 0
                return QuadraticResult.motNghiem(-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                return QuadraticResult.voNghiem();
            } else if (delta == 0) {
                return QuadraticResult.motNghiem(-b / (2 * a));
            } else {
                double sqrtDelta = Math.sqrt(delta);
                double x1 = (-b + sqrtDelta) / (2 * a);
                double x2 = (-b - sqrtDelta) / (2 * a);
                return QuadraticResult.haiNghiem(x1, x2);
            }
        }
    }

    // ============================================================
    // Bài 4: Tính số ngày của một tháng
    // ============================================================
    /**
     * Trả về số ngày của tháng "thang" trong năm "nam".
     * @throws IllegalArgumentException nếu thang không thuộc [1, 12]
     */
    public static int soNgayCuaThang(int thang, int nam) {
        if (thang < 1 || thang > 12) {
            throw new IllegalArgumentException("Tháng phải từ 1 đến 12");
        }
        switch (thang) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isNamNhuan(nam) ? 29 : 28;
            default:
                // Không thể xảy ra vì đã kiểm tra thang ở trên
                throw new IllegalStateException("Tháng không hợp lệ");
        }
    }

    /**
     * Kiểm tra năm nhuận: chia hết cho 4 và (không chia hết cho 100 hoặc chia hết cho 400).
     */
    public static boolean isNamNhuan(int nam) {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    // ============================================================
    // Bài 5: Kiểm tra n có phải là số nguyên tố hay không
    // ============================================================
    /**
     * Kiểm tra n có phải số nguyên tố hay không.
     */
    public static boolean isNguyenTo(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ============================================================
    // Bài 6: Tính tổng S = 1 - 2 + 3 - 4 + ... ± n
    // ============================================================
    /**
     * Tính tổng đan dấu S = 1 - 2 + 3 - 4 + ... (n số hạng).
     * @param n số số hạng, n >= 1
     * @throws IllegalArgumentException nếu n < 1
     */
    public static long tinhTongDanXen(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n phải >= 1");
        }
        long s = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                s += i;
            } else {
                s -= i;
            }
        }
        return s;
    }

    // ============================================================
    // Bài 7: Tìm UCLN (ước chung lớn nhất) của a và b
    // ============================================================
    /**
     * Tìm ước chung lớn nhất của a và b bằng thuật toán Euclid.
     * @throws IllegalArgumentException nếu a == 0 và b == 0
     */
    public static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("a và b không được đồng thời bằng 0");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // ============================================================
    // Bài 8: Tính tổng S = 1! + 2! + 3! + ... + n!
    // ============================================================
    /**
     * Tính giai thừa của n (hàm phụ trợ, dùng lại cho bài 8).
     * @throws IllegalArgumentException nếu n < 0
     */
    public static long giaiThua(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n phải >= 0");
        }
        long ket_qua = 1;
        for (int i = 2; i <= n; i++) {
            ket_qua *= i;
        }
        return ket_qua;
    }

    /**
     * Tính tổng S = 1! + 2! + ... + n!, sử dụng hàm giaiThua().
     * @throws IllegalArgumentException nếu n < 1
     */
    public static long tinhTongGiaiThua(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n phải >= 1");
        }
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += giaiThua(i);
        }
        return s;
    }
}
