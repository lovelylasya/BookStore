package Gallery.Book-Gallery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.Book-Gallery.boot.test.context.BookStoreTest;
import org.Book-Gallery.test.context.web.WebAppConfiguration;
import org.Book-Gallery.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@BookStoreTest(classes = BookStoreWebApplication.class)
@WebAppConfiguration
public class BookStoreWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
