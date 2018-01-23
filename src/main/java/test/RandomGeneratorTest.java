package test;

import static org.junit.Assert.*;

import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import model.Remote;
import utilities.RandomGenerator;

public class RandomGeneratorTest {
	
	private List<Remote> remotes = RandomGenerator.setRemotes(10);

	@Test
	public void testRandomRemotesGeneratorNotNull() {
		assertNotNull(remotes);
	}
	
	@Test
	public void testRandomRemotesSize() {
		assertThat(remotes.size(), is(10));
	}
	
	
}
