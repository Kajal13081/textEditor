package org.example.texteditor.actions;

import org.example.texteditor.ui.TextEditorPanel;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TextActions {

    private final TextEditorPanel editorPanel;
    private final UndoManager undoManager;

    // List to store positions of all occurrences of the search term
    private List<Integer> searchResults = new ArrayList<>();
    private int currentSearchIndex = -1;  // Track the current position of the search

    public TextActions(TextEditorPanel editorPanel) {
        this.editorPanel = editorPanel;
        this.undoManager = new UndoManager();
        enableUndoRedo();
    }

    // Action for Find
    public Action findAction = new AbstractAction("Find") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchTerm = JOptionPane.showInputDialog("Enter text to find:");
            if (searchTerm != null && !searchTerm.isEmpty()) {
                searchResults.clear();  // Clear previous search results
                currentSearchIndex = -1;  // Reset search index
                highlightSearchTerm(searchTerm);
            }
        }
    };

    // Action for Find Next
    public Action findNextAction = new AbstractAction("Find Next") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (searchResults.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No search results found.");
                return;
            }
            // Unhighlight the previous search result before highlighting the next
            removePreviousHighlight();

            // Move to the next result (circular behavior)
            currentSearchIndex = (currentSearchIndex + 1) % searchResults.size();
            int start = searchResults.get(currentSearchIndex);
            highlightSearchTermAtPosition(start, start + editorPanel.getTextArea().getText().length());
        }
    };

    // Method to unhighlight the previously highlighted term
    private void removePreviousHighlight() {
        Highlighter highlighter = editorPanel.getTextArea().getHighlighter();
        highlighter.removeAllHighlights(); // Clear all highlights
    }

    // Action for Replace
    public Action replaceAction = new AbstractAction("Replace") {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the currently selected text
            String selectedText = editorPanel.getTextArea().getSelectedText();

            if (selectedText != null && !selectedText.isEmpty()) {
                // Prompt user for the replacement text
                String replaceTerm = JOptionPane.showInputDialog("Replace with:");

                // If the user enters a replacement term, replace the selected text
                if (replaceTerm != null && !replaceTerm.isEmpty()) {
                    replaceSelectedText(selectedText, replaceTerm);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a text to replace.");
            }
        }
    };

    // Method to replace the selected text with the replacement term
    private void replaceSelectedText(String selectedText, String replaceTerm) {
        try {
            // Get the current document from the text area
            JTextPane textArea = editorPanel.getTextArea();
            Document doc = textArea.getDocument();

            // Get the selection's start and end position
            int selectionStart = textArea.getSelectionStart();
            int selectionEnd = textArea.getSelectionEnd();

            // Replace the selected text with the new text
            doc.remove(selectionStart, selectionEnd - selectionStart);
            doc.insertString(selectionStart, replaceTerm, null);

            // Optional: Highlight the newly inserted text
            // highlightSearchTermAtPosition(selectionStart, selectionStart + replaceTerm.length());

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    // Action for Undo
    public Action undoAction = new AbstractAction("Undo") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        }
    };

    // Action for Redo
    public Action redoAction = new AbstractAction("Redo") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        }
    };

    // Method to highlight the search term in the text area (highlight all matches)
    private void highlightSearchTerm(String searchTerm) {
        String content = editorPanel.getTextArea().getText();
        Highlighter highlighter = editorPanel.getTextArea().getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

        highlighter.removeAllHighlights(); // Clear previous highlights
        int index = content.indexOf(searchTerm);
        int matchCount = 0;

        // Highlight all occurrences of the search term and store their positions
        while (index >= 0) {
            try {
                highlighter.addHighlight(index, index + searchTerm.length(), painter);
                searchResults.add(index);  // Store the position
                matchCount++;
                index = content.indexOf(searchTerm, index + 1); // Look for the next occurrence
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        // Show a message with the number of matches found
        if (matchCount > 0) {
            JOptionPane.showMessageDialog(null, matchCount + " occurrences found.");
            highlighter.removeAllHighlights();
        } else {
            JOptionPane.showMessageDialog(null, "Text not found.");
        }
    }

    // Method to highlight a specific search result based on position
    private void highlightSearchTermAtPosition(int start, int end) {
        try {
            Highlighter highlighter = editorPanel.getTextArea().getHighlighter();
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            highlighter.removeAllHighlights(); // Clear previous highlights
            highlighter.addHighlight(start, end, painter);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    // Method to enable Undo and Redo functionality
    public void enableUndoRedo() {
        editorPanel.getTextArea().getDocument().addUndoableEditListener(undoManager);
    }
}
