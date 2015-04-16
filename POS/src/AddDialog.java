import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * AddDialog class extend javax.swing.JDialog.
 * It used to show a add new button dialog 
 *
 */
public class AddDialog extends JDialog {
	//the main content panel
	private final JPanel contentPanel = new JPanel();
	//the name text field 
	private JTextField tfName;
	//the price text field 
	private JTextField tfPrice;
	//the combobox the select witch type of button.(flavor / decorator)
	private JComboBox<String> comboBox;
	
	/**
	 * Create the dialog.
	 */
	public AddDialog() {
		final AddDialog that = this;
		setBounds(100, 100, 360, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(58, 25, 54, 15);
		contentPanel.add(lblType);
		
		comboBox = new JComboBox<String>(new String[] {"flavor", "decorator"});
		comboBox.setBounds(122, 22, 89, 21);
		contentPanel.add(comboBox);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(58, 80, 54, 15);
		contentPanel.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(122, 77, 89, 21);
		contentPanel.add(tfName);
		tfName.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(122, 128, 89, 21);
		contentPanel.add(tfPrice);
		
		JLabel lblPrice = new JLabel("price:");
		lblPrice.setBounds(58, 131, 54, 15);
		contentPanel.add(lblPrice);
		

		//-----------------------------------show a 'OK' button
		JButton okButton = new JButton("OK");
		//add mouse listener of the button
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					//add new button
					int price = Integer.parseInt(tfPrice.getText());//get the price
					String name = tfName.getText();//get the name
					String type = comboBox.getSelectedItem().toString();//get the choice type
					MainFrame.addButtonByDialog(name, price, type);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				that.dispose();
			}
		});
		
		okButton.setBounds(100, 229, 69, 23);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
