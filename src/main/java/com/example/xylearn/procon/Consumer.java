package com.example.xylearn.procon;

import lombok.SneakyThrows;

public class Consumer extends Thread{
    private Foods foods;

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public Consumer(String name, Foods foods) {
        super(name);
        this.foods = foods;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                foods.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
