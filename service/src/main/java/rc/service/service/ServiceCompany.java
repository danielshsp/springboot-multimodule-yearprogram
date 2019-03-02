package rc.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import rc.domain.Company;
import rc.persistence.DaoCompany;
import rc.service.jms.YearPlanSender;

import java.util.List;

@Service
public class ServiceCompany {

    @Autowired
    DaoCompany daoCompany;
    @Autowired
    YearPlanSender yearPlanSender;

    public List<Company> findAll(){
        List<Company> companyList = daoCompany.findAll();
        yearPlanSender.sendTopic("Get  all of company list");
        return companyList;
    }

    public Page<Company> findAllByPage(int page, int size, String order){
        Page<Company> companyPage = daoCompany.findAllByPage(page,size,order);
        yearPlanSender.sendTopic("Get  all of company with paging");
        return companyPage;
    }

    public List<Company> findCompanyByyear(int year){

        List<Company> companyList = daoCompany.findCompanyByyear(year);
        yearPlanSender.sendTopic("Get all company per year:"+year+"");
        return companyList;

    }

    public Company save(Company [] company){
        Company singleCompany = null;
        for(int i = 0; i<company.length; i++){
              daoCompany.save(company[i]);
        }
        singleCompany =  company[0];
        return singleCompany;
    }

    /*public List<Company> creationOfCompany(String companyName, int year){
        Company company =  new Company(companyName, year);
        String [] companyArr =  companyName.split(",");
        int lenCompanyArr = companyArr.length;
        List<Company> companyList = null;
        if(lenCompanyArr > 0){

            for(int i = 0; i<lenCompanyArr;i++){

                //System.out.println(companyArr[i].);
                company.setCompany(companyArr[i]);
                // companyRepository.addCompany(companyArr[i],year);
                daoCompany.save(company);
                yearPlanSender.sendTopic("create a new company the company Name is: "+company.getCompany()+" ");
                // company = new Company(takeCompany, year);
            }
        }

        List <Company> companyObj = daoCompany.findCompByyear(year);
        return companyObj;

    }*/
}
