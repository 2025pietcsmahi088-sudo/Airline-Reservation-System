package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LoginFrame extends JFrame {

    // =====================================================
    // COLORS
    // =====================================================

    private final Color NAVY_BLUE = new Color(15, 45, 75);
    private final Color BLUE = new Color(30, 100, 180);
    private final Color SKY_BLUE = new Color(70, 160, 220);
    private final Color LIGHT_BLUE = new Color(235, 245, 255);
    private final Color WHITE = Color.WHITE;
    private final Color DARK_TEXT = new Color(30, 40, 50);
    private final Color DANGER_RED = new Color(200, 60, 60);
    private final Color SUCCESS_GREEN = new Color(40, 150, 90);

    // =====================================================
    // LOGIN VARIABLES
    // =====================================================

    private JTextField usernameField;
    private JPasswordField passwordField;

    // =====================================================
    // TABLE VARIABLES
    // =====================================================

    private JTable flightTable;
    private DefaultTableModel flightModel;

    private JTable reservationTable;
    private DefaultTableModel reservationModel;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public LoginFrame() {

        setTitle("Airline Reservation System");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        showLoginPage();
    }

    // =====================================================
    // COMMON HEADER
    // =====================================================

    private JPanel createHeader() {

        JPanel header = new JPanel();

        header.setLayout(
                new BoxLayout(header, BoxLayout.Y_AXIS)
        );

        header.setBackground(NAVY_BLUE);

        // Logo
        ImageIcon logoIcon =
                new ImageIcon("src/ui/poornimalogo.jpeg");

        Image image = logoIcon.getImage();

        Image scaledImage =
                image.getScaledInstance(
                        300,
                        70,
                        Image.SCALE_SMOOTH
                );

        JLabel logo =
                new JLabel(
                        new ImageIcon(scaledImage)
                );

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // Project title
        JLabel title =
                new JLabel(
                        "AIRLINE RESERVATION SYSTEM"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        title.setForeground(WHITE);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(
                Box.createVerticalStrut(10)
        );

        header.add(logo);

        header.add(
                Box.createVerticalStrut(5)
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(10)
        );

        return header;
    }

    // =====================================================
    // COMMON FOOTER
    // =====================================================

    private JPanel createFooter() {

        JPanel footerPanel =
                new JPanel(
                        new BorderLayout()
                );

        footerPanel.setBackground(NAVY_BLUE);

        JLabel footer =
                new JLabel(
                        "Developed by MAHI RAJAWAT | 2026",
                        SwingConstants.CENTER
                );

        footer.setForeground(WHITE);

        footer.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        footer.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        footerPanel.add(
                footer,
                BorderLayout.CENTER
        );

        return footerPanel;
    }

    // =====================================================
    // COMMON NAVIGATION PANEL
    // =====================================================

    private JPanel createNavigationPanel() {

        JPanel navigation =
                new JPanel();

        navigation.setLayout(
                new BoxLayout(
                        navigation,
                        BoxLayout.Y_AXIS
                )
        );

        navigation.setBackground(NAVY_BLUE);

        navigation.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        10,
                        15,
                        10
                )
        );

        JLabel menuTitle =
                new JLabel("MENU");

        menuTitle.setForeground(WHITE);

        menuTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        menuTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        navigation.add(menuTitle);

        navigation.add(
                Box.createVerticalStrut(15)
        );

        JButton homeButton =
                createNavigationButton("Home");

        JButton flightButton =
                createNavigationButton(
                        "Flight Management"
                );

        JButton reservationButton =
                createNavigationButton(
                        "Reservation Management"
                );

        JButton passengerButton =
                createNavigationButton(
                        "Passenger List"
                );

        JButton infoButton =
                createNavigationButton(
                        "View Information"
                );

        JButton logoutButton =
                createNavigationButton(
                        "Logout"
                );

        navigation.add(homeButton);

        navigation.add(
                Box.createVerticalStrut(8)
        );

        navigation.add(flightButton);

        navigation.add(
                Box.createVerticalStrut(8)
        );

        navigation.add(reservationButton);

        navigation.add(
                Box.createVerticalStrut(8)
        );

        navigation.add(passengerButton);

        navigation.add(
                Box.createVerticalStrut(8)
        );

        navigation.add(infoButton);

        navigation.add(
                Box.createVerticalGlue()
        );

        navigation.add(logoutButton);

        homeButton.addActionListener(
                e -> showDashboard()
        );

        flightButton.addActionListener(
                e -> showFlightManagement()
        );

        reservationButton.addActionListener(
                e -> showReservationManagement()
        );

        passengerButton.addActionListener(
                e -> showPassengerList()
        );

        infoButton.addActionListener(
                e -> showInformation()
        );

        logoutButton.addActionListener(
                e -> logout()
        );

        return navigation;
    }

    // =====================================================
    // NAVIGATION BUTTON STYLE
    // =====================================================

    private JButton createNavigationButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setMaximumSize(
                new Dimension(
                        210,
                        42
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setBackground(BLUE);

        button.setForeground(WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setFocusPainted(false);

        return button;
    }

    // =====================================================
    // NORMAL BUTTON STYLE
    // =====================================================

    private void styleBlueButton(
            JButton button
    ) {

        button.setBackground(BLUE);

        button.setForeground(WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setFocusPainted(false);
    }

    // =====================================================
    // DANGER BUTTON STYLE
    // =====================================================

    private void styleDangerButton(
            JButton button
    ) {

        button.setBackground(DANGER_RED);

        button.setForeground(WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setFocusPainted(false);
    }

    // =====================================================
    // TABLE STYLE
    // =====================================================

    private void styleTable(
            JTable table
    ) {

        table.setRowHeight(32);

        table.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        table.setForeground(DARK_TEXT);

        table.setGridColor(
                new Color(
                        210,
                        220,
                        230
                )
        );

        table.setSelectionBackground(
                SKY_BLUE
        );

        table.setSelectionForeground(
                WHITE
        );

        table.getTableHeader()
                .setBackground(
                        NAVY_BLUE
                );

        table.getTableHeader()
                .setForeground(
                        WHITE
                );

        table.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                14
                        )
                );

        table.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                100,
                                35
                        )
                );
    }

    // =====================================================
    // LOGIN PAGE
    // =====================================================

    private void showLoginPage() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        JPanel backgroundPanel =
                new JPanel(
                        new GridBagLayout()
                );

        backgroundPanel.setBackground(
                LIGHT_BLUE
        );

        // Login Box

        JPanel loginBox =
                new JPanel(
                        new GridBagLayout()
                );

        loginBox.setBackground(WHITE);

        loginBox.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                SKY_BLUE,
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                40,
                                25,
                                40
                        )
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10,
                        10,
                        10,
                        10
                );

        // Login title

        JLabel loginTitle =
                new JLabel(
                        "LOGIN"
                );

        loginTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        loginTitle.setForeground(
                NAVY_BLUE
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        loginBox.add(
                loginTitle,
                gbc
        );

        // Username

        JLabel usernameLabel =
                new JLabel(
                        "Username:"
                );

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        loginBox.add(
                usernameLabel,
                gbc
        );

        usernameField =
                new JTextField(15);

        usernameField.setPreferredSize(
                new Dimension(
                        180,
                        32
                )
        );

        gbc.gridx = 1;

        loginBox.add(
                usernameField,
                gbc
        );

        // Password

        JLabel passwordLabel =
                new JLabel(
                        "Password:"
                );

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        loginBox.add(
                passwordLabel,
                gbc
        );

        passwordField =
                new JPasswordField(15);

        passwordField.setPreferredSize(
                new Dimension(
                        180,
                        32
                )
        );

        gbc.gridx = 1;

        loginBox.add(
                passwordField,
                gbc
        );

        // Login Button

        JButton loginButton =
                new JButton(
                        "LOGIN"
                );

        loginButton.setPreferredSize(
                new Dimension(
                        180,
                        40
                )
        );

        styleBlueButton(
                loginButton
        );

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        loginBox.add(
                loginButton,
                gbc
        );

        // Forgot Password

        JButton forgotButton =
                new JButton(
                        "Forgot Password?"
                );

        forgotButton.setForeground(
                BLUE
        );

        forgotButton.setBackground(
                WHITE
        );

        forgotButton.setBorderPainted(
                false
        );

        gbc.gridy = 4;

        loginBox.add(
                forgotButton,
                gbc
        );

        backgroundPanel.add(
                loginBox
        );

        add(
                backgroundPanel,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        loginButton.addActionListener(
                e -> login()
        );

        forgotButton.addActionListener(
                e ->
                        JOptionPane.showMessageDialog(
                                this,
                                "Please contact the administrator.",
                                "Forgot Password",
                                JOptionPane.INFORMATION_MESSAGE
                        )
        );

        // Enter key login

        passwordField.addActionListener(
                e -> login()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // LOGIN FUNCTION
    // =====================================================

    private void login() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Enter username and password.",
                    "Login Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Demo credentials; user login is not stored in MySQL.
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // DASHBOARD
    // =====================================================

    private void showDashboard() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        add(
                createNavigationPanel(),
                BorderLayout.WEST
        );

        JPanel dashboard =
                new JPanel(
                        new GridBagLayout()
                );

        dashboard.setBackground(
                LIGHT_BLUE
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        15,
                        15,
                        15,
                        15
                );

        // Welcome

        JLabel welcome =
                new JLabel(
                        "Welcome to Airline Reservation System"
                );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        welcome.setForeground(
                NAVY_BLUE
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        dashboard.add(
                welcome,
                gbc
        );

        JLabel subtitle =
                new JLabel(
                        "Manage flights and passenger reservations easily"
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        subtitle.setForeground(
                DARK_TEXT
        );

        gbc.gridy = 1;

        dashboard.add(
                subtitle,
                gbc
        );

        // Flight button

        JButton flightButton =
                new JButton(
                        "✈ Flight Management"
                );

        flightButton.setPreferredSize(
                new Dimension(
                        250,
                        60
                )
        );

        styleBlueButton(
                flightButton
        );

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;

        dashboard.add(
                flightButton,
                gbc
        );

        // Reservation button

        JButton reservationButton =
                new JButton(
                        "☑ Reservation Management"
                );

        reservationButton.setPreferredSize(
                new Dimension(
                        250,
                        60
                )
        );

        styleBlueButton(
                reservationButton
        );

        gbc.gridx = 1;

        dashboard.add(
                reservationButton,
                gbc
        );

        // Passenger button

        JButton passengerButton =
                new JButton(
                        "♟ Passenger List"
                );

        passengerButton.setPreferredSize(
                new Dimension(
                        250,
                        60
                )
        );

        passengerButton.setBackground(
                SKY_BLUE
        );

        passengerButton.setForeground(
                WHITE
        );

        passengerButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        passengerButton.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 3;

        dashboard.add(
                passengerButton,
                gbc
        );

        // Information button

        JButton infoButton =
                new JButton(
                        "ⓘ View Information"
                );

        infoButton.setPreferredSize(
                new Dimension(
                        250,
                        60
                )
        );

        infoButton.setBackground(
                SKY_BLUE
        );

        infoButton.setForeground(
                WHITE
        );

        infoButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        infoButton.setFocusPainted(false);

        gbc.gridx = 1;

        dashboard.add(
                infoButton,
                gbc
        );

        // Logout

        JButton logoutButton =
                new JButton(
                        "Logout"
                );

        logoutButton.setPreferredSize(
                new Dimension(
                        180,
                        45
                )
        );

        styleDangerButton(
                logoutButton
        );

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        dashboard.add(
                logoutButton,
                gbc
        );

        add(
                dashboard,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        // Actions

        flightButton.addActionListener(
                e -> showFlightManagement()
        );

        reservationButton.addActionListener(
                e -> showReservationManagement()
        );

        passengerButton.addActionListener(
                e -> showPassengerList()
        );

        infoButton.addActionListener(
                e -> showInformation()
        );

        logoutButton.addActionListener(
                e -> logout()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // FLIGHT MANAGEMENT
    // =====================================================

    private void showFlightManagement() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        add(
                createNavigationPanel(),
                BorderLayout.WEST
        );

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                LIGHT_BLUE
        );

        // Title

        JLabel title =
                new JLabel(
                        "Flight Management"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        title.setForeground(
                NAVY_BLUE
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        10
                )
        );

        main.add(
                title,
                BorderLayout.NORTH
        );

        // Table

        String[] columns = {

                "Flight ID",
                "Flight Number",
                "Source",
                "Destination",
                "Date",
                "Time"

        };

        flightModel =
                new DefaultTableModel(
                        columns,
                        0
                );

        flightTable =
                new JTable(
                        flightModel
                );

        styleTable(
                flightTable
        );

        // Example flights

        flightModel.addRow(
                new Object[]{
                        101,
                        "AI101",
                        "Delhi",
                        "Mumbai",
                        "10-09-2026",
                        "10:00 AM"
                }
        );

        flightModel.addRow(
                new Object[]{
                        102,
                        "AI202",
                        "Jaipur",
                        "Delhi",
                        "11-09-2026",
                        "02:00 PM"
                }
        );

        flightModel.addRow(
                new Object[]{
                        103,
                        "AI303",
                        "Mumbai",
                        "Bangalore",
                        "12-09-2026",
                        "06:00 PM"
                }
        );

        flightModel.addRow(
                new Object[]{
                        104,
                        "AI404",
                        "Jaipur",
                        "Mumbai",
                        "13-09-2026",
                        "09:00 AM"
                }
        );

        flightModel.addRow(
                new Object[]{
                        105,
                        "AI505",
                        "Delhi",
                        "Jaipur",
                        "14-09-2026",
                        "04:00 PM"
                }
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        flightTable
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );

        main.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // Buttons

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout()
                );

        buttonPanel.setBackground(
                LIGHT_BLUE
        );

        JButton addButton =
                new JButton(
                        "Add Flight"
                );

        JButton updateButton =
                new JButton(
                        "Update Flight"
                );

        JButton deleteButton =
                new JButton(
                        "Delete Flight"
                );

        JButton backButton =
                new JButton(
                        "Back"
                );

        styleBlueButton(addButton);
        styleBlueButton(updateButton);
        styleDangerButton(deleteButton);
        styleBlueButton(backButton);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        main.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(
                main,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        // Actions

        addButton.addActionListener(
                e -> addFlight()
        );

        updateButton.addActionListener(
                e -> updateFlight()
        );

        deleteButton.addActionListener(
                e -> deleteFlight()
        );

        backButton.addActionListener(
                e -> showDashboard()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // ADD FLIGHT
    // =====================================================

    private void addFlight() {

        JTextField flightNumber =
                new JTextField();

        JTextField source =
                new JTextField();

        JTextField destination =
                new JTextField();

        JTextField date =
                new JTextField();

        JTextField time =
                new JTextField();

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                10,
                                10
                        )
                );

        panel.add(
                new JLabel("Flight Number:")
        );

        panel.add(flightNumber);

        panel.add(
                new JLabel("Source:")
        );

        panel.add(source);

        panel.add(
                new JLabel("Destination:")
        );

        panel.add(destination);

        panel.add(
                new JLabel("Date:")
        );

        panel.add(date);

        panel.add(
                new JLabel("Time:")
        );

        panel.add(time);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Add Flight",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (
                result !=
                        JOptionPane.OK_OPTION
        ) {

            return;
        }

        if (
                flightNumber.getText().trim().isEmpty()
                        ||
                        source.getText().trim().isEmpty()
                        ||
                        destination.getText().trim().isEmpty()
                        ||
                        date.getText().trim().isEmpty()
                        ||
                        time.getText().trim().isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields.",
                    "Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int newId =
                101 + flightModel.getRowCount();

        flightModel.addRow(
                new Object[]{

                        newId,

                        flightNumber
                                .getText()
                                .trim(),

                        source
                                .getText()
                                .trim(),

                        destination
                                .getText()
                                .trim(),

                        date
                                .getText()
                                .trim(),

                        time
                                .getText()
                                .trim()

                }
        );

        JOptionPane.showMessageDialog(
                this,
                "Flight added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    // UPDATE FLIGHT
    // =====================================================

    private void updateFlight() {

        int row =
                flightTable.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a flight first.",
                    "Update Flight",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        JTextField flightNumber =
                new JTextField(
                        flightModel
                                .getValueAt(
                                        row,
                                        1
                                )
                                .toString()
                );

        JTextField source =
                new JTextField(
                        flightModel
                                .getValueAt(
                                        row,
                                        2
                                )
                                .toString()
                );

        JTextField destination =
                new JTextField(
                        flightModel
                                .getValueAt(
                                        row,
                                        3
                                )
                                .toString()
                );

        JTextField date =
                new JTextField(
                        flightModel
                                .getValueAt(
                                        row,
                                        4
                                )
                                .toString()
                );

        JTextField time =
                new JTextField(
                        flightModel
                                .getValueAt(
                                        row,
                                        5
                                )
                                .toString()
                );

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                10,
                                10
                        )
                );

        panel.add(
                new JLabel("Flight Number:")
        );

        panel.add(flightNumber);

        panel.add(
                new JLabel("Source:")
        );

        panel.add(source);

        panel.add(
                new JLabel("Destination:")
        );

        panel.add(destination);

        panel.add(
                new JLabel("Date:")
        );

        panel.add(date);

        panel.add(
                new JLabel("Time:")
        );

        panel.add(time);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Update Flight",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (
                result !=
                        JOptionPane.OK_OPTION
        ) {

            return;
        }

        flightModel.setValueAt(
                flightNumber.getText().trim(),
                row,
                1
        );

        flightModel.setValueAt(
                source.getText().trim(),
                row,
                2
        );

        flightModel.setValueAt(
                destination.getText().trim(),
                row,
                3
        );

        flightModel.setValueAt(
                date.getText().trim(),
                row,
                4
        );

        flightModel.setValueAt(
                time.getText().trim(),
                row,
                5
        );

        JOptionPane.showMessageDialog(
                this,
                "Flight updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    // DELETE FLIGHT
    // =====================================================

    private void deleteFlight() {

        int row =
                flightTable.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a flight.",
                    "Delete Flight",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this flight?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (
                result ==
                        JOptionPane.YES_OPTION
        ) {

            flightModel.removeRow(row);

            JOptionPane.showMessageDialog(
                    this,
                    "Flight deleted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================================
    // RESERVATION MANAGEMENT
    // =====================================================

    private void showReservationManagement() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        add(
                createNavigationPanel(),
                BorderLayout.WEST
        );

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                LIGHT_BLUE
        );

        JLabel title =
                new JLabel(
                        "Reservation Management"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        title.setForeground(
                NAVY_BLUE
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        10
                )
        );

        main.add(
                title,
                BorderLayout.NORTH
        );

        String[] columns = {

                "Reservation ID",
                "Passenger Name",
                "Flight ID",
                "Seat Number",
                "Reservation Date"

        };

        reservationModel =
                new DefaultTableModel(
                        columns,
                        0
                );

        reservationTable =
                new JTable(
                        reservationModel
                );

        styleTable(
                reservationTable
        );

        // Example passengers

        reservationModel.addRow(
                new Object[]{
                        1,
                        "Rahul Sharma",
                        101,
                        "A1",
                        "09-09-2026"
                }
        );

        reservationModel.addRow(
                new Object[]{
                        2,
                        "Priya Singh",
                        102,
                        "B2",
                        "09-09-2026"
                }
        );

        reservationModel.addRow(
                new Object[]{
                        3,
                        "Aman Verma",
                        103,
                        "C3",
                        "10-09-2026"
                }
        );

        reservationModel.addRow(
                new Object[]{
                        4,
                        "Neha Gupta",
                        104,
                        "D4",
                        "10-09-2026"
                }
        );

        reservationModel.addRow(
                new Object[]{
                        5,
                        "Riya Mehta",
                        105,
                        "E5",
                        "11-09-2026"
                }
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        reservationTable
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );

        main.add(
                scrollPane,
                BorderLayout.CENTER
        );

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout()
                );

        buttonPanel.setBackground(
                LIGHT_BLUE
        );

        JButton addButton =
                new JButton(
                        "Add Passenger"
                );

        JButton updateButton =
                new JButton(
                        "Update"
                );

        JButton deleteButton =
                new JButton(
                        "Delete"
                );

        JButton passengerButton =
                new JButton(
                        "Passenger List"
                );

        JButton backButton =
                new JButton(
                        "Back"
                );

        styleBlueButton(addButton);
        styleBlueButton(updateButton);
        styleDangerButton(deleteButton);
        styleBlueButton(passengerButton);
        styleBlueButton(backButton);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(passengerButton);
        buttonPanel.add(backButton);

        main.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(
                main,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        addButton.addActionListener(
                e -> addPassenger()
        );

        updateButton.addActionListener(
                e -> updatePassenger()
        );

        deleteButton.addActionListener(
                e -> deletePassenger()
        );

        passengerButton.addActionListener(
                e -> showPassengerList()
        );

        backButton.addActionListener(
                e -> showDashboard()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // ADD PASSENGER
    // =====================================================

    private void addPassenger() {

        JTextField name =
                new JTextField();

        JTextField flightId =
                new JTextField();

        JTextField seat =
                new JTextField();

        JTextField date =
                new JTextField();

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                4,
                                2,
                                10,
                                10
                        )
                );

        panel.add(
                new JLabel("Passenger Name:")
        );

        panel.add(name);

        panel.add(
                new JLabel("Flight ID:")
        );

        panel.add(flightId);

        panel.add(
                new JLabel("Seat Number:")
        );

        panel.add(seat);

        panel.add(
                new JLabel("Reservation Date:")
        );

        panel.add(date);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Add Passenger",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (
                result !=
                        JOptionPane.OK_OPTION
        ) {

            return;
        }

        if (
                name.getText().trim().isEmpty()
                        ||
                        flightId.getText().trim().isEmpty()
                        ||
                        seat.getText().trim().isEmpty()
                        ||
                        date.getText().trim().isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields.",
                    "Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            int id =
                    Integer.parseInt(
                            flightId
                                    .getText()
                                    .trim()
                    );

            int reservationId =
                    reservationModel.getRowCount() + 1;

            reservationModel.addRow(
                    new Object[]{

                            reservationId,

                            name
                                    .getText()
                                    .trim(),

                            id,

                            seat
                                    .getText()
                                    .trim(),

                            date
                                    .getText()
                                    .trim()

                    }
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Passenger added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (
                NumberFormatException e
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Flight ID must be a number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // UPDATE PASSENGER
    // =====================================================

    private void updatePassenger() {

        int row =
                reservationTable
                        .getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a passenger first.",
                    "Update",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        JTextField name =
                new JTextField(
                        reservationModel
                                .getValueAt(
                                        row,
                                        1
                                )
                                .toString()
                );

        JTextField flightId =
                new JTextField(
                        reservationModel
                                .getValueAt(
                                        row,
                                        2
                                )
                                .toString()
                );

        JTextField seat =
                new JTextField(
                        reservationModel
                                .getValueAt(
                                        row,
                                        3
                                )
                                .toString()
                );

        JTextField date =
                new JTextField(
                        reservationModel
                                .getValueAt(
                                        row,
                                        4
                                )
                                .toString()
                );

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                4,
                                2,
                                10,
                                10
                        )
                );

        panel.add(
                new JLabel("Passenger Name:")
        );

        panel.add(name);

        panel.add(
                new JLabel("Flight ID:")
        );

        panel.add(flightId);

        panel.add(
                new JLabel("Seat Number:")
        );

        panel.add(seat);

        panel.add(
                new JLabel("Reservation Date:")
        );

        panel.add(date);

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Update Passenger",
                        JOptionPane.OK_CANCEL_OPTION
                );

        if (
                result !=
                        JOptionPane.OK_OPTION
        ) {

            return;
        }

        try {

            int id =
                    Integer.parseInt(
                            flightId
                                    .getText()
                                    .trim()
                    );

            reservationModel.setValueAt(
                    name.getText().trim(),
                    row,
                    1
            );

            reservationModel.setValueAt(
                    id,
                    row,
                    2
            );

            reservationModel.setValueAt(
                    seat.getText().trim(),
                    row,
                    3
            );

            reservationModel.setValueAt(
                    date.getText().trim(),
                    row,
                    4
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Passenger updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (
                NumberFormatException e
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Flight ID must be a number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // DELETE PASSENGER
    // =====================================================

    private void deletePassenger() {

        int row =
                reservationTable
                        .getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a passenger.",
                    "Delete",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this passenger?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (
                result ==
                        JOptionPane.YES_OPTION
        ) {

            reservationModel.removeRow(
                    row
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Passenger deleted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =====================================================
    // PASSENGER LIST
    // =====================================================

    private void showPassengerList() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        add(
                createNavigationPanel(),
                BorderLayout.WEST
        );

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(
                LIGHT_BLUE
        );

        JLabel title =
                new JLabel(
                        "Passenger List"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25
                )
        );

        title.setForeground(
                NAVY_BLUE
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        10
                )
        );

        main.add(
                title,
                BorderLayout.NORTH
        );

        String[] columns = {

                "Passenger ID",
                "Passenger Name",
                "Flight ID",
                "Seat Number",
                "Reservation Date"

        };

        DefaultTableModel passengerModel =
                new DefaultTableModel(
                        columns,
                        0
                );

        JTable passengerTable =
                new JTable(
                        passengerModel
                );

        styleTable(
                passengerTable
        );

        passengerModel.addRow(
                new Object[]{
                        1,
                        "Rahul Sharma",
                        101,
                        "A1",
                        "09-09-2026"
                }
        );

        passengerModel.addRow(
                new Object[]{
                        2,
                        "Priya Singh",
                        102,
                        "B2",
                        "09-09-2026"
                }
        );

        passengerModel.addRow(
                new Object[]{
                        3,
                        "Aman Verma",
                        103,
                        "C3",
                        "10-09-2026"
                }
        );

        passengerModel.addRow(
                new Object[]{
                        4,
                        "Neha Gupta",
                        104,
                        "D4",
                        "10-09-2026"
                }
        );

        passengerModel.addRow(
                new Object[]{
                        5,
                        "Riya Mehta",
                        105,
                        "E5",
                        "11-09-2026"
                }
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        passengerTable
                );

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );

        main.add(
                scrollPane,
                BorderLayout.CENTER
        );

        JPanel bottom =
                new JPanel();

        bottom.setBackground(
                LIGHT_BLUE
        );

        JButton backButton =
                new JButton(
                        "Back to Home"
                );

        styleBlueButton(
                backButton
        );

        bottom.add(
                backButton
        );

        main.add(
                bottom,
                BorderLayout.SOUTH
        );

        add(
                main,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        backButton.addActionListener(
                e -> showDashboard()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // VIEW INFORMATION
    // =====================================================

    private void showInformation() {

        getContentPane().removeAll();

        setLayout(
                new BorderLayout()
        );

        add(
                createHeader(),
                BorderLayout.NORTH
        );

        add(
                createNavigationPanel(),
                BorderLayout.WEST
        );

        JPanel main =
                new JPanel(
                        new GridBagLayout()
                );

        main.setBackground(
                LIGHT_BLUE
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        10,
                        10,
                        10,
                        10
                );

        // Title

        JLabel title =
                new JLabel(
                        "View Information"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        title.setForeground(
                NAVY_BLUE
        );

        gbc.gridx = 0;
        gbc.gridy = 0;

        main.add(
                title,
                gbc
        );

        // Information Box

        JTextArea information =
                new JTextArea();

        information.setText(
                "AIRLINE RESERVATION SYSTEM\n\n"
                        +
                        "Project Type: Java Desktop Application\n\n"
                        +
                        "Purpose:\n"
                        +
                        "This system is designed to manage "
                        +
                        "airline flights and passenger reservations.\n\n"
                        +
                        "Technologies Used:\n"
                        +
                        "• Java\n"
                        +
                        "• Java Swing\n"
                        +
                        "• IntelliJ IDEA\n"
                        +
                        "• MySQL\n"
                        +
                        "• JDBC\n\n"
                        +
                        "Main Modules:\n"
                        +
                        "• Login\n"
                        +
                        "• Home / Dashboard\n"
                        +
                        "• Flight Management\n"
                        +
                        "• Reservation Management\n"
                        +
                        "• Passenger List\n"
                        +
                        "• View Information\n\n"
                        +
                        "CRUD Operations:\n"
                        +
                        "Create, Read, Update and Delete\n\n"
                        +
                        "Developed by:\n"
                        +
                        "MAHI RAJAWAT"
        );

        information.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        information.setForeground(
                DARK_TEXT
        );

        information.setBackground(
                WHITE
        );

        information.setEditable(false);

        information.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                SKY_BLUE,
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                20,
                                30,
                                20,
                                30
                        )
                )
        );

        gbc.gridy = 1;

        main.add(
                information,
                gbc
        );

        JButton backButton =
                new JButton(
                        "Back to Home"
                );

        styleBlueButton(
                backButton
        );

        gbc.gridy = 2;

        main.add(
                backButton,
                gbc
        );

        add(
                main,
                BorderLayout.CENTER
        );

        add(
                createFooter(),
                BorderLayout.SOUTH
        );

        backButton.addActionListener(
                e -> showDashboard()
        );

        revalidate();
        repaint();
    }

    // =====================================================
    // LOGOUT
    // =====================================================

    private void logout() {

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                );

        if (
                result ==
                        JOptionPane.YES_OPTION
        ) {

            showLoginPage();
        }
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    LoginFrame frame =
                            new LoginFrame();

                    frame.setVisible(true);
                }
        );
    }
}