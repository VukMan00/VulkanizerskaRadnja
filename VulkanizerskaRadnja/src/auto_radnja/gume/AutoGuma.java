package auto_radnja.gume;

/**
 * Predstavlja model gume i njegove specifikacije
 * 
 * Guma ima marku, precnik, sirinu i visnu ali nema identifikator
 * 
 * @author Vuk Manojlovic
 * @since 0.1.0
 */
public class AutoGuma {

	/**
	 * Marka modela gume kao String
	 */
	private String markaModel = null;
	
	/**
	 * Precnik gume kao Integer
	 */
	private int precnik = -1;
	
	/**
	 * Sirina gume kao Integer
	 */
	private int sirina = -1;
	
	/**
	 * Visina gume kao Integer
	 */
	private int visina = -1;
	
	public AutoGuma() {
	}
	
	/**
	 * Inicijalizacija atributa AutoGuma
	 * 
	 * @param markaModel nova vrednost za marku modela gume
	 * @param precnik nova vrednost za precnik gume
	 * @param sirina nova vrednost za sirinu gume
	 * @param visina nova vrednost za visinu gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku modela gume
	 * 
	 * @return marku modela gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja vrednost marke modela gume
	 * 
	 * @param markaModel nova vrednost za marku modela gume
	 * 
	 * @throws NullPointerException ako se unese null vrednost za marku modela
	 * @throws IllegalArgumentException ako se unese String duzine manje od 3 kao marka modela gume
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik gume
	 * 
	 * @return precnik gume kao Integer
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Postavlja precnik gume
	 * 
	 * @param precnik nova vrednost za precnik gume
	 * 
	 * @throws IllegalArgumentException ako se unese Integer cija je vrednost manja od 13 i veca od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume
	 * 
	 * @return sirina gume kao Integer
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu gume
	 * 
	 * @param sirina nova vrednost za sirinu gume
	 * 
	 * @throws IllegalArgumentException ako se unese Integer cija je vrednost manja od 135 i veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu gume
	 * 
	 * @return visina gume kao Integer
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Postavlja visinu gume
	 * 
	 * @param visina nova vrednost za visinu gume
	 * 
	 * @throws IllegalArgumentException ako se unese Integer cija je vrednost manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
	}
	
	/**
	 * Poredi dve auto gume preko njihovih atributa i same instance klase
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true - ako su instance klase iste i ako su atributi dva objekta isti</li>
	 * 		<li>false - ako su unete null vrednosti i ukoliko im neki od atributa nije isti</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
