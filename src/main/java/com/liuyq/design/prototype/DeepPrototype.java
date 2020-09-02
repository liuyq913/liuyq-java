package com.liuyq.design.prototype;

/**
 * @author: liuyuqing
 * @Date: 2020/8/14 14:32
 */
class FieldClone implements Cloneable{

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    protected FieldClone clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
        return (FieldClone) object;
    }

}

public class DeepPrototype implements Cloneable {

    private int x;
    private int y;
    private int z;
    private FieldClone field;

    public DeepPrototype() {
        this.x = 2;
        this.y = 3;
        this.z = 4;
        this.field = new FieldClone();
        this.field.setA(5);
    }

    public FieldClone getField() {
        return field;
    }

    protected DeepPrototype clone() {
        Object object = null;
        try {
            object = super.clone();
            ((DeepPrototype)object).field = this.field.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
        return (DeepPrototype) object;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "," + field.getA() + "]";
    }

    public static void main(String[] args) {
        DeepPrototype prototype1 = new DeepPrototype();
        System.out.println(prototype1);
        System.out.println(prototype1.getField());
        DeepPrototype prototype2 = prototype1.clone();
        System.out.println(prototype2);
        System.out.println(prototype2.getField());
    }

}