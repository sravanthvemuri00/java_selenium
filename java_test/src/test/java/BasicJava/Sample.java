package BasicJava;

public class Sample extends Constructor {
    static int a=10;
    public void m4() {
        System.out.println(a);
        a=20;

    }

    public void m3() {
        System.out.println(a);
        System.out.println(super.a);

    }

    public static void main(String[] args) {
        Sample s=new Sample();
        s.m4();
        s.m3();



    }
}
