package softwaretesting.example.utilities;

public class Util {

  public long randomNumber() {
    return System.currentTimeMillis();
  }

  public static void main(String[] args) {
    Util variable = new Util();
    String text = String.valueOf(variable.randomNumber());
    String text2 = "Hiep" + text + "@gmail.com";
    System.out.println(variable.randomNumber());
    // String text = String.valueOf(utilities.randomNumber());
    System.out.println("Text: " + text2);
  }
}
