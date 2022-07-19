package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import webapp.model.Figure;

public interface FigureRepository extends JpaRepository<Figure, Long> {
//    @Modifying
//    void update(Figure figure, String id);
}
