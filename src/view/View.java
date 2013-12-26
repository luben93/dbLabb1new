package view;

//public class View {
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import controller.DatabaseErrorExecption;
import controller.NullValueExecption;

public class View extends JFrame {

	private JPanel contentPane;
	private int BoxOptionSelected;
	private int searchChoice;
	private String value = null;
	private JTable table;
	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { WindiwBuilderTest frame = new
	 * WindiwBuilderTest(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public View(final controller.DatabaseConnection dri) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
		      @Override
		      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		         //dont forget to 
		       //System.out.println("goodbye");
		          dri.terminateCon();    
		       System.exit(0);
		          
		      }
		  });
		
		final JButton add = new JButton("Add record");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add.setBounds(36, 202, 108, 23);
		contentPane.add(add);

		final JButton search = new JButton("Search");
		search.setBounds(181, 202, 89, 23);
		contentPane.add(search);

		final JButton rate = new JButton("Rate");
		rate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rate.setBounds(312, 202, 89, 23);
		contentPane.add(rate);

		final String[] BoxOptions = { "Rock", "Opera", "Classic", "r&b", "Rap",
				"New Age", "Nightclub" };
		final JComboBox comboBox = new JComboBox(BoxOptions);
		comboBox.setBounds(36, 126, 102, 23);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					BoxOptionSelected = comboBox.getSelectedIndex();
				}
			}
		});

		contentPane.add(comboBox);

		final JLabel textArea = new JLabel("Genre");
		textArea.setBounds(154, 127, 47, 21);
		contentPane.add(textArea);

		final JLabel textArea2 = new JLabel("Artist");
		textArea2.setBounds(154, 76, 47, 21);
		contentPane.add(textArea2);

		final JTextArea artist = new JTextArea();
		artist.setBounds(36, 74, 89, 23);
		contentPane.add(artist);

		final JLabel textArea3 = new JLabel("Album");
		textArea3.setBounds(154, 26, 89, 21);
		contentPane.add(textArea3);

		final JTextArea song = new JTextArea();
		song.setBounds(36, 24, 89, 23);
		contentPane.add(song);

		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(36, 168, 89, 23);
		contentPane.add(btnSubmit);

		final JButton btnMenu = new JButton("Cancel");
		btnMenu.setBounds(181, 168, 89, 23);
		contentPane.add(btnMenu);

		final JButton ArtistButton = new JButton("Artist");
		ArtistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ArtistButton.setBounds(219, 25, 89, 23);
		contentPane.add(ArtistButton);

		final JButton TitleButton = new JButton("Album");
		TitleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TitleButton.setBounds(312, 25, 89, 23);
		contentPane.add(TitleButton);

		final JButton GenreButton = new JButton("Genre");
		GenreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GenreButton.setBounds(219, 94, 89, 23);
		contentPane.add(GenreButton);

		final JButton RatingButton = new JButton("Rating");
		RatingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RatingButton.setBounds(312, 94, 89, 23);
		contentPane.add(RatingButton);

		final JTextArea ArtistTextSearch = new JTextArea();
		ArtistTextSearch.setBounds(219, 60, 89, 23);
		contentPane.add(ArtistTextSearch);

		final JTextArea TitleTextSearch = new JTextArea();
		TitleTextSearch.setBounds(312, 60, 89, 23);
		contentPane.add(TitleTextSearch);

		final JTextArea GenreTextSearch = new JTextArea();
		GenreTextSearch.setBounds(219, 124, 89, 23);
		contentPane.add(GenreTextSearch);

		final JTextArea RatingTextSearch = new JTextArea();
		RatingTextSearch.setBounds(312, 124, 89, 23);
		contentPane.add(RatingTextSearch);

		final JButton SubmitSearch = new JButton("Sumbit");
		SubmitSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubmitSearch.setBounds(280, 168, 89, 23);
		contentPane.add(SubmitSearch);
		
		final String[] BoxOptions_1 = { "","Worst", "Bad", "Okey", "Good", "Best"};
		final JComboBox comboBox_1 = new JComboBox(BoxOptions_1);
		comboBox_1.setBounds(357, 11, 77, 20);
		contentPane.add(comboBox_1);
		
		final JButton SubmitRate = new JButton("Submit");
		SubmitRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		SubmitRate.setBounds(345, 75, 89, 23);
		contentPane.add(SubmitRate);
		
		final JLabel AddNewArtistToAlbum = new JLabel("Add another artist to the album ?");
		AddNewArtistToAlbum.setBounds(36, 38, 339, 27);
		contentPane.add(AddNewArtistToAlbum);
		
		final JButton Yes = new JButton("Yes");
		Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Yes.setBounds(46, 94, 89, 23);
		contentPane.add(Yes);
		
		final JButton No = new JButton("No");
		No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		No.setBounds(164, 94, 89, 23);
		contentPane.add(No);
		
		final JButton SubmitNewArtist = new JButton("Submit");
		SubmitNewArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubmitNewArtist.setBounds(78, 108, 89, 23);
		contentPane.add(SubmitNewArtist);
		
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					BoxOptionSelected = comboBox_1.getSelectedIndex();
				}
			}
		});
		
		
		textArea.setVisible(false);
		comboBox.setVisible(false);
		textArea2.setVisible(false);
		artist.setVisible(false);
		textArea3.setVisible(false);
		song.setVisible(false);
		btnMenu.setVisible(false);
		btnSubmit.setVisible(false);
		ArtistButton.setVisible(false);
		TitleButton.setVisible(false);
		GenreButton.setVisible(false);
		RatingButton.setVisible(false);
		ArtistTextSearch.setVisible(false);
		RatingTextSearch.setVisible(false);
		TitleTextSearch.setVisible(false);
		GenreTextSearch.setVisible(false);
		SubmitSearch.setVisible(false);
		comboBox_1.setVisible(false);
		SubmitRate.setVisible(false);
		AddNewArtistToAlbum.setVisible(false);
		Yes.setVisible(false);
		No.setVisible(false);
		SubmitNewArtist.setVisible(false);


		rate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setVisible(false);
				search.setVisible(false);
				rate.setVisible(false);
				
				//TODO RATE
				try {
					dri.selectAll();
				} catch (DatabaseErrorExecption e1) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Database error. ( " + e.toString());
					e1.printStackTrace();
				}
				
				Object[][] data =new Object[dri.getLatestQueryResults().size()][4];
				data[0]=new Object[] {"Album","Genre","Rating","Artist"};
			    for(int i=1; i<dri.getLatestQueryResults().size();i++){

			            	data[i][0]=dri.getLatestQueryResults().get(i-1).getAlbum();
			            	data[i][1]=dri.getLatestQueryResults().get(i-1).getGenre();
			            	data[i][2]=dri.getLatestQueryResults().get(i-1).getRating();
			            	data[i][3]=dri.getLatestQueryResults().get(i-1).getArtist();
			    }
			    
				
			    table = new JTable(data,
			    		new Object[] { "Album","Genre","Rating","Artist" }
			    		);
				table.setBounds(0, 0, 347, 262);
				contentPane.add(table);
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			        public void valueChanged(ListSelectionEvent event) {
			           value =  table.getValueAt(table.getSelectedRow(), 0).toString();
			        }
			    });
				
				table.setVisible(true);
				comboBox_1.setVisible(true);
				SubmitRate.setVisible(true);
			}
		});

		
		SubmitRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				
				
				try {
					dri.updateRating(BoxOptions_1[BoxOptionSelected], value);
				} catch (DatabaseErrorExecption e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Database error. ( " + e.toString());
					e.printStackTrace();
				}
				table.setVisible(false);
				comboBox_1.setVisible(false);
				SubmitRate.setVisible(false);
				
				add.setVisible(true);
				search.setVisible(true);
				rate.setVisible(true);
			}
		});
		
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				add.setVisible(false);
				search.setVisible(false);
				rate.setVisible(false);
				comboBox.setVisible(true);
				textArea.setVisible(true);
				textArea2.setVisible(true);
				artist.setVisible(true);
				textArea3.setVisible(true);
				song.setVisible(true);
				btnMenu.setVisible(true);
				btnSubmit.setVisible(true);
			}
		});

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// TODO TRANSAKTION. KLAR
				try {
					dri.AddTransaction(artist.getText(), song.getText(),
							BoxOptions[BoxOptionSelected]);
				} catch (NullValueExecption e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Fill in Album and Artist. ( " + e.toString());
					e.printStackTrace();
				} catch (DatabaseErrorExecption e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Database error. ( " + e.toString());
					e.printStackTrace();
				}

				textArea.setVisible(false);
				comboBox.setVisible(false);
				textArea2.setVisible(false);
				artist.setVisible(false);
				textArea3.setVisible(false);
				song.setVisible(false);
				btnMenu.setVisible(false);
				btnSubmit.setVisible(false);
				AddNewArtistToAlbum.setVisible(true);
				Yes.setVisible(true);
				No.setVisible(true);
				
				
			}
		});
		
		No.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				AddNewArtistToAlbum.setVisible(false);
				Yes.setVisible(false);
				No.setVisible(false);
				add.setVisible(true);
				search.setVisible(true);
				rate.setVisible(true);
			}
		});
		
		Yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				No.setVisible(false);
				Yes.setVisible(false);
				textArea2.setVisible(true);
				artist.setVisible(true);
				SubmitNewArtist.setVisible(true);
			}
		});
		
		SubmitNewArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				textArea2.setVisible(false);
				artist.setVisible(false);
				SubmitNewArtist.setVisible(false);
				No.setVisible(true);
				Yes.setVisible(true);
				
				//TODO ADD NEW ANOTHER ARTIST TO THE ALBUM. LAGRAD PROCEDUR. KLAR
				
				try {
					dri.AddAnotherArtistToAlbum(artist.getText(), song.getText());
				} catch (NullValueExecption e) {
					javax.swing.JOptionPane.showMessageDialog(null,
					"Fill in Artist. ( " + e.toString());
					e.printStackTrace();
				} catch (DatabaseErrorExecption e) {
					javax.swing.JOptionPane.showMessageDialog(null,
					"No rights... paska! ( " + e.toString());
					e.printStackTrace();
				}
				
			}
		});
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				add.setVisible(true);
				search.setVisible(true);
				rate.setVisible(true);
				textArea.setVisible(false);
				comboBox.setVisible(false);
				textArea2.setVisible(false);
				artist.setVisible(false);
				textArea3.setVisible(false);
				song.setVisible(false);
				btnMenu.setVisible(false);
				btnSubmit.setVisible(false);
			}
		});

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				add.setVisible(false);
				search.setVisible(false);
				rate.setVisible(false);
				ArtistButton.setVisible(true);
				TitleButton.setVisible(true);
				GenreButton.setVisible(true);
				RatingButton.setVisible(true);
			}
		});

		ArtistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ArtistTextSearch.setVisible(true);
				TitleTextSearch.setVisible(false);
				GenreTextSearch.setVisible(false);
				RatingTextSearch.setVisible(false);
				SubmitSearch.setVisible(true);
				searchChoice = 1;
			}
		});
		TitleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ArtistTextSearch.setVisible(false);
				TitleTextSearch.setVisible(true);
				GenreTextSearch.setVisible(false);
				RatingTextSearch.setVisible(false);
				SubmitSearch.setVisible(true);
				searchChoice = 2;
			}
		});
		GenreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ArtistTextSearch.setVisible(false);
				TitleTextSearch.setVisible(false);
				GenreTextSearch.setVisible(true);
				RatingTextSearch.setVisible(false);
				SubmitSearch.setVisible(true);
				searchChoice = 3;
			}
		});
		RatingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ArtistTextSearch.setVisible(false);
				TitleTextSearch.setVisible(false);
				GenreTextSearch.setVisible(false);
				RatingTextSearch.setVisible(true);
				SubmitSearch.setVisible(true);
				searchChoice = 4;
			}
		});

		SubmitSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if (searchChoice == 1) {
					System.out.println(ArtistTextSearch.getText());
					ArtistTextSearch.setVisible(false);
					try {
						dri.Search("artist", ArtistTextSearch.getText(), "album");
					} catch (DatabaseErrorExecption e) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Databse error. ( " + e.toString());
						e.printStackTrace();
					}
					
					JTableModel model = new JTableModel(dri.getLatestQueryResults());
					
				}
				// *TODO
				if (searchChoice == 2) {
					System.out.println(TitleTextSearch.getText());
					TitleTextSearch.setVisible(false);
					try {
						dri.Search("albumid", TitleTextSearch.getText(), "album");
					} catch (DatabaseErrorExecption e) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Databse error. ( " + e.toString());
						e.printStackTrace();
					}
					
					JTableModel model = new JTableModel(dri.getLatestQueryResults());
				}
				// *TODO
				if (searchChoice == 3) {
					System.out.println(GenreTextSearch.getText());
					GenreTextSearch.setVisible(false);
					try {
						dri.Search("genre", GenreTextSearch.getText(), "album");
					} catch (DatabaseErrorExecption e) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Databse error. ( " + e.toString());
						e.printStackTrace();
					}
					
					JTableModel model = new JTableModel(dri.getLatestQueryResults());
				}
				// *TODO
				if (searchChoice == 4) {
					System.out.println(RatingTextSearch.getText());
					RatingTextSearch.setVisible(false);
					try {
						dri.Search("rating", RatingTextSearch.getText(), "album");
					} catch (DatabaseErrorExecption e) {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Databse error. ( " + e.toString());
						e.printStackTrace();
					}
					
					JTableModel model = new JTableModel(dri.getLatestQueryResults());
				}

				add.setVisible(true);
				search.setVisible(true);
				rate.setVisible(true);
				ArtistButton.setVisible(false);
				TitleButton.setVisible(false);
				GenreButton.setVisible(false);
				RatingButton.setVisible(false);
				SubmitSearch.setVisible(false);

			}
		});
	}
}
