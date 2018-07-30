<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Stock Search</title>
</head>
<body>


Stock Search<br>

<P></P>

<form name="myform" action="servlets/StockSearchServlet/" method="post">
    What stock would you like to search for?
    <select name="symbol" title="symbol">
        <option value="AAPL">AAPL</option>
        <option value="AGTK">AGTK</option>
        <option value="AKAM">AKAM</option>
        <option value="AOL">AOL</option>
        <option value="BCOM">BCOM</option>
        <option value="BCOR">BCOR</option>
        <option value="BIDU">BIDU</option>
        <option value="CARB">CARB</option>
        <option value="CCIH">CCIH</option>
        <option value="CHIC">CHIC</option>
        <option value="CNV">CNV</option>
        <option value="CXDO">CXDO</option>
        <option value="EDXC">EDXC</option>
        <option value="FB">FB</option>
        <option value="GOOG">GOOG</option>
        <option value="IACI">IACI</option>
        <option value="INAP">INAP</option>
        <option value="JCOM">JCOM</option>
        <option value="LOOK">LOOK</option>
        <option value="MEET">MEET</option>
        <option value="MOMO">MOMO</option>
        <option value="NTES">NTES</option>
        <option value="NQ">NQ</option>
        <option value="OTOW">OTOW</option>
        <option value="VNET">VNET</option>
        <option value="WIFI">WIFI</option>
    </select>
    <br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>
</body>
</html>
