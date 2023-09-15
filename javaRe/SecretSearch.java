
public class SecretSearch{
    double xa, ya, va, xb, yb, vb;
    public SecretSearch(double xa, double ya, double va, double xb, double yb, double vb) {
        this.xa = xa;
        this.ya = ya;
        this.va = va;
        this.xb = xb;
        this.yb = yb;
        this.vb = vb;
    }
    private double sqrt(double X) {
        if (X == 0) return 0;
        double eps = 0.000001;
        double min = 0;
        double max = X;
        if (X < 1) {
          max = 1;
        }
        while (max - min > eps) {
          double mid = (min + max) / 2.0;
          if (mid * mid < X) {
            min = mid;
          } else {
            max = mid;
          }
        }
        return max;
      }
    
    public double minTimeA() {
        
        return sqrt(Math.abs(this.ya)/this.va);

    }

    public double timeFromA(double XZ) {
        return sqrt((xa - XZ) * (xa - XZ) + ya*ya);
    }

    public double pointC() {
        double X = Math.abs(xb - xa);
        double eps = 0.000001;
        double min = xa;
        double max = xb;
        if (X < 1) {
          max = 1;
        }
        while (max - min > eps) {
          double mid = (max - min) / 2.0 + min;
          if (checkC(mid)) {
            min = mid;
          } else {
            max = mid;
          }
        }
        return min;
      }
    private boolean checkC(double mid) {
        double first = vb*vb*((xa-mid)*(xa-mid) + ya*ya);
        double second = va*va*((xb-mid)*(xb-mid) + yb*yb);
        return first < second;

    }


    
    public static void main(String[] args) {
        SecretSearch test = new SecretSearch(-1, 1, 1, 1, -1, 0.5);
        System.out.printf("%.6f\n",test.minTimeA());
        System.out.printf("%.6f\n",test.timeFromA(0));
        System.out.printf("%.6f\n",test.pointC());
        
    }

}