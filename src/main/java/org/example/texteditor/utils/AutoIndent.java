package org.example.texteditor.utils;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AutoIndent {
// Auto-indentation will adjust the indentation of the lines when the user presses "Enter" or pastes content.
// It will check the previous line's indentation level and replicate it for the new line.
    public static void enableAutoIndent(final JTextArea textArea) {
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int caretPos = textArea.getCaretPosition();
                    try {
                        String previousLine = getPreviousLine(textArea, caretPos);
                        String indent = getIndentation(previousLine);

                        // Insert the same indentation at the beginning of the new line
                        textArea.insert(indent, caretPos);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private static String getPreviousLine(JTextArea textArea, int caretPos) throws BadLocationException {
        int lineStart = textArea.getLineOfOffset(caretPos) - 1;
        if (lineStart < 0) {
            return "";
        }
        int lineStartPos = textArea.getLineStartOffset(lineStart);
        int lineEndPos = textArea.getLineEndOffset(lineStart);
        return textArea.getText(lineStartPos, lineEndPos - lineStartPos).trim();
    }

    private static String getIndentation(String line) {
        StringBuilder indent = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Character.isWhitespace(c)) {
                indent.append(c);
            } else {
                break;
            }
        }
        return indent.toString();
    }
}

