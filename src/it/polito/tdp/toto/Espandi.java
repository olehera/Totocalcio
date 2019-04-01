package it.polito.tdp.toto;

public class Espandi {
	
	public void espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		espandi(p, parziale, 0);
	}
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato...
	
	public void espandi(Pronostico p, Schedina parziale, int livello) {
		
		/* parziale contiene gi� (livello) valori
		      nelle posizioni da 0...livello-1
		   io devo determinare parziale[livello]
		     (cio� la livello+1esima riga)
		   sulla base della previsione in p[livello]
		*/
		
		if (livello == p.getN()) {
			System.out.println(parziale);
			return ;
		}
		
		Previsione prev = p.get(livello);
		
		// prova le varie alternative
		for (Risultato r : prev.getValori()) {
			// provo ad aggiungere 'r' alla soluzione
			parziale.add(r);
			
			espandi(p, parziale, livello+1);
			
			// backtrack
			parziale.removeLast();
		}
			
	}
}
