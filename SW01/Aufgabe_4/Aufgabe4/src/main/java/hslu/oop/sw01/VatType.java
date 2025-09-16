package hslu.oop.sw01;

public enum VatType {
    normal(8.1),
    reduced(2.6),
    special(3.8);

    private VatType(double vatValue) {}
}
