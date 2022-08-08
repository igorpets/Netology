package Homeworks_01;

/*
Многосерийный предприниматель
*/

public class Buildings {
    private String type;

    public void initialize(String type) {
        this.type = type;
    }

    //напишите тут ваш код

    public static void main(String[] args) {
        Buildings building = new Buildings(); //"Ресторан"
        building.initialize("Барбершоп");

        String s1 = new String("JavaRush");
        s1 = "JavaRush";
        String s2 = "JavaRush";
//        s2 = new String("JavaRush");
        String s3 = "JavaRush";
//        s3 = new String("JavaRush");
        System.out.println(s1 == s3);
        System.out.println(s2.equals(s3));
    }
}