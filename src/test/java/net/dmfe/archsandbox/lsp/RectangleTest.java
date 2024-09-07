package net.dmfe.archsandbox.lsp;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void rectangleTest() {
        Rectangle rectangle = ServiceLoader.load(AbstractRectangleFactory.class).findFirst().orElseThrow().get();

        rectangle.setHeight(10);
        rectangle.setWidth(5);

        assertEquals(50, rectangle.getArea());
    }

}
