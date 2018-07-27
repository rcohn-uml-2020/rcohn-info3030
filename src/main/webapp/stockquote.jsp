<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mood Survey</title>
</head>
<body>


Stock Search<br>

<P></P>

<form name="myform" action="servlets/StockSearchServlet/" method="post">
    What stock would you like to search for?
    <select>
        <option value="AAPL">AAPL</option>
        <option value="AGTK">AAPL</option>
        <option value="AKAM">AAPL</option>
        <option value="AOL">AAPL</option>
        <option value="BCOM">AAPL</option>
        <option value="BCOR">AAPL</option>
        <option value="BIDU">AAPL</option>
        <option value="CARB">AAPL</option>
        <option value="CCIH">AAPL</option>
        <option value="CHIC">AAPL</option>
        <option value="CNV">AAPL</option>
        <option value="CXDO">AAPL</option>
        <option value="EDXC">AAPL</option>
        <option value="FB">AAPL</option>
        <option value="GOOG">AAPL</option>
        <option value="IACI">AAPL</option>
        <option value="INAP">AAPL</option>
        <option value="JCOM">AAPL</option>
        <option value="LOOK">AAPL</option>
        <option value="MEET">AAPL</option>
        <option value="MOMO">AAPL</option>
        <option value="NTES">AAPL</option>
        <option value="NQ">AAPL</option>
        <option value="OTOW">AAPL</option>
        <option value="VNET">AAPL</option>
        <option value="WIFI">AAPL</option>
    </select>
    <br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>
</body>
</html>
