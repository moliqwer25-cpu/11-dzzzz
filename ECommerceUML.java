import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ECommerceUML extends JFrame {

    private List<ClassBox> classes = new ArrayList<>();

    public ECommerceUML() {
        setTitle("E-Commerce UML Diagram");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Кластарды анықтау
        classes.add(new ClassBox("User", 50, 50,
                new String[]{"id", "name", "email", "address", "phone", "role"},
                new String[]{"register()", "login()", "updateData()"}));
        classes.add(new ClassBox("Customer", 300, 50,
                new String[]{},
                new String[]{}));
        classes.add(new ClassBox("Admin", 300, 200,
                new String[]{},
                new String[]{}));
        classes.add(new ClassBox("Product", 50, 200,
                new String[]{"id", "name", "description", "price", "stock", "category"},
                new String[]{"create()", "update()", "delete()"}));
        classes.add(new ClassBox("Order", 50, 400,
                new String[]{"id", "date", "status", "customer", "products", "total"},
                new String[]{"placeOrder()", "cancel()", "pay()"}));
        classes.add(new ClassBox("Payment", 400, 400,
                new String[]{"id", "type", "amount", "status", "date"},
                new String[]{"process()", "refund()"}));
        classes.add(new ClassBox("Delivery", 700, 400,
                new String[]{"id", "address", "status", "courier"},
                new String[]{"send()", "track()", "complete()"}));

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // Кластарды салу
        for (ClassBox cls : classes) {
            cls.draw(g2);
        }

        // Наследование
        drawInheritance(g2, 50 + 100, 50 + 120, 300 + 100, 50); // User -> Customer
        drawInheritance(g2, 50 + 100, 50 + 120, 300 + 100, 200); // User -> Admin

        // Ассоциации
        drawAssociation(g2, 50 + 100, 400 + 120, 400 + 100, 400); // Order -> Payment
        drawAssociation(g2, 50 + 100, 400 + 120, 700 + 100, 400); // Order -> Delivery
        drawAssociation(g2, 50 + 100, 400 + 20, 50 + 100, 200); // Order -> Product
    }

    private void drawInheritance(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.drawLine(x1, y1, x2, y2);
        g2.fillPolygon(new int[]{x2 - 10, x2, x2 + 10}, new int[]{y2 + 10, y2, y2 + 10}, 3);
    }

    private void drawAssociation(Graphics2D g2, int x1, int y1, int x2, int y2) {
        g2.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        new ECommerceUML();
    }

    // Класс для визуализации UML класса
    static class ClassBox {
        String name;
        String[] attributes;
        String[] methods;
        int x, y;
        int width = 200;
        int height = 120;

        public ClassBox(String name, int x, int y, String[] attributes, String[] methods) {
            this.name = name;
            this.attributes = attributes;
            this.methods = methods;
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics2D g2) {
            int attrHeight = attributes.length * 15;
            int methHeight = methods.length * 15;
            int totalHeight = 20 + attrHeight + methHeight + 10;

            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, totalHeight);
            g2.setColor(Color.BLACK);
            g2.drawRect(x, y, width, totalHeight);
            g2.drawLine(x, y + 20, x + width, y + 20); // разделитель имени
            g2.drawLine(x, y + 20 + attrHeight, x + width, y + 20 + attrHeight); // разделитель атрибутов

            g2.drawString(name, x + 10, y + 15);
            int curY = y + 35;
            for (String attr : attributes) {
                g2.drawString(attr, x + 10, curY);
                curY += 15;
            }
            for (String method : methods) {
                g2.drawString(method, x + 10, curY);
                curY += 15;
            }
        }
    }
}
