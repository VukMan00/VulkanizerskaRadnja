package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testSetMarkaModelSaNull() {
		assertThrows(NullPointerException.class, ()->ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelSaDuzinomManjomOdTri() {
		assertThrows(IllegalArgumentException.class, ()->ag.setMarkaModel("op"));
	}
	
	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Opel Omega");
		assertEquals("Opel Omega", ag.getMarkaModel());
	}
	
	@ParameterizedTest
	@CsvSource({
		"10",
		"11",
		"24"
	})
	void testSetPrecnikNedozvoljeno(int precnik) {
		assertThrows(IllegalArgumentException.class, ()->ag.setPrecnik(precnik));
	}
	
	@Test
	void testSetPrecnik() {
		ag.setPrecnik(15);
		assertEquals(15, ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"10",
		"11",
		"360"
	})
	void testSetSirinaNedozvoljeno(int sirina) {
		assertThrows(IllegalArgumentException.class, ()->ag.setSirina(sirina));
	}
	
	@Test
	void testSetSirina() {
		ag.setSirina(340);
		assertEquals(340, ag.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"10",
		"20",
		"100"
	})
	void testSetVisinaNedozvoljeno(int visina) {
		assertThrows(IllegalArgumentException.class, ()->ag.setVisina(visina));
	}
	
	@Test
	void testSetVisina() {
		ag.setVisina(30);
		assertEquals(30, ag.getVisina());
	}
	
	@Test
	@DisplayName("Test za proveru toString metode")
	void testToString() {
		ag.setMarkaModel("Opel Omega");
		ag.setPrecnik(15);
		ag.setSirina(340);
		ag.setVisina(30);
		
		String s = ag.toString();
		assertTrue(s.contains("Opel Omega"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("340"));
		assertTrue(s.contains("30"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Opel Omega, Opel Omega, 15, 15, 340, 340, 30, 30, true",
		"Opel Omega, Opel Corsa, 15, 16, 340, 341, 30, 30, false"
	})
	void testEquals(String markaModela, String markaModela2, int precnik, int precnik2, int sirina, int sirina2, int visina, int visina2, boolean isti) {
		ag.setMarkaModel(markaModela);
		ag.setPrecnik(precnik);
		ag.setSirina(sirina);
		ag.setVisina(visina);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(markaModela2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		
		assertEquals(isti, ag.equals(ag2));
		
		
	}

}
