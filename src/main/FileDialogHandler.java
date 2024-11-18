package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileDialogHandler {

    private JFrame parent;

    private File selectedDir = null;

    private JDialog dialog;

    private final File[] saveDir = {null};

    private JTextArea dirText;



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


        dialog = new JDialog(parent, "Save As New", true);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(parent);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Enter file name (without extension):");
        JTextField fileNameField = new JTextField(20);
        fileNameField.setSize(150,30);
        fileNameField.setLocation(150,70);

       dirText = new JTextArea("No Directory Selected");
       dirText.setLineWrap(true);
       dirText.setPreferredSize(new Dimension(200,70));

       dirText.setWrapStyleWord(true);
       dirText.setEditable(false);




        JPanel buttonPanel = new JPanel();
        JButton chooseDirButton = new JButton("Choose Directory");
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");


        chooseDirButton.addActionListener(e -> chooseDirAction());

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Add components to the dialog
        panel.add(label, BorderLayout.NORTH);
        panel.add(fileNameField);
        panel.add(chooseDirButton, BorderLayout.WEST);
        panel.add(dirText);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);

        // save the selected Dir

    }

    private void chooseDirAction() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(dialog);

        if(result == JFileChooser.APPROVE_OPTION) {
            System.out.println("TEsttt");
            saveDir[0] = fileChooser.getSelectedFile();
            dirText.setText(saveDir[0].getAbsolutePath());
        }



    }

}
