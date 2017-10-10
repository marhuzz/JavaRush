package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import javafx.scene.web.HTMLEditor;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Marhuz on 20.03.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this,menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);

    }

    public void initEditor(){
        //6.1. Устанавливать значение «text/html» в качестве типа контента для компонента htmlTextPane.
        //Найди и используй подходящий метод.
        htmlTextPane.setContentType("text/html");
        //6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
        JScrollPane scrollPane = new JScrollPane(htmlTextPane);
        //6.3. Добавлять вкладку в панель tabbedPane с именем «HTML» и компонентом из предыдущего
        //пункта.
        tabbedPane.addTab("HTML",scrollPane);
        //6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.
        JScrollPane jScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",jScrollPane);
        tabbedPane.setPreferredSize(preferredSize());
        TabbedPaneChangeListener changeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(changeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(null,"Created by Marhuzz","О программе",JOptionPane.INFORMATION_MESSAGE);
    }

    public void exit() {
        controller.exit();
    }

    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void undo (){
        try {
            undoManager.undo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void redo (){
        try{
            undoManager.redo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;

    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "Новый" :
                controller.createNewDocument();
                break;
            case "Открыть" :
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                this.showAbout();
                break;
                default:
                    break;
        }

    }
}
