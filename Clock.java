import java.util.*;
public class Clock {
  public static double angle(int h, int m) {
    double anglemin = m * 6;
    if(h == 12) {
      h = 0;
    }if(m == 60) {
      m = 0;
    }
    double angleh = (h * 30) + ((double) m/2.0);
    double diff = anglemin - angleh;
    return Math.abs(diff);

  }

  public static void main(String[] args) {
    System.out.println(angle(12, 00));

  }
}
