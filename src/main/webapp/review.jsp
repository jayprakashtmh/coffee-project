<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <%@include file="nav.jsp"%>
    
    <section class="review" id="review">
        <h1 class="heading">customer's <span>review</span></h1>

        <div class="box-container">
            <div class="box">
                <img src="img/quote-img.png" alt="">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore ab quas, facilis reiciendis nostrum facere sint quia rem placeat perspiciatis quo consequatur dolore repellendus veniam fugit tenetur similique eius! Cupiditate.</p>
                <img src="img/pic (1).jpg" class="user" alt="">
                <h3>Rekha</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
            </div>
            <div class="box">
                <img src="img/quote-img.png" alt="">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore ab quas, facilis reiciendis nostrum facere sint quia rem placeat perspiciatis quo consequatur dolore repellendus veniam fugit tenetur similique eius! Cupiditate.</p>
                <img src="img/pic (2).jpg" class="user" alt="">
                <h3>Akshay Kumar</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
            </div>
            <div class="box">
                <img src="img/quote-img.png" alt="">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore ab quas, facilis reiciendis nostrum facere sint quia rem placeat perspiciatis quo consequatur dolore repellendus veniam fugit tenetur similique eius! Cupiditate.</p>
                <img src="img/pic (3).jpg" class="user" alt="">
                <h3>Madhuri Dixit</h3>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                </div>
            </div>
        </div>
    </section>

    <script src="style.js"></script>
</body>
</html>