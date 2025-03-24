package com.itheima.clone;

public class MyClass implements Cloneable {

    private String field1;
    private NestedClass nestedClass;

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        MyClass myClass = (MyClass) super.clone();
//        myClass.nestedClass = (NestedClass) nestedClass.clone();
//        return myClass;
        MyClass myclass = (MyClass) super.clone();
        myclass.nestedClass = (NestedClass) nestedClass.clone();
        return myclass;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public NestedClass getNestedClass() {
        return nestedClass;
    }

    public void setNestedClass(NestedClass nestedClass) {
        this.nestedClass = nestedClass;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass myClass = new MyClass();
        myClass.setField1("Hello");
        myClass.setNestedClass(new NestedClass());
        myClass.getNestedClass().setNestedField(100);

        // 克隆对象
        MyClass cloned = (MyClass) myClass.clone();

        // 输出原始对象和克隆对象的属性
        System.out.println("Original field1: " + myClass.getField1());
        System.out.println("Cloned field1: " + cloned.getField1());

        System.out.println("Original nestedField: " + myClass.getNestedClass().getNestedField());
        System.out.println("Cloned nestedField: " + cloned.getNestedClass().getNestedField());

        //修改克隆对象的值 看看原对象是否会受到影响
        cloned.setField1("World");
        cloned.setNestedClass(new NestedClass());
        cloned.getNestedClass().setNestedField(200);

        // 输出原始对象和克隆对象的属性
        System.out.println("Original field1: " + myClass.getField1());
        System.out.println("Cloned field1: " + cloned.getField1());

        System.out.println("Original nestedField: " + myClass.getNestedClass().getNestedField());
        System.out.println("Cloned nestedField: " + cloned.getNestedClass().getNestedField());
    }
}

class NestedClass implements Cloneable {

    private int nestedField;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    };

    public int getNestedField() {
        return nestedField;
    }

    public void setNestedField(int nestedField) {
        this.nestedField = nestedField;
    }
}
