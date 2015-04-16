import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;


public class MainFrame {
	//the main JFrame object  
	public static JFrame frmIceCreamPos;
	//store the flavor type button's list 
	public static List<MyButton> flavorBtnList = new ArrayList<MyButton>();
	//store the decorator type button's list 
	public static List<MyButton> decoratorBtnList = new ArrayList<MyButton>();
	//show the total price text pane
	private static JTextPane txTotal;
	//contain the flavor type button's show panel
	private static JPanel flavorPanel;
	//contain the decorator type button's show panel
	private static JPanel decoratorPanel;
	/**
	 * the main method start the application.
	 */
	public static void main(String[] args) {
		initialize();//initialize the GUI frame
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		//---------------------------------show the main GUI frame 
		frmIceCreamPos = new JFrame();
		frmIceCreamPos.setTitle("Ice Cream Pos");
		frmIceCreamPos.setBounds(100, 100, 585, 478);
		frmIceCreamPos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIceCreamPos.getContentPane().setLayout(null);
		
		
		//---------------------------------show FLAVOR button
		JLabel lblflavor = new JLabel("ICE-CREAM FLAVOR");
		lblflavor.setFont(new Font("Arial", Font.BOLD, 14));
		lblflavor.setBounds(11, 20, 174, 22);
		frmIceCreamPos.getContentPane().add(lblflavor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 549, 59);
		frmIceCreamPos.getContentPane().add(scrollPane);
		
		flavorPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) flavorPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setAlignOnBaseline(true);
		scrollPane.setViewportView(flavorPanel);
		//add two default flavor type button
		addButton(flavorPanel,flavorBtnList,false,"Chocolate",20);
		addButton(flavorPanel,flavorBtnList,false,"Vanilla",20);
		
		//---------------------------------show Decorator button
		JLabel lblDecorator = new JLabel("Decorator");
		lblDecorator.setFont(new Font("Arial", Font.BOLD, 14));
		lblDecorator.setBounds(11, 124, 174, 22);
		frmIceCreamPos.getContentPane().add(lblDecorator);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 145, 547, 59);
		frmIceCreamPos.getContentPane().add(scrollPane1);
		
		decoratorPanel = new JPanel();
		scrollPane1.setViewportView(decoratorPanel);
		FlowLayout fl_decoratorPanel = (FlowLayout) decoratorPanel.getLayout();
		fl_decoratorPanel.setAlignment(FlowLayout.LEFT);
		//add two default decorator type  button
		addButton(decoratorPanel,decoratorBtnList,true,"M&M",5);
		addButton(decoratorPanel,decoratorBtnList,true,"Strawberry",4);
		
		
		//---------------------------------show total price
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
		lblTotal.setBounds(11, 224, 50, 22);
		frmIceCreamPos.getContentPane().add(lblTotal);
		
		txTotal = new JTextPane();
		txTotal.setBackground(Color.LIGHT_GRAY);
		txTotal.setEditable(false);
		txTotal.setBounds(59, 225, 126, 21);
		frmIceCreamPos.getContentPane().add(txTotal);
		
		//----------------------------------------New IceCream button
		JButton btnNewIcecream = new JButton("New IceCream");
		//add mouse listener of the button
		btnNewIcecream.addMouseListener(new MouseAdapter() {
			/**
			 * override the mouse clicked event
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				//Remove all select options of buttons
				for(MyButton btn : flavorBtnList){
					 if(btn.selected){
						 btn.setSeleteStatus(false);
					 }
				 }
				for(MyButton btn : decoratorBtnList){
					btn.setSeleteStatus(false);
				 }
				//refresh the total price
				refreshTotal();
			}
		});
		btnNewIcecream.setBounds(438, 10, 121, 23);
		frmIceCreamPos.getContentPane().add(btnNewIcecream);
		
		//---------------------------------------System Administrator button
		JButton btnSystem = new JButton("System Administrator");
		//add mouse listener of the button
		btnSystem.addMouseListener(new MouseAdapter() {
			/**
			 * override the mouse clicked event
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddDialog();//show a new dialog to add new button
			}
		});
		btnSystem.setBounds(11, 286, 174, 23);
		frmIceCreamPos.getContentPane().add(btnSystem);
		
		frmIceCreamPos.setVisible(true);
	}
	
	/**
	 * add a new button and show in the frame
	 * @param panel which panel to show the new button
	 * @param btnList store the new button in this button list
	 * @param multipleChoice this button whether is multiple choice button group
	 * 			the flavor buttons is single choice,and the decorator buttons is multiple choice
	 * @param name the button name
	 * @param price the price
	 */
	private static void  addButton(JPanel panel, List<MyButton> btnList, boolean multipleChoice,
			String name, int price){
		MyButton button = new MyButton(name,price,multipleChoice);
		panel.add(button);
		btnList.add(button);
		panel.updateUI();//update the UI
	}
	
	/**
	 * add a new button by dialog
	 * @param name 
	 * @param price 
	 * @param type flavor/decorator type button
	 */
	public static void addButtonByDialog(String name, int price,String type){
		if(type.equals("flavor")){
			addButton(flavorPanel, flavorBtnList, false, name, price);
		}
		else{
			addButton(decoratorPanel, decoratorBtnList, true, name, price);
		}
	}
	
	/**
	 * refresh the total price
	 */
	public static int refreshTotal() {
		int total = 0;
		for(MyButton btn : flavorBtnList){
			 if(btn.selected){
				 total += btn.price;
			 }
		 }
		for(MyButton btn : decoratorBtnList){
			 if(btn.selected){
				 total += btn.price;
			 }
		 }
		txTotal.setText("$" + total);
		return total;
	}
}

/**
 * MyButton class is extend javax.swing.JButton 
 * 
 */
class MyButton extends JButton{

	public boolean multipleChoice = false;
	public boolean selected = false;
	private JButton that ;
	public int price;
	public String name;
	MyButton(String name, int price, boolean multipleChoice_){
		super(name + " $" + price);
		that = this;
		this.price = price;
		this.name = name;
		this.multipleChoice = multipleChoice_;
		this.setBackground(new Color(255,255,255));
		//set the mouse listen
		this.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				//if the button group is not multiple choice(single choice),set this group other button not selected
				if(!multipleChoice){
					 List<MyButton> flavorBtnList = MainFrame.flavorBtnList;
					 for(MyButton btn : flavorBtnList){
						 if(btn != that)
							 btn.setSeleteStatus(false);
					 }
				}
				//changer the select status
				selected = !selected;
				setSeleteStatus(selected);
				
				//refresh the total price
				MainFrame.refreshTotal();
			}
		});
	}
	
	/**
	 * set this button select status
	 * @param selete
	 */
	protected void setSeleteStatus(boolean select){
		selected = select;
		Color  color = new Color(255,255,255);
		if(select){
			color = new Color(108,183,238);
		}
		that.setBackground(color );
	}
	
	
	
}
