package net.dmfe.archsandbox.lsp;

public class AnimalShelter {

    void accept(Animal animal) {
        System.out.println("It's an animal!");
    }

    Animal get() throws Exception {
        return new Animal();
    }

}
