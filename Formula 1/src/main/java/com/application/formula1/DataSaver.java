package com.application.formula1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class DataSaver {

	private static List<ShoferiFormula1> shoferet = new ArrayList<ShoferiFormula1>();
	private static Set<String> skuadrat = new HashSet<String>();
	private static Set<String> garatAktuale = new HashSet<String>();

	public static void readFile() {
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/application/Files/Formula1.csv"));
			while ((line = br.readLine()) != null) {
				String[] shoferi = line.split(splitBy);
				String emri = shoferi[0];
				ShoferiFormula1 shoferiFormula1 = new ShoferiFormula1(emri);
				shoferiFormula1.setVendndodhja(shoferi[1]);
				shoferiFormula1.setSkuadra(shoferi[2]);
				shoferiFormula1.setVendi1(Integer.valueOf(shoferi[3]));
				shoferiFormula1.setVendi2(Integer.valueOf(shoferi[4]));
				shoferiFormula1.setVendi3(Integer.valueOf(shoferi[5]));
				shoferiFormula1.setPiketTotale(Integer.valueOf(shoferi[6]));
				shoferiFormula1.setGaraTotale(Integer.valueOf(shoferi[7]));
				shoferet.add(shoferiFormula1);
				skuadrat.add(shoferiFormula1.getSkuadra());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile() throws FileNotFoundException {
		deleteFileContent();
		try {
			@SuppressWarnings("resource")
			FileOutputStream fos = new FileOutputStream("src/main/java/com/application/Files/Formula1.csv");
			String lineSeparator = ",";
			String NEW_LINE = System.lineSeparator();
			for (ShoferiFormula1 shoferi : shoferet) {
				fos.write(shoferi.getEmri().getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(shoferi.getVendndodhja().getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(shoferi.getSkuadra().getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(String.valueOf(shoferi.getVendi1()).getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(String.valueOf(shoferi.getVendi2()).getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(String.valueOf(shoferi.getVendi3()).getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(String.valueOf(shoferi.getPiketTotale()).getBytes());
				fos.write(lineSeparator.getBytes());

				fos.write(String.valueOf(shoferi.getGaraTotale()).getBytes());
				fos.write(NEW_LINE.getBytes());
			}

			fos.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void deleteFileContent() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("src/main/java/com/application/Files/Formula1.csv");
		writer.print("");
		writer.close();
	}

	public static String shtoShofer(String emri, String skuadra, String vendndodhja) {
		if (!skuadrat.contains(skuadra)) {
			ShoferiFormula1 shoferi = new ShoferiFormula1(emri);
			shoferi.setSkuadra(skuadra);
			shoferi.setVendndodhja(vendndodhja);
			skuadrat.add(skuadra);
			shoferet.add(shoferi);
			return "Shoferi u shtua me sukses";
		}

		return "Skuadra ne te cilen po shtohet shoferi ekziston!";
	}

	public static String fshijShofer(String emri, String skuadra) {
		String mesazhi = "";
		int index = 0;
		boolean remove = false;
		if (skuadrat.contains(skuadra)) {
			skuadrat.remove(skuadra);
			for (ShoferiFormula1 shofer : shoferet) {
				if (shofer.getEmri().equalsIgnoreCase(emri)) {
					index = shoferet.indexOf(shofer);
					remove = true;
					mesazhi = "Shoferi u fshi!";
					break;
				} else {
					mesazhi = "Nuk mund te fshihet shoferi!";
				}
			}
		} else {
			mesazhi = "Nuk mund te fshihet shoferi!";
		}
		if (remove) {
			shoferet.remove(index);
		}
		return mesazhi;
	}

	public static String ndryshoSkuader(String emri, String skuadra) {
		boolean ekzistuese = false;
		int index = 0;
		for (String s : skuadrat) {
			if (s.equals(skuadra))
				ekzistuese = true;
		}
		if (!ekzistuese) {
			for (ShoferiFormula1 shoferi : shoferet) {
				if (shoferi.getEmri().equalsIgnoreCase(emri)) {
					index = shoferet.indexOf(shoferi);
					break;
				}
			}
			if (shoferet.size() > 0) {
				shoferet.get(index).setSkuadra(skuadra);
				return "Skuadra e shoferit u ndryshua!";
			} else {
				return "Shoferi nuk ekziston!";
			}
		} else {
			return "Kjo skuader ka nje shofer tjeter!";
		}
	}

	public static String statistika(String emri) {
		int index = 0;
		boolean ekzistues = false;
		for (ShoferiFormula1 shoferi : shoferet) {
			if (shoferi.getEmri().equalsIgnoreCase(emri)) {
				index = shoferet.indexOf(shoferi);
				ekzistues = true;
				break;
			}
		}
		if (ekzistues) {
			ShoferiFormula1 s = shoferet.get(index);
			return "Skuadra: " + s.getSkuadra() + ", Vendi 1: " + s.getVendi1() + ", Vendi 2: " + s.getVendi2()
					+ ", Vendi 3: " + s.getVendi3() + ", Garat totale: " + s.getGaraTotale() + ", Piket totale: "
					+ s.getPiketTotale();
		} else {
			return "Shoferi nuk ekziston!";
		}
	}
/*
	public static String garaShoferi(String emri){
		int index = 0;
		boolean ekzistues = false;
		for(ShoferiFormula1 shoferi : shoferet){
			if (shoferi.getEmri().equalsIgnoreCase(emri)) {
				index = shoferet.indexOf(shoferi);
				ekzistues = true;
				break;
			}
		}
		if (ekzistues){
			ShoferiFormula1 s = shoferet.get(index);
			return
		}
	}
*/
	public static Set<String> renditSipasPikeve() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ShoferiFormula1 shoferi : shoferet) {
			map.put(shoferi.getEmri(), shoferi.getPiketTotale());
		}
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap.keySet();

	}

	public static Set<String> renditSipasFitoreve() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (ShoferiFormula1 shoferi : shoferet) {
			map.put(shoferi.getEmri(), shoferi.getVendi1());
		}
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap.keySet();
	}

	public static Set<String> listoGarat() {
		garatAktuale.add("Bahrain");
		garatAktuale.add("Arabi Saudite");
		garatAktuale.add("Australi");
		garatAktuale.add("Itali");
		garatAktuale.add("SHBA");
		garatAktuale.add("Spanje");
		garatAktuale.add("Monako");
		garatAktuale.add("Azerbajxhan");
		garatAktuale.add("Kanada");
		garatAktuale.add("Britani");
		garatAktuale.add("Austri");
		garatAktuale.add("France");
		garatAktuale.add("Hungari");
		garatAktuale.add("Belgjike");
		garatAktuale.add("Holande");
		garatAktuale.add("Rusi");
		garatAktuale.add("Singapor");
		garatAktuale.add("Japoni");
		garatAktuale.add("Meksike");
		garatAktuale.add("Brazil");
		garatAktuale.add("Abu Dhabi");
		return garatAktuale;
	}

}
