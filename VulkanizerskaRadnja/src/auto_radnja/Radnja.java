package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju u kojoj mogu da se dodaju gume, pretrazuju i uzimaju.
 * 
 * @author Vuk Manojlovic
 * @since 0.9.0
 */
public interface Radnja {
	
	/**
	 * Dodaje gumu u radnju
	 * 
	 * Guma ne sme biti null, i ne sme biti duplikat
	 * 
	 * @param a guma koju treba dodati u radnju
	 * @throws NullPointerException ako je uneta guma null
	 * @throws RuntimeException ako uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pronalazi zeljenu knjigu po atributu markaModel
	 * 
	 * Marka modela gume ne sme biti null.
	 * 
	 * @param markaModel markaModel vrednost po kojoj se pretrazuju knjige
	 * @return List svih guma po datom kriterijumu
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraca sve gume iz radnje
	 * 
	 * @return List svih guma
	 */
	List<AutoGuma> vratiSveGume();
}
