package com.javarush.task.task32.task3209;


import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Marhuz on 20.03.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
        this.document = new HTMLDocument();
    }

    public static void main(String[] args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader,document,0);
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
        return document.toString();
    }

    public void resetDocument(){
        if (this.document != null && view!=null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document=((HTMLDocument) new
                HTMLEditorKit().createDefaultDocument());
        if(document.getUndoableEditListeners()==null)
        {
            this.document.addUndoableEditListener(view.getUndoListener());
        } view.update();

    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showOpenDialog(view) == fileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader reader = new FileReader(currentFile)){
                new HTMLEditorKit().read(reader,document,0);
                view.resetUndo();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument(){

        if (currentFile == null){
            saveDocumentAs();
        }
        else{
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)){
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());

        if (fileChooser.showSaveDialog(view) == fileChooser.APPROVE_OPTION){
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)){
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }

        }

    }


}
