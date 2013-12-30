import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * AddMediaWindow class is used to create window where users can add new media to the program.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class AddMediaWindow extends JFrame{
	
	private static final long serialVersionUID = -2846640589177978406L;
	
	private String[] mediaTypes = { "Movie", "Music", "Series" };
	private MainWindow mainWindowRef;
	
    //Create table models for TV, movie, music
    BTableModel tableModel = new BTableModel("Movie",0);
    
    //CREATE TABLES FOR TV, movie, music
    JTable table = new JTable(tableModel);
    
	JScrollPane tableScrollPane = new JScrollPane(table);
	
	 JPanel north = new JPanel();
	 JPanel south = new JPanel();
	 JPanel center = new JPanel(new BorderLayout());
	 
	 JComboBox<String> type = new JComboBox<String>();
	 
	 List<String[]> addRows = new ArrayList<String[]>();

	/**
	 * Constructor for class AddMediaWindow.
	 */
	public AddMediaWindow() {
		initWindow();
	}
	
	/**
	 * Constructor for class AddMediaWindow.
	 */
	public AddMediaWindow(MainWindow ref) {
		mainWindowRef = ref;
		initWindow();
	}

	/**
	 * Creates a window which allows users to add media objects.
	 */
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    table.setEnabled(true);
	    tableModel.addRow(new Object[0]);
	    
	    table.setFillsViewportHeight(true);
	    
        panel.setToolTipText("NII VITTU USKALLA");
	   
	    
	    for (int i = 0; i < mediaTypes.length; i++) {
	        type.addItem(mediaTypes[i]);
	    }

	    type.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	
	           if(type.getSelectedItem().equals("Series")) {
	        	   tableModel = new BTableModel("TVSeries",0);
	        	   table.setModel(tableModel);
	        	   tableModel.addRow(new Object[0]);
	           }
	           
	           if(type.getSelectedItem().equals("Movie")) {
	        	   tableModel = new BTableModel("Movie",0);
	        	   table.setModel(tableModel);
	        	   tableModel.addRow(new Object[0]);	 
	           }
	           
	           if(type.getSelectedItem().equals("Music")) {
	        	   tableModel = new BTableModel("Music",0);
	        	   table.setModel(tableModel);
	        	   tableModel.addRow(new Object[0]);
	           }
	        }
	    });
   
	    JButton addButton = new JButton("Add");
	    
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		if(table.isEditing()) {
	    			 table.getCellEditor().stopCellEditing();
	    		}
	    		if(checkRowCorrectness()) {
	    			if(checkRating()) {
		    			addRowsToDatabase();
		    			setVisible(false);
	    			} else {
	    				PromptWindow c = new PromptWindow("Rating must be a number between 1-10");
	    				c.setVisible(true);
	    			}

	    		} else {
	    			PromptWindow d = new PromptWindow("Fields Publish Year, Rating must be a number.");
	    			d.setVisible(true);
	    		}
	    	}
	    });
	       
	    JButton nextButton = new JButton("Next");
	    nextButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		tableModel.addRow(new Object[0]);
	    		table.editCellAt(table.getRowCount()-1, 0);
	    	}
	    });
	       
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		setVisible(false);
	    	}
	    });
	       
	    JPanel typePanel = new JPanel(new GridLayout(1,2));
	    JLabel typeLabel = new JLabel("Type",JLabel.LEFT);

	    typePanel.add(typeLabel);
	    typePanel.add(type);

	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    
	    south.add(addButton);
	    south.add(nextButton);
	    south.add(cancelButton);
	   
	    north.add(typePanel);

	    center.add(tableScrollPane);
	    tableModel = new BTableModel("Movie",0);
	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Checks that the publishYear and rating is type of integer.
	 * 
	 * @return true if integer, false if not.
	 */
	protected boolean checkRowCorrectness() {
		int rowCount = table.getRowCount();
		int currentRow = 0;
		boolean correct = false;
		
		if(type.getSelectedItem().toString().equals("Series")) {
			while(currentRow < rowCount) {	
				correct = validateIntRow(table.getValueAt(currentRow, 4).toString());
				if(correct == false) { return false; }
				correct = validateIntRow(table.getValueAt(currentRow, 5).toString());
				if(correct == false) { return false; }
				currentRow++;
			}
		} else  {
			while(currentRow < rowCount) {	
				correct = validateIntRow(table.getValueAt(currentRow, 3).toString());
				if(correct == false) { return false; }
				correct = validateIntRow(table.getValueAt(currentRow, 4).toString());	
				if(correct == false) { return false; }
				currentRow++;
			}
			
		}
		return correct;
	}
	
	/**
	 * Check if the rating given is in range of 1-10.
	 * 
	 * @return	true, if rating is 1-0. false if not.
	 */
	protected boolean checkRating() {
		int rowCount = table.getRowCount();
		int currentRow = 0;
		boolean correct = false;
		int tmp;
		
		if(type.getSelectedItem().toString().equals("Series")) {
			while(currentRow < rowCount) {	
				tmp = Integer.parseInt(table.getValueAt(currentRow, 5).toString());
				
				if(tmp >= 1 && tmp <= 10) {
					correct = true;
				} else {
					return false;
				}
				currentRow++;
			}
		} else  {
			while(currentRow < rowCount) {	
				tmp = Integer.parseInt(table.getValueAt(currentRow, 4).toString());
				if(tmp >= 1 && tmp <= 10) {
					correct = true;
				} else {
					return false;
				}
				currentRow++;
			}
		}
		return correct;
	}

	/**
	 * Checks if string is actually a number.
	 * 
	 * @param str	string to be checked.
	 * @return		true if is number, false if not.
	 */
	private boolean validateIntRow(String str) {
		try {
			Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
			return false;
	}

	/**
	 * Used to add rows from the table actual Media and into the database.
	 */
	public void addRowsToDatabase() {
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		int currentRow = 0;
		int currentColumn = 0;
		List<String[]> rows = new ArrayList<String[]>();
		Iterator<String[]>rowIterator;
		
		while(currentRow < rowCount) {
			String[] tmp = new String[columnCount];
			while(currentColumn < columnCount) {
				tmp[currentColumn] = ((String) table.getValueAt(currentRow, currentColumn));
				System.out.println(((String) table.getValueAt(currentRow, currentColumn)));
				currentColumn++;
			}
			rows.add(tmp);
			currentRow++;
		}
		addRows = rows;
		rowIterator = rows.iterator();
		while(rowIterator.hasNext()) {
			String[] tmp = rowIterator.next();
			if(type.getSelectedItem().toString().equals("Series")) {
				mainWindowRef.addRow("TVSeries",tmp,1);
			} else {
				mainWindowRef.addRow(type.getSelectedItem().toString(), tmp,1);
			}
			
		}
		
	}

}
