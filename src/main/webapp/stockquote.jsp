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
    <select>
        <option name="symbol" title="symbol" value="AAPL">AAPL</option>
        <option name="symbol" title="symbol" value="AGTK">AGTK</option>
        <option name="symbol" title="symbol" value="AKAM">AKAM</option>
        <option name="symbol" title="symbol" value="AOL">AOL</option>
        <option name="symbol" title="symbol" value="BCOM">BCOM</option>
        <option name="symbol" title="symbol" value="BCOR">BCOR</option>
        <option name="symbol" title="symbol" value="BIDU">BIDU</option>
        <option name="symbol" title="symbol" value="CARB">CARB</option>
        <option name="symbol" title="symbol" value="CCIH">CCIH</option>
        <option name="symbol" title="symbol" value="CHIC">CHIC</option>
        <option name="symbol" title="symbol" value="CNV">CNV</option>
        <option name="symbol" title="symbol" value="CXDO">CXDO</option>
        <option name="symbol" title="symbol" value="EDXC">EDXC</option>
        <option name="symbol" title="symbol" value="FB">FB</option>
        <option name="symbol" title="symbol" value="GOOG">GOOG</option>
        <option name="symbol" title="symbol" value="IACI">IACI</option>
        <option name="symbol" title="symbol" value="INAP">INAP</option>
        <option name="symbol" title="symbol" value="JCOM">JCOM</option>
        <option name="symbol" title="symbol" value="LOOK">LOOK</option>
        <option name="symbol" title="symbol" value="MEET">MEET</option>
        <option name="symbol" title="symbol" value="MOMO">MOMO</option>
        <option name="symbol" title="symbol" value="NTES">NTES</option>
        <option name="symbol" title="symbol" value="NQ">NQ</option>
        <option name="symbol" title="symbol" value="OTOW">OTOW</option>
        <option name="symbol" title="symbol" value="VNET">VNET</option>
        <option name="symbol" title="symbol" value="WIFI">WIFI</option>
    </select>
    <br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>
</body>
</html>
