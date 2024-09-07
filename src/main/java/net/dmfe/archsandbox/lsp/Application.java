package net.dmfe.archsandbox.lsp;

public class Application {

    public static void main(String[] args) {
        AnimalShelter animalShelter = new CatShelter();
        animalShelter.accept(new Cat());

        CatShelter catShelter = new CatShelter();
        catShelter.accept(new Cat());
    }

}
