<%-- 
    Document   : index
    Created on : 23-Jan-2018, 10:45:11
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Peserta</h1>
        
        <form action="DataServlet">
            Cari :
            <input type="text" name="cari" value="${param.cari}">
            <input type="submit" value="Cari">
            
        </form> 
<a href="addData.jsp;">Tambah Data</a>
        <p></p>
        
        <a href="DataServlet?action=6">Add Peserta</a><br/>

        <table border=1 cellpadding=3 cellspacing=0 >
            <td>Code</td>
            <td>Name</td>
            <td>Gender</td>
            <td>Placeofbirth</td>
            <td>DateOfBirth</td>
            <td>MaritalStatus</td>
            <td>ReligionCode</td>
            <td>CurrentAddress</td>     
            <td>EducationCode</td>
            <td>Gpa</td>
            <td>ProgramCode</td>
            <td>ExpectedSalery</td>
            <td>Edit</td>
        </tr>

        <c:forEach var="p" items="${mhs}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${p.gender=='1'}">
                            Laki-laki
                            <br />
                        </c:when>
                        <c:when test="${p.gender=='2'}">
                            Perempuan
                            <br />
                        </c:when>   
                        <c:otherwise>
                            Dipertanyakan 
                            <br />
                        </c:otherwise>
                    </c:choose></td>
                <td>${p.placeOfBirth}</td>
                <td>
                    <fmt:formatDate pattern = "dd/MM/yyyy" value="${p.dateOfBirth}"/>
                </td>
                <td><c:choose>
                        <c:when test="${p.maritalstatus=='M'}">
                            Menikah
                            <br />
                        </c:when>
                        <c:when test="${p.maritalstatus=='B'}">
                            Belum Menikah
                            <br />
                        </c:when>   
                        <c:otherwise>
                            Janda/Duda 
                            <br />
                        </c:otherwise>
                    </c:choose></td>
                <td><c:choose>
                        <c:when test="${p.religionCode=='1'}">
                            Islam
                            <br />
                        </c:when>
                        <c:when test="${p.religionCode=='2'}">
                            Katolik
                            <br />
                        </c:when>
                        <c:when test="${p.religionCode=='3'}">
                            Protestan
                            <br />
                        </c:when>
                        <c:when test="${p.religionCode=='4'}">
                            Hindu
                            <br />
                        </c:when>
                        <c:when test="${p.religionCode=='5'}">
                            Buddha
                            <br />
                        </c:when>   
                        <c:otherwise>
                            Konghucu 
                            <br />
                        </c:otherwise>
                    </c:choose></td>
                <td>${p.currentAddress}</td>
                <td><c:choose>
                        <c:when test="${p.educationCode=='1'}">
                            SMU
                            <br />
                        </c:when>
                        <c:when test="${p.educationCode=='2'}">
                            S1
                            <br />
                        </c:when>
                        <c:when test="${p.educationCode=='3'}">
                            S2
                            <br />
                        </c:when><c:otherwise>
                            S3 
                            <br />
                        </c:otherwise>
                    </c:choose></td>
                <td>${p.gpa}</td>
                <td>
                    <c:choose>
                        <c:when test="${p.programCode=='1'}">
                            JAVA
                            <br />
                        </c:when>
                        <c:when test="${p.programCode=='2'}">
                            .NET
                            <br />
                        </c:when>   
                    </c:choose></td>
                <td>${p.expectedSalary}</td>    
                <td>
                    <a href="DataServlet?action=4&id=${p.id}">Edit</a>
                    <a href="DataServlet?action=3&id=${p.id}" onclick="return confirm('Yakin ingin Hapus???');">Hapus</a>
                </td>
            </tr>
        </c:forEach>
    </table><br>
    <c:forEach var="i" begin="1" end="${total}">
        <a href="DataServlet?page=${i}&cari=${p.cari}">${i}</a>&nbsp;
    </c:forEach>
</body>
</html>