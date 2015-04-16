import junit.framework.TestCase;


public class Test1 extends TestCase {

	 
	@org.junit.Test
	public void testAddButtonByDialog(){
		MainFrame.main(null);
		//test add new flavor button by dialog
		MainFrame.addButtonByDialog("button1", 1, "flavor");
		MyButton b1 = MainFrame.flavorBtnList.get(MainFrame.flavorBtnList.size() - 1);
		assertEquals("button1",b1.name);
		assertEquals(1,b1.price);
		//test add new decorator button by dialog
		MainFrame.addButtonByDialog("button2", 2, "decorator");
		MyButton b2 = MainFrame.decoratorBtnList.get(MainFrame.decoratorBtnList.size() - 1);
		assertEquals("button2", b2.name);
		assertEquals(2, b2.price);
	}

}
