package net.dmfe.archsandbox.lsp;

public class RectangleFactory implements AbstractRectangleFactory {

    @Override
    public Rectangle get() {
        return new Rectangle();
    }

}
