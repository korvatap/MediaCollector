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
import java.util.Iterator;
import java.util.List;

	import javax.swing.JScrollPane;
import javax.swing.JTable;


	public class PromptWindow extends JFrame{

		/**
		 * @param args
		 */
		
		private String message = " ";
		private MediaObject database;
		private List<Integer> idArray;
		private PromptWindow ref;
		private MainWindow mainRef;
		
		public PromptWindow(String text, MediaObject database, MainWindow mainRef, List<Integer> idArray) {
			this.database = database;
			this.idArray = idArray;
			this.mainRef = mainRef;
			setPromptText(text);
			initWindow();
			ref = this;
		}
		
		public PromptWindow(String text) {
			setPromptText(text);
			initWindowOK();
			ref = this;
		}
		
		
		private void setPromptText(String text) {
			this.message = text;
			
		}

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
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	}

