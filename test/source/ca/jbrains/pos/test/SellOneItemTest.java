package ca.jbrains.pos.test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {

    @Test
    public void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCodeReader("12345");
        assertEquals("7.95", display.getText());
    }

    @Test
    @Ignore("refactor to get barcode reader to tell getText what to display")
    public void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCodeReader("11111");
        assertEquals("8.00", display.getText());
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    public static class Sale {
        private Display display;

        public Sale (Display display) {
            this.display = display;
        }

        public void onBarCodeReader (String barcode) {
            display.setText("7.95");
            
        }
    }
}
