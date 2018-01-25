/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.entity.Data;
import com.entity.Program;
import com.service.DataService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class DataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            try {

//                    response.setHeader("cache-control", "no-cache no-store, must revalidate");
//                    response.setHeader("Pragma", "no-cache");
//                    response.setDateHeader("Expires", 0);
//
//                    HttpSession session = request.getSession();
//                    if (session.getAttribute("Login Sukses") == null) {
//                        response.sendRedirect("gagal.jsp");
//                    } else {
                int aksi = request.getParameter("action") == null ? 1
                        : Integer.parseInt(request.getParameter("action"));

                switch (aksi) {
                    case 1:
                        loadData(request);
                        RequestDispatcher dispatch = request.getRequestDispatcher("/index.jsp");
                        dispatch.forward(request, response);
                        break;

                    case 2:
                        addData(request);
                        response.sendRedirect("DataServlet?action=1");
                        //response.sendRedirect("MahasiswaServlet");
                        break;

                    case 3:
                        deleteData(request);
                        response.sendRedirect("DataServlet?action=1");
                        break;

                    case 4:
                        getById(request);
                        RequestDispatcher dispatch1 = request.getRequestDispatcher("/update.jsp");
                        dispatch1.forward(request, response);
                        break;

                    case 5:
                        updateData(request);
                        response.sendRedirect("DataServlet?action=1");
                    case 6:
                        loadProgram(request);
                        RequestDispatcher dispatch2 = request.getRequestDispatcher("addData.jsp");
                        dispatch2.forward(request, response);
                        break;
                }
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadProgram (HttpServletRequest request){
        DataService ds = new DataService();
        List<Program> list2;
        list2=ds.selectProgram();
        request.setAttribute("pg", list2);
    }
    
    public void loadData(HttpServletRequest request) {
        int halamanKe = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        String search = request.getParameter("cari") == null ? "" : request.getParameter("cari");

        DataService db = new DataService();
        List<Data> list;
        try {
            list = db.selectPaging(halamanKe, search);
            request.setAttribute("mhs", list);

            //set halaman
            int jml = new DataService().getCountPage(search);
            request.setAttribute("total", jml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(HttpServletRequest request) {
        DataService db = new DataService();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String sTglLahir = request.getParameter("dateOfBirth");
            Date tglLahir = df.parse(sTglLahir);
            Data m = new Data();
            m.setName(request.getParameter("name"));
            m.setGender(request.getParameter("gender"));
            m.setPlaceOfBirth(request.getParameter("placeOfBirth"));
            m.setDateOfBirth(tglLahir);
            m.setMaritalstatus(request.getParameter("maritalstatus"));
            m.setReligionCode(Integer.parseInt(request.getParameter("religionCode")));
            m.setCurrentAddress(request.getParameter("currentAddress"));
            m.setEducationCode(Integer.parseInt(request.getParameter("educationCode")));
            m.setGpa(Double.parseDouble(request.getParameter("gpa")));
            m.setProgramCode(Integer.parseInt(request.getParameter("programCode")));
            m.setExpectedSalary(request.getParameter("expectedSalary"));

            db.addData(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(HttpServletRequest request) {
        DataService db = new DataService();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            db.deleteData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(HttpServletRequest request) {
        DataService db = new DataService();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            //Mahasiswa mhs = db.getById(id);
            String sTglLahir = request.getParameter("dateOfBirth");
            Date tglLahir = df.parse(sTglLahir);
            Data m = new Data();
            m.setId(Long.parseLong(request.getParameter("id")));
            m.setName(request.getParameter("name"));
            m.setGender(request.getParameter("gender"));
            m.setPlaceOfBirth(request.getParameter("placeOfBirth"));
            m.setDateOfBirth(tglLahir);
            m.setMaritalstatus(request.getParameter("maritalstatus"));
            m.setReligionCode(Integer.parseInt(request.getParameter("religionCode")));
            m.setCurrentAddress(request.getParameter("currentAddress"));
            m.setEducationCode(Integer.parseInt(request.getParameter("educationCode")));
            m.setGpa(Double.parseDouble(request.getParameter("gpa")));
            m.setProgramCode(Integer.parseInt(request.getParameter("programCode")));
            m.setExpectedSalary(request.getParameter("expectedSalary"));

            db.updateData(m);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void getById(HttpServletRequest request) {
        DataService db = new DataService();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Data mhs = db.getById(id);
            request.setAttribute("Data", mhs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
