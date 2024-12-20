package main;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileDialogHandler {

    private JFrame parent;

    private File selectedDir = null;

    private JDialog dialog;

    private static final File[] saveDir = {null};

    private JTextArea dirText;
    private JTextField fileNameField;

    private MouseHandler mouse;





    // create funcitonality for choosing a dir could have one method that all methods use

    public FileDialogHandler(JFrame parent, MouseHandler mouse) {
        this.parent = parent;
        this.mouse = mouse;
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

    public void saveAsFile() {


        dialog = new JDialog(parent, "Save As New", true);
        dialog.setSize(500, 200);
        dialog.setLocationRelativeTo(parent);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Enter file name (without extension):");
        fileNameField = new JTextField(20);
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

        // save button functionality
        saveButton.addActionListener(e -> {
            try {
                saveAsFileAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


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

        // if there was already a saved dir
        if(saveDir[0] != null) {
            System.out.println("something goin on");
            dirText.setText(saveDir[0].getAbsolutePath());
            return;
        }

        if(saveDir[0] == null) {
            System.out.println("this was wrong");
        }

        if(result == JFileChooser.APPROVE_OPTION) {
            System.out.println("TEsttt");
            saveDir[0] = fileChooser.getSelectedFile();
            dirText.setText(saveDir[0].getAbsolutePath());
        }



    }

    // save the file as a new file
    private void saveAsFileAction() throws IOException {

        // get the file name from the field
        String fileName = fileNameField.getText();

        // check if there is a valid directory
        if (saveDir[0] == null) {


            System.out.println("Error: Cannot write to the selected directory.");
            return;
        }

        // if the file name field is empty
        if(fileName.isEmpty()) {
            System.out.println("There was no file name");
            return;
        }


        dialog.setVisible(false);


        System.out.println(fileName);




        File newFile = new File(saveDir[0].getAbsolutePath() + File.separator + fileName + ".txt");

        if(newFile.createNewFile()) {
            System.out.println("File was created");

            FileWriter outputFile = new FileWriter(newFile);

            writeToFile(outputFile);
        }
        else {
            // if the file already exsists
            System.out.println("File was not created");
        }



    }

    // save the current file
    public void saveFile() {

    }


    // write the tile array to a file
    private void writeToFile(FileWriter file) throws IOException {

        for(int i = 0;i<mouse.gridCols;i++) {

            for(int j = 0;j<mouse.gridRows;j++) {

                file.write(String.format(mouse.tileArray[i][j] + " "));

            }
            file.write("\n");
        }

        file.close();

    }



}
