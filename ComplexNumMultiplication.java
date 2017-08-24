public class ComplexNumMultiplication {

  public static void main(String[] args) {
    System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
  }

  public static String complexNumberMultiply(String a, String b) {
    //split the two input strings into an array of four strings
    String[] a_split = a.split("\\+"); //[a, bi]
    String[] b_split = b.split("\\+"); //[a, bi]

    //handle the multiplication of those four items
    //handle special multiplication of i values
    //come up with answer in correct format
    return compute(a_split[0], a_split[1], b_split[0], b_split[1]);
  }

  private static String compute(String a1, String ai, String b1, String bi) {
    int real = Integer.parseInt(a1) * Integer.parseInt(b1);
    String imaginary;

    String bi_minusi = bi.substring(0, bi.length() - 1);
    String ai_minusi = ai.substring(0, ai.length() - 1);

    int first_middle = Integer.parseInt(a1) * Integer.parseInt(bi_minusi);
    int second_middle = Integer.parseInt(b1) * Integer.parseInt(ai_minusi);
    int total_middle = first_middle + second_middle;
    imaginary = total_middle + "i";

    real = real - (Integer.parseInt(bi_minusi) * Integer.parseInt(ai_minusi));

    return real + "+" + imaginary;
  }

}
