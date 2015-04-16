import junit.framework.TestCase;


public class Test2 extends TestCase {

	 
	@org.junit.Test
	public void testRefreshTotal(){
		MainFrame.main(null);
		assertEquals(0,MainFrame.refreshTotal());//default total equal 0 
		MainFrame.flavorBtnList.get(0).selected = true;//select a button  price is 20
		MainFrame.decoratorBtnList.get(1).selected = true;//select a button  price is 4
		assertEquals(24,MainFrame.refreshTotal());//default total equal 20 + 4  
		 
	}

}
