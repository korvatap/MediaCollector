import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;

/**
 * PromptWindow class is used to creat prompt windows that will guide the user in the use of this program.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class PromptWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private String message = " ";
	private MediaObject database;
	private List<Integer> idArray;
	private PromptWindow ref;
	private MainWindow mainRef;
		
	/**
	 * Constructor for PromptWindow. This is used to create delete confirmation window.
	 * 
	 * @param text		text that will be displayed at the window.
	 * @param database	database is used to make modifications to the objects.
	 * @param mainRef	reference to the main window to inform it about changes..
	 * @param idArray	id's of objects that will be deleted
	 */
	public PromptWindow(String text, MediaObject database, MainWindow mainRef, List<Integer> idArray) {
		this.database = database;
		this.idArray = idArray;
		this.mainRef = mainRef;
		setPromptText(text);
		initWindow();
		ref = this;
	}
		
	/**
	 * Constructor for PromptWindow. This is used to tell user about what they have done wrong.
	 * 
	 * @param text		text that will be displayed at the window.
	 */
	public PromptWindow(String text) {
		setPromptText(text);
		initWindowOK();
		ref = this;
	}
		
	/**
	 * Sets the message text to a wanted text.
	 * 
	 * @param text		text to be set as message.
	 */
		
	private void setPromptText(String text) {
		this.message = text;
	}
 
	/**
	 * Creates a window which display a message to the user.
	 */
	public final void initWindowOK() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		
		JLabel messageJlb = new JLabel(message,JLabel.CENTER); 
			
		JButton confirmButton = new JButton("OK");
	    confirmButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		ref.setVisible(false);
	    	}
	    });
		    
	    JPanel north = new JPanel();
	    JPanel south = new JPanel();
	    panel.add(north, BorderLayout.NORTH);  
	    panel.add(south, BorderLayout.SOUTH);
		    
	    north.add(messageJlb);
	    south.add(confirmButton);
		    
	    setTitle("Media Collector");
	    setSize(500, 200);
	    setLocationRelativeTo(null);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Creates a window for the user which displays a message.
	 * Used for confirming the deletion of media.
	 */
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
		    
	    panel.setToolTipText("NII VITTU USKALLA");
		    
	    JLabel messageJlb = new JLabel(message,JLabel.CENTER); 
   
	    JButton confirmButton = new JButton("Yes");
	    confirmButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		Iterator<Integer> idIterator = idArray.iterator(); 
	    		while (idIterator.hasNext()) {
	    			Integer tmp = idIterator.next();
	    			mainRef.deleteRowFromTable(tmp);
	    			database.deleteObjectById(tmp);
	    		}
	    		ref.setVisible(false);
	    	}
	    });
		       
	    JButton cancelButton = new JButton("No");
	    cancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		ref.setVisible(false);
	    	}
	    });
		       
	    JPanel north = new JPanel();
	    JPanel south = new JPanel();
		   
	    panel.add(north, BorderLayout.NORTH);  
	    panel.add(south, BorderLayout.SOUTH);
		    
	    north.add(messageJlb);
	    south.add(confirmButton);
	    south.add(cancelButton);
		  
	    setTitle("Media Collector");
	    setSize(500, 200);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}