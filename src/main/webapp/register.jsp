
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/loginPageCSS.css">
    <link rel="stylesheet" href="CSS/Navbar.css">

    <title>Bidit - Login</title>
</head>
<body>
<div>
    <jsp:include page="component/NavBar2.jsp"></jsp:include>
</div>
    <div class="Middle_break"></div>

    <div class="registerSide">
        <form name="registerform" method="get" action="register">
            <div class="form_body">
                <div class="left">
                    <div class="form_header">Register</div>

                    <a href="login.jsp" style="font-size: 1.5vw">Already got an account?</a><br>
                <label>
                    User Name:
                    <input type="text" name="userName" placeholder="enter user name" required>
                </label>
                <br>
                <label>
                    First Name:
                    <input type="text" name="fname" placeholder="enter first name" required>
                </label>
                <br>
                <label>
                    Last Name:
                    <input type="text" name="lname" placeholder="enter last name" required>
                </label>
                <br>
                <label>
                    Date of Birth:
                    <input type="date" name="dob">
                </label>
                <br>
                <label>
                    Phone number:
                    <input type="text" name="phone" placeholder="enter phone number" required>
                </label>
                <br>
                <label>
                    Email:
                    <input type="text" name="email" placeholder="enter a valid email" required>
                </label>
                <br>
                <label>
                    Password:
                    <input type="password" name="password" placeholder="enter password" required>
                </label>
                    <br><br>
                    <button type="submit" class="submit_button"><b>Register</b></button>
                    <br>
                    <button type="reset" class="reset_button"><b>Reset</b></button>
                </div>
                <div class="right">
                    <h2 style="color: firebrick; font-size: 2.5vw">Banking Information:</h2>
                    <label>Bank account number(00000):
                    <input type="number" min="0" max="99999" name="accountNum">
                    </label>
                    <br>
                    <label>Bank transit num(000):
                        <input type="number" min="0" max="99999" name="branchNum">
                    </label>
                    <br>
                    <label>Bank branch num (00000):
                        <input type="number" min="0" max="999" name="transitNum">
                    </label>
                    <br>
                    <h2 style="color: firebrick; font-size: 2.5vw"> Address Information:</h2>
                    <label>House Number:
                        <input type="number" min="0" max="99999" name="houseNum">
                    </label>
                    <br>
                    <label>Street Name:
                        <input type="text" name="streetName" placeholder="Enter street Name">
                    </label>
                    <br>
                    <label>Cite Name:
                        <input type="text" name="city" placeholder="Enter city">
                    </label>
                    <br>
                    <label>Postal code:
                        <input type="text" name="postalcode" placeholder="Enter postal code">
                    </label>
                    <br>
                    <label>Province:
                        <input type="text" name="province" placeholder="Enter province">
                    </label>
                    <br>
                    <label>Country:
                        <input type="text" name="courty" placeholder="Enter country">
                    </label>
                    <br>

                </div>
            </div>

        </form>

    </div>
</div>
</body>
</html>
