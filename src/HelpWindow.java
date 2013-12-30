import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * HelpWindow class is used as to create help window to assis users in the usage of the program.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class HelpWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel helpText = new JLabel();
	HelpWindow ref;

	/**
	 * Constructor for HelpWindow class.
	 */
	public HelpWindow() {
		ref = this;
		initWindow();
	}
	
	/**
	 * Used to choose which help text to be presented for the user.
	 * 
	 * @param type	which kind of text to be presented.
	 */
	public void setHelpText(int type) {
		switch(type) {
			case 1: helpText.setText("<html><h2>Add media instructions</h2>" +
					"<br> - Media can be added using the Add button in the main window." +
					"<br> - After this a window will open and there you have to fill the fields with information you want. <br>" +
					" - The next button in the add window will create new row to the table which enables you to add<br> multiple medias in a fast way in to the database." +
					"<br>- The Add button in the Add window finally then adds the new medias in to the database.<br> - This is supposed to be pressed when the information for the media has been inserted in to the table." +
					"<br>- The cancel button just cancels the new media adding feature and no information is saved to the database. </html>");				
			break;
			case 2: helpText.setText("<html><h2>Media search instructions</h2><br>- If you want to search media you just need to select the correct tab in the main window first.<br>" +
					"- After this you type to the search box the search string you want to use and press search.<br>" +
					"- The program will then list all media found using the search string.</html>");
									
			break;
			case 3: helpText.setText("<html><h2>How to delete media </h2<br>- You can delete media by ticking the select column of the corresponding media you want to delete.<br>" +
					"- After this you just press delete button and the media will be deleted if you choose to confirm the removal of the media.</html>");
									
			break;
			case 4: helpText.setText("<html><h2>How to modify media</h2> <br>- To be able to modify media you first have to select the media you want to modify." +
					"<br>- This can be achieved by ticking the select column of the target media to be modified.<br>" +
					"- After this you just press the modify button and a new window will open.<br>" +
					"- In the new window you have a table with the media information you selected.<br>" +
					"- Now you can modify the media information straight from the table and after that pressing save to save the media.<br>" +
					"- Cancel button is to cancel the procedure and no modifications to the media will be saved.</html>");
									
			break;
			default: helpText.setText("<html><h2>How to delete media </h2<br>- You can delete media by ticking the select column of the corresponding media you want to delete.<br>" +
					"- After this you just press delete button and the media will be deleted if you choose to confirm the removal of the media.</html>");
									
			break;
		}
	}
	
	/**
	 * Used to create the help window. Constains definitions of 
	 * buttons and labels.
	 */
	public final void initWindow() {
		 JPanel panel = new JPanel();
		 getContentPane().add(panel);
		 panel.setLayout(new BorderLayout());
		 
		 helpText.setText("Choose which instruction you want to read by pressing the corresponding button.");
		 
		 
		 JButton mediaAddHelp = new JButton("How to add media");
		 mediaAddHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(1);
		    	}
		 });
		 
		 JButton closeButton = new JButton("Close");
		 closeButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setVisible(false);
		    	}
		 });
		 
		 JButton mediaSearchHelp = new JButton("How to search media");
		 mediaSearchHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(2);
		    	}
		 });
		 
		 JButton mediaDeleteHelp = new JButton("How to remove media");
		 mediaDeleteHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(3);
		    	}
		 });
		 
		 JButton mediaModifyHelp = new JButton("How to modify media");
		 mediaModifyHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(4);
		    	}
		 });
		 
		 JPanel north = new JPanel();
		 JPanel center = new JPanel();
		 JPanel south = new JPanel();
		 center.setBorder(BorderFactory.createLineBorder(Color.black));
		    
		 panel.add(north, BorderLayout.NORTH);
		 panel.add(center, BorderLayout.CENTER);
		 panel.add(south, BorderLayout.SOUTH);
		    
		 north.add(mediaAddHelp);
		 north.add(mediaSearchHelp);
		 north.add(mediaDeleteHelp);
		 north.add(mediaModifyHelp);
		 
		 south.add(closeButton);
		 
		 center.add(helpText);

		 setTitle("Media Collector");
		 setSize(800, 600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
