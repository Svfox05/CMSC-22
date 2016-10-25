/**
 * 
 */
package gui;

/**
 * @author User
 *
 */
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Frame extends JFrame {

	public Frame() {
		super("RockPaperScissorsLizardSpock");
		//sets the radio buttons
		JRadioButton option1 = new JRadioButton("Rock");
		JRadioButton option2 = new JRadioButton("Paper");
		JRadioButton option3 = new JRadioButton("Scissors");
		JRadioButton option4 = new JRadioButton("Lizard");
		JRadioButton option5 = new JRadioButton("Spock");
		
		ButtonGroup group = new ButtonGroup();
		group.add(option1);
		group.add(option2);
		group.add(option3);
		group.add(option4);
		group.add(option5);

		setLayout(new FlowLayout());

		//adds radio buttons
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(option5);

		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Frame().setVisible(true);
			}
		});
	}
}