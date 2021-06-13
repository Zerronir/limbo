package com.limbo.Pages;

import com.limbo.entities.Client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static Connection connection;
    public static JPanel Inici;
    public static CardLayout cl;
    public static JPanel panel;
    public static Client logedUser;

    static JMenuItem itemImportData;
    static JMenuItem itemExportDatabase;
    static JMenuItem itemExit;

    //public static Cistella cistella;

    public static void main(String[] args) throws IOException, SQLException {


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Limbo APP");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1920, 1080);

            panel = new JPanel();
            frame.setContentPane(panel);

            cl = new CardLayout();
            panel.setLayout(cl);

            Inici loginForm = new Inici();
            panel.add(loginForm, "Inici");

            JPanel blankPanel = new JPanel();
            panel.add(blankPanel, "BLANK");

            Registre registreForm = new Registre();
            panel.add(registreForm, "Registre");

            TaulaProductes taulaProductes = new TaulaProductes();
            panel.add(taulaProductes, "TAULA_PRODUCTES");

            PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
            panel.add(paginaPrincipal, "PaginaPrincipal");

            PaginaCliente paginaCliente = new PaginaCliente();
            panel.add(paginaCliente, "PaginaClient");

            JMenuBar jMenuBar = new JMenuBar();
            frame.setJMenuBar(jMenuBar);

            JMenu menuFile = new JMenu("File");
            itemImportData = new JMenuItem("Importar dades");
            itemExportDatabase = new JMenuItem("Export database");
            itemExit = new JMenuItem("Exit");
            menuFile.add(itemImportData);
            menuFile.add(itemExportDatabase);
            menuFile.add(itemExit);
            jMenuBar.add(menuFile);
            itemImportData.setEnabled(false);
            itemExportDatabase.setEnabled(false);

            JMenu menuEdit = new JMenu("Edit");
            JMenuItem itemCopy = new JMenuItem("Copy");
            JMenuItem itemCut = new JMenuItem("Cut");
            menuEdit.add(itemCopy);
            menuEdit.add(itemCut);
            jMenuBar.add(menuEdit);

            JMenu menuOperativa = new JMenu("Operativa");
            JMenuItem itemCercaProductes = new JMenuItem("Cerca de productes");
            JMenuItem itemVeureCistella = new JMenuItem("Veure cistella");
            JMenuItem itemDadesPersonals = new JMenuItem("Dades personals");
            menuOperativa.add(itemCercaProductes);
            menuOperativa.add(itemVeureCistella);
            menuOperativa.add(itemDadesPersonals);
            jMenuBar.add(menuOperativa);

            frame.setVisible(true);
        });
    }

    public static void showBlankPanel() {
        cl.show(panel, "BLANK");
    }

    public static void showTaulaProductesPanel() {
        cl.show(panel, "TAULA_PRODUCTES");
        /*
            itemImportData.setEnabled(true);
            itemExportDatabase.setEnabled(true);
        */
    }

    public static void showLoginPanel() {
        cl.show(panel, "Inici");
    }

    public static void showRegistrePanel() {
        cl.show(panel, "Registre");
    }

    public static void showFirstPage() {
        cl.show(panel, "PaginaPrincipal");
    }

    public static void showClientPage() {
        cl.show(panel, "PaginaClient");
    }
}
