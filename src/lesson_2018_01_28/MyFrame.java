package lesson_2018_01_28;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	String[] arr = 
			new String[] {"1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5"};
	
	DefaultListModel<String> lst =
			new DefaultListModel<>();
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					MyFrame frame = new MyFrame();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private  Controller c;
	private  DefaultListModel<String> dlm;
	private  int selectedRow;
	private JPopupMenu jpm = new JPopupMenu("pop");
	
	public MyFrame() {
				
		dlm = new DefaultListModel<>();
		c = new Controller(dlm);
		
		lst = new DefaultListModel<>();
		
		JMenuItem item  = new JMenuItem("Delete");
		jpm.add(item);
		
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				c.deleteItem(selectedRow);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sizeWidth =450;
		int sizeHeight = 300;
		int locY =(screenSize.width - sizeWidth) /2;
		int locX = (screenSize.height - sizeHeight) /2;
		
		setBounds(locX, locY, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);
		
		
		
		JMenuItem mntmAdd = new JMenuItem("add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MyJDialog(c);
				
				
			}
		});
		menu.add(mntmAdd);
		
		
		
		JMenuItem mntmItem = new JMenuItem("exit");
		
		mntmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.exit(0); // terminate the whole process
				dispose();// close current window
			}
		});
		
		menu.add(mntmItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(219, 32, 91, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 199, 230);
		contentPane.add(scrollPane);
		lst.addElement("Hello");
		
		
		JList list = new JList(c.getDlm());
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.out.println(e);
					if(e.getButton() == 3) {
						System.out.println("right");
						
					JList<String> list1 = (JList<String>)e.getComponent();
					selectedRow = list1.locationToIndex(e.getPoint());
					list1.setSelectedIndex(selectedRow);
					jpm.show(e.getComponent(), e.getX(), e.getY());
					
					}
			}
		});
		
				
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
	}
}
