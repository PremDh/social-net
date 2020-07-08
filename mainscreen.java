/* The main portal and user feed for the network. When the user logins, they are immediately directed to this screen where they can search for friends
 * and navigate to their own user profile.
 * Also has the option to delete their profile from here.
 */

package testScreen;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

public class mainscreen {

	protected static Shell shell1;
	private static Text text;
	
	//string array of all users of program initialized.
	public static String[] names = new String[] {"Johnny Simpson", "Heather Chang", "Darian Delaney", 
												 "Bruno Liu", "Kevin Nguyen", "Davy Propper", 
												 "Kathy Nguyen", "Vivian Tran"};
	
	//placeholder variable to help search and direct user to correct user's profile.
	public static int placeholder = -1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainscreen window = new mainscreen();
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
		createContents();
		shell1.open();
		shell1.layout();
		while (!shell1.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected static void createContents() {
		shell1 = new Shell();
		shell1.setSize(678, 481);
		shell1.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI Black", 11, SWT.NORMAL));
		lblNewLabel.setBounds(10, 28, 155, 20);
		lblNewLabel.setText("Friend Suggestions");
		
		Label label = new Label(shell1, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(165, 4, 39, 394);
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(shell1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_1.setBounds(10, 65, 138, 94);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		//List of friend suggestions to help user's search.
		List list = new List(scrolledComposite_1, SWT.BORDER);
		list.add("Johnny Simpson");
		list.add("Heather Chang");
		list.add("Darian Delaney");
		list.add("Bruno Liu");
		list.add("Kevin Nguyen");
		list.add("Davy Propper");
		list.add("Kathy Nguyen");
		list.add("Vivian Tran");
		scrolledComposite_1.setContent(list);
		scrolledComposite_1.setMinSize(list.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Label label_1 = new Label(shell1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(199, 44, 335, 15);
		
		//main feed and space for other friend's statuses and posts to show up for user.
		Label lblNewsFeed = new Label(shell1, SWT.NONE);
		lblNewsFeed.setFont(SWTResourceManager.getFont("Segoe UI Black", 22, SWT.BOLD));
		lblNewsFeed.setBounds(208, 302, 210, 40);
		lblNewsFeed.setText("News Feed");
		
		Label lblWeconnect = new Label(shell1, SWT.NONE);
		lblWeconnect.setText("WeConnect");
		lblWeconnect.setFont(SWTResourceManager.getFont("Segoe UI Black", 22, SWT.BOLD));
		lblWeconnect.setBounds(254, 0, 210, 40);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(199, 347, 353, 85);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		//button to delete account - directs user out of network/newsfeed and back to login screen.
		//User can proceed to make a new account from there.
		Button btnNewButton = new Button(shell1, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell1.close();
				testprof.open();
			}
		});
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnNewButton.setBounds(559, 10, 93, 25);
		btnNewButton.setText("Delete Account");
		
		//Search engine for user to enter name to be directed to another user's profile.
		Label lblSearch = new Label(shell1, SWT.NONE);
		lblSearch.setText("Search");
		lblSearch.setFont(SWTResourceManager.getFont("Segoe UI Black", 11, SWT.NORMAL));
		lblSearch.setBounds(10, 178, 155, 20);
		
		text = new Text(shell1, SWT.BORDER);
		text.setBounds(10, 204, 138, 21);
		
		//button to signal to collect the user's search query.
		Button btnSearchFriend = new Button(shell1, SWT.NONE);
		btnSearchFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { //upon button click, program iterates through string array of names to search for user profile.
				placeholder++;
				for(int i = 0; i < names.length; i++) {
					placeholder = i;
					if(text.getText().equals(names[i])) {
						shell1.close();
						userProf.open(); //if correct user profile is found, user is immediately directed to that other user's profile.
					}
						
				}
			}
		});
		btnSearchFriend.setBounds(10, 232, 75, 25);
		btnSearchFriend.setText("Search Friend");
		
		//space and "feed" for other friend's profiles to show up.
		Label lblAddFriendTo = new Label(shell1, SWT.NONE);
		lblAddFriendTo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblAddFriendTo.setBounds(210, 65, 335, 46);
		lblAddFriendTo.setText("Add friends to see their posts and statuses pop up!");
		
		//button to link user to their own personal profile
		//Can update user status and bio from this profile.
		Button btnNewButton_1 = new Button(shell1, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell1.close();
				mainUser.open();
			}
		});
		btnNewButton_1.setBounds(560, 53, 92, 40);
		btnNewButton_1.setText("Go to Profile");
		

	}
}
