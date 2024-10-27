<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.admin.content.blog.Blog, java.util.*, java.text.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Blog</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<section class="blogs" id="blogs">
		<h1 class="heading">
			our <span>blogs</span>
		</h1>
		<div class="box-container">
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Blog> alb = (ArrayList<Blog>) request.getAttribute("blog");
			Iterator<Blog> it = alb.iterator();
			while (it.hasNext()) {
				Blog b1 = it.next();
				String path = "./blog_img/" + b1.getPic_url();
			%>
			<div class="box">
				<div class="image">
					<img src=<%=path%> alt="">
				</div>
				<div class="content">
					<a href="" class="title"><%=b1.getName()%></a> <span>by admin
						/ <%=fD(b1.getDate())%></span>
					<p><%=b1.getDesc()%></p>
					<a href="#" class="btn">read more</a>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</section>

	<%!public static String fD(Date date) {

		java.util.Date utilDate = new Date(date.getTime());

		// Extract day, month, and year from the date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		String month = monthFormat.format(date);

		// Determine the correct suffix
		String suffix = getDayNumberSuffix(day);

		// Return the formatted date string
		return String.format("%d%s %s, %d", day, suffix, month, year);
	}

	private static String getDayNumberSuffix(int day) {
		if (day >= 11 && day <= 13) {
			return "th";
		}
		switch (day % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}%>
	%>


    <script src="style.js"></script>
</body>
</html>