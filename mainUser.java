/* window depicts user's own personal profile.
 * Here they can edit their bio, current status, and see their list of friends.
 * 
 */

package testScreen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class mainUser {
	static List list; //list depicting list of friends.
	private final static FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private static Text text; //string depicting user bio.
	private static Text text_1; //string depicting user's personal current status.

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainUser window = new mainUser();
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
		Shell shell = new Shell();
		shell.setSize(512, 360);
		shell.setText("SWT Application");
		
		//depicts user profile.
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblNewLabel.setBounds(30, 10, 126, 35);
		lblNewLabel.setText("Your Profile");
		
		Label lblFriends = new Label(shell, SWT.NONE);
		lblFriends.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblFriends.setBounds(360, 10, 87, 27);
		lblFriends.setText("Friends");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(296, 18, 12, 253);
		
		//when friend is added from another user's profile - that friend's name is added to list of friends here on user's personal page.
		List list = new List(shell, SWT.BORDER);
		list.setBounds(343, 43, 116, 228);
		list.add(userProf.added);
		
		//label fields become visible and permanent once bio and current status are set by user.
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(30, 68, 248, 15);
		formToolkit.adapt(lblNewLabel_1, true, true);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(30, 135, 248, 15);
		formToolkit.adapt(lblNewLabel_2, true, true);
		
		//text fields to set and edit user's bio
		text = new Text(shell, SWT.BORDER);
		text.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			lblNewLabel_1.setText(text.getText());
			text.setVisible(false); //text field deleted and entered text is depicted as label.
			lblNewLabel_1.setVisible(true); //label revealed to show changes to user bio.
		}
		});
		text.setBounds(30, 62, 260, 21);
		formToolkit.adapt(text, true, true);
		
		
		
		
		
		Label lblAddBio = new Label(shell, SWT.NONE);
		lblAddBio.setBounds(30, 43, 55, 15);
		formToolkit.adapt(lblAddBio, true, true);
		lblAddBio.setText("Add Bio");
		
		Label lblUpdateStatu = new Label(shell, SWT.NONE);
		lblUpdateStatu.setBounds(30, 108, 97, 15);
		formToolkit.adapt(lblUpdateStatu, true, true);
		lblUpdateStatu.setText("Update Status");
		
		//text field to edit user's current status.
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(30, 129, 260, 21);
		formToolkit.adapt(text_1, true, true);
		text_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			lblNewLabel_2.setText(text_1.getText());
			text_1.setVisible(false); //text field is deleted and entered text is depicted as label.
			lblNewLabel_2.setVisible(true); //label revealed to show changes to status.
		}
		});
		
		//button to navigate user back to landing page and news feed.
		Button btnBackToNews = new Button(shell, SWT.NONE);
		btnBackToNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				mainscreen.open();
			}
		});
		btnBackToNews.setBounds(22, 266, 105, 25);
		formToolkit.adapt(btnBackToNews, true, true);
		btnBackToNews.setText("Back to News Feed");
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
			
	}
}
