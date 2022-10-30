package Controler;

import Dao.EntityImpDAO.UserImp;
import Dao.InterfaceClass.UserDao;
import Model.User;
import constant.SessionAttr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.awt.Desktop;
@WebServlet(urlPatterns = "/user/login/faceid")
public class FaceId extends HttpServlet {
    UserDao userService = new UserImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String applicationPath = req.getServletContext().getRealPath("");
        int x = applicationPath.lastIndexOf("\\target");
        String appPath = applicationPath.substring(0,x)+"\\reface"; // path
        String test = "@echo off"+"\n"+ appPath.replace("\\","\n cd ") + "\n cls"+"\n python runcheck.py" +"\n exit";
        xWriteFile(test,appPath+"\\runCheckFaceId.bat");
        String vbsFile = "main\n" +
                "Sub main\n" +
                "Set oShell = CreateObject (\"Wscript.Shell\") \n" +
                "Dim strArgs\n" +
                "strArgs = \"cmd /c " + appPath +"\\runCheckFaceId.bat" + "\"\n"+
                "oShell.Run strArgs, 0, false\n" +
                "End Sub";
        xWriteFile(vbsFile,appPath+"\\runCheckFaceId.vbs");
        Desktop.getDesktop().open(new File(appPath+"\\runCheckFaceId.vbs"));
        xWriteFile(" ",appPath+"//isRunning.txt");
        RunOnRealTime(appPath,req,resp,session);
        while (true){
            try {
                Thread.sleep(1000);
                User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
                if (user == null){
                }else {
                    resp.sendRedirect("/asm/index");
                    return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void xWriteFile(String x, String path) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(x);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String xReaderfile(String path) throws IOException { // đọc file check_id rồi trả về a với giá trị có trong file tương đương với mã id trong csdl
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String x = br.readLine();
        return x;
    }
    private void RunOnRealTime(String path, HttpServletRequest req, HttpServletResponse resp, HttpSession session)throws ServletException, IOException{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        String isrun = xReaderfile(path+"\\isRunning.txt");
                        if (isrun == null){
                        }else {
                        if (xReaderfile(path+"\\isRunning.txt").equals("stop")){
                        User user = userService.findByUsername(xReaderfile(path+"\\data.txt"));
                        session.setAttribute(SessionAttr.CURRENT_USER,user);
                        return;
                        }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
    t1.start();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/views/index.jsp");
    }
}
