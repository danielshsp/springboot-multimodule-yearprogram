package rc.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rc.domain.Category;
import rc.domain.Company;
import rc.persistence.CompanyRepository;
import rc.service.controller.ControllerService;
import rc.service.service.ServiceCompany;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value= "/rest")
public class YearPlanController {

    @Autowired
    ControllerService controllerService;
    @Autowired
    ServiceCompany serviceCompany;

    @GetMapping(value = "/category/all")
    public List<Category> getAllCategory(){
        return controllerService.getAllOfCategory();
    }

    @GetMapping(value = "/company/all")
    public List<Company> getAllCompany(@RequestParam(required = false) boolean noCache){
        return serviceCompany.findAll(noCache);
    }


    @GetMapping(value = "/company/client/all")
    public Page<Company> findAllByPage(@RequestParam("page") int page ,@RequestParam("size")int size, @RequestParam("order") String order){

        return serviceCompany.findAllByPage(page,size,order);
    }

    @GetMapping(value = "/company/{id}")
    public Company getCompanyByid(@PathVariable final int id){
        return serviceCompany.findBycompanyId(id);
    }

    @GetMapping(value = "/company/name/{company}")
    public Company findBycompany(@PathVariable final String company){
        return serviceCompany.findBycompany(company);
    }

    @GetMapping(value = "/company/year/{year}")
    public List<Company> getAllOfCompanyByYear(@PathVariable final int year){
        return controllerService.getAllCompanyByYear(year);
    }

    @GetMapping(value = "/company/clearcache")
    public String clearCache(){
        return  serviceCompany.clearCache();
    }

    @GetMapping(value = "/company/deletecomp/{id}")
    public Long deleteBycompanyId(@PathVariable final int id){
         return serviceCompany.deleteBycompanyId(id);
    }

    @GetMapping(value = "/category/{secondCategory}/{year}")
    public List<Category> getAllCategoryByYearAndsecondCategory(@PathVariable final String secondCategory,@PathVariable final int year){
        return controllerService.getCategoryByYearAndsecondCategory(secondCategory,year);
    }

    @PostMapping(value="/create/company")
    public Company createCompany(@RequestBody Company [] company){
        return serviceCompany.save(company);
    }

    //@PostMapping(value = "/company/all")
    /*public List <Company> createCompany(@RequestBody Map<String, String> body){
        String company = body.get("company");
        int year = Integer.parseInt(body.get("year"));
        return controllerService.creationOfCompany(company,year);
    }*/
}
