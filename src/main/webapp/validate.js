function validateForm() {
            var email = document.getElementById("email").value;
            var phno = document.getElementById("phno").value;
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("password1").value;

            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!email.match(emailPattern)) {
                alert("Invalid email address");
                return false;
            }

            var phnoPattern = /^\d{10}$/;
            if (!phno.match(phnoPattern)) {
                alert("Invalid phone number");
                return false;
            }

            if (password !== confirmPassword) {
                alert("Passwords do not match");
                return false;
            }

            return true;
        }