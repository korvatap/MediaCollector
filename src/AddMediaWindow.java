import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AddMediaWindow extends JFrame{
	
	private String[] mediaTypes = { "Movie", "Music", "Series" };
	private String[] categories = { "Ebullient", "Obtuse", "Recalcitrant", "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent" };  
	
    //Create table models for TV, movie, music
    BTableModel tableModel = new BTableModel("Movie");
    
    //CREATE TABLES FOR TV, movie, music
    JTable table = new JTable(tableModel);
    
	JScrollPane tableScrollPane = new JScrollPane(table);
	
	 JPanel north = new JPanel();
	 JPanel south = new JPanel();
	 JPanel center = new JPanel(new BorderLayout());
	 
	 JComboBox<String> type = new JComboBox<String>();

	
	public AddMediaWindow() {
		initWindow();
	}
	
	
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    table.setEnabled(true);
	    tableModel.setColumnCount(tableModel.getColumnCount()-1);
	    tableModel.addRow(new Object[0]);
	    
	    table.setFillsViewportHeight(true);
	    
        panel.setToolTipText("NII VITTU USKALLA");
	   
	    
	    for (int i = 0; i < mediaTypes.length; i++) {
	        type.addItem(mediaTypes[i]);
	    }
	    
	    type.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	
	           if(type.getSelectedItem().equals("Series")) {
	        	   tableModel.setColumnCount(0);
	        	   tableModel.addColumn("Title");
	        	   tableModel.addColumn("Series");
	        	   tableModel.addColumn("Episode");
	        	   tableModel.addColumn("Publish Year");
	        	   tableModel.addColumn("Rating");
	        	   tableModel.addColumn("Genre");
	           }
	           
	           if(type.getSelectedItem().equals("Movie")) {
	        	   tableModel.setColumnCount(0);
	        	   tableModel.addColumn("Title");
	        	   tableModel.addColumn("Language");
	        	   tableModel.addColumn("Publish Year");
	        	   tableModel.addColumn("Rating");
	        	   tableModel.addColumn("Genre");
	           }
	           
	           if(type.getSelectedItem().equals("Music")) {
	        	   tableModel.setColumnCount(0);
	        	   tableModel.addColumn("Title");
	        	   tableModel.addColumn("Artist");
	        	   tableModel.addColumn("Publish Year");
	        	   tableModel.addColumn("Rating");
	        	   tableModel.addColumn("Genre");
	           }
	        }
	    });
   
	    JButton addButton = new JButton("Add");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		addRowsToDatabase();
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
   
	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addRowsToDatabase() {
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		int currentRow = 0;
		int currentColumn = 0;
		List<String[]> rows = new ArrayList<String[]>();
		
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
		
	}

}
