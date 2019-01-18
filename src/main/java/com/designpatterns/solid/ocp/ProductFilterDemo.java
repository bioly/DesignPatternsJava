package com.designpatterns.solid.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", color=").append(color);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}

interface Specification<T>{
    boolean isSatisfied(T item);
}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product>{

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class AndSpecification<T> implements Specification<T> {

    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterFilter implements Filter<Product>{
    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

class ProductFilter{
    public Stream<Product> findByColor(List<Product> products, Color color){
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> findBySize(List<Product> products, Size size){
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> findBySizeAndColor(List<Product> products, Size size, Color color){
        return products.stream().filter(p -> p.size == size && p.color == color);
    }
}

public class ProductFilterDemo {
    public static void main(String[] args) {
        System.out.println("Products filter demo (OCP): ");

        Product tv_set = new Product("TV Set", Color.BLUE, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);
        Product banans = new Product("Banans", Color.GREEN, Size.SMALL);

        List<Product> products = Arrays.asList(tv_set, house, banans);

        ProductFilter pf = new ProductFilter();
        System.out.println("Filter all GREEN products:");
        pf.findByColor(products, Color.GREEN).forEach(System.out::println);

        System.out.println("Filter by size and color: ");
        pf.findBySizeAndColor(products, Size.LARGE, Color.BLUE).forEach(System.out::println);

        // better practise based on OCP
        BetterFilter bf = new BetterFilter();
        System.out.println("Green products (new): ");
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(System.out::println);

        System.out.println("Large blue items: ");
        bf.filter(products, new AndSpecification<>(new ColorSpecification(Color.BLUE),
                new SizeSpecification(Size.LARGE)))
                .forEach(System.out::println);
    }
}
