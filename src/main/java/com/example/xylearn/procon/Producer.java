package com.example.xylearn.procon;

import lombok.SneakyThrows;

public class Producer extends Thread{
    private Foods foods;

    public Producer(String name, Foods foods) {
        super(name);
        this.foods = foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            foods.produce();
            Thread.sleep(100);

        }

    }
}
