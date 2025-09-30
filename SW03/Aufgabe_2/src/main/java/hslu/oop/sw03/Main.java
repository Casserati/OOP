package hslu.oop.sw03;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int i = 0;

        for (i = 0; i <= 10; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println(i);
        }

        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

        exerciseC(0.9f);

        printBox(10, 4);
    }

    private static void exerciseC(float initValue){
        int count = 0;
//        while (initValue <= 1.0f){
//            initValue += 0.000025f;
//            count++;
//            System.out.println(initValue);
//            System.out.println("Counter: " + count);
//        }

        for(int i = 0; i <= 4000; i++){
            initValue += 0.000025f;
            System.out.println(initValue);
        }
    }

    private static void printBox(final int width, final int height){
        for (int i = 1; i <= height; i++){
            System.out.print("\n");
            for (int o = 1; o <= width; o++){
                if (i == 1 || i == height){
                    System.out.print("#");
                }else if (o == 1 || o == width){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
        }
    }
}