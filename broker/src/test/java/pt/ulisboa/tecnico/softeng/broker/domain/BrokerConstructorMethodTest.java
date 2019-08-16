package pt.ulisboa.tecnico.softeng.broker.domain;

import org.junit.Assert;
import org.junit.Test;

import pt.ist.fenixframework.FenixFramework;
import pt.ulisboa.tecnico.softeng.broker.exception.BrokerException;

public class BrokerConstructorMethodTest extends RollbackTestAbstractClass {

	@Override
	public void populate4Test() {
	}

	@Test
	public void success() {
		Broker broker = new Broker("BR01", "WeExplore");

		Assert.assertEquals("BR01", broker.getCode());
		Assert.assertEquals("WeExplore", broker.getName());
		Assert.assertEquals(0, broker.getAdventureSet().size());
		Assert.assertTrue(FenixFramework.getDomainRoot().getBrokerSet().contains(broker));
	}

	@Test
	public void nullCode() {
		try {
			new Broker(null, "WeExplore");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

	@Test
	public void emptyCode() {
		try {
			new Broker("", "WeExplore");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

	@Test
	public void blankCode() {
		try {
			new Broker("  ", "WeExplore");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

	@Test
	public void uniqueCode() {
		Broker broker = new Broker("BR01", "WeExplore");

		try {
			new Broker("BR01", "WeExploreX");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(1, FenixFramework.getDomainRoot().getBrokerSet().size());
			Assert.assertTrue(FenixFramework.getDomainRoot().getBrokerSet().contains(broker));
		}
	}

	@Test
	public void nullName() {
		try {
			new Broker("BR01", null);
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

	@Test
	public void emptyName() {
		try {
			new Broker("BR01", "");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

	@Test
	public void blankName() {
		try {
			new Broker("BR01", "    ");
			Assert.fail();
		} catch (BrokerException be) {
			Assert.assertEquals(0, FenixFramework.getDomainRoot().getBrokerSet().size());
		}
	}

}
