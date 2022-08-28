package Gallery.Book-Gallery.configuration;

import org.Book-Gallery.boot.autoconfigure.EnableAutoConfiguration;
import org.Book-Gallery.boot.autoconfigure.domain.EntityScan;
import org.Book-Gallery.context.annotation.Configuration;
import org.Book-Gallery.data.jpa.repository.config.EnableJpaRepositories;
import org.Book-Gallery.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"Gallery.Book-Gallery.domain"})
@EnableJpaRepositories(basePackages = {"Gallery.Book-Gallery.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
