
package eHealth_GUI;//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import Users.Patient;


@SuppressWarnings("serial")
public class Healthcare_Entry extends JFrame {

	private JPanel contentPane;

	String username;

	/**
	 * <h1>The User Start Page</h1>
	 * <p>This is the code for the Entry Window that is displayed, when the user logs in as "patient".</p>
	 * @author Sidra Abbasi
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Healthcare_Entry frame = new Healthcare_Entry();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @param patient takes the object Patient that is created at the time of logging in
	 */
	public Healthcare_Entry(Patient patient) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*Introduction*/

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Welcome!");
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesTitle.setBounds(27, 11, 286, 45);
		contentPane.add(lblNewJgoodiesTitle);


		JLabel lbluser = new JLabel("You are logged in as: " + patient.getUsername());
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbluser.setBounds(99, 29, 143, 58);
		contentPane.add(lbluser);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Need to find a doctor?");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewJgoodiesLabel_1.setBounds(88, 91, 164, 45);
		contentPane.add(lblNewJgoodiesLabel_1);


		/*Buttons: Logout, My Profile, Services, Contact, Search*/

		/**
		 * Upon pressing the Logout button, the object "patient" is getting deleted and the Login Screen gets displayed.
		 * @author: GUI: Sidra Abbasi, Logic: Harris Nuhanovic
		 */
		JButton btnSearchDoc = new JButton("Start searching");
		btnSearchDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//�ffne Eingangsfenster
				Healthcare_Search_Doc second = new Healthcare_Search_Doc(patient);
				second.setVisible(true);


			}
		});
		btnSearchDoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearchDoc.setBounds(52, 147, 237, 45);
		contentPane.add(btnSearchDoc);

		JLabel lblNewLabel = new JLabel("View or edit your information:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(80, 234, 180, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Healthcare_User_Profile userprofile = new Healthcare_User_Profile(patient);
				userprofile.setVisible(true);

				dispose();

			}
		});
		btnMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMyProfile.setBounds(15, 278, 150, 39);
		contentPane.add(btnMyProfile);

		JButton btnMyAppointments = new JButton("My Appointments");
		btnMyAppointments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Manage_Appointment_Patient appointments = new Manage_Appointment_Patient(patient);
					appointments.setVisible(true);
					dispose();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}




			}
		});
		btnMyAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMyAppointments.setBounds(175, 278, 150, 39);
		contentPane.add(btnMyAppointments);


		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				patient.logOutPat(patient);


				Healthcare_Login login = new Healthcare_Login();
				login.frame.setVisible(true);

				dispose();
			}
		});
		btnLogout.setBounds(99, 335, 143, 39);
		contentPane.add(btnLogout);
	}
}
