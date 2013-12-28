import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ModifyWindow extends JFrame {

	private static final long serialVersionUID = 3781413385233728385L;
	
	private MainWindow mainRef;
	
    //Create table models for TV, movie, music
    BTableModel tableModel = new BTableModel("Movie",0);
    
    //CREATE TABLES FOR TV, movie, music
    JTable table = new JTable(tableModel);
    
	JScrollPane tableScrollPane = new JScrollPane(table);
	
	 JPanel south = new JPanel();
	 JPanel center = new JPanel(new BorderLayout());
	 
	 
	 List<String[]> addRows = new ArrayList<String[]>();

	public ModifyWindow(MainWindow mainRef, List<Integer> idArray) {
		this.mainRef = mainRef;
		initWindow();
	}
	
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    table.setEnabled(true);
	    tableModel.addRow(new Object[0]);
	    
	    table.setFillsViewportHeight(true);
	    
        panel.setToolTipText("NII VITTU USKALLA");
	       
	    JButton nextButton = new JButton("Save");
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

	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    
	    south.add(nextButton);
	    south.add(cancelButton);

	    center.add(tableScrollPane);
	    tableModel = new BTableModel("Movie",0);
	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
