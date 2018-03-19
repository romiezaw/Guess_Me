<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="ajax.js"></script>
<title>Guess Me</title>

</head>
<body bgcolor="#eeeeee">
 	<div class="container">
 		 <h2 >Guess Me </h2><br>
 			
 			<div id="winner"></div>
 		 
		 	<div class="panel panel-primary">
		 	
				<input type="text" min="0" 
							step="1" 
							name="guessMe" 
							maxlength="4" 
							class="form-control" 
							id="guessMe"
							placeholder="Enter 4 digits" 
							pattern = "^([\d])((?!\1)[\d])(?!\2)((?!\1)[\d])(?!\3)(?!\2)((?!\1)[\d])$"
							required
			    /> 
			 </div><br>
			<button
                    type="submit"
                    id="btnSubmit"
                    class="btn btn-primary">
                    Submit
                </button>			
		  &nbsp;
			<button
                    type="Reset"
                    id="btnReset"
                    class="btn btn-primary">
                    Reset
                </button>
            <br><br>
		<br> <div  class="form-group" id="dataDiv"></div>
		
		
		
<!-- 
	<c:if test = "${not empty guessMap}">
		<table class="table table-striped">
			<thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">You Entered</th>
		      <th scope="col">(Matching Digit , Matching Position)</th>
		    </tr>
		  </thead>
			<c:forEach var="checker" items="${guessMap}">
				<tr>
					<th scope="row">1</th>
						<td>${checker.key}</td>
						<td>(${checker.value[0]},${checker.value[1]})</td>
					</th>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</div>
 -->
	</div>
</body>
</html>