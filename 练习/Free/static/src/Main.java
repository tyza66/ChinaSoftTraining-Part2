public class Main {
    public static void main(String[] args) {
        TestStatic testStatic1 = new TestStatic();
        TestStatic testStatic2 = new TestStatic();

        System.out.println(testStatic1.my + " 1 " +testStatic1.all);
        System.out.println(testStatic2.my + " 2 " +testStatic2.all);


        System.out.println();
        TestStatic.all = 2;
        testStatic1.my = 96;

        System.out.println(testStatic1.my + " 1 " +testStatic1.all);
        System.out.println(testStatic2.my + " 2 " +testStatic2.all);

        TestStatic testStatic3 = new TestStatic();
        System.out.println(testStatic3.my + " 2 " +testStatic3.all);
    }
}