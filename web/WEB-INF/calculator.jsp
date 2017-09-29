<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Calculator</title>
    </head>
    <body>
        <h1>Calculator</h1>
        
        <form action="calcservlet" method="post">
            First: <input type="text" name="first" value =${first}><br/>
            Second: <input type="text" name="second" value = ${second}><br/>
            <input type="submit" name="operation" value="+"> <input type="submit" name="operation" value="-"> 
            <input type="submit" name="operation" value="*"> <input type="submit" name="operation" value="%">
        </form>
        <br/>
            ${result}
              ${error}
    </body>
</html>
