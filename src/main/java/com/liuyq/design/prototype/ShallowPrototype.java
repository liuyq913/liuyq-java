package com.liuyq.design.prototype;

/**
 * @author: liuyuqing
 * @Date: 2020/8/14 14:31
 */
class Field{

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

}

public class ShallowPrototype implements Cloneable {

    private int x;
    private int y;
    private int z;
    private Field field;

    public ShallowPrototype() {
        this.x = 2;
        this.y = 3;
        this.z = 4;
        this.field = new Field();
        this.field.setA(5);
    }

    public Field getField() {
        return field;
    }

    @Override
    public ShallowPrototype clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
        return (ShallowPrototype) object;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "," + field.getA() + "]";
    }

    public static void main(String[] args) {
        ShallowPrototype prototype1 = new ShallowPrototype();
        System.out.println(prototype1);
        System.out.println(prototype1.getField());
        ShallowPrototype prototype2 = prototype1.clone();
        System.out.println(prototype2);
        System.out.println(prototype2.getField());
    }
}