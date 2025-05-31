package org.example.texteditor.actions;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormatActions {

    // CleanUp Action
    public static class CleanUpAction extends AbstractAction {
        private final JTextPane textPane;

        public CleanUpAction(JTextPane textPane) {
            super("Clean Up");
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textPane.setDocument(new DefaultStyledDocument());
        }
    }

    // Bold Action
    public static class BoldAction extends AbstractAction {
        private final JTextPane textPane;

        public BoldAction(JTextPane textPane) {
            super("Bold");
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            if (start != end) {  // If text is selected
                SimpleAttributeSet style = new SimpleAttributeSet();
                boolean isBold = StyleConstants.isBold(doc.getCharacterElement(start).getAttributes());

                // Toggle bold style
                StyleConstants.setBold(style, !isBold);
                doc.setCharacterAttributes(start, end - start, style, false);
                textPane.repaint();  // Ensure it repaints after applying style
            } else {
                System.out.println("No text selected.");
            }
        }
    }

    // Italic Action
    public static class ItalicAction extends AbstractAction {
        private final JTextPane textPane;

        public ItalicAction(JTextPane textPane) {
            super("Italic");
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            if (start != end) {  // If text is selected
                SimpleAttributeSet style = new SimpleAttributeSet();
                boolean isItalic = StyleConstants.isItalic(doc.getCharacterElement(start).getAttributes());

                // Toggle italic style
                StyleConstants.setItalic(style, !isItalic);
                doc.setCharacterAttributes(start, end - start, style, false);
                textPane.repaint();  // Ensure it repaints after applying style
            } else {
                System.out.println("No text selected.");
            }
        }
    }

    // Font Color Action
    public static class FontColorAction extends AbstractAction {
        private final JTextPane textPane;

        public FontColorAction(JTextPane textPane) {
            super("Font Color");
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = JColorChooser.showDialog(null, "Choose Font Color", Color.BLACK);
            if (color != null) {
                StyledDocument doc = textPane.getStyledDocument();
                int start = textPane.getSelectionStart();
                int end = textPane.getSelectionEnd();

                if (start != end) {  // If text is selected
                    SimpleAttributeSet style = new SimpleAttributeSet();
                    StyleConstants.setForeground(style, color);
                    doc.setCharacterAttributes(start, end - start, style, false);
                    textPane.repaint();  // Ensure it repaints after applying style
                }
            }
        }
    }

    // Font Family Action
    public static class FontFamilyAction extends AbstractAction {
        private final JTextPane textPane;
        private final String fontFamily;

        public FontFamilyAction(JTextPane textPane, String fontFamily) {
            super("Font Family: " + fontFamily);
            this.textPane = textPane;
            this.fontFamily = fontFamily;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            if (start != end) {  // If text is selected
                SimpleAttributeSet style = new SimpleAttributeSet();
                StyleConstants.setFontFamily(style, fontFamily);
                doc.setCharacterAttributes(start, end - start, style, false);
                textPane.repaint();  // Ensure it repaints after applying style
            }
        }
    }

    // Font Size Action
    public static class FontSizeAction extends AbstractAction {
        private final JTextPane textPane;
        private final int fontSize;

        public FontSizeAction(JTextPane textPane, int fontSize) {
            super("Font Size: " + fontSize);
            this.textPane = textPane;
            this.fontSize = fontSize;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StyledDocument doc = textPane.getStyledDocument();
            int start = textPane.getSelectionStart();
            int end = textPane.getSelectionEnd();

            if (start != end) {  // If text is selected
                SimpleAttributeSet style = new SimpleAttributeSet();
                StyleConstants.setFontSize(style, fontSize);
                doc.setCharacterAttributes(start, end - start, style, false);
                textPane.repaint();  // Ensure it repaints after applying style
            }
        }
    }

    // Call this method only once in the TextEditorPanel to set the document
    public static void setStyledDocument(JTextPane textPane) {
        textPane.setDocument(new DefaultStyledDocument());
    }
}
