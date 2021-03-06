package rc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "categoryplantbl" ,schema = "ypl", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int categoryId;
    @Column(name = "problem_sub_type", columnDefinition = "NVARCHAR(255)")
    private String secondCategory;
    @Column(name = "third_category", columnDefinition = "NVARCHAR(255)")
    private String thirdCategory;
    @Column(name = "years")
    private int year;
   @Column(name = "company_id" ,insertable = false,updatable = false )
    private int companyId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @JsonIgnore
    private  Company company;

    public Category() {
    }

    public Category(String secondCategory, String thirdCategory, int year) {
        this.secondCategory = secondCategory;
        this.thirdCategory = thirdCategory;
        this.year = year;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getThirdCategory() {
        return thirdCategory;
    }

    public void setThirdCategory(String thirdCategory) {
        this.thirdCategory = thirdCategory;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return this.company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
