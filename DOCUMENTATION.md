# Documentation for Repository: https://github.com/Kajal13081/textEditor

## File: src/main/java/org/example/texteditor/custom/customButton.java

**CustomButton Class**
=====================

The `CustomButton` class is a custom implementation of the `JButton` with additional features such as rounded corners, customizable background color, and optional dynamic border radius.

**Constructors**
---------------

### `CustomButton(String text)`

Creates a new instance with the specified text. The button's default background color is set to white, and the font is set to Arial with a size of 13.

### `CustomButton(String text, int radius)`

Creates a new instance with the specified text and radius for the rounded corners.

**Methods**
---------

### `setButtonSize(int width, int height)`

Sets the preferred size of the button.

### `setRadius(int radius)`

Sets the radius of the rounded corners` dynamically.

### `setBackground(Color color)`

Overrides the `setBackground` method to set the background color of the button`.

**Notes**
----

* The `paintComponent` method is currently commented out, which means the button's appearance is not customized. If uncommented, it would change the button's background color based on its state (pressed, hovered, or default).
* The `radius` variable is used to set the rounded corners of the button.

**Example Usage**
-----

```java
CustomButton button = new CustomButton("Click me!");
button.setButtonSize(100, 30);
button.setRadius(20);
```

This would create a button with the text "Click me!" with a size of 100x30, and a rounded corner radius of 20.

---

## File: src/main/java/org/example/texteditor/utils/AutoIndent.java

AutoIndent
================

### Description

Auto-indentation will adjust the indentation of the lines when the user presses "Enter" or pastes content. It will check the previous line's indentation level and replicate it for the new line.

### Methods

#### `enableAutoIndent(final JTextArea textArea)`

Enables auto-indentation for the given `JTextArea`.

##### Parameters

* `textArea`: The `JTextArea` for which auto-indentation should be enabled.

##### Description

This method adds a key listener to the `JTextArea` to listen for "Enter" key presses. When the "Enter" key is pressed, it gets the previous line's indentation and inserts the same indentation at the beginning of the new line.

#### `getPreviousLine `(JTextArea textArea, int caretPos)`

Gets the previous line from the `JTextArea`.

##### Parameters

* `textArea`: The `JTextArea` from which to get the previous line.
* `caretPos`: The current caret position.

##### Returns

The previous line from the `JTextArea`.

##### Throws

* `BadLocationException`: If the caret position is invalid.

#### `getIndentation(String line)`

Gets the indentation from the given line.

##### Parameters

* `line`: The line from which to get the indentation.

##### Returns

The indentation from the line.

### Usage

To enable auto-indentation for a `JTextArea`, simply call the `enableAutoIndent` method and pass the `JTextArea` instance as an argument.

```java
JTextArea textArea = new JTextArea();
AutoIndent.enableAutoIndent(textArea);
```

---

## File: src/main/java/org/example/texteditor/utils/FileUtils.java

**FileUtils.java**
=====================

### Package

`org.example.texteditor.utils`

### Import Statements

* `java.io.*`
* `java.nio.file.Files`
* `java.nio.file.Paths`

### Class: FileUtils

#### Description

Utility class to read and write files

#### Methods

##### `readFile`

**Signature:** `public static String readFile(File file)`

**Description:**

Reads the content of a given `File` and returns as a `String`.

**Parameters:**

* `file`: The `File` to read from.

**Implementation:**
```java
StringBuilder content = new StringBuilder();
try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()))) {
    String line;
    while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
    }
} catch (IOException e) {
    e.printStackTrace();
}
return content.toString();
```
##### `writeFile`

**Signature:** `public static void writeFile(File file, String content)`

**Description:**

Writes the given `content` to a given `File`.

**Parameters:**

* `file`: The `File` to write to.
* `content`: The `String` content to write.

**Implementation:**
```java
try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()))) {
    writer.write(content);
} catch (IOException e) {
    e.printStackTrace();
}
```
Note: This documentation is generated based on the provided source code and may not include additional information or descriptions that may be present in the actual code.

---

## File: src/main/java/org/example/texteditor/ui/MenuBar.java

MenuBar
================

### Class MenuBar

* **Package:** `org.example.texteditor.ui`
* **Extends:** `JMenuBar`

### Constructors**

#### `MenuBar(TextEditorPanel editorPanel, TextActions textActions)`

* **Parameters:**
	+ `editorPanel` (`TextEditorPanel`): The text editor panel
	+ `textActions` (`TextActions`): The text actions
* **Description:** Initializes the menu bar with file, edit, and format actions.

### Methods**

#### `MenuBar`

* **Description:** Initializes the menu bar with the following menus:
	- **File Menu:**
		+ Open Item
		+ Save Item
		+ Exit Item
	- **Edit Menu:**
		+ Cut Item
		+ Copy Item
		+ Paste Item
		+ Find Item**
		+ Replace Item
	- **Format Menu:**
		+ Clean Up Action
				- Bold Action
		+ Italic Action
		+ Font Color Action
		+ Font Family Actions (with available font family names)
			+ Font Size Actions (with font sizes 12, 14,  Note: The `findNextItem` is currently not added to the Edit Menu.

---

## File: src/main/java/org/example/texteditor/actions/EditActions.java

EditActions.java
================

### Package

`org.example.texteditor.actions`

### Import Statements

* `javax.swing.*`
* `java.awt.event.ActionEvent`

### Class: EditActions

The `EditActions` contains static inner classes that handle actions related to editing text, such as cutting, copying, pasting, and more.

### Inner Class: CutAction

#### Extends

`AbstractAction`

#### Fields

* `private final JTextPane textPane;` - the text pane associated with this action

#### Constructors

* `public CutAction(JTextPane textPane)` - creates a new `CutAction` instance with the given `textPane`

#### Methods

* `public void actionPerformed(ActionEvent e)` - handles the cut action by calling `textPane.cut()` method
	+ Cuts the selected text

### Inner Class: CopyAction

#### Extends

`AbstractAction`

#### Fields

* `private final JTextPane textPane;` - the text pane associated with this action

#### Constructors

* `public CopyAction(JTextPane textPane)` - creates a new `CopyAction` instance with the given `textPane`

#### Methods

* `public void actionPerformed(ActionEvent e)` - handles the copy action by calling `textPane.copy()` method
	+ Copies the selected text

### Inner Class: PasteAction

#### Extends

`AbstractAction`

#### Fields

* `private final JTextPane textPane;` - the text pane associated with this action

#### Constructors

* `public PasteAction(JTextPane textPane)` - creates a new `PasteAction` instance with the given `textPane`

#### Methods

* `public void actionPerformed(ActionEvent e)` - handles the paste action by calling `textPane.paste()` method
	+ Pastes the clipboard text

---

## File: src/main/java/org/example/texteditor/actions/FormatActions.java

FormatActions
================

The `FormatActions` Class

### Description

The `FormatActions` class is a utility class that provides various actions for text formatting in a text editor.

### Constructors

This class does not have any constructors`.

### Methods

#### `CleanUpAction`

*   `CleanUpAction(JTextPane textPane)**`: Creates a new `CleanUpAction` with the specified `textPane`.
*   `public void actionPerformed(ActionEvent e)`: Clears the document of the `textPane` by setting a new `DefaultStyledDocument`.

#### `BoldAction`

*   `BoldAction(JTextPane textPane)**`: Creates a new `BoldAction` with the specified `textPane`.
*   `public void actionPerformed(ActionEvent e)`: Toggles the bold style of the selected text in the `textPane`.

#### `ItalicAction`

*   `ItalicAction(JTextPane textPane)**`: Creates a new `ItalicAction` with the specified `textPane`.
*   `public void actionPerformed(ActionEvent e)`: Toggles the italic style of the selected text in the `textPane`.

#### `FontColorAction`

*   `FontColorAction(JTextPane textPane)**`: Creates a new `FontColorAction` with the specified `textPane`.
*   `public void actionPerformed(ActionEvent e)`: Sets the font color of the selected text in the `textPane` using a `JColorChooser`.

#### `FontFamilyAction`

*   `FontFamilyAction(JTextPane textPane, String fontFamily)**`: Creates a new `FontFamilyAction` with the specified `textPane` and `fontFamily`.
*   `public void actionPerformed(ActionEvent e)`: Sets the font family of the selected text in the `textPane`.

#### `FontSizeAction`

*   `FontSizeAction(JTextPane textPane, int fontSize)**`: Creates a new `FontSizeAction` with the specified `textPane` and `fontSize`.
*   `public void actionPerformed(ActionEvent e)`: Sets the font size of the selected text in the `textPane`.

#### `setStyledDocument`

*   `public static void setStyledDocument(JTextPane textPane)`: Sets the document of the `textPane` to a new `DefaultStyledDocument`.

### Nested Classes

#### `CleanUpAction`

*   A subclass of `AbstractAction` that clears the document of a JTextPane`.

#### `BoldAction`

*   A subclass of `AbstractAction` that toggles the bold style of the selected text in a `JTextPane`.

#### `ItalicAction`

*   A subclass of `AbstractAction` that toggles the italic style of the selected text in a `JTextPane`.

#### `FontColorAction`

*   A subclass of `AbstractAction` that sets the font color of the selected text in a `JTextPane`.

#### `FontFamilyAction`

*   A subclass of `AbstractAction` that sets the font family of the selected text in a `JTextPane`.

#### `FontSizeAction`

*   A subclass of `AbstractAction` that sets the font size of the selected text in a `JTextPane`.

---

## File: src/main/java/org/example/texteditor/utils/SyntaxHighlighter.java

Syntax Highlighter
================

### Package

`org.example.texteditor.utils` package.

### Import Statements

* `javax.swing.*`
* `javax.swing.event.DocumentEvent`
* `javax.swing.event.DocumentListener`
* `javax.swing.text.*`
* `java.awt.*`
* `java.util.regex.Matcher`
* `java.util.regex.Pattern`

### Class

`SyntaxHighlighter`

#### Static Fields

* `KEYWORDS`: an array of strings containing Java keywords.
* `COMMENT_PATTERN`: a regular expression pattern for matching comments.
* `STRING_PATTERN`: a regular expression pattern for matching strings.

#### Methods

##### `enableSyntaxHighlighting`

* Parameters: `final JTextPane textPane`
* Description: Enables syntax highlighting for the given `JTextPane`.
* Implementation: Adds a `DocumentListener` to the `JTextPane`'s document, which calls `highlightSyntax` on each document update.

##### `highlightSyntax`

* Parameters: `JTextPane textPane`
* Description: Highlights the syntax of the given `JTextPane`.
* Implementation:
	+ Clears previous highlights.
	+ Highlights keywords.
	+ Highlights comments.
	+ Highlights strings.

##### `highlightPattern`

* Parameters: `StyledDocument doc`, `String text`, `String pattern`, `SimpleAttributeSet attributes`
* Description: Highlights the given pattern in the text.
* Implementation: Uses a regular expression pattern to find matches and sets the character attributes accordingly.

##### `createKeywordStyle`

* Returns: `SimpleAttributeSet`
* Description: Creates a style for keywords.
* Style attributes:
	+ Foreground color: Blue

##### `createCommentStyle`

* Returns: `SimpleAttributeSet`
* Description: Creates a style for comments.
* Style attributes:
	+ Foreground color: Green

##### `createStringStyle`

* Returns: `SimpleAttributeSet`
* Description: Creates a style for strings.
* Style attributes:
	+ Foreground color: Orange

---

## File: src/main/java/org/example/texteditor/actions/FileActions.java

FileActions.java
================

This class handles actions like open, save, and exit.

Classes
--------

###OpenAction

A subclass of `AbstractAction` that handles the open action.

####Constructors

#####OpenAction(JTextPane textPane)`

* `textPane`: The `JTextPane` to interact with.

####Methods

#####`actionPerformed(ActionEvent e)`

Handles the open action. It shows an open file chooser, and if a file is chosen, it reads the file content and sets it to the `JTextPane`.

###SaveAction

A subclass of `AbstractAction` that handles the save action.

####Constructors

#####SaveAction(JTextPane textPane)`

* `textPane`: The `JTextPane` to interact with.

####Methods

#####`actionPerformed(ActionEvent e)`

Handles the save action. It shows a save file chooser, and if a file is chosen, it writes the content of the `JTextPane` to the file.

###ExitAction

A subclass of `AbstractAction` that handles the exit action.

####Methods

#####`actionPerformed(ActionEvent e)`

Exits the application.

---

## File: src/main/java/org/example/texteditor/actions/TextActions.java

TextActions
==========

The `TextActions`TextActions` is a class that provides various text editing actions for a `TextEditorPanel`. It handles find, find next, replace, undo, and redo operations.

### Constructors

#### `TextActions(TextEditorPanel editorPanel)`

Creates a new instance of `TextActions` and initializes it with a `TextEditorPanel` and an `UndoManager`

The class has an `UndoManager` instance that is used to manage undo and redo operations.

### Fields

#### `private List<Integer> searchResults`

A list to store the indices of all occurrences of the search term.

#### `private int currentSearchIndex`

Tracks the current position of the search.

### Actions

#### `public Action findAction`

An action that finds a term in the text. When triggered, it clears previous search results, resets the search index, and highlights the search term.

#### `public Action findNextAction`

An action that finds the next occurrence of the search term. When triggered, it unhighlights the previous search result, moves to the next result (circular behavior), and highlights the new result.

#### `public Action replaceAction`

An action that replaces the selected text with a new term. When triggered, it gets the selected text, prompts for a replacement term, and replaces the selected text with the new term.

#### `public Action undoAction`

An action that undoes the last edit operation.

#### `public Action redoAction`

An action that redoes the last undone edit operation.

### Methods

#### `private void removePreviousHighlight()`

Removes all highlights from the text area.

#### `private void replaceSelectedText(String selectedText, String replaceTerm)`

Replaces the selected text with the replacement term.

#### `private void highlightSearchTerm(String searchTerm)`

Highlights all occurrences of the search term in the text area and stores their positions.

#### `private void highlightSearchTermAtPosition(int start, int end)`

Highlights a specific search result based on position.

#### `public void enableUndoRedo()`

Enables undo and redo functionality by adding an undoable edit listener to the text area's document.

### Notes

*   The class uses `JOptionPane` for user input and feedback.
*   The class uses `UndoManager` for undo and redo operations.

---

## File: src/main/java/org/example/texteditor/ui/TextEditorPanel.java

Here is the generated documentation for the `TextEditorPanel.java` file:
```
TextEditorPanel
================

**Package:** `org.example.texteditor.ui`

**Class:** `TextEditorPanel`

**Extends:** `JPanel`

**Summary:**
A custom `JPanel` implementation that provides a basic text editing functionality with a scrollable area.

**Constructors:**
### `TextEditorPanel()`

Initializes the `TextEditorPanel` component with a scrollable text area.

**Fields:**
### `textPane`

*   **Type:** `JTextPane`
*   **Description:** The text pane component that allows editing text.
### `doc`

*   **Type:** `StyledDocument`
*   **Description:** The styled document associated with the text pane.**

**Methods:**
### `getTextArea()`

*   **Type:** `JTextPane`
*   **Description:** Returns the text area component.

### `setText(String text)`

*   **Parameter:** `text` - The text to be set in the text area.
*   **Description:** Sets the text in the text area.

### `getText()`

*   **Returns:** `String` - The text in the text area.
*   **Description:** Returns the text in the text area.

**Implementation Notes:**

*   The `JTextPane` component is wrapped inside a `JScrollPane` to provide scroll functionality.
*   The `JTextPane` is set to be editable, and its preferred size is set to 600x400 pixels.
*   The `JTextPane` is made focusable and requested to gain focus by default.
```
Let me know if you'd like me to generate documentation for the rest of the files as well!

---

## File: src/main/java/org/example/Main.java

**Main.java**
================

### Package

* `org.example`

### Imports

* `org.example.texteditor.ui.MainFrame;`
* `javax.swing.*;`
* `java.awt.*;`

### Class: Main

#### Description

* 

#### Fields

* None`

#### Constructors

* None

#### Methods

##### main

###### Description

* 

###### Parameters

* `String[] args`

###### Returns

* `void`

###### Throws

* None

###### Code

```java
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
```

### Notes

* TIP To **Run** code, press **or** click the  icon in the gutter.

---

## File: src/main/java/org/example/texteditor/ui/MainFrame.java

MainFrame
==========

The `MainFrame` class, located in the `org.example.texteditor.ui` package, serves as the primary user interface component for the Text Editor application. It extends the `JFrame` class from the `javax.swing` package.

### Constructors

#### MainFrame()

The default constructor for the `MainFrame` class. It sets up the main frame with the title "Text Editor", a size of 800x600 pixels, and an exit operation on close. It initializes the `editorPanel`, `textActions`, and `menuBar` components, adding the `editorPanel` to the center of the frame and the `menuBar` to the top of the frame.

### Fields

#### editorPanel

A private final `TextEditorPanel` object, representing the main text editing area of the application.

#### textActions

A `TextActions` object, used for handling text-related actions in the application.

#### menuBar

A private final `JMenuBar` object, representing the menu bar of the application.

### Code Explanation

The constructor `MainFrame()` sets up the main frame with the title "Text Editor", a size of 800x600 pixels, and an exit operation on close. It initializes the `editorPanel`, `textActions`, and `menuBar` components, adding the `editorPanel` to the center of the frame and the `menuBar` to the top of the frame.

The `AutoIndent` feature is currently disabled, but it can be enabled by uncommenting the line `AutoIndent.enableAutoIndent(editorPanel.getTextArea());`.

The `SyntaxHighlighter` feature is enabled by default, which provides syntax highlighting for the text area.

The constructor also includes a commented-out section for setting up a toolbar, which can be enabled by uncommenting the lines `FormatToolbar toolbar = new FormatToolbar(editorPanel);` and `add(toolbar, BorderLayout.NORTH);`.

---



File: src/main/java/org/example/texteditor/custom/customButton.java
package org.example.texteditor.custom;

import javax.swing.*;
import java.awt.*;

public class customButton extends JButton {

    private int radius = 40;  // Default radius for rounded corners

    // Constructor with text
    public customButton(String text) {
        super(text);
        setContentAreaFilled(false); // Disable default background filling
        setFocusPainted(false); // Disable focus painted (highlighted border when clicked)
        setBackground(new Color(255, 255, 255)); // Set default button background
        //setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Set border
        setFont(new Font("Arial", Font.TRUETYPE_FONT, 13)); // Set font for text
    }

    // Constructor to set custom radius
    public customButton(String text, int radius) {
        this(text);
        this.radius = radius;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        // Check if the button is pressed or hovered
//        if (getModel().isPressed()) {
//            g.setColor(new Color(200, 200, 200)); // Set color for pressed state
//        } else if (getModel().isRollover()) {
//            g.setColor(new Color(220, 220, 220)); // Set color for hover state
//        } else {
//            g.setColor(new Color(255, 255, 255)); // Default background color
//        }
//
//        // Fill the rounded rectangle with custom color
//        g.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
//
//        // Call the superclass method to draw the text and icon
//        super.paintComponent(g);
//    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
    }

    // Allow setting the button size
    public void setButtonSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    // Optional: Set the border radius dynamically
    public void setRadius(int radius) {
        this.radius = radius;
    }
}


File: src/main/java/org/example/texteditor/utils/AutoIndent.java
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



File: src/main/java/org/example/texteditor/utils/FileUtils.java
package org.example.texteditor.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    // Utility class to read and write files
    public static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.toURI()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeFile(File file, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


File: src/main/java/org/example/texteditor/ui/MenuBar.java
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


File: src/main/java/org/example/texteditor/actions/EditActions.java
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


File: src/main/java/org/example/texteditor/actions/FormatActions.java
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


File: src/main/java/org/example/texteditor/utils/SyntaxHighlighter.java
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


File: src/main/java/org/example/texteditor/actions/FileActions.java
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


File: src/main/java/org/example/texteditor/actions/TextActions.java
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


File: src/main/java/org/example/texteditor/ui/TextEditorPanel.java
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


File: src/main/java/org/example/Main.java
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

File: src/main/java/org/example/texteditor/ui/MainFrame.java
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


