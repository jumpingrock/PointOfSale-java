package ca.jbrains.pos.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SellOneItemTest {



    private Display display;
    private Sale sale;

    @Before
    public void setup() {
        Map<String, String> priceByBarcode = new HashMap<String, String>() {{
            put("12345", "7.95");
            put("23456", "12.50");
        }};

        display = new Display();
        sale = new Sale(display, (HashMap)priceByBarcode);
    }

    @Test
    public void productFound() {

        sale.onBarCodeReader("12345");
        assertEquals("7.95", display.getText());
    }

    @Test
    public void anotherProductFound() {

        sale.onBarCodeReader("23456");
        assertEquals("12.50", display.getText());
    }

    @Test
    public void productNotFounnd() {

        sale.onBarCodeReader("99999");
        assertEquals("Product not found 99999", display.getText());
    }

    @Test
    public void emptyBarcode() {

        sale.onBarCodeReader("");
        assertEquals("Product not found: Empty barcode", display.getText());
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
        private Map<String, String> priceByBarcode;

        public Sale (Display display, HashMap<String, String> priceByBarcode) {

            this.display = display;
            this.priceByBarcode = priceByBarcode;
        }

        public void onBarCodeReader (String barcode) {

            if ("".equals(barcode)){
                display.setText("Product not found: Empty barcode");
                return;
            }

            if (priceByBarcode.containsKey(barcode)){
                display.setText(priceByBarcode.get(barcode));

            }else {
                display.setText("Product not found " + barcode);

            }
        }
    }
}
