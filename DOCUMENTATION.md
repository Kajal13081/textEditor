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

