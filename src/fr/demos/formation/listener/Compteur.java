package fr.demos.formation.listener;

public class Compteur {
	
	private int valeur;
	
	
	
	public Compteur(int valeur) {
		super();
		this.valeur = valeur;
	}
	
	

	@Override
	public String toString() {
		return " " + valeur ;
	}



	void incrementer(){
		valeur++;
	}
	
	void decrementer(){
		valeur--;
	}

}
