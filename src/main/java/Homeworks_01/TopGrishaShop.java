package Homeworks_01;

public class TopGrishaShop {

    private static int count = 1;

    static class User {
        String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }

    public static void main(String[] args) {
        User user = new User("Coder(sha)");
        System.out.println("Hello world");
        int appleSumRubCurrency = 100;
        int appleCount = 5;
        System.out.printf("Пользователь %s начал покупки\n", user.getUserName());
        System.out.println("Вы должы заплатить за яблоки = " + appleCount*appleSumRubCurrency);

        checkBonus(appleCount);

        pickAllItems(appleCount, "Яблоко");
        double discount = getDiscount(appleCount);

        System.out.println("Вы должы заплатить за яблоки с учетом скидки = " + appleCount*appleSumRubCurrency*discount);
        System.out.printf("Пользователь %s закончил покупки\n", user.getUserName());
    }

    private static double getDiscount(int appleCount) {
        double discount = appleCount >= 5
                ? 0.5
                : 1;

        if (discount == 1) {
            System.out.println("Пользователь не получил скидку");
        } else {
            System.out.println("Пользователь получил скидку = " + discount);
        }

        return discount;
    }

    private static void pickAllItems(int appleCount, String itemName) {
        for (int i = 1; i <= appleCount; i++) {
            System.out.println(itemName + " id = " + i);
        }
    }

    private static void checkBonus(int appleCount) {
        if (appleCount > 3) {
            System.out.println("Шопер в подарок");
        }
    }
}