package org.example.texteditor.custom;

import javax.swing.*;
import java.awt.*;

public class customButton extends JButton {

    private int radius = 40;  // Default radius for rounded corners

    // Constructor with text
    public customButton(String text) {
        super(text);
        setContentAreaFilled(false); // Disable default background filling
        setFocusPainted(false); // Disable focus painted (highlighted border when clicked)
        setBackground(new Color(255, 255, 255)); // Set default button background
        //setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Set border
        setFont(new Font("Arial", Font.TRUETYPE_FONT, 13)); // Set font for text
    }

    // Constructor to set custom radius
    public customButton(String text, int radius) {
        this(text);
        this.radius = radius;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        // Check if the button is pressed or hovered
//        if (getModel().isPressed()) {
//            g.setColor(new Color(200, 200, 200)); // Set color for pressed state
//        } else if (getModel().isRollover()) {
//            g.setColor(new Color(220, 220, 220)); // Set color for hover state
//        } else {
//            g.setColor(new Color(255, 255, 255)); // Default background color
//        }
//
//        // Fill the rounded rectangle with custom color
//        g.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
//
//        // Call the superclass method to draw the text and icon
//        super.paintComponent(g);
//    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
    }

    // Allow setting the button size
    public void setButtonSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    // Optional: Set the border radius dynamically
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
