package hslu.oop.sw03;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    private int max(int value1, int value2) {
        return Math.max(value1, value2);
    }

    private int max(int value1, int value2, int value3) {
        return Math.max(value1, max(value2, value3));
    }
}