package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Product;
import data.db.ProductDBMgr;

public class ProductDbMgrTest {
	private static ProductDBMgr PdMgr ;

	@BeforeClass
	public static void Setup() {
		PdMgr = new ProductDBMgr();
	}
/*
 * Purpose: get Product by pdname parameter
 * Input  : 콜드브루 which in products db, 레드벨벳케익 which does not in products db
 * Expected : 
 * 콜드브루 -> return 콜드브루 product 
 * 레드벨벳케익 -> return null 
 * 
 * */
	@Test
	public void testGetOneProduct() {
		Product pd = PdMgr.getOneProduct("콜드브루");
		assertNotNull(pd);
		pd = PdMgr.getOneProduct("레드벨벳케익");
		assertNull(pd);
	}

	@Test
	public void testGetAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewOneProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditOneProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOneProdcut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductsByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
