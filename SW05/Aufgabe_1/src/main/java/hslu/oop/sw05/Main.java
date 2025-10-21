package hslu.oop.sw05;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        /**
         * Shape => statischer Datentyp, Circle/Rectangle dynamischer Datentyp
         * dynamische Datentypen können während der Runtime verändert werden. Statice
         * Datentypen bleiben während der ganzen Runtime der gleiche Datentyp
         *
         */
        Shape shape1 = new Circle(10, 10, 20);
        Shape shape2 = new Rectangle(10, 10, 20, 30);

        shape1.move(20, 20);
        shape2.move(30, 30);

        System.out.println(((Circle)shape1).getDiameter());

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}