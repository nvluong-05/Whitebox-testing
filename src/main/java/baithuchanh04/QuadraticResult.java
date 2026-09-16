package baithuchanh04;

import java.util.Objects;

public class QuadraticResult {

    public enum Type {
        VO_NGHIEM,       
        VO_SO_NGHIEM,    
        MOT_NGHIEM,      
        HAI_NGHIEM       
    }

    public final Type type;
    public final double x1;
    public final double x2;

    public QuadraticResult(Type type, double x1, double x2) {
        this.type = type;
        this.x1 = x1;
        this.x2 = x2;
    }

    public static QuadraticResult voNghiem() {
        return new QuadraticResult(Type.VO_NGHIEM, 0, 0);
    }

    public static QuadraticResult voSoNghiem() {
        return new QuadraticResult(Type.VO_SO_NGHIEM, 0, 0);
    }

    public static QuadraticResult motNghiem(double x) {
        return new QuadraticResult(Type.MOT_NGHIEM, x, x);
    }

    public static QuadraticResult haiNghiem(double x1, double x2) {
        return new QuadraticResult(Type.HAI_NGHIEM, x1, x2);
    }

    @Override
    public String toString() {
        switch (type) {
            case VO_NGHIEM: return "Vô nghiệm";
            case VO_SO_NGHIEM: return "Vô số nghiệm";
            case MOT_NGHIEM: return "Nghiệm duy nhất x = " + x1;
            case HAI_NGHIEM: return "Hai nghiệm x1 = " + x1 + ", x2 = " + x2;
            default: return "Không xác định";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuadraticResult)) return false;
        QuadraticResult that = (QuadraticResult) o;
        return type == that.type
                && Double.compare(that.x1, x1) == 0
                && Double.compare(that.x2, x2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, x1, x2);
    }
}
