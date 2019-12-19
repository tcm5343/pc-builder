/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import javax.swing.JFrame;
import backend.DB_Manager;

/**
 *
 * @author mbp5503
 */
public class Mockup {

    private Customer customerPanel;
    private Manager managerPanel;
    private MainPanel mainPanel;
    private BuildPC buildPC;
    private IndividualComp indComp;
    private AddComp addComponent;
    private AccessComp AccessComponent;
    private UpdateStock updateStock;
    private ConfirmationPage confirmPage;
    private Game gamePanel;
    private JFrame frame;
    private DB_Manager db;
    private DeleteComp delComponent;

    /**
     * @param args the command line arguments
     */
    public void initialize() {

        db = new DB_Manager();
        frame = new JFrame("GUI");
        mainPanel = new MainPanel(this);
        customerPanel = new Customer(this);
        managerPanel = new Manager(this, db);
        buildPC = new BuildPC(this);
        indComp = new IndividualComp(this);
        addComponent = new AddComp(this);
        AccessComponent = new AccessComp(this);
        updateStock = new UpdateStock(this);
        confirmPage = new ConfirmationPage(this);
        delComponent = new DeleteComp(this);
        gamePanel = new Game(this);

        db.readFile();

        frame.add(mainPanel);
        frame.setSize(850, 600);   //change size to adjust all panels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void changePanel(String Old, String New) {
        if (Old.equals("main")) {
            frame.remove(mainPanel);
        } else if (Old.equals("customer")) {
            frame.remove(customerPanel);
        } else if (Old.equals("manager")) {
            frame.remove(managerPanel);
        } else if (Old.equals("confirm")) {
            frame.remove(confirmPage);
        } else if (Old.equals("custompc")) {
            frame.remove(buildPC);
        } else if (Old.equals("individualpart")) {
            frame.remove(indComp);
        } else if (Old.equals("accessitem")) {
            frame.remove(AccessComponent);
        } else if (Old.equals("additem")) {
            frame.remove(addComponent);
        } else if (Old.equals("update")) {
            frame.remove(updateStock);
        } else if (Old.equals("game")) {
            frame.remove(gamePanel);
        } else if (Old.equals("confirm")) {
            frame.remove(confirmPage);
        } else if (Old.equals("deleteitem")) {
            frame.remove(delComponent);
        }
        if (New.equals("main")) {
            frame.add(mainPanel);
        } else if (New.equals("customer")) {
            frame.add(customerPanel);
        } else if (New.equals("manager")) {
            frame.add(managerPanel);
        } else if (New.equals("individualpart")) {
            frame.add(indComp);
        } else if (New.equals("custompc")) {
            frame.add(buildPC);
        } else if (New.equals("additem")) {
            frame.add(addComponent);
        } else if (New.equals("accessitem")) {
            frame.add(AccessComponent);
        } else if (New.equals("update")) {
            frame.add(updateStock);
        } else if (New.equals("confirm")) {
            frame.add(confirmPage);
        } else if (New.equals("game")) {
            frame.add(gamePanel);
        } else if (New.equals("deleteitem")) {
            frame.add(delComponent);
        }

        frame.validate();
        frame.pack();
    }

    protected BuildPC getBuildPC() {
        return buildPC;
    }

    protected ConfirmationPage getConfirmPage() {
        return confirmPage;
    }

    protected IndividualComp getIndComp() {
        return indComp;
    }

    public static void main(String args[]) {
        Mockup myApp = new Mockup();
        myApp.initialize();
    }

}
