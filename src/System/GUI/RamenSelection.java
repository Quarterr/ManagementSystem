package System.GUI;

import java.util.List; 

import java.awt.EventQueue;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import System.Data.Menu_Reader;
import System.Entity.Entity_Ticket;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * This class is the interface for users to select the Ramen.
 * @author Siyi Yan
 * @version 3.0
 */
public class RamenSelection {

	private JFrame frmWelcomeToRamen;
    private Entity_Ticket ramenTicket = new Entity_Ticket();
    private Menu_Reader menuc=new Menu_Reader();
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;
    private int counter4 = 0;
    private int choose1=0;
    private int choose2=0;
    private int choose3=0;
    private int choose4=0;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RamenSelection window = new RamenSelection();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * The constructor of the application.
	 */
	public RamenSelection() {
		initialize();
	}
	/**
	 * Initialization.
	 * @param t
	 */
	public RamenSelection(Entity_Ticket t) {
		choose1=1;choose2=1;choose3=1;choose4=1;
		frmWelcomeToRamen = new JFrame();
		frmWelcomeToRamen.setVisible(true);
		frmWelcomeToRamen.setTitle("Welcome to Ramen Restaurant!");
		frmWelcomeToRamen.setBounds(0, 0, 663, 766);
		frmWelcomeToRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToRamen.getContentPane().setLayout(null);
		
		JLabel noirNum,price;
		JPanel panelHead = new JPanel();  
		panelHead.setBounds(0, 0, 605, 61);
		frmWelcomeToRamen.getContentPane().add(panelHead);
		panelHead.setLayout(null);
		
		JLabel totalRamen = new JLabel("Totoro Ramen");
		totalRamen.setForeground(new Color(255, 153, 0));
		totalRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		totalRamen.setBounds(51, 0, 269, 53);
		panelHead.add(totalRamen);
		
		JLabel enjoy = new JLabel("enjoy it now!");
		enjoy.setForeground(new Color(255, 153, 0));
		enjoy.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		enjoy.setBounds(382, 23, 146, 38);
		panelHead.add(enjoy);
		
		JPanel panelChoice = new JPanel(); //essential choice panel
		panelChoice.setBounds(0, 61, 643, 455);
		panelChoice.setBackground(new Color(255, 255, 255));
		panelChoice.setForeground(new Color(255, 255, 255));
		frmWelcomeToRamen.getContentPane().add(panelChoice);
		panelChoice.setLayout(null);
		
		JLabel essPrice = new JLabel("essential selection-\uFFE19.9");
		essPrice.setText("essential selection-\uFFE1"+String.valueOf(Menu_Reader.readPrice("Basic")));
		essPrice.setBounds(14, 13, 337, 34);
		essPrice.setForeground(new Color(255, 153, 0));
		essPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
		panelChoice.add(essPrice);
		
		JPanel panelSoup = new JPanel(); //soup panel
		panelSoup.setBounds(14, 60, 282, 99);
		panelSoup.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelSoup);
		panelSoup.setLayout(null);
		
		JPanel panelSoup1 = new JPanel();  
		panelSoup1.setBounds(14, 8, 254, 82);
		panelSoup.add(panelSoup1);
		panelSoup1.setLayout(null);
		
		JPanel panelSp = new JPanel();
		panelSp.setBackground(new Color(255, 153, 0));
		panelSp.setForeground(new Color(255, 153, 0));
		panelSp.setBounds(78, 0, 10, 82);
		panelSoup1.add(panelSp);
		
		ButtonGroup soupGroup=new ButtonGroup();
		JRadioButton tonkostu = new JRadioButton("Tonkotsu");
		tonkostu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("soup", "Tonkotsu"); //set the user's choice
			}
		});
		tonkostu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		tonkostu.setBounds(97, 0, 157, 27);
		panelSoup1.add(tonkostu);
		
		JRadioButton shio = new JRadioButton("Shio");
		shio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("soup", "Shio");   //set the user's choice
			}
		});
		shio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		shio.setBounds(97, 55, 157, 27);
		panelSoup1.add(shio);
		
		JRadioButton shoyu = new JRadioButton("Shoyu");
		shoyu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t.setBasicPart1("soup", "Shoyu");   //set the user's choice
			}
		});
		shoyu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		shoyu.setBounds(97, 24, 157, 35);
		panelSoup1.add(shoyu);
		
		soupGroup.add(shoyu);
		soupGroup.add(shio);
		soupGroup.add(tonkostu);
		
		if(t.getBasicPart1("soup")=="Shoyu") {
			shoyu.setSelected(true);
		}
		else if(t.getBasicPart1("soup")=="Shio") {
			shio.setSelected(true);
		}
		else {
			tonkostu.setSelected(true);
		}
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/Picture/soup.jpg"));
		lblNewLabel_3.setBounds(0, 0, 88, 82);
		panelSoup1.add(lblNewLabel_3);
		
		ButtonGroup noodleGroup=new ButtonGroup();
		
		JPanel panelNoodel = new JPanel();  //noodles choice panel
		panelNoodel.setBounds(14, 169, 282, 99);
		panelNoodel.setLayout(null);
		panelNoodel.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelNoodel);
		
		JPanel panelNoodel1 = new JPanel();
		panelNoodel1.setLayout(null);
		panelNoodel1.setBounds(14, 8, 254, 82);
		panelNoodel.add(panelNoodel1);
		
		JPanel panelSp_1 = new JPanel();
		panelSp_1.setForeground(new Color(255, 153, 0));
		panelSp_1.setBackground(new Color(255, 153, 0));
		panelSp_1.setBounds(78, 0, 10, 82);
		panelNoodel1.add(panelSp_1);
		
		JRadioButton soft = new JRadioButton("Soft");
		soft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("noodle", "Soft");  //set the user's choice
			}
		});
		soft.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		soft.setBounds(97, 0, 157, 27);
		panelNoodel1.add(soft);
		
		JRadioButton firm = new JRadioButton("Firm");
		firm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("noodle", "Firm");  //set the user's choice
			}
		});
		firm.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		firm.setBounds(97, 55, 157, 27);
		panelNoodel1.add(firm);
		
		JRadioButton medium = new JRadioButton("Medium");
		medium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("noodle", "Medium");  ////set the user's choice
			}
		});
		medium.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		medium.setBounds(97, 24, 157, 35);
		panelNoodel1.add(medium);
		
		noodleGroup.add(medium);
		noodleGroup.add(firm);
		noodleGroup.add(soft);
		
		if(t.getBasicPart1("noodle")=="Medium") {
			medium.setSelected(true);
		}
		else if(t.getBasicPart1("noodle")=="Firm") {
			firm.setSelected(true);
		}
		else {
			soft.setSelected(true);
		}
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/Picture/noodle.jpg"));
		lblNewLabel_2.setBounds(-60, 0, 140, 82);
		panelNoodel1.add(lblNewLabel_2);
	
		
		ButtonGroup onionGroup=new ButtonGroup();
		
		JPanel panelOnion = new JPanel();  //onion panel
		panelOnion.setBounds(14, 283, 282, 99);
		panelOnion.setLayout(null);
		panelOnion.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelOnion);
		
		JPanel panelOnion1 = new JPanel();
		panelOnion1.setLayout(null);
		panelOnion1.setBounds(14, 8, 254, 82);
		panelOnion.add(panelOnion1);
		
		JPanel panelSp_1_1 = new JPanel();
		panelSp_1_1.setForeground(new Color(255, 153, 0));
		panelSp_1_1.setBackground(new Color(255, 153, 0));
		panelSp_1_1.setBounds(78, 0, 10, 82);
		panelOnion1.add(panelSp_1_1);
		
		JRadioButton no = new JRadioButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("springOnion", "No");  //set the user's choice
			}
		});
		no.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		no.setBounds(97, 0, 157, 27);
		panelOnion1.add(no);
		
		JRadioButton lot = new JRadioButton("Lot");
		lot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("springOnion", "Lot");  //set the user's choice
			}
		});
		lot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lot.setBounds(97, 55, 157, 27);
		panelOnion1.add(lot);
		
		JRadioButton little = new JRadioButton("Little");
		little.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setBasicPart1("springOnion", "Little");  //set the user's choice
			}
		});
		little.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		little.setBounds(97, 24, 157, 35);
		panelOnion1.add(little);
		
		if(t.getBasicPart1("springOnion")=="Lot") {
			lot.setSelected(true);
		}
		else if(t.getBasicPart1("springOnion")=="No") {
			no.setSelected(true);
		}
		else {
			little.setSelected(true);
		}
		onionGroup.add(little);
		onionGroup.add(lot);
		onionGroup.add(no);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/Picture/SpringOnion.jpg"));
		lblNewLabel_4.setBounds(-100, 0, 180, 82);
		panelOnion1.add(lblNewLabel_4);
		
		
		JPanel panelNori= new JPanel();   //nori panel
		panelNori.setBackground(new Color(255, 153, 0));
		panelNori.setBounds(420, 29, 149, 85);
		panelChoice.add(panelNori);
		panelNori.setLayout(null);
		
		JPanel panelNori_1 = new JPanel();
		panelNori_1.setBounds(14, 8, 120, 70);
		panelNori.add(panelNori_1);
		panelNori_1.setLayout(null);
		
		JLabel nori = new JLabel("Nori");
		nori.setHorizontalAlignment(SwingConstants.CENTER);
		nori.setBounds(0, 2, 120, 28);
		nori.setForeground(new Color(255, 153, 0));
		nori.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		panelNori_1.add(nori);
		
		ButtonGroup noriGroup = new ButtonGroup();
		JButton have = new JButton(String.valueOf((char)8730));
		
		have.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have.setBounds(0, 43, 61, 27);
		panelNori_1.add(have);
		
		JButton don = new JButton(String.valueOf((char)215));
		if(Menu_Reader.readAvailable("Nori")==false) {
			nori.setText("sold out");
			don.setForeground(Color.RED);
			have.setForeground(Color.BLACK);
			t.setBasicPart2("nori", false);
			nori.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		don.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don.setBounds(59, 43, 61, 27);
		panelNori_1.add(don);
		if(t.getBasicPart2("nori")==true) {
			have.setForeground(Color.RED);
			don.setForeground(Color.BLACK);
		}
		else {
			don.setForeground(Color.RED);
			have.setForeground(Color.BLACK);
		}
		
		JPanel panelChasu = new JPanel();   //chashu panel
		panelChasu.setLayout(null);
		panelChasu.setBackground(new Color(255, 153, 0));
		panelChasu.setBounds(420, 138, 149, 85);
		panelChoice.add(panelChasu);
		
		JPanel panelChasu1 = new JPanel();
		panelChasu1.setLayout(null);
		panelChasu1.setBounds(14, 8, 120, 70);
		panelChasu.add(panelChasu1);
		
		JLabel lblChashu = new JLabel("Chashu");
		lblChashu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChashu.setForeground(new Color(255, 153, 0));
		lblChashu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblChashu.setBounds(0, 5, 120, 28);
		panelChasu1.add(lblChashu);
		
		JButton have_1 = new JButton(String.valueOf((char)8730));
		have_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have_1.setBounds(0, 43, 61, 27);
		panelChasu1.add(have_1);
		
		JButton don_1 = new JButton(String.valueOf((char)215));
		don_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don_1.setBounds(59, 43, 61, 27);
		panelChasu1.add(don_1);
		if(Menu_Reader.readAvailable("Chashu")==false) {
			lblChashu.setText("sold out");
			don_1.setForeground(Color.RED);
			have_1.setForeground(Color.BLACK);
			t.setBasicPart2("nori", false);
			lblChashu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		
		
		have_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Chashu")==true) {
				have_1.setForeground(Color.RED);
				t.setBasicPart2("chashu", true);
				choose2++;
				don_1.setForeground(Color.BLACK);}
			}
		});
		don_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_1.setForeground(Color.RED);
				t.setBasicPart2("chashu", false);
				choose2++;
				have_1.setForeground(Color.BLACK);
			}
		});
		
		if(t.getBasicPart2("chashu")==true) {
			have_1.setForeground(Color.RED);
			don_1.setForeground(Color.BLACK);
		}
		if(t.getBasicPart2("chashu")==false) {
			don_1.setForeground(Color.RED);
			have_1.setForeground(Color.BLACK);
		}
		
		JPanel panelEgg = new JPanel();  //egg panel
		panelEgg.setLayout(null);
		panelEgg.setBackground(new Color(255, 153, 0));
		panelEgg.setBounds(420, 247, 149, 85);
		panelChoice.add(panelEgg);
		
		JPanel panelEgg1 = new JPanel();
		panelEgg1.setLayout(null);
		panelEgg1.setBounds(14, 8, 120, 70);
		panelEgg.add(panelEgg1);
		
		JLabel lblBoiledEgg = new JLabel("Boiled egg");
		lblBoiledEgg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoiledEgg.setForeground(new Color(255, 153, 0));
		lblBoiledEgg.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblBoiledEgg.setBounds(0, 5, 120, 28);
		panelEgg1.add(lblBoiledEgg);
		
		JButton have_2 = new JButton(String.valueOf((char)8730));
		have_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have_2.setBounds(0, 43, 61, 27);
		panelEgg1.add(have_2);
		
		JButton don_2 = new JButton(String.valueOf((char)215));
		don_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don_2.setBounds(59, 43, 61, 27);
		panelEgg1.add(don_2);
		if(menuc.readAvailable("Egg")==false) {
			lblBoiledEgg.setText("sold out");
			don_2.setForeground(Color.RED);
			have_2.setForeground(Color.BLACK);
			t.setBasicPart2("egg", false);
			lblBoiledEgg.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		have_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Egg")==true) {
				have_2.setForeground(Color.RED);
				choose3++;
				t.setBasicPart2("egg", true);
				don_2.setForeground(Color.BLACK);}
			}
		});
		don_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_2.setForeground(Color.RED);
				choose3++;
				t.setBasicPart2("egg", false);
				have_2.setForeground(Color.BLACK);
			}
		});
		if(t.getBasicPart2("egg")==true) {
			have_2.setForeground(Color.RED);
			don_2.setForeground(Color.BLACK);
		}
		else {
			don_2.setForeground(Color.RED);
			have_2.setForeground(Color.BLACK);
		}
		
		JPanel panelHot = new JPanel();  //spicy panel
		panelHot.setBackground(new Color(255, 0, 51));
		panelHot.setBounds(64, 386, 505, 63);
		panelChoice.add(panelHot);
		panelHot.setLayout(null);
		
		JPanel panelHot_1 = new JPanel();
		panelHot_1.setBounds(14, 8, 476, 44);
		panelHot.add(panelHot_1);
		panelHot_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 51));
		panel_3.setBounds(72, 0, 10, 44);
		panelHot_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 0, 51));
		panel_3_1.setBounds(151, 0, 10, 44);
		panelHot_1.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(255, 0, 51));
		panel_3_2.setBounds(233, 0, 10, 44);
		panelHot_1.add(panel_3_2);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(255, 0, 51));
		panel_3_3.setBounds(315, 0, 10, 44);
		panelHot_1.add(panel_3_3);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBackground(new Color(255, 0, 51));
		panel_3_4.setBounds(397, 0, 10, 44);
		panelHot_1.add(panel_3_4);
		
		JPanel panelPay1 = new JPanel();  //pay panel
		panelPay1.setBounds(0, 649, 627, 71);
		frmWelcomeToRamen.getContentPane().add(panelPay1);
		panelPay1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uFFE1");  
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(14, 16, 49, 40);
		panelPay1.add(lblNewLabel_1);
		t.totalPriceCalculate();
		price = new JLabel(String.valueOf(t.getTotalPrice()));  //cost of ramen
	//	 price.setText(String.valueOf(t.getTotalPrice()));
	//	price.setText(String.valueOf(menuc.getPrice("Basic")));
		price.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		price.setBounds(71, 11, 84, 52);
		panelPay1.add(price);
		
		JButton spiciness_0 = new JButton("0");
		spiciness_0.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_0.setBounds(0, 0, 73, 44);
		panelHot_1.add(spiciness_0);
		
		JButton spiciness_1 = new JButton("1");
		spiciness_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_1.setBounds(82, 0, 73, 44);
		panelHot_1.add(spiciness_1);
		
		JButton spiciness_2 = new JButton("2");
		spiciness_2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_2.setBounds(161, 0, 75, 44);
		panelHot_1.add(spiciness_2);
		
		JButton spiciness_3 = new JButton("3");
		spiciness_3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_3.setBounds(242, 0, 75, 44);
		panelHot_1.add(spiciness_3);
		
		JButton spiciness_4 = new JButton("4");
		spiciness_4.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_4.setBounds(324, 0, 75, 44);
		panelHot_1.add(spiciness_4);
		
		JButton spiciness_5 = new JButton("5");
		spiciness_5.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_5.setBounds(404, 0, 75, 44);
		panelHot_1.add(spiciness_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 51));
		panel_2.setBounds(430, 345, 139, 43);
		panelChoice.add(panel_2);
		
		JLabel spiciness = new JLabel("Spiciness");
		spiciness.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		spiciness.setForeground(new Color(255, 255, 255));
		panel_2.add(spiciness);
		

		JPanel panelPay = new JPanel();   //add-one panel
		
		JScrollPane pan=new JScrollPane(panelPay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPay.setBackground(new Color(240, 240, 240));
		pan.setBounds(0, 519, 643, 135);
		panelPay.setBounds(0, 1519, 643, 150);
		frmWelcomeToRamen.getContentPane().add(pan);
		panelPay.setLayout(null);
		
		
		JPanel panelAddegg = new JPanel();  //add egg panel
		panelAddegg.setLayout(null);
		panelAddegg.setBackground(new Color(255, 204, 102));
		panelAddegg.setBounds(14, 42, 144, 89);
		panelPay.add(panelAddegg);
		
		JPanel panelAddegg1 = new JPanel();
		panelAddegg1.setBounds(14, 8, 116, 35);
		panelAddegg.add(panelAddegg1);
		
		JLabel eggtext = new JLabel("Egg");
		eggtext.setForeground(new Color(102, 204, 255));
		eggtext.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelAddegg1.add(eggtext);
		
		JLabel eggPrice = new JLabel("\uFFE1");
		eggPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Egg")));
		eggPrice.setForeground(new Color(255, 102, 0));
		eggPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		eggPrice.setBounds(0, 58, 31, 18);
		panelAddegg.add(eggPrice);
		
		JButton eggPlus = new JButton("+");
		eggPlus.setHorizontalAlignment(SwingConstants.LEFT);
		eggPlus.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		eggPlus.setBounds(94, 56, 41, 27);
		panelAddegg.add(eggPlus);
		
		JButton eggMin = new JButton("-");
		eggMin.setVerticalAlignment(SwingConstants.TOP);
		eggMin.setHorizontalAlignment(SwingConstants.LEFT);
		eggMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		eggMin.setBounds(34, 56, 41, 27);
		panelAddegg.add(eggMin);
		
		JLabel eggNum = new JLabel(String.valueOf(t.getAddOnPart("eggNo")));
		eggNum.setForeground(new Color(255, 102, 0));
		eggNum.setBounds(79, 61, 20, 16);
		panelAddegg.add(eggNum);
		
		eggPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getBasicPart2("egg")==false) {
					AddMore window = new AddMore();//check whether user choose egg
				}
				else {
				counter1++;
				t.setAddOnPart("eggNo", counter1);
				eggNum.setText((String.valueOf(counter1)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));
				}
			}
		});
		eggMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter1>=1) {
					counter1--;
					t.setAddOnPart("eggNo", counter1);
					eggNum.setText((String.valueOf(counter1)));
					t.totalPriceCalculate();
					price.setText(String.valueOf(t.getTotalPrice()));
				}
			}
		});
		if(Menu_Reader.readAvailable("Egg")==false) {
			eggtext.setText("sold out");
			eggtext.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			eggPrice.setVisible(false);
			eggPlus.setVisible(false);
			eggMin.setVisible(false);
			eggNum.setVisible(false);
			counter1=0;
		}
		
		JPanel panelAddbamboo = new JPanel();  //add bamboo panel
		panelAddbamboo.setLayout(null);
		panelAddbamboo.setBackground(new Color(255, 204, 102));
		panelAddbamboo.setBounds(172, 42, 144, 89);
		panelPay.add(panelAddbamboo);
		
		JPanel panelAddbamboo1 = new JPanel();
		panelAddbamboo1.setBounds(14, 8, 116, 35);
		panelAddbamboo.add(panelAddbamboo1);
		
		JLabel bambooShoot = new JLabel("Bamboo Shoots");
		bambooShoot.setForeground(new Color(102, 204, 255));
		bambooShoot.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		panelAddbamboo1.add(bambooShoot);
		
		JLabel bambooPrice = new JLabel("\uFFE1");
		bambooPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Bamboo Shoots")));
		bambooPrice.setForeground(new Color(255, 102, 0));
		bambooPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		bambooPrice.setBounds(0, 58, 31, 18);
		panelAddbamboo.add(bambooPrice);
		
		JButton bambooAdd = new JButton("+");
		bambooAdd.setHorizontalAlignment(SwingConstants.LEFT);
		bambooAdd.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		bambooAdd.setBounds(94, 56, 41, 27);
		panelAddbamboo.add(bambooAdd);
		
		JButton bambooMin = new JButton("-");
		
		bambooMin.setVerticalAlignment(SwingConstants.TOP);
		bambooMin.setHorizontalAlignment(SwingConstants.LEFT);
		bambooMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		bambooMin.setBounds(34, 56, 41, 27);
		panelAddbamboo.add(bambooMin);
		
		JLabel bambooNum = new JLabel(String.valueOf(t.getAddOnPart("bambooNo")));
		 bambooNum.setForeground(new Color(255, 102, 0));
		 bambooNum.setBounds(79, 61, 20, 16);
		panelAddbamboo.add( bambooNum);
		
		bambooMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter2>=1) {
				counter2--;
				t.setAddOnPart("bambooNo", counter2);
				bambooNum.setText((String.valueOf(counter2)));		
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));
			}
			}
		});
		bambooAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter2++;
				t.setAddOnPart("bambooNo", counter2);
				bambooNum.setText((String.valueOf(counter2)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));
			}
		});
		if(Menu_Reader.readAvailable("Bamboo Shoots")==false) {
			bambooShoot.setText("sold out");
			bambooShoot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			bambooPrice.setVisible(false);
			bambooAdd.setVisible(false);
			bambooMin.setVisible(false);
			bambooNum.setVisible(false);
			counter2=0;
		}
		
		JPanel panelMorenori = new JPanel();  //add nori panel
		panelMorenori.setLayout(null);
		panelMorenori.setBackground(new Color(255, 204, 102));
		panelMorenori.setBounds(330, 42, 144, 89);
		panelPay.add(panelMorenori);
		
		JPanel panelMorenori1 = new JPanel();
		panelMorenori1.setBounds(14, 8, 116, 35);
		panelMorenori.add(panelMorenori1);
		
		JLabel noriMore = new JLabel("Nori");
		noriMore.setForeground(new Color(102, 204, 255));
		noriMore.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelMorenori1.add(noriMore);
		JLabel noriPrice = new JLabel("\uFFE1");
		noriPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Nori")));
		noriPrice.setForeground(new Color(255, 102, 0));
		noriPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		noriPrice.setBounds(0, 58, 31, 18);
		panelMorenori.add(noriPrice);
		
		JButton noriAdd = new JButton("+");
		noriAdd.setHorizontalAlignment(SwingConstants.LEFT);
		noriAdd.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		noriAdd.setBounds(94, 56, 41, 27);
		panelMorenori.add(noriAdd);
		
		JButton noriMin = new JButton("-");
		noriMin.setVerticalAlignment(SwingConstants.TOP);
		noriMin.setHorizontalAlignment(SwingConstants.LEFT);
		noriMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		noriMin.setBounds(34, 56, 41, 27);
		panelMorenori.add(noriMin);
		
		noirNum = new JLabel(String.valueOf(t.getAddOnPart("noriNo")));
		noirNum.setForeground(new Color(255, 102, 0));
		noirNum.setBounds(79, 61, 20, 16);
		panelMorenori.add(noirNum);
		if(Menu_Reader.readAvailable("Nori")==false) {
			noriMore.setText("sold out");
			noriMore.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			noriPrice.setVisible(false);
			noriAdd.setVisible(false);
			noriMin.setVisible(false);
			noirNum.setVisible(false);
			counter3=0;
		}
		noriMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter3>=1) {
				counter3--;
				t.setAddOnPart("noriNo", counter3);
				noirNum.setText((String.valueOf(counter3)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));
			}
			}
		});
		noriAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getBasicPart2("nori")==false) {
					AddMore window = new AddMore(); //check whether user choose egg
				}
				else {
				counter3++;
				t.setAddOnPart("noriNo", counter3);
				noirNum.setText((String.valueOf(counter3)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));}
			}
		});
		
		JPanel panelMorechashu = new JPanel();   //add chashu panel
		panelMorechashu.setLayout(null);
		panelMorechashu.setBackground(new Color(255, 204, 102));
		panelMorechashu.setBounds(488, 42, 144, 89);
		panelPay.add(panelMorechashu);
		
		JPanel panelMorechashu1 = new JPanel();
		panelMorechashu1.setBounds(14, 8, 116, 35);
		panelMorechashu.add(panelMorechashu1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Chashu");
		lblNewLabel_4_3.setForeground(new Color(102, 204, 255));
		lblNewLabel_4_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelMorechashu1.add(lblNewLabel_4_3);
		
		JLabel chashuPrice = new JLabel("\uFFE1");
		chashuPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Chashu")));
		chashuPrice.setForeground(new Color(255, 102, 0));
		chashuPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		chashuPrice.setBounds(0, 58, 31, 18);
		panelMorechashu.add(chashuPrice);
		
		JButton chasuPlus= new JButton("+");
		chasuPlus.setHorizontalAlignment(SwingConstants.LEFT);
		chasuPlus.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		chasuPlus.setBounds(94, 56, 41, 27);
		panelMorechashu.add(chasuPlus);
		
		JButton chasuMin = new JButton("-");
		chasuMin.setVerticalAlignment(SwingConstants.TOP);
		chasuMin.setHorizontalAlignment(SwingConstants.LEFT);
		chasuMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		chasuMin.setBounds(34, 56, 41, 27);
		panelMorechashu.add(chasuMin);
		
		JLabel chasuNum = new JLabel(String.valueOf(t.getAddOnPart("chashuNo")));
		chasuNum.setForeground(new Color(255, 102, 0));
		chasuNum.setBounds(79, 61, 20, 16);
		panelMorechashu.add(chasuNum);
		if(Menu_Reader.readAvailable("Chashu")==false) {
			lblNewLabel_4_3.setText("sold out");
			lblNewLabel_4_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			chashuPrice.setVisible(false);
			chasuPlus.setVisible(false);
			chasuMin.setVisible(false);
			chasuNum.setVisible(false);
			counter4=0;
		}
		chasuMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter4>=1) {
				counter4--;
				t.setAddOnPart("chashuNo", counter4);
				chasuNum.setText((String.valueOf(counter4)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));
			}
			}
		});
		chasuPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getBasicPart2("chashu")==false) {
					AddMore window = new AddMore(); //check whether user choose egg
				}
				else {
				counter4++;
		    	t.setAddOnPart("chashuNo", counter4);
				chasuNum.setText((String.valueOf(counter4)));
				t.totalPriceCalculate();
				price.setText(String.valueOf(t.getTotalPrice()));}
			}
		});
		
	
		
		JLabel lblNewLabel = new JLabel("Add-on");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(27, 0, 131, 45);
		panelPay.add(lblNewLabel);
		
		JButton pay = new JButton("Pay");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t.getBasicPart1("soup")!=null &&t.getBasicPart1("noodle")!=null&& t.getBasicPart1("springOnion")!=null &&choose1!=0 &&choose2!=0 &&choose3!=0 &&choose4!=0) {
				panelHead.setVisible(false);
				panelChoice.setVisible(false);
				panelPay.setVisible(false);
				panelPay1.setVisible(false);
				frmWelcomeToRamen.setVisible(false);
				EatInOrTakeAway frame = new EatInOrTakeAway(t);
				}
				else {
					ChooseBasic window = new ChooseBasic();
				}
			}
		});
		pay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		pay.setBounds(447, 13, 166, 51);
		panelPay1.add(pay);
		
		
		
		spiciness_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_0.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				t.setSpiciness(0);
				choose4++;
			}
		});
		if(t.getSpiciness()==0) {
			spiciness_0.setForeground(Color.RED);	
			spiciness_1.setForeground(Color.BLACK);
			spiciness_2.setForeground(Color.BLACK);
			spiciness_3.setForeground(Color.BLACK);
			spiciness_4.setForeground(Color.BLACK);
			spiciness_5.setForeground(Color.BLACK);
		}
		spiciness_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_1.setForeground(Color.RED);	
				spiciness_0.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				t.setSpiciness(1);
				choose4++;
			}
		});
		if(t.getSpiciness()==1) {
			spiciness_1.setForeground(Color.RED);	
			spiciness_0.setForeground(Color.BLACK);
			spiciness_2.setForeground(Color.BLACK);
			spiciness_3.setForeground(Color.BLACK);
			spiciness_4.setForeground(Color.BLACK);
			spiciness_5.setForeground(Color.BLACK);
		}
		spiciness_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_2.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				t.setSpiciness(2);
				choose4++;
			}
		});
		if(t.getSpiciness()==2) {
			spiciness_2.setForeground(Color.RED);	
			spiciness_1.setForeground(Color.BLACK);
			spiciness_0.setForeground(Color.BLACK);
			spiciness_3.setForeground(Color.BLACK);
			spiciness_4.setForeground(Color.BLACK);
			spiciness_5.setForeground(Color.BLACK);
			t.setSpiciness(2);
		}
		spiciness_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_3.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				t.setSpiciness(3);
				choose4++;
			}
		});
		if(t.getSpiciness()==3) {
			spiciness_3.setForeground(Color.RED);	
			spiciness_1.setForeground(Color.BLACK);
			spiciness_2.setForeground(Color.BLACK);
			spiciness_0.setForeground(Color.BLACK);
			spiciness_4.setForeground(Color.BLACK);
			spiciness_5.setForeground(Color.BLACK);
		}
		spiciness_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_4.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				t.setSpiciness(4);
				choose4++;
			}
		});
		if(t.getSpiciness()==4) {
			spiciness_4.setForeground(Color.RED);	
			spiciness_1.setForeground(Color.BLACK);
			spiciness_2.setForeground(Color.BLACK);
			spiciness_3.setForeground(Color.BLACK);
			spiciness_0.setForeground(Color.BLACK);
			spiciness_5.setForeground(Color.BLACK);
		}
		spiciness_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_5.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				t.setSpiciness(5);
				choose4++;
			}
		});
		if(t.getSpiciness()==5) {
			spiciness_5.setForeground(Color.RED);	
			spiciness_1.setForeground(Color.BLACK);
			spiciness_2.setForeground(Color.BLACK);
			spiciness_3.setForeground(Color.BLACK);
			spiciness_4.setForeground(Color.BLACK);
			spiciness_0.setForeground(Color.BLACK);
		}
		
		have.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Nori")==true) {
				have.setForeground(Color.RED);
				don.setForeground(Color.BLACK);
				choose1++;
				t.setBasicPart2("nori", true);}
			}
		});
		don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don.setForeground(Color.RED);
				have.setForeground(Color.BLACK);
				choose1++;
				t.setBasicPart2("nori", false);
				if(counter3!=0) {
					counter3=0;
					System.out.print(counter3);
					noirNum.setText((String.valueOf(counter3)));
					t.setAddOnPart("noriNo", counter3);
					t.totalPriceCalculate();
					price.setText(String.valueOf(t.getTotalPrice()));
					
				}
			}
		});
		
		have_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Egg")==true) {
				have_2.setForeground(Color.RED);
				choose3++;
				t.setBasicPart2("egg", true);
				don_2.setForeground(Color.BLACK);}
			}
		});
		don_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_2.setForeground(Color.RED);
				choose3++;
				t.setBasicPart2("egg", false);
				have_2.setForeground(Color.BLACK);
				if(counter1!=0) {
					counter1=0;
					System.out.print(counter1);
					eggNum.setText((String.valueOf(counter1)));
					t.setAddOnPart("eggNo", counter1);
					t.totalPriceCalculate();
					price.setText(String.valueOf(t.getTotalPrice()));
					
				}
			}
		});
		have_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Chashu")==true) {
				have_1.setForeground(Color.RED);
				t.setBasicPart2("chashu", true);
				choose2++;
				don_1.setForeground(Color.BLACK);}
			}
		});
		don_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_1.setForeground(Color.RED);
				t.setBasicPart2("chashu", false);
				choose2++;
				have_1.setForeground(Color.BLACK);
				if(counter4!=0) {
					counter4=0;
					chasuNum.setText((String.valueOf(counter4)));
					t.setAddOnPart("chashuNo", counter4);
					t.totalPriceCalculate();
					price.setText(String.valueOf(t.getTotalPrice()));
					
				}
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnClear.setBounds(246, 13, 166, 51);
		panelPay1.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		      soupGroup.clearSelection();
			  noodleGroup.clearSelection();
			  onionGroup.clearSelection();
			  have.setForeground(Color.BLACK);
			  don.setForeground(Color.BLACK);
			  have_1.setForeground(Color.BLACK);
			  don_1.setForeground(Color.BLACK);
			  have_2.setForeground(Color.BLACK);
			  don_2.setForeground(Color.BLACK);
			  spiciness_2.setForeground(Color.BLACK);	
			  spiciness_1.setForeground(Color.BLACK);
			  spiciness_0.setForeground(Color.BLACK);
			  spiciness_3.setForeground(Color.BLACK);
			  spiciness_4.setForeground(Color.BLACK);
			  spiciness_5.setForeground(Color.BLACK);
			  eggNum.setText("0");
			  bambooNum.setText("0");
			  noirNum.setText("0");
			  chasuNum.setText("0");
			  price.setText("9.9");
			  t.setBasicPart1("soup", null);
			  t.setBasicPart1("noodle", null);
			  t.setBasicPart1("springonion", null);
			  choose1 = 0;
			  choose2 = 0;
			  choose3 = 0;
			  choose4 = 0;
			  t.setAddOnPart("eggNo", 0);
			  t.setAddOnPart("bambooNo", 0);
			  t.setAddOnPart("noriNo", 0);
			  t.setAddOnPart("chashuNo", 0);
			}});
           
	
	}
	
	public Entity_Ticket getTicket() {
		return ramenTicket;
	}

	/**
	 * Initialize the contents of the Ramen interface
	 */
	private void initialize() {
		frmWelcomeToRamen = new JFrame();
		frmWelcomeToRamen.setVisible(true);
		frmWelcomeToRamen.setTitle("Welcome to Ramen Restaurant!");
		frmWelcomeToRamen.setBounds(0, 0, 663, 766);
		frmWelcomeToRamen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToRamen.getContentPane().setLayout(null);
		
		JLabel noirNum,price;
		JPanel panelHead = new JPanel();  
		panelHead.setBounds(0, 0, 605, 61);
		frmWelcomeToRamen.getContentPane().add(panelHead);
		panelHead.setLayout(null);
		
		JLabel totalRamen = new JLabel("Totoro Ramen");
		totalRamen.setForeground(new Color(255, 153, 0));
		totalRamen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		totalRamen.setBounds(51, 0, 269, 53);
		panelHead.add(totalRamen);
		
		JLabel enjoy = new JLabel("enjoy it now!");
		enjoy.setForeground(new Color(255, 153, 0));
		enjoy.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		enjoy.setBounds(382, 23, 146, 38);
		panelHead.add(enjoy);
		
		JPanel panelChoice = new JPanel(); //essential choice panel
		panelChoice.setBounds(0, 61, 643, 455);
		panelChoice.setBackground(new Color(255, 255, 255));
		panelChoice.setForeground(new Color(255, 255, 255));
		frmWelcomeToRamen.getContentPane().add(panelChoice);
		panelChoice.setLayout(null);
		
		JLabel essPrice = new JLabel("essential selection-\uFFE19.9");
		essPrice.setText("essential selection-\uFFE1"+String.valueOf(Menu_Reader.readPrice("Basic")));
		essPrice.setBounds(14, 13, 337, 34);
		essPrice.setForeground(new Color(255, 153, 0));
		essPrice.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
		panelChoice.add(essPrice);
		
		JPanel panelSoup = new JPanel(); //soup panel
		panelSoup.setBounds(14, 60, 282, 99);
		panelSoup.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelSoup);
		panelSoup.setLayout(null);
		
		JPanel panelSoup1 = new JPanel();  
		panelSoup1.setBounds(14, 8, 254, 82);
		panelSoup.add(panelSoup1);
		panelSoup1.setLayout(null);
		
		JPanel panelSp = new JPanel();
		panelSp.setBackground(new Color(255, 153, 0));
		panelSp.setForeground(new Color(255, 153, 0));
		panelSp.setBounds(78, 0, 10, 82);
		panelSoup1.add(panelSp);
		
		ButtonGroup soupGroup=new ButtonGroup();
		JRadioButton tonkostu = new JRadioButton("Tonkotsu");
		tonkostu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("soup", "Tonkotsu"); //set the user's choice
			}
		});
		tonkostu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		tonkostu.setBounds(97, 0, 157, 27);
		panelSoup1.add(tonkostu);
		
		JRadioButton shio = new JRadioButton("Shio");
		shio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("soup", "Shio");   //set the user's choice
			}
		});
		shio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		shio.setBounds(97, 55, 157, 27);
		panelSoup1.add(shio);
		
		JRadioButton shoyu = new JRadioButton("Shoyu");
		shoyu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramenTicket.setBasicPart1("soup", "Shoyu");   //set the user's choice
			}
		});
		shoyu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		shoyu.setBounds(97, 24, 157, 35);
		panelSoup1.add(shoyu);
		
		soupGroup.add(shoyu);
		soupGroup.add(shio);
		soupGroup.add(tonkostu);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/Picture/soup.jpg"));
		lblNewLabel_3.setBounds(0, 0, 88, 82);
		panelSoup1.add(lblNewLabel_3);
		
		ButtonGroup noodleGroup=new ButtonGroup();
		
		JPanel panelNoodel = new JPanel();  //noodles choice panel
		panelNoodel.setBounds(14, 169, 282, 99);
		panelNoodel.setLayout(null);
		panelNoodel.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelNoodel);
		
		JPanel panelNoodel1 = new JPanel();
		panelNoodel1.setLayout(null);
		panelNoodel1.setBounds(14, 8, 254, 82);
		panelNoodel.add(panelNoodel1);
		
		JPanel panelSp_1 = new JPanel();
		panelSp_1.setForeground(new Color(255, 153, 0));
		panelSp_1.setBackground(new Color(255, 153, 0));
		panelSp_1.setBounds(78, 0, 10, 82);
		panelNoodel1.add(panelSp_1);
		
		JRadioButton soft = new JRadioButton("Soft");
		soft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("noodle", "Soft");  //set the user's choice
			}
		});
		soft.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		soft.setBounds(97, 0, 157, 27);
		panelNoodel1.add(soft);
		
		JRadioButton firm = new JRadioButton("Firm");
		firm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("noodle", "Firm");  //set the user's choice
			}
		});
		firm.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		firm.setBounds(97, 55, 157, 27);
		panelNoodel1.add(firm);
		
		JRadioButton medium = new JRadioButton("Medium");
		medium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("noodle", "Medium");  ////set the user's choice
			}
		});
		medium.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		medium.setBounds(97, 24, 157, 35);
		panelNoodel1.add(medium);
		
		noodleGroup.add(medium);
		noodleGroup.add(firm);
		noodleGroup.add(soft);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/Picture/noodle.jpg"));
		lblNewLabel_2.setBounds(-60, 0, 140, 82);
		panelNoodel1.add(lblNewLabel_2);
		
	
		
			
	
		
		ButtonGroup onionGroup=new ButtonGroup();
		
		JPanel panelOnion = new JPanel();  //onion panel
		panelOnion.setBounds(14, 283, 282, 99);
		panelOnion.setLayout(null);
		panelOnion.setBackground(new Color(255, 153, 0));
		panelChoice.add(panelOnion);
		
		JPanel panelOnion1 = new JPanel();
		panelOnion1.setLayout(null);
		panelOnion1.setBounds(14, 8, 254, 82);
		panelOnion.add(panelOnion1);
		
		JPanel panelSp_1_1 = new JPanel();
		panelSp_1_1.setForeground(new Color(255, 153, 0));
		panelSp_1_1.setBackground(new Color(255, 153, 0));
		panelSp_1_1.setBounds(78, 0, 10, 82);
		panelOnion1.add(panelSp_1_1);
		
		JRadioButton no = new JRadioButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("springOnion", "No");  //set the user's choice
			}
		});
		no.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		no.setBounds(97, 0, 157, 27);
		panelOnion1.add(no);
		
		JRadioButton lot = new JRadioButton("Lot");
		lot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("springOnion", "Lot");  //set the user's choice
			}
		});
		lot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lot.setBounds(97, 55, 157, 27);
		panelOnion1.add(lot);
		
		JRadioButton little = new JRadioButton("Little");
		little.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramenTicket.setBasicPart1("springOnion", "Little");  //set the user's choice
			}
		});
		little.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		little.setBounds(97, 24, 157, 35);
		panelOnion1.add(little);
		
		onionGroup.add(little);
		onionGroup.add(lot);
		onionGroup.add(no);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("src/Picture/SpringOnion.jpg"));
		lblNewLabel_4.setBounds(-100, 0, 180, 82);
		panelOnion1.add(lblNewLabel_4);
		
		
		JPanel panelNori= new JPanel();   //nori panel
		panelNori.setBackground(new Color(255, 153, 0));
		panelNori.setBounds(420, 29, 149, 85);
		panelChoice.add(panelNori);
		panelNori.setLayout(null);
		
		JPanel panelNori_1 = new JPanel();
		panelNori_1.setBounds(14, 8, 120, 70);
		panelNori.add(panelNori_1);
		panelNori_1.setLayout(null);
		
		JLabel nori = new JLabel("Nori");
		nori.setHorizontalAlignment(SwingConstants.CENTER);
		nori.setBounds(0, 2, 120, 28);
		nori.setForeground(new Color(255, 153, 0));
		nori.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		panelNori_1.add(nori);
		
		ButtonGroup noriGroup = new ButtonGroup();
		JButton have = new JButton(String.valueOf((char)8730));
		
		have.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have.setBounds(0, 43, 61, 27);
		panelNori_1.add(have);
		
		JButton don = new JButton(String.valueOf((char)215));
		if(Menu_Reader.readAvailable("Nori")==false) {
			nori.setText("sold out");
			don.setForeground(Color.RED);
			have.setForeground(Color.BLACK);
			ramenTicket.setBasicPart2("nori", false);
			nori.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		don.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don.setBounds(59, 43, 61, 27);
		panelNori_1.add(don);
		
		
		JPanel panelChasu = new JPanel();   //chashu panel
		panelChasu.setLayout(null);
		panelChasu.setBackground(new Color(255, 153, 0));
		panelChasu.setBounds(420, 138, 149, 85);
		panelChoice.add(panelChasu);
		
		JPanel panelChasu1 = new JPanel();
		panelChasu1.setLayout(null);
		panelChasu1.setBounds(14, 8, 120, 70);
		panelChasu.add(panelChasu1);
		
		JLabel lblChashu = new JLabel("Chashu");
		lblChashu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChashu.setForeground(new Color(255, 153, 0));
		lblChashu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblChashu.setBounds(0, 5, 120, 28);
		panelChasu1.add(lblChashu);
		
		JButton have_1 = new JButton(String.valueOf((char)8730));
		have_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have_1.setBounds(0, 43, 61, 27);
		panelChasu1.add(have_1);
		
		JButton don_1 = new JButton(String.valueOf((char)215));
		don_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don_1.setBounds(59, 43, 61, 27);
		panelChasu1.add(don_1);
		if(Menu_Reader.readAvailable("Chashu")==false) {
			lblChashu.setText("sold out");
			don_1.setForeground(Color.RED);
			have_1.setForeground(Color.BLACK);
			ramenTicket.setBasicPart2("nori", false);
			lblChashu.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		
		
		have_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Chashu")==true) {
				have_1.setForeground(Color.RED);
				ramenTicket.setBasicPart2("chashu", true);
				choose2++;
				don_1.setForeground(Color.BLACK);}
			}
		});
		don_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_1.setForeground(Color.RED);
				ramenTicket.setBasicPart2("chashu", false);
				choose2++;
				have_1.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelEgg = new JPanel();  //egg panel
		panelEgg.setLayout(null);
		panelEgg.setBackground(new Color(255, 153, 0));
		panelEgg.setBounds(420, 247, 149, 85);
		panelChoice.add(panelEgg);
		
		JPanel panelEgg1 = new JPanel();
		panelEgg1.setLayout(null);
		panelEgg1.setBounds(14, 8, 120, 70);
		panelEgg.add(panelEgg1);
		
		JLabel lblBoiledEgg = new JLabel("Boiled egg");
		lblBoiledEgg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoiledEgg.setForeground(new Color(255, 153, 0));
		lblBoiledEgg.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblBoiledEgg.setBounds(0, 5, 120, 28);
		panelEgg1.add(lblBoiledEgg);
		
		JButton have_2 = new JButton(String.valueOf((char)8730));
		have_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		have_2.setBounds(0, 43, 61, 27);
		panelEgg1.add(have_2);
		
		JButton don_2 = new JButton(String.valueOf((char)215));
		don_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		don_2.setBounds(59, 43, 61, 27);
		panelEgg1.add(don_2);
		if(Menu_Reader.readAvailable("Egg")==false) {
			lblBoiledEgg.setText("sold out");
			don_2.setForeground(Color.RED);
			have_2.setForeground(Color.BLACK);
			ramenTicket.setBasicPart2("egg", false);
			lblBoiledEgg.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		}
		have_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Egg")==true) {
				have_2.setForeground(Color.RED);
				choose3++;
				ramenTicket.setBasicPart2("egg", true);
				don_2.setForeground(Color.BLACK);}
			}
		});
		don_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_2.setForeground(Color.RED);
				choose3++;
				ramenTicket.setBasicPart2("egg", false);
				have_2.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelHot = new JPanel();  //spicy panel
		panelHot.setBackground(new Color(255, 0, 51));
		panelHot.setBounds(64, 386, 505, 63);
		panelChoice.add(panelHot);
		panelHot.setLayout(null);
		
		JPanel panelHot_1 = new JPanel();
		panelHot_1.setBounds(14, 8, 476, 44);
		panelHot.add(panelHot_1);
		panelHot_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 0, 51));
		panel_3.setBounds(72, 0, 10, 44);
		panelHot_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 0, 51));
		panel_3_1.setBounds(151, 0, 10, 44);
		panelHot_1.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(255, 0, 51));
		panel_3_2.setBounds(233, 0, 10, 44);
		panelHot_1.add(panel_3_2);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(255, 0, 51));
		panel_3_3.setBounds(315, 0, 10, 44);
		panelHot_1.add(panel_3_3);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBackground(new Color(255, 0, 51));
		panel_3_4.setBounds(397, 0, 10, 44);
		panelHot_1.add(panel_3_4);
		
		JPanel panelPay1 = new JPanel();  //pay panel
		panelPay1.setBounds(0, 649, 627, 71);
		frmWelcomeToRamen.getContentPane().add(panelPay1);
		panelPay1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uFFE1");  
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(14, 16, 49, 40);
		panelPay1.add(lblNewLabel_1);
		
		 price = new JLabel("9.9");  //cost of ramen
		price.setText(String.valueOf(Menu_Reader.readPrice("Basic")));
		price.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		price.setBounds(71, 11, 84, 52);
		panelPay1.add(price);
		
		JButton spiciness_0 = new JButton("0");
		spiciness_0.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_0.setBounds(0, 0, 73, 44);
		panelHot_1.add(spiciness_0);
		
		JButton spiciness_1 = new JButton("1");
		spiciness_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_1.setBounds(82, 0, 73, 44);
		panelHot_1.add(spiciness_1);
		
		JButton spiciness_2 = new JButton("2");
		spiciness_2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_2.setBounds(161, 0, 75, 44);
		panelHot_1.add(spiciness_2);
		
		JButton spiciness_3 = new JButton("3");
		spiciness_3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_3.setBounds(242, 0, 75, 44);
		panelHot_1.add(spiciness_3);
		
		JButton spiciness_4 = new JButton("4");
		spiciness_4.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_4.setBounds(324, 0, 75, 44);
		panelHot_1.add(spiciness_4);
		
		JButton spiciness_5 = new JButton("5");
		spiciness_5.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		spiciness_5.setBounds(404, 0, 75, 44);
		panelHot_1.add(spiciness_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 51));
		panel_2.setBounds(430, 345, 139, 43);
		panelChoice.add(panel_2);
		
		JLabel spiciness = new JLabel("Spiciness");
		spiciness.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		spiciness.setForeground(new Color(255, 255, 255));
		panel_2.add(spiciness);
		
		JPanel panelPay = new JPanel();   //add-one panel
		
		JScrollPane pan=new JScrollPane(panelPay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelPay.setBackground(new Color(240, 240, 240));
		pan.setBounds(0, 519, 643, 135);
		panelPay.setBounds(0, 1519, 643, 150);
		frmWelcomeToRamen.getContentPane().add(pan);
		panelPay.setLayout(null);
		
		
		JPanel panelAddegg = new JPanel();  //add egg panel
		panelAddegg.setLayout(null);
		panelAddegg.setBackground(new Color(255, 204, 102));
		panelAddegg.setBounds(14, 42, 144, 89);
		panelPay.add(panelAddegg);
		
		JPanel panelAddegg1 = new JPanel();
		panelAddegg1.setBounds(14, 8, 116, 35);
		panelAddegg.add(panelAddegg1);
		
		JLabel eggtext = new JLabel("Egg");
		eggtext.setForeground(new Color(102, 204, 255));
		eggtext.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelAddegg1.add(eggtext);
		
		JLabel eggPrice = new JLabel("\uFFE1");
		eggPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Egg")));
		eggPrice.setForeground(new Color(255, 102, 0));
		eggPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		eggPrice.setBounds(0, 58, 31, 18);
		panelAddegg.add(eggPrice);
		
		JButton eggPlus = new JButton("+");
		eggPlus.setHorizontalAlignment(SwingConstants.LEFT);
		eggPlus.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		eggPlus.setBounds(94, 56, 41, 27);
		panelAddegg.add(eggPlus);
		
		JButton eggMin = new JButton("-");
		eggMin.setVerticalAlignment(SwingConstants.TOP);
		eggMin.setHorizontalAlignment(SwingConstants.LEFT);
		eggMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		eggMin.setBounds(34, 56, 41, 27);
		panelAddegg.add(eggMin);
		
		JLabel eggNum = new JLabel("0");
		eggNum.setForeground(new Color(255, 102, 0));
		eggNum.setBounds(79, 61, 20, 16);
		panelAddegg.add(eggNum);
		
		eggPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ramenTicket.getBasicPart2("egg")==false) {
					AddMore window = new AddMore();//check whether user choose egg
				}
				else {
				counter1++;
				ramenTicket.setAddOnPart("eggNo", counter1);
				eggNum.setText((String.valueOf(counter1)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));
				}
			}
		});
		eggMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter1>=1) {
					counter1--;
					ramenTicket.setAddOnPart("eggNo", counter1);
					eggNum.setText((String.valueOf(counter1)));
					ramenTicket.totalPriceCalculate();
					price.setText(String.valueOf(ramenTicket.getTotalPrice()));
				}
			}
		});
		if(Menu_Reader.readAvailable("Egg")==false) {
			eggtext.setText("sold out");
			eggtext.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			eggPrice.setVisible(false);
			eggPlus.setVisible(false);
			eggMin.setVisible(false);
			eggNum.setVisible(false);
			counter1=0;
		}
		
		JPanel panelAddbamboo = new JPanel();  //add bamboo panel
		panelAddbamboo.setLayout(null);
		panelAddbamboo.setBackground(new Color(255, 204, 102));
		panelAddbamboo.setBounds(172, 42, 144, 89);
		panelPay.add(panelAddbamboo);
		
		JPanel panelAddbamboo1 = new JPanel();
		panelAddbamboo1.setBounds(14, 8, 116, 35);
		panelAddbamboo.add(panelAddbamboo1);
		
		JLabel bambooShoot = new JLabel("Bamboo Shoots");
		bambooShoot.setForeground(new Color(102, 204, 255));
		bambooShoot.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		panelAddbamboo1.add(bambooShoot);
		
		JLabel bambooPrice = new JLabel("\uFFE1");
		bambooPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Bamboo Shoots")));
		bambooPrice.setForeground(new Color(255, 102, 0));
		bambooPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		bambooPrice.setBounds(0, 58, 31, 18);
		panelAddbamboo.add(bambooPrice);
		
		JButton bambooAdd = new JButton("+");
		bambooAdd.setHorizontalAlignment(SwingConstants.LEFT);
		bambooAdd.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		bambooAdd.setBounds(94, 56, 41, 27);
		panelAddbamboo.add(bambooAdd);
		
		JButton bambooMin = new JButton("-");
		
		bambooMin.setVerticalAlignment(SwingConstants.TOP);
		bambooMin.setHorizontalAlignment(SwingConstants.LEFT);
		bambooMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		bambooMin.setBounds(34, 56, 41, 27);
		panelAddbamboo.add(bambooMin);
		
		JLabel bambooNum = new JLabel("0");
		 bambooNum.setForeground(new Color(255, 102, 0));
		 bambooNum.setBounds(79, 61, 20, 16);
		panelAddbamboo.add( bambooNum);
		
		bambooMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter2>=1) {
				counter2--;
				ramenTicket.setAddOnPart("bambooNo", counter2);
				bambooNum.setText((String.valueOf(counter2)));		
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));
			}
			}
		});
		bambooAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter2++;
				ramenTicket.setAddOnPart("bambooNo", counter2);
				bambooNum.setText((String.valueOf(counter2)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));
			}
		});
		if(Menu_Reader.readAvailable("Bamboo Shoots")==false) {
			bambooShoot.setText("sold out");
			bambooShoot.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			bambooPrice.setVisible(false);
			bambooAdd.setVisible(false);
			bambooMin.setVisible(false);
			bambooNum.setVisible(false);
			counter2=0;
		}
		
		JPanel panelMorenori = new JPanel();  //add nori panel
		panelMorenori.setLayout(null);
		panelMorenori.setBackground(new Color(255, 204, 102));
		panelMorenori.setBounds(330, 42, 144, 89);
		panelPay.add(panelMorenori);
		
		JPanel panelMorenori1 = new JPanel();
		panelMorenori1.setBounds(14, 8, 116, 35);
		panelMorenori.add(panelMorenori1);
		
		JLabel noriMore = new JLabel("Nori");
		noriMore.setForeground(new Color(102, 204, 255));
		noriMore.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelMorenori1.add(noriMore);
		JLabel noriPrice = new JLabel("\uFFE1");
		noriPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Nori")));
		noriPrice.setForeground(new Color(255, 102, 0));
		noriPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		noriPrice.setBounds(0, 58, 31, 18);
		panelMorenori.add(noriPrice);
		
		JButton noriAdd = new JButton("+");
		noriAdd.setHorizontalAlignment(SwingConstants.LEFT);
		noriAdd.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		noriAdd.setBounds(94, 56, 41, 27);
		panelMorenori.add(noriAdd);
		
		JButton noriMin = new JButton("-");
		noriMin.setVerticalAlignment(SwingConstants.TOP);
		noriMin.setHorizontalAlignment(SwingConstants.LEFT);
		noriMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		noriMin.setBounds(34, 56, 41, 27);
		panelMorenori.add(noriMin);
		
		noirNum = new JLabel("0");
		noirNum.setForeground(new Color(255, 102, 0));
		noirNum.setBounds(79, 61, 20, 16);
		panelMorenori.add(noirNum);
		if(Menu_Reader.readAvailable("Nori")==false) {
			noriMore.setText("sold out");
			noriMore.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			noriPrice.setVisible(false);
			noriAdd.setVisible(false);
			noriMin.setVisible(false);
			noirNum.setVisible(false);
			counter3=0;
		}
		noriMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter3>=1) {
				counter3--;
				ramenTicket.setAddOnPart("noriNo", counter3);
				noirNum.setText((String.valueOf(counter3)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));
			}
			}
		});
		noriAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ramenTicket.getBasicPart2("nori")==false) {
					AddMore window = new AddMore(); //check whether user choose egg
				}
				else {
				counter3++;
				ramenTicket.setAddOnPart("noriNo", counter3);
				noirNum.setText((String.valueOf(counter3)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));}
			}
		});
		
		JPanel panelMorechashu = new JPanel();   //add chashu panel
		panelMorechashu.setLayout(null);
		panelMorechashu.setBackground(new Color(255, 204, 102));
		panelMorechashu.setBounds(488, 42, 144, 89);
		panelPay.add(panelMorechashu);
		
		JPanel panelMorechashu1 = new JPanel();
		panelMorechashu1.setBounds(14, 8, 116, 35);
		panelMorechashu.add(panelMorechashu1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Chashu");
		lblNewLabel_4_3.setForeground(new Color(102, 204, 255));
		lblNewLabel_4_3.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		panelMorechashu1.add(lblNewLabel_4_3);
		
		JLabel chashuPrice = new JLabel("\uFFE1");
		chashuPrice.setText("\uFFE1"+String.valueOf(Menu_Reader.readPrice("Chashu")));
		chashuPrice.setForeground(new Color(255, 102, 0));
		chashuPrice.setFont(new Font("Yu Gothic UI Semilight", Font.ITALIC, 12));
		chashuPrice.setBounds(0, 58, 31, 18);
		panelMorechashu.add(chashuPrice);
		
		JButton chasuPlus= new JButton("+");
		chasuPlus.setHorizontalAlignment(SwingConstants.LEFT);
		chasuPlus.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		chasuPlus.setBounds(94, 56, 41, 27);
		panelMorechashu.add(chasuPlus);
		
		JButton chasuMin = new JButton("-");
		chasuMin.setVerticalAlignment(SwingConstants.TOP);
		chasuMin.setHorizontalAlignment(SwingConstants.LEFT);
		chasuMin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		chasuMin.setBounds(34, 56, 41, 27);
		panelMorechashu.add(chasuMin);
		
		JLabel chasuNum = new JLabel("0");
		chasuNum.setForeground(new Color(255, 102, 0));
		chasuNum.setBounds(79, 61, 20, 16);
		panelMorechashu.add(chasuNum);
		if(Menu_Reader.readAvailable("Chashu")==false) {
			lblNewLabel_4_3.setText("sold out");
			lblNewLabel_4_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			chashuPrice.setVisible(false);
			chasuPlus.setVisible(false);
			chasuMin.setVisible(false);
			chasuNum.setVisible(false);
			counter4=0;
		}
		chasuMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(counter4>=1) {
				counter4--;
				ramenTicket.setAddOnPart("chashuNo", counter4);
				chasuNum.setText((String.valueOf(counter4)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));
			}
			}
		});
		chasuPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ramenTicket.getBasicPart2("chashu")==false) {
					AddMore window = new AddMore(); //check whether user choose egg
				}
				else {
				counter4++;
		    	ramenTicket.setAddOnPart("chashuNo", counter4);
				chasuNum.setText((String.valueOf(counter4)));
				ramenTicket.totalPriceCalculate();
				price.setText(String.valueOf(ramenTicket.getTotalPrice()));}
			}
		});
		
	
		
		JLabel lblNewLabel = new JLabel("Add-on");
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(27, 0, 131, 45);
		panelPay.add(lblNewLabel);
		
		JButton pay = new JButton("Pay");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ramenTicket.getBasicPart1("soup")!=null &&ramenTicket.getBasicPart1("noodle")!=null&& ramenTicket.getBasicPart1("springOnion")!=null &&choose1!=0 &&choose2!=0 &&choose3!=0 &&choose4!=0) {
				panelHead.setVisible(false);
				panelChoice.setVisible(false);
				panelPay.setVisible(false);
				panelPay1.setVisible(false);
				frmWelcomeToRamen.setVisible(false);
				EatInOrTakeAway frame = new EatInOrTakeAway(ramenTicket);
				}
				else {
					ChooseBasic window = new ChooseBasic();
				}
			}
		});
		pay.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		pay.setBounds(447, 13, 166, 51);
		panelPay1.add(pay);
		
		
		
		spiciness_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_0.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(0);
				choose4++;
			}
		});
		spiciness_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_1.setForeground(Color.RED);	
				spiciness_0.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(1);
				choose4++;
			}
		});
		spiciness_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_2.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(2);
				choose4++;
			}
		});
		spiciness_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_3.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(3);
				choose4++;
			}
		});
		spiciness_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_4.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				spiciness_5.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(4);
				choose4++;
			}
		});
		spiciness_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiciness_5.setForeground(Color.RED);	
				spiciness_1.setForeground(Color.BLACK);
				spiciness_2.setForeground(Color.BLACK);
				spiciness_3.setForeground(Color.BLACK);
				spiciness_4.setForeground(Color.BLACK);
				spiciness_0.setForeground(Color.BLACK);
				ramenTicket.setSpiciness(5);
				choose4++;
			}
		});
		have.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Nori")==true) {
				have.setForeground(Color.RED);
				don.setForeground(Color.BLACK);
				choose1++;
				ramenTicket.setBasicPart2("nori", true);}
			}
		});
		don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don.setForeground(Color.RED);
				have.setForeground(Color.BLACK);
				choose1++;
				ramenTicket.setBasicPart2("nori", false);
				if(counter3!=0) {
					counter3=0;
					System.out.print(counter3);
					noirNum.setText((String.valueOf(counter3)));
					ramenTicket.setAddOnPart("noriNo", counter3);
					ramenTicket.totalPriceCalculate();
					price.setText(String.valueOf(ramenTicket.getTotalPrice()));
					
				}
			}
		});
		
		have_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Egg")==true) {
				have_2.setForeground(Color.RED);
				choose3++;
				ramenTicket.setBasicPart2("egg", true);
				don_2.setForeground(Color.BLACK);}
			}
		});
		don_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_2.setForeground(Color.RED);
				choose3++;
				ramenTicket.setBasicPart2("egg", false);
				have_2.setForeground(Color.BLACK);
				if(counter1!=0) {
					counter1=0;
					System.out.print(counter1);
					eggNum.setText((String.valueOf(counter1)));
					ramenTicket.setAddOnPart("eggNo", counter1);
					ramenTicket.totalPriceCalculate();
					price.setText(String.valueOf(ramenTicket.getTotalPrice()));
					
				}
			}
		});
		have_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Menu_Reader.readAvailable("Chashu")==true) {
				have_1.setForeground(Color.RED);
				ramenTicket.setBasicPart2("chashu", true);
				choose2++;
				don_1.setForeground(Color.BLACK);}
			}
		});
		don_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				don_1.setForeground(Color.RED);
				ramenTicket.setBasicPart2("chashu", false);
				choose2++;
				have_1.setForeground(Color.BLACK);
				if(counter4!=0) {
					counter4=0;
					chasuNum.setText((String.valueOf(counter4)));
					ramenTicket.setAddOnPart("chashuNo", counter4);
					ramenTicket.totalPriceCalculate();
					price.setText(String.valueOf(ramenTicket.getTotalPrice()));
					
				}
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnClear.setBounds(246, 13, 166, 51);
		panelPay1.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  soupGroup.clearSelection();
			  noodleGroup.clearSelection();
			  onionGroup.clearSelection();
			  have.setForeground(Color.BLACK);
			  don.setForeground(Color.BLACK);
			  have_1.setForeground(Color.BLACK);
			  don_1.setForeground(Color.BLACK);
			  have_2.setForeground(Color.BLACK);
			  don_2.setForeground(Color.BLACK);
			  spiciness_2.setForeground(Color.BLACK);	
			  spiciness_1.setForeground(Color.BLACK);
			  spiciness_0.setForeground(Color.BLACK);
			  spiciness_3.setForeground(Color.BLACK);
			  spiciness_4.setForeground(Color.BLACK);
			  spiciness_5.setForeground(Color.BLACK);
			  eggNum.setText("0");
			  bambooNum.setText("0");
			  noirNum.setText("0");
			  chasuNum.setText("0");
			  price.setText("9.9");
			  ramenTicket.setBasicPart1("soup", null);
			  ramenTicket.setBasicPart1("noodle", null);
			  ramenTicket.setBasicPart1("springonion", null);
			  /*
			  ramenTicket.setBasicPart2("egg",null);
			  ramenTicket.setBasicPart2("chashu", null);
			  ramenTicket.setBasicPart2("nori", null);
			  ramenTicket.setSpiciness(null);
			  */
			  choose1 = 0;
			  choose2 = 0;
			  choose3 = 0;
			  choose4 = 0;
			  ramenTicket.setAddOnPart("eggNo", 0);
			  ramenTicket.setAddOnPart("bambooNo", 0);
			  ramenTicket.setAddOnPart("noriNo", 0);
			  ramenTicket.setAddOnPart("chashuNo", 0);
			}});
		
	}
}
