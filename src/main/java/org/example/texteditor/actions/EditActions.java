package org.example.texteditor.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditActions {

    // Handles actions like cut, copy, paste, undo, and redo
    public static class CutAction extends AbstractAction {
        private final JTextPane textPane;

        public CutAction(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textPane.cut(); // Cut selected text
        }
    }

    public static class CopyAction extends AbstractAction {
        private final JTextPane textPane;

        public CopyAction(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textPane.copy(); // Copy selected text
        }
    }

    public static class PasteAction extends AbstractAction {
        private final JTextPane textPane;

        public PasteAction(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textPane.paste(); // Paste clipboard text
        }
    }
}
