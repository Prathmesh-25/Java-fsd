$(document).ready(function () {
    // Form submission handling
    $("#contactForm").submit(function (event) {
        event.preventDefault(); // Prevent the default form submission

        // Simple form validation
        var name = $("#name").val();
        var email = $("#email").val();
        var message = $("#message").val();

        if (name === "" || email === "" || message === "") {
            alert("Please fill in all fields.");
            return;
        }

        // You can add additional validation or AJAX submission here
        // For now, just showing a success message
        alert("Form submitted successfully!");
    });

    // Triggering a modal
    $("#showModalBtn").click(function () {
        $("#myModal").modal("show");
    });
});
