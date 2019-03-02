package rc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.domain.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    List<Category> findBysecondCategoryAndYearAllIgnoreCase(String secondCategory, int year);
    Optional<Category> findBycategoryId(int categoryId);
}
