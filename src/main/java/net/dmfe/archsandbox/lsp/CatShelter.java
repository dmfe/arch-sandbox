package net.dmfe.archsandbox.lsp;

import java.io.IOException;

public class CatShelter extends AnimalShelter {

    void accept(Cat cat) {
        System.out.println("This is cat!");
    }

    Cat get() throws IOException {
        return new Cat();
    }
}
