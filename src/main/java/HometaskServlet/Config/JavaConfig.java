package HometaskServlet.Config;

import HometaskServlet.Controller.PostController;
import HometaskServlet.Repository.PostRepository;
import HometaskServlet.Service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public PostController postController(PostService service) {
        return new PostController(service);
    }

    @Bean
    public PostService service(PostRepository repository) {
        return new PostService(repository);
    }

    @Bean
    public PostRepository repository() {
        return new PostRepository();
    }
}
