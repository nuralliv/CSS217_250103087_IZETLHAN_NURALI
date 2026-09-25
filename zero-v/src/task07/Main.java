package task07;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        InventoryIteratorAdapter provider = new InventoryIteratorAdapter(new LegacyInventory());
        Iterator<String> iterator = provider.getInventoryIterator();
        while (iterator.hasNext()) {
            System.out.println("Item: " + iterator.next());
        }
    }
}
