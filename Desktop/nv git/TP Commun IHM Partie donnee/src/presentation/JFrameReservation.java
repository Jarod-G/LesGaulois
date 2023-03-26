package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import com.github.lgooddatepicker.components.DatePicker;

import dialog.DialogueReservation;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;


public class JFrameReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDateTime;
	private JLabel lblChooseDate;
	private JLabel lblChooseTime;
	private JPanel panelNumofPersons;
	private JLabel lblNumofPersons;
	private DatePicker datePicker;
	private JPanel panelTable;
	private JLabel lblTableMap;
	private JButton btnValidate;
	private JPanel panelConfirmCancel;
	private DialogueReservation dialogueReservation;
	private JComboBox jcb_nbPersonne;
	private JComboBox jcb_time;
	


	/**
	 * Create the frame.
	 */
	public JFrameReservation() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		setTitle("R\u00E9servez une table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDateTime = new JPanel();
		
		panelNumofPersons = new JPanel();
		
		panelTable = new JPanel();
		
		panelConfirmCancel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelConfirmCancel, 0, 0, Short.MAX_VALUE)
						.addComponent(panelTable, 0, 0, Short.MAX_VALUE)
						.addComponent(panelDateTime, GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE)
						.addComponent(panelNumofPersons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDateTime, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(panelNumofPersons, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelConfirmCancel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblTableMap = new JLabel("");
		lblTableMap.setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		
		JLabel lblChoisissezVotre = new JLabel("3. Choisissez votre table");
		lblChoisissezVotre.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		listTables = new JList();
		listTables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnValidate.setEnabled(true);
			}
		});
		listTables.setModel(new AbstractListModel() {
			String[] values = new String[] {"TABLE 1", "TABLE 2", "TABLE 3", "TABLE 4", "TABLE 5", "TABLE 6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(listTables, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblChoisissezVotre, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelTable.setVerticalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTable.createSequentialGroup()
					.addGap(10)
					.addComponent(lblChoisissezVotre, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelTable.createParallelGroup(Alignment.TRAILING)
						.addComponent(listTables, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
						.addComponent(lblTableMap, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelTable.setLayout(gl_panelTable);
		
		
		btnValidate = new JButton("Valider");
		btnValidate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String timeS = (String) jcb_time.getSelectedItem();
				String nbPersonneS = (String) jcb_nbPersonne.getSelectedItem();
				String dateS = (String) datePicker.getDateStringOrEmptyString();
				int nbTable = listTables.getSelectedIndex() + 1;

				enableValidationInformation(dateS,timeS,nbPersonneS,nbTable);
				
				
			}
		});
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initPresentation();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_panelConfirmCancel = new GroupLayout(panelConfirmCancel);
		gl_panelConfirmCancel.setHorizontalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(btnValidate)
					.addGap(20)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelConfirmCancel.setVerticalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panelConfirmCancel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValidate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelConfirmCancel.setLayout(gl_panelConfirmCancel);
		
		lblNumofPersons = new JLabel("2. Indiquez le nombre de personnes");
		lblNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		String[] s2 = {"2","3","4","5","6","7","8"};
		jcb_nbPersonne = new JComboBox(s2);
		jcb_nbPersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				do_itemStateChangedNbP(e1);
			}
		});
		
		
		GroupLayout gl_panelNumofPersons = new GroupLayout(panelNumofPersons);
		gl_panelNumofPersons.setHorizontalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGroup(gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(31)
							.addComponent(jcb_nbPersonne, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panelNumofPersons.setVerticalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jcb_nbPersonne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panelNumofPersons.setLayout(gl_panelNumofPersons);
		
		lblChooseDate = new JLabel("1. Choisissez la date");
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblChooseTime = new JLabel("et l'heure");
		lblChooseTime.setEnabled(false);
		lblChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		datePicker = new DatePicker();
		datePicker.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent arg0) {
				do_datePicker_dateChanged(arg0);
			}
		});

		jcb_time = new JComboBox();
		jcb_time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				do_itemStateChangedTime(e);
			}
		});
		jcb_time.setModel(new DefaultComboBoxModel(new String[] {"12h00", "12h30", "13h00", "19h30", "20h00", "20h30"}));
		


		
		// DATE
		GroupLayout gl_panelDateTime = new GroupLayout(panelDateTime);
		gl_panelDateTime.setHorizontalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(27)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(jcb_time, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(10)
							.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_panelDateTime.setVerticalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(jcb_time, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		panelDateTime.setLayout(gl_panelDateTime);
		contentPane.setLayout(gl_contentPane);

	}
	
	public void initPresentation() {
		lblChooseDate.setEnabled(true);
		datePicker.setEnabled(true);
		
		lblChooseTime.setEnabled(false);
		jcb_time.setEnabled(false);
		
		lblNumofPersons.setEnabled(false);
		jcb_nbPersonne.setEnabled(false);
		
		lblTableMap.setEnabled(false);
		listTables.setEnabled(false);
		
		
		btnValidate.setEnabled(false);
		
		System.out.println("InitPresentation done");
	}
	
	public void enableTime() {
		lblChooseTime.setEnabled(true);
		jcb_time.setEnabled(true);
		
		
	}
	
	public void enableNumofPersons() {
		lblNumofPersons.setEnabled(true);
		jcb_nbPersonne.setEnabled(true);
		
	}
	
	public void enableTableMap() {
		listTables.setEnabled(true);
		lblTableMap.setEnabled(true);
		
	}
	
	private JList listTables;
	
	public void enableValidationInformation(String date, String time, String numPersons, int numTable) {
		int choix = JOptionPane.showConfirmDialog(this,"Réservation confirmé le " + date + " à " + time + " pour " + numPersons + " personnes à la table " + numTable, "Confirmation de réservation", JOptionPane.OK_OPTION);
	}
	

	
//Record reference to Dialogue
	
	public void setDialogue(DialogueReservation dialogReservation) {
		dialogueReservation = dialogReservation;
	}
	
	protected void do_itemStateChangedTime(ActionEvent e)
    {
		enableNumofPersons();
		
    }
	
	protected void do_itemStateChangedNbP(ActionEvent e1)
    {
		enableTableMap();
    }
	
	
	protected void do_datePicker_dateChanged(DateChangeEvent arg0) {
		enableTime();
	}
	
}
