package cross.threebodyship.userinterface;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectorUI extends JPanel implements Observer {
	
	JButton stageButton;
	JButton backButton;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectorUI() {
		// TODO Auto-generated constructor stub
		JLabel label = new JLabel("This is a Selector");
		add(label, BorderLayout.SOUTH);
		
        stageButton = new JButton("Sample Stage");
        add(BorderLayout.EAST, stageButton);
        
        backButton = new JButton("Back to Starter");
        add(BorderLayout.WEST, backButton);
	}
	
	public JButton getStageButton() {
		return stageButton;
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
