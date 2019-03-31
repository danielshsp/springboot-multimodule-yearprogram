package rc.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import rc.domain.Company;
import rc.persistence.DaoCompany;
import org.springframework.cache.annotation.Cacheable;

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
