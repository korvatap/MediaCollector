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

	import javax.swing.JScrollPane;
import javax.swing.JTable;


	public class PromptWindow extends JFrame{

		/**
		 * @param args
		 */
		
		private String message = " ";
		
		public PromptWindow(String text) {
			setPromptText(text);
			initWindow();
		}
		
		
		private void setPromptText(String text) {
			this.message = text;
			
		}


		public final void initWindow() {
		    JPanel panel = new JPanel();
		    getContentPane().add(panel);
		    panel.setLayout(new BorderLayout());
		    
	        panel.setToolTipText("NII VITTU USKALLA");
		    
	        JLabel messageJlb = new JLabel(message,JLabel.CENTER); 

		   
		    JButton confirmButton = new JButton("Kyllä");
		    confirmButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		//System.exit(0);
		    	}
		    });
		       
		    JButton cancelButton = new JButton("Ei");
		    cancelButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		//System.exit(0);
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

