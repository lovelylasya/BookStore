package Gallery.Book-Gallery.bootstrap;

import Gallery.Book-Gallery.domain.Product;
import Gallery.Book-Gallery.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.Book-Gallery.beans.factory.annotation.Autowired;
import org.Book-Gallery.context.ApplicationListener;
import org.Book-Gallery.context.event.ContextRefreshedEvent;
import org.Book-Gallery.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BookLoader implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;

    private Logger log = LogManager.getLogger(BookLoader.class);

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Book Encyclopedia = new Book();
        Encyclopedia.setDescription("Book-Gallery Gallery Encyclopedia");
        Encyclopedia.setPrice(new BigDecimal("18.95"));
        Encylopedia.setImageUrl("https://www.google.com/search?q=encyclopedia&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjO_5CQlOn5AhWhplYBHW-CDRYQ_AUoA3oECAEQBQ&biw=1536&bih=619&dpr=2#imgrc=f1zU98YZUk0-_M");
        Encyclopedia.setBookId("235268845711068308");
        bookRepository.save(Encyclopedia);

        log.info("Saved Encyclopedia - id: " + Encyclopedia.getId());

        Book jenkins = new Book();
        jenkins.setDescription("Book-Gallery Gallery Jenkins");
        jenkins.setImageUrl("https://www.google.com/search?q=jenkins&tbm=isch&ved=2ahUKEwjt2oKSlOn5AhWm_TgGHQ5vAlkQ2-cCegQIABAA&oq=jenkins&gs_lcp=CgNpbWcQAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BwgAELEDEEM6BAgAEEM6CwgAEIAEELEDEIMBOggIABCxAxCDAVCoCFjMJ2DnK2gAcAB4BIABiwGIAeQNkgEEMC4xNJgBAKABAaoBC2d3cy13aXotaW1nsAEAwAEB&sclient=img&ei=qSwLY63iK6b74-EPjt6JyAU&bih=619&biw=1536#imgrc=spB5bbliHmZt-M");
        jenkins.setBookId("168639393495335947");
        jenkins.setPrice(new BigDecimal("11.95"));
        bookRepository.save(jenkins);

        log.info("Saved jenkins - id:" + jenkins.getId());
    }
}
