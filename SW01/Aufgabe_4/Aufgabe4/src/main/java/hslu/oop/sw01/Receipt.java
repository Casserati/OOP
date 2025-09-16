package hslu.oop.sw01;

import java.util.List;

public class Receipt {

    private Provider provider;
    private List<Product> products;
    private double price;

    public void printProvider(){
        System.out.println(provider.getName().toUpperCase());
        System.out.println(provider.getAddress().getStreetname() + " " + provider.getAddress().getHouseNr());
        System.out.println(provider.getAddress().getZipcode() + " " + provider.getAddress().getCity());
        System.out.println("TEL " + provider.getPhoneNumber());
    }

    public void printProducts(){
        for (Product p : products){
            System.out.println(p.getName());
            System.out.println(p.getQuantity() + "x \\t" + p.getPrice());
        }
    }

    private double getPrice(){
        for(Product p : products){
           price += p.getPrice();
        }

        return price;
    }

}
