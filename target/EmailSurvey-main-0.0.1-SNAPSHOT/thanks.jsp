<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <img src="images/murachlogo.jpg" alt="Murach Logo">
    <h1>Thanks for joining our survey</h1>

    <h2>Your information:</h2>
    <p>First Name: ${user.firstName}</p>
    <p>Last Name: ${user.lastName}</p>
    <p>Email: ${user.email}</p>
    <p>Date of Birth: ${user.dob}</p>
    <p>Heard From: ${user.heardFrom}</p>
    <p>Wants Updates: ${user.wantsUpdates}</p>
    <p>Email Announcements: ${user.emailOK}</p>
    <p>Contact Via: ${user.contactVia}</p>
</body>
</html>
