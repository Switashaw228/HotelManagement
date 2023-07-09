import java.awt.*;
// import java.awt.EventQueue;
// import java.awt.Font;
// import java.awt.Image;
import java.util.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame implements ActionListener {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1, t2, t3, t6;
	JComboBox comboBox;
	JRadioButton r1, r2;
	Choice c1;
	JLabel checkintime;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewCustomer() throws SQLException {

		setBounds(330, 140, 700, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(400, 40, 300, 400);
		add(l1);

		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 25));
		lblName.setBounds(118, 0, 300, 53);
		contentPane.add(lblName);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);

		comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
		comboBox.setBounds(211, 73, 150, 20);
		lblId.setBackground(Color.WHITE);
		contentPane.add(comboBox);

		JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);

		t1 = new JTextField();
		t1.setBounds(211, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);

		t2 = new JTextField();
		t2.setBounds(211, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);

		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(211, 191, 80, 14);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(300, 191, 100, 14);
		add(r2);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);

		JLabel lblReserveRoomNumber = new JLabel("Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		contentPane.add(lblReserveRoomNumber);

		c1 = new Choice();
		try {
			conn c = new conn();
			String query = "select * from room where available = 'Available'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				c1.add(rs.getString("room"));
			}
		} catch (Exception e) {
		}
		c1.setBounds(211, 274, 150, 30);
		contentPane.add(c1);
		c1.setBackground(Color.WHITE);

		JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		contentPane.add(lblCheckInStatus);

		Date date = new Date();
		checkintime = new JLabel("" + date);
		checkintime.setBounds(175, 316, 200, 14);
		checkintime.setFont(new Font("Raleway", Font.BOLD, 14));
		add(checkintime);

		JLabel lblDeposite = new JLabel("Deposit :");
		lblDeposite.setBounds(35, 359, 200, 14);
		contentPane.add(lblDeposite);

		t3 = new JTextField();
		t3.setBounds(211, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		// t5 = new JTextField();
		// t5.setBounds(211, 316, 150, 20);
		// contentPane.add(t5);
		// t5.setColumns(10);

		t6 = new JTextField();
		t6.setBounds(211, 359, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn c = new conn();
				String radio = null;

				if (r1.isSelected()) {
					radio = "Male";
				} else if (r2.isSelected()) {
					radio = "Female";
				}

				String s6 = c1.getSelectedItem();

				try {

					String s1 = (String) comboBox.getSelectedItem();
					String s2 = t1.getText();
					String s3 = t2.getText();
					String s4 = radio;
					String s5 = t3.getText();
					String s7 = checkintime.getText();
					String s8 = t6.getText();

					String q1 = "insert into customer values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5
							+ "','" + s6 + "','" + s7 + "','" + s8 + "')";
					String q2 = "update room set available = 'Occupied' where room = " + s6;
					c.s.executeUpdate(q1);
					c.s.executeUpdate(q2);

					JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
					new Reception().setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				} catch (NumberFormatException s) {
					JOptionPane.showMessageDialog(null, "Please enter a valid Number");
				} catch (Exception eee) {

				}
			}
		});
		btnNewButton.setBounds(100, 400, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
				new Reception().setVisible(true);
				;
			}
		});
		btnExit.setBounds(260, 400, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}
}