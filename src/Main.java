public class Main {
    public static void main(String[] args) {
        WindowFrame test = new WindowFrame("Test");
        DrawPanel1 panel = new DrawPanel1(test);
        test.add(panel);
    }
}