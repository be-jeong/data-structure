package com.example.datastructure.basic.set;

public class SetPractice {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        B b1 = new B(18);
        B b2 = new B(55);

        //java가 임의로 부여한 해시값을 출력
        System.out.println(a1.toString());
        //이건 a2객체를 그대로 출력함. 그러면 object 클래스의 toString 호출함
        System.out.println(a2);
        System.out.println(b1.toString());
        System.out.println(b2);
    }
}

class A {

}

class B {
    int x;

    B(int x) {
        this.x = x;
    }

    public String toString() {
        return "B[" + x + "]";
    }
}
