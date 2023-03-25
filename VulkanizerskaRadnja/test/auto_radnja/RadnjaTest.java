package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja r = new VulkanizerskaRadnja();
	

	@Test
	void testDodajGumu() {
		AutoGuma autoGuma = new AutoGuma("Opel Corsa",15,340,30);
		r.dodajGumu(autoGuma);
		
		List<AutoGuma> gume = r.vratiSveGume();
		assertEquals(1, gume.size());
		assertTrue(gume.contains(autoGuma));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Opel Corsa");
		ag.setPrecnik(15);
		ag.setSirina(340);
		ag.setVisina(30);
		
		r.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Opel Corsa");
		ag2.setPrecnik(15);
		ag2.setSirina(340);
		ag2.setVisina(30);
		
		assertThrows(RuntimeException.class,()->r.dodajGumu(ag2));
	}
	
	@Test
	void testDodajGumuSaNull() {
		assertThrows(NullPointerException.class,()->r.dodajGumu(null));
	}
	
	@Test
	void testPronadjiGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Opel Corsa");
		ag.setPrecnik(15);
		ag.setSirina(340);
		ag.setVisina(30);
		r.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Opel Omega");
		ag2.setPrecnik(17);
		ag2.setSirina(342);
		ag2.setVisina(31);
		r.dodajGumu(ag2);
		
		List<AutoGuma> noveGume = r.pronadjiGumu("Opel Corsa");
		assertEquals(1, noveGume.size());
		assertTrue(noveGume.contains(ag));
	}
	
	@Test
	void testPronadjiGumuSaDelomMarke() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Opel Corsa");
		ag.setPrecnik(15);
		ag.setSirina(340);
		ag.setVisina(30);
		r.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Opel Omega");
		ag2.setPrecnik(17);
		ag2.setSirina(342);
		ag2.setVisina(31);
		r.dodajGumu(ag2);
		
		List<AutoGuma> noveGume = r.pronadjiGumu("Opel");
		assertEquals(2, noveGume.size());
		assertTrue(noveGume.contains(ag));
		assertTrue(noveGume.contains(ag2));
	}
	
	@Test
	void testPronadjiGumuSaNull() {
		assertThrows(NullPointerException.class, ()->r.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuKojaNePostoji() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Opel Corsa");
		ag.setPrecnik(15);
		ag.setSirina(340);
		ag.setVisina(30);
		r.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Opel Omega");
		ag2.setPrecnik(17);
		ag2.setSirina(342);
		ag2.setVisina(31);
		r.dodajGumu(ag2);
		
		List<AutoGuma> noveGume = r.pronadjiGumu("Opel Kadet");
		assertEquals(0, noveGume.size());
		assertFalse(noveGume.contains(ag));
		assertFalse(noveGume.contains(ag2));
	}
	
	

}
