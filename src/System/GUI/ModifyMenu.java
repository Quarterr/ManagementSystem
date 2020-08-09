package System.GUI;
import javax.swing.*;

import org.quartz.Scheduler;

import System.Control.TimeTrigger;
import System.Data.Menu_Reader;
import System.Data.Menu_Storer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class provide the interface that the manager can modify the menu.
 * @author Siyi Yan
 * @version 3.0
 */
public class ModifyMenu  {
	private JTextField ramenPrice;//define the textfield
	private JTextField noriPrice;
	private JTextField eggPrice;
	private JTextField bambooPrice;
	private JFrame manage;
	private JPanel jp;
	private JTextField chashuPrice;
	Boolean rava,nava,eava,bsava,cava;//define the available of each item
    
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyMenu window = new ModifyMenu();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the  modify panel.
	 */
	public ModifyMenu(TimeTrigger tt, Scheduler sched) {
		manage = new JFrame();
		jp=new JPanel();
		manage.setVisible(true);
		//frmManageYourRestaurant.getContentPane().setBackground();
		manage.setTitle("Manage your restaurant");
		manage.setBounds(100, 100, 1013, 650);
		manage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manage.getContentPane().setLayout(null);
		manage.add(jp);
		jp.setBounds(0, 0, 1000,700);
		jp.setLayout(null);
		ButtonGroup g1 = new ButtonGroup();
		ButtonGroup g2 = new ButtonGroup();
		ButtonGroup g3 = new ButtonGroup();
		ButtonGroup g4 = new ButtonGroup();
		ButtonGroup g5 = new ButtonGroup();
		JPanel panelhead = new JPanel();
		panelhead.setBounds(180, 0, 656, 81);
		jp.add(panelhead);
		panelhead.setLayout(null);
		JLabel totoral = new JLabel("Totoro Ramen");
		totoral.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		totoral.setForeground(new Color(255, 153, 0));
		totoral.setBounds(191, 13, 304, 55);
		panelhead.add(totoral);
		
		JPanel mfm = new JPanel();
		mfm.setBackground(new Color(255, 204, 153));
		mfm.setForeground(new Color(255, 204, 0));
		mfm.setBounds(0, 79, 997, 68);
		jp.add(mfm);
		mfm.setLayout(null);
		
		JLabel menu = new JLabel(">Modify menu");
		menu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		menu.setForeground(new Color(255, 153, 0));
		menu.setBounds(14, 13, 225, 42);
		mfm.add(menu);
		
		JPanel changePanel = new JPanel();  //define the change panel
		changePanel.setBackground(new Color(255, 255, 255));
		changePanel.setBounds(180, 162, 632, 382);
		jp.add(changePanel);
		changePanel.setLayout(null);
		
		JPanel panelSp1 = new JPanel();
		panelSp1.setBounds(0, 63, 632, 10);
		changePanel.add(panelSp1);
		
		JPanel panelSp2 = new JPanel();
		panelSp2.setBounds(0, 127, 632, 10);
		changePanel.add(panelSp2);
		
		JPanel panelSp3 = new JPanel();
		panelSp3.setBounds(0, 190, 632, 10);
		changePanel.add(panelSp3);
		
		JPanel panelSp4 = new JPanel();
		panelSp4.setBounds(0, 314, 632, 10);
		changePanel.add(panelSp4);
		
		JPanel panelSp5 = new JPanel();
		panelSp5.setBounds(0, 252, 632, 10);
		changePanel.add(panelSp5);
		
		JPanel panelSp6 = new JPanel();
		panelSp6.setBounds(181, 0, 10, 382);
		changePanel.add(panelSp6);
		
		JPanel panelSp7 = new JPanel();
		panelSp7.setBounds(395, 0, 10, 382);
		changePanel.add(panelSp7);
		
		JLabel item = new JLabel("Item");  //set the item that can change
		item.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		item.setBounds(10, 24, 94, 26);
		changePanel.add(item);
		
		JLabel ramen = new JLabel("Ramen");
		ramen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		ramen.setBounds(10, 86, 94, 26);
		changePanel.add(ramen);
		
		JLabel nori = new JLabel("Nori");
		nori.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		nori.setBounds(10, 150, 94, 26);
		changePanel.add(nori);
		
		JLabel egg = new JLabel("Boiled egg");
		egg.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		egg.setBounds(10, 213, 145, 36);
		changePanel.add(egg);
		
		JLabel chashu = new JLabel("Chashu");
		chashu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		chashu.setBounds(14, 333, 122, 36);
		changePanel.add(chashu);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		price.setBounds(205, 24, 72, 26);
		changePanel.add(price);
		
		JLabel bambooShoot = new JLabel("Bamboo shoot");
	    bambooShoot.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
	    bambooShoot.setBounds(10, 275, 145, 36);
	    changePanel.add(bambooShoot);
		
		JLabel ava = new JLabel("Available");
		ava.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		ava.setBounds(419, 24, 115, 26);
		changePanel.add(ava);
		
		JLabel lblNewLabel_6 = new JLabel("\uFFE1");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6.setBounds(205, 96, 26, 18);
		changePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("\uFFE1");
		lblNewLabel_6_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6_1.setBounds(205, 159, 26, 18);
		changePanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("\uFFE1");
		lblNewLabel_6_2.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6_2.setBounds(205, 213, 26, 18);
		changePanel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("\uFFE1");
		lblNewLabel_6_3.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6_3.setBounds(205, 279, 26, 18);
		changePanel.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("\uFFE1");
		lblNewLabel_6_4.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_6_4.setBounds(205, 347, 26, 18);
		changePanel.add(lblNewLabel_6_4);
		
		ramenPrice = new JTextField();
		ramenPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		ramenPrice.setText(String.valueOf(Menu_Reader.readPrice("Basic")));
		ramenPrice.setBounds(245, 90, 115, 28);
		changePanel.add(ramenPrice);
		ramenPrice.setColumns(10);
		
		noriPrice = new JTextField();
		noriPrice.setColumns(10);
		noriPrice.setText("1.0");
		noriPrice.setBounds(245, 154, 115, 28);
		noriPrice.setText(String.valueOf(Menu_Reader.readPrice("Nori")));
		noriPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		changePanel.add(noriPrice);
		
		eggPrice = new JTextField();
		eggPrice.setText("1.0");
		eggPrice.setText(String.valueOf(Menu_Reader.readPrice("Egg")));
		eggPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		eggPrice.setColumns(10);
		eggPrice.setBounds(245, 213, 115, 28);
		changePanel.add(eggPrice);
		
		bambooPrice = new JTextField();
		bambooPrice.setColumns(10);
		bambooPrice.setText("1.0");
		bambooPrice.setText(String.valueOf(Menu_Reader.readPrice("Bamboo Shoots")));
		bambooPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		bambooPrice.setBounds(245, 275, 115, 28);
		changePanel.add(bambooPrice);
		
		chashuPrice = new JTextField();
		chashuPrice.setText("2.0");
		chashuPrice.setText(String.valueOf(Menu_Reader.readPrice("Chashu")));
		chashuPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		chashuPrice.setColumns(10);
		chashuPrice.setBounds(245, 344, 115, 28);
		changePanel.add(chashuPrice);
		
		JRadioButton ramenYes = new JRadioButton("Yes");
		ramenYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rava=true;
			}
		});
		ramenYes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		ramenYes.setBackground(Color.WHITE);
		ramenYes.setBounds(415, 91, 83, 27);
		if(Menu_Reader.readAvailable("Basic")==true) {
			ramenYes.setSelected(true);  //get the information from file
			rava=true;
		}
		changePanel.add(ramenYes);
		
		JRadioButton noriYes = new JRadioButton("Yes");
		noriYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nava=true;    //set user choice
			}
		});
		noriYes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		noriYes.setBackground(Color.WHITE);
		if(Menu_Reader.readAvailable("Nori")==true) {
			noriYes.setSelected(true);
			nava=true;
		}
		noriYes.setBounds(415, 154, 83, 27);
		changePanel.add(noriYes);
		
		JRadioButton eggYes = new JRadioButton("Yes");
		eggYes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		eggYes.setBackground(Color.WHITE);
		eggYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eava=true;
			}
		});
		if(Menu_Reader.readAvailable("Egg")==true) {
			eggYes.setSelected(true);
			eava=true;
		}
		eggYes.setBounds(415, 216, 83, 27);
		changePanel.add(eggYes);
		
		JRadioButton bambooYes = new JRadioButton("Yes");
		bambooYes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		bambooYes.setBackground(Color.WHITE);
		bambooYes.setBounds(415, 278, 83, 27);
		if(Menu_Reader.readAvailable("Bamboo Shoots")==true) {
			bambooYes.setSelected(true);
			bsava=true;
		}
		bambooYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsava=true;
			}
		});
		changePanel.add(bambooYes);
		
		JRadioButton chashuYes = new JRadioButton("Yes");
		chashuYes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		chashuYes.setBackground(Color.WHITE);
		chashuYes.setBounds(415, 343, 83, 27);
		if(Menu_Reader.readAvailable("Chashu")==true) {
			chashuYes.setSelected(true);
			cava=true;
		}
		chashuYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cava=true;
			}
		});
		changePanel.add(chashuYes);
		/*
		JRadioButton ramenNo = new JRadioButton("No");
		ramenNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		ramenNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rava=false;
			}
		});
		
		ramenNo.setBackground(Color.WHITE);
		if(manager.getAvailable("Basic")==false) {
			ramenNo.setSelected(true);
			rava=false;
		}*
		ramenNo.setBounds(539, 91, 83, 27);
		changePanel.add(ramenNo);
		*/
		JRadioButton noriNo = new JRadioButton("No");
		noriNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		noriNo.setBackground(Color.WHITE);
		if(Menu_Reader.readAvailable("Nori")==false) {
			noriNo.setSelected(true);
			nava=false;
		}
		noriNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nava=false;
			}
		});
		noriNo.setBounds(539, 154, 83, 27);
		changePanel.add(noriNo);
		
		JRadioButton eggNo = new JRadioButton("No");
		eggNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		eggNo.setBackground(Color.WHITE);
		if(Menu_Reader.readAvailable("Egg")==false) {
			eggNo.setSelected(true);
			eava=false;
		}
		eggNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eava=false;
			}
		});
		eggNo.setBounds(539, 216, 83, 27);
		changePanel.add(eggNo);
		
		JRadioButton bambooNo = new JRadioButton("No");
		bambooNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		bambooNo.setBackground(Color.WHITE);
		if(Menu_Reader.readAvailable("Bamboo Shoots")==false) {
			bambooNo.setSelected(true);
			bsava=false;
		}
		bambooNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bsava=false;
			}
		});
		bambooNo.setBounds(539, 278, 83, 27);
		changePanel.add(bambooNo);
		
		JRadioButton chashuNo = new JRadioButton("No");
		chashuNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		chashuNo.setBackground(Color.WHITE);
		if(Menu_Reader.readAvailable("Chashu")==false) {
			chashuNo.setSelected(true);
			cava=false;
		}
		chashuNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cava=false;
			}
		});
		chashuNo.setBounds(539, 343, 83, 27);
		changePanel.add(chashuNo);
		
	//	g1.add(ramenNo);
		g1.add(ramenYes);
		g2.add(noriNo);
		g2.add(noriYes);
		g3.add(eggYes);
		g3.add(eggNo);
		g4.add(bambooYes);
	    g4.add(bambooNo);
	    g5.add(chashuNo);
	    g5.add(chashuYes);
	    
	    
	    
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(255, 153, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//write the change back to the file
				if(Float.parseFloat(ramenPrice.getText())>=0 && Float.parseFloat(noriPrice.getText())>=0 && Float.parseFloat(chashuPrice.getText())>=0&&Float.parseFloat(eggPrice.getText())>=0&&Float.parseFloat(bambooPrice.getText())>=0) {
				Menu_Storer.storePrice("Basic", Float.parseFloat(ramenPrice.getText()));
				Menu_Storer.storePrice("Nori", Float.parseFloat(noriPrice.getText()));
				Menu_Storer.storePrice("Chashu", Float.parseFloat(chashuPrice.getText()));
				Menu_Storer.storePrice("BoiledEgg", Float.parseFloat(eggPrice.getText()));
				Menu_Storer.storePrice("BambooShoots", Float.parseFloat(bambooPrice.getText()));
				Menu_Storer.storeAvailable("Basic", rava);
				Menu_Storer.storeAvailable("Nori", nava);
				Menu_Storer.storeAvailable("Chashu", cava);
				Menu_Storer.storeAvailable("BambooShoots", bsava);
				Menu_Storer.storeAvailable("BoiledEgg", eava);
				ModifySuccess frame = new ModifySuccess();
				frame.setVisible(true);
				//manage.setVisible(false);
				}
				else {
					PriceWrong window=new PriceWrong();
					//manage.setVisible(false);
				}
				/*
				setVisible(false);
				jf=(JFrame)getRootPane().getParent();
				jp=new ChoicePanel();
				jp.setBounds(0, 0, 1000,700);
				jf.getContentPane().add(jp);
				*/
			}
		});
		btnNewButton.setBounds(831, 499, 152, 45);
		jp.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 153, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoicePanel window = new ChoicePanel(tt,sched);
				manage.setVisible(false);
				/*
				setVisible(false);
				jf=(JFrame)getRootPane().getParent(); //back to the choice panel
				jp=new ChoicePanel();
				jp.setBounds(0, 0, 1000,700);
				jf.getContentPane().add(jp);
				
			//	Mangement m = new Mangement();
				*/
			}
		});
		btnBack.setBounds(14, 499, 152, 45);
		jp.add(btnBack);

	}
}
