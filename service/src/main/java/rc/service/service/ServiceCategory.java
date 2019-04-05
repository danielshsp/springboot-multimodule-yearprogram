package rc.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.cache.CompanyCahce;
import rc.domain.Category;
import rc.persistence.DaoCategory;
import rc.service.jms.YearPlanSender;

import java.util.List;

@Service
public class ServiceCategory {
    @Autowired
    DaoCategory daoCategory;
    @Autowired
    YearPlanSender yearPlanSender;

    public List<Category> getCategoryByYearAndsecondCategory(String secondCategory, int year){

        List<Category> categoryList = daoCategory.findBysecondCategoryAndYearAllIgnoreCase(secondCategory,year);
        yearPlanSender.sendTopic("Get all company per year:"+year+" and per secondCategory: "+secondCategory+"");
        return categoryList;

    }

    public List<Category> findAll(){

        List<Category> categoryList = daoCategory.findAll();
        yearPlanSender.sendTopic("Get all of category list");
        return categoryList;
    }

}
