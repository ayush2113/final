package com.studentmanagementsystem.controller.redirect;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagementsystem.controller.ClassroomController;
import com.studentmanagementsystem.controller.HomeworkController;
import com.studentmanagementsystem.controller.ParentController;
import com.studentmanagementsystem.controller.ReportController;
import com.studentmanagementsystem.controller.StudentController;
import com.studentmanagementsystem.controller.SubjectController;
import com.studentmanagementsystem.controller.TeacherController;
import com.studentmanagementsystem.controller.UserController;
import com.studentmanagementsystem.entity.Address;
import com.studentmanagementsystem.entity.Users;
import com.studentmanagementsystem.service.AddressService;
import com.studentmanagementsystem.service.StudentService;

@Controller
public class RedirectPage {


    @Autowired
    private StudentService studentService;


    @Autowired
    private AddressService addressController;

    @Autowired
    private ClassroomController classroomController;

    @Autowired
    private HomeworkController homeworkController;

    @Autowired
    private ParentController parentController;

    @Autowired
    private ReportController reportController;


    @Autowired
    private StudentController studentController;

    @Autowired
    private SubjectController subjectController;

    @Autowired
    private TeacherController teacherController;

    /*
    *
    * Pages redirect
    *
    * */
    //Login
    
    private String loginPage = "auth/login/index";

    //Sign up
    private String signUpPage = "auth/signup/index";
    private String studentassignment="studentassignment/student-assignment";

    private String studentDashboardPage = "dashboard/student";

    //indexPage
    private String homePage = "index";

    //Admin Dashboard Page
    private String adminDashboardPage = "dashboard/admin";

    //Address Page
    private String adminAddressPage = "address";

    //Class Room Page
    private String adminClassroomPage = "classroom";

    //Homework Page
    private String adminHomeworkPage = "homework";

    //Parent Page
    private String adminParentPage = "parent";

    //Report Page
    private String adminReportPage = "report";

    //Admin School
    private String adminSchoolPage = "school";

    //Student Page
    private String adminStudentPage = "signup/student";

    //Subject Page
    private String adminSubjectPage = "subject";

    private String studentschedule="schedule/studentschedule";

    //Teacher Page
    private String adminTeacherPage = "teacher";
    @Autowired
    private UserController userController;



    @GetMapping("/login-page")
    public String loginPage(
            @RequestParam(required = false, defaultValue = "user", value = "role") String role,
            Model model
    ){
        model.addAttribute("roleSignInMessage",
                ((char)(role.charAt(0)-32))+role.substring(1)+"'s"+" Sign In");
        return loginPage;
    }

    @GetMapping("/sign-up-page")
    public String signUpPage(){
        return signUpPage;
    }

    @PostMapping("/create-new-user")
    public String signUpUser( Users users, String confirm_password, Model model){
        if (users.getPassword().equals(confirm_password)){
            if (userController.save(users) != null)
                return loginPage;
            System.out.println(users.getEmailId()+" is already exists!");
        }
        model.addAttribute("firstName",users.getFirstName());
        model.addAttribute("middleName",users.getMiddleName());
        model.addAttribute("lastName",users.getLastName());
        model.addAttribute("emailId", users.getEmailId());
        model.addAttribute("phoneNumber", users.getPhoneNumber());
        System.out.println(users);

        return signUpPage;
    }

    @PostMapping(value = "/user-sign-in")
public String userSignIn(Users users, Model model) {
    Map<String, Object> user = userController.login(users);
    if (user != null) {
        return studentDashboardPage;
    }
    model.addAttribute("error", "Invalid username or password");
    return loginPage; // Redirect to login page with error message
}
    

@GetMapping(value="student-assignments")
public String studentAssignments(){
    return studentassignment;
}

@GetMapping("/admin-logout")
public String logout() {
    // Invalidate the session if needed
    // request.getSession().invalidate();
    return loginPage; // Redirect to login page
}

    @GetMapping("welcome")
    public String welcome(Model model){

        return "welcome";
    }
    
    @GetMapping("/admin-add-student")
    public String adminAddStudentPage() {
        return adminStudentPage; // Return the view for adding a student
    }

    
    @GetMapping(value = "admin-dashboard")
    public String adminDashboard(Model model){
        return adminDashboardPage;
    }

    @GetMapping(value = "school-dashboard")
    public String schoolDashboard(Model model){
        return null;
    }

    @GetMapping(value = "teacher-dashboard")
    public String teacherDashboard(Model model){
        return null;
    }

    @GetMapping(value = "student-dashboard")
    public String studentDashboard(Model model){
        return studentDashboardPage;
    }

   @GetMapping(value="student-schedule")
   public String studentschedule(){
    return studentschedule;
   }

    /*
    *
    * Address
    *
    * */
    public Address saveAddress(Address browserAddress){
        return addressController.save(browserAddress);
    }

    public Address updateAddress(Integer id, Address updatedBrowserAddress){
        return addressController.updateAddress(id, updatedBrowserAddress);
    }

    public Address deleteAddress(Integer id){
        return addressController.deleteById(id);
    }

    public Address deleteAddress(Integer id, Address address){
        return addressController.updateAddress(id, address);
    }




    /*
    *
    * Class Room
    *
    * */

    /*
    *
    * Homework
    *
    * */

    /*
    *
    * Parent
    *
    * */

    /*
    *
    * Report
    *
    * */

    /*
    *
    * School
    *
    * */

    /*
    *
    * Student
    *
    * */

    /*
    *
    * Subject
    *
    * */

    /*
    *
    * Teacher
    *
    * */

    @GetMapping("test")
    public String test(Model model){
        return "xxx";
    }
}