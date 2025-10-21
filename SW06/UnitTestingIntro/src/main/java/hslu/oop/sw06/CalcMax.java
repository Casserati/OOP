package hslu.oop.sw06;

public class CalcMax {

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int max(int x,int y,int z){
        return max(x,y) > z ? max(x,y) : z;
    }
}
