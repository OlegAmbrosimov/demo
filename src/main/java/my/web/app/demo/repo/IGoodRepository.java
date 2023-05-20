package my.web.app.demo.repo;

import my.web.app.demo.models.Good;
import org.springframework.data.repository.CrudRepository;

public interface IGoodRepository extends CrudRepository <Good, Long> {
}
