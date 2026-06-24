package week1.codes;

class Computer {
    private String CPU;
    private int RAM;
    private int Storage;

    public Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public void display() {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Storage: " + Storage + " GB");
    }
}

class ComputerBuilder {
    String CPU;
    int RAM;
    int Storage;

    public ComputerBuilder setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder setRAM(int RAM) {
        this.RAM = RAM;
        return this;
    }

    public ComputerBuilder setStorage(int Storage) {
        this.Storage = Storage;
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {

        Computer computer = new ComputerBuilder()
                .setCPU("Intel i7")
                .setRAM(16)
                .setStorage(512)
                .build();

        computer.display();
    }
}