package Homeworks_01;

import java.util.Objects;

/*
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
        System.out.println(iphone1.equals(null));
    }

    public boolean equals(Object _obj) {
        if (_obj == null) return false;
        Iphone obj = (Iphone) _obj;
        if (price != obj.price) return false;
        if (model == null) {
            if (obj.model != null) return false;
        }
        else if (!model.equals(obj.model)) return false;
        if (color == null) {
            if (obj.color != null) return false;
        }
        else if (!color.equals(obj.color)) return false;
        return true;
    }

}