<%-- 
    Document   : update
    Created on : 23-Jan-2018, 17:34:57
    Author     : user
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data</title>
    </head>
    <body>
        <h1>Update Data</h1>

        <form action="DataServlet" method="POST">
            id : ${Data.id} <br/>
            <input type="hidden" name="id" value="${Data.id}">
            Nama : <input type="text" name="name" value="${Data.name}" /> <br/>
            Gender :
            <INPUT TYPE="radio" NAME="gender" VALUE="1" <c:if test="${Data.gender.equalsIgnoreCase('1')}">checked</c:if> >
                Laki-laki
                &nbsp;
                <INPUT TYPE="radio" NAME="gender" VALUE="2" <c:if test="${Data.gender.equalsIgnoreCase('2')}">checked</c:if> >
                Perempuan
                <br/>
                Tempat Lahir: <input type="text" name="placeOfBirth" value="${Data.placeOfBirth}"/> <br/>
            Tanggal Lahir : <input type="text" name="dateOfBirth" 
                                   value="<fmt:formatDate pattern 
                                                   = "dd/MM/yyyy" value="${Data.dateOfBirth}"/>"> format : dd/MM/yyyy <br/>
            Status Pernikahan: 
            <SELECT NAME="maritalstatus" SIZE="1">
                <OPTION value="B" <c:if test="${Data.maritalstatus.equalsIgnoreCase('B')}">selected</c:if>>Belum menikah</OPTION>
                <OPTION value="M" <c:if test="${Data.maritalstatus.equalsIgnoreCase('M')}">selected</c:if>>Menikah</OPTION>
                <OPTION value="X" <c:if test="${Data.maritalstatus.equalsIgnoreCase('X')}">selected</c:if>>Janda / Duda</OPTION>
                </SELECT>
                <br/>
                Agama:
                <SELECT NAME="religionCode" SIZE="1">
                    <OPTION value="1" <c:if test="${Data.religionCode==('1')}">selected</c:if>>Islam</OPTION>
                <OPTION value="2" <c:if test="${Data.religionCode==('2')}">selected</c:if>>Kristen</OPTION>
                <OPTION value="3" <c:if test="${Data.religionCode==('3')}">selected</c:if>>Katolik</OPTION>
                <OPTION value="4" <c:if test="${Data.religionCode==('4')}">selected</c:if>>Hindu</OPTION>
                <OPTION value="5" <c:if test="${Data.religionCode==('5')}">selected</c:if>>Budha</OPTION>
                <OPTION value="6" <c:if test="${Data.religionCode==('6')}">selected</c:if>>Konghucu</OPTION>
                </SELECT>
                <br/>
                Alamat:  <input type="text" name="currentAddress" value="${Data.currentAddress}"/> <br/>
            Pendidikan: 
            <SELECT NAME="educationCode" SIZE="1">
                <OPTION value="1" <c:if test="${Data.educationCode == ('1')}">selected</c:if>>SMU</OPTION>
                <OPTION value="2" <c:if test="${Data.educationCode ==('2')}">selected</c:if>>S1</OPTION>
                <OPTION value="3" <c:if test="${Data.educationCode ==('3')}">selected</c:if>>S2</OPTION>
                <OPTION value="4" <c:if test="${Data.educationCode == ('4')}">selected</c:if>>S3</OPTION>
                </SELECT>
                <br/>
                IPK: <input type="text" name="gpa" value="${Data.gpa}"/><br/>
            Program Pelatihan: 
            <SELECT NAME="programCode" SIZE="1">
                <OPTION value="1" <c:if test="${Data.programCode ==('1')}">selected</c:if>>Java</OPTION>
                <OPTION value="2" <c:if test="${Data.programCode ==('2')}">selected</c:if>>.Net</OPTION>
                </SELECT>
                <br/>
                Gaji yang diharapkan: <input type="text" name="expectedSalary" value="${Data.expectedSalary}"/>
            <input type="hidden" name="action" value="5"/>
            <input type="submit" value="Update" /> <br/>
        </form>
    </body>
</html>