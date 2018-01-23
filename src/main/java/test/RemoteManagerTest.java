package test;


import org.junit.Test;

import junit.framework.TestCase;
import model.Remote;
import model.RemoteManager;

public class RemoteManagerTest extends TestCase{
	
	private Remote remote;
	private RemoteManager remoteManager = new RemoteManager();
	
	@Override
	protected void setUp() throws Exception {
		remote = new Remote();
		remote.setId(1);
		remoteManager.addRemote(remote);
		remoteManager.setFrequency(1.0);
	}

	@Test
	public void testAddRemote() {
		assertNotNull(remoteManager.getRemotes());
	}
	
	@Test
	public void testActionRequest() {
		assertTrue(remoteManager.actionRequest(remote));
	}
	
}
