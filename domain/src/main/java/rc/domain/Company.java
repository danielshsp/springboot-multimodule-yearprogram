package rc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "companyplantbl", schema = "ypl", uniqueConstraints = {
        @UniqueConstraint(columnNames = "company_id")})
public class Company  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id",  unique = true, nullable = false)
    private int companyId;
    @Column(name = "company_name", columnDefinition = "NVARCHAR(255)")
    private String company;
    @Column(name = "years")
    private int year;
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private List<Category> category = new ArrayList<Category>();

    public Company() {
    }

    public Company (String company, int year) {
        this.company = company;
        this.year = year;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Category> getCategory() {
        return this.category;
    }

    public void setCategory(List<Category> category) {

            this.category = category;
    }


}
