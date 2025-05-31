package org.example.texteditor.utils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxHighlighter {

    private static final String[] KEYWORDS = {"public", "private", "class", "static", "void", "if", "else", "for", "while"};
    private static final Pattern COMMENT_PATTERN = Pattern.compile("//.*|/\\*.*?\\*/", Pattern.DOTALL);
    private static final Pattern STRING_PATTERN = Pattern.compile("\"(.*?)\"");

    public static void enableSyntaxHighlighting(final JTextPane textPane) {
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> highlightSyntax(textPane));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> highlightSyntax(textPane));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> highlightSyntax(textPane));
            }
        });
    }

    private static void highlightSyntax(JTextPane textPane) {
        String text = textPane.getText();
        StyledDocument doc = (StyledDocument) textPane.getDocument();
        SimpleAttributeSet keywordAttr = createKeywordStyle();
        SimpleAttributeSet commentAttr = createCommentStyle();
        SimpleAttributeSet stringAttr = createStringStyle();

        // Clear previous highlights
        doc.setCharacterAttributes(0, text.length(), new SimpleAttributeSet(), true);

        // Highlight keywords
        for (String keyword : KEYWORDS) {
            highlightPattern(doc, text, keyword, keywordAttr);
        }

        // Highlight comments
        Matcher commentMatcher = COMMENT_PATTERN.matcher(text);
        while (commentMatcher.find()) {
            doc.setCharacterAttributes(commentMatcher.start(), commentMatcher.end() - commentMatcher.start(), commentAttr, false);
        }

        // Highlight strings
        Matcher stringMatcher = STRING_PATTERN.matcher(text);
        while (stringMatcher.find()) {
            doc.setCharacterAttributes(stringMatcher.start(), stringMatcher.end() - stringMatcher.start(), stringAttr, false);
        }
    }

    private static void highlightPattern(StyledDocument doc, String text, String pattern, SimpleAttributeSet attributes) {
        Pattern p = Pattern.compile("\\b" + pattern + "\\b");
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            doc.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), attributes, false);
        }
    }

    private static SimpleAttributeSet createKeywordStyle() {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, Color.BLUE);  // Set color for keywords
        StyleConstants.setBold(style, true);  // Make keywords bold
        return style;
    }

    private static SimpleAttributeSet createCommentStyle() {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, Color.GREEN);  // Set color for comments
        return style;
    }

    private static SimpleAttributeSet createStringStyle() {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setForeground(style, Color.ORANGE);  // Set color for strings
        return style;
    }
}
