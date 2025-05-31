package org.example.texteditor.ui;

import javax.swing.*;
import java.awt.*;

import org.example.texteditor.actions.TextActions;
import org.example.texteditor.utils.AutoIndent;
import org.example.texteditor.utils.SyntaxHighlighter;

public class MainFrame extends JFrame {

    // The Main Frame that ties together the UI components
    private final TextEditorPanel editorPanel;
    private TextActions textActions;
    private final JMenuBar menuBar;

    public MainFrame() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        editorPanel = new TextEditorPanel();
        textActions = new TextActions(editorPanel);
        setLayout(new BorderLayout());
        add(editorPanel, BorderLayout.CENTER);

        // Enable auto-indentation
        // AutoIndent.enableAutoIndent(editorPanel.getTextArea());

        // Enable syntax highlighting
        SyntaxHighlighter.enableSyntaxHighlighting(editorPanel.getTextArea());

        menuBar = new MenuBar(editorPanel, textActions);
        setJMenuBar(menuBar);


        // Set up the toolbar (if you have one)
        //FormatToolbar toolbar = new FormatToolbar(editorPanel);
        //add(toolbar, BorderLayout.NORTH);
    }
}
