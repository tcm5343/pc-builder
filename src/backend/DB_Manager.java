/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author tcm5343
 */
public class DB_Manager {

    private static final int MAX_RECORDS = 25;

    // Variables and Instances of Classes
    private CPU currentCPU;       //store an instance of current CPU which is a CPU
    private CPU CPUArray[] = new CPU[MAX_RECORDS];        //store all student records
    private int nextCPU = 0;         // location of next empty position in the array
    private int numCPU = 0;         // number of input student records
    private String xmlname;      // temporary storage for first name from xml
    private int xmlsku;       //temporary storage for last name from xml
    private String xmlsocket;   //temporary storage for degree status from xml
    private int xmlprice;
    private int xmlstock;
    private int xmlpower;
    private String xmltype;
    // temporary storage for major from xml
    // constructor
    private String myConnectString;

    private static int sku = countAllRecords();

    // constructor
    public DB_Manager() {
        // dynamically fetches path for database
        String url = System.getProperty("user.dir");
        myConnectString = "jdbc:ucanaccess://" + url.replace("\\", "/")
                + "/database/inventory.accdb";
    }

    public static int getSku() {
        sku++;
        return sku;
    }

    // returns all records in the database
    public ArrayList<Item> queryAllRecords() {

        ArrayList<Item> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // I do not know how to dynamically generate these
            String[] tables = new String[]{"CPU", "MOBO", "RAM", "GPU",
                "PSU", "Case"};

            // loops through the tables array changing the query
            for (int i = 0; i < tables.length; i++) {
                // connect to database
                Connection con = DriverManager.getConnection(myConnectString);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from " + tables[i]);

                while (rs.next()) {
                    // init of variables
                    int rsSku, rsStock, rsPower, rsSize, rsRamType, rsModular;
                    String rsName, rsSocket, rsType;
                    Double rsPrice;

                    switch (rs.getString("type")) {

                        case "CPU":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsSocket = rs.getString("socket");
                            rsPower = rs.getInt("power");

                            // CPU(String name, String type, double price, int sku, int stock, int socket, int power)
                            CPU cpu = new CPU(rsName, rsType, rsPrice, rsSku, rsStock, rsSocket, rsPower);
                            Items.add(cpu);
                            break;

                        case "MOBO":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsSize = rs.getInt("size");
                            rsRamType = rs.getInt("ramType");
                            rsSocket = rs.getString("socket");

                            // MOBO(String name, String type, double price, int sku, int stock, int size, int ramType, int socket)
                            MOBO mobo = new MOBO(rsName, rsType, rsPrice, rsSku, rsStock, rsSize, rsRamType, rsSocket);
                            Items.add(mobo);
                            break;

                        case "RAM":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsRamType = rs.getInt("ramType");

                            // RAM(String name, String type, double price, int sku, int stock, int ramType)
                            RAM ram = new RAM(rsName, rsType, rsPrice, rsSku, rsStock, rsRamType);
                            Items.add(ram);
                            break;

                        case "GPU":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsPower = rs.getInt("power");

                            // GPU(String name, String type, double price, int sku, int stock, int power)
                            GPU gpu = new GPU(rsName, rsType, rsPrice, rsSku, rsStock, rsPower);
                            Items.add(gpu);
                            break;

                        case "PSU":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsModular = rs.getInt("modular");
                            rsPower = rs.getInt("power");

                            // PSU(String name, String type, double price, int sku, int stock, int modular, int power)
                            PSU psu = new PSU(rsName, rsType, rsPrice, rsSku, rsStock, rsModular, rsPower);
                            Items.add(psu);
                            break;

                        case "Case":
                            rsSku = rs.getInt("sku");
                            rsName = rs.getString("name");
                            rsType = rs.getString("type");
                            rsPrice = rs.getDouble("price");
                            rsStock = rs.getInt("stock");
                            rsSize = rs.getInt("size");

                            // Case(String name, String type, double price, int sku, int stock, int size)
                            Case computerCase = new Case(rsName, rsType, rsPrice, rsSku, rsStock, rsSize);
                            Items.add(computerCase);
                            break;
                    } // end of switch
                } // end of while
                stmt.close();
                con.close();
            } // end of for loop
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryAllRecords()

    // returns CPU which is in stock
    public ArrayList<CPU> queryCPU() {

        ArrayList<CPU> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from CPU";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                String rsSocket = rs.getString("socket");
                int rsPower = rs.getInt("power");

                // CPU(String name, String type, double price, int sku, int stock, int socket, int power)
                CPU cpu = new CPU(rsName, rsType, rsPrice, rsSku, rsStock, rsSocket, rsPower);
                Items.add(cpu);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryCPU()

    // returns MOBO which is in stock
    public ArrayList<MOBO> queryMOBO() {

        ArrayList<MOBO> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from MOBO";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsSize = rs.getInt("size");
                int rsRamType = rs.getInt("ramType");
                String rsSocket = rs.getString("socket");

                // MOBO(String name, String type, double price, int sku, int stock, int size, 
                // int ramType, int socket)
                MOBO mobo = new MOBO(rsName, rsType, rsPrice, rsSku, rsStock, rsSize, rsRamType, rsSocket);
                Items.add(mobo);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryMOBO()

    // returns RAM which is in stock
    public ArrayList<RAM> queryRAM() {

        ArrayList<RAM> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from RAM";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsRamType = rs.getInt("ramType");

                // RAM(String name, String type, double price, int sku, int stock, int ramType)
                RAM ram = new RAM(rsName, rsType, rsPrice, rsSku, rsStock, rsRamType);
                Items.add(ram);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryRAM()

    // returns GPU which is in stock
    public ArrayList<GPU> queryGPU() {

        ArrayList<GPU> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from GPU";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsPower = rs.getInt("power");

                // GPU(String name, String type, double price, int sku, int stock, int power)
                GPU gpu = new GPU(rsName, rsType, rsPrice, rsSku, rsStock, rsPower);
                Items.add(gpu);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryGPU()

    // returns PSU which is in stock
    public ArrayList<PSU> queryPSU() {

        ArrayList<PSU> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from PSU";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsModular = rs.getInt("modular");
                int rsPower = rs.getInt("power");

                // PSU(String name, String type, double price, int sku, int stock, int modular, int power)
                PSU psu = new PSU(rsName, rsType, rsPrice, rsSku, rsStock, rsModular, rsPower);
                Items.add(psu);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryPSU()

    // returns Case which is in stock
    public ArrayList<Case> queryCase() {

        ArrayList<Case> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from Case";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsSize = rs.getInt("size");

                // Case(String name, String type, double price, int sku, int stock, int size)
                Case computerCase = new Case(rsName, rsType, rsPrice, rsSku, rsStock, rsSize);
                Items.add(computerCase);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryCase()

    // queries the MOBO table to see what MOBO 
    // matches the socket param and is in stock
    public ArrayList<MOBO> queryMOBOSocket(String socket) {

        ArrayList<MOBO> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from MOBO where socket=? and stock > 0";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, socket);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsSize = rs.getInt("size");
                int rsRamType = rs.getInt("ramType");
                String rsSocket = rs.getString("socket");

                // MOBO(String name, String type, double price, int sku, int stock, int size, 
                // int ramType, int socket)
                MOBO mobo = new MOBO(rsName, rsType, rsPrice, rsSku, rsStock, rsSize, rsRamType, rsSocket);
                Items.add(mobo);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryMOBOSocket()

    // queries the Case table to see what Case matches 
    // the size param and is in stock
    public ArrayList<Case> queryCaseSize(int size) {

        ArrayList<Case> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from Case where size=? and stock > 0";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, size);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsSize = rs.getInt("size");

                // Case(String name, String type, double price, int sku, int stock, int size)
                Case computerCase = new Case(rsName, rsType, rsPrice, rsSku, rsStock, rsSize);
                Items.add(computerCase);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryCaseSize()

    // queries the PSU table to see what PSU matches 
    // the power param and is in stock
    public ArrayList<PSU> queryPSUPower(int power) {

        ArrayList<PSU> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from PSU where power >= ? and stock > 0";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, power);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsModular = rs.getInt("modular");
                int rsPower = rs.getInt("power");

                // PSU(String name, String type, double price, int sku, int stock, int modular, int power)
                PSU psu = new PSU(rsName, rsType, rsPrice, rsSku, rsStock, rsModular, rsPower);
                Items.add(psu);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryPSUPower()

    // queries the RAM table to see what RAM matches
    // the ramType param and is in stock
    public ArrayList<RAM> queryRamType(int ramType) {

        ArrayList<RAM> Items = new ArrayList<>();

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "select * from RAM where ramType=? and stock > 0";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ramType);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int rsSku = rs.getInt("sku");
                String rsName = rs.getString("name");
                String rsType = rs.getString("type");
                Double rsPrice = rs.getDouble("price");
                int rsStock = rs.getInt("stock");
                int rsRamType = rs.getInt("ramType");

                // RAM(String name, String type, double price, int sku, int stock, int ramType)
                RAM ram = new RAM(rsName, rsType, rsPrice, rsSku, rsStock, rsRamType);
                Items.add(ram);
            }
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return Items;
        }
    } // end of queryRamType()

    // update CPU stock
    public void updateCPUStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update CPU set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "CPU stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateCPUStock()

    // update MOBO stock
    public void updateMOBOStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update MOBO set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "MOBO stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateMOBOStock()

    // update RAM stock
    public void updateRAMStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update RAM set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "RAM stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateRAMStock()

    // update GPU stock
    public void updateGPUStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update GPU set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "GPU stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateGPUStock()

    // update PSU stock
    public void updatePSUStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update PSU set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "PSU stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updatePSUStock()

    // update Case stock
    public void updateCaseStock(String name, int newStock) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = "update Case set stock=? where name=?";

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, newStock);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "Case stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateCaseStock()

    public void insertItem(Item item) {
        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);
            PreparedStatement preparedStatement = null;
            String sql = null;

            if (item instanceof CPU) {
                // prepared statement creation and assignment
                sql = "insert into CPU values(?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setString(3, ((CPU) item).getSocket());
                preparedStatement.setInt(4, item.getStock());
                preparedStatement.setDouble(5, item.getPrice());
                preparedStatement.setInt(6, ((CPU) item).getPower());
                preparedStatement.setString(7, item.getType());
            } else if (item instanceof MOBO) {
                // prepared statement creation and assignment
                sql = "insert into MOBO values(?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setString(3, ((MOBO) item).getSocket());
                preparedStatement.setInt(4, item.getStock());
                preparedStatement.setDouble(5, item.getPrice());
                preparedStatement.setInt(6, ((MOBO) item).getRamType());
                preparedStatement.setString(7, item.getType());
                preparedStatement.setInt(8, ((MOBO) item).getSize());
            } else if (item instanceof RAM) {
                // prepared statement creation and assignment
                sql = "insert into RAM values(?, ?, ?, ?, ?, ?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setInt(3, ((RAM) item).getRamType());
                preparedStatement.setInt(4, item.getStock());
                preparedStatement.setDouble(5, item.getPrice());
                preparedStatement.setString(6, item.getType());
            } else if (item instanceof GPU) {
                // prepared statement creation and assignment
                sql = "insert into GPU values(?, ?, ?, ?, ?, ?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setInt(3, item.getStock());
                preparedStatement.setDouble(4, item.getPrice());
                preparedStatement.setInt(5, ((GPU) item).getPower());
                preparedStatement.setString(6, item.getType());
            } else if (item instanceof PSU) {
                // prepared statement creation and assignment
                sql = "insert into PSU values(?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setInt(3, item.getStock());
                preparedStatement.setDouble(4, item.getPrice());
                preparedStatement.setInt(5, ((PSU) item).getPower());
                preparedStatement.setString(6, item.getType());
                preparedStatement.setInt(7, ((PSU) item).getModular());
            } else if (item instanceof Case) {
                // prepared statement creation and assignment
                sql = "insert into Case values(?, ?, ?, ?, ?, 'Case')";
                preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, item.getSku());
                preparedStatement.setString(2, item.getName());
                preparedStatement.setInt(3, ((Case) item).getSize());
                preparedStatement.setDouble(4, item.getPrice());
                preparedStatement.setInt(5, item.getStock());
            }

            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            // JOptionPane.showMessageDialog(null, "New Item Added", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } //end of insertItem()

    public void deleteItem(Item item) {
        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = null;
            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);
            PreparedStatement preparedStatement = null;

            if (item instanceof CPU) {
                sql = "Delete * from CPU where name = ?";

                // prepared statement creation and assignment
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
                //JOptionPane.showMessageDialog(null, "CPU added", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else if (item instanceof MOBO) {
                sql = "Delete * from MOBO where name = ? and type = 'MOBO'";

                // prepared statement creation and assignment
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());

            } else if (item instanceof RAM) {
                sql = "Delete * from RAM where name = ? and type = 'RAM'";

                // prepared statement creation and assignment
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
            } else if (item instanceof GPU) {
                sql = "Delete * from GPU where name = ? and type = 'GPU'";

                // prepared statement creation and assignment
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
            } else if (item instanceof PSU) {
                sql = "Delete * from PSU where name = ? and type = 'PSU'";

                // prepared statement creation and assignment
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
            } else if (item instanceof Case) {
                sql = "Delete * from Case where name = ? and type = 'Case'";

                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, item.getName());
            }

            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "Item deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } //end of insertItem()

    public void readFile() {

        nextCPU = 0; // reset location of next empty position in the array
        numCPU = 0; // reset number of input student records
        String filename = "CPU.xml";

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            NodeList list = document.getElementsByTagName("cpu");

            createCPUTable();
            //createRAMTable();

            //This for loop gathers all the student attributes, puts them in a StudentRecord object
            //then stores that student in the StudentArray
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                xmlsku = getSkuXML(element);
                xmlname = getNameXML(element);

                xmlsocket = getSocketXML(element);
                xmlstock = getStockXML(element);   //temporary storage for degree status from xml 
                xmlprice = getPriceXML(element);

                xmlpower = getPowerXML(element);
                xmltype = getTypeXML(element);

                currentCPU = new CPU(xmlname, xmltype, xmlprice, xmlsku, xmlstock, xmlsocket, xmlpower);
                insertItem(currentCPU);

                //   System.out.println(currentCPU.toString());
                //insertCPU(currentCPU);  //reading fine but insert cpu doesnt work 
                // store student record in array
                CPUArray[nextCPU] = currentCPU;

                // increment number of student records and move to next position in studentArray
                numCPU++;
                nextCPU++;

            }//end for loop loading the studentArray[] with full student records

            System.out.println("Completed reading from XML");

        }//end try block
        catch (ParserConfigurationException parserException) {
            parserException.printStackTrace();
        }//end catch block
        catch (SAXException saxException) {
            saxException.printStackTrace();
        }//end catch block
        catch (IOException ioException) {
            ioException.printStackTrace();
        }//end catch block

    }//end readFile()

    //RETURNS THE FIRST NAME OF THE STUDENT
    public String getNameXML(Element parent) {
        NodeList child = parent.getElementsByTagName("name");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();
    }//end getFirstName

    //RETURNS THE LAST NAME OF THE STUDENT    
    public int getSkuXML(Element parent) {
        NodeList child = parent.getElementsByTagName("sku");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());
    }

    public String getSocketXML(Element parent) {
        NodeList child = parent.getElementsByTagName("socket");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();
    }

    public int getPriceXML(Element parent) {
        NodeList child = parent.getElementsByTagName("price");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());
    }

    public int getStockXML(Element parent) {
        NodeList child = parent.getElementsByTagName("stock");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());
    }

    public int getPowerXML(Element parent) {
        NodeList child = parent.getElementsByTagName("power");
        Node childTextNode = child.item(0).getFirstChild();
        return Integer.parseInt(childTextNode.getNodeValue());
    }

    public String getTypeXML(Element parent) {
        NodeList child = parent.getElementsByTagName("type");
        Node childTextNode = child.item(0).getFirstChild();
        return childTextNode.getNodeValue();
    }

//    public void storeCPUfromXML() {
//        for (int i = 0; i < numCPU; i++) {
//            //CPU(String name, String type, double price, int sku, int stock, String socket, int power){
//            CPU cpu = new CPU(
//                    CPUArray[i].getName(),
//                    CPUArray[i].getType(),
//                    CPUArray[i].getPrice(),
//                    CPUArray[i].getSku(),
//                    CPUArray[i].getStock(),
//                    CPUArray[i].getSocket(),
//                    CPUArray[i].getPower()
//            );
//            insertItem(cpu);
//        }
//    } // end of storeCPUfromXML()

    public void createRAMTable() {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);
            Statement stmt = con.createStatement();

            //this code may need to be commented out because an exception will be thrown
            //if this table doesn't exist in the database
            stmt.execute("DROP TABLE RAM");

            stmt.execute("CREATE TABLE RAM"
                    + "(sku number, name varchar(255),"
                    + "  ramType number, stock number, price number, type varchar(255))");

            System.out.println("Created RAM table");

            stmt.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }//end catch block
        // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }//end catch block
    }//end createTable()

    public void createCPUTable() {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);
            Statement stmt = con.createStatement();

            //this code may need to be commented out because an exception will be thrown
            //if this table doesn't exist in the database
            stmt.execute("DROP TABLE CPU");

            stmt.execute("CREATE TABLE CPU"
                    + "(sku number, name varchar(255),"
                    + " socket varchar(255), stock number, price number, power number, "
                    + "type varchar(255))");

            System.out.println("Created CPU table");

            stmt.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }//end catch block
        // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }//end catch block
    }//end createTable()

    // update Item stock
    // stock must be changed before being passed
    public void updateItem(Item item) {

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = null;

            // connect to database
            Connection con = DriverManager.getConnection(myConnectString);

            if (item instanceof CPU) {
                sql = "update CPU set stock=? where name=?";
            } else if (item instanceof MOBO) {
                sql = "update MOBO set stock=? where name=?";
            } else if (item instanceof RAM) {
                sql = "update RAM set stock=? where name=?";
            } else if (item instanceof GPU) {
                sql = "update GPU set stock=? where name=?";
            } else if (item instanceof PSU) {
                sql = "update PSU set stock=? where name=?";
            } else if (item instanceof Case) {
                sql = "update Case set stock=? where name=?";
            }

            // prepared statement creation and assignment
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // assign values to variables
            preparedStatement.setInt(1, item.getStock());
            preparedStatement.setString(2, item.getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "Item stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateItemStock()

    // decrements the carts stock by one
    public void updateCartStock(ArrayList<Item> itemList) {
        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String sql = null;

            for (Item item : itemList) {

                int stock = item.getStock() - 1;
                String name = item.getName();

                if (item instanceof CPU) {
                    sql = "update CPU set stock=? where name=?";
                } else if (item instanceof MOBO) {
                    sql = "update MOBO set stock=? where name=?";
                } else if (item instanceof RAM) {
                    sql = "update RAM set stock=? where name=?";
                } else if (item instanceof GPU) {
                    sql = "update GPU set stock=? where name=?";
                } else if (item instanceof PSU) {
                    sql = "update PSU set stock=? where name=?";
                } else if (item instanceof Case) {
                    sql = "update Case set stock=? where name=?";
                }

                // connect to database
                Connection con = DriverManager.getConnection(myConnectString);

                // prepared statement creation and assignment
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setInt(1, stock);
                preparedStatement.setString(2, name);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                con.close();

            }
        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            JOptionPane.showMessageDialog(null, "Cart stock decremented", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } // end of updateCartStock()

    public static int countAllRecords() {
        DB_Manager db = new DB_Manager();
        String[] tables = new String[]{"CPU", "MOBO", "RAM", "GPU", "PSU", "Case"};
        int count = 0;

        try {
            // load database driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // loops through the tables array changing the query
            for (int i = 0; i < tables.length; i++) {
                // connect to database
                Connection con = DriverManager.getConnection(db.myConnectString);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM " + tables[i]);

                while (rs.next()) {
                    count += rs.getInt("total");
                }
                stmt.close();
                con.close();
            } // end of for loop

        } // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // detect problems loading database driver
        catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null,
                    classNotFound.getMessage(), "Driver Not Found",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            return count;
        }
    } // end of countAllRecords()

}// end of class
