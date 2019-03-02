package rc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rc.domain.Category;
import java.util.List;

@Repository
public class DaoCategory {

    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> findBysecondCategoryAndYearAllIgnoreCase(String secondCategory,int year){
        return categoryRepository.findBysecondCategoryAndYearAllIgnoreCase(secondCategory,year);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category findOne(Long id){
        return categoryRepository.findOne(id);
    }

    public Category findBycompanyId(int categoryId){
        return categoryRepository.findBycategoryId(categoryId).get();
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }




}
