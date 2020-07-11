/*
This class depicts the window of the network's Sign-Up screen
User has the option to go back to login screen or signup.
User has to enter their first and last name, set their DOB, username, and password to proceed and join the network.
 * 
 */

package testScreen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class signup {
	private static Text text;
	private static Text text_1;
	private static Text text_2;
	private static Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			signup window = new signup(); //displays signup window.
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public static void open() {
		Display display = Display.getDefault();
		Shell shlSignupForWeconnnect = new Shell();
		shlSignupForWeconnnect.setSize(458, 338);
		shlSignupForWeconnnect.setText("Sign-Up for WeConnect");
		
		Label lblSignup = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblSignup.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSignup.setBounds(204, 10, 55, 31);
		lblSignup.setText("Signup");
		
		//text field to enter their First Name.
		Label lblFirstName = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblFirstName.setBounds(50, 46, 69, 15);
		lblFirstName.setText("First Name");
		
		text = new Text(shlSignupForWeconnnect, SWT.BORDER);
		text.setBounds(50, 67, 103, 21);
		
		//text field for user to enter their Last Name.
		Label lblNewLabel = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblNewLabel.setBounds(187, 47, 72, 15);
		lblNewLabel.setText("Last Name");
		
		text_1 = new Text(shlSignupForWeconnnect, SWT.BORDER);
		text_1.setBounds(187, 67, 103, 21);
		
		//date/time field for user to set their date of birth.
		Label lblDateOfBirth = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblDateOfBirth.setBounds(339, 46, 80, 15);
		lblDateOfBirth.setText("Date of Birth");
		
		DateTime dateTime = new DateTime(shlSignupForWeconnnect, SWT.BORDER);
		dateTime.setBounds(339, 64, 80, 24);
		
		//text field for user to enter their username.
		Label lblUsername = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblUsername.setBounds(50, 118, 69, 15);
		lblUsername.setText("Username");
		
		text_2 = new Text(shlSignupForWeconnnect, SWT.BORDER);
		text_2.setBounds(50, 139, 103, 21);
		
		//text field for user to enter their password.
		//field has password setting enabled so their text entry is hidden.
		Label lblNewLabel_1 = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblNewLabel_1.setBounds(50, 193, 183, 15);
		lblNewLabel_1.setText("Password (at least 12 characters)"); 
		
		text_3 = new Text(shlSignupForWeconnnect, SWT.BORDER | SWT.PASSWORD);
		text_3.setBounds(50, 214, 103, 21);
		
		
		Label lblNewLabel_2 = new Label(shlSignupForWeconnnect, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_2.setBounds(50, 241, 55, 15);
		lblNewLabel_2.setText(".");
		
		Button btnNewButton = new Button(shlSignupForWeconnnect, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_3.getCharCount() >= 12) { //condition to check if user's password and text entry is at least 12 characters.
					shlSignupForWeconnnect.close();
					mainscreen.open();
				}else {
					lblNewLabel_2.setText("Your password must be at least 12 characters."); //label returned if user's password entry is unsatisfactory.
				}
			}
		});
		
		//once all fields all filled, user clicks this button to officially join network.
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(280, 151, 124, 84);
		btnNewButton.setText("Join Network");
		
		//button to link user back to login screen.
		Button btnBackToLogin = new Button(shlSignupForWeconnnect, SWT.NONE);
		btnBackToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlSignupForWeconnnect.close();
				testprof.open();
			}
		});
		
		
		
		btnBackToLogin.setBounds(10, 0, 84, 25);
		btnBackToLogin.setText("Back to Login");

		shlSignupForWeconnnect.open();
		shlSignupForWeconnnect.layout();
		while (!shlSignupForWeconnnect.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

}
