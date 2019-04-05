package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Espandi {
	
	private List<Schedina> soluzioni;
	
	public List<Schedina> espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		this.soluzioni = new ArrayList<Schedina>();
		espandi(p, parziale, 0);
		return this.soluzioni;
	}
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato...
	
	public void espandi(Pronostico p, Schedina parziale, int livello) {
		
		/* parziale contiene già (livello) valori
		      nelle posizioni da 0...livello-1
		   io devo determinare parziale[livello]
		     (cioè la livello+1esima riga)
		   sulla base della previsione in p[livello]
		*/
		
		if (livello == p.getN()) {
	     // System.out.println(parziale);
			this.soluzioni.add(new Schedina(parziale));    // creo una copia non gli passo il riferimento
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
