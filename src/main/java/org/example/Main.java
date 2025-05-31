package org.example;

import org.example.texteditor.ui.MainFrame;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Run the GUI in the Event-Dispatching Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create and show the main frame of the text editor
                MainFrame mainFrame = new MainFrame();
                // Show the frame
                mainFrame.setVisible(true);
            }
        });
    }
}