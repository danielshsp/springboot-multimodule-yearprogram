package rc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rc.domain.Company;
import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Procedure
    void addCompany(String companyName,int year);
    List<Company> findCompanyByyear(int year);
    Optional<Company> findBycompanyId(int companyId);
    List<Company> findCompByyear(int year);

}



