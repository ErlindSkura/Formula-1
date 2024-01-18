package com.application.formula1;

public abstract class Shoferi {
	
	private String emri;

	private String vendndodhja;

	private String skuadra;
	
	public Shoferi(String emri) {
		this.emri = emri;
	}
	
	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getVendndodhja() {
		return vendndodhja;
	}

	public void setVendndodhja(String vendndodhja) {
		this.vendndodhja = vendndodhja;
	}

	public String getSkuadra() {
		return skuadra;
	}

	public void setSkuadra(String skuadra) {
		this.skuadra = skuadra;
	}

}
