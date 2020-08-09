package System.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import org.quartz.Scheduler;

import System.Control.Report;
import System.Control.SendMail;
import System.Control.TimeTrigger;
import System.Data.Report_Reader;
import System.Data.Report_Storer;
import System.Entity.Entity_Report;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * Interface generating the general report.
 * @author Mengmeng Ai
 * @version 1.0
 */
public class GeneralReport extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralReport frame = new GeneralReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param tt
	 * @param sched
	 */
	public GeneralReport(TimeTrigger tt, Scheduler sched) {
		// get the data
		Entity_Report repo = new Entity_Report();
		Report_Storer.csvforstatistic(repo.getrepoDate());
		repo=Report_Reader.creatRepo();
		
		HashMap noodleData=repo.getNoodle();
		HashMap soupData=repo.getSoup();
		HashMap onionData=repo.getOnion();
		HashMap spiciData=repo.getSpiciness();
		
		//setType(Type.UTILITY);
		setTitle("Welcome to Ramen Restaurant!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblTotoralRemen = new JLabel("TOTORO   REMEN");
		lblTotoralRemen.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblTotoralRemen.setForeground(new Color(255, 140, 0));
		lblTotoralRemen.setBounds(332, 0, 417, 33);
		contentPane.add(lblTotoralRemen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 42, 1005, 3);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(0, 46, 1005, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblpayment = new JLabel(">Report --General");
		lblpayment.setForeground(new Color(255, 140, 0));
		lblpayment.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 23));
		lblpayment.setBounds(14, 13, 251, 31);
		panel_1.add(lblpayment);
		
		//the soup panel
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(244, 164, 96));
		panel_2.setBounds(117, 159, 234, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();  
		panel_3.setBounds(5, 5, 77, 79);
		panel_2.add(panel_3);
		ImageIcon soupPicture=new ImageIcon("src/Picture/soup.jpg");
		panel_3.setLayout(null);
		JLabel soupLabel=new JLabel(soupPicture);
		soupLabel.setBounds(0, 0, 77, 79);
		soupLabel.setBackground(new Color(245, 255, 250));
		panel_3.add(soupLabel);
		
		JLabel lblTonkostu = new JLabel("Tonkotsu");
		lblTonkostu.setForeground(new Color(255, 140, 0));
		lblTonkostu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblTonkostu.setOpaque(true);
		lblTonkostu.setBackground(new Color(255, 245, 238));
		lblTonkostu.setBounds(86, 5, 72, 24);
		panel_2.add(lblTonkostu);
		
		JLabel lblShoyu = new JLabel("Shoyu");
		lblShoyu.setForeground(new Color(255, 140, 0));
		lblShoyu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblShoyu.setOpaque(true);
		lblShoyu.setBackground(new Color(255, 245, 238));
		lblShoyu.setBounds(86, 32, 72, 24);
		panel_2.add(lblShoyu);
		
		JLabel lblShio = new JLabel("Shio");
		lblShio.setForeground(new Color(255, 140, 0));
		lblShio.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblShio.setOpaque(true);
		lblShio.setBackground(new Color(255, 245, 238));
		lblShio.setBounds(86, 60, 72, 24);
		panel_2.add(lblShio);
		
		int TonNum;
		if(soupData.get("Tonkotsu")==null) {
			TonNum=0;
		}
		else {
			TonNum=(int)soupData.get("Tonkotsu");
		}
		JLabel lblTonnum = new JLabel(""+TonNum);
		lblTonnum.setForeground(Color.BLACK);
		lblTonnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblTonnum.setOpaque(true);
		lblTonnum.setBackground(Color.WHITE);
		lblTonnum.setBounds(162, 5, 67, 24);
		panel_2.add(lblTonnum);
		
		int ShoNum;
		if(soupData.get("Shoyu")==null) {
			ShoNum=0;
		}
		else {
			ShoNum=(int)soupData.get("Shoyu");
		}
		JLabel lblShoyunum = new JLabel(""+ShoNum);
		lblShoyunum.setForeground(Color.BLACK);
		lblShoyunum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblShoyunum.setOpaque(true);
		lblShoyunum.setBackground(Color.WHITE);
		lblShoyunum.setBounds(162, 32, 67, 24);
		panel_2.add(lblShoyunum);
		
		int ShioNum;
		if(soupData.get("Shio")==null) {
			ShioNum=0;
		}
		else {
			ShioNum=(int)soupData.get("Shio");
		}
		JLabel lblShionum = new JLabel(""+ShioNum);
		lblShionum.setForeground(Color.BLACK);
		lblShionum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblShionum.setOpaque(true);
		lblShionum.setBackground(Color.WHITE);
		lblShionum.setBounds(162, 60, 67, 24);
		panel_2.add(lblShionum);
		
		//the noodle panel
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(244, 164, 96));
		panel_4.setBounds(117, 247, 234, 90);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();  
		panel_5.setBounds(5, 5, 77, 79);
		panel_4.add(panel_5);
		ImageIcon noodlePicture=new ImageIcon("src/Picture/noodle.jpg");
		panel_5.setLayout(null);
		JLabel noodleLabel=new JLabel(noodlePicture);
		noodleLabel.setBounds(0, 0, 77, 79);
		noodleLabel.setBackground(new Color(245, 255, 250));
		panel_5.add(noodleLabel);
		
		JLabel lblSoft = new JLabel("Soft");
		lblSoft.setForeground(new Color(255, 140, 0));
		lblSoft.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblSoft.setOpaque(true);
		lblSoft.setBackground(new Color(255, 245, 238));
		lblSoft.setBounds(86, 5, 72, 24);
		panel_4.add(lblSoft);
		
		JLabel lblMedium = new JLabel("Medium");
		lblMedium.setForeground(new Color(255, 140, 0));
		lblMedium.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblMedium.setOpaque(true);
		lblMedium.setBackground(new Color(255, 245, 238));
		lblMedium.setBounds(86, 32, 72, 24);
		panel_4.add(lblMedium);
		
		JLabel lblFirm = new JLabel("Firm");
		lblFirm.setForeground(new Color(255, 140, 0));
		lblFirm.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblFirm.setOpaque(true);
		lblFirm.setBackground(new Color(255, 245, 238));
		lblFirm.setBounds(86, 60, 72, 24);
		panel_4.add(lblFirm);
		
		int SoftNum;
		if(noodleData.get("Soft")==null) {
			SoftNum=0;
		}
		else {
			SoftNum=(int)noodleData.get("Soft");
		}
		JLabel lblSoftnum = new JLabel(""+SoftNum);
		lblSoftnum.setForeground(Color.BLACK);
		lblSoftnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblSoftnum.setOpaque(true);
		lblSoftnum.setBackground(Color.WHITE);
		lblSoftnum.setBounds(162, 5, 67, 24);
		panel_4.add(lblSoftnum);
		
		int MediumNum;
		if(noodleData.get("Medium")==null) {
			MediumNum=0;
		}
		else {
			MediumNum=(int)noodleData.get("Medium");
		}
		JLabel lblMediumnum = new JLabel(""+MediumNum);
		lblMediumnum.setForeground(Color.BLACK);
		lblMediumnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblMediumnum.setOpaque(true);
		lblMediumnum.setBackground(Color.WHITE);
		lblMediumnum.setBounds(162, 32, 67, 24);
		panel_4.add(lblMediumnum);
		
		int FirmNum;
		if(noodleData.get("Firm")==null) {
			FirmNum=0;
		}
		else {
			FirmNum=(int)noodleData.get("Firm");
		}
		JLabel lblFirmnum = new JLabel(""+FirmNum);
		lblFirmnum.setForeground(Color.BLACK);
		lblFirmnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblFirmnum.setOpaque(true);
		lblFirmnum.setBackground(Color.WHITE);
		lblFirmnum.setBounds(162, 60, 67, 24);
		panel_4.add(lblFirmnum);
		
		//the onion panel
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(244, 164, 96));
		panel_6.setBounds(117, 336, 234, 90);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();  
		panel_7.setBounds(5, 5, 77, 79);
		panel_6.add(panel_7);
		ImageIcon onionPicture=new ImageIcon("src/Picture/SpringOnion.jpg");
		panel_7.setLayout(null);
		JLabel onionLabel=new JLabel(onionPicture);
		onionLabel.setBounds(0, 0, 77, 79);
		onionLabel.setBackground(new Color(245, 255, 250));
		panel_7.add(onionLabel);
		
		JLabel lblNo = new JLabel("No");
		lblNo.setForeground(new Color(255, 140, 0));
		lblNo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblNo.setOpaque(true);
		lblNo.setBackground(new Color(255, 245, 238));
		lblNo.setBounds(86, 5, 72, 24);
		panel_6.add(lblNo);
		
		JLabel lblLittle = new JLabel("Little");
		lblLittle.setForeground(new Color(255, 140, 0));
		lblLittle.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblLittle.setOpaque(true);
		lblLittle.setBackground(new Color(255, 245, 238));
		lblLittle.setBounds(86, 32, 72, 24);
		panel_6.add(lblLittle);
		
		JLabel lblLot = new JLabel("Lot");
		lblLot.setForeground(new Color(255, 140, 0));
		lblLot.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblLot.setOpaque(true);
		lblLot.setBackground(new Color(255, 245, 238));
		lblLot.setBounds(86, 60, 72, 24);
		panel_6.add(lblLot);
		
		int NoNum;
		if(onionData.get("No")==null) {
			NoNum=0;
		}
		else {
			NoNum=(int)onionData.get("No");
		}
		JLabel lblNonum = new JLabel(""+NoNum);
		lblNonum.setForeground(Color.BLACK);
		lblNonum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblNonum.setOpaque(true);
		lblNonum.setBackground(Color.WHITE);
		lblNonum.setBounds(162, 5, 67, 24);
		panel_6.add(lblNonum);
		
		
		int LittleNum;
		if(onionData.get("Little")==null) {
			LittleNum=0;
		}
		else {
			LittleNum=(int)onionData.get("Little");
		}
		JLabel lblLittlenum = new JLabel(""+LittleNum);
		lblLittlenum.setForeground(Color.BLACK);
		lblLittlenum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblLittlenum.setOpaque(true);
		lblLittlenum.setBackground(Color.WHITE);
		lblLittlenum.setBounds(162, 32, 67, 24);
		panel_6.add(lblLittlenum);
		
		int LotNum;
		if(onionData.get("Lot")==null) {
			LotNum=0;
		}
		else {
			LotNum=(int)onionData.get("Lot");
		}
		JLabel lblLotnum = new JLabel(""+LotNum);
		lblLotnum.setForeground(Color.BLACK);
		lblLotnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblLotnum.setOpaque(true);
		lblLotnum.setBackground(Color.WHITE);
		lblLotnum.setBounds(162, 60, 67, 24);
		panel_6.add(lblLotnum);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(491, 137, 247, 129);
		panel_8.setBackground(new Color(244, 164, 96));
		panel_8.setLayout(null);
		contentPane.add(panel_8);
		
		JLabel lblNori = new JLabel("NORI");
		lblNori.setForeground(new Color(255, 140, 0));
		lblNori.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblNori.setOpaque(true);
		lblNori.setBackground(new Color(255, 245, 238));
		lblNori.setBounds(7, 7, 172, 24);
		panel_8.add(lblNori);
		
		JLabel lblNorinum = new JLabel(""+repo.getn_Nori());
		lblNorinum.setForeground(Color.BLACK);
		lblNorinum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblNorinum.setOpaque(true);
		lblNorinum.setBackground(Color.WHITE);
		lblNorinum.setBounds(185, 7, 55, 24);
		panel_8.add(lblNorinum);
		
		JLabel lblChashu = new JLabel("CHASHU");
		lblChashu.setForeground(new Color(255, 140, 0));
		lblChashu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblChashu.setOpaque(true);
		lblChashu.setBackground(new Color(255, 245, 238));
		lblChashu.setBounds(7, 37, 172, 24);
		panel_8.add(lblChashu);
		
		JLabel lblChashunum = new JLabel(""+repo.getn_Chashu());
		lblChashunum.setForeground(Color.BLACK);
		lblChashunum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblChashunum.setOpaque(true);
		lblChashunum.setBackground(Color.WHITE);
		lblChashunum.setBounds(185, 37, 55, 24);
		panel_8.add(lblChashunum);
		
		JLabel lblEgg = new JLabel("BOILED EGGS");
		lblEgg.setForeground(new Color(255, 140, 0));
		lblEgg.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblEgg.setOpaque(true);
		lblEgg.setBackground(new Color(255, 245, 238));
		lblEgg.setBounds(7, 67, 172, 24);
		panel_8.add(lblEgg);
		
		JLabel lblEggnum = new JLabel(""+repo.getn_Egg());
		lblEggnum.setForeground(Color.BLACK);
		lblEggnum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblEggnum.setOpaque(true);
		lblEggnum.setBackground(Color.WHITE);
		lblEggnum.setBounds(185, 67, 55, 24);
		panel_8.add(lblEggnum);
		
		JLabel lblBamboo = new JLabel("BAMBOO SHOOTS");
		lblBamboo.setForeground(new Color(255, 140, 0));
		lblBamboo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblBamboo.setOpaque(true);
		lblBamboo.setBackground(new Color(255, 245, 238));
		lblBamboo.setBounds(7, 97, 172, 24);
		panel_8.add(lblBamboo);
		
		JLabel lblBamboonum = new JLabel(""+repo.getn_Bamboo());
		lblBamboonum.setForeground(Color.BLACK);
		lblBamboonum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblBamboonum.setOpaque(true);
		lblBamboonum.setBackground(Color.WHITE);
		lblBamboonum.setBounds(185, 97, 55, 24);
		panel_8.add(lblBamboonum);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(220, 20, 60));
		panel_9.setBounds(491, 347, 358, 68);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(178, 34, 34));
		lblLevel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblLevel.setOpaque(true);
		lblLevel.setBackground(Color.WHITE);
		lblLevel.setBounds(5, 5, 106, 26);
		panel_9.add(lblLevel);
		
		JLabel lblSaleV = new JLabel("Sale Volume");
		lblSaleV.setForeground(Color.BLACK);
		lblSaleV.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblSaleV.setOpaque(true);
		lblSaleV.setBackground(Color.WHITE);
		lblSaleV.setBounds(5, 37, 106, 26);
		panel_9.add(lblSaleV);
		
		JLabel lbl0 = new JLabel("0");
		lbl0.setForeground(new Color(178, 34, 34));
		lbl0.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl0.setOpaque(true);
		lbl0.setBackground(Color.WHITE);
		lbl0.setBounds(117, 5, 34, 26);
		panel_9.add(lbl0);
		
		int ZeroNum;
		if(spiciData.get("0")==null) {
			ZeroNum=0;
		}
		else {
			ZeroNum=(int)spiciData.get("0");
		}
		JLabel lbl0V = new JLabel(""+ZeroNum);
		lbl0V.setForeground(Color.BLACK);
		lbl0V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl0V.setOpaque(true);
		lbl0V.setBackground(Color.WHITE);
		lbl0V.setBounds(117, 37, 34, 26);
		panel_9.add(lbl0V);
		
		JLabel lbl1 = new JLabel("1");
		lbl1.setForeground(new Color(178, 34, 34));
		lbl1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl1.setOpaque(true);
		lbl1.setBackground(Color.WHITE);
		lbl1.setBounds(157, 5, 34, 26);
		panel_9.add(lbl1);
		
		int OneNum;
		if(spiciData.get("1")==null) {
			OneNum=0;
		}
		else {
			OneNum=(int)spiciData.get("1");
		}
		JLabel lbl1V = new JLabel(""+OneNum);
		lbl1V.setForeground(Color.BLACK);
		lbl1V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl1V.setOpaque(true);
		lbl1V.setBackground(Color.WHITE);
		lbl1V.setBounds(157, 37, 34, 26);
		panel_9.add(lbl1V);
		
		JLabel lbl2 = new JLabel("2");
		lbl2.setForeground(new Color(178, 34, 34));
		lbl2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl2.setOpaque(true);
		lbl2.setBackground(Color.WHITE);
		lbl2.setBounds(197, 5, 34, 26);
		panel_9.add(lbl2);
		
		int TwoNum;
		if(spiciData.get("2")==null) {
			TwoNum=0;
		}
		else {
			TwoNum=(int)spiciData.get("2");
		}
		JLabel lbl2V = new JLabel(""+TwoNum);
		lbl2V.setForeground(Color.BLACK);
		lbl2V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl2V.setOpaque(true);
		lbl2V.setBackground(Color.WHITE);
		lbl2V.setBounds(197, 37, 34, 26);
		panel_9.add(lbl2V);
		
		
		JLabel lbl3 = new JLabel("3");
		lbl3.setForeground(new Color(178, 34, 34));
		lbl3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl3.setOpaque(true);
		lbl3.setBackground(Color.WHITE);
		lbl3.setBounds(237, 5, 34, 26);
		panel_9.add(lbl3);
		
		int ThreeNum;
		if(spiciData.get("3")==null) {
			ThreeNum=0;
		}
		else {
			ThreeNum=(int)spiciData.get("3");
		}
		JLabel lbl3V = new JLabel(""+ThreeNum);
		lbl3V.setForeground(Color.BLACK);
		lbl3V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl3V.setOpaque(true);
		lbl3V.setBackground(Color.WHITE);
		lbl3V.setBounds(237, 37, 34, 26);
		panel_9.add(lbl3V);
		
		JLabel lbl4 = new JLabel("4");
		lbl4.setForeground(new Color(178, 34, 34));
		lbl4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl4.setOpaque(true);
		lbl4.setBackground(Color.WHITE);
		lbl4.setBounds(277, 5, 34, 26);
		panel_9.add(lbl4);
		
		int FourNum;
		if(spiciData.get("4")==null) {
			FourNum=0;
		}
		else {
			FourNum=(int)spiciData.get("4");
		}
		JLabel lbl4V = new JLabel(""+FourNum);
		lbl4V.setForeground(Color.BLACK);
		lbl4V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl4V.setOpaque(true);
		lbl4V.setBackground(Color.WHITE);
		lbl4V.setBounds(277, 37, 34, 26);
		panel_9.add(lbl4V);
		
		JLabel lbl5 = new JLabel("5");
		lbl5.setForeground(new Color(178, 34, 34));
		lbl5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl5.setOpaque(true);
		lbl5.setBackground(Color.WHITE);
		lbl5.setBounds(317, 5, 34, 26);
		panel_9.add(lbl5);
		
		int FiveNum;
		if(spiciData.get("5")==null) {
			FiveNum=0;
		}
		else {
			FiveNum=(int)spiciData.get("5");
		}
		JLabel lbl5V = new JLabel(""+FiveNum);
		lbl5V.setForeground(Color.BLACK);
		lbl5V.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lbl5V.setOpaque(true);
		lbl5V.setBackground(Color.WHITE);
		lbl5V.setBounds(317, 37, 34, 26);
		panel_9.add(lbl5V);
				
	    int arr[]={ZeroNum, OneNum, TwoNum, ThreeNum, FourNum,FiveNum};
	    int order[]= {0,1,2,3,4,5};
	    for (int i=0;i<arr.length;i++) {
	    	for (int j=0;j<arr.length-i-1;j++) {
	            if (arr[j]>arr[j+1]){
	                int temp=arr[j+1];
	                int temp2=order[j+1];
	                arr[j+1]=arr[j];
	                order[j+1]=order[j];
	                arr[j]=temp;
	                order[j]=temp2;
	               	}
	            }
	    	}
	
	    int order2[]=new int[6];
	    int o=0;
	    int num=0;
	    for(int i=5;i>=0;i--) {
	    	if(arr[5]==arr[i]) {
	    		order2[o]=order[i];
	    		o=o+1;
	    		num=num+1;
	    	}
	    }
	    for (int i = 0; i < order2.length; i++) {
	        for (int j = 0; j < order2.length - i - 1; j++) {
	            if (order2[j] > order2[j + 1]) {
	                int temp = order2[j + 1];
	                order2[j + 1] = order2[j];
	                order2[j] = temp;
	            }
	        }
	    }
	    String popuStr=""+order2[6-num]+",";
	    for(int i=1;i<=num-1;i++) {
	    	popuStr=popuStr+order2[6-num+i]+",";
	    }
	    popuStr= popuStr.substring(0,popuStr.length()-1);
		JLabel lblTheMostPopular = new JLabel("The most popular level is "+popuStr);
		lblTheMostPopular.setForeground(new Color(178, 34, 34));
		lblTheMostPopular.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		lblTheMostPopular.setBackground(new Color(255, 140, 0));
		lblTheMostPopular.setBounds(491, 446, 364, 33);
		contentPane.add(lblTheMostPopular);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportPanel window=new ReportPanel(tt,sched);
				dispose();
			}
		});
		btnNext.setBounds(807, 538, 113, 33);
		contentPane.add(btnNext);
		
		JButton btnSendReport = new JButton("Send Report");
		btnSendReport.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		btnSendReport.setBounds(170, 446, 181, 46);
		btnSendReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String To="844702734@qq.com";
			    SendMail.sendRepo(To);
			    SendSuccess s=new SendSuccess();	
			}
		});
		contentPane.add(btnSendReport);
		
		JLabel lblNoodleSalesTable = new JLabel("Noodle Sales Table ");
		lblNoodleSalesTable.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		lblNoodleSalesTable.setBounds(85, 116, 266, 18);
		contentPane.add(lblNoodleSalesTable);
		
		JLabel lblAddonSalesTable = new JLabel("Add-on Sales Table");
		lblAddonSalesTable.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		lblAddonSalesTable.setBounds(453, 105, 271, 18);
		contentPane.add(lblAddonSalesTable);
		
		JLabel lblSpicinessSalesTable = new JLabel("Spiciness Sales Table");
		lblSpicinessSalesTable.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		lblSpicinessSalesTable.setBounds(453, 306, 271, 18);
		contentPane.add(lblSpicinessSalesTable);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 21));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Management m=new Management(tt,sched);
				dispose();
			}
		});
		btnBack.setBounds(50, 538, 113, 33);
		contentPane.add(btnBack);
		
		
	}
}
