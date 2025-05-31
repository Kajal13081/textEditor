package org.example.texteditor.ui;

import org.example.texteditor.actions.FormatActions;
import org.example.texteditor.actions.FileActions;
import org.example.texteditor.actions.EditActions;
import org.example.texteditor.actions.TextActions;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public MenuBar(TextEditorPanel editorPanel, TextActions textActions) {
        // Create File Menu
        JMenu fileMenu = new JMenu("File");

        // Open Item
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new FileActions.OpenAction(editorPanel.getTextArea()));
        fileMenu.add(openItem);

        // Save Item
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new FileActions.SaveAction(editorPanel.getTextArea()));
        fileMenu.add(saveItem);
        fileMenu.addSeparator();

        // Exit Item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new FileActions.ExitAction());
        fileMenu.add(exitItem);

        // Create Edit Menu
        JMenu editMenu = new JMenu("Edit");

        // Cut Item
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(new EditActions.CutAction(editorPanel.getTextArea()));
        editMenu.add(cutItem);

        // Copy Item
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(new EditActions.CopyAction(editorPanel.getTextArea()));
        editMenu.add(copyItem);

        // Paste Item
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(new EditActions.PasteAction(editorPanel.getTextArea()));
        editMenu.add(pasteItem);

        // Add actions for Find and Replace
        JMenuItem findItem = new JMenuItem(textActions.findAction);
        editMenu.add(findItem);

//        JMenuItem findNextItem = new JMenuItem(textActions.findNextAction); // Add Find Next
//        editMenu.add(findNextItem);

        JMenuItem replaceItem = new JMenuItem(textActions.replaceAction);
        editMenu.add(replaceItem);

        // Add the Edit Menu to the menu bar
        add(fileMenu);
        add(editMenu);

        // Create Format Menu for styling actions
        JMenu formatMenu = new JMenu("Format");

        // Add Bold, Italic, Font Color, Font Family, and Font Size actions to the Format menu
        formatMenu.add(new JMenuItem(new FormatActions.CleanUpAction(editorPanel.getTextArea())));
        formatMenu.add(new JMenuItem(new FormatActions.BoldAction(editorPanel.getTextArea())));
        formatMenu.add(new JMenuItem(new FormatActions.ItalicAction(editorPanel.getTextArea())));
        formatMenu.add(new JMenuItem(new FormatActions.FontColorAction(editorPanel.getTextArea())));

        // Add Font Family options
        JMenu fontFamilyMenu = new JMenu("Font Family");
        for (String fontFamily : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
            fontFamilyMenu.add(new JMenuItem(new FormatActions.FontFamilyAction(editorPanel.getTextArea(), fontFamily)));
        }
        formatMenu.add(fontFamilyMenu);

        // Add Font Size options
        JMenu fontSizeMenu = new JMenu("Font Size");
        Integer[] fontSizes = {12, 14, 16, 18, 20, 24, 28, 32};
        for (int fontSize : fontSizes) {
            fontSizeMenu.add(new JMenuItem(new FormatActions.FontSizeAction(editorPanel.getTextArea(), fontSize)));
        }
        formatMenu.add(fontSizeMenu);

        // Add the Format menu to the menu bar
        add(formatMenu);
    }
}
