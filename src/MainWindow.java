import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import statements
//Check if window closes automatically. Otherwise add suitable code

class BTableModel extends DefaultTableModel {
	String type;
	int del;
	
	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			if(type.equals("TVSeries")) {
				return String.class;
			} else { return Boolean.class; }
			
		default:
			return Boolean.class;
		}
	}
	
	
	BTableModel(String type, int del) {
		this.type = type;
		this.del = del;
		switch (type) {
			case "TVSeries":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Series");
				this.addColumn("Episode");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
			case "Music":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Artist");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
				
			case "Movie":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Language");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
		}
		if(del == 1) {
			this.addColumn("Select");
		}
	}
	
	 public boolean isCellEditable ( int row, int column )
     {
		 if(del == 1) {
			 if(getColumnClass(column) == Boolean.class) {
				 return true;
			 } else {
				 return false; 
			 }
		 }  else {
				 return true;
		 }
		
     }
	
	BTableModel() {}
	
}

public class MainWindow extends JFrame {
	
    MainWindow mainRef = this;
	MediaObject database;
	DatabaseCreator dc;
	JScrollPane tvScrollPane;
	JScrollPane movieScrollPane;
	JScrollPane musicScrollPane;
    //Create table models for TV, movie, music
    BTableModel tvModel = new BTableModel("TVSeries",1);
    BTableModel movieModel = new BTableModel("Movie",1);
    BTableModel musicModel = new BTableModel("Music",1);
    
    //CREATE TABLES FOR TV, movie, music
    JTable tvTable = new JTable(tvModel);
    JTable movieTable = new JTable(movieModel);
    JTable musicTable = new JTable(musicModel);
    
    JTextField search = new JTextField(20);
    String searchInput;
    
    JTabbedPane tabbedPane = new JTabbedPane();
	
	public MainWindow() {}
	public MainWindow(DatabaseCreator dc) {
		initUI();
		this.database = dc.getDatabases();
		this.dc = dc;
	}
	
	public final void initUI() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    BorderLayout panelLayout = new BorderLayout();
	    panelLayout.setHgap(10);
	    panelLayout.setVgap(10);
	    panel.setLayout(panelLayout);
	    
        panel.setToolTipText("NII VITTU USKALLA");
        
        //hide id column
       /* tvTable.getColumnModel().getColumn(0).setMinWidth(0);
        tvTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        movieTable.getColumnModel().getColumn(0).setMinWidth(0);
        movieTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        musicTable.getColumnModel().getColumn(0).setMinWidth(0);
        musicTable.getColumnModel().getColumn(0).setMaxWidth(0);*/
        
	    tvScrollPane = new JScrollPane(tvTable);
	    movieScrollPane = new JScrollPane(movieTable);
	    musicScrollPane = new JScrollPane(musicTable);
	    
	    tvTable.setFillsViewportHeight(true);
	    movieTable.setFillsViewportHeight(true);
	    musicTable.setFillsViewportHeight(true);
	       
	    JButton quitButton = new JButton("Quit");
	    //quitButton.setBounds(50, 60, 80, 30);
	    quitButton.setToolTipText("SAMMUTA MUT PRKL");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		System.exit(0);
	    	}
	    });
   
	    JButton searchButton = new JButton("Search");
	    searchButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		if(!search.getText().equals("")) {
		    		searchInput = search.getText();
		    		searchDatabase(searchInput);
		    		searchInput = "";
	    		} else {
	    			if(tabbedPane.getSelectedIndex() == 0) {
	    				movieModel.setRowCount(0);
	    				getRows("Movie");
	    			} else if (tabbedPane.getSelectedIndex() == 1) {
	    				musicModel.setRowCount(0);
	    				getRows("Music");
	    			} else {
	    				tvModel.setRowCount(0);
	    				getRows("TVSeries");
	    			}
	    		}
	
	    	}
	    });

	    JButton addButton = new JButton("Add");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
                AddMediaWindow xe = new AddMediaWindow(mainRef);
                xe.setVisible(true);
	    	}
	    });
	    
	    JButton modifyButton = new JButton("Modify");
	    modifyButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		List<Integer> idArray = getIdsFromSelectedRows();
	    		ModifyWindow mf = new ModifyWindow(mainRef, idArray);
	    	}
	    });
	       
	    JButton removeButton = new JButton("Delete");
	    removeButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		List<Integer> idArray = getIdsFromSelectedRows();
	    		if (!idArray.isEmpty()) {
	    			PromptWindow pw = new PromptWindow("Are you sure you want to delete selected rows?", database, mainRef, idArray);
	    			pw.setVisible(true);
	    		} else {
	    			PromptWindow pw = new PromptWindow("You did not choose anything to be removed!");
	    			pw.setVisible(true);
	    		}
	    	}
	    });
	       
	    JButton helpButton = new JButton("Manual");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });

        GridLayout tabbedGrid = new GridLayout(1,2);
	    JPanel north = new JPanel(tabbedGrid);
	    JPanel south = new JPanel();
	    JPanel center = new JPanel();
	    GridLayout westGrid = new GridLayout(20,3);

	    westGrid.setHgap(10);
	    westGrid.setVgap(10);
	    JPanel west = new JPanel(westGrid);

	    JLabel searchLabel = new JLabel("Search:");
	    searchLabel.setSize(50, 10);
	    
	    tabbedPane.addTab("Movies", null, movieScrollPane,
	                      "Does nothing");
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	    
        tabbedPane.addTab("Music", null, musicScrollPane,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        tabbedPane.addTab("Series", null, tvScrollPane,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
       
	    
	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    panel.add(west, BorderLayout.WEST);
	    
	    south.add(addButton);
	    south.add(modifyButton);
	    south.add(removeButton);
	    south.add(helpButton);
	    south.add(quitButton);
	    
	    center.add(searchLabel);
	    center.add(search);
	    center.add(searchButton);
	  
	    
	    north.add(tabbedPane);

	    setTitle("Media Collector");
	    setSize(800,600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected List<Integer> getIdsFromSelectedRows() {
		List<Integer> intList = new ArrayList<Integer>();
		//get current table in use
		int currentTable = tabbedPane.getSelectedIndex();
		int currentRows;
		int currentColumns;
		if(currentTable == 0) {
			currentRows = movieModel.getRowCount();
			currentColumns = movieModel.getColumnCount();
		} else if (currentTable == 1) {
			currentRows = musicModel.getRowCount();
			currentColumns = musicModel.getColumnCount();
		} else {
			currentRows = tvModel.getRowCount();
			currentColumns = tvModel.getColumnCount();
		}
		for(int i = 0; i < currentRows; i++) {
			
			if(currentTable == 0) {
				if(movieModel.getValueAt(i, currentColumns-1) != null ) {
					if(movieModel.getValueAt(i, currentColumns-1).toString().equals("true")) {
						intList.add(Integer.parseInt(movieModel.getValueAt(i,0).toString()));
					}
				}
				
			} else if (currentTable == 1) {
				if(musicModel.getValueAt(i, currentColumns-1) != null ) {
					if(musicModel.getValueAt(i, currentColumns-1).toString().equals("true")) {
						intList.add(Integer.parseInt(musicModel.getValueAt(i,0).toString()));
					}
				}
				
			} else {
				if(tvModel.getValueAt(i, currentColumns-1) != null ) {
					if(tvModel.getValueAt(i, currentColumns-1).toString().equals("true")) {
						intList.add(Integer.parseInt(tvModel.getValueAt(i,0).toString()));
					}
				}
				
			}
		}
			
		return intList;
	}
	protected void searchDatabase(String name) {
		String type;
	
		if (tabbedPane.getSelectedIndex() == 0) {
			type = "Movie"; 
			movieModel.setRowCount(0);
		} else if (tabbedPane.getSelectedIndex() == 1) {
			type = "Music";
			musicModel.setRowCount(0);
		} else {
			type = "TVSeries";
			tvModel.setRowCount(0);
		}
		
		List<String[]> rows = new ArrayList<String[]>();
		List<MediaItem> items = database.getObject(type);
		List<MediaItem> item;

		Iterator<MediaItem> iterator = items.iterator();
		Iterator<MediaItem> itemIterator;
		Iterator<String[]>rowIterator;

		
		while(iterator.hasNext()) {
			MediaObject tmp = (MediaObject) iterator.next();
			item = tmp.getItems();
			itemIterator = item.iterator();
			while(itemIterator.hasNext()) {
				MediaItem tmp2 = itemIterator.next();
				
				if(tmp2.getTitle().equals(name)) {
					rows.add(tmp2.getRow());
				}

			}
		}
		
		rowIterator = rows.iterator();
		
		if(rows != null) {
			while(rowIterator.hasNext()) {
				addRow(type, rowIterator.next(),0);
			}
		}
		
	}
	
	public static void main(String args[]) {
		  
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	FileParser fp;
	            	DatabaseCreator dc = null;
	            	try {
	            		fp = new FileParser();
	            		dc = new DatabaseCreator(fp);
	            		dc.createDatabases();
	            		dc.print();
	            		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	                MainWindow ex = new MainWindow(dc);

	                ex.getRows("Movie");
	                ex.getRows("Music");
	                ex.getRows("TVSeries");
	                ex.setVisible(true);
	                
	            }
	        });
	}
	
	protected void addRow(String type, String[] row, int add) {
		if(type.equals("TVSeries")) {
			tvModel.addRow(new Object[0]);
		} else if (type.equals("Movie")) {
			movieModel.addRow(new Object[0]);
		} else if (type.equals("Music")) {
			musicModel.addRow(new Object[0]);
		}

		for(int i = 0; i < row.length; i++) {
			switch(type) {
			case "TVSeries":
				tvModel.setValueAt(row[i], tvModel.getRowCount()-1, i);
				break;
			case "Movie":
				movieModel.setValueAt(row[i], movieModel.getRowCount()-1, i);
				break;
			case "Music":
				musicModel.setValueAt(row[i], musicModel.getRowCount()-1, i);
				break;
			}
		}
		if (add == 1) {
			if(type.equals("TVSeries")) {
				String [] combinedString = { "TVSeries", row[1], row[2], row[3], row[4], row[5], row[6] };
				dc.createDatabase(Arrays.toString(combinedString));
			} else if (type.equals("Movie")) {
				String [] combinedString = { "Movie", row[1], row[2], row[3], row[4], row[5] };
				dc.createDatabase(Arrays.toString(combinedString));
			} else if (type.equals("Music")) {
				String [] combinedString = { "Music", row[1], row[2], row[3], row[4], row[5] };
				dc.createDatabase(Arrays.toString(combinedString));
			}
		}
		
	}
	
	protected void getRows(String type) {
		List<String[]> rows = new ArrayList<String[]>();
		List<MediaItem> items = database.getObject(type);
		List<MediaItem> item;

		Iterator<MediaItem> iterator = items.iterator();
		Iterator<MediaItem> itemIterator;
		Iterator<String[]> rowIterator;
		
		
		while(iterator.hasNext()) {
			MediaObject tmp = (MediaObject) iterator.next();
			item = tmp.getItems();
			itemIterator = item.iterator();
			while(itemIterator.hasNext()) {
				rows.add(itemIterator.next().getRow());
			}
		}

		rowIterator = rows.iterator();
		
		if(rows != null) {
			while(rowIterator.hasNext()) {
				addRow(type, rowIterator.next(),0);
			}
		}
		
	}
	public void deleteRowFromTable(int id) {
		int currentTable = tabbedPane.getSelectedIndex();
		
		if(currentTable == 0) {
			for(int row = 0;row < movieModel.getRowCount();row++) {
				if(movieModel.getValueAt(row, 0).equals(Integer.toString(id))) {
					movieModel.removeRow(row);
				}
			}
		}

		if (currentTable == 1) {
			for(int row = 0;row < musicModel.getRowCount();row++) {
				if(musicModel.getValueAt(row, 0).equals(Integer.toString(id))) {
					musicModel.removeRow(row);
				}
			}

		}
		
		if (currentTable == 2) {
			for(int row = 0;row < tvModel.getRowCount();row++) {
				if(tvModel.getValueAt(row, 0).equals(Integer.toString(id))) {
					tvModel.removeRow(row);
				}
			}
		}

	}
}

