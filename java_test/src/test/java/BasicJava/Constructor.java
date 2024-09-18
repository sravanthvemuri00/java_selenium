package BasicJava;

import java.awt.image.SampleModel;

public class Constructor {
    static int a=2;
    public Constructor()
    {
        a=1;
        System.out.println("con "+a);
    }
    public void m1()
    {
        System.out.println("m1");
    }
    public void m2()
    {
    a=10;
        System.out.println(a);
    }

    public static void main(String[] args) {
        Constructor c=new Constructor();


    }
}

