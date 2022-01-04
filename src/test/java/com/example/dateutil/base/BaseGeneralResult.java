package com.example.dateutil.base;


public abstract class BaseGeneralResult<E> {

    private E element;


    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }


    @Override
    public String toString() {
        return "BaseGeneralElement{" +
                "element=" + element +
                '}';
    }
}
