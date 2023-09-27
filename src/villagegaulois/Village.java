package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public class Marche{
		private Etal[] etals;

		public Marche(int nbEtal) {
			etals = new Etal[nbEtal];
			for (int i = 0; i < nbEtal; i++) {
				etals[i]= new Etal();
			}
		}
		
		
		void utiliserEtal(int indiceEta1, Gaulois vendeur, String produit, int nbProduit) {
			
			if(indiceEta1<0 || indiceEta1>etals.length) {
				System.out.println("erreur");
				
			}
			
			etals[indiceEta1].occuperEtal(vendeur, produit, nbProduit);
		}
		
		int trouverEtalLibre() {
			for (int i = 0; i < etals.length; i++) {
				if(!etals[i].isEtalOccupe()) {
					return i;
				}
			}
			return -1;
		}
		
		Etal[] trouverEtals(String produit) {
			int k = 0;
			
			for (int i = 0; i < etals.length; i++) {
				if(etals[i].contientProduit(produit)) {
					k++;
				}
			}
			Etal[] e = new Etal[k];
			int j=0;
			for (int i = 0; i < etals.length; i++) {
				if(etals[i].contientProduit(produit)) {
					e[j]=etals[i];
					j++;
				}
			}
			
			return e;
		}
		
		
		Etal trouverVendeur(Gaulois gaulois) {
			
			for(int i=0; i<etals.length; i++) {
				if(etals[i].getVendeur().equals(gaulois)) {
					return etals[i];
				}
			}
			
			return null;
		}
		
		void afficherMarche() {
			int c = 0;
			for(int i=0; i<etals.length;i++) {
				if(etals[i].isEtalOccupe()) {
					System.out.println(etals[i].getVendeur().getNom()+" vend "+etals[i].);
				}
				else {
					c=etals.length-i;
				}
			}
			System.out.println("Il reste "+c+" �tals non utilis�s dans le march�.");
		}
		
		
		
	}

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
}