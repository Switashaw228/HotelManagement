import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dashboard extends JFrame implements ActionListener {
    Dashboard() {
        setBounds(0, 0, 1600, 750);

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1600, 750);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(300, 50, 1000, 50);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1600, 30);
        image.add(mb);

        JMenu Hotel = new JMenu("HOTEL MANAGEMENT");
        mb.add(Hotel);
        Hotel.setForeground(Color.red);

        JMenuItem reception = new JMenuItem("RECEPTION");
        Hotel.add(reception);
        reception.addActionListener(this);

        JMenu admin = new JMenu("ADMIN");
        mb.add(admin);
        admin.setForeground(Color.blue);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);
        addEmployee.addActionListener(this);

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        admin.add(addRooms);
        addRooms.addActionListener(this);

        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        admin.add(addDriver);
        addDriver.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD DRIVER")) {
            new AddDrivers();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRoom();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
