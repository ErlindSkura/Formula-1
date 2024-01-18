package com.application.formula1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formula1MenaxhimKampionati implements MenaxhimKampionati {

	public void menaxhoKampionat(final JPanel panel) {

		panel.setLayout(null);

		JLabel prezantim = new JLabel("Zgjidhni veprimin qe doni te kryeni");
		prezantim.setBounds(300, 50, 300, 80);
		panel.add(prezantim);

		// shto
		JButton shtoShofer = new JButton("Shto shofer");
		shtoShofer.setBounds(200, 110, 200, 50);
		shtoShofer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Shto shofer te ri");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);

				JLabel emri = new JLabel("Emri:");
				emri.setBounds(10, 20, 80, 25);
				panel.add(emri);
				final JTextField shkruajEmrin = new JTextField(20);
				shkruajEmrin.setBounds(100, 20, 150, 25);
				panel.add(shkruajEmrin);

				JLabel skuadra = new JLabel("Skuadra:");
				skuadra.setBounds(10, 50, 80, 65);
				panel.add(skuadra);
				final JTextField shkruajSkuadren = new JTextField(20);
				shkruajSkuadren.setBounds(100, 70, 150, 25);
				panel.add(shkruajSkuadren);

				JLabel vendndodhja = new JLabel("Vendndodhja");
				vendndodhja.setBounds(10, 80, 80, 105);
				panel.add(vendndodhja);
				final JTextField shkruajVendndodhja = new JTextField(20);
				shkruajVendndodhja.setBounds(100, 120, 150, 25);
				panel.add(shkruajVendndodhja);

				JButton shto = new JButton("Shto");
				shto.setBounds(100, 170, 150, 25);
				shto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel mesazhi = new JLabel();
						try {
							String label = DataSaver.shtoShofer(shkruajEmrin.getText(), shkruajSkuadren.getText(),
									shkruajVendndodhja.getText());
							mesazhi = new JLabel(label);
							mesazhi.setBounds(10, 320, 450, 55);
						} catch (Exception exp) {
							mesazhi = new JLabel("Regjistrimi nuk mund te kryhet. Kujdes ne plotesimin e te dhenave!");
							mesazhi.setBounds(10, 320, 450, 55);
						}
						mesazhi.setVisible(true);
						panel.add(mesazhi);
						;

					}
				});
				panel.add(shto);
			}
		});

		panel.add(shtoShofer);

		// fshi
		JButton hiqShofer = new JButton("Fshi shofer");
		hiqShofer.setBounds(200, 180, 200, 50);
		hiqShofer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Fshi shofer");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);

				JLabel emri = new JLabel("Emri:");
				emri.setBounds(10, 20, 80, 25);
				panel.add(emri);
				final JTextField shkruajEmrin = new JTextField(20);
				shkruajEmrin.setBounds(100, 20, 150, 25);
				panel.add(shkruajEmrin);

				JLabel skuadra = new JLabel("Skuadra:");
				skuadra.setBounds(10, 50, 80, 65);
				panel.add(skuadra);
				final JTextField shkruajSkuadren = new JTextField(20);
				shkruajSkuadren.setBounds(100, 70, 150, 25);
				panel.add(shkruajSkuadren);

				JButton fshi = new JButton("Fshi");
				fshi.setBounds(100, 170, 150, 25);
				fshi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel mesazhi = new JLabel();
						try {
							String label = DataSaver.fshijShofer(shkruajEmrin.getText(), shkruajSkuadren.getText());
							mesazhi = new JLabel(label);
							mesazhi.setBounds(10, 320, 450, 55);
						} catch (Exception exp) {
							exp.printStackTrace();
							mesazhi = new JLabel("Fshirja nuk mund te kryhet. Kujdes ne plotesimin e te dhenave!");
							mesazhi.setBounds(10, 320, 450, 55);
						}
						mesazhi.setVisible(true);
						panel.add(mesazhi);
						;

					}
				});
				panel.add(fshi);

			}
		});
		panel.add(hiqShofer);

		// ndrysho skuader
		JButton ndryshoShofer = new JButton("Ndrysho skuader");
		ndryshoShofer.setBounds(200, 250, 200, 50);
		ndryshoShofer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Ndrysho skuader");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);

				JLabel emri = new JLabel("Emri:");
				emri.setBounds(10, 20, 80, 25);
				panel.add(emri);
				final JTextField shkruajEmrin = new JTextField(20);
				shkruajEmrin.setBounds(100, 20, 150, 25);
				panel.add(shkruajEmrin);

				JLabel skuadra = new JLabel("Skuadra:");
				skuadra.setBounds(10, 50, 80, 65);
				panel.add(skuadra);
				final JTextField shkruajSkuadren = new JTextField(20);
				shkruajSkuadren.setBounds(100, 70, 150, 25);
				panel.add(shkruajSkuadren);

				JButton fshi = new JButton("Ndrysho");
				fshi.setBounds(100, 170, 150, 25);
				fshi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel mesazhi = new JLabel();
						try {
							String label = DataSaver.ndryshoSkuader(shkruajEmrin.getText(), shkruajSkuadren.getText());
							mesazhi = new JLabel(label);
							mesazhi.setBounds(10, 320, 450, 55);
						} catch (Exception exp) {
							exp.printStackTrace();
							mesazhi = new JLabel("Ndryshimi nuk mund te kryhet. Kujdes ne plotesimin e te dhenave!");
							mesazhi.setBounds(10, 320, 450, 55);
						}
						mesazhi.setVisible(true);
						panel.add(mesazhi);
						;

					}
				});
				panel.add(fshi);
			}
		});
		panel.add(ndryshoShofer);

		// statistika
		JButton statistikaShoferi = new JButton("Statistika per nje shofer");
		statistikaShoferi.setBounds(200, 320, 200, 50);
		statistikaShoferi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Statistika per nje shofer");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);

				JLabel emri = new JLabel("Emri:");
				emri.setBounds(10, 20, 80, 25);
				panel.add(emri);
				final JTextField shkruajEmrin = new JTextField(20);
				shkruajEmrin.setBounds(100, 20, 150, 25);
				panel.add(shkruajEmrin);

				JButton statistika = new JButton("Kerko statistika");
				statistika.setBounds(100, 170, 150, 25);
				statistika.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel mesazhi = new JLabel();
						try {
							String label = DataSaver.statistika(shkruajEmrin.getText());
							mesazhi = new JLabel(label);
							mesazhi.setBounds(10, 320, 650, 55);
						} catch (Exception exp) {
							exp.printStackTrace();
							mesazhi = new JLabel("Kujdes ne plotesimin e te dhenave!");
							mesazhi.setBounds(10, 320, 450, 55);
						}
						mesazhi.setVisible(true);
						panel.add(mesazhi);

					}
				});
				panel.add(statistika);
			}
		});
		panel.add(statistikaShoferi);
		

		JButton renditjaAktuale = new JButton("Kampionati aktual");
		renditjaAktuale.setBounds(200, 390, 200, 50);
		statistikaShoferi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(renditjaAktuale);

		// shto rezultate
		JButton shtoRezultate = new JButton("Shto Rezultate");
		shtoRezultate.setBounds(200, 460, 200, 50);
		shtoRezultate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					DataSaver.writeFile();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				JLabel mesazhi = new JLabel("Te dhenat u perditesuan me sukses!");
				mesazhi.setBounds(10, 700, 650, 55);
				mesazhi.setVisible(true);
				panel.add(mesazhi);
			}
		});
		panel.add(shtoRezultate);
        
		//rendit sipas pikeve
		JButton listoSipasPikeve = new JButton("Listo shoferet sipas pikeve");
		listoSipasPikeve.setBounds(600, 110, 200, 50);
		listoSipasPikeve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Listo shoferet sipas pikeve");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);
				JButton rendit = new JButton("Rendit shoferet");
				rendit.setBounds(10, 50, 150, 25);
				rendit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Set<String> lista = new HashSet<String>();
						JLabel mesazhi = new JLabel();
						try {
							lista = DataSaver.renditSipasPikeve();
						} catch (Exception exp) {
							exp.printStackTrace();
						}
						mesazhi = new JLabel(lista.toString());
						mesazhi.setBounds(10, 65, 1000, 55);
						mesazhi.setVisible(true);
						panel.add(mesazhi);
					}
				});
				panel.add(rendit);

			}
		});
		panel.add(listoSipasPikeve);

		// rendit sipas fitoreve
		JButton listoSipasFitoreve = new JButton("Listo shoferet sipas fitoreve");
		listoSipasFitoreve.setBounds(600, 180, 200, 50);
		listoSipasFitoreve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Listo shoferet sipas fitoreve");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);
				JButton rendit = new JButton("Rendit shoferet");
				rendit.setBounds(10, 50, 150, 25);
				rendit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Set<String> lista = new HashSet<String>();
						JLabel mesazhi = new JLabel();
						try {
							lista = DataSaver.renditSipasFitoreve();
						} catch (Exception exp) {
							exp.printStackTrace();
						}
						mesazhi = new JLabel(lista.toString());
						mesazhi.setBounds(10, 65, 1000, 55);
						mesazhi.setVisible(true);
						panel.add(mesazhi);
					}
				});
				panel.add(rendit);

			}
		});
		panel.add(listoSipasFitoreve);

		
		JButton shfaqGarat = new JButton("Listo garat");
		shfaqGarat.setBounds(600, 250, 200, 50);
		shfaqGarat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Listo garat e sezonit");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);
				JButton listo = new JButton("Listo");
				listo.setBounds(10, 50, 150, 25);
				listo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Set<String> lista = new HashSet<String>();
						JLabel mesazhi = new JLabel();
						try {
							lista = DataSaver.listoGarat();
						} catch (Exception exp) {
							exp.printStackTrace();
						}
						mesazhi = new JLabel(lista.toString());
						mesazhi.setBounds(10, 65, 1500, 55);
						mesazhi.setVisible(true);
						panel.add(mesazhi);
					}
				});
				panel.add(listo);

			}
		});
		panel.add(shfaqGarat);

		JButton shfaqGaraShoferi = new JButton("Listo garat e nje shoferi");
		shfaqGaraShoferi.setBounds(600, 320, 200, 50);
		shfaqGaraShoferi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Listo garat e shoferit");
				frame.setSize(1000, 1000);
				final JPanel panel = new JPanel();
				frame.add(panel);
				frame.setVisible(true);
				panel.setLayout(null);

				JLabel emri = new JLabel("Emri:");
				emri.setBounds(10, 20, 80, 25);
				panel.add(emri);
				final JTextField shkruajEmrin = new JTextField(20);
				shkruajEmrin.setBounds(100, 20, 150, 25);
				panel.add(shkruajEmrin);

				JButton statistika = new JButton("Kerko gara");
				statistika.setBounds(100, 170, 150, 25);
				statistika.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JLabel mesazhi = new JLabel();
						try {
							String label = DataSaver.statistika(shkruajEmrin.getText());
							mesazhi = new JLabel(label);
							mesazhi.setBounds(10, 320, 650, 55);
						} catch (Exception exp) {
							exp.printStackTrace();
							mesazhi = new JLabel("Kujdes ne plotesimin e te dhenave!");
							mesazhi.setBounds(10, 320, 450, 55);
						}
						mesazhi.setVisible(true);
						panel.add(mesazhi);

					}
				});
				panel.add(statistika);
			}
		});
		panel.add(shfaqGaraShoferi);

		JButton gjeneroGare = new JButton("Gjenero gare te rastesishme");
		gjeneroGare.setBounds(600, 390, 200, 50);
		gjeneroGare.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(gjeneroGare);
		
	}

	public void actionPerformed(ActionEvent e) {
	}
}
