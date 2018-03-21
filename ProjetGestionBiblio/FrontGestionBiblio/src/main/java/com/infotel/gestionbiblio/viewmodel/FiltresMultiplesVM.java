package com.infotel.gestionbiblio.viewmodel;

import java.util.List;

public class FiltresMultiplesVM 
{
	private List<Integer> auhtorIds;
	private List<Integer> editorsIds;
	private List<Integer> categoryIds;
	private boolean recommande;
	private String titre;
	
	
	
	public FiltresMultiplesVM() {
		super();
	}



	public List<Integer> getAuhtorIds() {
		return auhtorIds;
	}



	public void setAuhtorIds(List<Integer> auhtorIds) {
		this.auhtorIds = auhtorIds;
	}



	public List<Integer> getEditorsIds() {
		return editorsIds;
	}



	public void setEditorsIds(List<Integer> editorsIds) {
		this.editorsIds = editorsIds;
	}



	public List<Integer> getCategoryIds() {
		return categoryIds;
	}



	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public boolean isRecommande() {
		return recommande;
	}



	public void setRecommande(boolean recommande) {
		this.recommande = recommande;
	}
	

	
}
