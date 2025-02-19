let logoutTimer;

function resetLogoutTimer() {
    clearTimeout(logoutTimer); // Clears the previous timer

    logoutTimer = setTimeout(() => {
        console.log("User has been logged out due to inactivity.");
        alert("Session expired. You have been logged out.");
        
        // Here you could redirect to the login page
        window.location.href = "/login";
    }, 5 * 60 * 1000); // 5 minutes
}

// Event listeners to detect user activity
document.addEventListener("mousemove", resetLogoutTimer);
document.addEventListener("keypress", resetLogoutTimer);
document.addEventListener("click", resetLogoutTimer);

// Start the timer when the page loads
resetLogoutTimer();
