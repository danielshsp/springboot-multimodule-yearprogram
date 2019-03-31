package rc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rc.domain.Company;
import java.util.List;
import java.util.Optional;


@Repository
public class DaoCompany {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Page<Company> findAllByPage(int page, int size, String order){
        Sort sort;
        if (order.equals("DESC")){
             sort = new Sort(new Sort.Order(Sort.Direction.DESC, "companyId"));
        }else{
             sort = new Sort(new Sort.Order(Sort.Direction.ASC, "companyId"));
        }

        Pageable pageable = new PageRequest(page, size, sort);
        return companyRepository.findAll(pageable);
    }

    public Company findBycompanyId(int companyId){
        return companyRepository.findBycompanyId(companyId).get();
    }

    public Company findBycompany(String companyName){
        return companyRepository.findBycompany(companyName).get();
    }



    public List<Company> findCompanyByyear(int year){
        return companyRepository.findCompanyByyear(year);
    }

    public List<Company> findCompByyear(int year){
        return companyRepository.findCompByyear(year);
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public void delete(Company company){
        companyRepository.delete(company);
    }

    public Long deleteBycompanyId(int companyId){
       return companyRepository.deleteBycompanyId(companyId);
    }
}
