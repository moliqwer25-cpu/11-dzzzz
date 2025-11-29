import javax.swing.*;
import java.awt.*;

public class LogisticsComponentDiagram extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // Цвет компонентов
        Color compColor = new Color(173, 216, 230);

        // Frontend
        g2.setColor(compColor);
        g2.fillRoundRect(50, 50, 180, 80, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(50, 50, 180, 80, 20, 20);
        g2.drawString("Frontend", 110, 70);
        g2.drawString("REST API, WebSocket", 60, 90);
        g2.drawString("Display info, collect data", 60, 105);

        // Backend
        g2.setColor(compColor);
        g2.fillRoundRect(300, 50, 180, 80, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(300, 50, 180, 80, 20, 20);
        g2.drawString("Backend", 370, 70);
        g2.drawString("Database, RouteModule, Notification", 310, 90);
        g2.drawString("Process orders, manage logic", 310, 105);

        // Database
        g2.setColor(compColor);
        g2.fillRoundRect(300, 160, 180, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(300, 160, 180, 60, 20, 20);
        g2.drawString("Database", 370, 180);
        g2.drawString("Orders, Products, Clients, Routes", 310, 195);

        // Route Optimization Module
        g2.setColor(compColor);
        g2.fillRoundRect(550, 50, 200, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(550, 50, 200, 60, 20, 20);
        g2.drawString("RouteOptimizationModule", 560, 70);
        g2.drawString("Calculate optimal delivery routes", 560, 85);

        // Courier Integration Module
        g2.setColor(compColor);
        g2.fillRoundRect(50, 200, 220, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(50, 200, 220, 60, 20, 20);
        g2.drawString("CourierIntegrationModule", 60, 220);
        g2.drawString("Courier API, Webhook", 60, 235);
        g2.drawString("Manage deliveries & couriers", 60, 250);

        // Inventory Module
        g2.setColor(compColor);
        g2.fillRoundRect(300, 250, 180, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(300, 250, 180, 60, 20, 20);
        g2.drawString("InventoryModule", 370, 270);
        g2.drawString("SQL, Inventory API", 310, 285);
        g2.drawString("Track stock, reserve & move", 310, 300);

        // Notification System
        g2.setColor(compColor);
        g2.fillRoundRect(600, 200, 180, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(600, 200, 180, 60, 20, 20);
        g2.drawString("NotificationSystem", 620, 220);
        g2.drawString("Send notifications", 620, 235);

        // Analytics System
        g2.setColor(compColor);
        g2.fillRoundRect(600, 300, 180, 60, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(600, 300, 180, 60, 20, 20);
        g2.drawString("AnalyticsSystem", 650, 320);
        g2.drawString("Reports & performance analysis", 610, 335);

        // Взаимодействие (стрелки)
        g2.drawLine(230, 90, 300, 90); // Frontend -> Backend
        g2.drawLine(390, 130, 390, 160); // Backend -> Database
        g2.drawLine(480, 80, 550, 80); // Backend -> RouteModule
        g2.drawLine(240, 230, 300, 280); // CourierIntegration -> Inventory
        g2.drawLine(480, 280, 600, 230); // Backend -> Notification
        g2.drawLine(480, 280, 600, 320); // Backend -> Analytics
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Logistics System Component Diagram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 450);
        frame.add(new LogisticsComponentDiagram());
        frame.setVisible(true);
    }
}
