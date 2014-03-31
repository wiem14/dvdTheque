package fr.demos.formation.model;

public enum Categorie {
	s1("Dramatique"), s2("Comédie"), s3("Romantique");

	 private String CatType;
	  
	    private Categorie(String CatType) {
	    this.CatType = CatType;
	    }
	 
	   public String getCatType() {
	    return CatType;
	    }
}
