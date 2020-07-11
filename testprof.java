/*Main Class:
This is the login screen, where the program starts.
If the user is new, they have the option to signup, or just login with their username and password
if they are already registered.
 * *
 */

package testScreen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

//This class depicts the original login screen and window.
public class testprof{

	protected static Shell shell;
	private static Text text;
	private static Text txtEnterSomething;
	private final static FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	public static String[] names = mainscreen.names; //string array of all users of the program

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			testprof window = new testprof(); //login screen is initialized for user.
			//names.friendGraph.origFriend(); //friend graph is initialized to depict each user's friends.
			window.open();
			signup window1 = new signup(); 
		} catch (Exception e) {
			e.printStackTrace(); //throws error to safely halt program execution if program window fails to initialize.
		}
	}

	/**
	 * Open the window.
	 */
	public static void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected static void createContents() {
		shell = new Shell();
		shell.setSize(513, 392);
		shell.setText("Welcome to WeConnect!");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(152, 73, 53, 15);
		lblNewLabel.setText("Username");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(152, 95, 179, 21);
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setText("Password");
		lblPassword.setBounds(150, 146, 55, 15);
		
		txtEnterSomething = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtEnterSomething.setTouchEnabled(true);
		txtEnterSomething.setToolTipText("");
		txtEnterSomething.setBounds(152, 167, 179, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(152, 203, 75, 25);
		formToolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Login");
		
		Label lblWeconnect = new Label(shell, SWT.NONE);
		lblWeconnect.setText("WeConnect");
		lblWeconnect.setFont(SWTResourceManager.getFont("Segoe UI Black", 22, SWT.BOLD));
		lblWeconnect.setBounds(152, 15, 210, 52);
		formToolkit.adapt(lblWeconnect, true, true);
		
		//button links to Sign-Up screen is new user.
		Button btnSignup = new Button(shell, SWT.NONE);
		btnSignup.addMouseListener(new MouseAdapter() { //action listener for clicking down on Sign-Up button.
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close(); //signal for login screen to close and immediately open Sign-up window on button click.
				signup.open();
			}
		});
		btnSignup.setBounds(152, 269, 75, 25);
		formToolkit.adapt(btnSignup, true, true);
		btnSignup.setText("Sign-Up");
		
		
		Label lblNotAMember = new Label(shell, SWT.NONE);
		lblNotAMember.setBounds(150, 248, 101, 15);
		formToolkit.adapt(lblNotAMember, true, true);
		lblNotAMember.setText("New member?");

	}
}
