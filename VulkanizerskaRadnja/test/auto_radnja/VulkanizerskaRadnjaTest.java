package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

class VulkanizerskaRadnjaTest extends RadnjaTest{

	protected Radnja r;
	
	@BeforeEach
	void setUp() throws Exception {
		r = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	

}
