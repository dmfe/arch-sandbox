package net.dmfe.archsandbox.lsp;

public class SquareFactory implements AbstractRectangleFactory {

    @Override
    public Square get() {
        return new Square();
    }

}
