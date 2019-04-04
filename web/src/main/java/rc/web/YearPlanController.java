package rc.web;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rc.domain.Category;
import rc.domain.Company;
import rc.service.controller.ControllerService;
import rc.service.service.ServiceCompany;


@RestController
@RequestMapping("/api/v1")
@Api(value = "company-controller", description = "Operations pertaining to company in company Management System")
public class YearPlanController {

    @Autowired
    ControllerService controllerService;
    @Autowired
    ServiceCompany serviceCompany;

    @GetMapping(value = "/category/all")
    public List<Category> getAllCategory(){
        return controllerService.getAllOfCategory();
    }

    @ApiOperation(value = "listcompanies", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/company/all")
    public List<Company> getAllCompany(@RequestParam(required = false) boolean noCache){
        return serviceCompany.findAll(noCache);
    }


    @GetMapping(value = "/company/client/all")
    public Page<Company> findAllByPage(@RequestParam("page") int page ,@RequestParam("size")int size, @RequestParam("order") String order){

        return serviceCompany.findAllByPage(page,size,order);
    }

    @ApiOperation(value = "Get an company by Id")
    @GetMapping(value = "/company/{id}")
    public Company getCompanyByid(@PathVariable final int id){
        return serviceCompany.findBycompanyId(id);
    }

    @ApiOperation(value = "Get an company by name")
    @GetMapping(value = "/company/name/{company}")
    public Company findBycompany(@PathVariable final String company){
        return serviceCompany.findBycompany(company);
    }

    @GetMapping(value = "/company/year/{year}")
    public List<Company> getAllOfCompanyByYear(@PathVariable final int year){
        return controllerService.getAllCompanyByYear(year);
    }

    @ApiOperation(value = "Clear cache of company")
    @GetMapping(value = "/company/clearcache")
    public String clearCache(){
        return  serviceCompany.clearCache();
    }

    @ApiOperation(value = "Clear cache and db of company by Id")
    @DeleteMapping(value = "/company/deletecomp/{id}")
    public Long deleteBycompanyId(@PathVariable final int id){
         return serviceCompany.deleteBycompanyId(id);
    }

    @GetMapping(value = "/category/{secondCategory}/{year}")
    public List<Category> getAllCategoryByYearAndsecondCategory(@PathVariable final String secondCategory,@PathVariable final int year){
        return controllerService.getCategoryByYearAndsecondCategory(secondCategory,year);
    }

    @ApiOperation(value = "Add an companies")
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
