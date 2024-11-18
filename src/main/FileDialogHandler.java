package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileDialogHandler {

    private JFrame parent;

    private File selectedDir = null;

    // create funcitonality for choosing a dir could have one method that all methods use

    public FileDialogHandler(JFrame parent) {
        this.parent = parent;
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file: ");

        // set the directory it opens
        fileChooser.setCurrentDirectory(new File("C:\\Users\\zygmo\\OneDrive - University of Missouri\\Desktop"));

        // set the file type filters
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));

        int result = fileChooser.showOpenDialog(parent);

        if(result == JFileChooser.APPROVE_OPTION) {

            // if the user selects a file, get the file

            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    public void saveFile() {

        System.out.println("TEsttt");
        JDialog dialog = new JDialog(parent, "Save As New", true);
        dialog.setSize(500, 300);
        dialog.setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel label = new JLabel("Enter file name (without extension):");
        JTextField fileNameField = new JTextField(20);

        JLabel dirLabel = new JLabel("No directory selected");

        JPanel buttonPanel = new JPanel();
        JButton chooseDirButton = new JButton("Choose Directory");
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Add components to the dialog
        panel.add(label, BorderLayout.NORTH);
        panel.add(fileNameField, BorderLayout.CENTER);
        panel.add(chooseDirButton, BorderLayout.WEST);
        panel.add(dirLabel, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

}
