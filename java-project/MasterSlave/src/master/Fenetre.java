package master;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.EmployerDAO;
import model.Employer;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;

	
	/**
	 * Create the application.
	 */
	public Fenetre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1018, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 982, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Base", "base", "base"}));
		comboBox.setBounds(383, 11, 115, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(508, 11, 115, 20);
		panel.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"table"}));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Modifier/Suprimer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 62, 543, 404);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 24, 523, 369);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		
		Vector col=null;
		 Vector row=null;
		JButton btnModifier = new JButton("MODIFIER");
		try {
			 col = EmployerDAO.GetColumn("slave1");
			row = EmployerDAO.GetRows("slave1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(row,col); //COLONE ET LIGNE DE LA TABLE
		//bouton dans la table
		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRender());
		table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField(), table));
		table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRender());
		table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JTextField(), table));
		//SCROLL BAR HORIZONTAL ET VERTICAL
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 11, 503, 347);
		panel_1.add(scrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//*********************************************//
		scrollPane.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setMinWidth(65);
		table.getColumnModel().getColumn(1).setMinWidth(65);
		table.getColumnModel().getColumn(2).setMinWidth(65);
		table.getColumnModel().getColumn(3).setMinWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(74);
		table.getColumnModel().getColumn(4).setMinWidth(78);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setMinWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		 
		
		System.out.println(col);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ajouter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(563, 62, 429, 404);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(10, 23, 409, 370);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNom = new JLabel("NOM:");
		lblNom.setBounds(10, 11, 46, 14);
		panel_5.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(158, 8, 226, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM:");
		lblPrenom.setBounds(10, 51, 156, 14);
		panel_5.add(lblPrenom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 48, 226, 20);
		panel_5.add(textField_1);
		
		JLabel lblAdresse = new JLabel("ADRESSE:");
		lblAdresse.setBounds(10, 93, 156, 14);
		panel_5.add(lblAdresse);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 90, 226, 20);
		panel_5.add(textField_2);
		
		JLabel lblDateDeNaissance = new JLabel("DATE DE NAISSANCE:");
		lblDateDeNaissance.setBounds(10, 142, 156, 14);
		panel_5.add(lblDateDeNaissance);
		
		
		
		
		JComboBox comboBox_3 = new JComboBox();
		JComboBox comboBox_2 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() { ///BOX MOIS
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(Fonction.getMonthNumber((String) comboBox_3.getSelectedItem()));
				//System.out.println(Fonction.GetDayByMonth("Mars"));
				//comboBox_2.setModel(new DefaultComboBoxModel(Fonction.GetDayByMonth((String) comboBox_3.getSelectedItem())));
				Vector daymonth = Fonction.GetDayByMonth((String)comboBox_3.getSelectedItem());
				if(daymonth!=null) {
					comboBox_2.setModel(new DefaultComboBoxModel(daymonth));
				}
				
			}
		});
		
		comboBox_3.setModel(new DefaultComboBoxModel(Fonction.GetMonth()));
		comboBox_3.setBounds(158, 136, 96, 20);
		panel_5.add(comboBox_3);
		
		
		comboBox_2.addActionListener(new ActionListener() { //BOX JOUR
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(Fonction.GetDay()));
		comboBox_2.setBounds(264, 136, 47, 20);
		panel_5.add(comboBox_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(321, 136, 63, 20);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label = new JLabel();
		label.setBounds(158, 166, 226, 14);
		panel_5.add(label);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println((String)comboBox_3.getSelectedItem());
				Employer emp = new Employer();
				emp.setNom(textField.getText());
				emp.setPrenom(textField_1.getText());
				emp.setAdresse(textField_2.getText());
				System.out.println(comboBox_2.getSelectedItem());
				int month = Fonction.getMonthNumber((String) comboBox_3.getSelectedItem());
				int day = (int) comboBox_2.getSelectedItem();
				String years =  textField_5.getText();
				String notif = Fonction.FormInsert(emp, month, day, years);
				
				if(notif!="OK") {
					label.setText(notif);
				} else {
					
					emp.setDatenaissance(years+"-"+month+"-"+day);
					System.out.println(emp.getNom()+emp.getPrenom()+emp.getAdresse()+emp.getDatenaissance());
					try {
						EmployerDAO.insert("slave1",emp);
						label.setText("Donner ajouter");
						setModelTable();
					
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//String datenaissance = years+"-"+month+"-"+day;
				//System.out.println(datenaissance);
			}
		});
		btnAjouter.setBounds(158, 191, 130, 23);
		panel_5.add(btnAjouter);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 477, 982, 41);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnSynchroniser = new JButton("SYNCHRONISER");
		btnSynchroniser.setBounds(434, 11, 130, 23);
		panel_4.add(btnSynchroniser);
		
		frame.setVisible(true);
	} 
	public void setModelTable() {
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		Vector col=null;
		 Vector row=null;
		try {
			 col = EmployerDAO.GetColumn("slave1");
			row = EmployerDAO.GetRows("slave1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    tmodel.setDataVector(row,col);
		    table.setModel(tmodel);
		    table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRender());
			table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField(), table));
			table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRender());
			table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JTextField(), table));
		
	}
}
