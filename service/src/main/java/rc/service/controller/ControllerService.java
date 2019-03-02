package rc.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.domain.Category;
import rc.domain.Company;
import rc.persistence.CategoryRepository;
import rc.persistence.CompanyRepository;
import rc.service.jms.YearPlanSender;
import java.util.List;


@Service
public class ControllerService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    YearPlanSender yearPlanSender;


    public List<Category> getAllOfCategory(){

        List<Category> categoryList = categoryRepository.findAll();
        yearPlanSender.sendTopic("Get all of category list");
        return categoryList;
    }

    public List<Company> getAllOfCompany(){

        List<Company> companyList = companyRepository.findAll();
        yearPlanSender.sendTopic("Get  all of company list");
        return companyList;
    }

    public List<Company> getAllCompanyByYear(int year){

        List<Company> companyList = companyRepository.findCompanyByyear(year);
        yearPlanSender.sendTopic("Get all company per year:"+year+"");
        return companyList;

    }
    public List<Category> getCategoryByYearAndsecondCategory(String secondCategory,int year){

        List<Category> categoryList = categoryRepository.findBysecondCategoryAndYearAllIgnoreCase(secondCategory,year);
        yearPlanSender.sendTopic("Get all company per year:"+year+" and per secondCategory: "+secondCategory+"");
        return categoryList;

    }


}
