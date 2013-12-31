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
import java.util.Iterator;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * MainWindow class is used as to create main window for the program.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 3485582852539131332L;
	
	private MainWindow mainRef = this;
	private MediaObject database;
	private DatabaseCreator dc;
	
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
	
    /**
     * Constructor for the class MainWindow.
     * 
     * @param dc	database of MediaItems.
     */
	public MainWindow(DatabaseCreator dc) {
		FileManager fm = new FileManager();
		MediaObject dbFromFile = fm.readFile();
		
		initUI();
		this.dc = dc;
		dc.createDatabasesNew(dbFromFile);
		this.database = dc.getDatabases();
		
		Media.setId(dc.getHighestId());
        getRows("Movie");
        getRows("Music");
        getRows("TVSeries");
	}
	
	/**
	 * Used to get the database of MediaItems.
	 * 
	 * @return	database of MediaItems.
	 */
	public MediaObject getDatabase() {
		return database;
	}
	
	/**
	 * Used to create the actual window of MainWindow.
	 */
	public final void initUI() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    BorderLayout panelLayout = new BorderLayout();
	    panelLayout.setHgap(10);
	    panelLayout.setVgap(10);
	    panel.setLayout(panelLayout);
	    
        panel.setToolTipText("Using media collector main window");
        
        //hide id column
        tvTable.getColumnModel().getColumn(0).setMinWidth(0);
        tvTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        movieTable.getColumnModel().getColumn(0).setMinWidth(0);
        movieTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
        musicTable.getColumnModel().getColumn(0).setMinWidth(0);
        musicTable.getColumnModel().getColumn(0).setMaxWidth(0);
        
	    tvScrollPane = new JScrollPane(tvTable);
	    movieScrollPane = new JScrollPane(movieTable);
	    musicScrollPane = new JScrollPane(musicTable);
	    
	    tvTable.setFillsViewportHeight(true);
	    movieTable.setFillsViewportHeight(true);
	    musicTable.setFillsViewportHeight(true);
	       
	    JButton quitButton = new JButton("Quit");
	    quitButton.setToolTipText("Shutdown the program");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		FileManager fm = new FileManager();
	    		fm.writeToFile(dc.getDatabases());
	    		System.exit(0);
	    	}
	    });
   
	    JButton searchButton = new JButton("Search");
	    searchButton.setToolTipText("Search for media");
	    searchButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		if(!search.getText().equals("")) {
		    		searchInput = search.getText();
		    		searchDatabase(searchInput);
		    		searchInput = "";
	    		} else {
	    			if(tabbedPane.getSelectedIndex() == 0) {
	    				emptyRowsGetNewRows("Movie");
	    			} else if (tabbedPane.getSelectedIndex() == 1) {
	    				emptyRowsGetNewRows("Music");
	    			} else {
	    				emptyRowsGetNewRows("TVSeries");
	    			}
	    		}
	
	    	}
	    });

	    JButton addButton = new JButton("Add");
	    addButton.setToolTipText("Add more media");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
                AddMediaWindow xe = new AddMediaWindow(mainRef);
                xe.setVisible(true);
	    	}
	    });
	    
	    JButton modifyButton = new JButton("Modify");
	    modifyButton.setToolTipText("Modify selected media items");
	    modifyButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		List<Integer> idArray = getIdsFromSelectedRows();
	    		if(idArray.isEmpty()) {
	    			PromptWindow pw = new PromptWindow("You did not choose anything to be modified!");
	    			pw.setVisible(true);
	    		} else {
		    		ModifyWindow mf = new ModifyWindow(mainRef, getDatabase(), idArray, tabbedPane.getSelectedIndex());
		    		mf.setVisible(true);
	    		}

	    	}
	    });
	       
	    JButton removeButton = new JButton("Delete");
	    removeButton.setToolTipText("Delete selected media items");
	    removeButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
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
	    helpButton.setToolTipText("See manual on the usage of this program");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
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
	                      "Open movie table");
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	    
        tabbedPane.addTab("Music", null, musicScrollPane,
                "Open music table");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        tabbedPane.addTab("Series", null, tvScrollPane,
                "Open series table");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        
        movieTable.setToolTipText("This table contains all movie medias that are stored in the database");
        tvTable.setToolTipText("This table contains all tv series that are stored in the database");
        musicTable.setToolTipText("This table contains all music medias that are stored in the database");
	    
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
	
	/**
	 * Used to get the ID's of the items in the table.
	 * 
	 * @return
	 */
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
	
	/**
	 * Used to search the database of specific objects using
	 * a search string.
	 * 
	 * @param name	name of the object wanted.
	 */
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
	            		
					} catch (IOException e) {
						e.printStackTrace();
					}
	            	
	                MainWindow ex = new MainWindow(dc);
	                ex.setVisible(true);
	                
	            }
	        });
	}
	
	/**
	 * Used to add row to the table and to add new media to the database.
	 * 
	 * @param type	which kind of media is currently wanted to be added.
	 * @param row	contains the information which will be inserted to the media items.
	 * @param add	if 1 then add new media item to database.
	 */
	protected void addRow(String type, String[] row, int add) {
		if(type.equals("TVSeries")) {
			tvModel.addRow(new Object[0]);
		} else if (type.equals("Movie")) {
			movieModel.addRow(new Object[0]);
		} else if (type.equals("Music")) {
			musicModel.addRow(new Object[0]);
		}

		for(int i = 0; i < row.length; i++) {
			//System.out.println(row[i]);
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
				String combined = "TVSeries" + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5] + "," + row[6];
				dc.createDatabase(combined);
			} else if (type.equals("Movie")) {
				String combined = "Movie" + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5];
				dc.createDatabase(combined);
			} else if (type.equals("Music")) {
				String combined = "Music" + "," + row[1] + "," + row[2] + "," + row[3] + "," + row[4] + "," + row[5];
				dc.createDatabase(combined);
			}
			emptyRowsGetNewRows(type);
		}
		
		
	}
	
	/**
	 * Gets all media items of certain type and adds them to the
	 * corresponding table
	 * 
	 * @param type	type of the media. e.x. Music.
	 */
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
	
	/**
	 * Used to empty all rows of table and
	 * get new ones from the database. Used to update the table
	 * in a way.
	 * 
	 * @param type which table to be emptied and updated.
	 */
	public void emptyRowsGetNewRows(String type) {
		if(type.equals("Movie")) {
			movieModel.setRowCount(0);
			getRows("Movie");
		} else if (type.equals("Music")) {
			musicModel.setRowCount(0);
			getRows("Music");
		} else {
			tvModel.setRowCount(0);
			getRows("TVSeries");
		}
		
	}
	
	/**
	 * Used to delete row using an id.
	 * 
	 * @param id	target row to be deleted.
	 */
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

