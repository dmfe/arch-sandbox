package net.dmfe.archsandbox.lsp;

public class Square extends Rectangle {

    void setSize(int size) {
        height = size;
        width = size;
    }

    @Override
    public void setHeight(int height) {
        setSize(height);
    }

    @Override
    public void setWidth(int width) {
        setSize(width);
    }
}
