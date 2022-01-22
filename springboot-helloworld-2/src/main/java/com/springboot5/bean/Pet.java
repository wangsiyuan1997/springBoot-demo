package com.springboot5.bean;

/**
 * @Date And @Time: 2022/1/7  22:38
 */
public class Pet {
    private String name;
    private Double weight;

    public Pet() {
    }

    public Pet(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
