<%-- 
    Document   : addData
    Created on : 23-Jan-2018, 14:00:53
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Peserta</h1>
        <form action="DataServlet" method="POST">
            Nama : <input type="text" name="name"><br><p></p>
            Gender : <input type="radio" name="gender" value="1" checked> Laki-laki
            <input type="radio" name="gender" value="2"> Perempuan<br>
            Tempat Lahir :  <input type="text" name="placeOfBirth"><br>
            Tanggal Lahir :  <input type="text" name="dateOfBirth"> Format dd/MM/yyyy<br>
            Status Pernikahan : <select name="maritalstatus">
                <option value="B">Belum Menikah</option>
                <option value="M">Menikah</option>
                <option value="X">Duda/Janda</option>
            </select> <br>
            Agama : <select name="religionCode">
                <option value="1">ISLAM</option>
                <option value="2">KATOLIK</option>
                <option value="3">PROTESTAN</option>
                <option value="4">HINDU</option>
                <option value="5">BUDDA</option>
                <option value="6">KONGHUCU</option>
            </select> <br>
            Alamat : <input type="text" name="currentAddress"><br>
            Pendidikan : <select name="educationCode">
                <option value="1">SMU</option>
                <option value="2">S1</option>
                <option value="3">S2</option>
                <option value="4">S3</option>
            </select><br>
            IPK : <input type="text" name="gpa"><br><p>Format 3.00</p>
            Program Pelatihan : <select name="programCode">
                <c:forEach var = "a" items="${pg}">
                <option value="${a.id}">${a.deskripsi}</option>
                </c:forEach>
            </select> <br>
            Gaji yang diharapkan :  <input type="text" name="expectedSalary"><br>
            <input type="hidden" name="action" value="2"><br>
            <input type="submit" value="simpan"><br>
        </form>
    </body>
</html>
