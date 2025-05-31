package org.example.texteditor.ui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorPanel extends JPanel {
    private final JTextPane textPane;
    private final StyledDocument doc;
    // private final JMenuBar menuBar;

    public TextEditorPanel() {
        setLayout(new BorderLayout());

        // Initialize JTextPane with scroll
        textPane = new JTextPane();
        textPane.setEditable(true); // Make it editable
        textPane.setFont(new Font("Arial", Font.PLAIN, 14));
        textPane.setDocument(new DefaultStyledDocument());
        doc = textPane.getStyledDocument();
        textPane.requestFocusInWindow();
        textPane.setFocusable(true);

        // Wrap JTextPane inside a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Set preferred size
        add(scrollPane, BorderLayout.CENTER);

    }

    public JTextPane getTextArea() {
        return textPane;
    }

    public void setText(String text) {
        textPane.setText(text);
    }

    public String getText() {
        return textPane.getText();
    }
}
