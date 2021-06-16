package com.limbo.Pages;

import com.limbo.entities.Cistella;
import com.limbo.entities.Client;
import com.limbo.entities.LineaCistella;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection connection;
    public static JPanel Inici;
    public static CardLayout cl;
    public static JPanel panel;
    public static Client logedUser;
    public static Cistella cistella = new Cistella();
    public static List<LineaCistella> llista = new ArrayList<>();
    public static int exitDeCistella = 0;

    static JMenuItem itemImportData;
    static JMenuItem itemExportDatabase;
    static JMenuItem itemExit;

    //public static Cistella cistella;

    public static void main(String[] args) throws IOException, SQLException {


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Limbo APP");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1366, 728);

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

            PaginaCistella cartPage = new PaginaCistella();
            panel.add(cartPage, "PaginaCistella");

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
        if(exitDeCistella == 1) Main.cistella.setLinies(null);

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        panel.add(paginaPrincipal, "paginaPrincipal");
        cl.show(panel, "paginaPrincipal");
    }

    public static void showCartPage() {
        PaginaCistella paginaCistella = new PaginaCistella();
        panel.add(paginaCistella, "cistella");
        cl.show(panel, "cistella");
    }

    public static void showPurchasePage() throws Exception {
        PaginaCompra paginaCompra = new PaginaCompra();
        panel.add(paginaCompra, "compra");

        // LOAD TEXT COMPONENTS
        paginaCompra.setComponents();
        paginaCompra.fillComboBox();
        paginaCompra.fillAddressCombo();

        cl.show(panel, "compra");
    }

    public static void showAddressPage() {
        PaginaAdreca paginaAdreca = new PaginaAdreca();
        panel.add(paginaAdreca, "adreces");
        paginaAdreca.loadCombo();
        cl.show(panel, "adreces");
    }

    public static void showClientPage() {
        PaginaCliente paginaCliente = new PaginaCliente();
        panel.add(paginaCliente, "PaginaClient");
        paginaCliente.loadValues();
        cl.show(panel, "PaginaClient");
    }

    public static void showCardPage() {
        PaginaTargeta paginaTargeta = new PaginaTargeta();
        panel.add(paginaTargeta, "PaginaTargeta");
        cl.show(panel, "PaginaTargeta");
    }

}
