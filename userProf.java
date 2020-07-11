//This class is a window to display another user's profile on the network when the user navigates to it.
//The user profile contains the user's name, their current status, and their current list of friends.
//The user also has the option to add them as a friend.

package testScreen;

import java.util.Random;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class userProf {
	
	//list of possible user statuses that can be found on other user's profiles when navigating.
	private static String[] statuses = new String[] {"Practicing Guitar!", "Out of the house - At the beach!" , "Doing Homework.", 
													 "Listening to Spotify.", "Walking my dog.", 
													 "Eating lunch with friends.", "At work again!", "At school...", 
													 "Please do not disturb - pretty busy right now", "Running errands outside.", "Went to play volleyball!", 
													 "Doing okay! :)", "Sick :(", "Resting up for a big day tomorrow!", 
													 "In the kitchen - I'm cooking up a surprise! ;)", "Pouring out so I'm chilling inside", "On a hike!", 
													 "Out of town for a weekend trip - please reach me at my phone number!"
													 };
	

	protected static Shell shell;
	public static String added; //string depicting the friend that the user added - prepares program to add this friend to the list on user's personal profile.
	
	
	//method to collect a random string from array.
	//inserts that random status onto one of the user's profiles when the user navigates to one.
	public static String getRandom(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			userProf window = new userProf();
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
		shell.setSize(580, 419);
		shell.setText("SWT Application");
		
		//displays user's name on profile based on user search for specific profile
		//search and display is based on collection of users in the names array.
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI Black", 15, SWT.BOLD));
		lblNewLabel.setBounds(33, 27, 180, 40);
		lblNewLabel.setText(mainscreen.names[mainscreen.placeholder]);
		
		//label to depict user's current status.
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(33, 84, 63, 27);
		lblNewLabel_1.setText("Status");
		
		//sets the user's current status based on list above.
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(33, 119, 167, 15);
		lblNewLabel_2.setText(getRandom(statuses));
		
		//depicts label designating list of friends.
		Label lblFriends = new Label(shell, SWT.NONE);
		lblFriends.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblFriends.setBounds(33, 208, 63, 27);
		lblFriends.setText("Friends");
		
		//button to direct user back to newsfeed and main landing page.
		Button btnBackToNewsfeed = new Button(shell, SWT.NONE);
		btnBackToNewsfeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.close();
				mainscreen.open();
			}
		});
		btnBackToNewsfeed.setBounds(419, 10, 124, 25);
		btnBackToNewsfeed.setText("Back to NewsFeed");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(33, 169, 480, 15);
		
		//button to add user as a friend - once added, the user shows up on the user's own profile in their list of friends.
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(241, 27, 98, 25);
		btnNewButton.setText("Add Friend");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnNewButton.setText("Added!");
				added = "" + mainscreen.names[mainscreen.placeholder]; //adds friend's name to string to prepare to add to list of personal friends on their profile page.
				//names.testprof.addEdge(9, mainscreen.placeholder); //adds edge between user and added friend to depict connection.
			}
		});
		
		//initializes and depicts list of another user and their list of friends.
		List list = new List(shell, SWT.BORDER);
		list.setBounds(25, 238, 152, 68);
		list.add("Vivian Tran");
		list.add("Kathy Nguyen");
		list.add("Kevin Nguyen");
		list.add("Darian Delaney");
		list.add("Heather Chang");
		

	}
}
