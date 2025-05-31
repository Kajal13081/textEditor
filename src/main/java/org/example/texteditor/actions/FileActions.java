package org.example.texteditor.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import org.example.texteditor.utils.FileUtils;

public class FileActions {

    // Handles actions like open, save, and exit
    public static class OpenAction extends AbstractAction {
        private final JTextPane textPane;

        public OpenAction(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String content = FileUtils.readFile(selectedFile);
                textPane.setText(content); // Set the text in the JTextArea
            }
        }
    }

    public static class SaveAction extends AbstractAction {
        private final JTextPane textPane;

        public SaveAction(JTextPane textPane) {
            this.textPane = textPane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                FileUtils.writeFile(selectedFile, textPane.getText()); // Save the text to file
            }
        }
    }

    public static class ExitAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0); // Close the application
        }
    }
}
