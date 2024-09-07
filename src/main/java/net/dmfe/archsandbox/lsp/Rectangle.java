package net.dmfe.archsandbox.lsp;

public class Rectangle {

    int height;
    int width;

    public int getArea() {
        return height * width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
