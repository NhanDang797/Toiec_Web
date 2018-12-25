package controller.admin;

import command.UserCommand;
import core.dto.UserDTO;
import core.web.common.WebConstant;
import core.web.utils.FormUtil;
import org.apache.log4j.Logger;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    // khai báo để sử dụng thư viện logger
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*populate là lấy class được gọi đến */
        UserCommand command = FormUtil.populate(UserCommand.class, req); // lấy các tham số từ form  đưa vào DTO
        UserDTO pojo = command.getPojo(); // pojo là nơi chứa các field của 1 đối tượng của đối tượng được gọi

        UserService userService = new UserServiceImpl();
        try {
            /*Kiểm tra các  thuộc tính của pojo và đối tượng DTO không được null*/
            if (userService.isUserExits(pojo) != null && userService.isUserExits(pojo).getRoleDTO() != null) {
                /*Kiểm tra quyền của tên đăng nhập để  chuyển đến trang của quyền đó*/
                if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)){
                    req.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
                    req.setAttribute(WebConstant.MESSAGE_RESPONSE,"Welcom Admin");
                }
                else {
                    req.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
                    req.setAttribute(WebConstant.MESSAGE_RESPONSE,"Welcom User");
                }
            }

        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            req.setAttribute(WebConstant.ALERT,WebConstant.TYPE_ERROR);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE,"UserName or Password Invalid");
        }

        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req, resp);
    }
}
