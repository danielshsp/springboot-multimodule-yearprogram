package rc.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;
import rc.domain.Company;
import rc.persistence.DaoCompany;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Component
public class CompanyCahce {

    @Autowired
    DaoCompany daoCompany;
 
    @Cacheable(value = "companyCache", key = "#name")
    public Company findBycompany(String name){
        System.out.println("retrive  from DB" +name);
        return daoCompany.findBycompany(name);
    }

    @Cacheable(value = "companyCache", key = "#companyId")
    public Company findBycompanyId(int companyId){
        System.out.println("retrive  from DB" +companyId);
        return daoCompany.findBycompanyId(companyId);
    }

    @CachePut(value = "companyCache", condition = "#noCache", key="#noCache")
    @Cacheable(value = "companyCache", condition = "!#noCache", key ="!#noCache")
    public List<Company> findAll(boolean noCache){
        System.out.println("retrive  All from DB" );
        return daoCompany.findAll();

    }


    @CacheEvict(value = "companyCache", allEntries = true)
    public String clearCache(){
        return "clear companyCache successful";
    }

    @CacheEvict(value="companyCache",key = "#companyId")
    public Long deleteBycompanyId(int companyId){
        System.out.println("delete ItemCache Component.."+companyId);
        return daoCompany.deleteBycompanyId(companyId);
    }



}
