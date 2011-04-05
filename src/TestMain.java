import servlets.MoneyDropPage;
import servlets.ServletPage;
import servlets.ZombonePage;


public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServletPage ps = new MoneyDropPage();
		ps = new ZombonePage();
		System.out.print(ps.GetFileData());

	}

}
