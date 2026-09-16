# Bài thực hành 04 — Kiểm thử hộp trắng (White-box Testing)

Bài tập cài đặt 8 chương trình bằng Java, tổ chức thành các hàm riêng biệt,
và viết bộ test JUnit 5 nhằm đạt **100% statement coverage** và
**100% branch coverage**.

## 1. Danh sách 8 bài toán

| # | Bài toán | Hàm | Vị trí |
|---|----------|-----|--------|
| 1 | Chu vi hình chữ nhật | `tinhChuVi(dai, rong)` | `Functions.java` |
| 2 | Diện tích hình chữ nhật | `tinhDienTich(dai, rong)` | `Functions.java` |
| 3 | Giải phương trình bậc 2 | `giaiPhuongTrinhBac2(a, b, c)` | `Functions.java` + `QuadraticResult.java` |
| 4 | Số ngày của một tháng | `soNgayCuaThang(thang, nam)` (+ `isNamNhuan`) | `Functions.java` |
| 5 | Kiểm tra số nguyên tố | `isNguyenTo(n)` | `Functions.java` |
| 6 | Tổng đan dấu S = 1-2+3-4+...±n | `tinhTongDanXen(n)` | `Functions.java` |
| 7 | UCLN của a và b | `ucln(a, b)` | `Functions.java` |
| 8 | Tổng giai thừa S = 1!+2!+...+n! | `tinhTongGiaiThua(n)` (+ `giaiThua(n)`) | `Functions.java` |

## 2. Cấu trúc thư mục (chuẩn Maven)

```
bai04/
├── pom.xml
├── README.md
├── TESTCASES.md
├── junit-run-log.txt          # log kết quả chạy JUnit (36/36 PASS)
└── src/
    ├── main/java/baithuchanh04/
    │   ├── Functions.java          # 8 hàm nghiệp vụ
    │   └── QuadraticResult.java    # lớp kết quả cho bài giải PT bậc 2
    └── test/java/baithuchanh04/
        └── FunctionsTest.java      # 36 test case JUnit 5
```

## 3. Cách build & chạy test

### Cách 1: Dùng Maven (khuyến nghị, có báo cáo coverage bằng JaCoCo)
Cần cài Maven và có kết nối Internet để tải JUnit/JaCoCo lần đầu:
```bash
mvn test
```
Sau khi chạy xong, mở báo cáo coverage tại:
```
target/site/jacoco/index.html
```
Báo cáo này cho biết % statement coverage và % branch coverage của từng hàm —
dùng ảnh chụp màn hình trang này để nộp bài.

### Cách 2: Không cần Maven (dùng javac/java trực tiếp)
```bash
# Cài JUnit Console Standalone (hoặc tải file .jar tương ứng)
javac -d target/classes src/main/java/baithuchanh04/*.java
javac -cp "target/classes:junit-jupiter-api.jar:apiguardian-api.jar:opentest4j.jar" \
      -d target/test-classes src/test/java/baithuchanh04/*.java

java -jar junit-platform-console-standalone.jar \
     --class-path target/classes:target/test-classes \
     --scan-class-path --details=tree
```

Bộ test này **đã được biên dịch và chạy thực tế** — kết quả: **36/36 test PASS**
(xem `junit-run-log.txt`).

## 4. Phân tích mã nguồn (câu lệnh / nhánh / vòng lặp / đường đi logic)

Mỗi hàm trong `Functions.java` được thiết kế với các nhánh rẽ (if/else, switch)
tương ứng với các trường hợp nghiệp vụ khác nhau:

- **Bài 1, 2**: 1 nhánh điều kiện kiểm tra tham số hợp lệ (`dai<=0 || rong<=0`).
- **Bài 3**: cây quyết định 5 nhánh lồng nhau (a=0/b=0/c=0, delta <0/=0/>0).
- **Bài 4**: `switch` 3 nhóm tháng + nhánh năm nhuận (`isNamNhuan`, 1 điều kiện OR/AND).
- **Bài 5**: 4 nhánh sớm (n<2, n=2, n chẵn, vòng lặp chia thử) — 1 vòng `for`.
- **Bài 6**: 1 vòng `for` với nhánh chẵn/lẻ bên trong.
- **Bài 7**: vòng lặp `while` (thuật toán Euclid) + nhánh kiểm tra a=b=0.
- **Bài 8**: gọi lại hàm `giaiThua()` (dùng vòng `for`) bên trong vòng `for` của tổng.

Bộ test `FunctionsTest.java` được tổ chức theo `@Nested` cho từng bài, mỗi
test được gắn `@Tag("valid")` (luồng hợp lệ) hoặc `@Tag("edge-error")`
(biên / lỗi / ngoại lệ) để tách thành 2 issue theo yêu cầu đề bài — xem
`TESTCASES.md` để biết chi tiết từng test case và nhánh mà nó phủ.


Sau đó, trên trang GitHub của repo:

1. Vào tab **Issues → New issue**
   - **Issue 1**: tiêu đề *"Viết test JUnit kiểm thử hộp trắng cho các luồng xử lý hợp lệ"*.
     Nội dung: liệt kê các test có tag `valid` trong `TESTCASES.md`, đính kèm
     link tới `FunctionsTest.java`.
   - **Issue 2**: tiêu đề *"Viết test JUnit kiểm thử hộp trắng cho các nhánh lỗi, điều kiện biên, vòng lặp và ngoại lệ"*.
     Nội dung: liệt kê các test có tag `edge-error` trong `TESTCASES.md`.
2. Có thể đóng (close) 2 issue này sau khi đã commit code hoàn chỉnh, kèm
   ghi chú "Đã hoàn thành, xem FunctionsTest.java".
3. Chụp ảnh màn hình kết quả `mvn test` (hoặc dùng `junit-run-log.txt`) để
   đính kèm vào bài nộp.

## 6. Ghi chú

- Có thể đổi tên gói `baithuchanh04` cho phù hợp với cấu trúc repo cá nhân.
- Nếu giảng viên yêu cầu số liệu coverage cụ thể, chạy `mvn test` với JaCoCo
  (mục 3, Cách 1) để lấy số liệu chính xác theo từng dòng/nhánh mã nguồn.
