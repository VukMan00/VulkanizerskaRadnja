package auto_radnja;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Implementacija interfejsa Radnja u kojoj se koristi Array lista za smestanje guma
 * 
 * @author Vuk Manojlovic
 * @since 0.9.0
 */
public class VulkanizerskaRadnja implements Radnja{
	
	/**
	 * Array list sa svim gumama u radnji
	 */
	private List<AutoGuma> gume = new ArrayList<>();


	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null) {
			throw new NullPointerException("Guma ne sme biti null");
		}
		if (gume.contains(a)) {
			throw new RuntimeException("Guma vec postoji");
		}
		
		gume.add(a);
	}

	@Override
	public List<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Marka modela ne sme biti null");
		
		List<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for(int i=0;i<gume.size();i++)
			if (gume.get(i).getMarkaModel().contains(markaModel))
				novaLista.add(gume.get(i));
		
		return novaLista;
	}

	@Override
	public List<AutoGuma> vratiSveGume() {
		return gume;
	}

}
