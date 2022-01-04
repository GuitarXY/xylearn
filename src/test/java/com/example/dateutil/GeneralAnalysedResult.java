package com.example.dateutil;

import com.example.dateutil.base.BaseGeneralResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralAnalysedResult<T extends BaseGeneralResult> {
    List<T> elements = Collections.emptyList();

    public void addElement(T element){
        if (this.elements.isEmpty()) {
            this.elements = new ArrayList<>();
        }

        this.elements.add(element);
    }

    public void resetElements(List<T> elements){
        this.elements = elements;
    }

    public void addElements(List<T> elements){
        if (this.elements.isEmpty()) {
            this.elements = new ArrayList<>();
        }

        this.elements.addAll(elements);
    }

    public List<T> getElements() {
        return elements;
    }
}
